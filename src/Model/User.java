package Model;

//Crea la clase User
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
    public User() {
    }

    //Constructor de Paciente
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

    public int getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(int idUsuario) {
        this.idUsuario = idUsuario;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getCargo() {
        return cargo;
    }

    public void setCargo(String cargo) {
        this.cargo = cargo;
    }

    public String getArea() {
        return area;
    }

    public void setArea(String area) {
        this.area = area;
    }

    public String getUltimaSesion() {
        return ultimaSesion;
    }

    public void setUltimaSesion(String ultimaSesion) {
        this.ultimaSesion = ultimaSesion;
    }

    public int getId_empresa() {
        return id_empresa;
    }

    public void setId_empresa(int id_empresa) {
        this.id_empresa = id_empresa;
    }

    public int getId_tipo_usuario() {
        return id_tipo_usuario;
    }

    public void setId_tipo_usuario(int id_tipo_usuario) {
        this.id_tipo_usuario = id_tipo_usuario;
    }

    public int getId_persona() {
        return id_persona;
    }

    public void setId_persona(int id_persona) {
        this.id_persona = id_persona;
    }

    public String getNombreU() {
        return nombreU;
    }

    public void setNombreU(String nombreU) {
        this.nombreU = nombreU;
    }

    public String getApellidoU() {
        return apellidoU;
    }

    public void setApellidoU(String apellidoU) {
        this.apellidoU = apellidoU;
    }

    public String getEmailU() {
        return emailU;
    }

    public void setEmailU(String emailU) {
        this.emailU = emailU;
    }

    public String getTipoDocumentoU() {
        return tipoDocumentoU;
    }

    public void setTipoDocumentoU(String tipoDocumentoU) {
        this.tipoDocumentoU = tipoDocumentoU;
    }

    public int getNumeroDocumentoU() {
        return numeroDocumentoU;
    }

    public void setNumeroDocumentoU(int numeroDocumentoU) {
        this.numeroDocumentoU = numeroDocumentoU;
    }

    public int getCelularU() {
        return celularU;
    }

    public void setCelularU(int celularU) {
        this.celularU = celularU;
    }

    public String getFechaNaciemientoU() {
        return fechaNaciemientoU;
    }

    public void setFechaNaciemientoU(String fechaNaciemientoU) {
        this.fechaNaciemientoU = fechaNaciemientoU;
    }

    public String getCiudadOrigenU() {
        return ciudadOrigenU;
    }

    public void setCiudadOrigenU(String ciudadOrigenU) {
        this.ciudadOrigenU = ciudadOrigenU;
    }

    public String getDepartamentoOrigenU() {
        return departamentoOrigenU;
    }

    public void setDepartamentoOrigenU(String departamentoOrigenU) {
        this.departamentoOrigenU = departamentoOrigenU;
    }

    public String getDireccionU() {
        return direccionU;
    }

    public void setDireccionU(String direccionU) {
        this.direccionU = direccionU;
    }

    public String getNombre_tipo_usuario() {
        return nombre_tipo_usuario;
    }

    public void setNombre_tipo_usuario(String nombre_tipo_usuario) {
        this.nombre_tipo_usuario = nombre_tipo_usuario;
    }

   
}
