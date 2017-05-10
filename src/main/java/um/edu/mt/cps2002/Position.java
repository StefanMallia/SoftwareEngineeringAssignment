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

    public boolean equals(int r, int c)
    {
        if ( row == r && column == c)
            return true;
        else
            return false;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Position position = (Position) o;

        if (row != position.row) return false;
        return column == position.column;

    }

    @Override
    public int hashCode() {
        int result = row;
        result = 31 * result + column;
        return result;
    }
}
