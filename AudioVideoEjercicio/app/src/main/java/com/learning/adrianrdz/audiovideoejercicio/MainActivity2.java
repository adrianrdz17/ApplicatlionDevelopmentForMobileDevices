package com.learning.adrianrdz.audiovideoejercicio;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import android.content.Context;
import android.content.SharedPreferences;
import android.net.Uri;
import android.os.Bundle;
import android.app.Activity;
import android.widget.*;

public class MainActivity2 extends Activity{

    ImageView img;
    SharedPreferences sp;
    Uri path;
    String x;

    MediaController mcr;
    VideoView vvw;

    public void onCreate(Bundle b){
        super.onCreate(b);
        setContentView(R.layout.activity_main2);
        sp = getSharedPreferences("preferencias", Context.MODE_PRIVATE);
        x = sp.getString("path", "");
        path = Uri.parse(x);

        mcr = new MediaController(this);
        vvw = (VideoView) findViewById(R.id.xvv1);
        vvw.setMediaController(mcr);
        vvw.setVideoURI(path);
        vvw.start();

    }
}