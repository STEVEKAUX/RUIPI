package Model;

import java.sql.*;

/**
 * <span>Descripción:</span>
 * <p>
 * Se encarga de generar la conexión y desconexión a la base de datos usando el
 * JDBC.</p>
 *
 * @author Daniel Felipe Lozada Ramirez Email: dflozada2@misena.edu.co
 * @author Edgar Steve Pava Email: Espava60@misena.edu.co
 * @version 1.1.0
 * @since 2020
 */
public class Conexion {

    /**
     * Variables y constantes de la clase {@link Conexion}.
     *
     */
    private static final String DBNAME = "ruipidatabase";
    private static final String USER = "root";
    private static final String PASSWORD = "dflr.com";
    private static final String URL = "jdbc:mysql://localhost/" + DBNAME + "?useUnicode=true&use"
            + "JDBCCompliantTimezoneSHift=true&useLegacyDatetimeCode=false&"
            + "serverTimezone=UTC";

    public static Connection con = null;

    /**
     * <span>Descripción:</span>
     * <p>Se encarga de construir instancias de la clase Conexion</p>
     */
    public Conexion() {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
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

    /**
     * <span>Descripción:</span>
     * <p>
     * Obtiene la conexión.</p>
     *
     * @return con - Retorna un objeto de tipo {@code Conexion} con el estado de la conexión
     */
    public Connection getConnection() {
        return con;
    }

    /**
     * <span>Descripción:</span>
     * <p>
     * Desconecta la base de datos.</p>
     *
     * @return con - Retorna un objeto de tipo {@code Conexion} con el estado de la conexión una vez ha sido terminada
     */
    public Conexion disconnect() {
        con = null;
        if (con == null) {
            System.out.println("¡Conexión Terminada!");
        }
        return (Conexion) con;
    }
}
