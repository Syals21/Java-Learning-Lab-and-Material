/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package inventorysystem;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author User
 */
public class DBConnection {
    public static Connection getConnection () throws SQLException {
        String url = "jdbc:mysql://localhost:3306/office_inventory";
        String user ="root";
        String pass= "1234";
        
        return DriverManager.getConnection(url, user, pass);
    }
}
