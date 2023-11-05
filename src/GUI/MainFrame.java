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
        JPanelStart.add(cineplexLabel);

        getContentPane().add(JPanelStart, BorderLayout.PAGE_START);


        //JPanelCenter
        JPanelCenter = new JPanel();
        JPanelCenter.setBackground(new Color(0xFCFBE7));
        getContentPane().add(JPanelCenter, BorderLayout.CENTER);
        JPanelCenter.setLayout(new FlowLayout());

        JPanel1 = new JPanel();
        JPanel1.setBackground(Color.white);
        Dimension preferredSize = new Dimension(650, 500); // กำหนดขนาดความกว้างและความสูง
        JPanel1.setPreferredSize(preferredSize);
        JPanelCenter.add(JPanel1);

        JPanel2 = new JPanel();
        JPanel2.setBackground(Color.orange);
        Dimension preferredSize2 = new Dimension(250, 500); // กำหนดขนาดความกว้างและความสูง
        JPanel2.setPreferredSize(preferredSize2);
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
