package com.eafit.dis.cgonza47.ananum20152.Sistema_de_Ecuaciones;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;

import com.eafit.dis.cgonza47.ananum20152.R;
import com.eafit.dis.cgonza47.ananum20152.utilidades.Sistemas_de_Ecuaciones.Matriz;

public class SelecSisEcuActivity extends ActionBarActivity implements View.OnClickListener {

    private Button eliminacion_gaussiana_simple;
    private Button bt_egpt;
    private Button bt_egpp;
    private Button bt_egpe;
    private Button bt_dolittle;
    private Button bt_crout;
    private Button bt_cholesky;
    private Button bt_iterativos;

    Matriz matriz;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_selec_sis_ecu);

        eliminacion_gaussiana_simple = (Button) findViewById(R.id.bt_elimgaussimple);
        bt_dolittle = (Button) findViewById(R.id.bt_dolittle);
        bt_crout = (Button) findViewById(R.id.bt_crout);
        bt_cholesky = (Button) findViewById(R.id.bt_cholesky);
        bt_iterativos = (Button) findViewById(R.id.bt_iterativos);

        eliminacion_gaussiana_simple.setOnClickListener(this);
        bt_dolittle.setOnClickListener(this);
        bt_crout.setOnClickListener(this);
        bt_cholesky.setOnClickListener(this);
        bt_iterativos.setOnClickListener(this);

        Intent intent = getIntent();

        if (intent.getSerializableExtra("matriz") != null) {
            matriz = (Matriz) intent.getSerializableExtra("matriz");
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_selec_sis_ecu, menu);
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
        if (v.getId() == R.id.bt_elimgaussimple) {

            Intent i = new Intent(this, EliminacionGaussianaActivity.class);
            i.putExtra("matriz", matriz);
            startActivity(i);

        }if (v.getId() == R.id.bt_dolittle) {

            Intent i = new Intent(this, DolittleActivity.class);
            i.putExtra("matriz", matriz);
            startActivity(i);

        }if (v.getId() == R.id.bt_crout) {

            Intent i = new Intent(this, CroutActivity.class);
            i.putExtra("matriz", matriz);
            startActivity(i);

        }if (v.getId() == R.id.bt_cholesky) {

            Intent i = new Intent(this, CholeskyActivity.class);
            i.putExtra("matriz", matriz);
            startActivity(i);

        }if (v.getId() == R.id.bt_iterativos) {

            Intent i = new Intent(this, MetodosIterativosActivity.class);
            i.putExtra("matriz", matriz);
            startActivity(i);

        }
    }
}
