

package Controller;

import View.Home;
import java.awt.event.ActionEvent;


public class HomeController {
    
    //Declaración de variables
    private final Home h;
    
    //Constructor de HomeController
    public HomeController(Home h) {
        this.h=h;
    }
    
    public void actionPerformed(ActionEvent e){
        if(e.getSource()==h.btnCerrarSesion){
            h.close();
        }
    }

}
