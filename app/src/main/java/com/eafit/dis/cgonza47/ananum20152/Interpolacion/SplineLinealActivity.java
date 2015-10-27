package com.eafit.dis.cgonza47.ananum20152.Interpolacion;

import android.app.AlertDialog;
import android.content.Intent;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.eafit.dis.cgonza47.ananum20152.R;
import com.eafit.dis.cgonza47.ananum20152.utilidades.Interpolacion.Datos_inter;
import com.eafit.dis.cgonza47.ananum20152.utilidades.Interpolacion.Metodos_Interpolacion;

public class SplineLinealActivity extends ActionBarActivity implements View.OnClickListener {

    private Datos_inter di;
    private TextView solo_resultado;
    private Metodos_Interpolacion spline1;
    private Button bt_ayuda;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_spline_lineal);

        Intent intent = getIntent();

        di = (Datos_inter) intent.getSerializableExtra("Datos_inter");

        bt_ayuda = (Button) findViewById(R.id.ayuda_splin1);
        bt_ayuda.setOnClickListener(this);

        solo_resultado = (TextView) findViewById(R.id.solo_result_spline1);

        spline1 = new Metodos_Interpolacion();

        spline1.interpolacionTrazadoresLineales(di.getFx(), di.getX(), di.getY());

        solo_resultado.append("\n\n");

        for (int i = 0; i < spline1.getPendientes_spline1().size(); i++) {

            solo_resultado.append(spline1.getPendientes_spline1().get(i));

        }

        solo_resultado.append("\n\nEcuaciones\n\n");

        for (int i = 0; i < spline1.getFormulas_spline1().size(); i++) {

            solo_resultado.append(spline1.getFormulas_spline1().get(i));

        }

        solo_resultado.append("\nResultado f(x):\n\n");
        solo_resultado.append(spline1.getResultado_spline1());


    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_spline_lineal, menu);
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

    public void showAlert(View view, String Mensaje) {

        AlertDialog.Builder myAlert = new AlertDialog.Builder(this);
        myAlert.setMessage(Mensaje);
        myAlert.show();

    }

    @Override
    public void onClick(View v) {

        if (v.getId() == R.id.ayuda_splin1) {

            String mensaje = "Se quiere interpolar una funci\u00F3n F(x) de la que se conoce " +
                    "un n\u00FAmero de puntos pares (x, F(x)) por los cuales la funci\u00F3n " +
                    "polinomica debe pasar, en este m\\u00E9todo estas funciones son " +
                    "lineales es decir con grado 1";

            showAlert(v, mensaje);

        }
    }
}
