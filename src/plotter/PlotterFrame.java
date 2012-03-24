/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package plotter;

import java.awt.Color;
import javax.swing.JFrame;
import javax.swing.SwingUtilities;

/**
 *
 * @author stellarspot
 */
public class PlotterFrame extends JFrame{
    
    
    static final int WIDTH = 1000;
    static final int HEIGHT = 800;
    
    
    public PlotterFrame(String title, int width, int height, Plotter plotter){
        setTitle(title);
        setSize(width, height);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setBackground(Color.WHITE);
        PlotterCanvas canvas = new PlotterCanvas(width, height, plotter);
        
        getContentPane().add(canvas);
        
        
        setVisible(true);
        
    }
    
    
    public static void createAndShow(final Plotter plotter){
        SwingUtilities.invokeLater(new Runnable() {

            @Override
            public void run() {
                PlotterFrame frame = new PlotterFrame("Plotter Sample", WIDTH, HEIGHT, plotter);
            }
        });
        
    }
    
}
