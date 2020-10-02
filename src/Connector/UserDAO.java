/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Connector;

import Model.User;
import java.sql.*;

/**
 *
 * @author lenov
 */
public class UserDAO {
    
    PreparedStatement ps;
    ResultSet rs;
    
    
    Conexion con=new Conexion();
    Connection access;
    
    
    public User validarUsuario(String username, String password){
        
        User user = new User();
        
        String query="SELECT * FROM Usuario WHERE password=? and username=?";
        
        try {
            access=con.getConnection();
            ps=access.prepareStatement(query);
            ps.setString(1, username);
             ps.setString(2, password);
            rs=ps.executeQuery();
            
            while(rs.next()){
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
                user.setIdEmpresa(rs.getString(11));
                user.setIdTipoUsuario(rs.getInt(11));
                
            }
        } catch (Exception e) {
        }
        //access=(Connection) con.disconnect();
        return user;
    
}
    
}
