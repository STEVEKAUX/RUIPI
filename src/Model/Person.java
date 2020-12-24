package Model;

/**
 * <span>Descripción:</span>
 * <p>
 * Estructura la información de la Persona respecto a la "Entidad Persona" de la
 * base de datos.</p>
 *
 * @author Daniel Felipe Lozada Ramirez Email: dflozada2@misena.edu.co
 * @author Edgar Steve Pava Email: Espava60@misena.edu.co
 * @version 1.1.0
 * @since 2020
 */
public class Person {

    /**
     * Variables y constantes de la clase {@link Person}.
     *
     */
    private int idPersona = 0;
    private String nombre = "";
    private String apellido = "";
    private String email = "";
    private String tipoDocumento = "";
    private int numeroDocumento = 0;
    private int celular = 0;
    private String fechaNacimiento = "";
    private String ciudadOrigen = "";
    private String departamentoOrigen = "";
    private String direccion = "";

    /**
     * <p>
     * Método Constructor de Persona</p>
     */
    public Person() {
    }

    /**
     * <span>Descripción:</span>
     * <p>
     * Obtiene el idPersona de la Persona</p>
     *
     * @return idPersona - Retorna un int como idPersona de la Persona
     */
    public int getIdPersona() {
        return idPersona;
    }

    /**
     * <span>Descripción:</span>
     * <p>
     * Establece el idPersona de la Persona</p>
     *
     * @param idPersona Recibe un int como idPersona de la Persona
     */
    public void setIdPersona(int idPersona) {
        this.idPersona = idPersona;
    }

    /**
     * <span>Descripción:</span>
     * <p>
     * Obtiene el Nombre de la Persona</p>
     *
     * @return nombreP - Retorna un String como Nombre de la Persona
     */
    public String getNombre() {
        return nombre;
    }

    /**
     * <span>Descripción:</span>
     * <p>
     * Establece el Nombre de la Persona</p>
     *
     * @param nombre Recibe un String como Nombre de la Persona
     */
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    /**
     * <span>Descripción:</span>
     * <p>
     * Obtiene el Apellido de la Persona</p>
     *
     * @return apellidoP - Retorna un String como Apellido de la Persona
     */
    public String getApellido() {
        return apellido;
    }

    /**
     * <span>Descripción:</span>
     * <p>
     * Establece el Apellido de la Persona</p>
     *
     * @param apellido Recibe un String como Apellido de la Persona
     */
    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    /**
     * <span>Descripción:</span>
     * <p>
     * Obtiene el Email de la Persona</p>
     *
     * @return email - Retorna un String como Email de la Persona
     */
    public String getEmail() {
        return email;
    }

    /**
     * <span>Descripción:</span>
     * <p>
     * Establece el Email de la Persona</p>
     *
     * @param email Recibe un String como Email de la Persona
     */
    public void setEmail(String email) {
        this.email = email;
    }

    /**
     * <span>Descripción:</span>
     * <p>
     * Obtiene el Tipo de Documento de la Persona</p>
     *
     * @return tipoDocumento - Retorna un String como Tipo de Documento de la
     * Persona
     */
    public String getTipoDocumento() {
        return tipoDocumento;
    }

    /**
     * <span>Descripción:</span>
     * <p>
     * Establece el Tipo de Documento de la Persona</p>
     *
     * @param tipoDocumento Recibe un String como Tipo de Documento de la
     * Persona
     */
    public void setTipoDocumento(String tipoDocumento) {
        this.tipoDocumento = tipoDocumento;
    }

    /**
     * <span>Descripción:</span>
     * <p>
     * Obtiene el Número de Documento de la Persona</p>
     *
     * @return numeroDocumento - Retorna un int como Número de Documento de la
     * Persona
     */
    public int getNumeroDocumento() {
        return numeroDocumento;
    }

    /**
     * <span>Descripción:</span>
     * <p>
     * Establece el Número de Documento de la Persona</p>
     *
     * @param numeroDocumento Recibe un int como Número de Documento de la
     * Persona
     */
    public void setNumeroDocumento(int numeroDocumento) {
        this.numeroDocumento = numeroDocumento;
    }

    /**
     * <span>Descripción:</span>
     * <p>
     * Obtiene el Número de Teléfono o Celular de la Persona</p>
     *
     * @return celularP Retorna un int como Teléfono o Celular de la Persona
     */
    public int getCelular() {
        return celular;
    }

    /**
     * <span>Descripción:</span>
     * <p>
     * Establece el Número de Teléfono o Celular de la Persona</p>
     *
     * @param celular Recibe un int como Teléfono o Celular de la Persona
     */
    public void setCelular(int celular) {
        this.celular = celular;
    }

    /**
     * <span>Descripción:</span>
     * <p>
     * Obtiene la Fecha de Nacimiento de la Persona</p>
     *
     * @return fechaNacimiento - Retorna un String como Fecha de Nacimiento de
     * la Persona
     */
    public String getFechaNacimiento() {
        return fechaNacimiento;
    }

    /**
     * <span>Descripción:</span>
     * <p>
     * Establece la Fecha de Nacimiento de la Persona</p>
     *
     * @param fechaNacimiento Recibe un String como Fecha de Nacimiento de la
     * Persona
     */
    public void setFechaNacimiento(String fechaNacimiento) {
        this.fechaNacimiento = fechaNacimiento;
    }

    /**
     * <span>Descripción:</span>
     * <p>
     * Obtiene la Ciudad de Origen de la Persona</p>
     *
     * @return ciudadOrigen - Retorna un String como Ciudad de Origen de la
     * Persona
     */
    public String getCiudadOrigen() {
        return ciudadOrigen;
    }

    /**
     * <span>Descripción:</span>
     * <p>
     * Establece la Ciudad de Origen de la Persona</p>
     *
     * @param ciudadOrigen Recibe un String como Ciudad de Origen de la Persona
     */
    public void setCiudadOrigen(String ciudadOrigen) {
        this.ciudadOrigen = ciudadOrigen;
    }

    /**
     * <span>Descripción:</span>
     * <p>
     * Obtiene el Departamento de Origen de la Persona</p>
     *
     * @return departamentoOrigenP - Retorna un String como Departamento de
     * Origen de la Persona
     */
    public String getDepartamentoOrigen() {
        return departamentoOrigen;
    }

    /**
     * <span>Descripción:</span>
     * <p>
     * Establece el Departamento de Origen de la Persona</p>
     *
     * @param departamentoOrigen Recibe un String como Departamento de Origen de
     * la Persona
     */
    public void setDepartamentoOrigen(String departamentoOrigen) {
        this.departamentoOrigen = departamentoOrigen;
    }

    /**
     * <span>Descripción:</span>
     * <p>
     * Obtiene la Dirección de la Persona</p>
     *
     * @return direccion un String como Dirección de la Persona
     */
    public String getDireccion() {
        return direccion;
    }

    /**
     * <span>Descripción:</span>
     * <p>
     * Establece la Dirección de la Persona</p>
     *
     * @param direccion Recibe un String como Dirección de la Persona
     */
    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

}
