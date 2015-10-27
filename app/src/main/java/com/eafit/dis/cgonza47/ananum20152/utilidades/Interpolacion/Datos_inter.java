package com.eafit.dis.cgonza47.ananum20152.utilidades.Interpolacion;

import java.io.Serializable;

public class Datos_inter implements Serializable {

    private static final long serialVersionUID = 1L;

    private Double x[];
    private Double y[];
    private double fx;

    public Datos_inter(Double[] x, Double[] y, double fx) {

        this.x = x;
        this.y = y;
        this.fx = fx;

    }

    public Double[] getX() {
        return x;
    }

    public void setX(Double[] x) {
        this.x = x;
    }

    public Double[] getY() {
        return y;
    }

    public void setY(Double[] y) {
        this.y = y;
    }

    public double getFx() {
        return fx;
    }

    public void setFx(double fx) {
        this.fx = fx;
    }
}
