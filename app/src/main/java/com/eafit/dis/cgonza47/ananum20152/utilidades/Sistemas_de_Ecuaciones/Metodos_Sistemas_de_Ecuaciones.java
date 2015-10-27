package com.eafit.dis.cgonza47.ananum20152.utilidades.Sistemas_de_Ecuaciones;

import java.util.ArrayList;
import java.util.Arrays;

public class Metodos_Sistemas_de_Ecuaciones {

    private ArrayList<String> resultados = new ArrayList<String>();
    private ArrayList<String> solo_resultado = new ArrayList<String>();

    /*Metodos de Eliminacion Gaussiana*/

    public void eliminacionGaussianaSimple(int n, double[][] matriz) {

        resultados.add("Matriz Original\n\n");

        setMatriz(matriz, n);

        for (int k = 1; k < n; k++) {
            resultados.add("\nEtapa " + k + "\n");
            resultados.add("Objetivo: Poner ceros debajo del elemento A" + k + "," + k + "= " + matriz[k - 1][k - 1] + "\n");
            resultados.add("\nMultiplicadores: \n");
            for (int i = k + 1; i < n + 1; i++) {

                double multiplicador = matriz[i - 1][k - 1] / matriz[k - 1][k - 1];

                for (int j = k; j < n + 2; j++) {
                    matriz[i - 1][j - 1] = matriz[i - 1][j - 1] - multiplicador * matriz[k - 1][j - 1];
                }

                resultados.add("Multiplicador " + i + "," + k + " : " + multiplicador + "\n");
            }
            resultados.add(" " + "\n");

            resultados.add("\n\nMatriz A+b\n\n");
            setMatriz(matriz, n);
        }
        double x[] = new double[n];
        resultados.add("\nSustitucion Regresiva\n");
        for (int i = n; i > 0; i--) {
            double sumatoria = 0;
            for (int p = i + 1; p <= n; p++) {
                sumatoria = sumatoria + matriz[i - 1][p - 1] * x[p - 1];
            }
            x[i - 1] = (matriz[i - 1][n] - sumatoria) / matriz[i - 1][i - 1];
            resultados.add("X" + i + " = " + x[i - 1] + "\n");
            solo_resultado.add("X" + i + " = " + x[i - 1] + "\n");
        }
    }

    public void eliminacionGaussPivoteoParcial(int n, double[][] matriz) {
        resultados.add("Matriz Original\n");
        setMatriz(matriz, n);
        boolean flag = true;
        for (int k = 1; k < n; k++) {
            resultados.add("Etapa " + k + "\n");

            pivoteoParcial(matriz, k, n);

            if (pivoteoParcial(matriz, k, n) == null) {

                flag = false;

            } else {
                resultados.add("\nObjetivo: Poner ceros debajo del elemento A" + k + "," + k + "= " + matriz[k - 1][k - 1] + "\n");
                resultados.add("\nMultiplicadores:\n");
                for (int i = k + 1; i < n + 1; i++) {
                    double multiplicador = matriz[i - 1][k - 1] / matriz[k - 1][k - 1];
                    for (int j = k; j < n + 2; j++) {
                        matriz[i - 1][j - 1] = matriz[i - 1][j - 1] - multiplicador * matriz[k - 1][j - 1];
                    }
                    resultados.add("Multiplicador " + i + "," + k + " : " + multiplicador + "\n");
                }
                resultados.add(" " + "\n");
                resultados.add("Matriz A+b\n\n");
                setMatriz(matriz, n);
            }
        }

        if (flag) {
            double x[] = new double[n];
            resultados.add("\nSustitucion Regresiva\n");
            for (int i = n; i > 0; i--) {
                double sumatoria = 0;
                for (int p = i + 1; p <= n; p++) {
                    sumatoria = sumatoria + matriz[i - 1][p - 1] * x[p - 1];
                }
                x[i - 1] = (matriz[i - 1][n] - sumatoria) / matriz[i - 1][i - 1];
                resultados.add("X" + i + " = " + x[i - 1] + "\n");
                solo_resultado.add("X" + i + " = " + x[i - 1] + "\n");
            }
        } else {

            resultados.add("\n\n 0 EN LA DIAGONAL - EL ALGORITMO PARA");
        }
    }

    public double[][] pivoteoParcial(double[][] matriz, int k, int n) {
        double elementoMayor = Math.abs(matriz[k - 1][k - 1]);
        int filaMayor = k - 1;
        for (int s = k - 1; s < n; s++) {
            double nuevoElemento = Math.abs(matriz[s][k - 1]);
            if (nuevoElemento > elementoMayor) {
                elementoMayor = Math.abs(matriz[s][k - 1]);
                filaMayor = s;
            }
        }
        resultados.add("Elemento Mayor: " + elementoMayor + " en la fila " + (filaMayor + 1) + "\n");
        if (elementoMayor == 0) {

            resultados.add("El sistema de ecuaciones no tiene solucion unica\n");
            return null;

        } else {
            if (filaMayor != k - 1) {
                //resultados.add("Se procede a hacer el cambio de la fila " + k + " con la fila " + (filaMayor + 1) + "\n");
                for (int i = 0; i < matriz[0].length; i++) {
                    double aux = matriz[k - 1][i];
                    matriz[k - 1][i] = matriz[filaMayor][i];
                    matriz[filaMayor][i] = aux;
                }
                //resultados.add("\n\nMatriz A+b despues del pivoteo parcial\n\n");
                //setMatriz(matriz, n);
            }
        }
        return matriz;
    }

    public void eliminacionGaussPivoteoTotal(int n, double[][] matriz) {
        boolean flag = true;
        resultados.add("Matriz Original\n");
        int[] punt = crearPunt(n);
        setMatriz(matriz, n, punt);
        for (int k = 1; k < n; k++) {
            resultados.add("Etapa " + k + "\n");

            pivoteoTotal(matriz, punt, k, n);

            if (pivoteoTotal(matriz, punt, k, n) == null) {

                flag = false;

            } else {

                resultados.add("Objetivo: Poner ceros debajo del elemento A" + k + "," + k + "= " + matriz[k - 1][k - 1] + "\n");
                resultados.add("\nMultiplicadores:\n");
                for (int i = k + 1; i < n + 1; i++) {
                    double multiplicador = matriz[i - 1][k - 1] / matriz[k - 1][k - 1];
                    for (int j = k; j < n + 2; j++) {
                        matriz[i - 1][j - 1] = matriz[i - 1][j - 1] - multiplicador * matriz[k - 1][j - 1];
                    }
                    resultados.add("Multiplicador " + i + "," + k + " : " + multiplicador + "\n");
                }
                resultados.add(" " + "\n");
                resultados.add("Matriz A+b\n\n");
                setMatriz(matriz, n, punt);
            }
        }

        if (flag) {

            double x[] = new double[n];
            resultados.add("\nSustitucion Regresiva\n");
            for (int i = n; i > 0; i--) {
                double sumatoria = 0;
                for (int p = i + 1; p <= n; p++) {
                    sumatoria = sumatoria + matriz[i - 1][p - 1] * x[p - 1];
                }
                x[i - 1] = (matriz[i - 1][n] - sumatoria) / matriz[i - 1][i - 1];
                resultados.add("X" + punt[i - 1] + " = " + x[i - 1] + "\n");
                solo_resultado.add("X" + i + " = " + x[i - 1] + "\n");
            }
        } else {

            resultados.add("\n\n 0 EN LA DIAGONAL - EL ALGORITMO PARA");

        }
    }

    public int[] crearPunt(int n) {
        int[] punt = new int[n];
        for (int i = 0; i < n; i++) {
            punt[i] = i + 1;
        }
        return punt;
    }

    public double[][] pivoteoTotal(double[][] matriz, int[] punt, int k, int n) {
        double mayor = 0;
        int filaMayor = k - 1;
        int columnaMayor = k - 1;
        for (int r = k - 1; r < n; r++) {
            for (int s = k - 1; s < n; s++) {
                if (Math.abs(matriz[r][s]) > mayor) {
                    mayor = Math.abs(matriz[r][s]);
                    filaMayor = r;
                    columnaMayor = s;
                }
            }
        }
        resultados.add("Elemento Mayor: " + mayor + " en la fila " + (filaMayor + 1) + " y la columna " + (columnaMayor + 1) + "\n");
        if (mayor == 0) {
            resultados.add("El sistema de ecuaciones no tiene solucion unica\n");
            return null;
        } else {
            if (filaMayor != k - 1) {
                //resultados.add("Se procede a hacer el cambio de fila " + k + " con la fila " + (filaMayor + 1) + "\n\n");
                for (int i = 0; i < matriz[0].length; i++) {
                    double aux = matriz[k - 1][i];
                    matriz[k - 1][i] = matriz[filaMayor][i];
                    matriz[filaMayor][i] = aux;
                }
                //resultados.add("\n\nMatriz A+b despues del pivoteo\n\n");
                //setMatriz(matriz, n, punt);
            }
            if (columnaMayor != k - 1) {
                //resultados.add("Se procede a hacer el cambio de columna " + k + " con la columna " + (columnaMayor + 1) + "\n");
                for (int i = 0; i < n; i++) {
                    double aux = matriz[i][k - 1];
                    matriz[i][k - 1] = matriz[i][columnaMayor];
                    matriz[i][columnaMayor] = aux;
                }
                int aux2 = punt[columnaMayor];
                punt[columnaMayor] = punt[k - 1];
                punt[k - 1] = aux2;
                //resultados.add("\n\nMatriz A+b despues del pivoteo\n\n");
                //setMatriz(matriz, n, punt);
            }
        }
        return matriz;
    }

    public void setMatriz(double[][] matriz, int n, int[] punt) {

        for (int i = 0; i < n; i++) {
            resultados.add("X" + punt[i]);
            setAlignment(String.valueOf(punt[i]).length(), 23);
        }
        resultados.add("\n");
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n + 1; j++) {
                resultados.add(String.valueOf(matriz[i][j]));
                setAlignment(String.valueOf(matriz[i][j]).length(), 23);
            }
            resultados.add("\n");
        }
        resultados.add("" + "\n");
    }

    /*--------------------------------------------------------------------------------------------*/

    /*Metodos Factorizacion LU*/

    public void factorizacionDirectaDoolittle(double A[][], double[] b, int n) {
        double[][] L = new double[n][n];
        double[][] U = new double[n][n];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (i < j) {
                    U[i][j] = Double.POSITIVE_INFINITY;
                    L[i][j] = 0;
                } else if (i > j) {
                    L[i][j] = Double.POSITIVE_INFINITY;
                    U[i][j] = 0;
                } else if (i == j) {
                    L[i][j] = 1;
                    U[i][j] = Double.POSITIVE_INFINITY;
                }
            }
        }
        resultados.add("\nEtapa 0\n");
        resultados.add("\nMatriz A\n");
        setMatriz(A, n, true);
        resultados.add("\nMatriz L\n");
        setMatriz(L, n, true);
        resultados.add("\nMatriz U\n");
        setMatriz(U, n, true);

        for (int k = 1; k < n + 1; k++) {
            resultados.add("Etapa " + k + "\n");
            resultados.add("Encontrar la columna " + k + " de la L y la fila " + k + " de la U\n");
            resultados.add("\nMatriz A\n");
            setMatriz(A, n, true);
            double suma = 0;
            for (int p = 0; p < k - 1; p++) {
                suma += L[k - 1][p] * U[p][k - 1];
            }
            U[k - 1][k - 1] = (A[k - 1][k - 1] - suma) / L[k - 1][k - 1];

            for (int j = k + 1; j < n + 1; j++) {
                suma = 0;
                for (int p = 0; p < k - 1; p++) {

                    suma += L[k - 1][p] * U[p][j - 1];
                }
                U[k - 1][j - 1] = (A[k - 1][j - 1] - suma) / L[k - 1][k - 1];
            }
            resultados.add("\nMatriz L\n");
            setMatriz(L, n, true);
            for (int i = k + 1; i < n + 1; i++) {
                suma = 0;
                for (int p = 0; p < k - 1; p++) {
                    suma += L[i - 1][p] * U[p][k - 1];
                }
                L[i - 1][k - 1] = (A[i - 1][k - 1] - suma) / U[k - 1][k - 1];
            }
            resultados.add("\nMatriz U\n");
            setMatriz(U, n, true);
        }

        resultados.add("\nSustitucion Progresiva Lz=b\n");
        solo_resultado.add("Sustitucion Progresiva Lz=b\n\n");

        double[] z = sustitucionProgresiva(L, b);
        for (int i = 0; i < z.length; i++) {
            resultados.add("Z" + (i + 1) + " = " + z[i] + "\n");
            solo_resultado.add("Z" + (i + 1) + " = " + z[i] + "\n");
        }
        resultados.add("\nSustitucion Regresiva Ux=z\n");
        solo_resultado.add("\nSustitucion Regresiva Ux=z\n\n");
        double[] x = sustitucionRegresiva(U, z);
        for (int i = 0; i < x.length; i++) {
            resultados.add("X" + (i + 1) + " = " + x[i] + "\n");
            solo_resultado.add("X" + (i + 1) + " = " + x[i] + "\n");
        }
    }

    public void factorizacionDirectaCrout(double A[][], double[] b, int n) {
        double[][] L = new double[n][n];
        double[][] U = new double[n][n];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (i < j) {
                    U[i][j] = Double.POSITIVE_INFINITY;
                    L[i][j] = 0;
                } else if (i > j) {
                    L[i][j] = Double.POSITIVE_INFINITY;
                    U[i][j] = 0;
                } else if (i == j) {
                    U[i][j] = 1;
                    L[i][j] = Double.POSITIVE_INFINITY;
                }
            }
        }

        resultados.add("Etapa 0\n");
        resultados.add("\nMatriz A\n");
        setMatriz(A, n, true);
        resultados.add("\nMatriz L\n");
        setMatriz(L, n, true);
        resultados.add("\nMatriz U\n");
        setMatriz(U, n, true);

        for (int k = 1; k < n + 1; k++) {
            resultados.add("Etapa " + k + "\n");
            resultados.add("Encontrar la columna " + k + " de la L y la fila " + k + " de la U\n");
            resultados.add("\nMatriz A\n");
            setMatriz(A, n, true);
            double suma = 0;
            for (int p = 0; p < k - 1; p++) {
                suma += L[k - 1][p] * U[p][k - 1];
            }
            L[k - 1][k - 1] = (A[k - 1][k - 1] - suma) / U[k - 1][k - 1];
            for (int i = k + 1; i < n + 1; i++) {
                suma = 0;
                for (int p = 0; p < k - 1; p++) {
                    suma += L[i - 1][p] * U[p][k - 1];
                }
                L[i - 1][k - 1] = (A[i - 1][k - 1] - suma) / U[k - 1][k - 1];
            }

            resultados.add("\nMatriz L\n");
            setMatriz(L, n, true);

            for (int j = k + 1; j < n + 1; j++) {
                suma = 0;
                for (int p = 0; p < k - 1; p++) {
                    suma += L[k - 1][p] * U[p][j - 1];
                }
                U[k - 1][j - 1] = (A[k - 1][j - 1] - suma) / L[k - 1][k - 1];
            }
            resultados.add("\nMatriz U\n");
            setMatriz(U, n, true);
        }
        resultados.add("\nSustitucion Progresiva Lz=b\n");
        solo_resultado.add("Sustitucion Progresiva Lz=b\n\n");
        double[] z = sustitucionProgresiva(L, b);
        for (int i = 0; i < z.length; i++) {
            resultados.add("Z" + (i + 1) + " = " + z[i] + "\n");
            solo_resultado.add("Z" + (i + 1) + " = " + z[i] + "\n");
        }
        resultados.add("\nSustitucion Regresiva Ux=z\n");
        solo_resultado.add("\nSustitucion Regresiva Ux=z\n\n");
        double[] x = sustitucionRegresiva(U, z);
        for (int i = 0; i < x.length; i++) {
            resultados.add("X" + (i + 1) + " = " + x[i] + "\n");
            solo_resultado.add("X" + (i + 1) + " = " + x[i] + "\n");
        }
    }

    public void factorizacionDirectaCholesky(double A[][], double[] b, int n) {
        double[][] L = new double[n][n];
        double[][] U = new double[n][n];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (i < j) {
                    U[i][j] = Double.POSITIVE_INFINITY;
                    L[i][j] = 0;
                } else if (i > j) {
                    L[i][j] = Double.POSITIVE_INFINITY;
                    U[i][j] = 0;
                } else if (i == j) {
                    L[i][j] = Double.POSITIVE_INFINITY;
                    U[i][j] = Double.POSITIVE_INFINITY;
                }
            }
        }

        resultados.add("Etapa 0\n");
        resultados.add("\nMatriz A\n");
        setMatriz(A, n, true);
        resultados.add("\nMatriz L\n");
        setMatriz(L, n, true);
        resultados.add("\nMatriz U\n");
        setMatriz(U, n, true);

        for (int k = 1; k < n + 1; k++) {
            resultados.add("Etapa " + k + "\n");
            resultados.add("Encontrar la columna " + k + " de la L y la fila " + k + " de la U\n");
            resultados.add("\nMatriz A\n");
            setMatriz(A, n, true);
            double suma = 0;
            for (int p = 0; p < k - 1; p++) {
                suma += L[k - 1][p] * U[p][k - 1];
            }
            U[k - 1][k - 1] = Math.sqrt(A[k - 1][k - 1] - suma);
            L[k - 1][k - 1] = U[k - 1][k - 1];

            for (int j = k + 1; j < n + 1; j++) {
                suma = 0;
                for (int p = 0; p < k - 1; p++) {

                    suma += L[j - 1][p] * U[p][k - 1];
                }
                L[j - 1][k - 1] = (A[j - 1][k - 1] - suma) / L[k - 1][k - 1];
            }
            resultados.add("\nMatriz L\n");
            setMatriz(L, n, true);
            for (int i = k + 1; i < n + 1; i++) {
                suma = 0;
                for (int p = 0; p < k - 1; p++) {
                    suma += L[k - 1][p] * U[p][i - 1];
                }
                U[k - 1][i - 1] = (A[k - 1][i - 1] - suma) / L[k - 1][k - 1];
            }
            resultados.add("\nMatriz U\n");
            setMatriz(U, n, true);
        }

        resultados.add("\nSustitucion Progresiva Lz=b\n");
        solo_resultado.add("Sustitucion Progresiva Lz=b\n\n");

        double[] z = sustitucionProgresiva(L, b);
        for (int i = 0; i < z.length; i++) {
            resultados.add("Z" + (i + 1) + " = " + z[i] + "\n");
            solo_resultado.add("Z" + (i + 1) + " = " + z[i] + "\n");
        }

        resultados.add("\nSustitucion Regresiva Ux=z\n");
        solo_resultado.add("\nSustitucion Regresiva Ux=z\n\n");

        double[] x = sustitucionRegresiva(U, z);
        for (int i = 0; i < x.length; i++) {
            resultados.add("X" + (i + 1) + " = " + x[i] + "\n");
            solo_resultado.add("X" + (i + 1) + " = " + x[i] + "\n");
        }
    }

    public double[] sustitucionProgresiva(double[][] L, double[] b) {
        int n = L.length;
        double x[] = new double[n];
        for (int i = 1; i < n + 1; i++) {
            double suma = 0;
            for (int p = i - 1; p > 0; p--) {
                double a = L[i - 2][p];
                double c = x[p - 1];
                suma += (L[i - 1][p - 1] * x[p - 1]);
            }
            x[i - 1] = (b[i - 1] - suma) / L[i - 1][i - 1];
        }
        return x;
    }

    public double[] sustitucionRegresiva(double[][] U, double[] z) {
        int n = U.length;
        double[] x = new double[n];

        for (int i = n - 1; i >= 0; i--) {
            double suma = 0;
            for (int j = i + 1; j < n; j++) {
                suma += U[i][j] * x[j];
            }
            x[i] = (z[i] - suma) / U[i][i];
        }
        return x;
    }

    /*--------------------------------------------------------------------------------------------*/

    /*Iterativos*/

    /* Arrays Jacobi */

    ArrayList<Integer> iteraciones_jacobi = new ArrayList<Integer>();
    ArrayList<Double> error_jacobi = new ArrayList<Double>();
    ArrayList<Double> xs_jacobi = new ArrayList<Double>();
    ArrayList<String> resultados_jacobi = new ArrayList<String>();
    int tam_x0_jacobi;

    public ArrayList<Integer> getIteraciones_jacobi() {
        return iteraciones_jacobi;
    }

    public void setIteraciones_jacobi(ArrayList<Integer> iteraciones_jacobi) {
        this.iteraciones_jacobi = iteraciones_jacobi;
    }

    public ArrayList<Double> getError_jacobi() {
        return error_jacobi;
    }

    public void setError_jacobi(ArrayList<Double> error_jacobi) {
        this.error_jacobi = error_jacobi;
    }

    public ArrayList<Double> getXs_jacobi() {
        return xs_jacobi;
    }

    public void setXs_jacobi(ArrayList<Double> xs_jacobi) {
        this.xs_jacobi = xs_jacobi;
    }

    public int getTam_x0_jacobi() {
        return tam_x0_jacobi;
    }

    public void setTam_x0_jacobi(int tam_x0_jacobi) {
        this.tam_x0_jacobi = tam_x0_jacobi;
    }

    public ArrayList<String> getResultados_jacobi() {
        return resultados_jacobi;
    }

    public void setResultados_jacobi(ArrayList<String> resultados_jacobi) {
        this.resultados_jacobi = resultados_jacobi;
    }

    /*--------------------------------------------------------------------------------------------*/

    public void jacobi(double[][] matrix, double[] b, int n,
                       double[] x0, int iteraciones, double tolerancia, double alpha) {
        int contador = 1;
        double error = tolerancia + 1;
        double[] x = new double[n];

        iteraciones_jacobi.add(0);
        error_jacobi.add(0.0);
        tam_x0_jacobi = x0.length;

        for (int i = 0; i < tam_x0_jacobi; i++) {
            xs_jacobi.add(x0[i]);
        }

        while (error > tolerancia && contador < iteraciones) {

            for (int i = 1; i < n + 1; i++) {
                double suma = 0;
                for (int j = 1; j < n + 1; j++) {
                    if (i != j) {
                        suma = suma + matrix[i - 1][j - 1] * x0[j - 1];
                    }
                }
                x[i - 1] = (b[i - 1] - suma) / matrix[i - 1][i - 1];
                x[i - 1] = alpha * (x[i - 1]) + (1 - alpha) * (x0[i - 1]);
            }
            error = norma(x, x0, n);
            for (int i = 0; i < n; i++) {
                x0[i] = x[i];
                xs_jacobi.add(x[i]);
            }
            iteraciones_jacobi.add(contador);
            error_jacobi.add(error);
            contador++;
        }

        if (error < tolerancia) {

            resultados_jacobi.add("\nVector X\n\n");

            for (int i = 0; i < x.length; i++) {

                resultados_jacobi.add("X" + i + "=" + x[i] + "\n");

            }

            resultados_jacobi.add("\n\n Con una tolerancia de " + error + ".");

        } else {

            resultados_jacobi.add("\n\nFracaso en " + iteraciones + " iteraciones.");

        }
    }

    /*--------------------------------------------------------------------------------------------*/

    /*Arrays Gauss Seidel*/

    ArrayList<Integer> iteraciones_gaussidel = new ArrayList<Integer>();
    ArrayList<Double> error_gausseidel = new ArrayList<Double>();
    ArrayList<Double> xs_gausseidel = new ArrayList<Double>();
    ArrayList<String> resultados_gausseidel = new ArrayList<String>();
    int tam_x0_gausseidel;

    /*--------------------------------------------------------------------------------------------*/

    public ArrayList<Integer> getIteraciones_gaussidel() {
        return iteraciones_gaussidel;
    }

    public void setIteraciones_gaussidel(ArrayList<Integer> iteraciones_gaussidel) {
        this.iteraciones_gaussidel = iteraciones_gaussidel;
    }

    public ArrayList<Double> getError_gausseidel() {
        return error_gausseidel;
    }

    public void setError_gausseidel(ArrayList<Double> error_gausseidel) {
        this.error_gausseidel = error_gausseidel;
    }

    public int getTam_x0_gausseidel() {
        return tam_x0_gausseidel;
    }

    public void setTam_x0_gausseidel(int tam_x0_gausseidel) {
        this.tam_x0_gausseidel = tam_x0_gausseidel;
    }

    public ArrayList<Double> getXs_gausseidel() {
        return xs_gausseidel;
    }

    public void setXs_gausseidel(ArrayList<Double> xs_gausseidel) {
        this.xs_gausseidel = xs_gausseidel;
    }

    public ArrayList<String> getResultados_gausseidel() {
        return resultados_gausseidel;
    }

    public void setResultados_gausseidel(ArrayList<String> resultados_gausseidel) {
        this.resultados_gausseidel = resultados_gausseidel;
    }

    /*--------------------------------------------------------------------------------------------*/

    public void gaussSeidel(double[][] matrix, double[] b, int n,
                            double[] x0, int iteraciones, double tolerancia, double alpha) {
        int contador = 1;
        double error = tolerancia + 1;
        double[] x = new double[n];
        iteraciones_gaussidel.add(0);
        error_gausseidel.add(0.0);
        tam_x0_gausseidel = x0.length;

        for (int i = 0; i < tam_x0_gausseidel; i++) {
            xs_gausseidel.add(x0[i]);
        }

        while (error > tolerancia && contador < iteraciones) {

            for (int i = 0; i < n; i++) {
                x[i] = x0[i];
            }

            for (int i = 1; i < n + 1; i++) {
                double suma = 0;
                for (int j = 1; j < n + 1; j++) {
                    if (i != j) {
                        suma = suma + matrix[i - 1][j - 1] * x[j - 1];
                    }
                }
                x[i - 1] = (b[i - 1] - suma) / matrix[i - 1][i - 1];
                x[i - 1] = alpha * (x[i - 1]) + (1 - alpha) * (x0[i - 1]);
            }
            error = norma(x, x0, n);

            for (int i = 0; i < n; i++) {
                x0[i] = x[i];
                xs_gausseidel.add(x[i]);
            }

            iteraciones_gaussidel.add(contador);
            error_gausseidel.add(error);
            contador++;
        }

        if (error < tolerancia) {

            resultados_gausseidel.add("\nVector X\n\n");

            for (int i = 0; i < x0.length; i++) {

                resultados_gausseidel.add("X" + i + "=" + x0[i] + "\n");

            }

            resultados_gausseidel.add("\n\n Con una tolerancia de " + error + ".");

        } else {

            resultados_gausseidel.add("Fracaso en " + iteraciones + " iteraciones.");

        }
    }

    /*--------------------------------------------------------------------------------------------*/

    /*Pivoteo Escalonado*/

    public double[] busquedaDelMayorDeCadaFila(int n, double[][] matrix){
        double[] s= new double[n];
        for(int i=0; i<n;i++){
            for(int j=0;j<n;j++){
                if(Math.abs(matrix[i][j])>s[i]){
                    s[i] = Math.abs(matrix[i][j]);
                }
            }
        }
        return s;
    }

    public void eliminacionGaussPivoteoEscalonado(int n, double[][] matrix){

        resultados.add("Matriz Original\n\n");
        setMatriz(matrix, n);
        double[] s = busquedaDelMayorDeCadaFila(n, matrix);
        resultados.add("Vector de mayores de cada fila\n\n");
        resultados.add(Arrays.toString(s)+"\n");
        resultados.add("\n");
        for(int k = 1; k < n; k++){
            resultados.add("Etapa " + k +"\n");

            pivoteoEscalonado(matrix, k, n, s);

            resultados.add("\n");

            resultados.add("Objetivo: Poner ceros debajo del elemento A" + k + "," + k + "= " + matrix[k - 1][k - 1] + "\n");

            resultados.add("\nMultiplicadores:\n");
            for(int i = k+1; i < n+1; i++){
                double multiplicador = matrix[i-1][k-1]/matrix[k-1][k-1];
                for(int j = k ; j < n+2; j++){
                    matrix[i-1][j-1] = matrix[i-1][j-1] - multiplicador*matrix[k-1][j-1];
                }
                resultados.add("Multiplicador"+ i+","+k +" : " + multiplicador+"\n");
            }
            resultados.add("\n ");
            setMatriz(matrix, n);
        }
        double x[] = new double[n];
        resultados.add("Sustituci�n Regresiva"+"\n");
        for(int i = n; i>0;i--){
            double sumatoria = 0;
            for(int p = i+1; p <= n; p++){
                sumatoria = sumatoria + matrix[i-1][p-1]*x[p-1];
            }
            x[i-1] = (matrix[i-1][n]-sumatoria)/matrix[i-1][i-1];
            resultados.add( "X"+i+" = "+x[i-1]+"\n");
            solo_resultado.add( "X"+i+" = "+x[i-1]+"\n");
        }
    }

    public void pivoteoEscalonado(double[][] matrix, int k, int n,double[] s) {

        double mayor = 0;
        int filamayor = k-1;

        double[] cocientes = new double[n];

        for(int i = k; i<n+1;i++){
            cocientes[i-1] = Math.abs(matrix[i-1][k-1])/s[i-1];
        }
        resultados.add("\n");
        resultados.add("Vector de cocientes\n");
        resultados.add(Arrays.toString(cocientes)+"\n");

        for(int i = k-1; i<n;i++){
            if(cocientes[i]>mayor){
                mayor = cocientes[i];
                filamayor = i;
            }
        }
        resultados.add("El cociente mayor es: "+mayor+" de la fila "+(filamayor+1)+"\n");
        if(mayor==0){
            resultados.add("El sistema no tiene soluci�n �nica.\n");
            System.exit(0);
        }else{
            if(filamayor!=k-1){
                resultados.add("\n");
                resultados.add("Cambio de fila "+ k + " con fila " + (filamayor+1)+ "\n");
                for(int i = 0; i < matrix[0].length; i++){
                    double aux = matrix[k-1][i];
                    matrix[k-1][i] = matrix[filamayor][i];
                    matrix[filamayor][i] = aux;
                }
                /*double aux2 = s[k-1];
                s[k-1] = s[filamayor];
                s[filamayor] = aux2;*/

                resultados.add("Matriz A\n");
                setMatriz(matrix, n);
                resultados.add("Vector de mayores de cada fila\n");
                s = busquedaDelMayorDeCadaFila(n, matrix);
                resultados.add(Arrays.toString(s)+ "\n");
            }
        }
    }


    /*--------------------------------------------------------------------------------------------*/

    public static double norma(double[] x, double[] x0, int n) {
        double mayor = Double.NEGATIVE_INFINITY;
        double norma = 0;

        for (int i = 1; i < n; i++) {
            if (Math.abs(x[i - 1] - x0[i - 1]) > mayor) {
                mayor = Math.abs(x[i - 1] - x0[i - 1]);
            }
        }
        norma = mayor;
        return norma;
    }

    /*--------------------------------------------------------------------------------------------*/


    public void setMatriz(double[][] matriz, int n, boolean fact) {
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                resultados.add(String.valueOf(matriz[i][j]));
                setAlignment(String.valueOf(matriz[i][j]).length(), 23);
            }
            resultados.add("\n");
        }
        resultados.add("" + "\n");
    }

    public void setMatriz(double[][] matriz, int n) {
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n + 1; j++) {
                resultados.add(String.valueOf(matriz[i][j]));
                setAlignment(String.valueOf(matriz[i][j]).length(), 23);
            }
            resultados.add("\n");
        }
        resultados.add("" + "\n");
    }

    public void setAlignment(int n, int k) {
        if (n < k) {
            String espacios = "";
            for (int i = 0; i < k - n; i++) {
                espacios = espacios + " ";
            }
            resultados.add(espacios);
        }
    }

    public ArrayList<String> getResultados() {
        return resultados;
    }

    public void setResultados(ArrayList<String> resultados) {
        this.resultados = resultados;
    }

    public ArrayList<String> getSolo_resultado() {
        return solo_resultado;
    }

    public void setSolo_resultado(ArrayList<String> solo_resultado) {
        this.solo_resultado = solo_resultado;
    }
}
