package com.eafit.dis.cgonza47.ananum20152.utilidades;

import java.io.Serializable;
import java.util.ArrayList;


public class metodos implements Serializable {

    private static final long serialVersionUID = 1L;

    private String funcion;
    private funciones evalFunc;

    /*Biseccion arrays */

    private ArrayList<Integer> iter_bisec = new ArrayList<Integer>();
    private ArrayList<Double> a_bisec = new ArrayList<Double>();
    private ArrayList<Double> b_bisec = new ArrayList<Double>();
    private ArrayList<Double> xm_bisec = new ArrayList<Double>();
    private ArrayList<Double> fa_bisec = new ArrayList<Double>();
    private ArrayList<Double> fb_bisec = new ArrayList<Double>();
    private ArrayList<Double> fm_bisec = new ArrayList<Double>();
    private ArrayList<Double> error_bisec = new ArrayList<Double>();

    public ArrayList<Integer> getIter_bisec() {
        return iter_bisec;
    }

    public void setIter_bisec(ArrayList<Integer> iter_bisec) {
        this.iter_bisec = iter_bisec;
    }

    public ArrayList<Double> getA_bisec() {
        return a_bisec;
    }

    public void setA_bisec(ArrayList<Double> a_bisec) {
        this.a_bisec = a_bisec;
    }

    public ArrayList<Double> getB_bisec() {
        return b_bisec;
    }

    public void setB_bisec(ArrayList<Double> b_bisec) {
        this.b_bisec = b_bisec;
    }

    public ArrayList<Double> getXm_bisec() {
        return xm_bisec;
    }

    public void setXm_bisec(ArrayList<Double> xm_bisec) {
        this.xm_bisec = xm_bisec;
    }

    public ArrayList<Double> getFa_bisec() {
        return fa_bisec;
    }

    public void setFa_bisec(ArrayList<Double> fa_bisec) {
        this.fa_bisec = fa_bisec;
    }

    public ArrayList<Double> getFb_bisec() {
        return fb_bisec;
    }

    public void setFb_bisec(ArrayList<Double> fb_bisec) {
        this.fb_bisec = fb_bisec;
    }

    public ArrayList<Double> getFm_bisec() {
        return fm_bisec;
    }

    public void setFm_bisec(ArrayList<Double> fm_bisec) {
        this.fm_bisec = fm_bisec;
    }

    public ArrayList<Double> getError_bisec() {
        return error_bisec;
    }

    public void setError_bisec(ArrayList<Double> error_bisec) {
        this.error_bisec = error_bisec;
    }

    /*--------------------------------------------------------------------------------------------*/

    /*Regla Falsa arrays */

    private ArrayList<Integer> iter_rg = new ArrayList<Integer>();
    private ArrayList<Double> a_rg = new ArrayList<Double>();
    private ArrayList<Double> b_rg = new ArrayList<Double>();
    private ArrayList<Double> xm_rg = new ArrayList<Double>();
    private ArrayList<Double> fa_rg = new ArrayList<Double>();
    private ArrayList<Double> fb_rg = new ArrayList<Double>();
    private ArrayList<Double> fm_rg = new ArrayList<Double>();
    private ArrayList<Double> error_rg = new ArrayList<Double>();


    public ArrayList<Double> getFa_rg() {
        return fa_rg;
    }

    public void setFa_rg(ArrayList<Double> fa_rg) {
        this.fa_rg = fa_rg;
    }

    public ArrayList<Double> getError_rg() {
        return error_rg;
    }

    public void setError_rg(ArrayList<Double> error_rg) {
        this.error_rg = error_rg;
    }

    public ArrayList<Double> getFm_rg() {
        return fm_rg;
    }

    public void setFm_rg(ArrayList<Double> fm_rg) {
        this.fm_rg = fm_rg;
    }

    public ArrayList<Double> getFb_rg() {
        return fb_rg;
    }

    public void setFb_rg(ArrayList<Double> fb_rg) {
        this.fb_rg = fb_rg;
    }

    public ArrayList<Double> getXm_rg() {
        return xm_rg;
    }

    public void setXm_rg(ArrayList<Double> xm_rg) {
        this.xm_rg = xm_rg;
    }

    public ArrayList<Double> getB_rg() {
        return b_rg;
    }

    public void setB_rg(ArrayList<Double> b_rg) {
        this.b_rg = b_rg;
    }

    public ArrayList<Double> getA_rg() {
        return a_rg;
    }

    public void setA_rg(ArrayList<Double> a_rg) {
        this.a_rg = a_rg;
    }

    public ArrayList<Integer> getIter_rg() {
        return iter_rg;
    }

    public void setIter_rg(ArrayList<Integer> iter_rg) {
        this.iter_rg = iter_rg;
    }

    /*--------------------------------------------------------------------------------------------*/

    /*Punto fijo*/

    private ArrayList<Integer> iter_pf = new ArrayList<Integer>();
    private ArrayList<Double> vi_pf = new ArrayList<Double>();
    private ArrayList<Double> gx_pf = new ArrayList<Double>();
    private ArrayList<Double> fx_pf = new ArrayList<Double>();
    private ArrayList<Double> error_pf = new ArrayList<Double>();

    public ArrayList<Double> getError_pf() {
        return error_pf;
    }

    public void setError_pf(ArrayList<Double> error_pf) {
        this.error_pf = error_pf;
    }

    public ArrayList<Double> getFx_pf() {
        return fx_pf;
    }

    public void setFx_pf(ArrayList<Double> fx_pf) {
        this.fx_pf = fx_pf;
    }

    public ArrayList<Double> getGx_pf() {
        return gx_pf;
    }

    public void setGx_pf(ArrayList<Double> gx_pf) {
        this.gx_pf = gx_pf;
    }

    public ArrayList<Double> getVi_pf() {
        return vi_pf;
    }

    public void setVi_pf(ArrayList<Double> vi_pf) {
        this.vi_pf = vi_pf;
    }

    public ArrayList<Integer> getIter_pf() {
        return iter_pf;
    }

    public void setIter_pf(ArrayList<Integer> iter_pf) {
        this.iter_pf = iter_pf;
    }

    /*--------------------------------------------------------------------------------------------*/

    /*Newton Arrays*/

    private ArrayList<Integer> iter_new = new ArrayList<Integer>();
    private ArrayList<Double> vi_new = new ArrayList<Double>();
    private ArrayList<Double> gx_new = new ArrayList<Double>();
    private ArrayList<Double> fx_new = new ArrayList<Double>();
    private ArrayList<Double> error_new = new ArrayList<Double>();

    public ArrayList<Double> getError_new() {
        return error_new;
    }

    public void setError_new(ArrayList<Double> error_new) {
        this.error_new = error_new;
    }

    public ArrayList<Double> getFx_new() {
        return fx_new;
    }

    public void setFx_new(ArrayList<Double> fx_new) {
        this.fx_new = fx_new;
    }

    public ArrayList<Double> getGx_new() {
        return gx_new;
    }

    public void setGx_new(ArrayList<Double> gx_new) {
        this.gx_new = gx_new;
    }

    public ArrayList<Double> getVi_new() {
        return vi_new;
    }

    public void setVi_new(ArrayList<Double> vi_new) {
        this.vi_new = vi_new;
    }

    public ArrayList<Integer> getIter_new() {
        return iter_new;
    }

    public void setIter_new(ArrayList<Integer> iter_new) {
        this.iter_new = iter_new;
    }

    /*--------------------------------------------------------------------------------------------*/

    /*Secante Arrays*/

    private ArrayList<Integer> iter_sec = new ArrayList<Integer>();
    private ArrayList<Double> vi_sec = new ArrayList<Double>();
    private ArrayList<Double> fxs_sec = new ArrayList<Double>();
    private ArrayList<Double> fxa_sec = new ArrayList<Double>();
    private ArrayList<Double> xisminusxia = new ArrayList<Double>();
    private ArrayList<Double> error_sec = new ArrayList<Double>();

    public ArrayList<Double> getError_sec() {
        return error_sec;
    }

    public void setError_sec(ArrayList<Double> error_sec) {
        this.error_sec = error_sec;
    }

    public ArrayList<Double> getXisminusxia() {
        return xisminusxia;
    }

    public void setXisminusxia(ArrayList<Double> xisminusxia) {
        this.xisminusxia = xisminusxia;
    }

    public ArrayList<Double> getFxa_sec() {
        return fxa_sec;
    }

    public void setFxa_sec(ArrayList<Double> fxa_sec) {
        this.fxa_sec = fxa_sec;
    }

    public ArrayList<Double> getFxs_sec() {
        return fxs_sec;
    }

    public void setFxs_sec(ArrayList<Double> fxs_sec) {
        this.fxs_sec = fxs_sec;
    }

    public ArrayList<Double> getVi_sec() {
        return vi_sec;
    }

    public void setVi_sec(ArrayList<Double> vi_sec) {
        this.vi_sec = vi_sec;
    }

    public ArrayList<Integer> getIter_sec() {
        return iter_sec;
    }

    public void setIter_sec(ArrayList<Integer> iter_sec) {
        this.iter_sec = iter_sec;
    }

    /*--------------------------------------------------------------------------------------------*/

    /*Raices Multiples Arrays*/

    private ArrayList<Integer> iter_rm = new ArrayList<Integer>();
    private ArrayList<Double> vi_rm = new ArrayList<Double>();
    private ArrayList<Double> fpx_rm = new ArrayList<Double>();
    private ArrayList<Double> fx_rm = new ArrayList<Double>();
    private ArrayList<Double> fpp_rm = new ArrayList<Double>();
    private ArrayList<Double> error_rm = new ArrayList<Double>();

    public ArrayList<Double> getError_rm() {
        return error_rm;
    }

    public void setError_rm(ArrayList<Double> error_rm) {
        this.error_rm = error_rm;
    }

    public ArrayList<Double> getFpp_rm() {
        return fpp_rm;
    }

    public void setFpp_rm(ArrayList<Double> fpp_rm) {
        this.fpp_rm = fpp_rm;
    }

    public ArrayList<Double> getFx_rm() {
        return fx_rm;
    }

    public void setFx_rm(ArrayList<Double> fx_rm) {
        this.fx_rm = fx_rm;
    }

    public ArrayList<Double> getFpx_rm() {
        return fpx_rm;
    }

    public void setFpx_rm(ArrayList<Double> fpx_rm) {
        this.fpx_rm = fpx_rm;
    }

    public ArrayList<Double> getVi_rm() {
        return vi_rm;
    }

    public void setVi_rm(ArrayList<Double> vi_rm) {
        this.vi_rm = vi_rm;
    }

    public ArrayList<Integer> getIter_rm() {
        return iter_rm;
    }

    public void setIter_rm(ArrayList<Integer> iter_rm) {
        this.iter_rm = iter_rm;
    }

    /*--------------------------------------------------------------------------------------------*/

    /*Busquedas Incrementales Arrays*/

    private ArrayList<Double> x_bi = new ArrayList<Double>();
    private ArrayList<Double> result_bi = new ArrayList<Double>();
    private ArrayList<Integer> iter_bi = new ArrayList<Integer>();

    public ArrayList<Double> getX_bi() {
        return x_bi;
    }

    public void setX_bi(ArrayList<Double> x_bi) {
        this.x_bi = x_bi;
    }

    public ArrayList<Double> getResult_bi() {
        return result_bi;
    }

    public void setResult_bi(ArrayList<Double> result_bi) {
        this.result_bi = result_bi;
    }

    public ArrayList<Integer> getIter_bi() {
        return iter_bi;
    }

    public void setIter_bi(ArrayList<Integer> iter_bi) {
        this.iter_bi = iter_bi;
    }

    /*--------------------------------------------------------------------------------------------*/


    public metodos(String funcion) {

        this.funcion = funcion;

        this.evalFunc = new funciones(funcion);

    }

    /*EVALUAR FUNCION*/

    double funcion(double x) {

        return evalFunc.calculate(x);

    }

    /*VALOR ABSOLUTO*/

    public static double abs(double numero) {
        return numero > 0 ? numero : -numero;
    }

    /*GETTERS AND SETTERS*/

    public String getFuncion() {
        return funcion;
    }

    public void setFuncion(String funcion) {
        this.funcion = funcion;
    }

    /*METODOS DE ECUACIONES DE UNA VARIABLE*/

    public String busquedas_incrementales(double x0, double delta, int iter) {

        double y0;

        y0 = funcion_norm(x0, this.funcion);

        if (y0 == 0) {

            return (x0 + " es una raiz");

        } else {
            if (delta == 0) {

                return ("Ingrese un " + delta + "adecuado");

            } else {
                if (iter <= 0) {

                    return ("Ingrese un numero de iteraciones adecuado");

                } else {

                    x_bi.add(x0);
                    result_bi.add(y0);
                    iter_bi.add(0);

                    double x1 = x0 + delta;
                    double y1 = funcion_norm(x1, this.funcion);
                    int contador = 1;

                    while (y0 * y1 > 0 && contador < iter) {

                        x0 = x1;
                        y0 = y1;
                        x1 = x0 + delta;
                        y1 = funcion_norm(x1, this.funcion);
                        iter_bi.add(contador);
                        contador = contador + 1;
                        x_bi.add(x0);
                        result_bi.add(y0);
                    }
                    iter_bi.add(contador);
                    x_bi.add(x1);
                    result_bi.add(y1);
                    if (y1 == 0) {
                        return (x1 + " es una raíz");
                    } else {
                        if (y0 * y1 < 0) {
                            return ("(" + x0 + " - " + x1 + ") es un intervalo");
                        } else {
                            return ("El algoritmo fracaso en estas interaciones: " + iter);
                        }
                    }
                }
            }
        }
    }

    public String biseccion(double x0, double x1, double tolerancia, int iter, boolean ti_err) {

        iter_bisec.clear();
        a_bisec.clear();
        b_bisec.clear();
        xm_bisec.clear();
        fa_bisec.clear();
        fb_bisec.clear();
        fm_bisec.clear();

        double y0 = funcion_norm(x0, this.funcion);

        double y1 = funcion_norm(x1, this.funcion);

        if (y0 == 0) {

            return x0 + " es una raiz";

        } else if (tolerancia > 1) {

            return "Ingrese una tolerancia adecuada";

        } else if (iter <= 0) {

            return "Ingrese un numero de iteraciones adecuado";

        } else if (y1 == 0) {

            return x1 + " es una raiz";

        } else if (y0 * y1 < 0) {


            double xm = (x0 + x1) / 2;
            double ym = funcion_norm(xm, this.funcion);
            iter_bisec.add(0);
            a_bisec.add(x0);
            b_bisec.add(x1);
            xm_bisec.add(xm);
            fa_bisec.add(y0);
            fb_bisec.add(y1);
            fm_bisec.add(ym);
            int contador = 1;
            double error = tolerancia + 1;

            error_bisec.add(0.0);

            while (error > tolerancia && ym != 0 && contador < iter) {

                if (y0 * ym < 0) {

                    x1 = xm;
                    y1 = ym;

                } else {

                    x0 = xm;
                    y0 = ym;

                }

                double temp = xm;
                xm = (x0 + x1) / 2;
                ym = funcion_norm(xm,this.funcion);

                if (ti_err) {
                    error = Math.abs(xm - temp);
                    error_bisec.add(error);
                } else {
                    error = Math.abs((xm - temp) / xm);
                    error_bisec.add(error);
                }

                iter_bisec.add(contador);
                a_bisec.add(x0);
                b_bisec.add(x1);
                xm_bisec.add(xm);
                fa_bisec.add(y0);
                fb_bisec.add(y1);
                fm_bisec.add(ym);
                contador++;

            }

            if (ym == 0) {

                return xm + " es una raiz";

            } else if (error < tolerancia) {

                return xm + " es una aproximacion a una raiz con una tolerancia = " + tolerancia;

            } else {

                return ("El algoritmo fracaso en estas interaciones: " + iter);

            }
        } else {

            return ("El intervalo es inadecuado");

        }
    }

    public String Regla_Falsa(double x0, double x1, double tolerancia, int iter, boolean ti_err) {

        double y0 = funcion_norm(x0, this.funcion);
        double y1 = funcion_norm(x1, this.funcion);


        if (y0 == 0) {

            return x0 + " es una raiz";

        } else if (tolerancia > 1) {

            return "Ingrese una tolerancia adecuada";

        } else if (iter <= 0) {

            return "Ingrese un numero de iteraciones adecuado";

        } else if (y1 == 0) {

            return x1 + " es una raiz";

        } else if ((y0 * y1) < 0) {

            double xm = x0 - ((y0 * (x0 - x1)) / (y0 - y1));
            double ym = funcion_norm(xm, this.funcion);

            xm_rg.add(xm);
            iter_rg.add(0);
            a_rg.add(x0);
            b_rg.add(x1);
            fa_rg.add(y0);
            fb_rg.add(y1);
            fm_rg.add(ym);
            error_rg.add(0.0);

            double error = tolerancia + 1;
            int contador = 1;

            while ((ym != 0) && (error > tolerancia) && (contador < iter)) {

                if ((y0 * ym) < 0) {

                    x1 = xm;
                    y1 = ym;

                } else {

                    x0 = xm;
                    y0 = ym;

                }

                double temp = xm;
                xm = x0 - ((y0 * (x0 - x1)) / (y0 - y1));
                ym = funcion_norm(xm, this.funcion);

                if (ti_err) {
                    error = Math.abs(xm - temp);
                } else {
                    error = Math.abs((xm - temp) / xm);
                }

                xm_rg.add(xm);
                iter_rg.add(contador);
                a_rg.add(x0);
                b_rg.add(x1);
                fa_rg.add(y0);
                fb_rg.add(y1);
                fm_rg.add(ym);
                error_rg.add(error);

                contador++;
            }
            if (ym == 0) {

                return xm + " es una raiz";

            } else if (error <= tolerancia) {

                return xm + " es una aproximacion a una raiz con una tolerancia = " + tolerancia;

            } else {

                return ("El algoritmo fracaso en estas interaciones: " + iter);

            }
        } else {

            return ("El intervalo es inadecuado");

        }
    }


    public String Punto_fijo(double x0, double tolerancia, int iter, String funciong,
                             boolean ti_err) {

        if (tolerancia > 1) {

            return "Ingrese una tolerancia adecuada";

        } else {

            if (iter <= 0) {

                return "Ingrese un numero de iteraciones adecuado";

            } else {

                double y0 = funcion(x0);

                if (y0 == 0) {

                    return x0 + " es una raiz";

                } else {

                    int contador = 0;
                    double error = tolerancia + 1;
                    double xn = 0;

                    iter_pf.add(contador);
                    vi_pf.add(x0);
                    fx_pf.add(y0);
                    error_pf.add(0.0);

                    while (y0 != 0 && error > tolerancia && contador < iter) {

                        xn = funcion_PF(x0, funciong);

                        gx_pf.add(xn);

                        y0 = funcion_norm(xn, this.funcion);

                        if (ti_err) {
                            error = Math.abs(xn - x0);
                        } else {
                            error = Math.abs((xn - x0) / xn);
                        }
                        x0 = xn;
                        contador++;

                        iter_pf.add(contador);
                        vi_pf.add(x0);
                        fx_pf.add(y0);
                        error_pf.add(error);

                    }

                    gx_pf.add(xn);

                    if (y0 == 0) {

                        return x0 + " es una raiz";

                    } else {

                        if (error < tolerancia) {

                            return x0 + " es una aproximacion a una raiz con una tolerancia = "
                                    + tolerancia;

                        } else {

                            return ("El algoritmo fracaso en estas iteraciones: " + iter);

                        }
                    }
                }
            }
        }
    }

    private double funcion_PF(double x, String funcion) {

        funciones funcion_PF = new funciones(funcion);

        return funcion_PF.calculate(x);
    }

    private double funcion_norm(double x, String funcion) {

        funciones funcion_norm = new funciones(funcion);

        return funcion_norm.calculate(x);
    }


    public String newton(double tolerancia, double x0, int iter, String derivadaf, boolean ti_err) {

        double y0 = funcion_norm(x0,this.funcion);
        double dy0 = derivada_N(x0, derivadaf);
        double error = tolerancia + 1;
        double x1 = 0;
        int cont = 0;

        iter_new.add(cont);
        vi_new.add(x0);
        gx_new.add(dy0);
        fx_new.add(y0);
        error_new.add(0.0);

        if (tolerancia > 1) {

            return "Ingrese una tolerancia adecuada";

        } else if (iter <= 0) {

            return "Ingrese un numero de iteraciones adecuado";

        } else if (y0 == 0) {

            return x0 + " es una raiz";

        } else {

            while (y0 != 0 && dy0 != 0 && error > tolerancia && cont <
                    iter) {
                x1 = x0 - (y0 / dy0);
                y0 = funcion_norm(x1,this.funcion);
                dy0 = derivada_N(x1, derivadaf);
                if (ti_err) {
                    error = Math.abs(x1 - x0);
                } else {
                    error = Math.abs((x1 - x0) / x1);
                }
                x0 = x1;
                cont++;

                iter_new.add(cont);
                vi_new.add(x0);
                gx_new.add(dy0);
                fx_new.add(y0);
                error_new.add(error);
            }

            if (y0 == 0) {

                return x0 + " es una raiz";

            } else if (error < tolerancia) {

                return x0 + " es una aproximacion a una raiz con una tolerancia = " + tolerancia;

            } else if (dy0 == 0) {

                return x1 + "es una posible raiz multiple";

            } else {

                return ("El algoritmo fracaso en estas iteraciones: " + iter);

            }
        }
    }

    private double derivada_N(double x, String funcion) {

        funciones derivada_N = new funciones(funcion);

        return derivada_N.calculate(x);
    }

    public String secante(double x1, double x0, double tolerancia, int iter, boolean ti_err) {

        vi_sec.add(x0);
        fxa_sec.add(0.0);
        fxs_sec.add(0.0);
        error_sec.add(0.0);
        iter_sec.add(0);
        xisminusxia.add(0.0);

        double y0 = funcion_norm(x0,this.funcion);

        if (tolerancia > 1) {

            return "Ingrese una tolerancia adecuada";

        } else if (iter <= 0) {

            return "Ingrese un numero de iteraciones adecuado";

        } else if (y0 == 0) {

            return x0 + " es una raiz";

        } else {

            double y1 = funcion_norm(x1,this.funcion);
            int cont = 1;
            double error = tolerancia + 1;
            double den = y1 - y0;

            while (error > tolerancia && y1 != 0 && den != 0 && cont < iter) {

                double x2 = x1 - (y1 * (x1 - x0) / den);

                if (ti_err) {

                    error = Math.abs(x1 - x0);

                } else {

                    error = Math.abs((x1 - x0) / x1);

                }

                vi_sec.add(x1);
                fxa_sec.add(y0);
                fxs_sec.add(y1);
                error_sec.add(error);
                iter_sec.add(cont);
                xisminusxia.add(den);

                x0 = x1;
                y0 = y1;
                x1 = x2;
                y1 = funcion_norm(x1,this.funcion);
                den = y1 - y0;
                cont = cont + 1;
            }
            if (y1 == 0) {

                return x1 + " es una raiz";

            } else if (error <= tolerancia) {

                return x1 + " es una aproximacion a una raiz con una tolerancia = " + tolerancia;

            } else if (den == 0) {

                return "hay una posible raiz multiple";

            } else
                return ("El algoritmo fracaso en estas iteraciones: " + iter);
        }
    }

    public String RaicesMultiples(double tolerancia, double x0, int iter, String dfx, String ddfx,
                                  boolean tipo_err) {

        double y0 = funcion_norm(x0, this.funcion);
        double d1y0 = derivada_primera_raicesmultiples(x0, dfx);
        double d2y0 = derivada_segunda_raicesmultiples(x0, ddfx);
        double den = ((Math.pow(d1y0, 2)) - (y0 * d2y0));
        double error = tolerancia + 1;
        int cont = 0;

        iter_rm.add(cont);
        vi_rm.add(x0);
        fpx_rm.add(d1y0);
        fpp_rm.add(d2y0);
        fx_rm.add(y0);
        error_rm.add(0.0);

        if (tolerancia > 1) {

            return "Ingrese una tolerancia adecuada";

        } else if (iter <= 0) {

            return "Ingrese un numero de iteraciones adecuado";

        } else if (y0 == 0) {

            return x0 + " es una raiz";

        } else {

            while (y0 != 0 && error > tolerancia && den != 0 && cont <
                    iter) {

                double x1 = x0 - ((y0 * d1y0) / den);
                y0 = funcion_norm(x1, this.funcion);
                d1y0 = derivada_primera_raicesmultiples(x1, dfx);
                d2y0 = derivada_segunda_raicesmultiples(x1, ddfx);
                den = ((Math.pow(d1y0, 2)) - (y0 * d2y0));
                if (tipo_err) {
                    error = Math.abs(x1 - x0);
                } else {
                    error = Math.abs((x1 - x0) / x1);
                }
                x0 = x1;
                cont++;

                iter_rm.add(cont);
                vi_rm.add(x0);
                fpx_rm.add(d1y0);
                fpp_rm.add(d2y0);
                fx_rm.add(y0);
                error_rm.add(error);

            }
            if (y0 == 0) {

                return x0 + " es una raiz";

            } else if (error < tolerancia) {


                return x0 + " es una aproximacion a una raiz con una tolerancia = " + tolerancia;

            } else if (den == 0) {

                return "hay una posible raiz multiple";

            } else {

                return ("El algoritmo fracaso en estas iteraciones: " + iter);

            }
        }
    }

    private double derivada_primera_raicesmultiples(double x, String funcion) {

        funciones derivada_primera_raicesmultiples = new funciones(funcion);

        return derivada_primera_raicesmultiples.calculate(x);
    }

    private double derivada_segunda_raicesmultiples(double x, String funcion) {

        funciones derivada_segunda_raicesmultiples = new funciones(funcion);

        return derivada_segunda_raicesmultiples.calculate(x);
    }
}