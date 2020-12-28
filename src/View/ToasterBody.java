package View;


import javax.swing.*;
import java.awt.*;


/**
 * <span>Descripción:</span>
 * <p>
 * Permite la configuración de altura, posición, aspecto, fuente 
 * y fondo del aviso interactivo</p>
 *
 * @author Daniel Felipe Lozada Ramirez Email: dflozada2@misena.edu.co
 * @author Edgar Steve Pava Email: Espava60@misena.edu.co
 * @version 1.1.0
 * @since 2020
 */

class ToasterBody extends JPanel {

    //Declaración de constantes y variables globales de ToasterBody
    
    /**
     *
     */
    
    private static final int TOAST_PADDING = 15;
    private final int toastWidth;
    private final String message;
    private final Color c;
    private volatile boolean stopDisplaying;
    private final int heightOfToast;
    private final int stringPosX;
    private final int stringPosY;
    private int yPos;
    private final JPanel panelToToastOn;

    //Constructor de la clase ToasterBody
   
     /**
     * <p>
     * Método Constructor del visualizador</p>
     */
    
    public ToasterBody(JPanel panelToToastOn, String message, Color bgColor, int yPos) {
        this.panelToToastOn = panelToToastOn;
        this.message = message;
        this.yPos = yPos;
        this.c = bgColor;
        
        //Establece la fuente de los toasters
       FontMetrics metrics = getFontMetrics(UIUtils.FONT_GENERAL_UI);
        int stringWidth = metrics.stringWidth(this.message);
        
        //Obtiene y procesa las dimensiones del panel para establecer el toaster en el centro del panel
        toastWidth = stringWidth + (TOAST_PADDING * 2);
        heightOfToast = metrics.getHeight() + TOAST_PADDING;
        setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        setOpaque(false);
        setBounds((panelToToastOn.getWidth() - toastWidth) / 2, (int) -(Math.round(heightOfToast / 10.0) * 10), toastWidth, heightOfToast);

        stringPosX = (getWidth() - stringWidth) / 2;
        stringPosY = ((getHeight() - metrics.getHeight()) / 2) + metrics.getAscent();

        new Thread(() -> {
            while (getBounds().y < yPos) {
                int i1 = (yPos - getBounds().y) / 10;
                i1 = i1 <= 0 ? 1 : i1;
                setBounds((panelToToastOn.getWidth() - toastWidth) / 2, getBounds().y + i1, toastWidth, heightOfToast);
                repaint();
                try {
                    Thread.sleep(5);
                } catch (Exception ignored) {
                }
            }
        }).start();
    }
   
    //Se encarga de dibujar el toaster
    /**
     * @Override
     */
  
    protected void paintComponent(Graphics g) {
        Graphics2D g2 = UIUtils.get2dGraphics(g);
        super.paintComponent(g2);

        //Background
        
        g2.setColor(c);
        g2.fillRoundRect(0, 0, getWidth(), getHeight(), UIUtils.ROUNDNESS, UIUtils.ROUNDNESS);

        // Font
        
        g2.setFont(UIUtils.FONT_GENERAL_UI);
        g2.setColor(Color.white);
        g2.drawString(message, stringPosX, stringPosY);
    }
    //Obtiene el alto del toaster
    
    public int getHeightOfToast() {
        return heightOfToast;
    }
    //Detiene la visualización del toaster
    
    public synchronized boolean getStopDisplaying() {
        return stopDisplaying;
    }
    //Establece la pausa de la visualización del toaster
    
    public synchronized void setStopDisplaying(boolean hasStoppedDisplaying) {
        this.stopDisplaying = hasStoppedDisplaying;
    }
    //Establece la posición del toaster respecto al eje Y
    
    public void setyPos(int yPos) {
        this.yPos = yPos;
//        setBounds((panelToToastOn.getWidth() - toastWidth) / 2, yPos, toastWidth, heightOfToast);

        new Thread(() -> {
            while (getBounds().y > yPos) {
                int i1 = Math.abs((yPos - getBounds().y) / 10);
                i1 = i1 <= 0 ? 1 : i1;
                setBounds((panelToToastOn.getWidth() - toastWidth) / 2, getBounds().y - i1, toastWidth, heightOfToast);
                repaint();
                try {
                    Thread.sleep(20);
                } catch (Exception ignored) {
                }
            }
        }).start();
    }
    //Obtiene la posición del toaster respecto al eje Y
    
    public int getyPos() {
        return yPos;
    }
}
