import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;
import java.awt.event.*;

public class Splash extends JFrame implements ActionListener {

    @Override
    public void actionPerformed(ActionEvent e) {
        setVisible(false);
        new Login();
    }

    Splash() {

        //getContentPane() to target entire window
        getContentPane().setBackground(Color.WHITE);
        setLayout(null);

        //Components
        //Heading
        JLabel heading = new JLabel("EMPLOYEE MANAGEMENT SYSTEM");
        heading.setBounds(40, 30, 1200, 60);
        heading.setFont(new Font("serif", Font.BOLD, 60));
        heading.setForeground(Color.RED);
        add(heading);

        //Background Home-Image
        ImageIcon i1 = new ImageIcon("images/Splash.jpg");
        Image i2 = i1.getImage().getScaledInstance(1100, 700, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        image.setBounds(50, 100, 1050, 500);
        add(image);

        //Button
        JButton click = new JButton("CLICK HERE");
        click.setBounds(400, 400, 300, 70);
        click.setBackground(Color.BLACK);
        click.setForeground(Color.WHITE);
        click.addActionListener(this);
        image.add(click); //add button relatively to image

        //Set window size
        setSize(1170, 650);
        setLocation(200, 50);
        setVisible(true);

    }

    public static void main(String args[]) {
        new Splash();
    }
}