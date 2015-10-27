package com.eafit.dis.cgonza47.ananum20152.utilidades.Sistemas_de_Ecuaciones;

import java.io.Serializable;

public class DatosIterativos implements Serializable {

    private static final long serialVersionUID = 1L;
    double[][] A;
    double[] b;
    double[] x0;
    int iteraciones;
    double tolerancia;
    double alpha;

    public DatosIterativos(double[][] a, double[] b, double[] x0, int iteraciones, double tolerancia, double alpha) {
        A = a;
        this.b = b;
        this.x0 = x0;
        this.iteraciones = iteraciones;
        this.tolerancia = tolerancia;
        this.alpha = alpha;
    }

    public double[][] getA() {
        return A;
    }

    public void setA(double[][] a) {
        A = a;
    }

    public double[] getB() {
        return b;
    }

    public void setB(double[] b) {
        this.b = b;
    }

    public double[] getX0() {
        return x0;
    }

    public void setX0(double[] x0) {
        this.x0 = x0;
    }

    public int getIteraciones() {
        return iteraciones;
    }

    public void setIteraciones(int iteraciones) {
        this.iteraciones = iteraciones;
    }

    public double getTolerancia() {
        return tolerancia;
    }

    public void setTolerancia(double tolerancia) {
        this.tolerancia = tolerancia;
    }

    public double getAlpha() {
        return alpha;
    }

    public void setAlpha(double alpha) {
        this.alpha = alpha;
    }
}
