package GUI;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class TareaFiguras extends JPanel {

    int ejeX = 0, xa = 1;
    int ejeX1 = 0, xa1 = 1;
    int ejeY = 0, ya = 1;
    int ejeY1 = 0, ya1 = 1;

    private void moveCir() {
        if (ejeX + xa < 0) {
            xa = 1;
        }
        if (ejeX + xa > getWidth() - 30) {
            xa = -1;
        }
        if (ejeY + ya < 0) {
            ya = 1;
        }
        if (ejeY + ya > getHeight() - 30) {
            ya = -1;
        }

        ejeX = ejeX + xa;
        ejeY = ejeY + ya;
    }

    private void moveSquare() {
        if (ejeX1 + xa1 < 0) {
            xa1 = 2;
        }
        if (ejeX1 + xa1 > getWidth() - 30) {
            xa1 = -2;
        }
        if ((ejeY1+40) + ya1 < 0) {
            ya1 = 2;
        }
        if ((ejeY1+40) + ya1 > getHeight() - 30) {
            ya1 = -2;
        }

        ejeX1 = ejeX1 + xa1;
        ejeY1 = ejeY1 + ya1;
    }

    @Override
    public void paint(Graphics g) {
        super.paint(g);
        Graphics2D g2d = (Graphics2D) g;
        g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING,
                RenderingHints.VALUE_ANTIALIAS_ON);
        g.fillOval(ejeX1 - 2, ejeY1 + 40, 30, 30);
        g.setColor(Color.red);
        g.fillRect(ejeX, ejeY, 30, 30);

    }

    public static void main(String[] args) throws InterruptedException {
        JFrame frame = new JFrame("Tarea Figuras");
        TareaFiguras tfig = new TareaFiguras();
        frame.add(tfig);
        frame.setSize(300, 400);
        frame.setVisible(true);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        while (true) {
            tfig.moveCir();
            tfig.moveSquare();
            tfig.repaint();
            Thread.sleep(7);
        }
    }
}
