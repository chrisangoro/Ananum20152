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

public class NevilleInterpolacionActivity extends ActionBarActivity implements View.OnClickListener {

    private Datos_inter di;
    private TextView solo_resultado;
    private Metodos_Interpolacion neville;
    private TableLayout tl;
    private TableRow tr_head;
    private TextView xi;
    private TextView fs;
    private Button bt_ayuda;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_neville_interpolacion);

        Intent intent = getIntent();

        di = (Datos_inter) intent.getSerializableExtra("Datos_inter");

        solo_resultado = (TextView) findViewById(R.id.solo_result_nevInter);
        solo_resultado.setOnClickListener(this);

        bt_ayuda = (Button) findViewById(R.id.ayuda_neville);
        bt_ayuda.setOnClickListener(this);

        neville = new Metodos_Interpolacion();

        neville.interpolacionNeville(di.getFx(), di.getX(), di.getY());

        solo_resultado.append("Resultado:\n\n" + neville.getResult_neville());

        tl = (TableLayout) findViewById(R.id.Table_nevinter);
        tl.setVisibility(View.INVISIBLE);
        tl.setVerticalScrollBarEnabled(true);

        tr_head = new TableRow(this);
        tr_head.setId(100000);
        tr_head.setBackgroundColor(Color.WHITE);
        tr_head.setLayoutParams(new TableRow.LayoutParams(TableRow.LayoutParams.MATCH_PARENT,
                TableRow.LayoutParams.WRAP_CONTENT));

        xi = new TextView(this);
        xi.setId(2000000);
        xi.setText("Xi");
        xi.setTextColor(Color.BLACK);
        xi.setPadding(10, 10, 10, 10);
        xi.setBackgroundResource(R.drawable.cell_shape);
        tr_head.addView(xi);

        for (int i = 0; i < neville.getFs_neville().size(); i++) {

            fs = new TextView(this);
            fs.setId((i * 1000000) + 4000000);
            fs.setText(neville.getFs_neville().get(i));
            fs.setTextColor(Color.BLACK);
            fs.setPadding(10, 10, 10, 10);
            fs.setBackgroundResource(R.drawable.cell_shape);
            tr_head.addView(fs);

        }

        tl.addView(tr_head, new TableLayout.LayoutParams(
                TableLayout.LayoutParams.FILL_PARENT,
                TableLayout.LayoutParams.MATCH_PARENT));

        int punt = 0;

        for (int i = 0; i < neville.getXi_neville().size(); i++) {

            tr_head = new TableRow(this);
            tr_head.setId(i + 200);
            tr_head.setBackgroundColor(Color.WHITE);
            tr_head.setLayoutParams(new TableRow.LayoutParams(TableRow.LayoutParams.MATCH_PARENT,
                    TableRow.LayoutParams.WRAP_CONTENT));

            xi = new TextView(this);
            xi.setId(i + 2000001);
            xi.setText(String.valueOf(neville.getXi_neville().get(i)));
            xi.setTextColor(Color.BLACK);
            xi.setPadding(10, 10, 10, 10);
            xi.setBackgroundResource(R.drawable.cell_shape);
            tr_head.addView(xi);

            for (int j = 0; j < neville.getFs_neville().size(); j++) {

                fs = new TextView(this);
                fs.setId((j * 1000000) + 4000010 + i);
                fs.setText(String.valueOf(neville.getFsD_neville().get(punt)));
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
        getMenuInflater().inflate(R.menu.menu_neville_interpolacion, menu);
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

        if (v.getId() == R.id.ayuda_neville) {

            String mensaje = "Es particularmente indicado en el caso de que se desee evaluar el " +
                    "polinomio interpolador en un \u00FAnico punto, o en un n\u00FAmero muy " +
                    "reducido de puntos.";

            showAlert(v, mensaje);

        } else {

            solo_resultado.setVisibility(View.INVISIBLE);

            HorizontalScrollView scroll = (HorizontalScrollView) findViewById(R.id.scroll_resultnevi);
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
