package com.eafit.dis.cgonza47.ananum20152.Sistema_de_Ecuaciones;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.Gravity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;

import com.eafit.dis.cgonza47.ananum20152.R;
import com.eafit.dis.cgonza47.ananum20152.utilidades.Sistemas_de_Ecuaciones.DatosIterativos;
import com.eafit.dis.cgonza47.ananum20152.utilidades.Sistemas_de_Ecuaciones.Matriz;

public class MetodosIterativosActivity extends ActionBarActivity implements View.OnClickListener {

    private Matriz matriz;
    private EditText iter_et_iterativos;
    private EditText tolerancia_et_iterativos;
    private EditText alpha_et_iterativos;
    private Button bt_jacobi;
    private Button bt_gausseidel;
    private LinearLayout ly;
    private double[][] matrizA;
    private double[] matrizb;
    private int columnas;
    private int filas;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_metodos_iterativos);

        iter_et_iterativos = (EditText) findViewById(R.id.iter_et_iterativos);
        tolerancia_et_iterativos = (EditText) findViewById(R.id.tolerancia_et_iterativos);
        alpha_et_iterativos = (EditText) findViewById(R.id.alpha_et_iterativos);
        bt_jacobi = (Button) findViewById(R.id.bt_jacobi);
        bt_gausseidel = (Button) findViewById(R.id.bt_gausseidel);
        ly = (LinearLayout) findViewById(R.id.iterativos_ly);

        ly.setVerticalScrollBarEnabled(true);

        bt_gausseidel.setOnClickListener(this);
        bt_jacobi.setOnClickListener(this);

        Intent intent = getIntent();

        matriz = (Matriz) intent.getSerializableExtra("matriz");

        columnas = matriz.getMatriz()[0].length;
        filas = matriz.getMatriz().length;

        matrizA = new double[filas][columnas - 1];
        matrizb = new double[filas];

        for (int i = 0; i < matrizA.length; i++) {
            for (int j = 0; j < matrizA[i].length; j++) {
                matrizA[i][j] = matriz.getMatriz()[i][j];
            }
        }

        for (int i = 0; i < matrizb.length; i++) {

            matrizb[i] = matriz.getMatriz()[i][columnas - 1];

        }

        for (int i = 0; i < columnas - 1; i++) {

            EditText tv1 = new EditText(this);
            tv1.setId(i);
            tv1.setHint("X" + i);
            //tv1.setInputType(InputType.TYPE_NUMBER_VARIATION_NORMAL);
            tv1.setTextSize(15);
            tv1.setGravity(Gravity.CENTER);
            ly.addView(tv1);

        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_metodos_iterativos, menu);
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
        if (v.getId() == R.id.bt_jacobi) {

            if (iter_et_iterativos.getText().toString().length() >= 1
                    & tolerancia_et_iterativos.getText().toString().length() >= 1
                    & alpha_et_iterativos.toString().length() >= 1
                    ) {

                double[] x0 = new double[columnas - 1];

                EditText et_view;
                boolean flag = true;

                for (int i = 0; i < columnas - 1; i++) {

                    et_view = (EditText) ly.getChildAt(i);

                    if (et_view.getText().toString().length() >= 1) {
                        x0[i] = Double.parseDouble(et_view.getText().toString());
                    } else {
                        flag = false;
                        break;
                    }
                }

                if (flag) {

                    DatosIterativos di = new DatosIterativos(matrizA, matrizb, x0
                            , Integer.parseInt(iter_et_iterativos.getText().toString())
                            , Double.parseDouble(tolerancia_et_iterativos.getText().toString())
                            , Double.parseDouble(alpha_et_iterativos.getText().toString()));

                    Intent i = new Intent(this, JacobiActivity.class);
                    i.putExtra("matriz_di_jacobi", di);
                    startActivity(i);

                } else {
                }
            }
        }
        if (v.getId() == R.id.bt_gausseidel) {

            if (iter_et_iterativos.getText().toString().length() >= 1
                    & tolerancia_et_iterativos.getText().toString().length() >= 1
                    & alpha_et_iterativos.toString().length() >= 1
                    ) {

                double[] x0 = new double[columnas - 1];

                EditText et_view;
                boolean flag = true;

                for (int i = 0; i < columnas - 1; i++) {

                    et_view = (EditText) ly.getChildAt(i);

                    if (et_view.getText().toString().length() >= 1) {
                        x0[i] = Double.parseDouble(et_view.getText().toString());
                    } else {
                        flag = false;
                        break;
                    }
                }

                if (flag) {

                    DatosIterativos di = new DatosIterativos(matrizA, matrizb, x0
                            , Integer.parseInt(iter_et_iterativos.getText().toString())
                            , Double.parseDouble(tolerancia_et_iterativos.getText().toString())
                            , Double.parseDouble(alpha_et_iterativos.getText().toString()));

                    Intent i = new Intent(this, GaussSeidelActivity.class);
                    i.putExtra("matriz_di_gausseidel", di);
                    startActivity(i);

                } else {
                }
            }

        }
    }
}

