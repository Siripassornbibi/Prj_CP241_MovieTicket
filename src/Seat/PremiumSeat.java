package Seat;

import Movie.Movie1;

public class PremiumSeat extends Seat{
    public void Seat(int seatNumber){
        PremiumSeat s =new PremiumSeat(seatNumber);
    }
    public PremiumSeat(int seatNumber) {
        super(seatNumber);
        setPathPicture("src/picture/PurpleChair.png");
        setClicked_pathPicture("src/picture/ReservedPurpleSeat.png");
        setType("Premium");
        setPrice(200);
    }
}
