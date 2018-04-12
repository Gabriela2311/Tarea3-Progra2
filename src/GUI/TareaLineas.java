/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

/**
 *
 * @author Gabriela
 */


import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import javax.swing.JFrame;
import javax.swing.JPanel;


public class TareaLineas extends JPanel{
    
    // Constructor 
    public TareaLineas() {
        
        //Tamaño de la tabla
        this.setPreferredSize(new Dimension(800, 500));
    } 

    // Dibuja las lineas 
    private void drawLine(Graphics g){
        
        // dibujar los ejes del plano cartesiano
        for (int i = 0; i < 1000; i++) {
            g.setColor(Color.cyan);
            double x,y,x0,y0;
            y0= (Math.random()*900);
            x0= (Math.random()*900);
            y= (Math.random()*900);
            x= (Math.random()*900);

            linearFunction(g, x, y, x0, y0);

        }// fin del for 


    } // Fin del draw
    
    private void linearFunction(Graphics g, double x0, double y0, double x1, double y1){        
        
        double y;
        //double punto;
        
        //calculo de pendiente y del termino b (interseccion con eje y)
        double m = (y0 - y1) / (x0 - x1);
        double b = y0 - ((y0 - y1) / (x0 - x1)) * x0;
        
        for(double x = x0; x <= x1; x += 1){
             y = (m * x + b);
             g.drawLine((int)coord_x(x), (int)coord_y(y), (int)coord_x(x), (int)coord_y(y)); 
        } // fin del for

    }// fin del linearFunction
    
    private double coord_x(double x)
    {
        return x;
    }
    
     //transfoma el eje de las y como sifuera un plano cartesiano (el da vuelta y el y funciona 
        //de abajo hacia arriba)
    private double coord_y(double y){
        double real_y = (double)this.getHeight() - y;
        return real_y;
    }   //fin coord_y
   //Dibuja la linea
   @Override
    protected void paintComponent(Graphics g) {
        
        super.paintComponent(g);
        // se llama al metodo draw
        drawLine(g);
    }//fin metodo painComponent
    
    public static void main(String[] args) {
        JFrame window = new JFrame(" Draw Lines ");
        window.setContentPane(new TareaLineas());
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        window.pack();
        window.setResizable(false);
        window.setLocation(150, 100);
        window.setVisible(true);         
    }//fin main

    
} // fin clase
