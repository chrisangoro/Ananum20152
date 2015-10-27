package com.eafit.dis.cgonza47.ananum20152.Ecuaciones_de_una_variable;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TableLayout;
import android.widget.TableRow;
import android.widget.TextView;

import java.text.DecimalFormat;
import java.text.NumberFormat;

import com.eafit.dis.cgonza47.ananum20152.R;
import com.eafit.dis.cgonza47.ananum20152.utilidades.metodos;

public class TablaRaicesMultiplesActivity extends ActionBarActivity {

    private String funcion;
    private metodos metodo;
    private TextView tabla;
    private TableLayout tl;
    private TableRow tr_head;
    private TextView iter;
    private TextView vi;
    private TextView fxp;
    private TextView fx;
    private TextView fxpp;
    private TextView error;
    private NumberFormat formatter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tabla_raices_multiples);

        Intent intent = getIntent();
        funcion = intent.getStringExtra("funcion");
        metodo = (metodos) intent.getSerializableExtra("metodo");

        tl = (TableLayout) findViewById(R.id.Table_rm);
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

        fxp = new TextView(this);
        fxp.setId(40000000);
        fxp.setText("F'(x)");
        fxp.setTextColor(Color.BLACK);
        fxp.setPadding(10, 10, 10, 10);
        tr_head.addView(fxp);

        fx = new TextView(this);
        fx.setId(50000000);
        fx.setText("F(x)");
        fx.setTextColor(Color.BLACK);
        fx.setPadding(10, 10, 10, 10);
        tr_head.addView(fx);

        fxpp = new TextView(this);
        fxpp.setId(60000000);
        fxpp.setText("F''(x)");
        fxpp.setTextColor(Color.BLACK);
        fxpp.setPadding(10, 10, 10, 10);
        tr_head.addView(fxpp);

        error = new TextView(this);
        error.setId(70000000);
        error.setText("error");
        error.setTextColor(Color.BLACK);
        error.setPadding(10, 10, 10, 10);
        tr_head.addView(error);

        tl.addView(tr_head, new TableLayout.LayoutParams(
                TableLayout.LayoutParams.FILL_PARENT,
                TableLayout.LayoutParams.MATCH_PARENT));

        for (int i = 0; i < metodo.getIter_rm().size(); i++) {

            tr_head = new TableRow(this);
            tr_head.setId(i + 10000001);
            tr_head.setBackgroundColor(Color.WHITE);
            tr_head.setLayoutParams(new TableRow.LayoutParams(TableRow.LayoutParams.MATCH_PARENT,
                    TableRow.LayoutParams.WRAP_CONTENT));

            iter = new TextView(this);
            iter.setId(i + 20000001);
            iter.setText(String.valueOf(metodo.getIter_rm().get(i)));
            iter.setTextColor(Color.BLACK);
            iter.setPadding(10, 10, 10, 10);
            tr_head.addView(iter);

            vi = new TextView(this);
            vi.setId(i + 30000001);
            vi.setText(String.valueOf(metodo.getVi_rm().get(i)));
            vi.setTextColor(Color.BLACK);
            vi.setPadding(10, 10, 10, 10);
            tr_head.addView(vi);

            fxp = new TextView(this);
            fxp.setId(i + 40000001);
            fxp.setText(formatter.format(metodo.getFpx_rm().get(i)));
            fxp.setTextColor(Color.BLACK);
            fxp.setPadding(10, 10, 10, 10);
            tr_head.addView(fxp);

            fx = new TextView(this);
            fx.setId(i + 50000001);
            fx.setText(formatter.format(metodo.getFx_rm().get(i)));
            fx.setTextColor(Color.BLACK);
            fx.setPadding(10, 10, 10, 10);
            tr_head.addView(fx);

            fxpp = new TextView(this);
            fxpp.setId(i + 60000001);
            fxpp.setText(formatter.format(metodo.getFpp_rm().get(i)));
            fxpp.setTextColor(Color.BLACK);
            fxpp.setPadding(10, 10, 10, 10);
            tr_head.addView(fxpp);

            error = new TextView(this);
            error.setId(i + 70000001);
            error.setText(formatter.format(metodo.getError_rm().get(i)));
            error.setTextColor(Color.BLACK);
            error.setPadding(10, 10, 10, 10);
            tr_head.addView(error);

            tl.addView(tr_head, new TableLayout.LayoutParams(
                    TableLayout.LayoutParams.FILL_PARENT,
                    TableLayout.LayoutParams.MATCH_PARENT));
        }

        metodo.getIter_rm().clear();
        metodo.getVi_rm().clear();
        metodo.getFpx_rm().clear();
        metodo.getFx_rm().clear();
        metodo.getFpp_rm().clear();
        metodo.getError_rm().clear();


    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_tabla_raices_multiples, menu);
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
