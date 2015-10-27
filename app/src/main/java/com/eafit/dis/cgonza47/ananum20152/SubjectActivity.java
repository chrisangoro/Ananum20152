package com.eafit.dis.cgonza47.ananum20152;

import android.content.Intent;
import android.graphics.Typeface;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.eafit.dis.cgonza47.ananum20152.Ecuaciones_de_una_variable.MethodActivity;
import com.eafit.dis.cgonza47.ananum20152.Interpolacion.DatosInterpolacionActivity;
import com.eafit.dis.cgonza47.ananum20152.Sistema_de_Ecuaciones.MethodSistemaDeEcuacionesActivity;


public class SubjectActivity extends ActionBarActivity implements View.OnClickListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_subject);

        Typeface tf = Typeface.createFromAsset(getAssets(), "fuentes/Mathematical Bold.ttf");

        TextView tv = (TextView) findViewById(R.id.view_temas);

        tv.setTypeface(tf);

        Button bt_1 = (Button) findViewById(R.id.bt_1);
        Button bt_2 = (Button) findViewById(R.id.bt_2);
        Button bt_3 = (Button) findViewById(R.id.bt_3);

        bt_1.setTypeface(tf);
        bt_2.setTypeface(tf);
        bt_3.setTypeface(tf);

        bt_1.setOnClickListener(this);
        bt_2.setOnClickListener(this);
        bt_3.setOnClickListener(this);


    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_subject, menu);
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

        if (v.getId() == R.id.bt_1) {

            startActivity(new Intent(getApplicationContext(), MethodActivity.class));

        } else if (v.getId() == R.id.bt_2) {

            startActivity(new Intent(getApplicationContext(), MethodSistemaDeEcuacionesActivity.class));

        } else if (v.getId() == R.id.bt_3) {

            startActivity(new Intent(getApplicationContext(), DatosInterpolacionActivity.class));
        }
    }
}
