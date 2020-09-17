
package Model;

//Declaración de la Superclase Persona
public abstract class Persona {
    
    //Declaración de variables de Persona
    private int idPersona;
    private String nombre;
    private String apellido;
    private String fechaNacimiento;
    private String ciudadNacimiento;
    private String departamentoNacimiento;
    private String direccion;
    private String tipoDocumento;
    private int numeroDocumento;
    private String email;
    private String sexo;
    
    
    //Constructor de la clase Persona
    public Persona(int idPersona, String nombre, String apellido, String fechaNacimiento,
           String ciudadNacimiento, String departamentoNacimiento, String direccion, String tipoDocumento,
           int numeroDocumento, String email, String sexo) {
        this.idPersona = idPersona;
        this.nombre = nombre;
        this.apellido = apellido;
        this.fechaNacimiento = fechaNacimiento;
        this.ciudadNacimiento = ciudadNacimiento;
        this.departamentoNacimiento = departamentoNacimiento;
        this.direccion = direccion;
        this.tipoDocumento = tipoDocumento;
        this.numeroDocumento = numeroDocumento;
        this.email = email;
        this.sexo = sexo;
    }
    
    
    //Método abstracto
    public  abstract void modificarDatos();
    
    
    //Setters y Getters
    public int getIdPersona() {
        return idPersona;
    }

    /**public void setIdPersona(int idPersona) {
        this.idPersona = idPersona;
    }**/

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getFechaNacimiento() {
        return fechaNacimiento;
    }

    public void setFechaNacimiento(String fechaNacimiento) {
        this.fechaNacimiento = fechaNacimiento;
    }

    public String getCiudadNacimiento() {
        return ciudadNacimiento;
    }

    public void setCiudadNacimiento(String ciudadNacimiento) {
        this.ciudadNacimiento = ciudadNacimiento;
    }

    public String getDepartamentoNacimiento() {
        return departamentoNacimiento;
    }

    public void setDepartamentoNacimiento(String departamentoNacimiento) {
        this.departamentoNacimiento = departamentoNacimiento;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getTipoDocumento() {
        return tipoDocumento;
    }

    public void setTipoDocumento(String tipoDocumento) {
        this.tipoDocumento = tipoDocumento;
    }

    public int getNumeroDocumento() {
        return numeroDocumento;
    }

    public void setNumeroDocumento(int numeroDocumento) {
        this.numeroDocumento = numeroDocumento;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getSexo() {
        return sexo;
    }

    public void setSexo(String sexo) {
        this.sexo = sexo;
    }
    
}
