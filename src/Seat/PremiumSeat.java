package Seat;

import Movie.Movie1;

public class PremiumSeat extends Seat{
    public void Seat(int seatNumber){
        PremiumSeat s =new PremiumSeat(seatNumber);
    }
    public PremiumSeat(int seatNumber) {
        super(seatNumber);
        setType("Premium");
        setPrice(200);
    }
}
