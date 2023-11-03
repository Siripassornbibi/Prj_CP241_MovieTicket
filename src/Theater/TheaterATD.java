package Theater;

import java.util.HashMap;

public interface TheaterATD {
    public void setRow(int row);
    public void setColumn(int column);
    public void setTheater();
    public int getColumn();
    public int getRow();
    public HashMap getDataTheater();
    public void reserve(int numSeat,int price);

}
