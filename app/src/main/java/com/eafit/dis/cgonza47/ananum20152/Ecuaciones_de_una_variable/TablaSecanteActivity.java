package com.eafit.dis.cgonza47.ananum20152.Ecuaciones_de_una_variable;

import android.content.Intent;
import android.graphics.Color;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TableLayout;
import android.widget.TableRow;
import android.widget.TextView;

import java.text.DecimalFormat;
import java.text.NumberFormat;

import com.eafit.dis.cgonza47.ananum20152.R;
import com.eafit.dis.cgonza47.ananum20152.utilidades.metodos;

public class TablaSecanteActivity extends ActionBarActivity {

    private String funcion;
    private metodos metodo;
    private TextView tabla;
    private TableLayout tl;
    private TableRow tr_head;
    private TextView iter;
    private TextView vi;
    private TextView fxs;
    private TextView fxa;
    private TextView xsminusxa;
    private TextView error;
    private NumberFormat formatter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tabla_secante);

        Intent intent = getIntent();
        funcion = intent.getStringExtra("funcion");
        metodo = (metodos) intent.getSerializableExtra("metodo");

        tl = (TableLayout) findViewById(R.id.Table_sec);
        tl.setVerticalScrollBarEnabled(true);

        formatter = new DecimalFormat();
        formatter = new DecimalFormat("#.##E0");

        tr_head = new TableRow(this);
        tr_head.setId(100000);
        tr_head.setBackgroundColor(Color.WHITE);
        tr_head.setLayoutParams(new TableRow.LayoutParams(TableRow.LayoutParams.MATCH_PARENT,
                TableRow.LayoutParams.WRAP_CONTENT));

        iter = new TextView(this);
        iter.setId(20000000);
        iter.setText("Iter");
        iter.setTextColor(Color.BLACK);
        iter.setPadding(10, 10, 10, 10);
        tr_head.addView(iter);

        vi = new TextView(this);
        vi.setId(30000000);
        vi.setText("Valor inicial");
        vi.setTextColor(Color.BLACK);
        vi.setPadding(10, 10, 10, 10);
        tr_head.addView(vi);

        /*xsminusxa = new TextView(this);
        xsminusxa.setId(40000000);
        xsminusxa.setText("Xi - Xi-1");
        xsminusxa.setTextColor(Color.BLACK);
        xsminusxa.setPadding(10, 10, 10, 10);
        tr_head.addView(xsminusxa);*/

        fxs = new TextView(this);
        fxs.setId(50000000);
        fxs.setText("F( Xi )");
        fxs.setTextColor(Color.BLACK);
        fxs.setPadding(10, 10, 10, 10);
        tr_head.addView(fxs);

        fxa = new TextView(this);
        fxa.setId(60000000);
        fxa.setText("F( X(i-1) )");
        fxa.setTextColor(Color.BLACK);
        fxa.setPadding(10, 10, 10, 10);
        tr_head.addView(fxa);

        error = new TextView(this);
        error.setId(70000000);
        error.setText("error");
        error.setTextColor(Color.BLACK);
        error.setPadding(10, 10, 10, 10);
        tr_head.addView(error);

        tl.addView(tr_head, new TableLayout.LayoutParams(
                TableLayout.LayoutParams.FILL_PARENT,
                TableLayout.LayoutParams.MATCH_PARENT));

        for (int i = 0; i < metodo.getIter_sec().size(); i++) {

            tr_head = new TableRow(this);
            tr_head.setId(i + 10000001);
            tr_head.setBackgroundColor(Color.WHITE);
            tr_head.setLayoutParams(new TableRow.LayoutParams(TableRow.LayoutParams.MATCH_PARENT,
                    TableRow.LayoutParams.WRAP_CONTENT));

            iter = new TextView(this);
            iter.setId(i + 20000001);
            iter.setText(String.valueOf(metodo.getIter_sec().get(i)));
            iter.setTextColor(Color.BLACK);
            iter.setPadding(10, 10, 10, 10);
            tr_head.addView(iter);

            vi = new TextView(this);
            vi.setId(i + 30000001);
            vi.setText(String.valueOf(metodo.getVi_sec().get(i)));
            vi.setTextColor(Color.BLACK);
            vi.setPadding(10, 10, 10, 10);
            tr_head.addView(vi);

            /*xsminusxa = new TextView(this);
            xsminusxa.setId(i + 40000001);
            xsminusxa.setText(String.valueOf(metodo.getXisminusxia().get(i)));
            xsminusxa.setTextColor(Color.BLACK);
            xsminusxa.setPadding(10, 10, 10, 10);
            tr_head.addView(xsminusxa);*/

            fxs = new TextView(this);
            fxs.setId(i + 50000001);
            fxs.setText(formatter.format(metodo.getFxs_sec().get(i)));
            fxs.setTextColor(Color.BLACK);
            fxs.setPadding(10, 10, 10, 10);
            tr_head.addView(fxs);

            fxa = new TextView(this);
            fxa.setId(i + 60000001);
            fxa.setText(formatter.format(metodo.getFxa_sec().get(i)));
            fxa.setTextColor(Color.BLACK);
            fxa.setPadding(10, 10, 10, 10);
            tr_head.addView(fxa);

            error = new TextView(this);
            error.setId(i + 70000001);
            error.setText(formatter.format(metodo.getError_sec().get(i)));
            error.setTextColor(Color.BLACK);
            error.setPadding(10, 10, 10, 10);
            tr_head.addView(error);

            tl.addView(tr_head, new TableLayout.LayoutParams(
                    TableLayout.LayoutParams.FILL_PARENT,
                    TableLayout.LayoutParams.MATCH_PARENT));
        }

        metodo.getVi_sec().clear();
        metodo.getVi_sec().clear();
        metodo.getFxs_sec().clear();
        metodo.getFxa_sec().clear();
        metodo.getError_sec().clear();

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_tabla_secante, menu);
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
}
