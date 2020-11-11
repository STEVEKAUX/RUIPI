package Model;

//Crea la clase User
public class User {

    //Declaración de variables globales de User
    private int idUsuario;
    private String username;
    private String password;
    private String emailUsuario;
    private String nombreUsuario;
    private String apellidoUsuario;
    private String cargo;
    private String area;
    private String ultimaSesion;
    private String fechaUsuario;
    private int idEmpresa;
    private int idTipoUsuario;
    private String nombre_tipo_usuario;

    //Constructor vacío de la clase User
    public User() {
    }

    //Constructor de la clase User
    public User(int idUsuario, String username, String password, String nombreUsuario, String apellidoUsuario,
            String cargo, String area, String ultimaSesion, String fechaUsuario, int idEmpresa, int idTipoUsuario) {
        this.idUsuario = idUsuario;
        this.username = username;
        this.password = password;
        this.emailUsuario = emailUsuario;
        this.nombreUsuario = nombreUsuario;
        this.apellidoUsuario = apellidoUsuario;
        this.cargo = cargo;
        this.area = area;
        this.ultimaSesion = ultimaSesion;
        this.fechaUsuario = fechaUsuario;
        this.idEmpresa = idEmpresa;
        this.idTipoUsuario = idTipoUsuario;
    }

    //Setters y Getters
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

    public String getEmailUsuario() {
        return emailUsuario;
    }

    public void setEmailUsuario(String emailUsuario) {
        this.emailUsuario = emailUsuario;
    }

    public String getNombreUsuario() {
        return nombreUsuario;
    }

    public void setNombreUsuario(String nombreUsuario) {
        this.nombreUsuario = nombreUsuario;
    }

    public String getApellidoUsuario() {
        return apellidoUsuario;
    }

    public void setApellidoUsuario(String apellidoUsuario) {
        this.apellidoUsuario = apellidoUsuario;
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

    public String getFechaUsuario() {
        return fechaUsuario;
    }

    public void setFechaUsuario(String fechaUsuario) {
        this.fechaUsuario = fechaUsuario;
    }

    public int getIdEmpresa() {
        return idEmpresa;
    }

    public void setIdEmpresa(int idEmpresa) {
        this.idEmpresa = idEmpresa;
    }

    public int getIdTipoUsuario() {
        return idTipoUsuario;
    }

    public void setIdTipoUsuario(int idTipoUsuario) {
        this.idTipoUsuario = idTipoUsuario;
    }

    public String getNombre_tipo_usuario() {
        return nombre_tipo_usuario;
    }

    public void setNombre_tipo_usuario(String nombre_tipo_usuario) {
        this.nombre_tipo_usuario = nombre_tipo_usuario;
    }
}
