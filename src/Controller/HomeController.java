

package Controller;

import View.Home;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class HomeController implements ActionListener{
    
    //Declaración de variables
    private final Home h;
    
    //Constructor de HomeController
    public HomeController(Home h) {
        this.h=h;
        
         this.h.btnCerrarSesion.addActionListener(this);
    }
    
    @Override
    public void actionPerformed(ActionEvent e){
        if(e.getSource()==h.btnCerrarSesion){
            h.close();
        }
    }

}
