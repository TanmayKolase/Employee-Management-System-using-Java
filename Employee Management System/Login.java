import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;

public class Login extends JFrame implements ActionListener {

    JTextField uname,pass;
    public void actionPerformed(ActionEvent e) {
        try{
            String username = uname.getText();
            String password = pass.getText();

            Conn c = new Conn();
            String query = "SELECT * FROM login WHERE username = '"+username+"' and password = '"+password+"'";
            ResultSet rs = c.s.executeQuery(query);

            if (rs.next())
            {
                JOptionPane.showMessageDialog(null , "Login Successful!!!");
                new Home();
                setVisible(false);

            }else {
                JOptionPane.showMessageDialog(null , "Invalid username/password");
//                setVisible(false);
            }

        }catch (Exception ec){
            ec.printStackTrace();
        }
    }
    Login()
    {
        //Target entire window with getContentPane()
        getContentPane().setBackground(Color.white); //Color class in awt package
        setLayout(null);

        //add components
        //username field
        JLabel username = new JLabel("Username ");
        username.setBounds(40,40,100,30);
        add(username);

        uname = new JTextField();
        uname.setBounds(150,40,150,30);
        add(uname);

        //password field
        JLabel password = new JLabel("Password ");
        password.setBounds(40,100,100,30);
        add(password);

        pass = new JTextField();
        pass.setBounds(150,100,150,30);
        add(pass);

        //Login button
        JButton login = new JButton("LOGIN");
        login.setBackground(Color.BLACK);
        login.setForeground(Color.WHITE);
        login.setBounds(150,170,150,30);
        login.addActionListener(this);
        add(login);

        //Login-Image
        ImageIcon i1 = new ImageIcon("images/second.jpg");
        Image i2 = i1.getImage().getScaledInstance(200, 200, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        image.setBounds(350, 10, 200, 200);
        add(image);

        //set window size
        setSize(600,300);
        setLocation(450,200);
        setVisible(true);
    }

    public static void main(String[] args) {
        new Login();
    }
}
