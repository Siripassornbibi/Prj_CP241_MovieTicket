import DataStructure.DoubleHashingHashMap;
import GUI.MainFrame;
import Seat.*;
import Theater.Theater;

import java.util.Scanner;

public class Main {
    Scanner scanner = new Scanner(System.in);
    public static void main(String[] args) {
        Main a = new Main();
        Theater firstTheater = new Theater();

        System.out.println("\nROW: " + firstTheater.getRow() + "   COLUMN: " + firstTheater.getColumn());
        System.out.println("\n"+firstTheater.getDataTheater());

        //แสดงผล
        a.showCurrentTheater(firstTheater);

        a.option(firstTheater);


    }

    void option(Theater theater){
        int row,column;
        String input = "a";

        while(!input.equalsIgnoreCase("x")) {
            System.out.println("\nPlease choose your choice" +
                    "\n-------------------------------" +
                    "\n1.reserve" +
                    "\n2.cancel reservation" +
                    "\nx.exit");
            input = scanner.nextLine();

            if (input.equals("1")) {
                System.out.println("reserve row");
                row = scanner.nextInt();
                System.out.println("column");
                column = scanner.nextInt();
                theater.reserve(((row - 1) * theater.getColumn()) + column);
                
                showCurrentTheater(theater);
                
            } else if (input.equals("2")) {
                System.out.println("cancel reservation row");
                row = scanner.nextInt();
                System.out.println("column");
                column = scanner.nextInt();
                theater.cancelReservation(((row - 1) * theater.getColumn()) + column);

                showCurrentTheater(theater);
      
            }
            
        }
    }

    void showCurrentTheater(Theater theater){
        DoubleHashingHashMap data = theater.getDataTheater();
        for (int i = 1; i <= theater.getRow() * theater.getColumn(); i++) {
            Seat s = (Seat) data.get(i);
            if (i % 10 == 1 && i != 1) {
                System.out.print('\n');
                if(s.getStatus()){
                    System.out.print('o');
                }else{
                    System.out.print('x');
                }
            }else {
                if (s.getStatus()) {
                    System.out.print('o');
                } else {
                    System.out.print('x');
                }
            }
        }

    }

}