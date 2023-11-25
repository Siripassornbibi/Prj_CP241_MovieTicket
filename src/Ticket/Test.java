package Ticket;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Test {
    public static void main(String[] args) {
        JFrame frame = new JFrame("Multi JButton Example");
        frame.setSize(400, 300);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        ImageIcon imageIcon1 = new ImageIcon("src/picture/PickChair.png");
        Image image1 = imageIcon1.getImage().getScaledInstance(35, 35, Image.SCALE_SMOOTH);
        imageIcon1 = new ImageIcon(image1);
        JButton button1 = new JButton("");
        button1.setIcon(imageIcon1);
        button1.setActionCommand("button1");

        ImageIcon imageIcon2 = new ImageIcon("src/picture/PickChair.png");
        Image image2 = imageIcon2.getImage().getScaledInstance(35, 35, Image.SCALE_SMOOTH);
        imageIcon2 = new ImageIcon(image2);
        JButton button2 = new JButton("");
        button2.setIcon(imageIcon2);
        button2.setActionCommand("button2");

        ActionListener buttonListener = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JButton sourceButton = (JButton) e.getSource();
                toggleImage(sourceButton);
            }
        };

        button1.addActionListener(buttonListener);
        button2.addActionListener(buttonListener);

        frame.setLayout(new BoxLayout(frame.getContentPane(), BoxLayout.Y_AXIS));
        frame.add(button1);
        frame.add(button2);

        frame.setVisible(true);
    }

    private static void toggleImage(JButton button) {
        ImageIcon pickChairIcon = new ImageIcon("src/picture/PickChair.png");
        Image pickChairImage = pickChairIcon.getImage();

        ImageIcon reservedSeatIcon = new ImageIcon("src/picture/CheckedPurpleSeat.png");
        Image reservedSeatImage = reservedSeatIcon.getImage();

        ImageIcon currentIcon = (ImageIcon) button.getIcon();
        Image currentImage = currentIcon.getImage();

        if (currentImage.equals(pickChairImage)) {
            button.setIcon(reservedSeatIcon);
        } else {
            button.setIcon(pickChairIcon);
        }
    }
}

