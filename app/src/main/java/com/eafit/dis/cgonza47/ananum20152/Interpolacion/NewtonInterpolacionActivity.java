package com.eafit.dis.cgonza47.ananum20152.Interpolacion;

import android.app.AlertDialog;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.HorizontalScrollView;
import android.widget.TableLayout;
import android.widget.TableRow;
import android.widget.TextView;

import com.eafit.dis.cgonza47.ananum20152.R;
import com.eafit.dis.cgonza47.ananum20152.utilidades.Interpolacion.Datos_inter;
import com.eafit.dis.cgonza47.ananum20152.utilidades.Interpolacion.Metodos_Interpolacion;

public class NewtonInterpolacionActivity extends ActionBarActivity implements View.OnClickListener {

    private Datos_inter di;
    private TextView solo_resultado;
    private Metodos_Interpolacion newton;
    private TableLayout tl;
    private TableRow tr_head;
    private TextView xi;
    private TextView fs;
    private Button bt_ayuda;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_newton_interpolacion);

        Intent intent = getIntent();

        di = (Datos_inter) intent.getSerializableExtra("Datos_inter");

        solo_resultado = (TextView) findViewById(R.id.solo_result_newInter);
        solo_resultado.setOnClickListener(this);

        bt_ayuda = (Button) findViewById(R.id.ayuda_newinter);
        bt_ayuda.setOnClickListener(this);

        newton = new Metodos_Interpolacion();

        newton.interpolacionNewtonDiferenciasDivididas(di.getFx(), di.getX(), di.getY());

        solo_resultado.append(newton.getPolinomio_newton() + "\n\n");

        solo_resultado.append(newton.getResultado_newton());

        tl = (TableLayout) findViewById(R.id.Table_newinter);
        tl.setVisibility(View.INVISIBLE);
        tl.setVerticalScrollBarEnabled(true);

        tr_head = new TableRow(this);
        tr_head.setId(100000);
        tr_head.setBackgroundColor(Color.WHITE);
        tr_head.setLayoutParams(new TableRow.LayoutParams(TableRow.LayoutParams.MATCH_PARENT,
                TableRow.LayoutParams.WRAP_CONTENT));

        xi = new TextView(this);
        xi.setId(2000000);
        xi.setText("xi");
        xi.setTextColor(Color.BLACK);
        xi.setPadding(10, 10, 10, 10);
        xi.setBackgroundResource(R.drawable.cell_shape);
        tr_head.addView(xi);

        for (int i = 0; i < newton.getFs_newton().size(); i++) {

            fs = new TextView(this);
            fs.setId((i * 1000000) + 4000000);
            fs.setText(newton.getFs_newton().get(i));
            fs.setTextColor(Color.BLACK);
            fs.setPadding(10, 10, 10, 10);
            fs.setBackgroundResource(R.drawable.cell_shape);
            tr_head.addView(fs);

        }

        tl.addView(tr_head, new TableLayout.LayoutParams(
                TableLayout.LayoutParams.FILL_PARENT,
                TableLayout.LayoutParams.MATCH_PARENT));

        int punt = 0;

        for (int i = 0; i < newton.getXi_newton().size(); i++) {

            tr_head = new TableRow(this);
            tr_head.setId(i + 200);
            tr_head.setBackgroundColor(Color.WHITE);
            tr_head.setLayoutParams(new TableRow.LayoutParams(TableRow.LayoutParams.MATCH_PARENT,
                    TableRow.LayoutParams.WRAP_CONTENT));

            xi = new TextView(this);
            xi.setId(i + 2000001);
            xi.setText(String.valueOf(newton.getXi_newton().get(i)));
            xi.setTextColor(Color.BLACK);
            xi.setPadding(10, 10, 10, 10);
            xi.setBackgroundResource(R.drawable.cell_shape);
            tr_head.addView(xi);

            for (int j = 0; j < newton.getFs_newton().size(); j++) {

                fs = new TextView(this);
                fs.setId((j * 1000000) + 4000010 + i);
                fs.setText(String.valueOf(newton.getFsD_newton().get(punt)));
                fs.setTextColor(Color.BLACK);
                fs.setPadding(10, 10, 10, 10);
                fs.setBackgroundResource(R.drawable.cell_shape);
                tr_head.addView(fs);
                punt++;

            }

            tl.addView(tr_head, new TableLayout.LayoutParams(
                    TableLayout.LayoutParams.FILL_PARENT,
                    TableLayout.LayoutParams.MATCH_PARENT));

        }

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_newton_interpolacion, menu);
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

        if (v.getId() == R.id.ayuda_newinter) {

            String mensaje = "Se basa en la obtenci\u00F3n de un polinomio a partir de un " +
                    "conjunto de puntos dado, aproxim\u00E1ndose lo m\u00E1s posible a la " +
                    "curva buscada.";

            showAlert(v, mensaje);

        } else {

            solo_resultado.setVisibility(View.INVISIBLE);

            HorizontalScrollView scroll = (HorizontalScrollView) findViewById(R.id.scroll_resultnew);
            scroll.setHorizontalScrollBarEnabled(false);
            scroll.setVisibility(View.INVISIBLE);
            scroll.setScrollContainer(false);

            tl.setVisibility(View.VISIBLE);
        }

    }

    public void showAlert(View view, String Mensaje) {

        AlertDialog.Builder myAlert = new AlertDialog.Builder(this);
        myAlert.setMessage(Mensaje);
        myAlert.show();

    }
}
