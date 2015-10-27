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


public class SecanteActivity extends ActionBarActivity implements View.OnClickListener {

    private String funcion;
    private EditText x0_sec;
    private EditText x1_sec;
    private EditText tolerancia;
    private EditText iter;
    private TextView resultado;
    private metodos metodo;
    private boolean type_tol = true;
    private boolean flag_result = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_secante);

        Bundle bundle = getIntent().getExtras();
        funcion = bundle.getString("funcion");

        metodo = new metodos(funcion);

        x0_sec = (EditText) findViewById(R.id.x0_sec);
        x1_sec = (EditText) findViewById(R.id.x1_sec);
        tolerancia = (EditText) findViewById(R.id.tolerancia_sec);
        iter = (EditText) findViewById(R.id.iter_sec);
        resultado = (TextView) findViewById(R.id.resultado_sec);

        resultado.setMaxLines(30);
        resultado.setVerticalScrollBarEnabled(true);
        resultado.setMovementMethod(new ScrollingMovementMethod());


        resultado.setText(funcion + "\n\nPor favor asegurese de que la funcion sea continua o la aplicacion fallara");

        Button bt_volver_sec = (Button) findViewById(R.id.volver_sec);
        Button bt_ayuda_sec = (Button) findViewById(R.id.ayuda_sec);
        Button bt_calcular_sec = (Button) findViewById(R.id.calcular_sec);
        Button bt_graficar_sec = (Button) findViewById(R.id.graficar_sec);

        RadioButton rb_ErrAbs = (RadioButton) findViewById(R.id.ErrAbs_sec);
        RadioButton rb_ErrRel = (RadioButton) findViewById(R.id.ErrRel_sec);

        rb_ErrAbs.setOnClickListener(this);
        rb_ErrRel.setOnClickListener(this);

        resultado.setOnClickListener(this);

        bt_volver_sec.setOnClickListener(this);
        bt_ayuda_sec.setOnClickListener(this);
        bt_calcular_sec.setOnClickListener(this);
        bt_graficar_sec.setOnClickListener(this);

    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_secante, menu);
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


        if (v.getId() == R.id.calcular_sec) {

            ALG_Secante();

        } else if (v.getId() == R.id.graficar_sec) {

            Intent i = new Intent(this, GraficadorActivity.class);
            i.putExtra("funcion", funcion);
            startActivity(i);

        } else if (v.getId() == R.id.ayuda_sec) {

            String mensaje = "M\u00E9todo Secante\n\nEs un m\u00E9todo abierto, es decir, que " +
                    "no tiene en cuenta si el intervalo que se produce en cada iteraci\u00F3n " +
                    "contiene una ra\u00EDz. Es, adem\u00E1s una variante del m\u00E9todo de " +
                    "Newton, ya que opera de la misma forma con la diferencia de que G(x) se" +
                    " calcula con la formula [Xn+1=Xn-(F(Xn)(Xn-Xn-1))/((F(Xn)-F(Xn-1))]";

            showAlert(v, mensaje);


        } else if (v.getId() == R.id.volver_sec) {

            Intent i = new Intent(this, MethodActivity.class);
            i.putExtra("funcion", funcion);
            startActivity(i);

        } else if (v.getId() == R.id.ErrAbs_sec) {

            type_tol = true;

        } else if (v.getId() == R.id.ErrRel_sec) {

            type_tol = false;

        } else if (v.getId() == R.id.resultado_sec) {

            if (flag_result) {

                Intent i = new Intent(this, TablaSecanteActivity.class);
                i.putExtra("funcion", funcion);
                i.putExtra("metodo", metodo);
                startActivity(i);

            } else {


            }

        }
    }

    public void ALG_Secante() {

        metodo.getVi_sec().clear();
        metodo.getVi_sec().clear();
        metodo.getFxs_sec().clear();
        metodo.getFxa_sec().clear();
        metodo.getError_sec().clear();


        if (x0_sec.getText().toString() == "" || x1_sec.getText().toString() == "" || tolerancia.getText().toString() == "" || iter.getText().toString() == "") {

            resultado.setText("por favor inserte los terminos completos");

        } else {

            double x0 = Double.parseDouble(x0_sec.getText().toString());
            double x1 = Double.parseDouble(x1_sec.getText().toString());
            double tole = Double.parseDouble(tolerancia.getText().toString());
            int itera = Integer.parseInt(iter.getText().toString());

            resultado.setText(metodo.secante(x1, x0, tole, itera, type_tol));

            flag_result = true;
        }
    }

    public void showAlert(View view, String Mensaje) {

        AlertDialog.Builder myAlert = new AlertDialog.Builder(this);
        myAlert.setMessage(Mensaje);
        myAlert.show();

    }
}
