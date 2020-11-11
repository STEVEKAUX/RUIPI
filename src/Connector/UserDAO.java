/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Connector;

import Model.User;
import java.sql.*;

//Crea la clase UserDAO
public class UserDAO {

    //Crea las variables globales
    PreparedStatement ps;
    ResultSet rs;

    Conexion con = new Conexion();
    Connection access;

    //Se encarga de validar que el usuario exista en la base de datos, y carga los campos seleccionados en la query
    //a las variebles de la clase User.java
    //recibe como parámetro el nombre de usuario y contraseña ingresadas en el módulo de login.
    public User userValidator(String username, String password) {

        User user = new User();

        String query = "SELECT id_usuario, nombre_usuario, apellidos_usuario, username, password, email_usuario, cargo, area, "
                + "ultima_sesion, fecha_usuario, id_empresa, idtipo_usuario FROM Usuario WHERE password=? and username=?";

        try {
            access = con.getConnection();
            ps = access.prepareStatement(query);
            ps.setString(1, password);
            ps.setString(2, username);

            rs = ps.executeQuery();

            while (rs.next()) {
                user.setIdTipoUsuario(rs.getInt(1));
                user.setNombreUsuario(rs.getString(2));
                user.setApellidoUsuario(rs.getString(3));
                user.setUsername(rs.getString(4));
                user.setPassword(rs.getString(5));
                user.setEmailUsuario(rs.getString(6));
                user.setCargo(rs.getString(7));
                user.setArea(rs.getString(8));
                user.setUltimaSesion(rs.getString(9));
                user.setFechaUsuario(rs.getString(10));
                user.setIdEmpresa(rs.getInt(11));
                user.setIdTipoUsuario(rs.getInt(12));

            }
        } catch (Exception e) {
        }
        //access=(Connection) con.disconnect();
        return user;

    }

}
