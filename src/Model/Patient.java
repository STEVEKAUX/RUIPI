package Model;

//Crea la clase Patient
public class Patient {

    //Declaración de variables de la clase Patient
    private int idPaciente;
    private String rh;
    private boolean gestante;
    private String sexo;
    private String etnia;
    private String comunidad;
    private String municipio;
    private int Persona_id_persona;
    
    private int idPersona;
    private String nombreP;
    private String apellidoP;
    private String emailP;
    private String tipoDocumentoP;
    private int numeroDocumentoP;
    private String celularP;
    private String fechaNacimientoP;
    private String ciudadOrigenP;
    private String departamentoOrigenP;
    private String direccionP;
    private String programaPyDT;
    
    private int edad;
   

    //Constructor vacío de la clase Patient
    public Patient() {
    }

    //Constructor de la clase Patient

    public Patient(int idPaciente, String rh, boolean gestante, String sexo, String etnia,
            String comunidad, String municipio, int Persona_id_persona, int idPersona, String nombreP,
            String apellidoP, String emailP, String tipoDocumentoP, int numeroDocumentoP, String celularP,
            String fechaNacimientoP, String ciudadOrigenP, String departamentoOrigenP, String direccionP,
            int edad, String programaPyDT) {
        
        this.idPaciente = idPaciente;
        this.rh = rh;
        this.gestante = gestante;
        this.sexo = sexo;
        this.etnia = etnia;
        this.comunidad = comunidad;
        this.municipio = municipio;
        this.Persona_id_persona = Persona_id_persona;
        this.idPersona = idPersona;
        this.nombreP = nombreP;
        this.apellidoP = apellidoP;
        this.emailP = emailP;
        this.tipoDocumentoP = tipoDocumentoP;
        this.numeroDocumentoP = numeroDocumentoP;
        this.celularP = celularP;
        this.fechaNacimientoP = fechaNacimientoP;
        this.ciudadOrigenP = ciudadOrigenP;
        this.departamentoOrigenP = departamentoOrigenP;
        this.direccionP = direccionP;
        this.edad = edad;
        this.programaPyDT = programaPyDT;
    }
   
    //Setters y Getteres

    public int getIdPaciente() {
        return idPaciente;
    }

    public void setIdPaciente(int idPaciente) {
        this.idPaciente = idPaciente;
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

    public String getSexo() {
        return sexo;
    }

    public void setSexo(String sexo) {
        this.sexo = sexo;
    }

    public String getEtnia() {
        return etnia;
    }

    public void setEtnia(String etnia) {
        this.etnia = etnia;
    }

    public String getComunidad() {
        return comunidad;
    }

    public void setComunidad(String comunidad) {
        this.comunidad = comunidad;
    }

    public String getMunicipio() {
        return municipio;
    }

    public void setMunicipio(String municipio) {
        this.municipio = municipio;
    }

    public int getPersona_id_persona() {
        return Persona_id_persona;
    }

    public void setPersona_id_persona(int Persona_id_persona) {
        this.Persona_id_persona = Persona_id_persona;
    }

    public int getIdPersona() {
        return idPersona;
    }

    public void setIdPersona(int idPersona) {
        this.idPersona = idPersona;
    }

    public String getNombreP() {
        return nombreP;
    }

    public void setNombreP(String nombreP) {
        this.nombreP = nombreP;
    }

    public String getApellidoP() {
        return apellidoP;
    }

    public void setApellidoP(String apellidoP) {
        this.apellidoP = apellidoP;
    }

    public String getEmailP() {
        return emailP;
    }

    public void setEmailP(String emailP) {
        this.emailP = emailP;
    }

    public String getTipoDocumentoP() {
        return tipoDocumentoP;
    }

    public void setTipoDocumentoP(String tipoDocumentoP) {
        this.tipoDocumentoP = tipoDocumentoP;
    }

    public int getNumeroDocumentoP() {
        return numeroDocumentoP;
    }

    public void setNumeroDocumentoP(int numeroDocumentoP) {
        this.numeroDocumentoP = numeroDocumentoP;
    }

    public String getCelularP() {
        return celularP;
    }

    public void setCelularP(String celularP) {
        this.celularP = celularP;
    }

    public String getFechaNacimientoP() {
        return fechaNacimientoP;
    }

    public void setFechaNacimientoP(String fechaNacimientoP) {
        this.fechaNacimientoP = fechaNacimientoP;
    }

    public String getCiudadOrigenP() {
        return ciudadOrigenP;
    }

    public void setCiudadOrigenP(String ciudadOrigenP) {
        this.ciudadOrigenP = ciudadOrigenP;
    }

    public String getDepartamentoOrigenP() {
        return departamentoOrigenP;
    }

    public void setDepartamentoOrigenP(String departamentoOrigenP) {
        this.departamentoOrigenP = departamentoOrigenP;
    }

    public String getDireccionP() {
        return direccionP;
    }

    public void setDireccionP(String direccionP) {
        this.direccionP = direccionP;
    }

    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }

    public String getProgramaPyDT() {
        return programaPyDT;
    }

    public void setProgramaPyDT(String programaPyDT) {
        this.programaPyDT = programaPyDT;
    }
    
}
