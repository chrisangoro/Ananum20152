package com.eafit.dis.cgonza47.ananum20152.Interpolacion;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;

import com.eafit.dis.cgonza47.ananum20152.R;
import com.eafit.dis.cgonza47.ananum20152.utilidades.Interpolacion.Datos_inter;

public class SelecInterActivity extends ActionBarActivity implements View.OnClickListener {

    private Button bt_newtoninter;
    private Button lagrange_bt;
    private Button spline1_bt;
    private Button spline3_bt;
    private Datos_inter di;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_selec_inter);

        bt_newtoninter = (Button) findViewById(R.id.bt_newtoninter);
        lagrange_bt = (Button) findViewById(R.id.lagrange_bt);
        spline1_bt = (Button) findViewById(R.id.splin1_bt);
        spline3_bt = (Button) findViewById(R.id.splin3_bt);

        bt_newtoninter.setOnClickListener(this);
        lagrange_bt.setOnClickListener(this);
        spline1_bt.setOnClickListener(this);
        spline3_bt.setOnClickListener(this);

        Intent intent = getIntent();

        if (intent.getSerializableExtra("Datos_inter") != null) {
            di = (Datos_inter) intent.getSerializableExtra("Datos_inter");
        }

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_selec_inter, menu);
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

        if (v.getId() == R.id.bt_newtoninter) {

            Intent i = new Intent(this, NewtonInterpolacionActivity.class);
            i.putExtra("Datos_inter", di);
            startActivity(i);

        } else if (v.getId() == R.id.lagrange_bt) {

            Intent i = new Intent(this, LagrangeInterpolacionActivity.class);
            i.putExtra("Datos_inter", di);
            startActivity(i);

        }else if (v.getId() == R.id.splin1_bt) {

            Intent i = new Intent(this, SplineLinealActivity.class);
            i.putExtra("Datos_inter", di);
            startActivity(i);


        }else if (v.getId() == R.id.splin3_bt) {

            Intent i = new Intent(this, SplineCubicoActivity.class);
            i.putExtra("Datos_inter", di);
            startActivity(i);

        }
    }
}
