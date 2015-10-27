package com.eafit.dis.cgonza47.ananum20152.Ecuaciones_de_una_variable;

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
import android.widget.RadioButton;
import android.widget.TextView;

import com.eafit.dis.cgonza47.ananum20152.R;
import com.eafit.dis.cgonza47.ananum20152.utilidades.GraficadorActivity;
import com.eafit.dis.cgonza47.ananum20152.utilidades.metodos;

public class ReglaFalsaActivity extends ActionBarActivity implements View.OnClickListener {

    private String funcion;
    private EditText x0_rg;
    private EditText x1_rg;
    private EditText tolerancia_rg;
    private EditText iter;
    private TextView resultado;
    private metodos metodo;
    private boolean type_tol = true;
    private boolean flag_result = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_regla_falsa);

        Bundle bundle = getIntent().getExtras();
        funcion = bundle.getString("funcion");

        metodo = new metodos(funcion);

        x0_rg = (EditText) findViewById(R.id.x0_rg);
        x1_rg = (EditText) findViewById(R.id.x1_rg);
        tolerancia_rg = (EditText) findViewById(R.id.tolerancia_rg);
        iter = (EditText) findViewById(R.id.iter_rg);
        resultado = (TextView) findViewById(R.id.resultado_rg);

        resultado.setMaxLines(30);
        resultado.setVerticalScrollBarEnabled(true);
        resultado.setMovementMethod(new ScrollingMovementMethod());

        resultado.setText(funcion + "\n\nPor favor asegurese de que la funcion sea continua o la aplicacion fallara");

        Button bt_volver_rg = (Button) findViewById(R.id.volver_rg);
        Button bt_ayuda_rg = (Button) findViewById(R.id.ayuda_rg);
        Button bt_calcular_rg = (Button) findViewById(R.id.calcular_rg);
        Button bt_graficar_rg = (Button) findViewById(R.id.graficar_rg);

        RadioButton rb_ErrAbs = (RadioButton) findViewById(R.id.ErrAbs_rg);
        RadioButton rb_ErrRel = (RadioButton) findViewById(R.id.ErrRel_rg);

        rb_ErrAbs.setOnClickListener(this);
        rb_ErrRel.setOnClickListener(this);

        resultado.setOnClickListener(this);

        bt_volver_rg.setOnClickListener(this);
        bt_ayuda_rg.setOnClickListener(this);
        bt_calcular_rg.setOnClickListener(this);
        bt_graficar_rg.setOnClickListener(this);


    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_regla_falsa, menu);
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

        if (v.getId() == R.id.calcular_rg) {

            ALG_reglafalsa();

        } else if (v.getId() == R.id.graficar_rg) {

            Intent i = new Intent(this, GraficadorActivity.class);
            i.putExtra("funcion", funcion);
            startActivity(i);

        } else if (v.getId() == R.id.ayuda_rg) {

            String mensaje = "M\u00E9todo de Regla Falsa\n\nEste m\u00E9todo es una " +
                    "variable del m\u00E9todo de bisecci\u00F3n, pues consiste en " +
                    "reducir el intervalo en el que se encuentra una ra\u00EDz. La " +
                    "diferencia radica en que para calcular un valor medio, lo hacemos" +
                    "mediante la pendiente y por consiguiente con una formula diferente. ";

            showAlert(v, mensaje);

        } else if (v.getId() == R.id.volver_rg) {

            Intent i = new Intent(this, MethodActivity.class);
            i.putExtra("funcion", funcion);
            startActivity(i);

        } else if (v.getId() == R.id.ErrAbs_rg) {

            type_tol = true;

        } else if (v.getId() == R.id.ErrRel_rg) {

            type_tol = false;

        } else if (v.getId() == R.id.resultado_rg) {

            if (flag_result) {

                Intent i = new Intent(this, TablaReglaFalsaActivity.class);
                i.putExtra("funcion", funcion);
                i.putExtra("metodo", metodo);
                startActivity(i);

            } else {



            }

        }
    }

    public void ALG_reglafalsa() {

        metodo.getIter_rg().clear();
        metodo.getXm_rg().clear();
        metodo.getFm_rg().clear();
        metodo.getError_rg().clear();

        if (x0_rg.getText().toString() == "" || x1_rg.getText().toString() == "" || tolerancia_rg.getText().toString() == "" || iter.getText().toString() == "") {

            resultado.setText("por favor inserte los terminos completos");

        } else {

            double x0 = Double.parseDouble(x0_rg.getText().toString());
            double x1 = Double.parseDouble(x1_rg.getText().toString());
            double toler = Double.parseDouble(tolerancia_rg.getText().toString());
            int itera = Integer.parseInt(iter.getText().toString());

            resultado.setText(metodo.Regla_Falsa(x0, x1, toler, itera, type_tol));

            flag_result = true;

        }

    }

    public void showAlert(View view,String Mensaje){

        AlertDialog.Builder myAlert = new AlertDialog.Builder(this);
        myAlert.setMessage(Mensaje);
        myAlert.show();

    }
}
