package com.learning.adrianrdz.ejercicio1sp;

import android.app.Activity;
import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.widget.TextView;
import android.widget.Toast;

import org.w3c.dom.Text;

public class SecondActivity extends Activity {

    TextView jtv1, jtv2;
    float lat, lon;

    @Override
    protected void onCreate(Bundle b) {
        super.onCreate(b);
        setContentView(R.layout.activity_second);

        SharedPreferences preferencias = getSharedPreferences("preferencias", Context.MODE_PRIVATE);

        jtv1 = (TextView) findViewById(R.id.xtv_x);
        jtv2 = (TextView) findViewById(R.id.xtv_y);

        lat = preferencias.getFloat("lat",0);
        lon = preferencias.getFloat("lon",0);

        jtv1.setText("Latitud: "+ lat);
        jtv2.setText("Longitud: "+ lon);

        Toast.makeText(SecondActivity.this, "Preferencias cargadas", Toast.LENGTH_LONG).show();
    }
}