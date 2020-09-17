
package Model;

//Declaración de la subclase Usuario que extiende de Persona
public class Usuario extends Persona {
      
    
    //Declaración de variables de Usuario
    private int idUsuario;
    private String username;
    private String password;
    private String cargo ;
    private String area;
    private String ultimaSesion;
    private String fechaUsuario;
    private int idTipoUsuario;
   
    
    //Constructor de la clase Usuario
    public Usuario(int idPersona, String nombre, String apellido, String fechaNacimiento,
           String ciudadNacimiento, String departamentoNacimiento, String direccion, String tipoDocumento,
           int numeroDocumento, String email, String sexo) {
        
        super(idPersona, nombre, apellido, fechaNacimiento, ciudadNacimiento, departamentoNacimiento,
                direccion, tipoDocumento, numeroDocumento, email, sexo);
    }

    //método abstracto heredado
     @Override
    public void modificarDatos() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    
    
    //Setters y Getters
    public int getIdUsuario() {
        return idUsuario;
    }

    /**public void setIdUsuario(int idUsuario) {
        this.idUsuario = idUsuario;
    }**/

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getCargo() {
        return cargo;
    }

    public void setCargo(String cargo) {
        this.cargo = cargo;
    }

    public String getArea() {
        return area;
    }

    public void setArea(String area) {
        this.area = area;
    }

    public String getUltimaSesion() {
        return ultimaSesion;
    }

    public void setUltimaSesion(String ultimaSesion) {
        this.ultimaSesion = ultimaSesion;
    }

    public String getFechaUsuario() {
        return fechaUsuario;
    }

    public void setFechaUsuario(String fechaUsuario) {
        this.fechaUsuario = fechaUsuario;
    }

    public int getIdTipoUsuario() {
        return idTipoUsuario;
    }

    public void setIdTipoUsuario(int idTipoUsuario) {
        this.idTipoUsuario = idTipoUsuario;
    }

   
    
}
