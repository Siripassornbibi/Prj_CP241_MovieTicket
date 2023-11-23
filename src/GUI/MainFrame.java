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

        //เพิ่มเก้าอี้ตัวที่1
        ImageIcon imageIcon1 = new ImageIcon("src/picture/PinkChair.png");
        JLabel imageLabel1 = new JLabel(imageIcon1);
        JPanel1.add(imageLabel1);

        //เพิ่มเก้าอี้ตัวที่2
        ImageIcon imageIcon2 = new ImageIcon("src/picture/AnotherImage.png");
        JLabel imageLabel2 = new JLabel(imageIcon2);
        JPanel1.add(imageLabel2);



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

        // สร้าง JLabel สำหรับข้อความ
        JLabel textLabel = new JLabel("BorBor And The Gang");
        textLabel.setVerticalAlignment(JLabel.TOP);
        textLabel.setHorizontalAlignment(JLabel.LEFT);
        JPanel2.add(textLabel);

        // สร้าง ImageIcon สำหรับรูปภาพลำโพง
        ImageIcon additionalIcon = new ImageIcon("src/picture/speaker.png");
        Image additionalImage = additionalIcon.getImage();
        //ปรับขนาดรูป
        int additionalWidth = 20;
        int additionalHeight = 20;
        Image scaledAdditionalImage = additionalImage.getScaledInstance(additionalWidth, additionalHeight, Image.SCALE_SMOOTH);
        ImageIcon scaledAdditionalIcon = new ImageIcon(scaledAdditionalImage);
        JLabel additionalImageLabel = new JLabel(scaledAdditionalIcon);
        JPanel2.add(additionalImageLabel);
        JPanel2.setLayout(new FlowLayout(FlowLayout.LEFT));
        JPanelCenter.add(JPanel2);


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
