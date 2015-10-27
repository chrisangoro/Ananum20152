package com.eafit.dis.cgonza47.ananum20152.Interpolacion;

import android.app.AlertDialog;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.StringTokenizer;

import com.eafit.dis.cgonza47.ananum20152.R;
import com.eafit.dis.cgonza47.ananum20152.utilidades.Interpolacion.Datos_inter;

public class DatosInterpolacionActivity extends ActionBarActivity implements View.OnClickListener {


    private Button entrarInter_bt;
    private Button ayuda_bt_Inter;
    private TextView xn_et_inter;
    private TextView yn_et_inter;
    private TextView x_inter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_datos_interpolacion);

        entrarInter_bt = (Button) findViewById(R.id.entrartInter_bt);
        ayuda_bt_Inter = (Button) findViewById(R.id.ayuda_interpolacion);

        xn_et_inter = (EditText) findViewById(R.id.xn_et_inter);
        yn_et_inter = (EditText) findViewById(R.id.yn_et_inter);
        x_inter = (EditText) findViewById(R.id.x_inter);

        entrarInter_bt.setOnClickListener(this);
        ayuda_bt_Inter.setOnClickListener(this);

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_datos_interpolacion, menu);
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

        ArrayList<Double> x = new ArrayList<Double>();
        ArrayList<Double> y = new ArrayList<Double>();
        double remp_x;

        if (v.getId() == R.id.entrartInter_bt) {

            StringTokenizer tokens_x = new StringTokenizer(xn_et_inter.getText().toString());
            StringTokenizer tokens_y = new StringTokenizer(yn_et_inter.getText().toString());

            if (tokens_x.countTokens() == tokens_y.countTokens()) {

                while (tokens_x.hasMoreTokens()) {

                    x.add(Double.parseDouble(tokens_x.nextToken()));
                    y.add(Double.parseDouble(tokens_y.nextToken()));

                }

                if (x_inter.getText().length() > 0) {

                    remp_x = Double.parseDouble(x_inter.getText().toString());
                    Double x_a[] = x.toArray(new Double[x.size()]);
                    Double y_a[] = y.toArray(new Double[y.size()]);

                    Datos_inter di = new Datos_inter(x_a, y_a, remp_x);

                    Intent i = new Intent(this, SelecInterActivity.class);
                    i.putExtra("Datos_inter", di);
                    startActivity(i);

                }

            } else {

                System.out.println("Faltan datos ----------");

            }

        } else if (v.getId() == R.id.ayuda_interpolacion) {

            String mensaje = "Para ingresar los valores de Xn o Yn se pone el valor, si se quieren " +
                    "varios valores estos se separan con un espacio simple (el ultimo valor sin espacio)\n" +
                    "Xn: valor de los X " +
                    "\nYn: Valor de X evaluado en F(x)" +
                    "\nF(x): valor al cual se quiere interpolar";

            showAlert(v, mensaje);

        }
    }

    public void showAlert(View view, String Mensaje) {

        AlertDialog.Builder myAlert = new AlertDialog.Builder(this);
        myAlert.setMessage(Mensaje);
        myAlert.show();

    }
}
