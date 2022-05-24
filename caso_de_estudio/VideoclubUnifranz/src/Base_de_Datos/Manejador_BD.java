/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Base_de_Datos;

import com.mysql.jdbc.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author rayner
 */
public class Manejador_BD {
    //Atributos
    private final String IP = "sql10.freemysqlhosting.net";
    private final String PUERTO = "3306";
    private final String NOMBRE_BASE_DATOS = "sql10493622";
    private final String USUARIO_BASE_DATOS = "sql10493622";
    private final String password_BASE_DATOS = "I2DM1dcytb";
    private Connection conexion;
    
    //constructor
    public Manejador_BD() {
       //Paso 1
       cargarDriver();
        

    }
    
    //Metodos
    //Primer paso Cargar Driver
    public void cargarDriver() {
        try {
            Class.forName("com.mysql.jdbc.Driver");
        } catch(Exception ex) {
           // System.out.println("No se puede cargar el driver de MYSQL");
           // System.out.println("Error : " + ex.getMessage());
            JOptionPane.showMessageDialog(null, "No se puede cargar el driver de MYSQL debido a este error: " + ex.getMessage(), "Error Driver Mysql", JOptionPane.ERROR_MESSAGE);
        }
    }
    
    //Paso 2 Conectarse a la base de datos 
    public Connection conectarseBD() {
        try {
            //Conectando a la base de datos
            this.conexion = (Connection) DriverManager.getConnection("jdbc:mysql://" + this.IP + ":" + this.PUERTO + "/" + this.NOMBRE_BASE_DATOS, this.USUARIO_BASE_DATOS,this.password_BASE_DATOS);
        } catch (SQLException ex) {
            conexion = null;
            Logger.getLogger(Manejador_BD.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return conexion;
    }
    
    
    public Connection getConexion() {
        return this.conexion;
    }
    
   public void cerrarConexionBD() {
        try {
            conexion.close();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "No se puede cerrar la conexion a la base de datos: " + ex.getMessage(), "Error Cerrar Conexion BD", JOptionPane.ERROR_MESSAGE);
        }
   }
   
   
   public ResultSet consultarDB(String consultaSQL) {
       ResultSet resultado;
        try {
            Statement comando = conexion.createStatement();
            
           resultado = comando.executeQuery(consultaSQL);
        } catch (SQLException ex) {
            resultado = null;
            JOptionPane.showMessageDialog(null, "No se puede consultar a la base de datos: " + ex.getMessage(), "Error Consulta BD", JOptionPane.ERROR_MESSAGE);
        }
        
        return resultado;
 
   }
   
   public void insertarDB(String insercionSQL) {
        try {
           Statement comando = conexion.createStatement();
           comando.executeUpdate(insercionSQL);
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "No se puede insertar el registro a la base de datos: " + ex.getMessage(), "Error Insercion BD", JOptionPane.ERROR_MESSAGE);
        }
       
   }
}
