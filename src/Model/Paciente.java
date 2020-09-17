
package Model;

//Declaración de la subclase Paciente que extiende de Persona
public class Paciente extends Persona {
    
    //Declaración de variables de Paciente
    private int idPaciente;
    private String rh;
    private boolean gestante;
    private String raza;
    private String etnia;
    private String anteEHeredada;
    private String medActual;
    private String fechaPaciente;
    private String observaciones;
    
    
    //Constructor de la clase
    public Paciente(int idPersona, String nombre, String apellido, String fechaNacimiento,
           String ciudadNacimiento, String departamentoNacimiento, String direccion, String tipoDocumento, 
           int numeroDocumento, String email, String sexo) {
        
        super(idPersona, nombre, apellido, fechaNacimiento, ciudadNacimiento, departamentoNacimiento,
                direccion, tipoDocumento, numeroDocumento, email, sexo);
    }
    
    
     
    
    //método abstracto heredado
    @Override
    public void modificarDatos(){
        
    }
    
    //Setters y Getters
    public int getIdPaciente() {
        return idPaciente;
    }

    /**public void setIdPaciente(int idPaciente) {
        this.idPaciente = idPaciente;
    }**/

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

    public String getRaza() {
        return raza;
    }

    public void setRaza(String raza) {
        this.raza = raza;
    }

    public String getEtnia() {
        return etnia;
    }

    public void setEtnia(String etnia) {
        this.etnia = etnia;
    }

    public String getAnteEHeredada() {
        return anteEHeredada;
    }

    public void setAnteEHeredada(String anteEHeredada) {
        this.anteEHeredada = anteEHeredada;
    }

    public String getMedActual() {
        return medActual;
    }

    public void setMedActual(String medActual) {
        this.medActual = medActual;
    }

    public String getFechaPaciente() {
        return fechaPaciente;
    }

    public void setFechaPaciente(String fechaPaciente) {
        this.fechaPaciente = fechaPaciente;
    }

    public String getObservaciones() {
        return observaciones;
    }

    public void setObservaciones(String observaciones) {
        this.observaciones = observaciones;
    }
    
    
}
