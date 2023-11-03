package Seat;

public class Seat{
    private int seatNumber;
    private double price;
    private boolean reserved;

    public Seat(int seatNumber, double price) {
        this.seatNumber = seatNumber;
        this.price = price;
        this.reserved = false;
    }

    public int getSeatNumber() {
        return seatNumber;
    }

    public double getPrice() {
        return price;
    }

    public boolean isReserved() {
        return reserved;
    }

    public void reserve() {
        if (!reserved) {
            reserved = true;
            System.out.println("Seat " + seatNumber + " has been reserved.");
        } else {
            System.out.println("Seat " + seatNumber + " is already reserved.");
        }
    }

    public void cancelReservation() {
        if (reserved) {
            reserved = false;
            System.out.println("Reservation for seat " + seatNumber + " has been canceled.");
        } else {
            System.out.println("Seat " + seatNumber + " is not reserved.");
        }
    }


}
