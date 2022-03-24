package com.example.ejercicio;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    EditText jet1;
    Button jbtn1;
    TextView jtv1;

    int n = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Aqui se realiza la obtencion del elemento desde xml mediante el id especificado. Notese que es necesario castear
        jet1 = (EditText)findViewById(R.id.xet1);
        jbtn1 = (Button) findViewById(R.id.xbtn1);

        jbtn1.setOnClickListener(this::Aceptar);

        jtv1 = (TextView) findViewById(R.id.xtv1);

    }

    public void Aceptar(View view){
        n = Integer.parseInt(jet1.getText()+"");
        int i = n;
        boolean isPrime = true;
        jtv1.setText("");
        jtv1.append("Resultados para el numero: "+n+"\n");
        // Dado un numero natural: verificar si es maravilloso, si es primo y si es fibonacci

        while ( i != 1 ){
            if( i%2 == 0){
                i = i/2;
            }else
                i = (i*3)+1;

            jtv1.append(i+"\n");
        }

        jtv1.append(n + " es un numero maravilloso\n\n");

        //Aqui evaluaremos si el numero es primo.
        if (n == 0 || n == 1 || n == 4 )
            isPrime = false;
            // jtv1.append(n + " no es un numero primo");
        for (int x = 2; x < n / 2; x++) {
            if (n % x == 0) isPrime = false;
        }
        jtv1.append("\n" +n + " es un numero primo: " + isPrime);

        int limite = n;
        int num1, num2, temp;
        boolean isFibo = false;
        num1 = 0;
        num2 = 1;

        while(num2 + num1 <= 10000){
            temp = num1;
            num1 = num2;
            num2 = temp + num1;
            if(limite == num2){
                isFibo = true;

            }
        }

        jtv1.append("\n\n" + n + " pertenece a la sucesion de fibonacci: "+ isFibo);
    }
}