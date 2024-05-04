import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.sql.*;

public class updateEmployee extends JFrame implements ActionListener{

    JTextField tfphone, tfemail, tfsalary;
    JLabel lblempId;
    JButton add, back;
    String empId;

    updateEmployee(String empId) {
        this.empId = empId;
        getContentPane().setBackground(Color.WHITE);
        setLayout(null);

        JLabel heading = new JLabel("Update Employee Detail");
        heading.setBounds(320, 30, 500, 50);
        heading.setFont(new Font("SAN_SERIF", Font.BOLD, 25));
        add(heading);

        JLabel labelname = new JLabel("Name");
        labelname.setBounds(220, 150, 150, 30);
        labelname.setFont(new Font("serif", Font.PLAIN, 20));
        add(labelname);

        JLabel lblname = new JLabel();
        lblname.setBounds(320, 150, 240, 30);
        add(lblname);

        JLabel labelemail = new JLabel("Email");
        labelemail.setBounds(220, 200, 150, 30);
        labelemail.setFont(new Font("serif", Font.PLAIN, 20));
        add(labelemail);

        tfemail = new JTextField();
        tfemail.setBounds(320, 200, 240, 30);
        add(tfemail);

        JLabel labelphone = new JLabel("Phone");
        labelphone.setBounds(220, 250, 150, 30);
        labelphone.setFont(new Font("serif", Font.PLAIN, 20));
        add(labelphone);

        tfphone = new JTextField();
        tfphone.setBounds(320, 250, 240, 30);
        add(tfphone);

        JLabel labelsalary = new JLabel("Salary");
        labelsalary.setBounds(220, 300, 150, 30);
        labelsalary.setFont(new Font("serif", Font.PLAIN, 20));
        add(labelsalary);

        tfsalary = new JTextField();
        tfsalary.setBounds(320, 300, 240, 30);
        add(tfsalary);

        JLabel labelempId = new JLabel("Employee id");
        labelempId.setBounds(200, 350, 150, 30);
        labelempId.setFont(new Font("serif", Font.PLAIN, 20));
        add(labelempId);

        lblempId = new JLabel();
        lblempId.setBounds(430, 350, 150, 30);
        lblempId.setFont(new Font("serif", Font.PLAIN, 20));
        add(lblempId);

        try {
            Conn c = new Conn();
            String query = "select * from employee where empId = '"+empId+"'";
            ResultSet rs = c.s.executeQuery(query);
            while(rs.next()) {
                lblname.setText(rs.getString("name"));
                tfemail.setText(rs.getString("email"));
                tfphone.setText(rs.getString("phone"));
                tfsalary.setText(rs.getString("salary"));
                lblempId.setText(rs.getString("empId"));

            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        add = new JButton("Update Details");
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

        setSize(900, 700);
        setLocation(300, 50);
        setVisible(true);
    }

    public void actionPerformed(ActionEvent ae) {
        if (ae.getSource() == add) {
            String salary = tfsalary.getText();
            String phone = tfphone.getText();
            String email = tfemail.getText();
            try {
                Conn conn = new Conn();
                String query = "update employee set email = '"+email+"', phone = '"+phone+"', salary =  '"+salary+"' where empId = '"+empId+"'";
                conn.s.executeUpdate(query);
                JOptionPane.showMessageDialog(null, "Details updated successfully");
                setVisible(false);
                new Home();
            } catch (Exception e) {
                e.printStackTrace();
            }
        } else {
            setVisible(false);
            new Home();
        }
    }

    public static void main(String[] args) {
        new updateEmployee("");
    }
}