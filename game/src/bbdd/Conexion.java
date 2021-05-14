package bbdd;

import java.sql.*;
import javax.swing.JOptionPane;

public class Conexion {

	static String timeZone = "?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC";
    static String dbName = "proyectoprogramacion3t";
    static String url = "jdbc:mysql://localhost:3306/" + dbName + timeZone;
    static String user = "root";
    static String pass = "mariajose";
    static String driver = "com.mysql.cj.jdbc.Driver";
        
    static Connection conexion;
    static Statement consulta;
    static ResultSet resultado;
        
    public static void conectar() {
        try {
            Class.forName(driver);
            conexion = DriverManager.getConnection(url, user, pass);
            System.out.println("Base de datos situada en :\n "+url);
            consulta = conexion.createStatement();
        } catch(Exception e) {
            e.printStackTrace();
        }
    }
        
    public static ResultSet ejecutarSentencia(String Sentencia) {
        try {
            resultado = consulta.executeQuery(Sentencia);
        } catch(Exception e) {
        	e.printStackTrace();
        }
        return resultado;
    }
          
    public static void ejecutarUpdate(String Sentencia) {
        try {
            consulta.executeUpdate(Sentencia);
            System.out.println("Hecho.");
        } catch(SQLException e) {
        	e.printStackTrace();
        } 
    }
        
    public static void cerrarConexion() {
        try {
            consulta.close();
        } catch(Exception e) {
        	e.printStackTrace();
        }
    }
	
}
