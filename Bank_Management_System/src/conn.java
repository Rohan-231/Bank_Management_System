import java.sql.*;

public class conn {
    Connection c;
    Statement s = null;
    public conn(){
        try {
            // Class.forName("com.mysql.jdbc.Driver");
            c = DriverManager.getConnection("jdbc:mysql:///bankmanagementsystem","root","Rohan11");
            s = c.createStatement();
        } catch (Exception e) {
            System.out.println(e);
        }
    }
}
