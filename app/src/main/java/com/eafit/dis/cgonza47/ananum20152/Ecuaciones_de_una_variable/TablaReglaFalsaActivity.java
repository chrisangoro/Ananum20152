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

public class TablaReglaFalsaActivity extends ActionBarActivity {

    private String funcion;
    private metodos metodo;
    private TextView tabla;
    private TableLayout tl;
    private TableRow tr_head;
    private TextView iter;
    private TextView a;
    private TextView b;
    private TextView xm;
    private TextView fa;
    private TextView fb;
    private TextView fm;
    private TextView error;
    private NumberFormat formatter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tabla_regla_falsa);

        Intent intent = getIntent();
        funcion = intent.getStringExtra("funcion");
        metodo = (metodos) intent.getSerializableExtra("metodo");

        tl = (TableLayout) findViewById(R.id.Table_rg);
        tl.setVerticalScrollBarEnabled(true);

        formatter = new DecimalFormat();
        formatter = new DecimalFormat("#.##E0");

        tr_head = new TableRow(this);
        tr_head.setId(0+100000);
        tr_head.setBackgroundColor(Color.WHITE);
        tr_head.setLayoutParams(new TableRow.LayoutParams(TableRow.LayoutParams.MATCH_PARENT,
                TableRow.LayoutParams.WRAP_CONTENT));

        iter = new TextView(this);
        iter.setId(0+20000000);
        iter.setText("Iter");
        iter.setTextColor(Color.BLACK);
        iter.setPadding(10, 10, 10, 10);
        tr_head.addView(iter);

        /*a = new TextView(this);
        a.setId(0+30000000);
        a.setText("a");
        a.setTextColor(Color.BLACK);
        a.setPadding(10, 10, 10, 10);
        tr_head.addView(a);

        b = new TextView(this);
        b.setId(0+40000000);
        b.setText("b");
        b.setTextColor(Color.BLACK);
        b.setPadding(10, 10, 10, 10);
        tr_head.addView(b);*/

        xm = new TextView(this);
        xm.setId(0+50000000);
        xm.setText("xm ( promedio entre a y b o punto c )");
        xm.setTextColor(Color.BLACK);
        xm.setPadding(10, 10, 10, 10);
        tr_head.addView(xm);

        /*fa = new TextView(this);
        fa.setId(0+60000000);
        fa.setText("f(a)");
        fa.setTextColor(Color.BLACK);
        fa.setPadding(10, 10, 10, 10);
        tr_head.addView(fa);

        fb = new TextView(this);
        fb.setId(0+70000000);
        fb.setText("f(b)");
        fb.setTextColor(Color.BLACK);
        fb.setPadding(10, 10, 10, 10);
        tr_head.addView(fb);*/

        fm = new TextView(this);
        fm.setId(0+80000000);
        fm.setText("f(xm)");
        fm.setTextColor(Color.BLACK);
        fm.setPadding(10, 10, 10, 10);
        tr_head.addView(fm);

        error = new TextView(this);
        error.setId(0+90000000);
        error.setText("error");
        error.setTextColor(Color.BLACK);
        error.setPadding(10, 10, 10, 10);
        tr_head.addView(error);


        tl.addView(tr_head, new TableLayout.LayoutParams(
                TableLayout.LayoutParams.FILL_PARENT,
                TableLayout.LayoutParams.MATCH_PARENT));


        for (int i = 0; i < metodo.getIter_rg().size(); i++) {

            tr_head = new TableRow(this);
            tr_head.setId(i + 10000001);
            tr_head.setBackgroundColor(Color.WHITE);
            tr_head.setLayoutParams(new TableRow.LayoutParams(TableRow.LayoutParams.MATCH_PARENT,
                    TableRow.LayoutParams.WRAP_CONTENT));

            iter = new TextView(this);
            iter.setId(i + 20000001);
            iter.setText(String.valueOf(metodo.getIter_rg().get(i)));
            iter.setTextColor(Color.BLACK);
            iter.setPadding(10, 10, 10, 10);
            tr_head.addView(iter);

            /*a = new TextView(this);
            a.setId(i + 30000001);
            a.setText(String.valueOf(metodo.getA_rg().get(i)));
            a.setTextColor(Color.BLACK);
            a.setPadding(10, 10, 10, 10);
            tr_head.addView(a);

            b = new TextView(this);
            b.setId(i + 40000001);
            b.setText(String.valueOf(metodo.getB_rg().get(i)));
            b.setTextColor(Color.BLACK);
            b.setPadding(10, 10, 10, 10);
            tr_head.addView(b);*/

            xm = new TextView(this);
            xm.setId(i + 50000001);
            xm.setText(String.valueOf(metodo.getXm_rg().get(i)));
            xm.setTextColor(Color.BLACK);
            xm.setPadding(10, 10, 10, 10);
            tr_head.addView(xm);

           /* fa = new TextView(this);
            fa.setId(i + 60000001);
            fa.setText(String.valueOf(metodo.getFa_rg().get(i)));
            fa.setTextColor(Color.BLACK);
            fa.setPadding(10, 10, 10, 10);
            tr_head.addView(fa);

            fb = new TextView(this);
            fb.setId(i + 70000001);
            fb.setText(String.valueOf(metodo.getFb_rg().get(i)));
            fb.setTextColor(Color.BLACK);
            fb.setPadding(10, 10, 10, 10);
            tr_head.addView(fb);*/

            fm = new TextView(this);
            fm.setId(i + 80000001);
            fm.setText(String.valueOf(formatter.format(metodo.getFm_rg().get(i))));
            fm.setTextColor(Color.BLACK);
            fm.setPadding(10, 10, 10, 10);
            tr_head.addView(fm);

            error = new TextView(this);
            error.setId(i + 90000001);
            error.setText(formatter.format(metodo.getError_rg().get(i)));
            error.setTextColor(Color.BLACK);
            error.setPadding(10, 10, 10, 10);
            tr_head.addView(error);

            tl.addView(tr_head, new TableLayout.LayoutParams(
                    TableLayout.LayoutParams.FILL_PARENT,
                    TableLayout.LayoutParams.MATCH_PARENT));
        }

        metodo.getIter_rg().clear();
        metodo.getXm_rg().clear();
        metodo.getFm_rg().clear();
        metodo.getError_rg().clear();

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_tabla_regla_falsa, menu);
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
