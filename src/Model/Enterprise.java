package Model;

//Crea la clase Enterprise
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
    public Enterprise() {
    }

    //Constructor de Enterprise
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
    public int getIdEmpresa() {
        return idEmpresa;
    }

    public void setIdEmpresa(int idEmpresa) {
        this.idEmpresa = idEmpresa;
    }

    public int getNit() {
        return nit;
    }

    public void setNit(int nit) {
        this.nit = nit;
    }

    public String getNombreEmpresa() {
        return nombreEmpresa;
    }

    public void setNombreEmpresa(String nombreEmpresa) {
        this.nombreEmpresa = nombreEmpresa;
    }

    public String getDireccionEmpresa() {
        return direccionEmpresa;
    }

    public void setDireccionEmpresa(String direccionEmpresa) {
        this.direccionEmpresa = direccionEmpresa;
    }

    public String getCiudadEmpresa() {
        return ciudadEmpresa;
    }

    public void setCiudadEmpresa(String ciudadEmpresa) {
        this.ciudadEmpresa = ciudadEmpresa;
    }

    public String getDepartamentoEmpresa() {
        return departamentoEmpresa;
    }

    public void setDepartamentoEmpresa(String departamentoEmpresa) {
        this.departamentoEmpresa = departamentoEmpresa;
    }

    public int getTelefonoEmpresa() {
        return telefonoEmpresa;
    }

    public void setTelefonoEmpresa(int telefonoEmpresa) {
        this.telefonoEmpresa = telefonoEmpresa;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getEmailEmpresa() {
        return emailEmpresa;
    }

    public void setEmailEmpresa(String emailEmpresa) {
        this.emailEmpresa = emailEmpresa;
    }

}
