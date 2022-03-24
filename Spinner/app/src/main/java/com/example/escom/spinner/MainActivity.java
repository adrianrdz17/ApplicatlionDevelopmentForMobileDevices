package com.example.escom.spinner;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private Spinner spinner1;
    private EditText jet1, jet2;
    private TextView jtv1;
    private Button jbtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        jet1 = (EditText) findViewById(R.id.xet1);
        jet2 = (EditText) findViewById(R.id.xet2);
        jtv1 = (TextView) findViewById(R.id.xtvResultado);
        spinner1 = (Spinner) findViewById(R.id.spinner);
        jbtn = (Button) findViewById(R.id.xbtn);

        String [] opciones = {"Suma", "Resta", "Multiplicacion", "Division"};

        ArrayAdapter <String> adapter = new ArrayAdapter<String>(MainActivity.this, android.R.layout.simple_spinner_dropdown_item, opciones);
        spinner1.setAdapter(adapter);

        // Creacion del evento para el boton
        jbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String handler = jet1.getText().toString();

                int valor1 = Integer.parseInt(handler);
                handler = jet2.getText().toString();
                int valor2 = Integer.parseInt(handler);

                String seleccion = spinner1.getSelectedItem().toString();

                if ( seleccion.equals("Suma") ){
                    int suma = valor1 + valor2;
                    String resultado = String.valueOf(suma);
                    jtv1.append(resultado);
                }else if ( seleccion.equals("Resta") ){
                    int resta = valor1 - valor2;
                    String resultado = String.valueOf(resta);
                    jtv1.append(resultado);
                }else if ( seleccion.equals("Multiplicacion")){
                    int multiplicacion = valor1 * valor2;
                    String resultado = String.valueOf(multiplicacion);
                    jtv1.append(resultado);

                }else if( seleccion.equals("Division") ){

                    if (valor2 != 0){
                        int division = valor1 / valor2;
                        String resultado = String.valueOf(division);
                        jtv1.append(resultado);
                    }else{
                        Toast toast = Toast.makeText(MainActivity.this, "Division entre cero", Toast.LENGTH_LONG);
                        toast.show();
                    }
                }
            }
        });

    }

}