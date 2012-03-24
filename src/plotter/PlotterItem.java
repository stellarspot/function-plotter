/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package plotter;

import java.awt.Color;
import math.Function;

/**
 *
 * @author stellarspot
 */
public class PlotterItem {

    PlotterDomain domain;
    Function f;
    Color color;

    public PlotterItem(PlotterDomain domain, Function f) {
        this(domain, f, Color.BLUE);
    }

    public PlotterItem(PlotterDomain domain, Function f, Color color) {
        this.domain = domain;
        this.f = f;
        this.color = color;
    }
}
