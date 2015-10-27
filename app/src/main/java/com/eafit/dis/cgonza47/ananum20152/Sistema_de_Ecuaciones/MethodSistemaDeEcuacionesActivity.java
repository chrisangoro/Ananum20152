package com.eafit.dis.cgonza47.ananum20152.Sistema_de_Ecuaciones;

import android.app.AlertDialog;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.text.method.ScrollingMovementMethod;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.StringTokenizer;

import com.eafit.dis.cgonza47.ananum20152.R;
import com.eafit.dis.cgonza47.ananum20152.utilidades.Sistemas_de_Ecuaciones.Matriz;

public class MethodSistemaDeEcuacionesActivity extends ActionBarActivity implements View.OnClickListener {

    private Button entrarmatriz_bt;
    private Button ayuda_bt_matrices;
    private TextView matriz_et;
    private EditText tam_et;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_method_sistema_de_ecuaciones);

        entrarmatriz_bt = (Button) findViewById(R.id.entrarmatriz_bt);
        ayuda_bt_matrices = (Button) findViewById(R.id.ayuda_bt_matrices);
        matriz_et = (TextView) findViewById(R.id.matriz_et);
        tam_et = (EditText) findViewById(R.id.tam_et);

        matriz_et.setVerticalScrollBarEnabled(true);
        matriz_et.setMovementMethod(new ScrollingMovementMethod());

        entrarmatriz_bt.setOnClickListener(this);
        ayuda_bt_matrices.setOnClickListener(this);

        /*insert_n_tv = (TextView) findViewById(R.id.tam_matriz);
        insert_n_et = (EditText) findViewById(R.id.tam_matriz_et);

        entrar_matriz = (Button) findViewById(R.id.entrar_m_bt);
        entrar_matriz.setOnClickListener(this);


        /* Invisibles hasta que... */
        /*insert_matriz = (TextView) findViewById(R.id.matriz_tv);
        insert_matriz.setVisibility(View.INVISIBLE);

        tl = (TableLayout) findViewById(R.id.Table_matriz);
        tl.setVisibility(View.INVISIBLE);*/

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_method_sistema_de_ecuaciones, menu);
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
        /*if (v.getId() == R.id.entrar_m_bt) {



        }*/
        if (v.getId() == R.id.entrarmatriz_bt) {

            if (matriz_et.getText().length() > 3) {


                double[][] matriz = new double[Integer.parseInt(tam_et.getText().toString())]
                        [Integer.parseInt(tam_et.getText().toString()) + 1];
                ArrayList<Double> lista_fila = new ArrayList<Double>();
                int punt = 0;
                int f = 0;
                int c = 0;

                for (int i = 0; i < matriz_et.getText().length(); i++) {

                    if (matriz_et.getText().charAt(i) == '\n') {

                        StringTokenizer tokens = new StringTokenizer(matriz_et.getText()
                                .toString().substring(punt, i));

                        punt = i + 1;

                        while (tokens.hasMoreTokens()) {
                            lista_fila.add(Double.parseDouble(tokens.nextToken()));
                        }

                        if (lista_fila.size() != (Integer.parseInt(tam_et.getText().toString()) + 1)) {

                            lista_fila.clear();
                            matriz_et.setText("Copie la matriz bien");

                            break;
                        }

                        for (int j = 0; j < lista_fila.size(); j++) {

                            matriz[f][j] = lista_fila.get(j);

                        }

                        lista_fila.clear();

                        f++;
                    }

                }

                StringTokenizer tokens = new StringTokenizer(matriz_et.getText()
                        .toString().substring(punt, matriz_et.getText().length()));


                while (tokens.hasMoreTokens()) {
                    lista_fila.add(Double.parseDouble(tokens.nextToken()));
                }

                if (lista_fila.size() != (Integer.parseInt(tam_et.getText().toString()) + 1)) {

                    lista_fila.clear();
                    matriz_et.setText("Copie la matriz bien");

                } else {

                    for (int j = 0; j < lista_fila.size(); j++) {

                        matriz[f][j] = lista_fila.get(j);

                    }

                    lista_fila.clear();

                    Matriz m = new Matriz(matriz);

                    Intent i = new Intent(this, SelecSisEcuActivity.class);
                    i.putExtra("matriz", m);
                    startActivity(i);

                }
            }
        } else if (v.getId() == R.id.ayuda_bt_matrices) {

            String mensaje = "Ayuda sistemas de ecuaciones \n\nTama\u00F1o: pide el valor de " +
                    "la matriz aumentada ej: \"5\" matriz de 4x4 y el valor de B\n\npara " +
                    "ingresar los valores de la matriz se pone el valor separado por un espacio y para una nueva fila se usa \"salto de linea\"";

            showAlert(v, mensaje);

        }
    }

    public void showAlert(View view, String Mensaje) {

        AlertDialog.Builder myAlert = new AlertDialog.Builder(this);
        myAlert.setMessage(Mensaje);
        myAlert.show();

    }
}
