package buiildingsoft;

import DataBase.Conector;
import DataBase.Empleado;
import Interfaz.GUILogin;
import Interfaz.Splash;


public class BuiildingSoft {


    public static void main(String[] args) {

//        Splash ventanaSplash = new Splash();
//        ventanaSplash.setVisible(true);
        
        //databasecrete("1","2","3","4","5","6","7","8","9");
        
        Conector con = new Conector();
        con.connect();
        Empleado empleado = new Empleado("1","2","3","4","5","6","7","8","9");
        empleado.save();

        con.mostrarEmpleados();

        con.close();
    }

}
