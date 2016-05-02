package hmdb;

import java.awt.HeadlessException;
import java.sql.*;
import javax.swing.*;

/**
 * @author Rock
 */
public class MySqlConnect {
    Connection conn = null;
    
    Icon icon;

    public static Connection ConnectDB(){
        try {
            Class.forName("com.mysql.jdbc.Driver");
            Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/hotel_manager_db?autoReconnect=true&useSSL=true", "root", "root");
            JOptionPane.showMessageDialog(null, "Connected to database");
            return conn;
        } catch (ClassNotFoundException | SQLException | HeadlessException e) {
        JOptionPane.showMessageDialog(null, e);
        return null;
        }
    }
}
