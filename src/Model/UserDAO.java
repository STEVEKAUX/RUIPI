package Model;

import View.LoginUI;
import java.sql.*;

/**
 * <span>Descripción:</span>
 * <p>
 * Extiende de {@link Conexion}. Este tipo de clase Data Access Object (DAO)
 * representa la capa de acceso a los datos de la "Entidad Usuario" realizando
 * las consultas a la base de datos.</p>
 *
 * @author Daniel Felipe Lozada Ramirez Email: dflozada2@misena.edu.co
 * @author Edgar Steve Pava Email: Espava60@misena.edu.co
 * @version 1.1.0
 * @since 2020
 */
public class UserDAO extends Conexion {

    /**
     * Variables y constantes de la clase {@link PatientDAO}.
     *
     */
    PreparedStatement ps, ps2;
    ResultSet rs;

    Connection access;

    /**
     * <span>Descripción:</span>
     * <p>
     * Se encarga de validar que el usuario exista en la base de datos y carga
     * los campos seleccionados en la query a los atributos de la clase
     * {@link User}
     * </p>
     *
     * @param username Recibe un String como el Nombre de Usuario ingresado por
     * el Usuario en el módulo {@link LoginUI}
     * @param password Recibe un String como la Contraseña ingresado por el
     * Usuario en el módulo {@link LoginUI}
     * @return u - Retorna un Objeto de tipo User
     * @throws SQLException
     */
    public User userValidator(String username, String password) throws SQLException {

        User u = new User();

        String query = "SELECT pe.id_persona, pe.nombre, pe.apellido, pe.email, pe.tipo_documento, pe.numero_documento,"
                + "pe.celular, pe.fecha_nacimiento, pe.ciudad_origen, pe.departamento_origen, pe.direccion,"
                + "u.id_usuario, u.username, u.password, u.cargo, u.area, u.ultima_sesion, u.id_persona,"
                + "u.id_empresa, u.id_tipo_usuario "
                + "FROM Persona AS pe INNER JOIN Usuario AS u ON pe.id_persona=u.id_persona"
                + " WHERE password=? AND username=?";
        try {
            access = getConnection();
            ps = access.prepareStatement(query);
            ps.setString(1, password);
            ps.setString(2, username);
            rs = ps.executeQuery();
            con.commit();

            while (rs.next()) {

                u.setIdPersona(rs.getInt(1));
                u.setNombre(rs.getString(2));
                u.setApellido(rs.getString(3));
                u.setEmail(rs.getString(4));
                u.setTipoDocumento(rs.getString(5));
                u.setNumeroDocumento(rs.getInt(6));
                u.setCelular(rs.getInt(7));
                u.setFechaNacimiento(rs.getString(8));
                u.setCiudadOrigen(rs.getString(9));
                u.setDepartamentoOrigen(rs.getString(10));
                u.setDireccion(rs.getString(11));

                u.setIdUsuario(12);
                u.setUsername(rs.getString(13));
                u.setPassword(rs.getString(14));
                u.setCargo(rs.getString(15));
                u.setArea(rs.getString(16));
                u.setUltimaSesion(rs.getString(17));
                u.setId_empresa(rs.getInt(18));
                u.setId_tipo_usuario(rs.getInt(19));

            }
        } catch (Exception e) {
            con.rollback();
        }
        return u;

    }

    /**
     * Este método devuelve un entero de 6 dígitos aleatoreamente, se usará para
     * generar la contraseña del usuario que solicite el cambio de contraseña en
     * el botón de ¿Olvidó su contraseña?. Su uso se puede probar de la
     * siguiente forma: * {@code int newPassword = newPassword();
     * System.out.print(newPassword);}
     *
     * @return randomPassword - Retorna un int como La Nueva Contraseña de 6
     * dígitos generada para reemplazarla Contrasela olvidada por el Usuario
     */
    public int newPassword() {
        double num;
        num = Math.random() * 999999 + 1;
        num = (double) Math.round(num * 100d) / 100;
        int randomPassword = (int) (num);
        return (randomPassword);
    }

}
