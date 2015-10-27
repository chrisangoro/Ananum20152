package com.eafit.dis.cgonza47.ananum20152.utilidades;


import android.content.Context;
import android.util.Log;

import net.objecthunter.exp4j.Expression;
import net.objecthunter.exp4j.ExpressionBuilder;

import java.io.Serializable;

public class funciones implements Serializable{

    private static final long serialVersionUID = 1L;

    private static final String TAG = funciones.class.getName();

    private static Context c;
    private static funciones instance = null;
    private static Expression cal;
    private String function;

    protected funciones(String function) {

        this.function = function;
        try {
            setFunction(function);
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    public void setFunction(String function) throws Exception {
        try {
            cal = new ExpressionBuilder(function)
                    .variable("x").build();
        } catch (Exception e) {
            Log.e(TAG, "Cannot instantiate Calculator with the function: "
                    + function);
            String message = "exception";
            throw new Exception(message);
        }
    }

    public double calculate(double xValue) {
        cal.setVariable("x", xValue);
        return cal.evaluate();
    }

    public void setContext(Context c) {
        this.c = c;
    }

}
