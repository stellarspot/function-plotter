/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package sample;

import math.Function;
import plotter.Plotter;
import plotter.PlotterDomain;
import plotter.PlotterFrame;
import plotter.PlotterItem;

/**
 *
 * @author stellarspot
 */
public class PlotterSample {
    public static void main(String[] args) {
        
        
        Function f = new Function() {

            @Override
            public double calculate(double x) {
                if(x == 0){
                    return 0;
                }else{
                    return 0.5 * Math.sin(20 * x)/x;
                }
            }
        };
        
        Plotter plotter = new Plotter();
        plotter.setScale(40);
        
        double x = 5;
        double dx = 0.01;
        plotter.add(new PlotterItem(new PlotterDomain(-x, x, dx), f));
        PlotterFrame.createAndShow(plotter);
    }
}
