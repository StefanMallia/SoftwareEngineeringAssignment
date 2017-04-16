package um.edu.mt.cps2002;

/**
 * Created by stefan on 4/13/17.
 */
public class Position {
    int row;
    int column;

    Position(Position position)
    {
        this.row = position.row;
        this.column = position.column;
    }
    Position(int row, int column)
    {
        this.row = row;
        this.column = column;
    }
    /*
    public boolean equals(Position otherPosition)
    {
        if ( row == otherPosition.row && column == otherPosition.column)
            return true;
        else
            return false;
    }
    */
    public boolean equals(int r, int c)
    {
        if ( row == r && column == c)
            return true;
        else
            return false;
    }
}
