package Seat;

public class StandardSeat extends Seat{

    public StandardSeat(int seatNumber) {
        super(seatNumber);
        setType("Standard");
        setPrice(160);
    }
}
