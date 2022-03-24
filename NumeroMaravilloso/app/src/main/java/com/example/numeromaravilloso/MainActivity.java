package com.example.numeromaravilloso;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private EditText et1;
    private EditText et2;
    private TextView tv1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        et1 = (EditText)findViewById(R.id.txt_num1);
        et2 = (EditText)findViewById(R.id.txt_num2);

        tv1 = (TextView) findViewById(R.id.txt_resultado);
    }

    public void Sumar(View view){
        String handler = et1.getText().toString();
        int n1 = Integer.parseInt(handler);

        handler = et2.getText().toString();
        int n2 = Integer.parseInt(handler);

        int suma = n1 + n2;

        tv1.setText("Resultado " + suma  );
    }
}