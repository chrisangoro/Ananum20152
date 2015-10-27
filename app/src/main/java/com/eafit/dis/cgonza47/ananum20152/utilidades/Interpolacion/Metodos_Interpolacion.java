package com.eafit.dis.cgonza47.ananum20152.utilidades.Interpolacion;

import java.util.ArrayList;

public class Metodos_Interpolacion {


    private String polinomio_newton;
    private ArrayList<Double> xi_newton = new ArrayList<Double>();
    private ArrayList<String> fs_newton = new ArrayList<String>();
    private ArrayList<Double> fsD_newton = new ArrayList<Double>();
    private String resultado_newton;

    public String getPolinomio_newton() {
        return polinomio_newton;
    }

    public void setPolinomio_newton(String polinomio_newton) {
        this.polinomio_newton = polinomio_newton;
    }

    public ArrayList<Double> getXi_newton() {
        return xi_newton;
    }

    public void setXi_newton(ArrayList<Double> xi_newton) {
        this.xi_newton = xi_newton;
    }

    public ArrayList<String> getFs_newton() {
        return fs_newton;
    }

    public void setFs_newton(ArrayList<String> fs_newton) {
        this.fs_newton = fs_newton;
    }

    public ArrayList<Double> getFsD_newton() {
        return fsD_newton;
    }

    public void setFsD_newton(ArrayList<Double> fsD_newton) {
        this.fsD_newton = fsD_newton;
    }

    public String getResultado_newton() {
        return resultado_newton;
    }

    public void setResultado_newton(String resultado_newton) {
        this.resultado_newton = resultado_newton;
    }

    public void interpolacionNewtonDiferenciasDivididas(double valor, Double[] x, Double[] y) {

        if (x.length == y.length) {

            int nroPuntos = x.length;

            double[][] tabla = new double[nroPuntos][nroPuntos];

            for (int i = 0; i < nroPuntos; i++) {
                tabla[i][0] = y[i];
            }

            for (int i = 0; i < nroPuntos; i++) {
                for (int j = 1; j < i + 1; j++) {
                    tabla[i][j] = (tabla[i][j - 1] - tabla[i - 1][j - 1]) / (x[i] - x[i - j]);

                }
            }
            imprimirMatriz_Newton(tabla, nroPuntos, x);
            String pol = "P(x): " + String.valueOf(tabla[0][0]);
            String temp = "";
            double resultado = tabla[0][0];
            double aux = 1;
            for (int i = 1; i < nroPuntos; i++) {
                temp = temp + "(x" + "-" + (x[i - 1]) + ")";
                pol = pol + " " + (tabla[i][i] > 0 ? "+" : "") + (tabla[i][i] + "*" + temp);
                aux = aux * (valor - x[i - 1]);
                resultado = resultado + tabla[i][i] * aux;
            }

            polinomio_newton = pol;
            resultado_newton = ("f(" + valor + ") = " + resultado);

        } else {

            System.out.println("Faltan datos");

        }
    }

    private void imprimirMatriz_Newton(double[][] matrix, int n, Double x[]) {

        for (int i = 0; i < n; i++) {
            fs_newton.add("f" + (i) + "[]");
        }
        for (int i = 0; i < n; i++) {

            xi_newton.add(x[i]);

            for (int j = 0; j < n; j++) {
                fsD_newton.add(matrix[i][j]);
            }
        }
    }

    /*Lagrange*/

    ArrayList<String> resultado_L = new ArrayList<String>();
    ArrayList<String> pol_lagra = new ArrayList<String>();
    String fx_la;

    public ArrayList<String> getResultado_L() {
        return resultado_L;
    }

    public void setResultado_L(ArrayList<String> resultado_L) {
        this.resultado_L = resultado_L;
    }

    public ArrayList<String> getPol_lagra() {
        return pol_lagra;
    }

    public void setPol_lagra(ArrayList<String> pol_lagra) {
        this.pol_lagra = pol_lagra;
    }

    public String getFx_la() {
        return fx_la;
    }

    public void setFx_la(String fx_la) {
        this.fx_la = fx_la;
    }

    public void interpolacionLagrange(double valor, Double[] x, Double[] y) {

        if (x.length == y.length) {

            int nroPuntos = x.length;

            double resultado = 0;
            String pol = "P(x): \n";
            for (int k = 0; k < nroPuntos; k++) {
                double productoria = 1;
                String termino = "";
                for (int i = 0; i < nroPuntos; i++) {
                    if (i != k) {
                        productoria = productoria * (valor - x[i]) / (x[k] - x[i]);
                        termino = termino + ("[(x-" + x[i] + ")/(" + x[k] + "-" + x[i] + ")]");
                    }
                }
                resultado_L.add("L" + k + "(x):" + termino);
                pol += (y[k] > 0 ? "+" : "") + y[k] + "*" + termino + "\n";
                resultado += productoria * y[k];
            }
            pol_lagra.add(pol);
            fx_la = ("f(" + valor + ") = " + resultado);
        } else {

            System.out.println("Faltan datos");

        }
    }

    /*Neville */

    private ArrayList<Double> xi_neville = new ArrayList<Double>();
    private ArrayList<String> fs_neville = new ArrayList<String>();
    private ArrayList<Double> fsD_neville = new ArrayList<Double>();
    private String result_neville;

    public ArrayList<Double> getXi_neville() {
        return xi_neville;
    }

    public void setXi_neville(ArrayList<Double> xi_neville) {
        this.xi_neville = xi_neville;
    }

    public ArrayList<String> getFs_neville() {
        return fs_neville;
    }

    public void setFs_neville(ArrayList<String> fs_neville) {
        this.fs_neville = fs_neville;
    }

    public ArrayList<Double> getFsD_neville() {
        return fsD_neville;
    }

    public void setFsD_neville(ArrayList<Double> fsD_neville) {
        this.fsD_neville = fsD_neville;
    }

    public String getResult_neville() {
        return result_neville;
    }

    public void setResult_neville(String result_neville) {
        this.result_neville = result_neville;
    }

    public void interpolacionNeville(double valor, Double[] x, Double[] y) {

        if (x.length == y.length) {

            int nroPuntos = x.length;

            double[][] tabla = new double[nroPuntos][nroPuntos];
            for (int i = 0; i < nroPuntos; i++) {
                tabla[i][0] = y[i];
            }
            for (int i = 0; i < nroPuntos; i++) {
                for (int j = 1; j < i + 1; j++) {
                    tabla[i][j] = ((valor - x[i - j]) * tabla[i][j - 1] - ((valor - x[i]) * tabla[i - 1][j - 1])) / (x[i] - x[i - j]);
                }
            }
            imprimirMatrizNeville(tabla, nroPuntos, x);
            result_neville = ("f(" + valor + ") = " + tabla[nroPuntos - 1][nroPuntos - 1]);
        }
    }

    private void imprimirMatrizNeville(double[][] matrix, int n, Double x[]) {

        for (int i = 0; i < n; i++) {
            fs_neville.add("f" + i + "[]");
        }
        for (int i = 0; i < n; i++) {
            xi_neville.add(x[i]);
            for (int j = 0; j < n; j++) {
                fsD_neville.add(matrix[i][j]);
            }
        }
    }

    /*Spline Lineal */

    private String resultado_spline1;
    private ArrayList<String> pendientes_spline1 = new ArrayList<String>();
    private ArrayList<String> formulas_spline1 = new ArrayList<String>();

    public String getResultado_spline1() {
        return resultado_spline1;
    }

    public void setResultado_spline1(String resultado_spline1) {
        this.resultado_spline1 = resultado_spline1;
    }

    public ArrayList<String> getPendientes_spline1() {
        return pendientes_spline1;
    }

    public void setPendientes_spline1(ArrayList<String> pendientes_spline1) {
        this.pendientes_spline1 = pendientes_spline1;
    }

    public ArrayList<String> getFormulas_spline1() {
        return formulas_spline1;
    }

    public void setFormulas_spline1(ArrayList<String> formulas_spline1) {
        this.formulas_spline1 = formulas_spline1;
    }

    public void interpolacionTrazadoresLineales(double valor, Double x[], Double y[]) {

        if (x.length == y.length) {

            int nroPuntos = x.length;

            String[] formulas = new String[nroPuntos - 1];

            double resultado = 0;

            for (int i = 0; i < nroPuntos - 1; i++) {
                String temp = "S" + i + "(x) = " + y[i] + " + ";
                double bi = (y[i + 1] - y[i]) / (x[i + 1] - x[i]);
                pendientes_spline1.add("M" + i + " =(" + y[i + 1] + "-" + y[i] + ")/(" + x[i + 1] + "-" + x[i] + ") = " + bi + "\n");
                temp += bi + "(x-" + x[i] + ") cuando " + x[i] + "<=x<=" + x[i + 1];
                formulas[i] = temp;
                if (valor >= x[i] && valor <= x[i + 1]) {
                    resultado = y[i] + bi * (valor - x[i]);
                }
            }

            for (int i = 0; i < formulas.length; i++) {
                formulas_spline1.add(formulas[i] + "\n");
            }

            resultado_spline1 = ("f(" + valor + ") = " + resultado);

        } else {

            System.out.println("Faltan datos");

        }
    }

    /*Spline Cuadratico*/

    /*Spline Cubico*/

    private ArrayList<String> ecuaciones_spline3 = new ArrayList<String>();
    private String resultado_spline3;

    public ArrayList<String> getEcuaciones_spline3() {
        return ecuaciones_spline3;
    }

    public void setEcuaciones_spline3(ArrayList<String> ecuaciones_spline3) {
        this.ecuaciones_spline3 = ecuaciones_spline3;
    }

    public String getResultado_spline3() {
        return resultado_spline3;
    }

    public void setResultado_spline3(String resultado_spline3) {
        this.resultado_spline3 = resultado_spline3;
    }

    public void interpolacionTrazadoresCubicoNatural(double valor, Double x[], Double y[]) {

        if (x.length == y.length) {

            int nroPuntos = x.length;

            int n = nroPuntos - 1;
            double[][] tabla = new double[n * 4][n * 4 + 1];
            double[] b = new double[n * 4];

            int eqNumber = 1;

            int k = 0;
            int var = 0;
            int exp;
            int cont = 1;
            ecuaciones_spline3.add("Ecuaciones S(x):\n\n");

            for (int i = 0; i < n * 2; i++) {
                exp = 3;
                String eq = eqNumber + ") ";
                for (int j = 0; j < 4; j++) {
                    tabla[i][k + j] = Math.pow(x[var], exp);
                    if (cont == 1) {
                        eq += "a" + ((k / 4) + 1) + " * (" + x[var] + ")^" + exp;
                        eq += " + ";
                    } else if (cont == 2) {
                        eq += "b" + ((k / 4) + 1) + " * (" + x[var] + ")^" + exp;
                        eq += " + ";
                    } else if (cont == 3) {
                        eq += "c" + ((k / 4) + 1) + " * (" + x[var] + ")";
                        eq += " + ";
                    } else if (cont == 4) {
                        eq += "d" + ((k / 4) + 1);
                        cont = 0;
                    }
                    cont++;
                    exp--;
                }
                b[i] = y[var];
                eq += " = " + b[i];
                ecuaciones_spline3.add(eq + "\n");
                eqNumber++;
                if (i % 2 == 1) {
                    k += 4;
                } else {
                    var++;
                }
            }

            ecuaciones_spline3.add("\nEcuaciones S\"(x)\n\n");

            k = 0;
            int kaux = k + 4;
            int m = n * 2;
            var = 1;
            int cont2 = 1;
            for (int i = 0; i < n - 1; i++) {
                exp = 2;
                String eq = eqNumber + ") ";
                for (int j = 0; j < 3; j++) {
                    tabla[m + i][k + j] = (3 - j) * Math.pow(x[var], exp);
                    tabla[m + i][kaux + j] = -(3 - j) * Math.pow(x[var], exp);
                    if (cont2 == 1) {
                        eq += (3 - j) + " * a" + ((k / 4) + 1) + " * (" + x[var] + ")^" + exp;
                        eq += " + ";
                        eq += -(3 - j) + " * a" + ((kaux / 4) + 1) + " * (" + x[var] + ")^" + exp;
                        eq += " + ";
                    } else if (cont2 == 2) {
                        eq += (3 - j) + " * b" + ((k / 4) + 1) + " * (" + x[var] + ")";
                        eq += " + ";
                        eq += -(3 - j) + " * b" + ((kaux / 4) + 1) + " * (" + x[var] + ")";
                        eq += " + ";
                    } else if (cont2 == 3) {
                        eq += "c" + ((k / 4) + 1);
                        eq += " + ";
                        eq += "-c" + ((kaux / 4) + 1);
                        cont2 = 0;
                    }
                    cont2++;
                    exp--;
                }
                k += 4;
                kaux += 4;
                b[m + i] = 0.0;
                eq += " = " + b[m + i];
                ecuaciones_spline3.add(eq + "\n");
                eqNumber++;
                var++;
            }

            ecuaciones_spline3.add("\n\nEcuaciones S'''(x)\n\n");
            int cont3 = 1;
            k = 0;
            kaux = k + 4;
            m = m + (n - 1);
            var = 1;
            for (int i = 0; i < n - 1; i++) {
                exp = 1;
                String eq = eqNumber + ") ";
                for (int j = 0; j < 2; j++) {
                    tabla[m + i][k + j] = (6 - 4 * j) * Math.pow(x[var], exp);
                    tabla[m + i][kaux + j] = -(6 - 4 * j) * Math.pow(x[var], exp);
                    if (cont3 == 1) {
                        eq += (6 - 4 * j) + " * a" + ((k / 4) + 1) + " * (" + x[var] + ")^" + exp;
                        eq += " + ";
                        eq += -(6 - 4 * j) + " * a" + ((kaux / 4) + 1) + " * (" + x[var] + ")^" + exp;
                        eq += " + ";
                    } else if (cont3 == 2) {
                        eq += (6 - 4 * j) + " * b" + ((k / 4) + 1);
                        eq += " + ";
                        eq += -(6 - 4 * j) + " * b" + ((kaux / 4) + 1);
                        cont3 = 0;
                    }
                    cont3++;
                    exp--;
                }
                k += 4;
                kaux += 4;
                b[m + i] = 0.0;
                eq += " = " + b[m + i];
                ecuaciones_spline3.add(eq + "\n");
                eqNumber++;
                var++;
            }

            int cont4 = 1;
            k = 0;
            m = m + (n - 1);
            var = 0;
            for (int i = 0; i < 2; i++) {
                exp = 1;
                String eq = eqNumber + ") ";
                for (int j = 0; j < 2; j++) {
                    tabla[m][k + j] = (6 - 4 * j) * Math.pow(x[var], exp);
                    if (cont4 == 1) {
                        eq += (6 - 4 * j) + " * a" + ((k / 4) + 1) + " * (" + x[var] + ")^" + exp;
                        eq += " + ";
                    } else if (cont4 == 2) {
                        eq += (6 - 4 * j) + " * b" + ((k / 4) + 1);
                        cont4 = 0;
                    }
                    cont4++;
                    exp--;
                }
                b[m] = 0.0;
                eq += " = " + b[m];
                ecuaciones_spline3.add(eq + "\n");
                k = (n * 4) - 4;
                eqNumber++;
                m++;
                var = x.length - 1;
            }

            for (int i = 0; i < b.length; i++) {
                tabla[i][4 * n] = b[i];
            }

            Double[] sol = eliminacionGaussPivoteoTotal(4 * n, tabla);

            int ind = 0;
            if (valor >= x[0]) {
                if (valor <= x[x.length - 1]) {
                    for (int i = 0; i < x.length - 1; i++) {
                        if (valor >= x[i] && valor < x[i + 1]) {
                            ind = i;
                        }
                    }
                } else {
                    ind = x.length - 2;
                }
            }

            double resp = 0;
            for (int i = 0; i < 4; i++) {
                resp += sol[(ind * 4) + i] * Math.pow(valor, 3 - i);
            }

            resultado_spline3 = ("f(" + valor + ") = " + resp);
        } else {

            System.out.println("Faltan datos");

        }
    }

    private Double[] eliminacionGaussPivoteoTotal(int n, double[][] matrix) {
        String[] marcas = crearMarcas(n);
        String[] mCopy = crearMarcas(n);

        //imprimirMatriz(matrix, n, marcas);
        for (int k = 1; k < n; k++) {
            pivoteoTotal(matrix, marcas, k, n);
            for (int i = k + 1; i < n + 1; i++) {
                double multiplicador = matrix[i - 1][k - 1] / matrix[k - 1][k - 1];
                for (int j = k; j < n + 2; j++) {
                    matrix[i - 1][j - 1] = matrix[i - 1][j - 1] - multiplicador * matrix[k - 1][j - 1];
                }
            }
        }
        System.out.println("Pivoteo total.\n");
        /*imprimirMatriz(matrix, n, marcas);*/
        Double x[] = new Double[n];
        for (int i = n; i > 0; i--) {
            double sumatoria = 0;
            for (int p = i + 1; p <= n; p++) {
                sumatoria = sumatoria + matrix[i - 1][p - 1] * x[p - 1];
            }
            x[i - 1] = (matrix[i - 1][n] - sumatoria) / matrix[i - 1][i - 1];
        }

        System.out.println("Arreglo de coeficientes:");
        System.out.println("");
        for (int i = 0; i < x.length; i++) {
            System.out.println(marcas[i] + " : " + x[i]);
        }

        return devolverCoeficientesOrdenados(marcas, mCopy, x);
    }

    private Double[] devolverCoeficientesOrdenados(String[] marcas, String[] original, Double[] x) {
        for (int i = 0; i < original.length; i++) {
            for (int j = 0; j < original.length; j++) {
                if (original[i].equals(marcas[j])) {
                    double temp = x[i];
                    x[i] = x[j];
                    x[j] = temp;
                    String temp2 = marcas[i];
                    marcas[i] = marcas[j];
                    marcas[j] = temp2;
                }
            }
        }
        for (int i = 0; i < x.length; i++) {
            System.out.println(marcas[i] + " : " + x[i]);
        }

        return x;
    }

    private String[] crearMarcas(int n) {
        int cont = 0;
        int cont2 = 1;
        String[] marcas = new String[n];
        for (int i = 0; i < n; i++) {
            if (cont == 0) {
                marcas[i] = "a" + cont2;
            } else if (cont == 1) {
                marcas[i] = "b" + cont2;
            } else if (cont == 2) {
                marcas[i] = "c" + cont2;
            } else if (cont == 3) {
                marcas[i] = "d" + cont2;
                cont = -1;
                cont2++;
            }
            cont++;
        }
        return marcas;
    }

    private double[][] pivoteoTotal(double[][] matrix, String[] marcas, int k, int n) {
        double mayor = 0;
        int filaMayor = k - 1;
        int columnaMayor = k - 1;
        for (int r = k - 1; r < n; r++) {
            for (int s = k - 1; s < n; s++) {

                double algo = Math.abs(matrix[r][s]);
                System.out.println(algo);
                if (algo > mayor) {
                    mayor = Math.abs(matrix[r][s]);
                    filaMayor = r;
                    columnaMayor = s;
                }
            }
        }
        if (mayor == 0) {
            System.exit(0);
        } else {
            if (filaMayor != k - 1) {
                for (int i = 0; i < matrix[0].length; i++) {
                    double aux = matrix[k - 1][i];
                    matrix[k - 1][i] = matrix[filaMayor][i];
                    matrix[filaMayor][i] = aux;
                }
            }
            if (columnaMayor != k - 1) {
                for (int i = 0; i < n; i++) {
                    double aux = matrix[i][k - 1];
                    matrix[i][k - 1] = matrix[i][columnaMayor];
                    matrix[i][columnaMayor] = aux;
                }
                String aux2 = marcas[columnaMayor];
                marcas[columnaMayor] = marcas[k - 1];
                marcas[k - 1] = aux2;
            }
        }
        return matrix;
    }


}
