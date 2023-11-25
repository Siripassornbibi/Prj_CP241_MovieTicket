package Theater;

import DataStructure.DoubleHashingHashMap;

public class Theater1 extends Theater{
    void Theater (Object movieInfo){
        new Theater1(movieInfo);
    }
    public Theater1(Object movieInfo) {
        if (movieInfo != null) {
            this.setMovieInfo(movieInfo);

            //Set Theater name
            setTheater_Name("Theatre1");

            //Set size of the Theater
            setRow(6);
            setColumn(11);

            DataSeat = new DoubleHashingHashMap<>();
            //type seat
            String[] allSeatType = {"StandardSeat 1234","PremiumSeat 56"};
            setTheater(allSeatType);
            //System.out.print(DataSeat);
        } else {
            // จัดการกรณีที่ movieInfo เป็น null
            System.out.println("Error: movieInfo is null");
        }
    }
}
