package com.example.intents;

import android.app.Activity;
import android.os.Bundle;
import android.widget.EditText;

public class SegundaActivity extends Activity {

    EditText jet;
    Bundle bdl;

    @Override
    protected void onCreate(Bundle b) {
        super.onCreate(b);
        setContentView(R.layout.activity_segunda);

        jet = (EditText) findViewById(R.id.xet1);
        bdl = getIntent().getExtras();
        jet.append("Hola "+ bdl.get("NOMBRE"));
    }
}