/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package diplom;

import java.awt.event.KeyEvent;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.sql.*;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;

/**
 *
 * @author Алексей
 */
public class DBconnector {

    public static Connection c = null;

    public int connect(String loc, String name, String pass) {
        try {
            DriverManager.registerDriver(new com.mysql.jdbc.Driver());

            c = DriverManager.getConnection(
                    "jdbc:mysql://" + loc, name, pass);
            //List<String> values = new ArrayList<>();
        } catch (SQLException e) {
            e.printStackTrace();
            return 1;
        }
        return 0;
    }

}
