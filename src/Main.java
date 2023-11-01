import Theater.TheaterA;

public class Main {
    public static void main(String[] args) {
        TheaterA firstTheater = new TheaterA(5,10);
        System.out.println("ROW: "+firstTheater.getRow()+"   COLUMN: "+String.valueOf(firstTheater.getColumn()));
    }
}