package Theater;

public class TheaterA implements TheaterATD{
    private int row,column;

    public TheaterA(int row, int column){
        setRow(row);
        setColumn(column);
    }

    @Override
    public void setRow(int row) {
        this.row = row;
    }

    @Override
    public void setColumn(int column) {
        this.column = column;
    }
    public int getColumn() {
        return column;
    }

    @Override
    public int getRow() {
        return row;
    }
}
