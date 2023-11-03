import Theater.Theater;

public class Main {
    public static void main(String[] args) {
        Main a = new Main();
        Theater firstTheater = new Theater(5, 10);
        a.setTheater();

        System.out.println("\nROW: " + firstTheater.getRow() + "   COLUMN: " + String.valueOf(firstTheater.getColumn()));
        System.out.println("\n"+firstTheater.getDataTheater());

        //แสดงผล
        for (int i = 0; i < firstTheater.getRow() * firstTheater.getColumn(); i++) {
            if (i % 10 == 0 && i != 0) {
                System.out.print('\n');
                System.out.print('x');
            } else {
                System.out.print('x');
            }
        }

    }

    void setTheater(){
    }

}