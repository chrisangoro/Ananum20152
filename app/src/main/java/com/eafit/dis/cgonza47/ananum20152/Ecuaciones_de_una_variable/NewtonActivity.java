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

import java.text.NumberFormat;

import com.eafit.dis.cgonza47.ananum20152.R;
import com.eafit.dis.cgonza47.ananum20152.utilidades.GraficadorActivity;
import com.eafit.dis.cgonza47.ananum20152.utilidades.metodos;


public class NewtonActivity extends ActionBarActivity implements View.OnClickListener {

    private String funcion;
    private EditText x0_new;
    private EditText tolerancia;
    private EditText derivada;
    private EditText iter;
    private TextView resultado;
    private metodos metodo;
    private boolean type_tol = true;
    private boolean flag_result = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_newton);

        Bundle bundle = getIntent().getExtras();
        funcion = bundle.getString("funcion");

        metodo = new metodos(funcion);

        x0_new = (EditText) findViewById(R.id.x0_new);
        tolerancia = (EditText) findViewById(R.id.tolerancia_new);
        derivada = (EditText) findViewById(R.id.derivada_new);
        iter = (EditText) findViewById(R.id.iter_new);
        resultado = (TextView) findViewById(R.id.resultado_new);

        resultado.setMaxLines(30);
        resultado.setVerticalScrollBarEnabled(true);
        resultado.setMovementMethod(new ScrollingMovementMethod());

        resultado.setText(funcion + "\n\nPor favor asegurese de que la funcion sea continua o la " +
                "aplicacion fallara");

        Button bt_volver_new = (Button) findViewById(R.id.volver_new);
        Button bt_ayuda_new = (Button) findViewById(R.id.ayuda_new);
        Button bt_calcular_new = (Button) findViewById(R.id.calcular_new);
        Button bt_graficar_new = (Button) findViewById(R.id.graficar_new);

        RadioButton rb_ErrAbs = (RadioButton) findViewById(R.id.ErrAbs_new);
        RadioButton rb_ErrRel = (RadioButton) findViewById(R.id.ErrRel_new);

        rb_ErrAbs.setOnClickListener(this);
        rb_ErrRel.setOnClickListener(this);

        resultado.setOnClickListener(this);

        bt_volver_new.setOnClickListener(this);
        bt_ayuda_new.setOnClickListener(this);
        bt_calcular_new.setOnClickListener(this);
        bt_graficar_new.setOnClickListener(this);

    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_newton, menu);
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


        if (v.getId() == R.id.calcular_new) {

            ALG_newton();

        } else if (v.getId() == R.id.graficar_new) {

            Intent i = new Intent(this, GraficadorActivity.class);
            i.putExtra("funcion", funcion);
            startActivity(i);

        } else if (v.getId() == R.id.ayuda_new) {

            String mensaje = "M\u00E9todo de Newton\n\n" +
                    "Es un m\u00E9todo abierto, es decir, que no tiene en cuenta si el intervalo que se produce en " +
                    "cada iteraci\u00F3n contiene una ra\u00EDz. Es, adem\u00E1s una variante de punto fijo, ya que opera de la " +
                    "misma forma con la diferencia de que G(x) se calcula rest\u00E1ndole al X anterior la divisi\u00F3n " +
                    "de la Funci\u00F3n evaluada en X por la derivada de la misma.";

            showAlert(v,mensaje);

        } else if (v.getId() == R.id.volver_new) {

            Intent i = new Intent(this, MethodActivity.class);
            i.putExtra("funcion", funcion);
            startActivity(i);

        } else if (v.getId() == R.id.ErrAbs_new) {

            type_tol = true;

        } else if (v.getId() == R.id.ErrRel_new) {

            type_tol = false;

        } else if (v.getId() == R.id.resultado_new) {

            if (flag_result) {

                Intent i = new Intent(this, TablaNewtonActivity.class);
                i.putExtra("funcion", funcion);
                i.putExtra("metodo", metodo);
                startActivity(i);

            } else {


            }

        }
    }

    public void ALG_newton() {

        metodo.getIter_new().clear();
        metodo.getVi_new().clear();
        metodo.getGx_new().clear();
        metodo.getFx_new().clear();
        metodo.getError_new().clear();

        if (x0_new.getText().toString() == "" || derivada.getText().toString() == "" || tolerancia.getText().toString() == "" || iter.getText().toString() == "") {

            resultado.setText("por favor inserte los terminos completos");

        } else {

            double x0 = Double.parseDouble(x0_new.getText().toString());
            double tole = Double.parseDouble(tolerancia.getText().toString());
            String fpx = derivada.getText().toString();
            int itera = Integer.parseInt(iter.getText().toString());

            resultado.setText(metodo.newton(tole, x0, itera, fpx, type_tol));

            flag_result = true;
        }
    }

    public void showAlert(View view,String Mensaje){

        AlertDialog.Builder myAlert = new AlertDialog.Builder(this);
        myAlert.setMessage(Mensaje);
        myAlert.show();

    }
}
