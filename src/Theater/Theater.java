package Theater;

import DataStructure.DoubleHashingHashMap;
import Movie.Movie1;
import Movie.MovieInfo;
import Seat.*;

import java.io.*;
import java.util.Map;

public class Theater implements Serializable{
    private int row,column;
    private Object movieInfo;
    private String Theater_Name;

    DoubleHashingHashMap<Integer, Seat> DataSeat;

    String[] allSeatType;

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
            setAllSeatType(new String[]{"StandardSeat 12", "PremiumSeat 345"});
            //System.out.print(DataSeat);
        } else {
            // จัดการกรณีที่ movieInfo เป็น null
            System.out.println("Error: movieInfo is null");
        }
    }

    public Theater() {
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

    // Serialize data to a file
    public void saveDataTheater(){
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("dataSeat.ser"))) {
            oos.writeObject(DataSeat);
            System.out.println("Data saved successfully.");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    // Deserialize data from a file
    public void loadDataTheater(){
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream("dataSeat.ser"))) {
            DataSeat = (DoubleHashingHashMap<Integer, Seat>) ois.readObject();
            System.out.println("DataSeat loaded successfully.");
        } catch (IOException | ClassNotFoundException e) {
            System.out.println("Failed to load DataSeat. Initializing a new one.");
            e.printStackTrace();
            DataSeat = new DoubleHashingHashMap<>();
            // เพิ่มโค้ดเพื่อกำหนดค่าเริ่มต้นหรือปรับปรุงตามความเหมาะสม
            setTheater(allSeatType);
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

    public void setAllSeatType(String allSeatType[]){
        this.allSeatType = allSeatType;
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



    //reservation จริงๆ setStatus จากเก้าแี้เลยสะดวกกว่า
    public void reserve(int row,int column) {
        int numSeat = ((row-1)*this.column)+column;
        getCurrentDataSeat(numSeat).setReserveStatus(true);
    }

    public void cancelReservation(int row,int column){
        int numSeat = ((row-1)*this.column)+column;
        getCurrentDataSeat(numSeat).setReserveStatus(false);
    }

    //แสดงผล status การจองของที่นั่งทั้งหมด
    public void printAllStatus(){
        for (Map.Entry<Integer, Seat> entry : DataSeat.getAllEntries()) {
            Integer key = entry.getKey();
            Seat value = entry.getValue();

            // ในที่นี้, ใช้ getRow() และ getColumn() ตัวอย่างเพื่อแสดงผลข้อมูลของ Seat
            System.out.print("("+"Key: " + key + ", Value: " + value.getStatus()+")"+" , ");
        }
    }
}
