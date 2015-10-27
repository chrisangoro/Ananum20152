package com.eafit.dis.cgonza47.ananum20152.Sistema_de_Ecuaciones;

import android.app.AlertDialog;
import android.content.Intent;
import android.graphics.Typeface;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.text.method.ScrollingMovementMethod;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.eafit.dis.cgonza47.ananum20152.R;
import com.eafit.dis.cgonza47.ananum20152.utilidades.Sistemas_de_Ecuaciones.Matriz;
import com.eafit.dis.cgonza47.ananum20152.utilidades.Sistemas_de_Ecuaciones.Metodos_Sistemas_de_Ecuaciones;

public class CholeskyActivity extends ActionBarActivity implements View.OnClickListener {

    private TextView resultado;
    private TextView solo_resultado;
    private Matriz matriz;
    private Metodos_Sistemas_de_Ecuaciones cholesky;
    private Button bt_ayuda;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cholesky);


        solo_resultado = (TextView) findViewById(R.id.solo_resultados_cholesky);

        bt_ayuda = (Button) findViewById(R.id.ayuda_cholesky);
        bt_ayuda.setOnClickListener(this);

        solo_resultado.setOnClickListener(this);

        resultado = (TextView) findViewById(R.id.result_cholesky);
        resultado.setVisibility(View.INVISIBLE);
        resultado.setVerticalScrollBarEnabled(true);
        resultado.setHorizontalScrollBarEnabled(true);
        resultado.setMovementMethod(new ScrollingMovementMethod());
        resultado.setTypeface(Typeface.MONOSPACE);

        Intent intent = getIntent();

        matriz = (Matriz) intent.getSerializableExtra("matriz");

        int columnas = matriz.getMatriz()[0].length;
        int filas = matriz.getMatriz().length;

        double[][] matrizA = new double[filas][columnas - 1];
        double[] matrizb = new double[filas];

        for (int i = 0; i < matrizA.length; i++) {
            for (int j = 0; j < matrizA[i].length; j++) {
                matrizA[i][j] = matriz.getMatriz()[i][j];
            }
        }

        for (int i = 0; i < matrizb.length; i++) {

            matrizb[i] = matriz.getMatriz()[i][columnas - 1];

        }

        cholesky = new Metodos_Sistemas_de_Ecuaciones();

        cholesky.factorizacionDirectaCholesky(matrizA, matrizb, matrizA.length);

        for (int j = 0; j < cholesky.getSolo_resultado().size(); j++) {

            solo_resultado.append(cholesky.getSolo_resultado().get(j));

        }

        for (int i = 0; i < cholesky.getResultados().size(); i++) {

            resultado.append(cholesky.getResultados().get(i));

        }
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_cholesky, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }


    @Override
    public void onClick(View v) {
        if (v.getId() == R.id.solo_resultados_cholesky) {

            solo_resultado.setVisibility(View.INVISIBLE);
            resultado.setVisibility(View.VISIBLE);

        } else if (v.getId() == R.id.ayuda_cholesky) {

            String mensaje = "El objetivo del m\u00E9todo es encontrar una soluci\u00F3n a un" +
                    " sistema de ecuaciones lineales, basado en la factorizaci\u00F3n LU de la " +
                    "matriz de coeficientes relacionada al sistema.";

            showAlert(v, mensaje);

        }
    }

    public void showAlert(View view, String Mensaje) {

        AlertDialog.Builder myAlert = new AlertDialog.Builder(this);
        myAlert.setMessage(Mensaje);
        myAlert.show();

    }

}
