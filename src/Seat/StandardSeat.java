package Seat;

public class StandardSeat extends Seat{

    public void Seat(int seatNumber){
        StandardSeat s =new StandardSeat(seatNumber);
    }

    public StandardSeat(int seatNumber) {
        super(seatNumber);
        setPathPicture("src/picture/PickChair.png");
        setType("Standard");
        setPrice(160);
    }
}
