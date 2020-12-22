package Model;

//Crea la clase User

/**
 *
 * @author lenov
 */
public class User {

    //Declaración de variables globales de User
    private int idUsuario;
    private String username;
    private String password;
    private String cargo;
    private String area;
    private String ultimaSesion;
    private int id_empresa;
    private int id_tipo_usuario;
    
    private int id_persona;
    private String nombreU;
    private String apellidoU;
    private String emailU;
    private String tipoDocumentoU;
    private int numeroDocumentoU;
    private int celularU;
    private String fechaNaciemientoU;
    private String ciudadOrigenU;
    private String departamentoOrigenU;
    private String direccionU;
    
    
    
    private String nombre_tipo_usuario;

    //Constructor vacío de la clase User

    /**
     *
     */
    public User() {
    }

    //Constructor de Paciente

    /**
     *
     * @param idUsuario
     * @param username
     * @param password
     * @param cargo
     * @param area
     * @param ultimaSesion
     * @param Empresa_id_empresa
     * @param Tipo_id_tipo_usuario
     * @param id_persona
     * @param nombreUsuario
     * @param apellidoUsuario
     * @param emailUsuario
     * @param tipoDocumentoU
     * @param numeroDocumentoU
     * @param celularU
     * @param fechaNaciemientoU
     * @param ciudadOrigenU
     * @param departamentoOrigenU
     * @param direccionU
     * @param nombre_tipo_usuario
     */
    public User(int idUsuario, String username, String password, String cargo, String area,
            String ultimaSesion, int Empresa_id_empresa, int Tipo_id_tipo_usuario,
            int id_persona, String nombreUsuario, String apellidoUsuario, String emailUsuario, String tipoDocumentoU,
            int numeroDocumentoU, int celularU, String fechaNaciemientoU, String ciudadOrigenU, String departamentoOrigenU,
            String direccionU, String nombre_tipo_usuario) {
        
        this.idUsuario = idUsuario;
        this.username = username;
        this.password = password;
        this.cargo = cargo;
        this.area = area;
        this.ultimaSesion = ultimaSesion;
        this.id_empresa = Empresa_id_empresa;
        this.id_tipo_usuario = Tipo_id_tipo_usuario;
        
        this.id_persona = id_persona;
        this.nombreU = nombreUsuario;
        this.apellidoU = apellidoUsuario;
        this.emailU = emailUsuario;
        this.tipoDocumentoU = tipoDocumentoU;
        this.numeroDocumentoU = numeroDocumentoU;
        this.celularU = celularU;
        this.fechaNaciemientoU = fechaNaciemientoU;
        this.ciudadOrigenU = ciudadOrigenU;
        this.departamentoOrigenU = departamentoOrigenU;
        this.direccionU = direccionU;
        this.nombre_tipo_usuario = nombre_tipo_usuario;
    }

    /**
     *
     * @return
     */
    public int getIdUsuario() {
        return idUsuario;
    }

    /**
     *
     * @param idUsuario
     */
    public void setIdUsuario(int idUsuario) {
        this.idUsuario = idUsuario;
    }

    /**
     *
     * @return
     */
    public String getUsername() {
        return username;
    }

    /**
     *
     * @param username
     */
    public void setUsername(String username) {
        this.username = username;
    }

    /**
     *
     * @return
     */
    public String getPassword() {
        return password;
    }

    /**
     *
     * @param password
     */
    public void setPassword(String password) {
        this.password = password;
    }

    /**
     *
     * @return
     */
    public String getCargo() {
        return cargo;
    }

    /**
     *
     * @param cargo
     */
    public void setCargo(String cargo) {
        this.cargo = cargo;
    }

    /**
     *
     * @return
     */
    public String getArea() {
        return area;
    }

    /**
     *
     * @param area
     */
    public void setArea(String area) {
        this.area = area;
    }

    /**
     *
     * @return
     */
    public String getUltimaSesion() {
        return ultimaSesion;
    }

    /**
     *
     * @param ultimaSesion
     */
    public void setUltimaSesion(String ultimaSesion) {
        this.ultimaSesion = ultimaSesion;
    }

    /**
     *
     * @return
     */
    public int getId_empresa() {
        return id_empresa;
    }

    /**
     *
     * @param id_empresa
     */
    public void setId_empresa(int id_empresa) {
        this.id_empresa = id_empresa;
    }

    /**
     *
     * @return
     */
    public int getId_tipo_usuario() {
        return id_tipo_usuario;
    }

    /**
     *
     * @param id_tipo_usuario
     */
    public void setId_tipo_usuario(int id_tipo_usuario) {
        this.id_tipo_usuario = id_tipo_usuario;
    }

    /**
     *
     * @return
     */
    public int getId_persona() {
        return id_persona;
    }

    /**
     *
     * @param id_persona
     */
    public void setId_persona(int id_persona) {
        this.id_persona = id_persona;
    }

    /**
     *
     * @return
     */
    public String getNombreU() {
        return nombreU;
    }

    /**
     *
     * @param nombreU
     */
    public void setNombreU(String nombreU) {
        this.nombreU = nombreU;
    }

    /**
     *
     * @return
     */
    public String getApellidoU() {
        return apellidoU;
    }

    /**
     *
     * @param apellidoU
     */
    public void setApellidoU(String apellidoU) {
        this.apellidoU = apellidoU;
    }

    /**
     *
     * @return
     */
    public String getEmailU() {
        return emailU;
    }

    /**
     *
     * @param emailU
     */
    public void setEmailU(String emailU) {
        this.emailU = emailU;
    }

    /**
     *
     * @return
     */
    public String getTipoDocumentoU() {
        return tipoDocumentoU;
    }

    /**
     *
     * @param tipoDocumentoU
     */
    public void setTipoDocumentoU(String tipoDocumentoU) {
        this.tipoDocumentoU = tipoDocumentoU;
    }

    /**
     *
     * @return
     */
    public int getNumeroDocumentoU() {
        return numeroDocumentoU;
    }

    /**
     *
     * @param numeroDocumentoU
     */
    public void setNumeroDocumentoU(int numeroDocumentoU) {
        this.numeroDocumentoU = numeroDocumentoU;
    }

    /**
     *
     * @return
     */
    public int getCelularU() {
        return celularU;
    }

    /**
     *
     * @param celularU
     */
    public void setCelularU(int celularU) {
        this.celularU = celularU;
    }

    /**
     *
     * @return
     */
    public String getFechaNaciemientoU() {
        return fechaNaciemientoU;
    }

    /**
     *
     * @param fechaNaciemientoU
     */
    public void setFechaNaciemientoU(String fechaNaciemientoU) {
        this.fechaNaciemientoU = fechaNaciemientoU;
    }

    /**
     *
     * @return
     */
    public String getCiudadOrigenU() {
        return ciudadOrigenU;
    }

    /**
     *
     * @param ciudadOrigenU
     */
    public void setCiudadOrigenU(String ciudadOrigenU) {
        this.ciudadOrigenU = ciudadOrigenU;
    }

    /**
     *
     * @return
     */
    public String getDepartamentoOrigenU() {
        return departamentoOrigenU;
    }

    /**
     *
     * @param departamentoOrigenU
     */
    public void setDepartamentoOrigenU(String departamentoOrigenU) {
        this.departamentoOrigenU = departamentoOrigenU;
    }

    /**
     *
     * @return
     */
    public String getDireccionU() {
        return direccionU;
    }

    /**
     *
     * @param direccionU
     */
    public void setDireccionU(String direccionU) {
        this.direccionU = direccionU;
    }

    /**
     *
     * @return
     */
    public String getNombre_tipo_usuario() {
        return nombre_tipo_usuario;
    }

    /**
     *
     * @param nombre_tipo_usuario
     */
    public void setNombre_tipo_usuario(String nombre_tipo_usuario) {
        this.nombre_tipo_usuario = nombre_tipo_usuario;
    }

   
}
