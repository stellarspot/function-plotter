/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package math;

/**
 *
 * @author stellarspot
 */
public class Complex {
 
    private double re;
    private double im;

    public Complex() {
        this(0,0);
    }

    public Complex(double re, double im) {
        this.re = re;
        this.im = im;
    }

    public double getIm() {
        return im;
    }

    public void setIm(double im) {
        this.im = im;
    }

    public double getRe() {
        return re;
    }

    public void setRe(double re) {
        this.re = re;
    }
    
    public Complex add(Complex c){
        return new Complex(re + c.re, im + c.im);
    }
    
    public static Complex polar(double r, double phi){
        double re = r * Math.cos(phi);
        double im = r * Math.sin(phi);
        return new Complex(re, im);
        
    }
}
