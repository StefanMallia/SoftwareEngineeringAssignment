package um.edu.mt.cps2002;

public class Map
{
    int size;
    Colour[][] tileColours;
    public boolean setMapSize(int size, int players)
    {
        return true;
    }
    public void generate()
    {

    }
    public Colour getTileType(int row, int column)
    {
        return Colour.GREEN;
    }

}
