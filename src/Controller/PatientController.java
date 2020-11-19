
package Controller;

import Model.UserDAO;
import Model.Patient;
import Model.User;
import View.FormPatientsManagement;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

//Crea la clase PatientController
public class PatientController implements ActionListener {

    //Declara las variables globales
    private final   UserDAO udao;
    private final   User u;
    private final  FormPatientsManagement fp;
    private final Patient p;

    //Contructor de la clase PatientController
    public PatientController(User u, UserDAO udao, FormPatientsManagement fp, Patient p) {

        this.u = u;
        this.udao = udao;
        this.fp = fp;
        this.p=p;

        this.fp.btnAssociate.addActionListener(this);
        this.fp.btnSaveP.addActionListener(this);
        this.fp.btnSearchUpdateP.addActionListener(this);
        this.fp.btnIdentify.addActionListener(this);
        this.fp.btnDeleteP.addActionListener(this);
        this.fp.btnNewP.addActionListener(this);
    }
    
    //Se encarga de responder a los eventos del click de los botones del FormPatientsManagement
    @Override
    public void actionPerformed(ActionEvent e) {

        
        if (e.getSource() == fp.btnAssociate) {
            fp.asociate();
        }
        if(e.getSource()==fp.btnSaveP){
            fp.saveP();
        }
        if (e.getSource() == fp.btnSearchUpdateP) {
            fp.searchUpdate();
        }
        if(e.getSource()==fp.btnIdentify){
            fp.identify();
        }
        if (e.getSource()==fp.btnNewP) {
            fp.clearFields();
        }
        
    }

}
