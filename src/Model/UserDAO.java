package Model;

import java.sql.*;

//Crea la clase UserDAO

/**
 *
 * @author lenov
 */
public class UserDAO extends Conexion {

    //Crea las variables globales
    PreparedStatement ps, ps2;
    ResultSet rs;

    //Conexion con = new Conexion();
    Connection access;

    //Se encarga de validar que el usuario exista en la base de datos, y carga los campos seleccionados en la query
    //a las variebles de la clase User.java
    //recibe como parámetro el nombre de usuario y contraseña ingresadas en el módulo de login.

    /**
     *
     * @param username
     * @param password
     * @return
     * @throws SQLException
     */
    public User userValidator(String username, String password) throws SQLException {

        User user = new User();

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
            //Completar los demás campos del formulario con los set
            rs = ps.executeQuery();
            con.commit();

            while (rs.next()) {

                user.setId_persona(rs.getInt(1));
                user.setNombreU(rs.getString(2));
                user.setApellidoU(rs.getString(3));
                user.setEmailU(rs.getString(4));
                user.setTipoDocumentoU(rs.getString(5));
                user.setNumeroDocumentoU(rs.getInt(6));
                user.setCelularU(rs.getInt(7));
                user.setFechaNaciemientoU(rs.getString(8));
                user.setCiudadOrigenU(rs.getString(9));
                user.setDepartamentoOrigenU(rs.getString(10));
                user.setDireccionU(rs.getString(11));

                user.setIdUsuario(12);
                user.setUsername(rs.getString(13));
                user.setPassword(rs.getString(14));
                user.setCargo(rs.getString(15));
                user.setArea(rs.getString(16));
                user.setUltimaSesion(rs.getString(17));
                user.setId_empresa(rs.getInt(18));
                user.setId_tipo_usuario(rs.getInt(19));

            }
        } catch (Exception e) {
            con.rollback();
        }
        //access=(Connection) con.disconnect();
        return user;

    }

    //Este método devuelve un entero de 6 dígitos aleatoreamente, se usará para generar la contraseña del usuario que solicite
    //el cambio de contraseña en el botón de ¿Olvidó su contraseña?
    
//    int newPassword = newPassword();
//    System.out.print(newPassword);

    /**
     *
     * @return
     */

    public int newPassword() {
        double num;
        num = Math.random() * 999999 + 1;
        num = (double) Math.round(num * 100d) / 100;
        int randomPassword = (int) (num);
        return (randomPassword);
    }

}
