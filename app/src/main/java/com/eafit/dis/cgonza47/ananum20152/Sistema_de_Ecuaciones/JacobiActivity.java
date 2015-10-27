package com.eafit.dis.cgonza47.ananum20152.Sistema_de_Ecuaciones;

import android.app.AlertDialog;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TableLayout;
import android.widget.TableRow;
import android.widget.TextView;

import java.text.DecimalFormat;
import java.text.NumberFormat;

import com.eafit.dis.cgonza47.ananum20152.R;
import com.eafit.dis.cgonza47.ananum20152.utilidades.Sistemas_de_Ecuaciones.DatosIterativos;
import com.eafit.dis.cgonza47.ananum20152.utilidades.Sistemas_de_Ecuaciones.Metodos_Sistemas_de_Ecuaciones;

public class JacobiActivity extends ActionBarActivity implements View.OnClickListener {

    private TableLayout tl;
    private TableRow tr_head;
    private DatosIterativos di;
    private TextView resultados;
    private TextView iter;
    private TextView x;
    private TextView error;
    private Metodos_Sistemas_de_Ecuaciones jacobi;
    private NumberFormat formatter;
    private Button bt_ayuda;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_jacobi);

        Intent intent = getIntent();
        di = (DatosIterativos) intent.getSerializableExtra("matriz_di_jacobi");

        resultados = (TextView) findViewById(R.id.result_jacobi);
        resultados.setVerticalScrollBarEnabled(true);

        bt_ayuda = (Button) findViewById(R.id.ayuda_jacobi);
        bt_ayuda.setOnClickListener(this);

        formatter = new DecimalFormat();
        formatter = new DecimalFormat("#.##E0");

        jacobi = new Metodos_Sistemas_de_Ecuaciones();

        jacobi.jacobi(di.getA(), di.getB(), di.getA().length, di.getX0()
                , di.getIteraciones(), di.getTolerancia(), di.getAlpha());

        for (int i = 0; i < jacobi.getResultados_jacobi().size(); i++) {

            resultados.append(jacobi.getResultados_jacobi().get(i));

        }

        tl = (TableLayout) findViewById(R.id.Table_jacobi);
        tl.setVerticalScrollBarEnabled(true);

        tr_head = new TableRow(this);
        tr_head.setId(100);
        tr_head.setBackgroundColor(Color.WHITE);
        tr_head.setLayoutParams(new TableRow.LayoutParams(TableRow.LayoutParams.MATCH_PARENT,
                TableRow.LayoutParams.WRAP_CONTENT));

        iter = new TextView(this);
        iter.setId(2000000);
        iter.setText("Iter");
        iter.setTextColor(Color.BLACK);
        iter.setPadding(10, 10, 10, 10);
        tr_head.addView(iter);

        for (int i = 0; i < di.getX0().length; i++) {

            x = new TextView(this);
            x.setId((i * 1000000) + 4000000);
            x.setText("X" + i);
            x.setTextColor(Color.BLACK);
            x.setPadding(10, 10, 10, 10);
            tr_head.addView(x);

        }

        error = new TextView(this);
        error.setId(100000000);
        error.setText("Error");
        error.setTextColor(Color.BLACK);
        error.setPadding(10, 10, 10, 10);
        tr_head.addView(error);

        tl.addView(tr_head, new TableLayout.LayoutParams(
                TableLayout.LayoutParams.FILL_PARENT,
                TableLayout.LayoutParams.MATCH_PARENT));

        int punt = 0;

        for (int i = 0; i < jacobi.getIteraciones_jacobi().size(); i++) {

            tr_head = new TableRow(this);
            tr_head.setId(i + 200);
            tr_head.setBackgroundColor(Color.WHITE);
            tr_head.setLayoutParams(new TableRow.LayoutParams(TableRow.LayoutParams.MATCH_PARENT,
                    TableRow.LayoutParams.WRAP_CONTENT));

            iter = new TextView(this);
            iter.setId(i + 2000001);
            iter.setText(String.valueOf(jacobi.getIteraciones_jacobi().get(i)));
            iter.setTextColor(Color.BLACK);
            iter.setPadding(10, 10, 10, 10);
            tr_head.addView(iter);

            for (int j = 0; j < jacobi.getTam_x0_jacobi(); j++) {

                x = new TextView(this);
                x.setId((j * 1000000) + 4000010 + i);
                x.setText(String.valueOf(jacobi.getXs_jacobi().get(punt)));
                x.setTextColor(Color.BLACK);
                x.setPadding(10, 10, 10, 10);
                tr_head.addView(x);
                punt++;

            }

            error = new TextView(this);
            error.setId(i + 100000001);
            error.setText(formatter.format(jacobi.getError_jacobi().get(i)));
            error.setTextColor(Color.BLACK);
            error.setPadding(10, 10, 10, 10);
            tr_head.addView(error);

            tl.addView(tr_head, new TableLayout.LayoutParams(
                    TableLayout.LayoutParams.FILL_PARENT,
                    TableLayout.LayoutParams.MATCH_PARENT));

        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_jacobi, menu);
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

        if (v.getId() == R.id.ayuda_jacobi) {

            String mensaje = "Encontrar las aproximaciones de los valores de las variables de un " +
                    "sistema de ecuaciones lineales, por medio de la realizaci\u00F3n de varios " +
                    "c\u00E1lculos, los cuales se realizan por etapas, obteniendo as\u00ED " +
                    "aproximaciones por cada etapa.";

            showAlert(v, mensaje);


        }
    }

    public void showAlert(View view, String Mensaje) {

        AlertDialog.Builder myAlert = new AlertDialog.Builder(this);
        myAlert.setMessage(Mensaje);
        myAlert.show();

    }
}
