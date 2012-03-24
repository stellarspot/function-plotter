/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package plotter;

import math.Function;
import java.awt.Canvas;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import math.Complex;
import math.PlaneToComplex;

/**
 *
 * @author stellarspot
 */
public class PlotterCanvas extends Canvas {

    int width;
    int height;
    Plotter plotter;
    double scale;

    public PlotterCanvas(int width, int height, Plotter plotter) {
        this.width = width;
        this.height = height;
        this.plotter = plotter;
    }

//    List<PlotterItem> items = new LinkedList<PlotterItem>();
//
//    public void add(PlotterItem item) {
//        items.add(item);
//    }
//
//    public List<PlotterItem> getItems() {
//        return items;
//    }
    @Override
    public void paint(Graphics g) {


        scale = plotter.scale;

        Graphics2D g2 = (Graphics2D) g;

        g2.setColor(Color.WHITE);
        g2.fillRect(0, 0, width, height);
        g2.translate(width / 2, height / 2);
        g2.scale(1, -1);
        //g2.setBackground(Color.WHITE);
        

        for (PlotterItem item : plotter.items) {
            draw(g2, item);
        }

        for (PlotterPlaneComplexItem item : plotter.planeComplexItems) {
            draw(g2, item);
        }

    }

    void draw(Graphics2D g, PlotterItem item) {

        //System.out.println("Draw Item");
        g.setColor(item.color);

        Function f = item.f;

        PlotterDomain d = item.domain;

        double dx = d.delta;
        double x1 = d.min;
        double y1 = f.calculate(x1);
        double max = d.max;

        while (x1 <= max) {
            //System.out.println("x: " + x1 + ", y: " + y1 + ", dx: " + dx);
            double x2 = x1 + dx;
            double y2 = f.calculate(x2);

            //g.drawLine((int) x1, (int) y1, (int) x2, (int) y2);
            drawPlotterLine(g, x1, y1, x2, y2);

            x1 = x2;
            y1 = y2;

        }


    }

    void draw(Graphics2D g, PlotterPlaneComplexItem item) {


        g.setColor(item.color);

        PlaneToComplex f = item.f;
        PlotterDomain domainX = item.domainX;
        PlotterDomain domainY = item.domainY;

        System.out.println("X min: " + domainX.min);
        System.out.println("Y min: " + domainY.min);
        
        for (double x1 = domainX.min; x1 < domainX.max; x1 += domainX.delta) {
            for (double x2 = domainY.min; x2 < domainY.max; x2 += domainY.delta) {

                Complex c = f.calculate(x1, x2);

                draw(g, x1, x2, c);
            }
        }


    }

    void draw(Graphics2D g, double x, double y, Complex c) {

        double x2 = x + c.getRe();
        double y2 = y + c.getIm();

        drawPlotterLine(g, x, y, x2, y2);
        drawPlotterPoint(g, x2, y2);
        //g.drawLine((int) x, (int) y, (int) x2, (int) y2);
    }

    void drawPlotterLine(Graphics2D g, double x1, double y1, double x2, double y2) {
        g.drawLine((int) (scale * x1), (int) (scale * y1), (int) (scale * x2), (int) (scale * y2));
    }

    void drawPlotterPoint(Graphics2D g, double x, double y) {

        double r = 1;
        double r2 = 2 * r;
        g.drawOval((int) (scale * x - r), (int) (scale * y - r), (int) r2, (int) r2);
    }
}
