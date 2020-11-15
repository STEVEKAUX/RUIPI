/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package RUIPI;

import DAO.UserDAO;
import Controller.PatientController;
import Model.User;
import View.FormPatientsManagement;
import View.LoginUI;

//Crea la clase con principal RUIPI con el método Main de la aplicación
public class RUIPI {
     public static void main(String[] args) {
         LoginUI loginUI = new LoginUI();
         User u = new User();
         UserDAO uDao = new UserDAO();
         FormPatientsManagement fp = new FormPatientsManagement();
         PatientController pc= new PatientController(u, uDao, fp);
         
    }

}
