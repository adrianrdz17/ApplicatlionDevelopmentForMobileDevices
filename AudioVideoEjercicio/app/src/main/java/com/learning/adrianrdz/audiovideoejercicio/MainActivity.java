package com.learning.adrianrdz.audiovideoejercicio;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.media.MediaPlayer;
import android.net.Uri;
import android.os.*;
import android.app.*;
import android.provider.MediaStore;
import android.view.View;
import android.widget.*;

public class MainActivity extends Activity{

    SharedPreferences sp;
    Button btn, seleccion, seleccionarAudio, escucharAudio;
    Intent intent;
    float x, y;
    MediaPlayer mp;
    Uri path;

    public void onCreate(Bundle b){
        super.onCreate(b);
        setContentView(R.layout.activity_main);

        btn = (Button)findViewById(R.id.btn);
        seleccion = (Button)findViewById(R.id.selecion);

        seleccionarAudio = (Button) findViewById(R.id.seleccionAudio);
        escucharAudio = (Button) findViewById(R.id.btnEscucharAudio);

        sp = getSharedPreferences("preferencias", Context.MODE_PRIVATE);

        seleccion.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                cargarVideo();
            }
        });

        seleccionarAudio.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                cargarAudio();
            }
        });

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                SharedPreferences.Editor miEditor = sp.edit();
                miEditor.putString("path", path.toString());
                miEditor.commit();
                Toast.makeText(view.getContext(), "Reproduciendo video", Toast.LENGTH_LONG).show();
                intent = new Intent(MainActivity.this, MainActivity2.class);
                startActivity(intent);
            }
        });

        escucharAudio.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                SharedPreferences.Editor miEditor = sp.edit();
                miEditor.putString("path", path.toString());
                miEditor.commit();

                String x;

                sp = getSharedPreferences("preferencias", Context.MODE_PRIVATE);
                x = sp.getString("path", "");
                path = Uri.parse(x);

                reproducirAudio(path);



            }
        });



    }

    private void cargarVideo() {
        Intent intent = new Intent(Intent.ACTION_PICK, MediaStore.Video.Media.EXTERNAL_CONTENT_URI);
        intent.setType("video/");
        startActivityForResult(intent.createChooser(intent, "Seleccion la aplicacion"), 10);
    }

    private void cargarAudio() {
        Intent intent = new Intent(Intent.ACTION_GET_CONTENT, MediaStore.Video.Media.EXTERNAL_CONTENT_URI);
        intent.setType("audio/*");
        startActivityForResult(intent.createChooser(intent, "Seleccion la aplicacion"), 10);

//        Intent intent = new Intent(Intent.ACTION_GET_CONTENT);
//        intent.setType("audio/*"); // specify "audio/mp3" to filter only mp3 files
//        startActivityForResult(intent,1);
    }

    private void reproducirAudio(Uri path) {
        if(mp != null) mp.release();
        mp = MediaPlayer.create(this, path);
        mp.start();
        Toast.makeText(this, "Reproduciendo cancion", Toast.LENGTH_SHORT).show();
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if(resultCode == RESULT_OK){
            path = data.getData();
            Toast.makeText(this, "Se ha seleccionado el elemento correctamente", Toast.LENGTH_LONG).show();
        }
    }
}