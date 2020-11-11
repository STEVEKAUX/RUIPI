/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import Connector.UserDAO;
import Model.User;
import View.FormPatients;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

//Crea la clase PController
public class PController implements ActionListener {

    //Declara las variables globales
    private UserDAO udao;
    private User u;
    private FormPatients fp;

    //Contructor de la clase PController
    public PController(User u, UserDAO udao, FormPatients fp) {

        this.u = u;
        this.udao = udao;
        this.fp = fp;

        //this.fp.btnAssociate.addActionListener(this);
        //this.fp.btnSaveP.addActionListener(this);
        //this.fp.btnSearchUpdateP.addActionListener(this);
        //this.fp.btnIdentify.addActionListener(this);
        //this.fp.btnDeleteP.addActionListener(this);
        //this.fp.btnNewP.addActionListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent e) {

        /**
         * if(e.getSource()==fp.btnNewP){ fp.clearFields();  
        }*
         */
    }

}
