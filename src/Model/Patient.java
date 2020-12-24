package Model;

/**
 * <span>Descripción:</span>
 * <p>
 * Extiende de {@link Person}. Estructura la información del Paciente respecto a la "Entidad Paciente" de la
 * base de datos.</p>
 *
 * @author Daniel Felipe Lozada Ramirez Email: dflozada2@misena.edu.co
 * @author Edgar Steve Pava Email: Espava60@misena.edu.co
 * @version 1.1.0
 * @since 2020
 */
public class Patient extends Person{

    /**
     * Variables y constantes de la clase {@link Patient}.
     *
     */
    private int idPaciente;
    private String rh;
    private String gestante;
    private String sexo;
    private String etnia;
    private String comunidad;
    private String municipio;
    private int Persona_id_persona;
    private String programaPyDT;

    private int edad;

    /**
     * <p>
     * Método Constructor de Patient</p>
     */
    public Patient() {
        super();
    }

    /**
     * <span>Descripción:</span>
     * <p>
     * Obtiene el ID del Paciente</p>
     *
     * @return idPaciente - Retorna un int como ID del Paciente
     */
    public int getIdPaciente() {
        return idPaciente;
    }

    /**
     * <span>Descripción:</span>
     * <p>
     * Establece el ID del Paciente</p>
     *
     * @param idPaciente Recibe un int como ID del Paciente
     */
    public void setIdPaciente(int idPaciente) {
        this.idPaciente = idPaciente;
    }

    /**
     * <span>Descripción:</span>
     * <p>
     * Obtiene el RH del Paciente</p>
     *
     * @return rh - Retorna un String como RH del Paciente
     */
    public String getRh() {
        return rh;
    }

    /**
     * <span>Descripción:</span>
     * <p>
     * Establece el RH del Paciente</p>
     *
     * @param rh Recibe un String como RH del Paciente
     */
    public void setRh(String rh) {
        this.rh = rh;
    }

    /**
     * <span>Descripción:</span>
     * <p>
     * Obtiene el dato del Paciente correspondiente si está en Gestación</p>
     *
     * @return gestante - Retorna un String que indica si el Paciente es
     * Gestante
     */
    public String getGestante() {
        return gestante;
    }

    /**
     * <span>Descripción:</span>
     * <p>
     * Establece el dato del Paciente correspondiente si está en Gestación</p>
     *
     * @param gestante Recibe un String que indica si el Paciente es Gestante
     */
    public void setGestante(String gestante) {
        this.gestante = gestante;
    }

    /**
     * <span>Descripción:</span>
     * <p>
     * Obtiene el Sexo del Paciente</p>
     *
     * @return sexo - Retorna un String como Sexo del Paciente
     */
    public String getSexo() {
        return sexo;
    }

    /**
     * <span>Descripción:</span>
     * <p>
     * Establece el Sexo del Paciente</p>
     *
     * @param sexo Recibe un String como Sexo del Paciente
     */
    public void setSexo(String sexo) {
        this.sexo = sexo;
    }

    /**
     * <span>Descripción:</span>
     * <p>
     * Obtiene la Etnia del Paciente</p>
     *
     * @return etnia Retorna un String como Etnia a la cual pertenece el
     * Paciente
     */
    public String getEtnia() {
        return etnia;
    }

    /**
     * <span>Descripción:</span>
     * <p>
     * Establece la Etnia del Paciente</p>
     *
     * @param etnia Recibe un String como Etnia a la cual pertenece el Paciente
     */
    public void setEtnia(String etnia) {
        this.etnia = etnia;
    }

    /**
     * <span>Descripción:</span>
     * <p>
     * Obtiene la Comunidad del Paciente</p>
     *
     * @return comunidad - Retorna un String como Comunidad a la cual pertenece
     * el Paciente
     */
    public String getComunidad() {
        return comunidad;
    }

    /**
     * <span>Descripción:</span>
     * <p>
     * Establece la Comunidad del Paciente</p>
     *
     * @param comunidad Recibe un String como Comunidad a la cual pertenece el
     * Paciente
     */
    public void setComunidad(String comunidad) {
        this.comunidad = comunidad;
    }

    /**
     * <span>Descripción:</span>
     * <p>
     * Obtiene el Municipio del Paciente</p>
     *
     * @return municipio- Retorna un String como Municipio a la cual pertenece
     * el Paciente
     */
    public String getMunicipio() {
        return municipio;
    }

    /**
     * <span>Descripción:</span>
     * <p>
     * Establece el Municipio del Paciente</p>
     *
     * @param municipio Recibe un String como Municipio a la cual pertenece el
     * Paciente
     */
    public void setMunicipio(String municipio) {
        this.municipio = municipio;
    }

    /**
     * <span>Descripción:</span>
     * <p>
     * Obtiene el ID que relaciona Las entidades Paciente y Persona en la Base
     * de Datos</p>
     *
     * @return Persona_id_persona - Retorna un int como el ID que relaciona Las
     * entidades Paciente y Persona en la Base de Datos
     */
    public int getPersona_id_persona() {
        return Persona_id_persona;
    }

    /**
     * <span>Descripción:</span>
     * <p>
     * Establece el ID que relaciona Las entidades Paciente y Persona en la Base
     * de Datos</p>
     *
     * @param Persona_id_persona Recibe un int como el ID que relaciona Las
     * entidades Paciente y Persona en la Base de Datos
     */
    public void setPersona_id_persona(int Persona_id_persona) {
        this.Persona_id_persona = Persona_id_persona;
    }

    /**
     * <span>Descripción:</span>
     * <p>
     * Obtiene la Edad del Paciente</p>
     *
     * @return edad - Retorna un int como Edad del Paciente
     */
    public int getEdad() {
        return edad;
    }

    /**
     * <span>Descripción:</span>
     * <p>
     * Establece la Edad del Paciente</p>
     *
     * @param edad Recibe un int como Edad del Paciente
     */
    public void setEdad(int edad) {
        this.edad = edad;
    }

    /**
     * <span>Descripción:</span>
     * <p>
     * Obtiene el Programa de Prevención y Detección Temprana de Enfermedades al
     * que tiene acceso el Paciente</p>
     *
     * @return programaPyDT -Retorna un un String como Programa de Prevención y
     * Detección Temprana de enfermedades al que tiene acceso el Paciente
     */
    public String getProgramaPyDT() {
        return programaPyDT;
    }

    /**
     * <span>Descripción:</span>
     * <p>
     * Establece el Programa de Prevención y Detección Temprana de Enfermedades al
     * que tiene acceso el Paciente</p>
     * 
     * @param programaPyDT Recibe un String como Programa de Prevención y
     * Detección Temprana de enfermedades al que tiene acceso el Paciente
     */
    public void setProgramaPyDT(String programaPyDT) {
        this.programaPyDT = programaPyDT;
    }

}
