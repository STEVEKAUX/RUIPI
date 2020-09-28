
package Connector;

import java.sql.*;


public class Conexion {
	private static final String DBNAME="ruipidatabase";
	private static final String USER="root";
	private static final  String PASSWORD="dflr.com";
	private static final  String URL="jdbc:mysql://localhost/"+DBNAME+"?useUnicode=true&use"
                +"JDBCCompliantTimezoneSHift=true&useLegacyDatetimeCode=false&"
                +"serverTimezone=UTC";

	Connection con=null;
	//Constructor de la clase
	public Conexion(){
		try {
			//Obtener el driver
			Class.forName("com.mysql.cj.jdbc.Driver");
			//Obtener la conexion
			con=DriverManager.getConnection(URL,USER,PASSWORD);
			if (con!=null) {
				System.out.println("¡Conexión Exitosa a : "+DBNAME+"!");
			}
		} catch (ClassNotFoundException e) {
			System.out.println("¡Ocurre una ClassNotFoundException : "+e.getMessage()+"!");
		} catch (SQLException e) {
			System.out.println("¡Ocurre una SQLException: "+e.getMessage()+"!");
		}
	}
	public Connection getConnection(){
		return con;
	}
	public Conexion disconnect(){
            con=null;
		if(con==null){
                    System.out.println("¡Conexión Terminada!");   
                }
            return (Conexion) con;
	}
}



