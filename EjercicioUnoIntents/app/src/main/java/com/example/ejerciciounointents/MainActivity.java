package com.example.ejerciciounointents;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.*;

public class MainActivity extends Activity {

    EditText jet1;
    EditText jet2;
    Button jbtn1;
    Bundle bdl;
    Intent itn;

    @Override
    protected void onCreate(Bundle b) {
        super.onCreate(b);
        setContentView(R.layout.activity_main);
        jet1 = (EditText) findViewById(R.id.xet1);
        jet2 = (EditText) findViewById(R.id.xet2);
        jbtn1 = (Button) findViewById(R.id.xbtn1);

        jbtn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                itn = new Intent(MainActivity.this, SegundaActivity.class);
                bdl = new Bundle();
                bdl.putString("NOMBRE", jet1.getText().toString());
                bdl.putString("APELLIDO", jet2.getText().toString());
                itn.putExtras(bdl);
                startActivity(itn);
            }
        });

    }
}