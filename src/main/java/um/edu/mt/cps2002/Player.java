package um.edu.mt.cps2002;
import java.math.*;

/**
 * Created by stefan on 4/13/17.
 */
public class Player {
    Position position;
    Position initialPosition;
    Colour[][] mapKnowledge;


    public Player(Colour[][] map){
        mapKnowledge = new Colour[map.length][map.length];

        for(int i=0;i<map.length;i++){
            for(int j=0;j<map.length;j++){
                mapKnowledge[i][j]=Colour.GREY;
            }
        }

        while(true) {
            int I = (int) Math.floor(Math.random()*map.length);
            int J = (int) Math.floor(Math.random()*map.length);

            if(map[I][J]==Colour.GREEN){
                mapKnowledge[I][J] = Colour.GREEN;
                position = new Position(I,J);
                initialPosition = new Position(position);
                break;// randomly selects starting position
            }

        }
    }


    public boolean move(Direction direction, Map map)
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
        if(position.row>=map.size || position.column>=map.size) {
            position = previousPosition;
            return false;
        }
        else if(position.row < 0 || position.column < 0) {
            position = previousPosition;
            return false;
        }
        mapKnowledge[position.row][position.column] = map.tileColours[position.row][position.column];
        return true;
    }

    public void setPosition(Position position, Map map)
    {
        this.position = position;
        mapKnowledge[position.row][position.column] = map.tileColours[position.row][position.column];
    }


}
