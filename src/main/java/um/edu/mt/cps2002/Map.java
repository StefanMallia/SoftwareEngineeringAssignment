package um.edu.mt.cps2002;

public class Map
{
    int size;
    Position treasure;
    Colour[][] tileColours;

    public Map(){
        //do not use in implementation; used only to test setMapSize and generate functions seperately
    }
    /*
    public Map(int size,int players) throws Exception{
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
                r = (int) Math.ceil(Math.random()*2);

                switch(r){
                    case 1:
                        tileColours[i][j] = Colour.GREEN;
                        break;
                    default:
                        tileColours[i][j] = Colour.BLUE;


                }
            }


        }

        int I =  (int) Math.ceil(Math.random()*size);
        int J = (int) Math.ceil(Math.random()*size);

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

}
