package Theater;

import DataStructure.DoubleHashingHashMap;
import Movie.MovieInfo;
import Seat.*;

public class Theater{
    private int row,column;
    private MovieInfo movieInfo = new MovieInfo();

    private DoubleHashingHashMap<Integer, Seat> DataSeat;

    public Theater(){
        //Set size of the Theater
        setRow(5);
        setColumn(10);

        DataSeat = new DoubleHashingHashMap<>();
        //type seat
        String[] allSeatType = {"StandardSeat 12","PremiumSeat 345"};
        setTheater(allSeatType);
        //System.out.print(DataSeat);
    }

    //create detail of theater here
    public void setTheater(String allSeatType[]){
        int start;
        for(String seatTypeData : allSeatType){
            //eachData[0] = type , eachData[1] = row = 12
            String[] eachData = seatTypeData.split(" ");

            //change type of row to int
            char[] rows = eachData[1].toCharArray();
            Integer[] row = new Integer[rows.length];
            for (int i = 0; i < rows.length; i++) {
                row[i] = Character.getNumericValue(rows[i]);
            }

            //สร้าง seat แต่ละแถว
            if(eachData[0].equals("StandardSeat")){
                for (int r : row){
                    start = ((r - 1) * column) + 1;
                    for (int i = start;i<=column*r;i++){
                        DataSeat.put(i,new StandardSeat(i));
                    }
                }
            } else if (eachData[0].equals("PremiumSeat")) {
                for (int r : row){
                    start = ((r - 1) * column) + 1;
                    for (int i = start;i<=column*r;i++){
                        DataSeat.put(i,new PremiumSeat(i));
                    }
                }
            }

        }
    }



    //mutator
    public void setRow(int row) {
        this.row = row;
    }

    public void setColumn(int column) {
        this.column = column;
    }

    //accessor
    public int getColumn() {
        return column;
    }

    public int getRow() {
        return row;
    }

    public int getTotalSeat() {
        return row*column;
    }

    public MovieInfo getMovieInfo(){
        return movieInfo;
    }

    public DoubleHashingHashMap getDataTheater() {
        return DataSeat;
    }

    public Seat getCurrentDataSeat(int numSeat){
        return DataSeat.get(numSeat);
    }


    //reservation
    public void reserve(int row,int column) {
        int numSeat = ((row-1)*this.column)+column;
        getCurrentDataSeat(numSeat).setReserveStatus(true);
    }

    public void cancelReservation(int row,int column){
        int numSeat = ((row-1)*this.column)+column;
        getCurrentDataSeat(numSeat).setReserveStatus(false);
    }
}
