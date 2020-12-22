package Model;

import java.sql.*;

//Crea la clase Conexion

/**
 *
 * @author lenov
 */
public class Conexion {
    //Declara las constantes de la clase

    private static final String DBNAME = "ruipidatabase";
    private static final String USER = "root";
    private static final String PASSWORD = "dflr.com";
    private static final String URL = "jdbc:mysql://localhost/" + DBNAME + "?useUnicode=true&use"
            + "JDBCCompliantTimezoneSHift=true&useLegacyDatetimeCode=false&"
            + "serverTimezone=UTC";

    /**
     *
     */
    public static Connection con = null;
    //Constructor de la clase

    /**
     *
     */
    public Conexion() {
        try {
            //Obtener el driver
            Class.forName("com.mysql.cj.jdbc.Driver");
            //Obtener la conexion
            con = DriverManager.getConnection(URL, USER, PASSWORD);
            if (con != null) {
                System.out.println("¡Conexión Exitosa a : " + DBNAME + "!");
                con.setAutoCommit(false);
            }
        } catch (ClassNotFoundException e) {
            System.out.println("¡Ocurre una ClassNotFoundException : " + e.getMessage() + "!");
        } catch (SQLException e) {
            System.out.println("¡Ocurre una SQLException: " + e.getMessage() + "!");
        }
    }
    //Obtiene la conexión

    /**
     *
     * @return
     */
    public Connection getConnection() {
        return con;
    }
    //Desconecta la base de datos

    /**
     *
     * @return
     */
    public Conexion disconnect() {
        con = null;
        if (con == null) {
            System.out.println("¡Conexión Terminada!");
        }
        return (Conexion) con;
    }
}
