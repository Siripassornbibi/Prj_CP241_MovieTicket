package GUI;

import DataStructure.DoubleHashingHashMap;
import Movie.*;
import Seat.Seat;
import Theater.*;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public class ReservationMainFrame extends JFrame{
    private JPanel basePanel;
    private JButton button1,button2,button3;
    private JPanel JPanelStart;
    private JPanel JPanelEnd;
    private JPanel JPanelCenter;
    private JToolBar menu;
    private JLabel cinemaName,cineplexLabel;
    private JPanel JPanel1,JPanel2;
    private JLabel textLabel10; //TotalPrice
    private JLabel textLabel9; //Total Code Seat
    private int rowOne,columnOne;
    JButton reserveBtn;
    private ArrayList<Seat> allChooseSeat;
    private Map<Seat, JButton> seatButtonMap,seatJButtonMapReserved;
    private int countReservedClick;

    private Theater testTheater;
    private MovieInfo m;


    public ReservationMainFrame(Theater testTheater) {
        this.testTheater = testTheater;
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);  // ตั้งตำแหน่งให้ตรงกลาง
        getContentPane().setLayout(new BorderLayout(0, 0));
        createUIComponents();  // ย้ายการสร้าง UI ไปยังเมทอดนี้
        pack();  // ปรับขนาดตาม component ทั้งหมด
        setVisible(true);
    }

    public void createUIComponents() {
        //แก้ข้อมูลหนัง
        m = (MovieInfo) testTheater.getMovieInfo();

        rowOne = testTheater.getRow();
        columnOne = testTheater.getColumn();

        //test
        testTheater.getDataTheater().printAll();

        //ข้อมูลเก้าอี้ที่กดคลิกไว้
        allChooseSeat = new ArrayList<>();
        //key -> seat, value -> button
        seatButtonMap = new HashMap<>();
        seatJButtonMapReserved = new HashMap<>();

        //เลือกลบได้ทีละ 1 ตัว
        countReservedClick = 0;

        //******************************************************
        //                      ส่วน GUI
        //******************************************************

        // TODO: place custom component creation code here
        setTitle("Movie Reservation");
        setSize(1250, 1000);
        setVisible(true);
        setIconImage(new ImageIcon("src/picture/logo.png").getImage());
        getContentPane().setLayout(new BorderLayout(0, 0));
        getContentPane().setBackground(Color.PINK);

        //JPanelStart
        //******************************************************
        JPanelStart = new JPanel();
        JPanelStart.setBackground(new Color(0x3C3F41));
        JPanelStart.setLayout(new GridLayout(3, 1));

        cinemaName = new JLabel("Srinakharinwirot Cinema");
        cinemaName.setFont(new Font("Arial", Font.BOLD, 20));
        cinemaName.setBorder(new EmptyBorder(3, 0, 3, 0));
        cinemaName.setHorizontalAlignment(JLabel.CENTER);
        cinemaName.setVerticalAlignment(JLabel.CENTER);
        cinemaName.setForeground(Color.PINK);
        JPanelStart.add(cinemaName);

        menu = new JToolBar();
        button1 = new JButton("Click Here1");
        button1.setBounds(0, 0, 100, 50);
        button2 = new JButton("Click Here2");
        button2.setBounds(0, 0, 100, 50);
        button3 = new JButton("Click Here3");
        button3.setBounds(0, 0, 100, 50);
        menu.add(button1);
        menu.add(button2);
        menu.add(button3);
        JPanelStart.add(menu);

        cineplexLabel = new JLabel(testTheater.getTheaterName());
        cineplexLabel .setFont(new Font("Times New Roman", Font.BOLD, 18));
        cineplexLabel.setHorizontalAlignment(JLabel.CENTER);
        cineplexLabel.setVerticalAlignment(JLabel.CENTER);
        cineplexLabel.setForeground(Color.PINK);
        JPanelStart.add(cineplexLabel);

        getContentPane().add(JPanelStart, BorderLayout.PAGE_START);


        //JPanelCenter
        //******************************************************
        JPanelCenter = new JPanel();
        JPanelCenter.setBackground(new Color(0xFCFBE7));
        getContentPane().add(JPanelCenter, BorderLayout.CENTER);
        JPanelCenter.setLayout(new FlowLayout());

        //ส่วนตรงกลางซ้าย
        //******************************************************
        //JPanel 1
        JPanel1 = new JPanel();//ส่วนตรงกลางซ้าย
//        JPanel1.setBackground(Color.white);
        JPanel1.setOpaque(false);
        Dimension preferredSize = new Dimension(750, 750); // กำหนดขนาดความกว้างและความสูง
        JPanel1.setPreferredSize(preferredSize);
        JPanelCenter.add(JPanel1);
        JPanel1.setLayout(new GridLayout(rowOne+2, 1));

        //หน้าจอโรงหนัง
        ImageIcon screen = new ImageIcon("src/picture/screen.PNG");
        Image originalImagescreen = screen.getImage();
        Image scaledImagescreen = originalImagescreen.getScaledInstance(700, 50, Image.SCALE_SMOOTH);
        ImageIcon scaledIconscreen = new ImageIcon(scaledImagescreen);
        JLabel newImageLabelscreen = new JLabel(scaledIconscreen);
        JPanel1.add(newImageLabelscreen);

        //แถวเก้าอี้
        char lastCurrentChar = (char) ('A' + (rowOne-1));
        addRowWithLabel(rowOne,columnOne, lastCurrentChar,testTheater);

        JPanel seatPrice_Box = new JPanel();

        //กล่องราคาเก้าอี้ชมพู
        ImageIcon standardPrice = new ImageIcon("src/picture/StandardPrice.PNG");
        Image originalImage_standardPrice  = standardPrice.getImage();
        Image scaledImage_standardPrice  = originalImage_standardPrice.getScaledInstance(85, 85, Image.SCALE_SMOOTH);
        ImageIcon scaledIcon_standardPrice  = new ImageIcon(scaledImage_standardPrice );
        JLabel newImageLabel_standardPrice  = new JLabel(scaledIcon_standardPrice );
        seatPrice_Box.add(newImageLabel_standardPrice);

        //กล่องราคาเก้าอี้ม่วง
        ImageIcon PremiumPrice = new ImageIcon("src/picture/PremiumPrice.PNG");
        Image originalImage_PremiumPrice  = PremiumPrice.getImage();
        Image scaledImage_PremiumPrice = originalImage_PremiumPrice.getScaledInstance(85, 85, Image.SCALE_SMOOTH);
        ImageIcon scaledIcon_PremiumPrice  = new ImageIcon(scaledImage_PremiumPrice);
        JLabel newImageLabel_PremiumPrice  = new JLabel(scaledIcon_PremiumPrice);
        seatPrice_Box.add(newImageLabel_PremiumPrice);

        JPanel1.add(seatPrice_Box);

        //ส่วนตรงกลางขวา
        //******************************************************
        JPanel2 = new JPanel();//ส่วนด้านขวา
        JPanel2.setBackground(new Color((0xFFC9D1)));
        JPanel2.setBorder(new RoundBorder(30)); // ขอบมน
        Dimension preferredSize2 = new Dimension(420, 800); // กำหนดขนาดความกว้างและความสูง
        JPanel2.setPreferredSize(preferredSize2);

        //ส่วนด้านขวา JPanel

        //ส่วนด้านบนขวา
        JPanel jTop_JP2 = new JPanel(); //ขวาส่วนบน
        jTop_JP2.setBorder(new EmptyBorder(10, 0, 0, 0));
        jTop_JP2.setLayout(new GridLayout(1, 2));
        jTop_JP2.setOpaque(false);

        JPanel right_jTop_JP2 = new JPanel();
        right_jTop_JP2.setOpaque(false);
        right_jTop_JP2.setLayout(new GridLayout(4, 1));
        right_jTop_JP2.setBorder(new EmptyBorder(30, 10, 10, 10));

        ImageIcon originalIcon = new ImageIcon(m.getPosterMoviePath()); // เปลี่ยนเป็นตำแหน่งและชื่อไฟล์ของรูปเล็กที่คุณต้องการใช้
        Image originalImage = originalIcon.getImage();
        int scaledWidth = 150; // กำหนดความกว้างที่ต้องการ
        int scaledHeight = 200; // กำหนดความสูงที่ต้องการ
        Image scaledImage = originalImage.getScaledInstance(scaledWidth, scaledHeight, Image.SCALE_SMOOTH);
        ImageIcon scaledIcon = new ImageIcon(scaledImage);
        JLabel smallImageLabel = new JLabel(scaledIcon);
        jTop_JP2.add(smallImageLabel);

        // สร้าง JLabel สำหรับข้อความชื่อหนัง
        JLabel textLabel = new JLabel(m.getMovieName());
        textLabel.setFont(new Font("Arial", Font.BOLD,14));
        Font originalFont = textLabel.getFont();
        int newSize = 16;
        Font newFont = originalFont.deriveFont((float) newSize);
        textLabel.setFont(newFont);
        textLabel.setVerticalAlignment(JLabel.TOP);
        textLabel.setHorizontalAlignment(JLabel.LEFT);
        right_jTop_JP2.add(textLabel);

        JPanel A1 = new JPanel();
        A1.setOpaque(false);
        // สร้าง ImageIcon สำหรับรูปภาพลำโพง
        ImageIcon additionalIcon = new ImageIcon("src/picture/speaker.png");
        Image additionalImage = additionalIcon.getImage();
        int additionalWidth = 30;
        int additionalHeight = 30;
        Image scaledAdditionalImage = additionalImage.getScaledInstance(additionalWidth, additionalHeight, Image.SCALE_SMOOTH);
        ImageIcon scaledAdditionalIcon = new ImageIcon(scaledAdditionalImage);
        JLabel additionalImageLabel = new JLabel(scaledAdditionalIcon);
        A1.add(additionalImageLabel);

        A1.setLayout(new FlowLayout(FlowLayout.LEFT));

        //เพิ่ม text TH/EN
        JLabel textLabel1 = new JLabel(m.getLanguage());
        textLabel1.setVerticalAlignment(JLabel.TOP);
        textLabel1.setHorizontalAlignment(JLabel.LEFT);
        A1.add(textLabel1);

        right_jTop_JP2.add(A1);

        JPanel A2 = new JPanel();
        A2.setOpaque(false);
        // สร้าง ImageIcon สำหรับรูปภาพนาฬิกา
        ImageIcon newIcon = new ImageIcon("src/picture/Clock.png");
        Image newImage = newIcon.getImage();
        int newWidth = 30;
        int newHeight = 30;
        Image scaledNewImage = newImage.getScaledInstance(newWidth, newHeight, Image.SCALE_SMOOTH);
        ImageIcon scaledNewIcon = new ImageIcon(scaledNewImage);
        JLabel newImageLabel = new JLabel(scaledNewIcon);
        A2.add(newImageLabel);

        //เพิ่ม text 120 MINS
        JLabel textLabel2 = new JLabel(m.getTotalTime());
        textLabel2.setVerticalAlignment(JLabel.TOP);
        textLabel2.setHorizontalAlignment(JLabel.LEFT);
        A2.add(textLabel2);

        A2.setLayout(new FlowLayout(FlowLayout.LEFT));
        right_jTop_JP2.add(A2);

        // สร้าง ImageIcon สำหรับรูปภาพสองดี
        ImageIcon addIcon = new ImageIcon("src/picture/2D.png");
        Image addImage = addIcon.getImage();
        int addWidth = 40;
        int addHeight = 25;
        Image scaledAddImage = addImage.getScaledInstance(addWidth, addHeight, Image.SCALE_SMOOTH);
        ImageIcon scaledAddIcon = new ImageIcon(scaledAddImage);
        JLabel addImageLabel = new JLabel(scaledAddIcon);
        addImageLabel.setHorizontalAlignment(JLabel.RIGHT);
        right_jTop_JP2.add(addImageLabel);

        jTop_JP2.add(right_jTop_JP2);

        JPanel2.add(jTop_JP2);

        //ส่วนกลางขวา
        JPanel jMiddle_JP2 = new JPanel();
        jMiddle_JP2.setLayout(new GridLayout(4, 1));
        jMiddle_JP2.setPreferredSize(new Dimension(400, 300));
        jMiddle_JP2.setBorder(new EmptyBorder(10, 30, 10, 20));

        //เพิ่ม text showtime
        JLabel textLabel3 = new JLabel("ShowTime");
        textLabel3.setFont(new Font("Arial", Font.BOLD,14));
        textLabel3.setVerticalAlignment(JLabel.TOP);
        textLabel3.setHorizontalAlignment(JLabel.LEFT);
        jMiddle_JP2.add(textLabel3);

        JPanel B1 = new JPanel();
        B1.setOpaque(false);
        B1.setLayout(new GridLayout(2, 1));
        //เพิ่ม text swu
        JLabel textLabel4 = new JLabel("Srinakharinwirot Cinema");

        textLabel4.setVerticalAlignment(JLabel.TOP);
        textLabel4.setHorizontalAlignment(JLabel.LEFT);
        B1.add(textLabel4);

        //เพิ่ม text date
        JLabel textLabel5 = new JLabel("MON 13 NOV");
        textLabel5.setVerticalAlignment(JLabel.TOP);
        textLabel5.setHorizontalAlignment(JLabel.LEFT);
        B1.add(textLabel5);

        jMiddle_JP2.add(B1);

        JPanel B2 = new JPanel();
        B2.setLayout(new BoxLayout(B2, BoxLayout.X_AXIS));
        B2.setOpaque(false);

        //เพิ่ม text โรงหนัง
        JLabel textLabel6 = new JLabel(testTheater.getTheaterName());
        B2.add(textLabel6);

        // สร้าง ImageIcon สำหรับรูปภาพเวลา
        ImageIcon add1Icon = new ImageIcon("src/picture/Time.png");
        Image add1Image = add1Icon.getImage();
        int add1Width = 50;
        int add1Height = 35;
        Image scaledAdd1Image = add1Image.getScaledInstance(add1Width, add1Height, Image.SCALE_SMOOTH);
        ImageIcon scaledAdd1Icon = new ImageIcon(scaledAdd1Image);
        JLabel add1ImageLabel = new JLabel(scaledAdd1Icon);
        B2.add(Box.createHorizontalGlue());
        B2.add(add1ImageLabel);

        jMiddle_JP2.add(B2);

        JPanel B3 = new JPanel();
        B3.setOpaque(false);
        B3.setLayout(new GridLayout(2, 2));

        //เพิ่ม text ที่นั่ง
        JLabel textLabel7 = new JLabel("SEAT: ");
        textLabel7.setFont(new Font("Arial", Font.BOLD,14));
        textLabel7.setVerticalAlignment(JLabel.TOP);
        textLabel7.setHorizontalAlignment(JLabel.LEFT);
        B3.add(textLabel7);

        //เพิ่ม text ราคา
        JLabel textLabel8 = new JLabel("TOTAL PRICE");
        textLabel8.setFont(new Font("Arial", Font.BOLD,14));
        textLabel8.setVerticalAlignment(JLabel.TOP);
        textLabel8.setHorizontalAlignment(JLabel.LEFT);
        B3.add(textLabel8);

        //เพิ่ม text เลขที่นั่ง
        textLabel9 = new JLabel("");
        Font originalFont9 = textLabel9.getFont();
        int newSize9 = 14;
        Font newFont9 = originalFont9.deriveFont((float) newSize9);
        textLabel9.setFont(newFont9);
        textLabel9.setVerticalAlignment(JLabel.TOP);
        textLabel9.setHorizontalAlignment(JLabel.LEFT);
        B3.add(textLabel9);


        //เพิ่ม text ราคารวม
        textLabel10 = new JLabel("0 BATH");
        textLabel10.setVerticalAlignment(JLabel.TOP);
        textLabel10.setHorizontalAlignment(JLabel.LEFT);
        B3.add(textLabel10);

        jMiddle_JP2.add(B3);

        jMiddle_JP2.setOpaque(false);
        JPanel2.add(jMiddle_JP2);

        //ส่วนขวาล่าง
        JPanel jEnd_JP2 = new JPanel();
        jEnd_JP2.setOpaque(false);

        //ปุ่มกดจองยกเลิก
        reserveBtn = new JButton("SELECT SEAT");
        reserveBtn.setPreferredSize(new Dimension(360,45));

        //ActionListener ของ ปุ่มกดจองยกเลิก
        ActionListener btnReserveListener = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (reserveBtn.getText().equals("RESERVE")) {
                    //reserveBtn.setText("CANCEL");

                    for (Map.Entry<Seat , JButton> entry : seatButtonMap.entrySet()) {
                        Seat key = entry.getKey();
                        JButton value = entry.getValue();

                        key.setReserveStatus(true);

                        //testTheater.getDataTheater().printAll();

                        seatJButtonMapReserved.put(key,value);

                        ImageIcon reservedSeatIcon = new ImageIcon(key.getReserved_pathPicture());
                        value.setIcon(reservedSeatIcon);
                    }
                    //check
                    checkDoubleHash();
                    System.out.println('\n');

                    seatButtonMap.clear();
                    allChooseSeat.clear();

                    calculateTotal(seatButtonMap);
                    getSeatCode(allChooseSeat);

                    reserveBtn.setText("SELECT SEAT");

                } else if (reserveBtn.getText().equals("CANCEL")) {
                    for (Map.Entry<Seat , JButton> entry : seatButtonMap.entrySet()) {
                        Seat key = entry.getKey();
                        JButton value = entry.getValue();

                        key.setReserveStatus(false);
                        //check
                        checkDoubleHash();
                        System.out.println('\n');

                        seatJButtonMapReserved.remove(key);
                        seatButtonMap.clear();
                        allChooseSeat.clear();

                        calculateTotal(seatButtonMap);
                        getSeatCode(allChooseSeat);

                        ImageIcon SeatIcon = new ImageIcon(key.getPathPicture());
                        value.setIcon(SeatIcon);

                        reserveBtn.setText("SELECT SEAT");

                        countReservedClick--;
                    }
                }
            }
        };

        reserveBtn.addActionListener(btnReserveListener);

        jEnd_JP2.add(reserveBtn);

        JPanel2.add(jEnd_JP2);

        JPanelCenter.add(JPanel2);
        JPanelCenter.setLayout(new FlowLayout(FlowLayout.CENTER));

        //JPanelEnd
        //******************************************************
        JPanelEnd = new JPanel();
        JPanelEnd.setBackground(new Color(0x3C3F41));
        getContentPane().add(JPanelEnd, BorderLayout.PAGE_END);

        pack();

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);  // ตั้งตำแหน่งให้ตรงกลาง
        setVisible(true);
    }


    //วางเก้าอี้ทั้งหมดทุกแถว
    public void addRowWithLabel(int currentRow,int column, char currentChar,Theater theater) {
        //key เริ่มต้นที่ 1
        DoubleHashingHashMap data = theater.getDataTheater();
        if (currentRow > 0) {
            JPanel one = new JPanel();
            one.setOpaque(false);

            JLabel rowAlphabet = new JLabel(Character.toString(currentChar));
            rowAlphabet.setFont(new Font("Arial", Font.BOLD,13));
            one.add(rowAlphabet);

            for (int j = 1; j <= column; j++) {
                Seat s = (Seat) data.get((Math.abs( currentRow - theater.getRow() ) * column ) + j);
                //System.out.println(s.getSeatNumber());

                one.add(addSeat(s));
            }


            JPanel1.add(one);

            // เรียกตัวเองเพื่อทำแถวถัดไป
            addRowWithLabel(currentRow - 1,column, (char)(currentChar - 1),theater);
        }
    }

    //วางเก้าอี้แต่ละแบบ
    private JButton addSeat(Seat seat){
        ImageIcon imageIcon;
        if(seat.getStatus()){
            imageIcon = new ImageIcon(seat.getReserved_pathPicture());
            Image image = imageIcon.getImage().getScaledInstance(35, 35, Image.SCALE_SMOOTH);
            imageIcon = new ImageIcon(image);
        }else{
            imageIcon = new ImageIcon(seat.getPathPicture());
            Image image = imageIcon.getImage().getScaledInstance(35, 35, Image.SCALE_SMOOTH);
            imageIcon = new ImageIcon(image);
        }
        JButton btnSeat = new JButton("");
        btnSeat.setIcon(imageIcon);
        btnSeat.setBorder(BorderFactory.createEmptyBorder(0, 0, 0, 0));
        ActionListener buttonListener = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JButton sourceButton = (JButton) e.getSource();
                toggleImage(sourceButton,seat);
            }
        };

        btnSeat.addActionListener(buttonListener);

        return btnSeat;
    }

    //การกดปุ่มสับเก้าอี้
    private void toggleImage(JButton button,Seat seat) {
        //ภาพเก้าอี้ถูกคลิก
        ImageIcon ChairIcon = new ImageIcon(seat.getClicked_pathPicture());
        Image ChairImage = ChairIcon.getImage();

        //ภาพรูปภาพปกติ
        ImageIcon SeatIcon = new ImageIcon(seat.getPathPicture());
        Image SeatImage = SeatIcon.getImage();

        //ภาพถูกจอง
        ImageIcon reservedSeatIcon = new ImageIcon(seat.getReserved_pathPicture());
        Image reservedSeatImage = reservedSeatIcon.getImage();

        ImageIcon currentIcon = (ImageIcon) button.getIcon();
        Image currentImage = currentIcon.getImage();


        if (currentImage.equals(ChairImage)) {
            button.setIcon(SeatIcon);

            allChooseSeat.remove(seat);
            seatButtonMap.remove(seat);

            calculateTotal(seatButtonMap);
            getSeatCode(allChooseSeat);

        } else if (seat.getStatus() && countReservedClick == 0) {
            //รีเซ็ตใหม่ + เก้าอี้ที่จะลบ ลบได้ทีละตัว

            //ใช้รีเซ็ตพวกเก้าอี้ยังไม่จองที่เลือก
            for (JButton btn : seatButtonMap.values()){
                btn.setIcon(SeatIcon);
            }

            seatButtonMap.clear();
            allChooseSeat.clear();

            reserveBtn.setText("CANCEL");

            allChooseSeat.add(seat);
            seatButtonMap.put(seat,button);

            calculateTotal(seatButtonMap);
            getSeatCode(allChooseSeat);

            countReservedClick++;

        } else if (seat.getStatus() && countReservedClick > 0) {
            seatButtonMap.clear();
            allChooseSeat.clear();

            reserveBtn.setText("CANCEL");

            allChooseSeat.add(seat);
            seatButtonMap.put(seat,button);

            calculateTotal(seatButtonMap);
            getSeatCode(allChooseSeat);

            countReservedClick++;
        } else {
            if (countReservedClick > 0){
                seatButtonMap.clear();
                allChooseSeat.clear();
                countReservedClick = 0;
            }
            button.setIcon(ChairIcon);

            allChooseSeat.add(seat);
            seatButtonMap.put(seat,button);

            calculateTotal(seatButtonMap);
            getSeatCode(allChooseSeat);

            reserveBtn.setText("RESERVE");

        }

        if(allChooseSeat.isEmpty() && seatJButtonMapReserved.isEmpty()){
            reserveBtn.setText("SELECT SEAT");
        }
    }

    //คำนวณราคารวม
    private double calculateTotal(Map<Seat, JButton> inputHashMap){
        double sum = 0;
        for (Seat s : seatButtonMap.keySet()){
            sum += s.getPrice();
        }
        //System.out.println(sum);
        textLabel10.setText(sum + "  BATH"); // แสดงผลราคารวมทั้งหมด
        return sum;
    }

    //ที่นั่งที่กดเลือกทั้งหมด
    private String getSeatCode(ArrayList<Seat> selectedArrayList_Seat){
        String allSeatCode = new String("");

        for (int i = 0; i < selectedArrayList_Seat.size(); i++) {
            Seat s = selectedArrayList_Seat.get(i);
            if(selectedArrayList_Seat.size() == 1 || i == selectedArrayList_Seat.size()-1){
                allSeatCode += s.getRow() + s.getColum();
            } else{
                allSeatCode += s.getRow() + s.getColum()+", ";
            }
        }

        //System.out.println(allSeatCode);
        textLabel9.setText(allSeatCode);
        return allSeatCode;
    }

    private void checkDoubleHash(){
        //ไว้เช็คข้อมูลใน doublehashmap
        DoubleHashingHashMap<Integer, Seat> testData = testTheater.getDataTheater();
        for (Map.Entry<Integer, Seat> entry : testData.getAllEntries()) {
            Integer key = entry.getKey();
            Seat value = entry.getValue();

            // ในที่นี้, ใช้ getRow() และ getColumn() ตัวอย่างเพื่อแสดงผลข้อมูลของ Seat
            System.out.print("("+"Key: " + key + ", Value: " + value.getStatus()+")"+" , ");
        }

    }

    public void setTheater(Theater theater){
        this.testTheater = theater;
    }

    public Theater getTestTheater(Theater theater){
        return this.testTheater;
    }

}
