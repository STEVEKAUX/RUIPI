/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Connector;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

/**
 *
 * @author lenov
 */
public class PatientDAO {
    
    Connection conn;
    Conexion con=new Conexion();
    PreparedStatement ps;
    ResultSet rs;
    
//
//   public List toList() {
//        
//        List <Patient> listP = new ArrayList<>();
//        String query ="SELECT * FROM paciente";
//        try {
//            conn=con.getConnection();
//            ps=conn.prepareStatement(query);
//            rs=ps.executeQuery();
//            
//            while(rs.next()){
//                Patient p = new Patient();
//                p.setIdPaciente(rs.getInt(1));
//                p.setNombre(rs.getString(2));
//                
//                listP.add(p);
//                
//            }
//            
//        } catch (Exception e) {
//        }
//        
//        return listP;
//       
//    }
//
//    public void delete() {
//        
//    }
    
}
