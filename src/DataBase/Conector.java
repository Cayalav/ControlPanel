/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DataBase;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

/**
 *
 * @author Carlos
 */
public class Conector {

    String url = "E:\\Documentos\\Archivos respaldo\\NetBeansProjects\\BuiildingSoft\\src\\DataBase\\RegistroEmpleados.db";
    Connection connect = null;
    ResultSet rs = null;
    PreparedStatement pst = null;

    public void connect() {
        try {
            connect = DriverManager.getConnection("jdbc:sqlite:" + url);
            if (connect != null) {
                System.out.println("Conexion establecida");
            }
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
            System.err.println("No se ha podido conectar a la base de datos\n" + ex.getMessage());
        }
    }

    public void close() {
        try {
            connect.close();
        } catch (SQLException ex) {
            Logger.getLogger(Conector.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void mostrarEmpleados() {
        ResultSet result = null;
        try {
            PreparedStatement st = connect.prepareStatement("select * from empleados");
            result = st.executeQuery();
            while (result.next()) {
                System.out.print("Nombre: ");
                System.out.println(result.getInt("Nombre"));

                System.out.print("Cedula: ");
                System.out.println(result.getString("Cedula"));

                System.out.print("Contraseña: ");
                System.out.println(result.getString("Contraseña"));

                System.out.print("Fecha de nacimiento: ");
                System.out.println(result.getString("Fecha"));

                System.out.println("Celular: ");
                System.out.println(result.getString("Celular"));

                System.out.println("Correo: ");
                System.out.println(result.getString("Correo"));

                System.out.println("EPS: ");
                System.out.println(result.getString("EPS"));

                System.out.println("ARL: ");
                System.out.println(result.getString("ARL"));

                System.out.println("Celular de emergencia: ");
                System.out.println(result.getString("CelularEmergencia"));
                
                                System.out.println("Sexo: ");
                System.out.println(result.getString("Sexo"));

                System.out.println("=======================");
            }
        } catch (SQLException ex) {
            System.err.println(ex.getMessage());
        }
    }

    public void saveEmpleado(Empleado empleado) {
        try {
            PreparedStatement st = connect.prepareStatement("insert into empleados (Nombre, Cedula,Contraseña,Fecha,Celular,Correo,EPS,ARL,CelularEmergencia,Sexo) values (?,?,?,?,?,?,?,?,?,?)");
            st.setString(1, empleado.getNombre());
            st.setString(2, empleado.getCedula());
            st.setString(3, empleado.getContraseña());
            st.setString(4, empleado.getFecha_nacimiento());
            st.setString(5, empleado.getCelular());
            st.setString(6, empleado.getCorreo());
            st.setString(7, empleado.getEps());
            st.setString(8, empleado.getArl());
            st.setString(9, empleado.getCelular_emergencia());
              st.setString(10, empleado.getSexo());
            st.execute();
        } catch (SQLException ex) {
            System.err.println(ex.getMessage());
        }

    }

    public void validacionUser(JTextField user, JTextField pass) {
        try {
            connect();
            String query = "select * from empleados where Cedula=? and Contraseña=? ";
            PreparedStatement pst = connect.prepareStatement(query);
            pst.setString(1, user.getText());
            pst.setString(2, pass.getText());

            ResultSet rs = pst.executeQuery();
            int count = 0;
            while (rs.next()) {
                count = count + 1;
            }
            if (count >= 1) {
                System.out.println("User is correct");

            } else if (count == 0) {
                System.out.println("User is incorrect");
            }
            rs.close();
            pst.close();

        } catch (Exception e) {
            System.out.println("Hay un error: " + e.getMessage());
        }

    }

}
