package um.edu.mt.cps2002;
import java.math.*;

/**
 * Created by stefan on 4/13/17.
 */
public class Player {
    Position position;
    //Position initialPosition;
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
                break;// randomly selects starting position
            }

        }
    }


    public void move(Direction direction,Map map) throws IndexOutOfBoundsException
    {
        switch(direction){
            case UP:
                position.column--;

                break;
            case DOWN:
                position.column++;
                break;
            case LEFT:
                position.row--;
                break;
            case RIGHT:
                position.row++;
                break;


        }
        if(position.row>=map.size || position.column>=map.size)
            throw new IndexOutOfBoundsException();
        else mapKnowledge[position.column][position.row] = map.tileColours[position.column][position.row];
    }

    public void setPosition(Position position)
    {
        this.position = position;
       // mapKnowledge[position.column][position.row] = map.tileColours[position.column][position.row];
    }


}
