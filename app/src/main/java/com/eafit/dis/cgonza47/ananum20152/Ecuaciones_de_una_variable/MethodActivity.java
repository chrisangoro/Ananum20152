package com.eafit.dis.cgonza47.ananum20152.Ecuaciones_de_una_variable;

import android.app.AlertDialog;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.eafit.dis.cgonza47.ananum20152.R;


public class MethodActivity extends ActionBarActivity implements View.OnClickListener {


    private EditText funcion;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_method);

        Button bt_bisection = (Button) findViewById(R.id.bt_bisection);
        Button bt_reglafalsa = (Button) findViewById(R.id.bt_reglafalsa);
        Button bt_puntofijo = (Button) findViewById(R.id.bt_puntofijo);
        Button bt_newton = (Button) findViewById(R.id.bt_newton);
        Button bt_secante = (Button) findViewById(R.id.bt_secante);
        Button bt_raimul = (Button) findViewById(R.id.bt_raimul);
        Button bt_cap1 = (Button) findViewById(R.id.cap1_ayuda);


        funcion = (EditText) findViewById(R.id.funcion);

        if (getIntent().getExtras() != null) {

            Bundle bundle = getIntent().getExtras();

            if (bundle.getString("funcion") != null) {
                funcion.setText(bundle.getString("funcion"));
            }
        }

        bt_bisection.setOnClickListener(this);
        bt_reglafalsa.setOnClickListener(this);
        bt_puntofijo.setOnClickListener(this);
        bt_newton.setOnClickListener(this);
        bt_secante.setOnClickListener(this);
        bt_raimul.setOnClickListener(this);
        bt_cap1.setOnClickListener(this);


    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_method, menu);
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

        if (v.getId() == R.id.bt_bisection) {

            Intent i = new Intent(this, BisectionActivity.class);
            i.putExtra("funcion", funcion.getText().toString());
            startActivity(i);

        } else if (v.getId() == R.id.bt_reglafalsa) {

            Intent i = new Intent(this, ReglaFalsaActivity.class);
            i.putExtra("funcion", funcion.getText().toString());
            startActivity(i);

        } else if (v.getId() == R.id.bt_puntofijo) {

            Intent i = new Intent(this, PuntoFijoActivity.class);
            i.putExtra("funcion", funcion.getText().toString());
            startActivity(i);

        } else if (v.getId() == R.id.bt_newton) {

            Intent i = new Intent(this, NewtonActivity.class);
            i.putExtra("funcion", funcion.getText().toString());
            startActivity(i);

        } else if (v.getId() == R.id.bt_secante) {

            Intent i = new Intent(this, SecanteActivity.class);
            i.putExtra("funcion", funcion.getText().toString());
            startActivity(i);

        } else if (v.getId() == R.id.bt_raimul) {

            Intent i = new Intent(this, RaicesMultiplesActivity.class);
            i.putExtra("funcion", funcion.getText().toString());
            startActivity(i);

        } else if (v.getId() == R.id.cap1_ayuda) {

            String mensaje = "Ayuda Ecuaciones de una variable\n\nPara mostrar la tabla de " +
                    "valores se hace \"click\" o \"tap\" en la soluci\u00F3n\n\nejemplos de " +
                    "funciones conocidas:\n\n- abs: valor absoluto\n- acos: arco coseno\n- asin" +
                    ": arco seno\n- atan: arco tangente\n- cbrt: raiz cubica\n- ceil: n\u00FAm" +
                    "ero entero superior m\u00E1s cercana\n- cos: coseno\n- cosh: coseno hiperb" +
                    "olico\n- exp: n\u00FAmero de euler's elevado a la potencia (e^x)\n- floor" +
                    ": n\u00FAmero entero inferior m\u00E1s cercano\n- log: logaritmo natural " +
                    "(base e)\n- log10: logaritmo (base 10)\n- log2: logaritmo (base 2)\n- s" +
                    "in: seno\n- sinh: seno hiperbolico\n- sqrt: raiz cuadrada\n- tan: tangen" +
                    "te\n- tanh: tangente hiperbolica\n";

            showAlert(v, mensaje);

        }
    }

    public void showAlert(View view, String Mensaje) {

        AlertDialog.Builder myAlert = new AlertDialog.Builder(this);
        myAlert.setMessage(Mensaje);
        myAlert.show();

    }
}
