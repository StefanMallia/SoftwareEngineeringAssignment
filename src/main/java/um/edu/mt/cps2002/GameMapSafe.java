package um.edu.mt.cps2002;

/**
 * Created by tim on 11/05/2017.
 */
public class GameMapSafe extends GameMap {

    GameMapSafe(){}

    private Colour generateTile(){
        Colour ret = Colour.BLUE;
        double mapProp = mapProportion();

        if(mapProp<0.1 && Math.random()<=0.1)
            ret = Colour.BLUE;
        else
            ret = Colour.GREEN;



        return ret;

    }

    public double mapProportion(){
        double total = (double) size*size;
        int bluecount=0;

        for(int i=0;i<size;i++){
            for(int j=0;j<size;j++){
                if(tileColours[i][j]==Colour.BLUE)
                    bluecount++;
            }
        }

        return ((double) bluecount)/total;

    }

    public void generate()
    {
        //int r;

        for(int i=0;i<size;i++){
            for(int j=0;j<size;j++){
                tileColours[i][j] = generateTile();

                /*r = (int) Math.floor(Math.random()*2); //1 in 2 chance of case 1 for GREEN
                   switch(r){
                    case 1:
                        tileColours[i][j] = Colour.GREEN;
                        break;
                    default:
                        //checking to make sure that neighboring tiles are not blue
                        //this is a simple solution to making sure a path always exists to the treasure
                        boolean one_neighboring_blue = false;
                        for (int n = i-1; n <= i+1; n++) {
                            for (int m = j - 1; m <= j + 1; m++) {
                                //skip when out of bounds index and when (n, m) == (i, j)
                                if (n != -1 && n != size && m != -1 && m != size && !(n == i && m == j)) {
                                    if (tileColours[n][m] == Colour.BLUE) {
                                        tileColours[i][j] = Colour.GREEN;
                                        one_neighboring_blue = true;
                                        break;
                                    }
                                }
                            }
                            if (one_neighboring_blue)
                                break;
                        }
                        if (!one_neighboring_blue)
                            tileColours[i][j] = Colour.BLUE;


                }*/
            }


        }

        int I =  (int) Math.floor(Math.random()*size);
        int J = (int) Math.floor(Math.random()*size);

        tileColours[I][J] = Colour.YELLOW;
        treasure = new Position(I,J);

    }

}
