package DBConnect;

import java.sql.Connection;
import java.sql.DriverManager;

public class DBConnector {
    private Connection conn= null;
    public Connection getConnection(){
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            String str = "jdbc:mysql://localhost:3306/TourManager?useUnicode=true&characterEncoding=utf-8";
            conn = DriverManager.getConnection(str,"root","anhhaubk97");
        }catch (Exception e){
            e.printStackTrace();
        }
        return conn;
    }

}
