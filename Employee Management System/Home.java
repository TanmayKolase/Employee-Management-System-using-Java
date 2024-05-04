import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Home extends JFrame implements ActionListener {

    JButton add,view,remove,update;
    Home()
    {
        //target entire window
        getContentPane().setBackground(Color.WHITE);
        setLayout(null);

        //Background Home-Image
        ImageIcon i1 = new ImageIcon("images/home.jpg");
        Image i2 = i1.getImage().getScaledInstance(1120, 630, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        image.setBounds(0, 0, 1120, 630);
        add(image);

        //Components
        //Heading
        JLabel heading = new JLabel("EMPLOYEE MANAGEMENT SYSTEM");
        heading.setBounds(650, 30, 1000, 30);
        heading.setFont(new Font("serif", Font.BOLD, 20));
        heading.setForeground(Color.BLACK);
        image.add(heading);

        //Button1
        add = new JButton("Add");
        add.setBounds(650, 100, 150, 40);
        add.addActionListener(this);
        image.add(add); //add button relatively to image

        //Button2
        view = new JButton("View");
        view.setBounds(850, 100, 150, 40);
        view.addActionListener(this);
        image.add(view); //add button relatively to image

        //Button3
        remove = new JButton("Remove");
        remove.setBounds(650, 160, 150, 40);
        remove.addActionListener(this);
        image.add(remove); //add button relatively to image

        //Button4
        update = new JButton("Update");
        update.setBounds(850, 160, 150, 40);
        update.addActionListener(this);
        image.add(update); //add button relatively to image

        //set window size
        setSize(1120,630);
        setLocation(250,100);
        setVisible(true);
    }

    public static void main(String[] args) {
        new Home();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == add){
            setVisible(false);
            new addEmployee();
        } else if (e.getSource() == view) {
            setVisible(false);
            new viewEmployee();
        } else if (e.getSource() == remove) {
            setVisible(false);
            new removeEmployee();
        }else{
            //for update button
            setVisible(false);
            new viewEmployee();
        }
    }
}
