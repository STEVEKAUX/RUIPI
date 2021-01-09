package View;

/**
 * <span>Descripción:</span>
 * <p>
 * Extiende de {@link Person}. Estructura la información del Paciente respecto a la "Entidad Paciente" de la
 * base de datos.</p>
 *
 * @author Daniel Felipe Lozada Ramirez Email: dflozada2@misena.edu.co
 * @author Edgar Steve Pava Email: Espava60@misena.edu.co
 * @version 1.1.0
 * @since 2020
 */

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.util.concurrent.atomic.AtomicInteger;

//Crea la clase Toaster

/**
 *
 * @author lenov
 */

public class Toaster {

    /**
     * Constantes de la clase Toaster.
     *
     */
    
    private static final int STARTING_Y_POS = 178;
    private static final int SPACER_DISTANCE = 15;
    private static final ArrayList<ToasterBody> toasterBodies = new ArrayList<>();
    private final static AtomicInteger CURRENT_Y_OFFSET = new AtomicInteger();
    private final JPanel panelToToastOn;

    /**
     * <p>
     * Método Constructor de Toaster</p>
     * 
     * @param panelToToastOn
     */
    
    public Toaster(JPanel panelToToastOn) {
        this.panelToToastOn = panelToToastOn;
    }
        
     /**
     * <span>Descripción:</span>
     * <p>
     * Muestra un toaster de tipo error</p>
     *
     * @param messages
     */
    
    public void error(String... messages) {
        for (String s : messages) {
            toast(s, new Color(181, 59, 86));
        }
    }

    /**
     * <span>Descripción:</span>
     * <p>
     * Muestra un toaster de tipo success</p>
     *
     * @param messages
     */
    
    public void success(String... messages) {
        for (String s : messages) {
            toast(s, new Color(33, 181, 83));
        }
    }
    
    /**
     * <span>Descripción:</span>
     * <p>
     * Muestra un toaster de tipo info</p>
     *
     * @param messages
     */
    
   
    public void info(String... messages) {
        for (String s : messages) {
            toast(s, new Color(13, 116, 181));
        }
    }

    
    /**
     * <span>Descripción:</span>
     * <p>
     * Muestra un toaster de tipo warm</p>
     *
     * @param messages
     */
     
    public void warn(String... messages) {
        for (String s : messages) {
            toast(s, new Color(181, 147, 10));
        }
    }

     
    /**
     * <span>Descripción:</span>
     * <p>
     * Se encarga de crear los toasters</p>
     *
     * @param mensaje a mostrar en el toaster y el color de fondo del mismo en código RGB
     */
    
    
    private void toast(String message, Color bgColor) {
        ToasterBody toasterBody;

        if (toasterBodies.isEmpty()) {
            toasterBody = new ToasterBody(panelToToastOn, message, bgColor, STARTING_Y_POS);
            CURRENT_Y_OFFSET.set(STARTING_Y_POS + toasterBody.getHeightOfToast());
        } else {
            toasterBody = new ToasterBody(panelToToastOn, message, bgColor, CURRENT_Y_OFFSET.get() + SPACER_DISTANCE);
            CURRENT_Y_OFFSET.addAndGet(SPACER_DISTANCE + toasterBody.getHeightOfToast());
        }

        toasterBodies.add(toasterBody);

        new Thread(() -> {
            toasterBody.addMouseListener(new MouseAdapter() {
                @Override
                public void mousePressed(MouseEvent e) {
                    removeToast(toasterBody);
                }
            });

            panelToToastOn.add(toasterBody, 0);
            panelToToastOn.repaint();

            try {
                Thread.sleep(1000);
                removeToast(toasterBody);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }).start();
    }

    //Remueve el toaster del panel de forma automática 
    private synchronized void removeToast(ToasterBody toasterBody) {
        if (!toasterBody.getStopDisplaying()) {
            toasterBody.setStopDisplaying(true);

            toasterBodies.forEach(toasterBody1 -> {
                if (toasterBodies.indexOf(toasterBody1) >= toasterBodies.indexOf(toasterBody)) {
                    toasterBody1.setyPos(toasterBody1.getyPos() - toasterBody.getHeightOfToast() - SPACER_DISTANCE);
                }
            });

            toasterBodies.remove(toasterBody);

            CURRENT_Y_OFFSET.set(CURRENT_Y_OFFSET.get() - SPACER_DISTANCE - toasterBody.getHeightOfToast());

            panelToToastOn.remove(toasterBody);
            panelToToastOn.repaint();
        }
    }
}
