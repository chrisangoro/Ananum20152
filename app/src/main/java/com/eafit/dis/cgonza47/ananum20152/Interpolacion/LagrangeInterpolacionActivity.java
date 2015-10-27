package com.eafit.dis.cgonza47.ananum20152.Interpolacion;

import android.app.AlertDialog;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.eafit.dis.cgonza47.ananum20152.R;
import com.eafit.dis.cgonza47.ananum20152.utilidades.Interpolacion.Datos_inter;
import com.eafit.dis.cgonza47.ananum20152.utilidades.Interpolacion.Metodos_Interpolacion;

public class LagrangeInterpolacionActivity extends ActionBarActivity implements View.OnClickListener {

    private Datos_inter di;
    private TextView solo_resultado;
    private Metodos_Interpolacion lagrange;
    private Button bt_ayuda;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lagrange_interpolacion);

        Intent intent = getIntent();

        di = (Datos_inter) intent.getSerializableExtra("Datos_inter");

        bt_ayuda = (Button) findViewById(R.id.ayuda_lagrange);
        bt_ayuda.setOnClickListener(this);

        solo_resultado = (TextView) findViewById(R.id.solo_result_laInter);

        lagrange = new Metodos_Interpolacion();

        lagrange.interpolacionLagrange(di.getFx(), di.getX(), di.getY());

        solo_resultado.append("Construccion funcion L(x):\n\n");

        for (int i = 0; i < lagrange.getResultado_L().size(); i++) {

            solo_resultado.append(lagrange.getResultado_L().get(i));
            solo_resultado.append("\n");

        }

        solo_resultado.append("\nPolinomio interpolante:\n\n");

        for (int i = 0; i < lagrange.getPol_lagra().size(); i++) {

            solo_resultado.append(lagrange.getPol_lagra().get(i));

        }

        solo_resultado.append("\nResultado:\n\n" + lagrange.getFx_la());

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_lagrange_interpolacion, menu);
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
        if (v.getId() == R.id.ayuda_lagrange) {

            String mensaje = "Encontrar un polinomio interpolante que represente una funci\u00F3n " +
                    "o un problema sin definici\u00F3n exacta, que pase por un conjunto de puntos " +
                    "dados.";

            showAlert(v, mensaje);

        }
    }

    public void showAlert(View view, String Mensaje) {

        AlertDialog.Builder myAlert = new AlertDialog.Builder(this);
        myAlert.setMessage(Mensaje);
        myAlert.show();

    }
}
