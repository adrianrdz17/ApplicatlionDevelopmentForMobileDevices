package com.learning.adrianrdz.ejercicio1sp;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends Activity {

    EditText jet1, jet2;
    Button jbtn;
    SharedPreferences sp;
    Intent intnt;

    float x, y;

    @Override
    protected void onCreate(Bundle b) {
        super.onCreate(b);
        setContentView(R.layout.activity_main);

        jet1 = (EditText) findViewById(R.id.xet1);
        jet2 = (EditText) findViewById(R.id.xet2);
        jbtn = (Button) findViewById(R.id.xbtn);

        sp = getSharedPreferences("preferencias", Context.MODE_PRIVATE);

        x = sp.getFloat("lat", 0 );
        y = sp.getFloat("lon", 0 );
        jet1.setText(""+x);
        jet2.setText(""+y);

        jbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                x = Float.parseFloat(jet1.getText().toString());
                y = Float.parseFloat(jet2.getText().toString());

                SharedPreferences.Editor miEditor = sp.edit();
                miEditor.putFloat("lat", x);
                miEditor.putFloat("lon", y);
                miEditor.commit();
                Toast.makeText(MainActivity.this, "Preferencias guardadas\nEnviando al intent...", Toast.LENGTH_SHORT).show();

                // Creacion  y envio del nuevo intent
                intnt = new Intent(MainActivity.this, SecondActivity.class);
                startActivity(intnt);
            }
        });

    }
}