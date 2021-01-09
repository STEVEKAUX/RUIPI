package Model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

/**
 * <span>Descripción:</span>
 * <p>
 * Extiende de {@link Conexion}. Este tipo de clase Data Access Object (DAO)
 * representa la capa de acceso a los datos de la "Entidad Paciente" realizando
 * las consultas a la base de datos.</p>
 *
 * @author Daniel Felipe Lozada Ramirez Email: dflozada2@misena.edu.co
 * @author Edgar Steve Pava Email: Espava60@misena.edu.co
 * @version 1.1.0
 * @since 2020
 */
public class PatientDAO extends Conexion {

    /**
     * Variables y constantes de la clase {@link PatientDAO}.
     *
     */
   
    Connection conn;

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
