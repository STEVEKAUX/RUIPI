
package Controller;

import DAO.UserDAO;
import Model.User;
import View.FormPatientsManagement;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

//Crea la clase PatientController
public class PatientController implements ActionListener {

    //Declara las variables globales
    private final  UserDAO udao;
    private final  User u;
    private final  FormPatientsManagement fp;

    //Contructor de la clase PatientController
    public PatientController(User u, UserDAO udao, FormPatientsManagement fp) {

        this.u = u;
        this.udao = udao;
        this.fp = fp;

        //this.fp.btnAssociate.addActionListener(this);
        //this.fp.btnSaveP.addActionListener(this);
        //this.fp.btnSearchUpdateP.addActionListener(this);
        //this.fp.btnIdentify.addActionListener(this);
        //this.fp.btnDeleteP.addActionListener(this);
        this.fp.btnNewP.addActionListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent e) {

        
         if(e.getSource()==fp.btnNewP){ 
             fp.clearFields();
             fp.clearTable();
        }
        
    }

}
