package um.edu.mt.cps2002;

public class Map
{
    int size;
    Colour[][] tileColours;

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
                r = ((int) (Math.random()%2)+1);

                switch(r){
                    case 1:
                        tileColours[i][j] = Colour.GREEN;
                        break;
                    default:
                        tileColours[i][j] = Colour.BLUE;


                }
            }


        }

        int I =  (int) Math.random()%size;
        int J = (int) Math.random()%size;

        tileColours[I][J] = Colour.YELLOW;


    }

    public Colour getTileType(int row, int column)
    {

        return  tileColours[row][column];
    }

}
