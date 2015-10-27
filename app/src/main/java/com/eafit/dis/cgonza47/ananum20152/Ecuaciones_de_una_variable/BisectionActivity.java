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


public class BisectionActivity extends ActionBarActivity implements View.OnClickListener {

    private String funcion;
    private EditText x0_bisec;
    private EditText x1_bisec;
    private EditText tolerancia_bisec;
    private EditText iter;
    private TextView resultado;
    private metodos metodo;
    private boolean type_tol = false;
    private boolean flag_result = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bisection);

        Bundle bundle = getIntent().getExtras();
        funcion = bundle.getString("funcion");

        metodo = new metodos(funcion);

        x0_bisec = (EditText) findViewById(R.id.x0_bisec);
        x1_bisec = (EditText) findViewById(R.id.x1_bisec);
        tolerancia_bisec = (EditText) findViewById(R.id.tolerancia_bisec);
        iter = (EditText) findViewById(R.id.iter_bisec);
        resultado = (TextView) findViewById(R.id.resultado_bisec);

        resultado.setMaxLines(30);
        resultado.setVerticalScrollBarEnabled(true);
        resultado.setMovementMethod(new ScrollingMovementMethod());

        resultado.setText(funcion + "\n\nPor favor asegurese de que la funcion sea continua o " +
                "la aplicacion fallara");

        Button bt_volver_bisec = (Button) findViewById(R.id.volver_bisec);
        Button bt_ayuda_bisec = (Button) findViewById(R.id.ayuda_bisec);
        Button bt_calcular_bisec = (Button) findViewById(R.id.calcular_bisec);
        Button bt_graficar_bisec = (Button) findViewById(R.id.graficar_bisec);

        RadioButton rb_ErrAbs = (RadioButton) findViewById(R.id.ErrAbs_bisec);
        RadioButton rb_ErrRel = (RadioButton) findViewById(R.id.ErrRel_bisec);

        rb_ErrAbs.setOnClickListener(this);
        rb_ErrRel.setOnClickListener(this);

        resultado.setOnClickListener(this);

        bt_volver_bisec.setOnClickListener(this);
        bt_ayuda_bisec.setOnClickListener(this);
        bt_calcular_bisec.setOnClickListener(this);
        bt_graficar_bisec.setOnClickListener(this);

    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_bisection, menu);
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

        if (v.getId() == R.id.calcular_bisec) {

            ALG_bisection();

        } else if (v.getId() == R.id.graficar_bisec) {

            Intent i = new Intent(this, GraficadorActivity.class);
            i.putExtra("funcion", funcion);
            startActivity(i);

        } else if (v.getId() == R.id.ayuda_bisec) {

            String mensaje = "M\u00E9todo de Bisecci\u00F3n.\n\n" +
                    "Este m\u00E9todo consiste en encontrar primero un intervalo donde exista " +
                    "una ra\u00EDz, y luego dividir dicho intervalo en dos sub-intervalos de " +
                    "igual tama\u0148o, con el fin de tener valores m\u0227s aproximados a la ra\u00EDz.";

            showAlert(v,mensaje);

        } else if (v.getId() == R.id.volver_bisec) {

            Intent i = new Intent(this, MethodActivity.class);
            i.putExtra("funcion", funcion);
            startActivity(i);

        } else if (v.getId() == R.id.ErrAbs_bisec) {

            type_tol = true;

        } else if (v.getId() == R.id.ErrRel_bisec) {

            type_tol = false;

        } else if (v.getId() == R.id.resultado_bisec) {

            if (flag_result) {

                Intent i = new Intent(this, TablaBisectionActivity.class);
                i.putExtra("funcion", funcion);
                i.putExtra("metodo",metodo);
                startActivity(i);

            } else {


            }

        }

    }

    public void ALG_bisection() {

        metodo.getIter_bisec().clear();
        metodo.getFm_bisec().clear();
        metodo.getXm_bisec().clear();
        metodo.getError_bisec().clear();

        if (x0_bisec.getText().toString() == "" || x1_bisec.getText().toString() == "" || tolerancia_bisec.getText().toString() == "" || iter.getText().toString() == "") {

            resultado.setText("por favor inserte los terminos completos");

        } else {

            double x0 = Double.parseDouble(x0_bisec.getText().toString());
            double x1 = Double.parseDouble(x1_bisec.getText().toString());
            double toler = Double.parseDouble(tolerancia_bisec.getText().toString());
            int itera = Integer.parseInt(iter.getText().toString());

            resultado.setText(metodo.biseccion(x0, x1, toler, itera, type_tol));

            flag_result = true;
        }

    }

    public void showAlert(View view,String Mensaje){

        AlertDialog.Builder myAlert = new AlertDialog.Builder(this);
        myAlert.setMessage(Mensaje);
        myAlert.show();

    }

}
