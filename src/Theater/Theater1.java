package Theater;

import DataStructure.DoubleHashingHashMap;

public class Theater1 extends Theater{
    void Theater (Object movieInfo){
        new Theater1(movieInfo);
    }
    public Theater1(Object movieInfo) {
        if (movieInfo != null) {
            this.setMovieInfo(movieInfo);

            //Set size of the Theater
            setRow(6);
            setColumn(13);

            DataSeat = new DoubleHashingHashMap<>();
            //type seat
            String[] allSeatType = {"StandardSeat 123","PremiumSeat 456"};
            setTheater(allSeatType);
            //System.out.print(DataSeat);
        } else {
            // จัดการกรณีที่ movieInfo เป็น null
            System.out.println("Error: movieInfo is null");
        }
    }
}
