package com.example.ejerciciodosintents;

import android.os.Bundle;
import android.app.Activity;
import android.view.View;
import android.view.View.*;
import android.content.Intent;
import android.widget.*;

public class MainActivity extends Activity {

    EditText jet1;
    EditText jet2;
    EditText jet3;
    Button jbtn;
    Bundle bdl;
    Intent itn;

    @Override
    protected void onCreate(Bundle b) {
        super.onCreate(b);
        setContentView(R.layout.activity_main);

        jet1 = (EditText) findViewById(R.id.xet1);
        jet2 = (EditText) findViewById(R.id.xet2);
        jet3 = (EditText) findViewById(R.id.xet3);

        jbtn = (Button) findViewById(R.id.xbtn);

        jbtn.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View view) {
                itn = new Intent(MainActivity.this, SegundaActivity.class);
                bdl = new Bundle();
                bdl.putString("A", jet1.getText().toString());
                bdl.putString("B", jet2.getText().toString());
                bdl.putString("C", jet3.getText().toString());
                itn.putExtras(bdl);
                startActivity(itn);
            }
        });
    }
}