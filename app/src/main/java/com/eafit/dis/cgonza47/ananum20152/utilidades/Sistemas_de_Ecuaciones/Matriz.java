package com.eafit.dis.cgonza47.ananum20152.utilidades.Sistemas_de_Ecuaciones;

import java.io.Serializable;

public class Matriz implements Serializable {

    private static final long serialVersionUID = 1L;

    private double [][] matriz;

    public Matriz(double[][] matriz) {

        this.matriz = matriz;

    }

    public double[][] getMatriz() {
        return matriz;
    }

    public void setMatriz(double[][] matriz) {
        this.matriz = matriz;
    }
}
