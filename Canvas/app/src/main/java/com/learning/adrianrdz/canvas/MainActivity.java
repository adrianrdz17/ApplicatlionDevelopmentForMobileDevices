package com.learning.adrianrdz.canvas;

import android.app.Activity;
import android.hardware.Camera;
import android.os.Bundle;

public class MainActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        AreaDibujo c = AreaDibujo (this);
        setContentView(c);

    }

}