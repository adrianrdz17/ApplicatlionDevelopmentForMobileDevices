package com.learning.adrianrdz.lienzo;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.os.Bundle;

public class MainActivity extends Activity {

    @Override
    protected void onCreate(Bundle b) {
        super.onCreate(b);
        Lienzo l = new Lienzo (this);
        setContentView(l);

    }
}