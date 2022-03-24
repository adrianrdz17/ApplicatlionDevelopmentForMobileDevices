package com.learning.adrianrdz.sharedpreferences;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.*;
import android.app.*;
import android.widget.*;

public class MainActivity extends Activity {

    //Defino los componentes que mandare a llamar
    SharedPreferences sp;
    EditText jetn, jetx, jety;

    //Defino variables con tipos de dato primitivos
    String s;
    float x, y;

    @Override
    public void onCreate(Bundle b) {
        super.onCreate(b);
        setContentView(R.layout.activity_main);

        // Obtengo los datos y casteo desde los EditText.
        jetn = (EditText) findViewById(R.id.xetn);
        jetx = (EditText) findViewById(R.id.xetx);
        jety = (EditText) findViewById(R.id.xety);

        //Accedo a las preferencias con el metodo getSharedPreferences. Sus argumentos son el nombre del archivo y el acceso
        sp = getSharedPreferences("sharedpreferences", Context.MODE_PRIVATE);
        s = sp.getString("titulo", "ESCOM");
        x = sp.getFloat("x", 0);
        y = sp.getFloat("y", 0);

        // Hago que las preferencias leidas desde el archivo se muestren desde un principio en la aplicacion (valores por defecto)
        jetn.setText(s);
        jetx.setText("" + x);
        jety.setText("" + y);

    }

    protected void onPause(){
        super.onPause();

        // Obtengo los datos de los respectivos campos y casteo al tipo de dato deseado.
        s = jetn.getText().toString();
        x = Float.parseFloat(jetx.getText().toString());
        y = Float.parseFloat(jety.getText().toString());

        // Creo una instancia del objeto editor, llamandolo como un metodo al objeto de tipo SharedPreferences creado anteriormente
        SharedPreferences.Editor miEditor = sp.edit();

        // Uso la instancia del editor y el metodo putString para asignar los valores obtenidos de los campos con pares clave-valor
        miEditor.putString("titulo", s);
        miEditor.putFloat("x", x);
        miEditor.putFloat("y", y);

        // Guardo los cambios en el archivo aplicando el metodo commit en mi instancia del editor
        miEditor.commit();

        // Mensaje de confirmacion
        Toast.makeText(MainActivity.this, "Preferencias guardaddas", Toast.LENGTH_LONG).show();

    }
}