package Model;

/**
 * <span>Descripción:</span>
 * <p>
 * Se encarga de declarar los métodos que serán implementados por las clases que
 * hagan uso de la CRUD.</p>
 *
 * @author Daniel Felipe Lozada Ramirez Email: dflozada2@misena.edu.co
 * @author Edgar Steve Pava Email: Espava60@misena.edu.co
 * @version 1.1.0
 * @since 2020
 */
public interface CRUD {

    /**
     * <span>Descripción:</span>
     * <p>
     * Se encarga de ejecutar la funcionalidad que guarda un nuevo paciente o
     * actualiza los cambios en los datos de un paciente, su comportamiento
     * puede variar según el método que lo implementa.</p>
     */
    public void save();

    /**
     * <span>Descripción:</span>
     * <p>
     * Se encarga de ejecutar la funcionalidad que buscar un paciente, su
     * comportamiento puede variar según el método que lo implementa.</p>
     */
    public void search();

    /**
     * <span>Descripción:</span>
     * <p>
     * Se encarga de ejecutar la funcionalidad que limpia los campos del
     * formulario donse sea llamado, su comportamiento puede variar según el
     * método que lo implementa.</p>
     */
    public void clear();

    /**
     * <span>Descripción:</span>
     * <p>
     * Se encarga de ejecutar la funcionalidad que limpia la tabla del
     * formulario donse sea llamado, su comportamiento puede variar según el
     * método que lo implementa.</p>
     */
    public void clearTable();

    /**
     * <span>Descripción:</span>
     * <p>
     * Se encarga de ejecutar la funcionalidad que elimina superficialmente un
     * registro de un paciente, usuario o historia clínica, su comportamiento
     * puede variar según el método que lo implementa.</p>
     */
    public void softDelete();

    /**
     * <span>Descripción:</span>
     * <p>
     * Se encarga de ejecutar la funcionalidad que actualiza directamente de los
     * datos de un paciente, su comportamiento puede variar según el método que
     * lo implementa.</p>
     */
    public void update();
}
