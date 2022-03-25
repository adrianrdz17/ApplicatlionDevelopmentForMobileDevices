package com.learning.adrianrdz.detcalculator;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    Button btn2, btn3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btn2 = findViewById(R.id.xbtn2);
        btn3 = findViewById(R.id.xbtn3);

        btn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                // Aqui invoco el fragnent 2x2
                FragmentDosPorDos fragmentDosPorDos = new FragmentDosPorDos();
                FragmentTransaction fragmentTransaction= getSupportFragmentManager().beginTransaction();

                fragmentTransaction.replace(R.id.fragmentContainerView3, fragmentDosPorDos);
                fragmentTransaction.commit();

            }
        });

        btn3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // Aqui invoco el fragnent 3x3
                FragmentTresPorTres fragmentTresPorTres = new FragmentTresPorTres();
                FragmentTransaction fragmentTransaction= getSupportFragmentManager().beginTransaction();

                fragmentTransaction.replace(R.id.fragmentContainerView3, fragmentTresPorTres);
                fragmentTransaction.commit();
            }
        });

    }




}