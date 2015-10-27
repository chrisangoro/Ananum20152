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

public class RaicesMultiplesActivity extends ActionBarActivity implements View.OnClickListener {

    private String funcion;
    private EditText x0_raimul;
    private EditText tolerancia;
    private EditText derivada;
    private EditText derivadaseg;
    private EditText iter;
    private TextView resultado;
    private metodos metodo;
    private boolean type_tol = true;
    private boolean flag_result = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_raices_multiples);

        Bundle bundle = getIntent().getExtras();
        funcion = bundle.getString("funcion");

        metodo = new metodos(funcion);

        x0_raimul = (EditText) findViewById(R.id.x0_raimul);
        tolerancia = (EditText) findViewById(R.id.tolerancia_raimul);
        derivada = (EditText) findViewById(R.id.derivada_raimul);
        derivadaseg = (EditText) findViewById(R.id.derivadaseg_raimul);
        iter = (EditText) findViewById(R.id.iter_raimul);
        resultado = (TextView) findViewById(R.id.resultado_raimul);

        resultado.setMaxLines(30);
        resultado.setVerticalScrollBarEnabled(true);
        resultado.setMovementMethod(new ScrollingMovementMethod());

        resultado.setText(funcion + "\n\nPor favor asegurese de que la funcion sea continua o la aplicacion fallara");

        Button bt_volver_raimul = (Button) findViewById(R.id.volver_raimul);
        Button bt_ayuda_raimul = (Button) findViewById(R.id.ayuda_raimul);
        Button bt_calcular_raimul = (Button) findViewById(R.id.calcular_raimul);
        Button bt_graficar_raimul = (Button) findViewById(R.id.graficar_raimul);

        RadioButton rb_ErrAbs = (RadioButton) findViewById(R.id.ErrAbs_raimul);
        RadioButton rb_ErrRel = (RadioButton) findViewById(R.id.ErrRel_raimul);

        rb_ErrAbs.setOnClickListener(this);
        rb_ErrRel.setOnClickListener(this);

        resultado.setOnClickListener(this);

        bt_volver_raimul.setOnClickListener(this);
        bt_ayuda_raimul.setOnClickListener(this);
        bt_calcular_raimul.setOnClickListener(this);
        bt_graficar_raimul.setOnClickListener(this);

    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_raices_multiples, menu);
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

        if (v.getId() == R.id.calcular_raimul) {

            ALG_raicesmultiples();

        } else if (v.getId() == R.id.graficar_raimul) {

            Intent i = new Intent(this, GraficadorActivity.class);
            i.putExtra("funcion", funcion);
            startActivity(i);

        } else if (v.getId() == R.id.ayuda_raimul) {


            String mensaje = "M\u00E9todo de Raices Multiples\n\nEs un m\u00E9todo abierto, " +
                    "es decir, que no tiene en cuenta si el intervalo que se produce en cada " +
                    "iteraci\u00F3n contiene una ra\u00EDz. Es, adem\u00E1s una variante de " +
                    "Newton, ya que opera de la misma forma\ncon la diferencia de que  se " +
                    "calculan dos derivadas, para hallar el X siguiente rest\u00E1ndole al " +
                    "Xanterior la divisi\u00F3n entre la multiplicaci\u00F3n de la funcion " +
                    "evaluada  por la derivada y la resta entre la primera derivada al " +
                    "cuadrado y la multiplicaci\u00F3n de la funcion evaluada por la " +
                    "segunda derivada. ";

            showAlert(v, mensaje);

        } else if (v.getId() == R.id.volver_raimul) {

            Intent i = new Intent(this, MethodActivity.class);
            i.putExtra("funcion", funcion);
            startActivity(i);

        } else if (v.getId() == R.id.ErrAbs_raimul) {

            type_tol = true;

        } else if (v.getId() == R.id.ErrRel_raimul) {

            type_tol = false;

        } else if (v.getId() == R.id.resultado_raimul) {

            if (flag_result) {

                Intent i = new Intent(this, TablaRaicesMultiplesActivity.class);
                i.putExtra("funcion", funcion);
                i.putExtra("metodo", metodo);
                startActivity(i);

            } else {


            }

        }
    }

    public void ALG_raicesmultiples() {

        metodo.getIter_rm().clear();
        metodo.getVi_rm().clear();
        metodo.getFpx_rm().clear();
        metodo.getFx_rm().clear();
        metodo.getFpp_rm().clear();
        metodo.getError_rm().clear();

        if (x0_raimul.getText().toString() == "" || derivada.getText().toString() == "" || derivadaseg.getText().toString() == "" || tolerancia.getText().toString() == "" || iter.getText().toString() == "") {

            resultado.setText("por favor inserte los terminos completos");

        } else {

            double x0 = Double.parseDouble(x0_raimul.getText().toString());
            double tole = Double.parseDouble(tolerancia.getText().toString());
            String fpx = derivada.getText().toString();
            String fppx = derivadaseg.getText().toString();
            int itera = Integer.parseInt(iter.getText().toString());

            resultado.setText(metodo.RaicesMultiples(tole, x0, itera, fpx, fppx, type_tol));

            flag_result = true;
        }

    }

    public void showAlert(View view, String Mensaje) {

        AlertDialog.Builder myAlert = new AlertDialog.Builder(this);
        myAlert.setMessage(Mensaje);
        myAlert.show();

    }

}
