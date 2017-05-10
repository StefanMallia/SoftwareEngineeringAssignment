package um.edu.mt.cps2002;
import java.util.HashMap;

/**
 * Created by stefan on 4/13/17.
 */
public class Player {
    Position position;
    Position initialPosition;
    HashMap<Position, Colour> mapKnowledge; //if position not mapped then the area is grey


    public Player(GameMap gameMap){
        mapKnowledge = new HashMap<Position, Colour>();

        while(true) {
            int I = (int) Math.floor(Math.random()*gameMap.size);
            int J = (int) Math.floor(Math.random()*gameMap.size);

            if(gameMap.tileColours[I][J]==Colour.GREEN){
                position = new Position(I,J);
                setTileKnowledge(position, gameMap);
                initialPosition = new Position(position);
                break;// randomly selects starting position
            }

        }
    }


    public boolean move(Direction direction, GameMap gameMap)
    {
        Position previousPosition = new Position(position);
        switch(direction){
            case UP:
                position.row--;
                break;
            case DOWN:
                position.row++;
                break;
            case LEFT:
                position.column--;
                break;
            case RIGHT:
                position.column++;
                break;
        }
        if(position.row>= gameMap.size || position.column>= gameMap.size) {
            position = previousPosition;
            return false;
        }
        else if(position.row < 0 || position.column < 0) {
            position = previousPosition;
            return false;
        }
        setTileKnowledge(position, gameMap);
        return true;
    }

    public void setPosition(Position position, GameMap gameMap)
    {
        this.position = position;
        setTileKnowledge(position, gameMap);
    }

    public void setTileKnowledge(Position position, GameMap gameMap) {
        mapKnowledge.put(new Position(position), gameMap.getTileType(position));
    }
    public void setTileKnowledge(Position position, Colour colour) {
        mapKnowledge.put(new Position(position), colour);
    }

    public Colour getTileKnowledge(Position position) {
        if (mapKnowledge.containsKey(position)) {
            return mapKnowledge.get(position);
        }
        else {
            return Colour.GREY;
        }
    }
}
