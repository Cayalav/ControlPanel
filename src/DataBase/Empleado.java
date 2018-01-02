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
public class Empleado {
    
 
    private String nombre, cedula, contraseña, fecha_nacimiento,celular,correo,eps,arl,celular_emergencia;

    public Empleado(String nombre, String cedula, String contraseña, String fecha_nacimiento, String celular, String correo, String eps, String arl, String celular_emergencia) {
        this.nombre = nombre;
        this.cedula = cedula;
        this.contraseña = contraseña;
        this.fecha_nacimiento = fecha_nacimiento;
        this.celular = celular;
        this.correo = correo;
        this.eps = eps;
        this.arl = arl;
        this.celular_emergencia = celular_emergencia;
    }

        public void save(){
        Conector con = new Conector();
        con.connect();
        con.saveEmpleado(this);
        con.close();
    }
    
    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getCedula() {
        return cedula;
    }

    public void setCedula(String cedula) {
        this.cedula = cedula;
    }

    public String getContraseña() {
        return contraseña;
    }

    public void setContraseña(String contraseña) {
        this.contraseña = contraseña;
    }

    public String getFecha_nacimiento() {
        return fecha_nacimiento;
    }

    public void setFecha_nacimiento(String fecha_nacimiento) {
        this.fecha_nacimiento = fecha_nacimiento;
    }

    public String getCelular() {
        return celular;
    }

    public void setCelular(String celular) {
        this.celular = celular;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public String getEps() {
        return eps;
    }

    public void setEps(String eps) {
        this.eps = eps;
    }

    public String getArl() {
        return arl;
    }

    public void setArl(String arl) {
        this.arl = arl;
    }

    public String getCelular_emergencia() {
        return celular_emergencia;
    }

    public void setCelular_emergencia(String celular_emergencia) {
        this.celular_emergencia = celular_emergencia;
    }

    

}
