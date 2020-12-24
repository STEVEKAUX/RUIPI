package Controller;

import Model.Patient;
import Model.User;
import Model.UserDAO;
import View.FormPatientsManagement;
import View.LoginUI;

/**
 * <h1>Registro Único de Identificación de Pacientes Indígenas. RUIPI</h1>
 * <p>
 * RUIPI (Registro Único para la Identificación de Pacientes Indígenas) es un
 * proyecto desarrollado en Java que implementa el lector biométrico de huellas
 * dactilares U.are.U DigitalPersona 4500, con el fin de proporcionar una forma
 * eficaz de identificar pacientes de Instituciones Prestadoras de Servicios de
 * Salud (IPS) pertenecientes a comunidades vulnerables que carecen de documento
 * de identidad.</p>
 *
 * @author Daniel Felipe Lozada Ramirez Email: dflozada2@misena.edu.co
 * @author Edgar Steve Pava Email: Espava60@misena.edu.co
 * @version 1.1.0
 * @since 2020
 */
public class Main {

    /**
     * <span>Descripción:</span>
     * <p>
     * Inicia la aplicación RUIPI según las instrucciones que se le dan en el
     * cuerpo del método</p>
     *
     * @param args
     */
    public static void main(String[] args) {
        LoginUI loginUI = new LoginUI();
        User u = new User();
        UserDAO uDao = new UserDAO();
        Patient p = new Patient();
        FormPatientsManagement fp = new FormPatientsManagement();
        PatientController pc = new PatientController(u, uDao, fp, p);

    }

}
