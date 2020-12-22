package Model;

//Crea la clase Patient

/**
 *
 * @author lenov
 */
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

    /**
     *
     */
    public Patient() {
    }

    //Constructor de la clase Patient

    /**
     *
     * @param idPaciente
     * @param rh
     * @param gestante
     * @param sexo
     * @param etnia
     * @param comunidad
     * @param municipio
     * @param Persona_id_persona
     * @param idPersona
     * @param nombreP
     * @param apellidoP
     * @param emailP
     * @param tipoDocumentoP
     * @param numeroDocumentoP
     * @param celularP
     * @param fechaNacimientoP
     * @param ciudadOrigenP
     * @param departamentoOrigenP
     * @param direccionP
     * @param edad
     * @param programaPyDT
     */

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

    /**
     *
     * @return
     */

    public int getIdPaciente() {
        return idPaciente;
    }

    /**
     *
     * @param idPaciente
     */
    public void setIdPaciente(int idPaciente) {
        this.idPaciente = idPaciente;
    }

    /**
     *
     * @return
     */
    public String getRh() {
        return rh;
    }

    /**
     *
     * @param rh
     */
    public void setRh(String rh) {
        this.rh = rh;
    }

    /**
     *
     * @return
     */
    public boolean isGestante() {
        return gestante;
    }

    /**
     *
     * @param gestante
     */
    public void setGestante(boolean gestante) {
        this.gestante = gestante;
    }

    /**
     *
     * @return
     */
    public String getSexo() {
        return sexo;
    }

    /**
     *
     * @param sexo
     */
    public void setSexo(String sexo) {
        this.sexo = sexo;
    }

    /**
     *
     * @return
     */
    public String getEtnia() {
        return etnia;
    }

    /**
     *
     * @param etnia
     */
    public void setEtnia(String etnia) {
        this.etnia = etnia;
    }

    /**
     *
     * @return
     */
    public String getComunidad() {
        return comunidad;
    }

    /**
     *
     * @param comunidad
     */
    public void setComunidad(String comunidad) {
        this.comunidad = comunidad;
    }

    /**
     *
     * @return
     */
    public String getMunicipio() {
        return municipio;
    }

    /**
     *
     * @param municipio
     */
    public void setMunicipio(String municipio) {
        this.municipio = municipio;
    }

    /**
     *
     * @return
     */
    public int getPersona_id_persona() {
        return Persona_id_persona;
    }

    /**
     *
     * @param Persona_id_persona
     */
    public void setPersona_id_persona(int Persona_id_persona) {
        this.Persona_id_persona = Persona_id_persona;
    }

    /**
     *
     * @return
     */
    public int getIdPersona() {
        return idPersona;
    }

    /**
     *
     * @param idPersona
     */
    public void setIdPersona(int idPersona) {
        this.idPersona = idPersona;
    }

    /**
     *
     * @return
     */
    public String getNombreP() {
        return nombreP;
    }

    /**
     *
     * @param nombreP
     */
    public void setNombreP(String nombreP) {
        this.nombreP = nombreP;
    }

    /**
     *
     * @return
     */
    public String getApellidoP() {
        return apellidoP;
    }

    /**
     *
     * @param apellidoP
     */
    public void setApellidoP(String apellidoP) {
        this.apellidoP = apellidoP;
    }

    /**
     *
     * @return
     */
    public String getEmailP() {
        return emailP;
    }

    /**
     *
     * @param emailP
     */
    public void setEmailP(String emailP) {
        this.emailP = emailP;
    }

    /**
     *
     * @return
     */
    public String getTipoDocumentoP() {
        return tipoDocumentoP;
    }

    /**
     *
     * @param tipoDocumentoP
     */
    public void setTipoDocumentoP(String tipoDocumentoP) {
        this.tipoDocumentoP = tipoDocumentoP;
    }

    /**
     *
     * @return
     */
    public int getNumeroDocumentoP() {
        return numeroDocumentoP;
    }

    /**
     *
     * @param numeroDocumentoP
     */
    public void setNumeroDocumentoP(int numeroDocumentoP) {
        this.numeroDocumentoP = numeroDocumentoP;
    }

    /**
     *
     * @return
     */
    public String getCelularP() {
        return celularP;
    }

    /**
     *
     * @param celularP
     */
    public void setCelularP(String celularP) {
        this.celularP = celularP;
    }

    /**
     *
     * @return
     */
    public String getFechaNacimientoP() {
        return fechaNacimientoP;
    }

    /**
     *
     * @param fechaNacimientoP
     */
    public void setFechaNacimientoP(String fechaNacimientoP) {
        this.fechaNacimientoP = fechaNacimientoP;
    }

    /**
     *
     * @return
     */
    public String getCiudadOrigenP() {
        return ciudadOrigenP;
    }

    /**
     *
     * @param ciudadOrigenP
     */
    public void setCiudadOrigenP(String ciudadOrigenP) {
        this.ciudadOrigenP = ciudadOrigenP;
    }

    /**
     *
     * @return
     */
    public String getDepartamentoOrigenP() {
        return departamentoOrigenP;
    }

    /**
     *
     * @param departamentoOrigenP
     */
    public void setDepartamentoOrigenP(String departamentoOrigenP) {
        this.departamentoOrigenP = departamentoOrigenP;
    }

    /**
     *
     * @return
     */
    public String getDireccionP() {
        return direccionP;
    }

    /**
     *
     * @param direccionP
     */
    public void setDireccionP(String direccionP) {
        this.direccionP = direccionP;
    }

    /**
     *
     * @return
     */
    public int getEdad() {
        return edad;
    }

    /**
     *
     * @param edad
     */
    public void setEdad(int edad) {
        this.edad = edad;
    }

    /**
     *
     * @return
     */
    public String getProgramaPyDT() {
        return programaPyDT;
    }

    /**
     *
     * @param programaPyDT
     */
    public void setProgramaPyDT(String programaPyDT) {
        this.programaPyDT = programaPyDT;
    }
    
}
