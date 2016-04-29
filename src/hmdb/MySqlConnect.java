package hmdb;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
import java.sql.*;
import javax.swing.*;
/**
 *
 * @author Rock
 */
public class MySqlConnect {
    Connection conn = null;

    /**
     *
     * @return
     */
    public static Connection ConnectDB(){
        try {
            Class.forName("com.mysql.jdbc.Driver");
            Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/hotel_manager_db", "root", "root");
            JOptionPane.showMessageDialog(null, "Connected to database");
            return conn;
        } catch (Exception e) {
        JOptionPane.showMessageDialog(null, e);
        return null;
        }
    }
}
