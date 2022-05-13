package com.learning.adrianrdz.audiovideo;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.app.Activity;
import android.media.MediaPlayer;
import android.view.View;
import android.widget.*;

public class MainActivity extends Activity {

    MediaPlayer mp;
    Button jbtn1, jbtn2, jbtn3, jbtn4, jbtn5;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        jbtn1 = (Button) findViewById(R.id.xbn1);
        jbtn2 = (Button) findViewById(R.id.xbn2);
        jbtn3 = (Button) findViewById(R.id.xbn3);
        jbtn4 = (Button) findViewById(R.id.xbn4);
        jbtn5 = (Button) findViewById(R.id.xbn5);

        jbtn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                reproducir(R.raw.adele_hello);
            }
        });

        jbtn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                reproducir(R.raw.you_got_it);
            }
        });

        jbtn3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                reproducir(R.raw.ahhh);
            }
        });

        jbtn4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                reproducir(R.raw.aplauso);
            }
        });

        jbtn5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                reproducir(R.raw.risas);
            }
        });


    }

    void reproducir(int cancion){
        if (mp != null )    mp.release();;
        mp = MediaPlayer.create(this, cancion);
        mp.seekTo(0);
        mp.start();
    }

    public void onPause() {
        super.onPause();
        if (mp!=null)
            mp.release();
    }
}