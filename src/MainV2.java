import GUI.*;
import Movie.*;
import Theater.*;

public class MainV2 {
    public static void main(String[] args) {
        //สามารถแก้โรงหนังและหนังได้ตรงนี้
        Theater testTheater = new Theater1(new Movie1());

        // Add a shutdown hook to serialize data when the program exits
        Runtime.getRuntime().addShutdownHook(new Thread(testTheater::saveDataTheater));

        // Deserialize data when the program starts
        testTheater.loadDataTheater();

        //เปิด UI
        ReservationMainFrame reservationMainFrame = new ReservationMainFrame(testTheater);

    }

}
