/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package buiildingsoft;

import java.beans.Statement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

/**
 *
 * @author caya
 */
public class Login {
    Connection con;
    Statement st;
    ResultSet rs;
    
    
    
    JFrame login = new JFrame("User Login");
    JLabel user = new JLabel("Username:");
    JLabel pass = new JLabel("Password:");
    JTextField textfield1 = new JTextField("10");
    JTextField textfield2 = new JTextField("10");
    JButton b = new JButton("Login");
    
    public Login(){
        connect();
        frame();
    }

    private void connect() {
        try {
            String driver = "sun.jdbc.odbc.jdbcOdbcDriver" ;
            Class.forName(driver);
            
            String db = "jdbc:odbc:db1";
            con = DriverManager.getConnection(db);
            st =  (Statement) con.createStatement();
                    } catch (Exception ex) {
        }

    }

    private void frame() {
        login.setSize(600,400);
        login.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        login.setVisible(true);
        
        JPanel p = new JPanel();
        p.add(user);
        p.add(pass);
        p.add(textfield1);
        p.add(textfield2);
        p.add(b);
        
        login.add(p);
    }
}
