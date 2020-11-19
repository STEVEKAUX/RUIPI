package Model;

//Crea la clase Patient
public class Patient {

    //Declaración de variables de la clase Patient
    private int idPaciente;
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
    private String rh;
    private boolean gestante;
    private int edad;
    private String etnia;
    private String fechaPaciente;

    //Constructor vacío de la clase Patient
    public Patient() {
    }

    //Constructor de la clase Patient
    public Patient(int idPaciente, String nombre, String apellido, String fechaNacimiento, String ciudadNacimiento,
            String departamentoNacimiento, String direccion, String tipoDocumento, int numeroDocumento,
            String email, String sexo, String rh, boolean gestante, int edad, String etnia,
            String anteEHeredada, String medActual, String fechaPaciente) {
        this.idPaciente = idPaciente;
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
        this.rh = rh;
        this.gestante = gestante;
        this.edad = edad;
        this.etnia = etnia;
        this.fechaPaciente = fechaPaciente;
    }

    //Setters y Getters
    public int getIdPaciente() {
        return idPaciente;
    }

    public void setIdPaciente(int idPaciente) {
        this.idPaciente = idPaciente;
    }

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

    public String getRh() {
        return rh;
    }

    public void setRh(String rh) {
        this.rh = rh;
    }

    public boolean isGestante() {
        return gestante;
    }

    public void setGestante(boolean gestante) {
        this.gestante = gestante;
    }

    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }

    public String getEtnia() {
        return etnia;
    }

    public void setEtnia(String etnia) {
        this.etnia = etnia;
    }

    public String getFechaPaciente() {
        return fechaPaciente;
    }

    public void setFechaPaciente(String fechaPaciente) {
        this.fechaPaciente = fechaPaciente;
    }
    
}
