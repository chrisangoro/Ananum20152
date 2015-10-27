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

public class SplineCubicoActivity extends ActionBarActivity implements View.OnClickListener {

    private Datos_inter di;
    private TextView solo_resultado;
    private Metodos_Interpolacion spline3;
    private Button bt_ayuda;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_spline_cubico);

        Intent intent = getIntent();

        di = (Datos_inter) intent.getSerializableExtra("Datos_inter");

        bt_ayuda = (Button) findViewById(R.id.ayuda_splin3);
        bt_ayuda.setOnClickListener(this);

        solo_resultado = (TextView) findViewById(R.id.solo_result_spline3);

        spline3 = new Metodos_Interpolacion();

        spline3.interpolacionTrazadoresCubicoNatural(di.getFx(), di.getX(), di.getY());

        for (int i = 0; i < spline3.getEcuaciones_spline3().size(); i++) {

            solo_resultado.append(spline3.getEcuaciones_spline3().get(i));

        }

        solo_resultado.append("\nResultado f(x):\n\n");
        solo_resultado.append(spline3.getResultado_spline3());

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_spline_cubico, menu);
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

        if (v.getId() == R.id.ayuda_splin3) {

            String mensaje = "El spline c\u00FAbico es el spline m\u00E1s empleado, debido " +
                    "a que proporciona un excelente ajuste a los puntos tabulados y su " +
                    "c\u00E1lculo no es excesivamente complejo se verifican las uniones " +
                    "con sus derivadas para que sean cambios suaves.";

            showAlert(v, mensaje);

        }
    }

    public void showAlert(View view, String Mensaje) {

        AlertDialog.Builder myAlert = new AlertDialog.Builder(this);
        myAlert.setMessage(Mensaje);
        myAlert.show();

    }
}
