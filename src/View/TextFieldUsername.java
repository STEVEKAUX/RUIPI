package View;

/**
 * <span>Descripción:</span>
 * <p>
 *  Campo de texto donde se registra la información del nombre de usuario
 * </p>
 *
 * @author Daniel Felipe Lozada Ramirez Email: dflozada2@misena.edu.co
 * @author Edgar Steve Pava Email: Espava60@misena.edu.co
 * @version 1.1.0
 * @since 2020
 */

import javax.swing.*;
import java.awt.*;
import java.awt.geom.RoundRectangle2D;

//Crea la clase TextFieldUsername

/**
 *
 * @author lenov
 */

public class TextFieldUsername extends JTextField {

    /**
     * Declaración de las variables y objetos de la clase TextFieldUsername
     * 
     */
     
    private Shape shape;
    private Color borderColor = UIUtils.COLOR_INTERACTIVE;

/**
     * <p>
     * Constructor de Patient la clase TextFieldUsername</p>
     */    

    public TextFieldUsername() {
        setOpaque(false);
        setBackground(UIUtils.COLOR_BACKGROUND);
        setForeground(Color.white);
        setCaretColor(Color.white);
        setCursor(Cursor.getPredefinedCursor(Cursor.TEXT_CURSOR));
        setMargin(new Insets(2, 10, 2, 2));
        setHorizontalAlignment(SwingConstants.LEFT);
        setFont(UIUtils.FONT_GENERAL_UI);
    }

    
    /**
     * <span>Descripción:</span>
     * <p>
     * Se encarga de pintar el componente del campo de texto de nombre de usuario<p>
     * 
     * @param g 
     */
        
    @Override
    protected void paintComponent(Graphics g) {
        Graphics2D g2 = UIUtils.get2dGraphics(g);
        g2.setColor(getBackground());
        g2.fillRoundRect(0, 0, getWidth() - 1, getHeight() - 1, UIUtils.ROUNDNESS, UIUtils.ROUNDNESS);
        super.paintComponent(g2);
    }
    
    /**
     * <span>Descripción:</span>
     * <p>
     * Se encarga de pintar el componente del campo de texto de nombre de usuario<p>
     * 
     * @param g 
     */
    
    @Override
    protected void paintBorder(Graphics g) {
        Graphics2D g2 = UIUtils.get2dGraphics(g);
        g2.setColor(borderColor);
        g2.drawRoundRect(0, 0, getWidth() - 1, getHeight() - 1, UIUtils.ROUNDNESS, UIUtils.ROUNDNESS);
    }

    
    /**
     * <span>Descripción:</span>
     * <p>
     * Se encarga de pintar el contenido del campo de texto de nombre de usuario<p>
     * @param x
     * @param y
     * @return
     *  
     */
        
    @Override
    public boolean contains(int x, int y) {
        if (shape == null || !shape.getBounds().equals(getBounds())) {
            shape = new RoundRectangle2D.Float(0, 0, getWidth() - 1, getHeight() - 1, UIUtils.ROUNDNESS, UIUtils.ROUNDNESS);
        }
        return shape.contains(x, y);
    }

     /**
     * <span>Descripción:</span>
     * <p>
     * Establece el color del borde del campo de texto de nombre de usuario<p>
     * 
     * @param color 
     */
         
    public void setBorderColor(Color color) {
        borderColor = color;
        repaint();
    }
}
