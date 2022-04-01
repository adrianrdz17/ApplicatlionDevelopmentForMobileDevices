package com.learning.adrianrdz.practicapin;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.icu.util.ULocale;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import io.paperdb.Paper;

public class UnlockView extends AppCompatActivity {

    String save_pin_key = "password";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_unlock_view);

        Button btn_login, btn_reset;
        EditText et_password;

        btn_login = (Button) findViewById(R.id.btn_check_password);
        btn_reset = (Button) findViewById(R.id.xbtn_reset);

        et_password = (EditText) findViewById(R.id.xet_password);

        btn_login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                String password = et_password.getText().toString();

                if ( Paper.book().read("password").equals(password) ){

                    Toast.makeText(UnlockView.this,"Ingresando a la aplicacion", Toast.LENGTH_SHORT).show();

                    Intent intent = new Intent(UnlockView.this, Unlocked.class);
                    startActivity(intent);
                }   else    Toast.makeText(UnlockView.this, "Password incorrecta. Intente de nuevo", Toast.LENGTH_SHORT).show();
            }
        });

        btn_reset.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Paper.book().delete(save_pin_key);

                Toast.makeText(UnlockView.this, "Configure su nueva contraseña", Toast.LENGTH_SHORT).show();

                Intent intent = new Intent(UnlockView.this, MainActivity.class);
                startActivity(intent);
            }
        });
    }
}