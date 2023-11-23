package GUI;

import javax.swing.*;
import java.awt.*;

public class MainFrame extends JFrame{
    private JPanel basePanel;
    private JButton button1,button2,button3;
    private JPanel JPanelStart;
    private JPanel JPanelEnd;
    private JPanel JPanelCenter;
    private JToolBar menu;
    private JLabel cinemaName,cineplexLabel;
    private JPanel JPanel1,JPanel2;


    private void createUIComponents() {
        // TODO: place custom component creation code here
        setTitle("Movie Reservation");
        setSize(945,650);
        setVisible(true);
        setIconImage(new ImageIcon("src/picture/logo.png").getImage());
        getContentPane().setLayout(new BorderLayout(0,0));
        getContentPane().setBackground(Color.PINK);

        //JPanelStart
        JPanelStart = new JPanel();
        JPanelStart.setBackground(new Color(0x3C3F41));
        JPanelStart.setLayout(new GridLayout(3,1));

        cinemaName = new JLabel("CINEMA NAME");
        cinemaName.setHorizontalAlignment(JLabel.CENTER);
        cinemaName.setVerticalAlignment(JLabel.CENTER);
        cinemaName.setForeground(Color.PINK);
        JPanelStart.add(cinemaName);

        menu = new JToolBar();
        button1 = new JButton("Click Here1");
        button1.setBounds(0,0,100,50);
        button2 = new JButton("Click Here2");
        button2.setBounds(0,0,100,50);
        button3 = new JButton("Click Here3");
        button3.setBounds(0,0,100,50);
        menu.add(button1);
        menu.add(button2);
        menu.add(button3);
        JPanelStart.add(menu);

        cineplexLabel = new JLabel("CINEPLEX NAME");
        cineplexLabel.setHorizontalAlignment(JLabel.CENTER);
        cineplexLabel.setVerticalAlignment(JLabel.CENTER);
        cineplexLabel.setForeground(Color.PINK);
        JPanelStart.add(cineplexLabel);

        getContentPane().add(JPanelStart, BorderLayout.PAGE_START);


        //JPanelCenter
        JPanelCenter = new JPanel();
        JPanelCenter.setBackground(new Color(0xFCFBE7));
        getContentPane().add(JPanelCenter, BorderLayout.CENTER);
        JPanelCenter.setLayout(new FlowLayout());


        JPanel1 = new JPanel();
        JPanel1.setBackground(Color.white);
        Dimension preferredSize = new Dimension(750, 600); // กำหนดขนาดความกว้างและความสูง
        JPanel1.setPreferredSize(preferredSize);
        JPanelCenter.add(JPanel1);

        JPanel JPanel2 = new JPanel();
        JPanel2.setBackground(Color.GRAY);
        Dimension preferredSize2 = new Dimension(350, 500); // กำหนดขนาดความกว้างและความสูง
        JPanel2.setPreferredSize(preferredSize2);

        ImageIcon originalIcon = new ImageIcon("src/picture/Poster1.png"); // เปลี่ยนเป็นตำแหน่งและชื่อไฟล์ของรูปเล็กที่คุณต้องการใช้
        Image originalImage = originalIcon.getImage();
        int scaledWidth = 150; // กำหนดความกว้างที่ต้องการ
        int scaledHeight = 200; // กำหนดความสูงที่ต้องการ
        Image scaledImage = originalImage.getScaledInstance(scaledWidth, scaledHeight, Image.SCALE_SMOOTH);
        ImageIcon scaledIcon = new ImageIcon(scaledImage);
        JLabel smallImageLabel = new JLabel(scaledIcon);
        JPanel2.add(smallImageLabel);

        // สร้าง JLabel สำหรับข้อความ BorBorAndTheGang
        JLabel textLabel = new JLabel("BorBor And The Gang");
        Font originalFont = textLabel.getFont();
        int newSize = 16;
        Font newFont = originalFont.deriveFont((float) newSize);
        textLabel.setFont(newFont);
        textLabel.setVerticalAlignment(JLabel.TOP);
        textLabel.setHorizontalAlignment(JLabel.LEFT);
        JPanel2.add(textLabel);

        // สร้าง ImageIcon สำหรับรูปภาพลำโพง
        ImageIcon additionalIcon = new ImageIcon("src/picture/speaker.png");
        Image additionalImage = additionalIcon.getImage();
        int additionalWidth = 30;
        int additionalHeight = 30;
        Image scaledAdditionalImage = additionalImage.getScaledInstance(additionalWidth, additionalHeight, Image.SCALE_SMOOTH);
        ImageIcon scaledAdditionalIcon = new ImageIcon(scaledAdditionalImage);
        JLabel additionalImageLabel = new JLabel(scaledAdditionalIcon);
        JPanel2.add(additionalImageLabel);

        JPanel2.setLayout(new FlowLayout(FlowLayout.LEFT));
        JPanelCenter.add(JPanel2);

        //เพิ่ม text TH/EN
        JLabel textLabel1 = new JLabel("TH/EN");
        textLabel1.setVerticalAlignment(JLabel.TOP);
        textLabel1.setHorizontalAlignment(JLabel.LEFT);
        JPanel2.add(textLabel1);


        // สร้าง ImageIcon สำหรับรูปภาพนาริกา
        ImageIcon newIcon = new ImageIcon("src/picture/Clock.png");
        Image newImage = newIcon.getImage();
        int newWidth = 30;
        int newHeight = 30;
        Image scaledNewImage = newImage.getScaledInstance(newWidth, newHeight, Image.SCALE_SMOOTH);
        ImageIcon scaledNewIcon = new ImageIcon(scaledNewImage);
        JLabel newImageLabel = new JLabel(scaledNewIcon);
        JPanel2.add(newImageLabel);

        //เพิ่ม text 120 MINS
        JLabel textLabel2 = new JLabel("120 MINS");
        textLabel2.setVerticalAlignment(JLabel.TOP);
        textLabel2.setHorizontalAlignment(JLabel.LEFT);
        JPanel2.add(textLabel2);

        // สร้าง ImageIcon สำหรับรูปภาพสองดี
        ImageIcon addIcon = new ImageIcon("src/picture/2D.png");
        Image addImage = addIcon.getImage();
        int addWidth = 40;
        int addHeight = 25;
        Image scaledAddImage = addImage.getScaledInstance(addWidth, addHeight, Image.SCALE_SMOOTH);
        ImageIcon scaledAddIcon = new ImageIcon(scaledAddImage);
        JLabel addImageLabel = new JLabel(scaledAddIcon);
        JPanel2.add(addImageLabel);

        //เพิ่ม text showtime
        JLabel textLabel3 = new JLabel("ShowTime");
        textLabel3.setVerticalAlignment(JLabel.TOP);
        textLabel3.setHorizontalAlignment(JLabel.LEFT);
        JPanel2.add(textLabel3);

        //เพิ่ม text swu
        JLabel textLabel4 = new JLabel("Srinakharinwirot Cinema");
        textLabel4.setVerticalAlignment(JLabel.TOP);
        textLabel4.setHorizontalAlignment(JLabel.LEFT);
        JPanel2.add(textLabel4);

        //เพิ่ม text date
        JLabel textLabel5 = new JLabel("MON 13 NOV");
        textLabel5.setVerticalAlignment(JLabel.TOP);
        textLabel5.setHorizontalAlignment(JLabel.LEFT);
        JPanel2.add(textLabel5);




        //เพิ่ม text โรงหนัง
        JLabel textLabel6 = new JLabel("Theater7");
        textLabel6.setVerticalAlignment(JLabel.TOP);
        textLabel6.setHorizontalAlignment(JLabel.LEFT);
        JPanel2.add(textLabel6);

        // สร้าง ImageIcon สำหรับรูปภาพเวลา
        ImageIcon add1Icon = new ImageIcon("src/picture/Time.png");
        Image add1Image = add1Icon.getImage();
        int add1Width = 50;
        int add1Height = 35;
        Image scaledAdd1Image = add1Image.getScaledInstance(add1Width, add1Height, Image.SCALE_SMOOTH);
        ImageIcon scaledAdd1Icon = new ImageIcon(scaledAdd1Image);
        JLabel add1ImageLabel = new JLabel(scaledAdd1Icon);
        JPanel2.add(add1ImageLabel);

        //เพิ่ม text ที่นั่ง
        JLabel textLabel7 = new JLabel("SEAT: ");
        textLabel7.setVerticalAlignment(JLabel.TOP);
        textLabel7.setHorizontalAlignment(JLabel.LEFT);
        JPanel2.add(textLabel7);

        //เพิ่ม text ราคา
        JLabel textLabel8 = new JLabel("TOTAL PRICE");
        textLabel8.setVerticalAlignment(JLabel.TOP);
        textLabel8.setHorizontalAlignment(JLabel.LEFT);
        JPanel2.add(textLabel8);

        //เพิ่ม text เลขที่นั่ง
        JLabel textLabel9 = new JLabel("E6");
        Font originalFont9 = textLabel9.getFont();
        int newSize9 = 16;
        Font newFont9 = originalFont9.deriveFont((float) newSize9);
        textLabel9.setFont(newFont9);
        textLabel9.setVerticalAlignment(JLabel.TOP);
        textLabel9.setHorizontalAlignment(JLabel.LEFT);
        JPanel2.add(textLabel9);


        //เพิ่ม text ราคารวม
        JLabel textLabel10 = new JLabel("160 BATH");
        textLabel10.setVerticalAlignment(JLabel.TOP);
        textLabel10.setHorizontalAlignment(JLabel.LEFT);
        JPanel2.add(textLabel10);



        JPanelCenter.setLayout(new FlowLayout(FlowLayout.CENTER));


        //JPanelEnd
        JPanelEnd = new JPanel();
        JPanelEnd.setBackground(new Color(0x3C3F41));
        getContentPane().add(JPanelEnd, BorderLayout.PAGE_END);


    }

    public static void main(String args[]){
        MainFrame mainFrame = new MainFrame();
    }
}
