/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package plotter;

import java.awt.Color;
import math.PlaneToComplex;

/**
 *
 * @author stellarspot
 */
public class PlotterPlaneComplexItem {

    PlotterDomain domainX;
    PlotterDomain domainY;
    
    PlaneToComplex f;
    Color color;

    public PlotterPlaneComplexItem(PlotterDomain domainX, PlotterDomain domainY, PlaneToComplex f, Color color) {
        this.domainX = domainX;
        this.domainY = domainY;
        this.f = f;
        this.color = color;
    }
    
    
    
    
}
