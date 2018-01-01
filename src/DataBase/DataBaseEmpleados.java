/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DataBase;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 *
 * @author caya
 */
public class DataBaseEmpleados {

    public static final String DB_NAME = "testjava2.db";
    public static final String CONNECTION_STRING = "jdbc:sqlite:C:\\Users\\caya\\Documents\\NetBeansProjects\\BuiildingSoft\\src\\DataBase\\" + DB_NAME;
    public static final String DATOS_EMPLEADOS = "contacts";
    public static final String COLUMN_NAME = "name";
    public static final String COLUMN_CEDULA = "cedula";
    public static final String COLUMN_PASS = "pass";
    public static final String COLUMN_FECHA = "fecha";
    public static final String COLUMN_CELULAR = "celular";
    public static final String COLUMN_CORREO = "correo";
    public static final String COLUMN_EPS = "eps";
    public static final String COLUMN_ARL = "arl";
    public static final String COLUMN_CELULAREMERGENCIA = "celularemergencia";


    
    
    
    
    public static void ejecutar() {

        try {
            Connection conn = DriverManager.getConnection(CONNECTION_STRING);
            Statement statement = conn.createStatement();

            statement.execute("DROP TABLE IF EXISTS " + DATOS_EMPLEADOS);

            statement.execute("CREATE TABLE IF NOT EXISTS " + DATOS_EMPLEADOS
                    + " (" + COLUMN_NAME + " text, "
                    + COLUMN_CEDULA + " text, "
                    + COLUMN_PASS + " text"
                    + COLUMN_ARL + " text"
                    + COLUMN_FECHA + " text"
                    + COLUMN_CELULAR + " text"
                    + COLUMN_CORREO + " text"
                    + COLUMN_EPS + " text"
                    + COLUMN_CELULAREMERGENCIA + " text"
                    + ")");

            insertContact(statement, "1", "2", "3", "4", "5", "6", "7", "8", "9");

            statement.execute("UPDATE " + DATOS_EMPLEADOS + " SET "
                    + COLUMN_CELULAR + "=5566789"
                    + " WHERE " + COLUMN_NAME + "='Jane'");

            statement.execute("DELETE FROM " + DATOS_EMPLEADOS
                    + " WHERE " + COLUMN_NAME + "='Joe'");

            ResultSet results = statement.executeQuery("SELECT * FROM " + DATOS_EMPLEADOS);
            while (results.next()) {
                System.out.println(results.getString(COLUMN_NAME) + " "
                        + results.getString(COLUMN_CELULAR) + " "
                        + results.getString(COLUMN_PASS));
            }

            results.close();

            statement.close();
            conn.close();

//            Connection conn = DriverManager.getConnection("jdbc:sqlite:D:\\databases\\testjava.db");
//            Class.forName("org.sql.JDBC");
        } catch (SQLException e) {
            System.out.println("Something went wrong: " + e.getMessage());
            e.printStackTrace();
        }
    }

    private static void insertContact(Statement statement, String name, String cedula, String pass, String fecha, String celular, String correo, String eps, String arl, String celularemergencia) throws SQLException {
        statement.execute("INSERT INTO " + DATOS_EMPLEADOS
                + " (" + COLUMN_NAME + ", "
                + COLUMN_CEDULA + ", "
                + COLUMN_PASS + ", "
                + COLUMN_FECHA + ", "
                + COLUMN_CELULAR + ", "
                + COLUMN_CORREO + ", "
                + COLUMN_EPS + ", "
                + COLUMN_ARL + ", "
                + COLUMN_CELULAREMERGENCIA
                + " ) "
                + "VALUES('" + name + "', '" + cedula + "', '" + pass + "', '" + fecha + "', '" + celular + "', '" + correo + "', '" + eps + "', '" + arl + "', '" + celularemergencia + "')");
    }
    
    
//    public static void databasecrete(String name,String cedula, String pass, String fecha, String celular, String correo, String eps, String arl, String celularemergencia) {
//       
//        
//        try {
//            Connection conn = DriverManager.getConnection("jdbc:sqlite:C:\\Users\\caya\\Documents\\NetBeansProjects\\BuiildingSoft\\src\\DataBase\\Pruenba.db");
//            conn.setAutoCommit(true);
//            Statement statemment = conn.createStatement();
//            statemment.execute("CREATE TABLE IF NOT EXISTS DatosEmpleados "
//                    + "(nombre TEXT, cedula TEXT, pass TEXT, fecha TEXT, celular TEXT,correo TEXT,eps TEXT,arl TEXT,celularemergencia TEXT)");
//            statemment.execute("INSERT INTO DatosEmpleados (nombre,cedula,pass,fecha,celular,correo,eps,arl,celularemergencia)"
//                    + "VALUES('zasCarlos',5553104322088,'zzzcayalav17@gmail.com','zasCarlos',5553104322088,'zzzcayalav17@gmail.com','zasCarlos',5553104322088,'zzzcayalav17@gmail.com')");
//            statemment.close();
//            conn.close();
//            
//        } catch (SQLException e) {
//            System.out.println("Something went wrong " + e.getMessage());
//        }
//
//        
//    }

}
