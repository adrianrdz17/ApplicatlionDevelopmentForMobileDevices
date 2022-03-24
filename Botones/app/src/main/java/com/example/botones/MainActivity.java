package com.example.botones;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.*;

public class MainActivity extends Activity {
    Button jbn1, jbn2, jbn3, jbn4;
    protected void onCreate(Bundle b) {
        super.onCreate(b);
        setContentView(R.layout.activity_main);

        jbn1 = (Button) findViewById(R.id.xbn1);
        jbn1.setOnClickListener(bn1Listener);
        jbn2 = (Button) findViewById(R.id.xbn2);
        jbn2.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                showToastMessage("Boton digitado: xbn2\nUtiliza OnClickListener{}");
            }
        });
        jbn3 = (Button) findViewById(R.id.xbn3);
        jbn3.setOnClickListener(this::onClick);
    }

    private OnClickListener bn1Listener = new OnClickListener() {
        public void onClick(View view) {
            showToastMessage("Botón digitado: xbn1\nUtiliza: clase btn1Listener");

        }


    };

    public void onClick(View v) {
        showToastMessage("Botón digitado: xbn3\nUtiliza: implements OnClickListener.");
    }
    public void xbn4DesdeXML(View v) {
        showToastMessage("Boton digitado: xbn4\nInvoca al método desde el XML.");
    }
    private void showToastMessage(String msg){
        Toast toast = Toast.makeText(this, msg, Toast.LENGTH_SHORT); toast.show();
    }
}