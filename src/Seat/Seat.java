package Seat;

public class Seat{
    private int seatNumber;
    private double price;
    private String type;
    private Boolean reserveStatus = false;
    private String pathPicture;

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

    public String getPathPicture(){return pathPicture;}

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

    public void setPathPicture(String pathPicture){this.pathPicture = pathPicture;}
}
