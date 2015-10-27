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
import android.widget.TextView;

import com.eafit.dis.cgonza47.ananum20152.R;
import com.eafit.dis.cgonza47.ananum20152.utilidades.GraficadorActivity;
import com.eafit.dis.cgonza47.ananum20152.utilidades.metodos;


public class BusquedasIncrementalesActivity extends ActionBarActivity implements View.OnClickListener {

    private String funcion;
    private EditText x1_b1;
    private EditText delta;
    private EditText iter;
    private TextView resultado;
    private metodos metodo;
    private boolean flag_result = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_busquedas_incrementales_);

        Bundle bundle = getIntent().getExtras();
        funcion = bundle.getString("funcion");

        metodo = new metodos(funcion);

        x1_b1 = (EditText) findViewById(R.id.x1_bi);
        delta = (EditText) findViewById(R.id.delta_bi);
        iter = (EditText) findViewById(R.id.iter_bi);
        resultado = (TextView) findViewById(R.id.resultado_bi);

        resultado.setMaxLines(30);
        resultado.setVerticalScrollBarEnabled(true);
        resultado.setMovementMethod(new ScrollingMovementMethod());

        resultado.setText(funcion + "\n\nPor favor asegurese de que la funcion sea continua o la aplicacion fallara");

        Button bt_volver_bi = (Button) findViewById(R.id.volver_bi);
        Button bt_ayuda_bi = (Button) findViewById(R.id.ayuda_bi);
        Button bt_calcular_bi = (Button) findViewById(R.id.calcular_bi);
        Button bt_graficar_bi = (Button) findViewById(R.id.graficar_bi);

        resultado.setOnClickListener(this);

        bt_volver_bi.setOnClickListener(this);
        bt_ayuda_bi.setOnClickListener(this);
        bt_calcular_bi.setOnClickListener(this);
        bt_graficar_bi.setOnClickListener(this);

    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_busquedas_incrementales_, menu);
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


        if (v.getId() == R.id.calcular_bi) {

            ALG_busqueda_incremental();

        } else if (v.getId() == R.id.graficar_bi) {

            Intent i = new Intent(this, GraficadorActivity.class);
            i.putExtra("funcion", funcion);
            startActivity(i);

        } else if (v.getId() == R.id.ayuda_bi) {

            String mensaje = "M\u00E9todo de B\u00FAsquedas Incrementales.\n\n" +
                    "Cuando utilizamos el m\u00E9todo de B\u00FAsquedas Incrementales, " +
                    "pretendemos encontrar una aproximaci\u00F3n inicial, es decir, " +
                    "un conjunto de valores que formen un intervalo que contenga una ra\u00EDz.";

            showAlert(v,mensaje);

        } else if (v.getId() == R.id.volver_bi) {

            Intent i = new Intent(this, MethodActivity.class);
            i.putExtra("funcion", funcion);
            startActivity(i);

        } else if (v.getId() == R.id.resultado_bi) {

            if (flag_result) {

                Intent i = new Intent(this, TablasBIActivity.class);
                i.putExtra("funcion", funcion);
                i.putExtra("metodo",metodo);
                startActivity(i);

            } else {


            }

        }

    }

    public void ALG_busqueda_incremental() {

        //double x0 = Double.parseDouble(x1_b1.getText().toString());
        //double delt = Double.parseDouble(delta.getText().toString());
        //int itera = Integer.parseInt(iter.getText().toString());

        metodo.getX_bi().clear();
        metodo.getResult_bi().clear();
        metodo.getIter_bi().clear();

        if (x1_b1.getText().toString() == "" || delta.getText().toString() == "" || iter.getText().toString() == "") {

            resultado.setText("por favor inserte los terminos completos");

        } else {

            double x0 = Double.parseDouble(x1_b1.getText().toString());
            double delt = Double.parseDouble(delta.getText().toString());
            int itera = Integer.parseInt(iter.getText().toString());

            resultado.setText(metodo.busquedas_incrementales(x0, delt, itera));

            flag_result = true;
        }

    }

    public void showAlert(View view,String Mensaje){

        AlertDialog.Builder myAlert = new AlertDialog.Builder(this);
        myAlert.setMessage(Mensaje);
        myAlert.show();

    }
}
