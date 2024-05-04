import java.awt.*;
import javax.swing.*;
import com.toedter.calendar.JDateChooser;
import java.util.*;
import java.awt.event.*;

public class addEmployee extends JFrame implements ActionListener{

    Random ran = new Random();
    int number = ran.nextInt(100);

    JTextField name, phone,  email, salary;
    JDateChooser dob;
    JLabel lblempId;
    JButton add, back;

    addEmployee() {
        getContentPane().setBackground(Color.WHITE);
        setLayout(null);

        JLabel heading = new JLabel("Add Employee Detail");
        heading.setBounds(320, 30, 500, 50);
        heading.setFont(new Font("SAN_SERIF", Font.BOLD, 25));
        add(heading);

        //Components
        //Name
        JLabel labelname = new JLabel("Name");
        labelname.setBounds(220, 150, 150, 30);
        labelname.setFont(new Font("serif", Font.PLAIN, 20));
        add(labelname);

        name = new JTextField();
        name.setBounds(320, 150, 240, 30);
        add(name);

        //Email
        JLabel labelemail = new JLabel("Email");
        labelemail.setBounds(220, 200, 150, 30);
        labelemail.setFont(new Font("serif", Font.PLAIN, 20));
        add(labelemail);

        email = new JTextField();
        email.setBounds(320, 200, 240, 30);
        add(email);

        //Phone
        JLabel labelphone = new JLabel("Phone");
        labelphone.setBounds(220, 250, 150, 30);
        labelphone.setFont(new Font("serif", Font.PLAIN, 20));
        add(labelphone);

        phone = new JTextField();
        phone.setBounds(320, 250, 240, 30);
        add(phone);

        //Salary
        JLabel labelsalary = new JLabel("Salary");
        labelsalary.setBounds(220, 300, 150, 30);
        labelsalary.setFont(new Font("serif", Font.PLAIN, 20));
        add(labelsalary);

        salary = new JTextField();
        salary.setBounds(320, 300, 240, 30);
        add(salary);

        JLabel labelempId = new JLabel("Employee id");
        labelempId.setBounds(200, 350, 150, 30);
        labelempId.setFont(new Font("serif", Font.PLAIN, 20));
        add(labelempId);

        lblempId = new JLabel("" + number);
        lblempId.setBounds(430, 350, 150, 30);
        lblempId.setFont(new Font("serif", Font.PLAIN, 20));
        lblempId.setForeground(Color.RED);
        add(lblempId);

        //Buttons
        add = new JButton("Add Details");
        add.setBounds(250, 450, 150, 40);
        add.addActionListener(this);
        add.setBackground(Color.BLACK);
        add.setForeground(Color.WHITE);
        add(add);

        back = new JButton("Back");
        back.setBounds(450, 450, 150, 40);
        back.addActionListener(this);
        back.setBackground(Color.BLACK);
        back.setForeground(Color.WHITE);
        add(back);

        //Set window size
        setSize(900, 700);
        setLocation(300, 50);
        setVisible(true);
    }

    public static void main(String[] args) {
        new addEmployee();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == add){
            String name1 = name.getText();
            String email1 = email.getText();
            String phone1 = phone.getText();
            String salary1 = salary.getText();
            String empId1 = lblempId.getText();

            try{
                Conn conn = new Conn();
                String query = "INSERT INTO EMPLOYEE VALUES('"+name1+"' , '"+email1+"' , '"+phone1+"' , '"+salary1+"' , '"+empId1+"');";
                conn.s.executeUpdate(query);
                JOptionPane.showMessageDialog(null , "Details added successfully!!!");
                setVisible(false);
                new Home();
            }catch(Exception e1)
            {
                e1.printStackTrace();
            }
        } else if (e.getSource() == back) {
            setVisible(false);
            new Home();
        }
    }
}