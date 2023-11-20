package Theater;

import DataStructure.DoubleHashingHashMap;
import Seat.Seat;

import java.util.HashMap;

public class Theater implements TheaterADT{
    private int row,column;
    private DoubleHashingHashMap<Integer, Seat> DataSeat;

    public Theater(int row, int column){
        setRow(row);
        setColumn(column);
        DataSeat = new DoubleHashingHashMap<>();
        setTheater();
        //System.out.print(DataSeat);
    }
    public void setTheater(){
        for(int i = 1; i <= this.row*this.column; i++){
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
    public DoubleHashingHashMap getDataTheater() {
        return DataSeat;
    }

    @Override
    public void reserve(int numSeat,int price) {
        Seat rs = new Seat(numSeat,price);
        DataSeat.replace(numSeat,rs);
    }

    public void cancelReservation(int numSeat){
        DataSeat.replace(numSeat,null);
    }
}
