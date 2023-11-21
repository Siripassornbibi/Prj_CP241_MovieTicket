package Seat;

public class Seat{
    private int seatNumber;
    private double price;
    private String type;

    private Boolean reserveStatus = false;

    public Seat(int seatNumber) {
       setSeatNumber(seatNumber);
    }

    //accessor
    public int getSeatNumber() {
        return seatNumber;
    }

    public double getPrice(){
        return price;
    }

    public String getType(){
        return type;
    }

    public Boolean getStatus(){
        return reserveStatus;
    }

    //mutator
    public void setSeatNumber(int num){
        this.seatNumber = num;
    }

    public void setPrice(double price){
        this.price = price;
    }

    public void setType(String type){
        this.type = type;
    }

    public void setReserveStatus(Boolean reserveStatus){
        this.reserveStatus = reserveStatus;
    }
}
