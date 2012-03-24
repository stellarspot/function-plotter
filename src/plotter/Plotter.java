/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package plotter;

import java.util.LinkedList;
import java.util.List;

/**
 *
 * @author stellarspot
 */
public class Plotter {
 
    double scale = 1.0;

    public void setScale(double scale) {
        this.scale = scale;
    }
    
    List<PlotterItem> items = new LinkedList<>();
    List<PlotterPlaneComplexItem> planeComplexItems = new LinkedList<>();
    
    
    public void add(PlotterItem item){
        items.add(item);
    }

    public void add(PlotterPlaneComplexItem item){
        planeComplexItems.add(item);
    }
    
    
    public List<PlotterItem> getItems() {
        return items;
    }
    
    
}
