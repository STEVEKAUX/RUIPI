package Model;

/**
 * <span>Descripción:</span>
 * <p>
 * Estructura la información de la Empresa respecto a la "Entidad Empresa" de la
 * base de datos.</p>
 *
 * @author Daniel Felipe Lozada Ramirez Email: dflozada2@misena.edu.co
 * @author Edgar Steve Pava Email: Espava60@misena.edu.co
 * @version 1.1.0
 * @since 2020
 */
public class Enterprise {

    /**
     * Variables y constantes de la clase {@link Enterprise}.
     *
     */
    private int idEmpresa;
    private int nit;
    private String nombreEmpresa;
    private String direccionEmpresa;
    private String ciudadEmpresa;
    private String departamentoEmpresa;
    private int telefonoEmpresa;
    private String url;
    private String emailEmpresa;

    /**
     * <p>
     * Método Constructor de Enterprise</p>
     *
     */
    public Enterprise() {

    }

    /**
     * <span>Descripción:</span>
     * <p>
     * Obtiene el ID de la Empresa</p>
     *
     * @return idEmpresa - Retorna un int como ID de la Empresa
     */
    public int getIdEmpresa() {
        return idEmpresa;
    }

    /**
     * <span>Descripción:</span>
     * <p>
     * Establece el ID de la Empresa</p>
     *
     * @param idEmpresa Recibe un int como ID de la Empresa
     */
    public void setIdEmpresa(int idEmpresa) {
        this.idEmpresa = idEmpresa;
    }

    /**
     * <span>Descripción:</span>
     * <p>
     * Obtiene el NIT de la Empresa</p>
     *
     * @return nit - Retorna un int como NIT de la Empresa
     */
    public int getNit() {
        return nit;
    }

    /**
     * <span>Descripción:</span>
     * <p>
     * Establece el NIT de la Empresa</p>
     *
     * @param nit Recibe un int como NIT de la Empresa
     */
    public void setNit(int nit) {
        this.nit = nit;
    }

    /**
     * <span>Descripción:</span>
     * <p>
     * Obtiene el Nombre de la Empresa</p>
     *
     * @return nombreEmpresa - Retorna un String como Nombre de la Empresa
     */
    public String getNombreEmpresa() {
        return nombreEmpresa;
    }

    /**
     * <span>Descripción:</span>
     * <p>
     * Establece el Nombre de la Empresa</p>
     *
     * @param nombreEmpresa Recibe un String como Nombre de la Empresa
     */
    public void setNombreEmpresa(String nombreEmpresa) {
        this.nombreEmpresa = nombreEmpresa;
    }

    /**
     * <span>Descripción:</span>
     * <p>
     * Obtiene la Dirección de la Empresa</p>
     *
     * @return direccionEmpresa - Retorna un String como Dirección de la Empresa
     */
    public String getDireccionEmpresa() {
        return direccionEmpresa;
    }

    /**
     * <span>Descripción:</span>
     * <p>
     * Establece la Dirección de la Empresa</p>
     *
     * @param direccionEmpresa Recibe un String como Dirección de la Empresa
     */
    public void setDireccionEmpresa(String direccionEmpresa) {
        this.direccionEmpresa = direccionEmpresa;
    }

    /**
     * <span>Descripción:</span>
     * <p>
     * Obtiene la Ciudad de la Empresa</p>
     *
     * @return ciudadEmpresa - Retorna un String como Ciudad de la Empresa
     */
    public String getCiudadEmpresa() {
        return ciudadEmpresa;
    }

    /**
     * <span>Descripción:</span>
     * <p>
     * Establece la Ciudad de la Empresa</p>
     *
     * @param ciudadEmpresa Recibe un String como Ciudad de la Empresa
     */
    public void setCiudadEmpresa(String ciudadEmpresa) {
        this.ciudadEmpresa = ciudadEmpresa;
    }

    /**
     * <span>Descripción:</span>
     * <p>
     * Obtiene el Departamento de la Empresa</p>
     *
     * @return departamentoEmpresa - Retorna un String como Departamento de la
     * Empresa
     */
    public String getDepartamentoEmpresa() {
        return departamentoEmpresa;
    }

    /**
     * <span>Descripción:</span>
     * <p>
     * Establece el Departamento de la Empresa</p>
     *
     * @param departamentoEmpresa Recibe un Srtring como Departamento de la
     * Empresa
     */
    public void setDepartamentoEmpresa(String departamentoEmpresa) {
        this.departamentoEmpresa = departamentoEmpresa;
    }

    /**
     * <span>Descripción:</span>
     * <p>
     * Obtiene el Teléfono o Celular de la Empresa</p>
     *
     * @return telefonoEmpresa - Retorna un int como Teléfono o Celular de la
     * Empresa
     */
    public int getTelefonoEmpresa() {
        return telefonoEmpresa;
    }

    /**
     * <span>Descripción:</span>
     * <p>
     * Establece el Teléfono o Celular de la Empresa</p>
     *
     * @param telefonoEmpresa Recibe un int como teléfono o Celular de la
     * Empresa
     */
    public void setTelefonoEmpresa(int telefonoEmpresa) {
        this.telefonoEmpresa = telefonoEmpresa;
    }

    /**
     * <span>Descripción:</span>
     * <p>
     * Obtiene el Sitio Web de la Empresa</p>
     *
     * @return url -Retorna un String como Sitio Web de la Empresa
     */
    public String getUrl() {
        return url;
    }

    /**
     * <span>Descripción:</span>
     * <p>
     * Establece el Sitio Web de la Empresa</p>
     *
     * @param url Recibe un String como Sitio Web de la Empresa
     */
    public void setUrl(String url) {
        this.url = url;
    }

    /**
     * <span>Descripción:</span>
     * <p>
     * Obtiene el Email de la Empresa</p>
     *
     * @return emailEmpresa - Retorna un String como Email de la Empresa
     */
    public String getEmailEmpresa() {
        return emailEmpresa;
    }

    /**
     * <span>Descripción:</span>
     * <p>
     * Establece el Email de la Empresa</p>
     *
     * @param emailEmpresa Recibe un String como Email de la Empresa
     */
    public void setEmailEmpresa(String emailEmpresa) {
        this.emailEmpresa = emailEmpresa;
    }

}
