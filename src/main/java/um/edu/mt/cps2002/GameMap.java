package um.edu.mt.cps2002;

public class GameMap
{
    int size;
    Position treasure;
    Colour[][] tileColours;
    public static GameMap instance = null;

    public GameMap(){}

    public static GameMap getInstance() {
        if (instance == null) {
            instance = new GameMap();
            return instance;
        }
        else {
            return null;
        }
    }
    /*
    public GameMap(int size,int players) throws Exception{
        setMapSize(size,players);
        generate();
    }*/

    public boolean setMapSize(int size, int players)
    {
        if(size<5) return false;
        else if(size>50) return false;
        else if(size<8 && players>4) return false;
        else{
            this.size = size;
            tileColours = new Colour[size][size];
            return true;
        }


    }

    public void generate()
    {
        int r;

        for(int i=0;i<size;i++){
            for(int j=0;j<size;j++){
                r = (int) Math.floor(Math.random()*2); //1 in 2 chance of case 1 for GREEN

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


                }
            }


        }

        int I =  (int) Math.floor(Math.random()*size);
        int J = (int) Math.floor(Math.random()*size);

        tileColours[I][J] = Colour.YELLOW;
        treasure = new Position(I,J);

    }

    public Colour getTileType(int row, int column) throws IndexOutOfBoundsException
    {
        if(row>=size || column >= size)
            throw new IndexOutOfBoundsException();
        else return  tileColours[row][column];
    }

    public Colour getTileType(Position position)
    {
        if(position.row>=size || position.column >= size)
            throw new IndexOutOfBoundsException();
        else return  tileColours[position.row][position.column];
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

}
