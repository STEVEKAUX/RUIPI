package Model;

/**
 * <span>Descripción:</span>
 * <p>
 * Extiende de {@link Person}. Estructura la información del Paciente respecto a
 * la "Entiidad Usuario" de la base de datos.</p>
 *
 * @author Daniel Felipe Lozada Ramirez Email: dflozada2@misena.edu.co
 * @author Edgar Steve Pava Email: Espava60@misena.edu.co
 * @version 1.1.0
 * @since 2020
 */
public class User extends Person {

    /**
     * Variables y constantes de la clase {@link User}.
     *
     */
    private int idUsuario;
    private String username;
    private String password;
    private String cargo;
    private String area;
    private String ultimaSesion;
    private int id_empresa;
    private int id_tipo_usuario;

    private String nombre_tipo_usuario;

    /**
     * <p>
     * Método Constructor de User</p>
     */
    public User() {
        super();
    }

    /**
     * <span>Descripción:</span>
     * <p>
     * Obtiene el ID del Usuario</p>
     *
     * @return idUsuario - Retorna un int como ID del Usuario
     */
    public int getIdUsuario() {
        return idUsuario;
    }

    /**
     * <span>Descripción:</span>
     * <p>
     * Establece el ID del Usuario</p>
     *
     * @param idUsuario Recibe un int como ID del Usuario
     */
    public void setIdUsuario(int idUsuario) {
        this.idUsuario = idUsuario;
    }

    /**
     * <span>Descripción:</span>
     * <p>
     * Obtiene el Nombre de Usuario del Usuario</p>
     *
     * @return username - Retorna un String como Nombre de Usuario del Usuario
     */
    public String getUsername() {
        return username;
    }

    /**
     * <span>Descripción:</span>
     * <p>
     * Establece el Nombre de Usuario del Usuario</p>
     *
     * @param username Recibe un String como Nombre de Usuario del Usuario
     */
    public void setUsername(String username) {
        this.username = username;
    }

    /**
     * <span>Descripción:</span>
     * <p>
     * Obtiene la contraseña del Usuario</p>
     *
     * @return password - Retorna un String como Password del Usuario
     */
    public String getPassword() {
        return password;
    }

    /**
     * <span>Descripción:</span>
     * <p>
     * Establece la contraseña del Usuario</p>
     *
     * @param password Recibe un String como Password del Usuario
     */
    public void setPassword(String password) {
        this.password = password;
    }

    /**
     * <span>Descripción:</span>
     * <p>
     * Obtiene el cargo del Usuario</p>
     *
     * @return cargo - Retorna un String como Cargo del usuario
     */
    public String getCargo() {
        return cargo;
    }

    /**
     * <span>Descripción:</span>
     * <p>
     * Establece el cargo del Usuario</p>
     *
     * @param cargo Recibe un String como Cargo del usuario
     */
    public void setCargo(String cargo) {
        this.cargo = cargo;
    }

    /**
     * <span>Descripción:</span>
     * <p>
     * Obtiene el area del Usuario</p>
     *
     * @return area - Retorna un String como Area del Usuario
     */
    public String getArea() {
        return area;
    }

    /**
     * <span>Descripción:</span>
     * <p>
     * Establece el area del Usuario</p>
     *
     * @param area Recibe un String como Area del Usuario
     */
    public void setArea(String area) {
        this.area = area;
    }

    /**
     * <span>Descripción:</span>
     * <p>
     * Obtiene la Última Sesión del Usuario</p>
     *
     * @return ultimaSesion - Retorna un String como la Última Sesión del
     * Usuario
     */
    public String getUltimaSesion() {
        return ultimaSesion;
    }

    /**
     * <span>Descripción:</span>
     * <p>
     * Establece la Última Sesión del Usuario</p>
     *
     * @param ultimaSesion Recibe un String como la Última Sesión del Usuario
     */
    public void setUltimaSesion(String ultimaSesion) {
        this.ultimaSesion = ultimaSesion;
    }

    /**
     * <span>Descripción:</span>
     * <p>
     * Obtiene el ID de la empresa a la que pertenece el Usuario</p>
     *
     * @return id_empresa - Retorena un int como ID de la empresa a la que
     * pertenece el Usuario
     */
    public int getId_empresa() {
        return id_empresa;
    }

    /**
     * <span>Descripción:</span>
     * <p>
     * Establece el ID de la empresa a la que pertenece el Usuario</p>
     *
     * @param id_empresa Recibe un int como ID de la empresa a la que pertenece
     * el Usuario
     */
    public void setId_empresa(int id_empresa) {
        this.id_empresa = id_empresa;
    }

    /**
     * <span>Descripción:</span>
     * <p>
     * Obtiene el ID del Tipo de Usuario del Usuario</p>
     *
     * @return id_tipo_usuario - Retorna un int como el ID del Tipo de Usuario
     * del Usuario
     */
    public int getId_tipo_usuario() {
        return id_tipo_usuario;
    }

    /**
     * <span>Descripción:</span>
     * <p>
     * Establece el ID del Tipo de Usuario del Usuario</p>
     *
     * @param id_tipo_usuario Recibe un int como el ID del Tipo de Usuario del
     * Usuario
     */
    public void setId_tipo_usuario(int id_tipo_usuario) {
        this.id_tipo_usuario = id_tipo_usuario;
    }

    /**
     * <span>Descripción:</span>
     * <p>
     * Obtiene el Nombre del Tipo de Usuario del Usuario</p>
     *
     * @return nombre_tipo_usuario - Retorna un String como el Nombre del Tipo
     * de Usuario del Usuario
     */
    public String getNombre_tipo_usuario() {
        return nombre_tipo_usuario;
    }

    /**
     * <span>Descripción:</span>
     * <p>
     * Establece el Nombre del Tipo de Usuario del Usuario</p>
     *
     * @param nombre_tipo_usuario Recibe un String como el Nombre del Tipo de
     * Usuario del Usuario
     */
    public void setNombre_tipo_usuario(String nombre_tipo_usuario) {
        this.nombre_tipo_usuario = nombre_tipo_usuario;
    }

}
