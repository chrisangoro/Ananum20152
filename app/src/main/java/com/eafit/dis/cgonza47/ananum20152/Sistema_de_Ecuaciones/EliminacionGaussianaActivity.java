package com.eafit.dis.cgonza47.ananum20152.Sistema_de_Ecuaciones;

import android.app.AlertDialog;
import android.content.Intent;
import android.graphics.Typeface;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.text.method.ScrollingMovementMethod;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.eafit.dis.cgonza47.ananum20152.R;
import com.eafit.dis.cgonza47.ananum20152.utilidades.Sistemas_de_Ecuaciones.Matriz;
import com.eafit.dis.cgonza47.ananum20152.utilidades.Sistemas_de_Ecuaciones.Metodos_Sistemas_de_Ecuaciones;

public class EliminacionGaussianaActivity extends ActionBarActivity implements View.OnClickListener {

    private TextView resultado;
    private Matriz matriz;
    private Metodos_Sistemas_de_Ecuaciones egs;
    private TextView solo_resultado;
    private Button bt_ayuda;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_eliminacion_gaussiana);

        solo_resultado = (TextView) findViewById(R.id.solo_resultados_eg);
        solo_resultado.setOnClickListener(this);

        bt_ayuda = (Button) findViewById(R.id.ayuda_egs);
        bt_ayuda.setOnClickListener(this);

        resultado = (TextView) findViewById(R.id.result_gaussimple);
        resultado.setVisibility(View.INVISIBLE);
        resultado.setVerticalScrollBarEnabled(true);
        resultado.setHorizontalScrollBarEnabled(true);
        resultado.setMovementMethod(new ScrollingMovementMethod());
        resultado.setTypeface(Typeface.MONOSPACE);

        Intent intent = getIntent();

        matriz = (Matriz) intent.getSerializableExtra("matriz");

        egs = new Metodos_Sistemas_de_Ecuaciones();

        egs.eliminacionGaussianaSimple(matriz.getMatriz().length, matriz.getMatriz());

        for (int j = 0; j < egs.getSolo_resultado().size(); j++) {

            solo_resultado.append(egs.getSolo_resultado().get(j));

        }

        for (int i = 0; i < egs.getResultados().size(); i++) {

            resultado.append(egs.getResultados().get(i));

        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_eliminacion_gaussiana, menu);
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
        if (v.getId() == R.id.solo_resultados_eg) {

            solo_resultado.setVisibility(View.INVISIBLE);
            resultado.setVisibility(View.VISIBLE);

        } else if (v.getId() == R.id.ayuda_egs) {

            String mensaje = "Consiste en convertir a trav\u00E9s de operaciones l\u00EDneales " +
                    "un sistema en otro equivalente m\u00E1s sencillo, cuya respuesta pueda leerse" +
                    " de manera directa, este m\u00E9todo se puede usar para cualquier sistema " +
                    "(n x n) siempre y cuando se respete la relaci\u00F3n de una ecuaci\u00F3n " +
                    "por cada variable y evitando que la diagonal haya 0 ";

            showAlert(v, mensaje);

        }
    }

    public void showAlert(View view, String Mensaje) {

        AlertDialog.Builder myAlert = new AlertDialog.Builder(this);
        myAlert.setMessage(Mensaje);
        myAlert.show();

    }

}
