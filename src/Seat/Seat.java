package Seat;

import java.io.Serializable;

public class Seat implements Serializable {
    private int seatNumber;
    private double price;
    private String type;
    private Boolean reserveStatus = false;
    private String pathPicture,clicked_pathPicture,reserved_pathPicture;

    private String row;
    private int colum;

    public Seat(int seatNumber) {
       setSeatNumber(seatNumber);
    }

    //accessor
    public int getSeatNumber() {
        return seatNumber;
    }

    public String getRow(){return row;}

    public int getColum(){return colum;}

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

    public String getClicked_pathPicture(){return clicked_pathPicture;}

    public String getReserved_pathPicture(){return reserved_pathPicture;}

    //mutator
    public void setSeatNumber(int num){
        this.seatNumber = num;
    }

    public void setRow(String row){
        this.row = row;
    }

    public void setColum(int colum){
        this.colum = colum;
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

    public void setClicked_pathPicture(String Clicked_pathPicture){this.clicked_pathPicture = Clicked_pathPicture;}

    public void setReserved_pathPicture(String Reserved_pathPicture){this.reserved_pathPicture = Reserved_pathPicture;}
}
