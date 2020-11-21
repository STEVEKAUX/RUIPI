
package Model;

import Controller.PatientController;
import View.FormPatientsManagement;
import View.LoginUI;

//Crea la clase con principal RUIPI con el método Main de la aplicación
public class RUIPI {
     public static void main(String[] args) {
         LoginUI loginUI = new LoginUI();
         User u = new User();
         UserDAO uDao = new UserDAO();
         Patient p= new Patient();
         FormPatientsManagement fp = new FormPatientsManagement();
         PatientController pc= new PatientController(u, uDao, fp, p);
         
    }

}
