package Seat;

import java.io.Serializable;

public class StandardSeat extends Seat{

    public void Seat(int seatNumber){
        StandardSeat s =new StandardSeat(seatNumber);
    }

    public StandardSeat(int seatNumber) {
        super(seatNumber);
        setPathPicture("src/picture/PickChair.png");
        setClicked_pathPicture("src/picture/CheckedPinkSeat.png");
        setReserved_pathPicture("src/picture/ReservedPickChair.png");
        setType("Standard");
        setPrice(160);
    }
}
