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

public class TablasBIActivity extends ActionBarActivity {

    private String funcion;
    private metodos metodo;
    private TableLayout tl;
    private TableRow tr_head;
    private TextView x;
    private TextView fx;
    private NumberFormat formatter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tablas_bi);

        Intent intent = getIntent();
        funcion = intent.getStringExtra("funcion");
        metodo = (metodos) intent.getSerializableExtra("metodo");

        tl = (TableLayout) findViewById(R.id.Table_bi);
        tl.setVerticalScrollBarEnabled(true);

        formatter = new DecimalFormat();
        formatter = new DecimalFormat("#.##E0");

        tr_head = new TableRow(this);
        tr_head.setId(100000);
        tr_head.setBackgroundColor(Color.WHITE);
        tr_head.setLayoutParams(new TableRow.LayoutParams(TableRow.LayoutParams.MATCH_PARENT,
                TableRow.LayoutParams.WRAP_CONTENT));

        x = new TextView(this);
        x.setId(20000000);
        x.setText("x");
        x.setTextColor(Color.BLACK);
        x.setPadding(10, 10, 10, 10);
        tr_head.addView(x);

        fx = new TextView(this);
        fx.setId(30000000);
        fx.setText("F (x)");
        fx.setTextColor(Color.BLACK);
        fx.setPadding(10, 10, 10, 10);
        tr_head.addView(fx);

        tl.addView(tr_head, new TableLayout.LayoutParams(
                TableLayout.LayoutParams.FILL_PARENT,
                TableLayout.LayoutParams.MATCH_PARENT));

        for (int i = 0; i < metodo.getIter_bi().size(); i++) {

            tr_head = new TableRow(this);
            tr_head.setId(i + 10000001);
            tr_head.setBackgroundColor(Color.WHITE);
            tr_head.setLayoutParams(new TableRow.LayoutParams(TableRow.LayoutParams.MATCH_PARENT,
                    TableRow.LayoutParams.WRAP_CONTENT));

            x = new TextView(this);
            x.setId(i + 20000001);
            x.setText(String.valueOf(metodo.getX_bi().get(i)));
            x.setTextColor(Color.BLACK);
            x.setPadding(10, 10, 10, 10);
            tr_head.addView(x);

            fx = new TextView(this);
            fx.setId(i + 30000001);
            fx.setText(formatter.format(metodo.getResult_bi().get(i)));
            fx.setTextColor(Color.BLACK);
            fx.setPadding(10, 10, 10, 10);
            tr_head.addView(fx);

            tl.addView(tr_head, new TableLayout.LayoutParams(
                    TableLayout.LayoutParams.FILL_PARENT,
                    TableLayout.LayoutParams.MATCH_PARENT));
        }

        metodo.getX_bi().clear();
        metodo.getResult_bi().clear();
        metodo.getIter_bi().clear();

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_tablas_bi, menu);
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
