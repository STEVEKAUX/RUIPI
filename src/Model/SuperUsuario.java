
package Model;

//Declaración de la subclase Superusuario que extiende de Usuario
public class SuperUsuario extends Usuario {
    
    
    //Declaración de variables de Superusuario
    private int idSuperusuario;
    
    
    //Constructor de Superusuario

    public SuperUsuario(int idSuperusuario, int idPersona, String nombre, String apellido, 
            String fechaNacimiento, String ciudadNacimiento, String departamentoNacimiento, 
            String direccion, String tipoDocumento, int numeroDocumento, String email, String sexo) {
        
        super(idPersona, nombre, apellido, fechaNacimiento, ciudadNacimiento, 
                departamentoNacimiento, direccion, tipoDocumento, numeroDocumento, email, sexo);
        this.idSuperusuario = idSuperusuario;
    }

    
    
    
    //Getters y Setters
    public int getIdSuperusuario() {
    return idSuperusuario;
    }

    /*public void setIdSuperusuario(int idSuperusuario) {
        this.idSuperusuario = idSuperusuario;
    }*/
    
}

