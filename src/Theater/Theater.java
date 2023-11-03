package Theater;

import Seat.Seat;
import Ticket.Ticket;

import java.util.HashMap;

public class Theater implements TheaterATD{
    private int row,column;
    private HashMap<Integer, Seat> DataSeat;

    public Theater(int row, int column){
        setRow(row);
        setColumn(column);
        DataSeat = new HashMap<>(row*column);
        setTheater();
        //System.out.print(DataSeat);
    }
    public void setTheater(){
        for(int i = 0; i < this.row*this.column; i++){
            DataSeat.put(i,null);
        }
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

    @Override
    public HashMap getDataTheater() {
        return DataSeat;
    }

    @Override
    public void reserve(int numSeat,int price) {
        Seat rs = new Seat(numSeat,price);
        DataSeat.replace(numSeat,rs);
    }
}
