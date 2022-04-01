package com.learning.adrianrdz.practicapin;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import io.paperdb.Paper;

public class MainActivity extends AppCompatActivity {

    Button btnSave;
    EditText etSet, etVerify;
    String set, verify;

    String save_pin_key = "password";
//    String final_pin = ""

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        Paper.init(this);
        final String save_pin = Paper.book().read(save_pin_key);

        if ( save_pin != null && !save_pin.equals("null") ){
            super.onCreate(savedInstanceState);
            setContentView(R.layout.activity_unlock_view);

            Button btn_login, btnReset;
            EditText et_password;

            btn_login = (Button) findViewById(R.id.btn_check_password);
            btnReset = (Button) findViewById(R.id.xbtn_reset);
            et_password = (EditText) findViewById(R.id.xet_password);

            btn_login.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {

                    String password = et_password.getText().toString();

                    if ( Paper.book().read("password").equals(password) ){

                        Toast.makeText(MainActivity.this,"Ingresando a la aplicacion", Toast.LENGTH_SHORT).show();

                        Intent intent = new Intent(MainActivity.this, Unlocked.class);
                        startActivity(intent);
                    }   else    Toast.makeText(MainActivity.this, "Password incorrecta. Intente de nuevo", Toast.LENGTH_SHORT).show();
                }
            });

            btnReset.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Paper.book().delete(save_pin_key);

                    Toast.makeText(MainActivity.this, "Configure su nueva contraseña", Toast.LENGTH_SHORT).show();

                    Intent intent = new Intent(MainActivity.this, MainActivity.class);
                    startActivity(intent);
                }
            });

        } else {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.activity_main);


            btnSave = (Button) findViewById(R.id.btn_save);
            etSet = (EditText) findViewById(R.id.xet_set_password);
            etVerify = (EditText) findViewById(R.id.xet_verify_password);

            btnSave.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    handlePassword();

                }
            });


        }

    }

    protected void handlePassword(){

        set = etSet.getText().toString();
        verify = etVerify.getText().toString();

        if ( set.equals("") || verify.equals("") ) Toast.makeText(this,"Rellene ambos campos para configurar su nueva contraseña", Toast.LENGTH_SHORT).show();
        else if( !set.equals( verify ) ) Toast.makeText(this, "Las entradas no coinciden. Intentelo de nuevo", Toast.LENGTH_SHORT ).show();
        else setNewPassword( set );

    }

    protected void setNewPassword(String set){

        Toast.makeText( this, "Password guardada", Toast.LENGTH_SHORT).show();
        Paper.book().write(save_pin_key, set);

        Intent intent = new Intent(MainActivity.this, UnlockView.class );
        startActivity( intent );

    }

}