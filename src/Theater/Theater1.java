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
            setRow(5);
            setColumn(11);

            DataSeat = new DoubleHashingHashMap<>();
            //type seat
            setAllSeatType(new String[]{"StandardSeat 123","PremiumSeat 45"});
            //System.out.print(DataSeat);
        } else {
            // จัดการกรณีที่ movieInfo เป็น null
            System.out.println("Error: movieInfo is null");
        }
    }
}
