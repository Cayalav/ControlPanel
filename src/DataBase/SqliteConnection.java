/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DataBase;

import java.sql.Connection;
import java.sql.DriverManager;
import javax.swing.JOptionPane;

/**
 *
 * @author Carlos
 */
public class SqliteConnection {
    
      Connection conn = null;

    public static Connection dbConnector() {

        try {
            Class.forName("org.sqlite.JDBC");
            Connection conn = DriverManager.getConnection("jdbc:sqlite:E:\\Documentos\\Archivos respaldo\\NetBeansProjects\\BuiildingSoft\\src\\DataBase\\RegistroEmpleados.db");
            System.out.println("Conexion establecida");
            return conn;
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
            return null;
        }

    }
    
}
