package Theater;

import DataStructure.DoubleHashingHashMap;
import Movie.Movie1;
import Movie.MovieInfo;
import Seat.*;

public class Theater{
    private int row,column;
    private Object movieInfo;
    private String Theater_Name;

    DoubleHashingHashMap<Integer, Seat> DataSeat;

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

    public Theater(Object movieInfo) {
        if (movieInfo != null) {
            //Set Theater name
            setTheater_Name("Theatre XX");

            this.movieInfo = movieInfo;

            //Set size of the Theater
            setRow(5);
            setColumn(10);

            DataSeat = new DoubleHashingHashMap<>();
            //type seat
            String[] allSeatType = {"StandardSeat 12","PremiumSeat 345"};
            setTheater(allSeatType);
            //System.out.print(DataSeat);
        } else {
            // จัดการกรณีที่ movieInfo เป็น null
            System.out.println("Error: movieInfo is null");
        }
    }

    //create detail of theater here
    public void setTheater(String allSeatType[]){
        int start;
        char lastCurrentChar = (char) ('A' + (this.getRow()-1));

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
                    for (int i = start; i <= column * r; i++){
                        Seat s = new StandardSeat(i);
                        s.setColum(i-((r-1)*column));
                        s.setRow(String.valueOf(lastCurrentChar));
                        DataSeat.put(i,s);
                    }
                    lastCurrentChar = (char) (lastCurrentChar-1);
                }
            } else if (eachData[0].equals("PremiumSeat")) {
                for (int r : row){
                    start = ((r - 1) * column) + 1;
                    for (int i = start; i <= column * r; i++){
                        Seat s = new PremiumSeat(i);
                        s.setColum(i - ((r-1) * column) );
                        s.setRow(String.valueOf(lastCurrentChar));
                        DataSeat.put(i,s);
                    }
                    lastCurrentChar = (char) (lastCurrentChar-1);
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

    public void setMovieInfo(Object movieInfo){
        this.movieInfo = movieInfo;
    }

    public void setTheater_Name(String theaterName){
        this.Theater_Name = theaterName;
    }

    //accessor
    public String getTheaterName(){
        return Theater_Name;
    }
    public int getColumn() {
        return column;
    }

    public int getRow() {
        return row;
    }

    public int getTotalSeat() {
        return row*column;
    }

    public Object getMovieInfo(){
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
