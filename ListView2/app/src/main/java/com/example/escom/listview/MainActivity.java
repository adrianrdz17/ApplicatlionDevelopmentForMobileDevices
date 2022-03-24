package com.example.escom.listview;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.*;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private TextView jtv1;
    private ListView jlv1;

    private String nombres [] = {"Samuel", "Valentina", "Valeria"};
    private String edades [] = {"18", "25", "22"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        jtv1 = (TextView) findViewById(R.id.xtv1);
        jlv1 = (ListView) findViewById(R.id.xlv1);

        ArrayAdapter<String> adapter = new ArrayAdapter<String>(MainActivity.this, R.layout.list_item, nombres );
        ArrayAdapter<String> adapter1 = new ArrayAdapter<String>(MainActivity.this, R.layout.list_item, edades);
        jlv1.setAdapter(adapter, adapter1);

        jlv1.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                jtv1.setText("La edad de " + jlv1.getItemAtPosition(i) + " es: " + edades[i] + "anios." );
            }
        });
    }
}