package Seat;

public class StandardSeat extends Seat{

    public void Seat(int seatNumber){
        StandardSeat s =new StandardSeat(seatNumber);
    }

    public StandardSeat(int seatNumber) {
        super(seatNumber);
        setType("Standard");
        setPrice(160);
    }
}
