package GUI;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class TareaFiguras extends JPanel {

    //Variables de movimiento
    int ejeX = 0, xa = 1;
    int ejeX1 = 0, xa1 = 1;
    int ejeY = 0, ya = 1;
    int ejeY1 = 0, ya1 = 1;

    //Mueve el circulo por la ventana
    private void moveCir() {
        if (ejeX + xa < 0) {
            xa = 1;
        }//end if
        if (ejeX + xa > getWidth() - 30) {
            xa = -1;
        }//end if
        if (ejeY + ya < 0) {
            ya = 1;
        }//end if
        if (ejeY + ya > getHeight() - 30) {
            ya = -1;
        }//end if

        //incrementa los valores de los ejes
        ejeX = ejeX + xa;
        ejeY = ejeY + ya;
    }//end method movecir()

    //Mueve el cuadrado por la ventana
    private void moveSquare() {
        if (ejeX1 + xa1 < 0) {
            xa1 = 2;
        }//end if
        if (ejeX1 + xa1 > getWidth() - 30) {
            xa1 = -2;
        }//end if
        if ((ejeY1 + 40) + ya1 < 0) {
            ya1 = 2;
        }//end if
        if ((ejeY1 + 40) + ya1 > getHeight() - 30) {
            ya1 = -2;
        }//end if

        //incrementa los valores de los ejes
        ejeX1 = ejeX1 + xa1;
        ejeY1 = ejeY1 + ya1;
    }//end method moveSquare

    //Metodo que da color a las figuras
    @Override
    public void paint(Graphics g) {
        super.paint(g);
        Graphics2D g2d = (Graphics2D) g;
        g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING,
                RenderingHints.VALUE_ANTIALIAS_ON);
        g.fillOval(ejeX1 - 2, ejeY1 + 40, 30, 30);
        g.setColor(Color.red);
        g.fillRect(ejeX, ejeY, 30, 30);

    }//fin metodo paint

    //metodo main 
    public static void main(String[] args) throws InterruptedException {
        JFrame frame = new JFrame("Tarea Figuras");
        TareaFiguras tfig = new TareaFiguras();
        frame.add(tfig);
        frame.setSize(300, 400);
        frame.setVisible(true);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        //mientras la ventana sea visible se añaden los componentes
        while (true) {
            tfig.moveCir();
            tfig.moveSquare();
            tfig.repaint();
            Thread.sleep(7);
        }
    }
}
