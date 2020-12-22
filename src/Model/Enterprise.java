package Model;

//Crea la clase Enterprise

/**
 *
 * @author lenov
 */
public class Enterprise {

    //Declaración de variables globales de la clase Enterprise
    private int idEmpresa;
    private int nit;
    private String nombreEmpresa;
    private String direccionEmpresa;
    private String ciudadEmpresa;
    private String departamentoEmpresa;
    private int telefonoEmpresa;
    private String url;
    private String emailEmpresa;

    //Constructor vacío de Enterprice

    /**
     *
     */
    public Enterprise() {
    }

    //Constructor de Enterprise

    /**
     *
     * @param idEmpresa
     * @param nit
     * @param nombreEmpresa
     * @param direccionEmpresa
     * @param ciudadEmpresa
     * @param departamentoEmpresa
     * @param telefonoEmpresa
     * @param url
     * @param emailEmpresa
     */
    public Enterprise(int idEmpresa, int nit, String nombreEmpresa, String direccionEmpresa,
            String ciudadEmpresa, String departamentoEmpresa, int telefonoEmpresa, String url,
            String emailEmpresa) {
        this.idEmpresa = idEmpresa;
        this.nit = nit;
        this.nombreEmpresa = nombreEmpresa;
        this.direccionEmpresa = direccionEmpresa;
        this.ciudadEmpresa = ciudadEmpresa;
        this.departamentoEmpresa = departamentoEmpresa;
        this.telefonoEmpresa = telefonoEmpresa;
        this.url = url;
        this.emailEmpresa = emailEmpresa;
        
    }

    //Setters y Getters

    /**
     *
     * @return
     */
    public int getIdEmpresa() {
        return idEmpresa;
    }

    /**
     *
     * @param idEmpresa
     */
    public void setIdEmpresa(int idEmpresa) {
        this.idEmpresa = idEmpresa;
    }

    /**
     *
     * @return
     */
    public int getNit() {
        return nit;
    }

    /**
     *
     * @param nit
     */
    public void setNit(int nit) {
        this.nit = nit;
    }

    /**
     *
     * @return
     */
    public String getNombreEmpresa() {
        return nombreEmpresa;
    }

    /**
     *
     * @param nombreEmpresa
     */
    public void setNombreEmpresa(String nombreEmpresa) {
        this.nombreEmpresa = nombreEmpresa;
    }

    /**
     *
     * @return
     */
    public String getDireccionEmpresa() {
        return direccionEmpresa;
    }

    /**
     *
     * @param direccionEmpresa
     */
    public void setDireccionEmpresa(String direccionEmpresa) {
        this.direccionEmpresa = direccionEmpresa;
    }

    /**
     *
     * @return
     */
    public String getCiudadEmpresa() {
        return ciudadEmpresa;
    }

    /**
     *
     * @param ciudadEmpresa
     */
    public void setCiudadEmpresa(String ciudadEmpresa) {
        this.ciudadEmpresa = ciudadEmpresa;
    }

    /**
     *
     * @return
     */
    public String getDepartamentoEmpresa() {
        return departamentoEmpresa;
    }

    /**
     *
     * @param departamentoEmpresa
     */
    public void setDepartamentoEmpresa(String departamentoEmpresa) {
        this.departamentoEmpresa = departamentoEmpresa;
    }

    /**
     *
     * @return
     */
    public int getTelefonoEmpresa() {
        return telefonoEmpresa;
    }

    /**
     *
     * @param telefonoEmpresa
     */
    public void setTelefonoEmpresa(int telefonoEmpresa) {
        this.telefonoEmpresa = telefonoEmpresa;
    }

    /**
     *
     * @return
     */
    public String getUrl() {
        return url;
    }

    /**
     *
     * @param url
     */
    public void setUrl(String url) {
        this.url = url;
    }

    /**
     *
     * @return
     */
    public String getEmailEmpresa() {
        return emailEmpresa;
    }

    /**
     *
     * @param emailEmpresa
     */
    public void setEmailEmpresa(String emailEmpresa) {
        this.emailEmpresa = emailEmpresa;
    }

}
