package com.example.ejerciciodosintents;

import android.content.Context;
import android.widget.*;
import android.app.Activity;
import android.os.Bundle;

import org.w3c.dom.Text;

public class SegundaActivity extends Activity {

    TextView jet;
    Bundle bdl;

    String handler;
    double a, indiceB, c, x1, x2;

    @Override
    protected void onCreate(Bundle b) {
        super.onCreate(b);
        setContentView(R.layout.activity_segunda);
        jet = (TextView) findViewById(R.id.xet4);
        bdl = getIntent().getExtras();

        Context context = getApplicationContext();
        CharSequence text = "";
        int duration = Toast.LENGTH_LONG;


        handler = bdl.getString("A");
        a = Double.parseDouble( handler );

        handler = bdl.getString("B");
        indiceB = Double.parseDouble( handler );

        handler = bdl.getString("C");
        c = Double.parseDouble( handler );

        double numero = (indiceB*indiceB) - (4*a*c);
        if(numero > 0) {
            x1 = (-indiceB + Math.sqrt(numero)) / 2*a;
            x2 = (-indiceB - Math.sqrt(numero)) / 2*a;
        }else {
            if(numero == 0) {
                x1 = (-indiceB) / 2*a;
                text = "La ecuacion tiene una sola solucion";
                Toast toast = Toast.makeText(context, text, duration);
                toast.show();

            } else {
                text = "La ecuacion no tiene solucion";
                Toast toast = Toast.makeText(context, text, duration);
                toast.show();


            }
        }

        jet.append("Las raices para la entrada donde: \n a = " + bdl.getString("A") + "\n b = " + bdl.getString("B") + " \n c = " + bdl.getString("C") + "\n\n Son: \nx1 = " + x1 + "\t\n" + "x2 = " + x2);

    }
}