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
            int I = (int) Math.random() % map.length;
            int J = (int) Math.random() % map.length;

            if(map[J][I]==Colour.GREEN){
                mapKnowledge[J][I] = Colour.GREEN;
                position = new Position(J,I);
                break;// randomly selects starting position
            }

        }
    }


    public void move(Direction direction,Map map) throws Exception
    {
        switch(direction){
            case UP:
                position.row++;

                break;
            case DOWN:
                position.row--;
                break;
            case LEFT:
                position.column--;
                break;
            case RIGHT:
                position.column++;
                break;


        }
        if(position.row>map.size || position.column>map.size)
            throw new Exception("Out of Bounds");

        mapKnowledge[position.column][position.row] = map.tileColours[position.column][position.row];
    }

    public void setPosition(Position position)
    {
        this.position = position;
    }


}
