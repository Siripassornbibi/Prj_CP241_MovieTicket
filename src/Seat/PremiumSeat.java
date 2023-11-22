package Seat;

public class PremiumSeat extends Seat{
    public PremiumSeat(int seatNumber) {
        super(seatNumber);
        setType("Premium");
        setPrice(200);
    }
}
