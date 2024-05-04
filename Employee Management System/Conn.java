import java.sql.*;
public class Conn {

    Connection c;
    Statement s;
    public Conn()
    {
        try{
            Class.forName("com.mysql.jdbc.Driver");
            //Inside MySql Workbench
            c = DriverManager.getConnection("jdbc:mysql:///EMS","root" , "Tanmay@07");
            s = c.createStatement();
        }catch(Exception e){
            e.printStackTrace();
    }
    }
}
