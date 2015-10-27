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

public class PuntoFijoActivity extends ActionBarActivity implements View.OnClickListener {

    private String funcion;
    private EditText x0_pf;
    private EditText tolerancia;
    private EditText funciong;
    private EditText iter;
    private TextView resultado;
    private metodos metodo;
    private boolean type_tol = true;
    private boolean flag_result = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_punto_fijo);

        Bundle bundle = getIntent().getExtras();
        funcion = bundle.getString("funcion");

        metodo = new metodos(funcion);

        x0_pf = (EditText) findViewById(R.id.x0_pf);
        tolerancia = (EditText) findViewById(R.id.tolerancia_pf);
        funciong = (EditText) findViewById(R.id.funciong_pf);
        iter = (EditText) findViewById(R.id.iter_pf);
        resultado = (TextView) findViewById(R.id.resultado_pf);

        resultado.setMaxLines(30);
        resultado.setVerticalScrollBarEnabled(true);
        resultado.setMovementMethod(new ScrollingMovementMethod());

        resultado.setText(funcion + "\n\nPor favor asegurese de que la funcion sea continua o la aplicacion fallara");

        Button bt_volver_pf = (Button) findViewById(R.id.volver_pf);
        Button bt_ayuda_pf = (Button) findViewById(R.id.ayuda_pf);
        Button bt_calcular_pf = (Button) findViewById(R.id.calcular_pf);
        Button bt_graficar_pf = (Button) findViewById(R.id.graficar_pf);

        RadioButton rb_ErrAbs = (RadioButton) findViewById(R.id.ErrAbs_pf);
        RadioButton rb_ErrRel = (RadioButton) findViewById(R.id.ErrRel_pf);

        rb_ErrAbs.setOnClickListener(this);
        rb_ErrRel.setOnClickListener(this);

        resultado.setOnClickListener(this);

        bt_volver_pf.setOnClickListener(this);
        bt_ayuda_pf.setOnClickListener(this);
        bt_calcular_pf.setOnClickListener(this);
        bt_graficar_pf.setOnClickListener(this);
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_punto_fijo, menu);
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


        if (v.getId() == R.id.calcular_pf) {

            ALG_puntofijo();

        } else if (v.getId() == R.id.graficar_pf) {

            Intent i = new Intent(this, GraficadorActivity.class);
            i.putExtra("funcion", funcion);
            startActivity(i);

        } else if (v.getId() == R.id.ayuda_pf) {

            String mensaje = "M\u00E9todo de Punto Fijo\n\nEste es un m\u00E9todo abierto,es decir, " +
                    "que en cada iteraci\u00F3n calcula una aproximaci\u00F3n a la ra\u00EDz, " +
                    "sin tener en cuenta si ese intervalo contiene o no una ra\u00EDz. " +
                    "La diferencia principal de este m\u00E9todo consiste en hallar Xn, " +
                    "ya que no se hace simplemente sumando un incremento constante, sino " +
                    "que adem\u00E1s se genera a ecuaci\u00F3n X = (gx) buscando la " +
                    "intersecci\u00F3n de la recta y=x yla curva y=g(x). Cuando se " +
                    "tiene dicho valor se eval\u00FAa en f(x), buscando que se " +
                    "presente un cambio de signo con respecto a la anterior o que " +
                    "su resultado sea igual a cero para determinar si encontramos " +
                    "un intervalo o una ra\u00EDz.";

            showAlert(v, mensaje);


        } else if (v.getId() == R.id.volver_pf) {

            Intent i = new Intent(this, MethodActivity.class);
            i.putExtra("funcion", funcion);
            startActivity(i);

        } else if (v.getId() == R.id.ErrAbs_pf) {

            type_tol = true;

        } else if (v.getId() == R.id.ErrRel_pf) {

            type_tol = false;

        } else if (v.getId() == R.id.resultado_pf) {

            if (flag_result) {

                Intent i = new Intent(this, TablaPuntoFijoActivity.class);
                i.putExtra("funcion", funcion);
                i.putExtra("metodo", metodo);
                startActivity(i);

            } else {


            }

        }
    }

    public void ALG_puntofijo() {

        metodo.getIter_pf().clear();
        metodo.getVi_pf().clear();
        metodo.getGx_pf().clear();
        metodo.getFx_pf().clear();
        metodo.getError_pf().clear();

        if (x0_pf.getText().toString() == "" || tolerancia.getText().toString() == "" || iter.getText().toString() == "") {

            resultado.setText("por favor inserte los terminos completos");

        } else {

            double x0 = Double.parseDouble(x0_pf.getText().toString());
            double tole = Double.parseDouble(tolerancia.getText().toString());
            String gx = funciong.getText().toString();
            int itera = Integer.parseInt(iter.getText().toString());

            resultado.setText(metodo.Punto_fijo(x0, tole, itera, gx, type_tol));

            flag_result = true;
        }

    }

    public void showAlert(View view, String Mensaje) {

        AlertDialog.Builder myAlert = new AlertDialog.Builder(this);
        myAlert.setMessage(Mensaje);
        myAlert.show();

    }
}
