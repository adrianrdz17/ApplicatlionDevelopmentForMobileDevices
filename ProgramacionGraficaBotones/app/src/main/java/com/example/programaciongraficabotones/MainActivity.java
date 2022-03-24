package com.example.programaciongraficabotones;

import androidx.appcompat.app.AppCompatActivity;

import android.view.View;
import android.view.View.*;
import android.widget.*;

import android.os.Bundle;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    Button jbtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        jbtn = (Button) findViewById(R.id.xbtn);
        jbtn.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View view) {
                showToastMessage("Boton con imagen presionado");
            }
        });


    }

    private void showToastMessage(String s){
        Toast t = Toast.makeText(this, s, Toast.LENGTH_SHORT); t.show();
        t.show();
    }
}