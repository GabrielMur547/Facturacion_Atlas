/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Pantallas;

/**
 *
 * @author Gmurillo
 */
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConexionMySQL {
    
    private static final String URL = "jdbc:mysql://localhost:3306/facturas";
    private static final String USUARIO = "root";
    private static final String CONTRASENA = "";
    
    private static Connection conexion = null;
    
    public static Connection obtenerConexion() throws SQLException, ClassNotFoundException {
        if (conexion == null) {
            Class.forName("com.mysql.jdbc.Driver");
            conexion = DriverManager.getConnection(URL, USUARIO, CONTRASENA);
        }
        return conexion;
    }
    
    public static void cerrarConexion() throws SQLException {
        if (conexion != null) {
            conexion.close();
            conexion = null;
        }
    }
}
