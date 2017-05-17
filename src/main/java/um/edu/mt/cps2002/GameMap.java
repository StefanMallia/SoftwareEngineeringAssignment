package um.edu.mt.cps2002;

public abstract class GameMap
{
    int size;
    Position treasure;
    Colour[][] tileColours;
    public static int instance_num = 0;

    public GameMap(){}


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

    public abstract void generate();


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
