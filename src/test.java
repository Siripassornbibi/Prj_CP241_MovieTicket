import DataStructure.DoubleHashingHashMap;
import Seat.Seat;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.util.Map;

public class test {
    static DoubleHashingHashMap<Integer, Seat> DataSeat;
    public static void main(String[] args) {
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream("dataSeat.ser"))) {
            DataSeat = (DoubleHashingHashMap<Integer, Seat>) ois.readObject();
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }

        if (DataSeat != null) {
            for (Map.Entry<Integer, Seat> entry : DataSeat.getAllEntries()) {
                Integer key = entry.getKey();
                Seat value = entry.getValue();
                System.out.print("(" + "Key: " + key + ", Value: " + value.getStatus() + ")" + " , ");
            }
        } else {
            System.out.println("DataSeat is null. Loading failed.");
        }

    }

}
