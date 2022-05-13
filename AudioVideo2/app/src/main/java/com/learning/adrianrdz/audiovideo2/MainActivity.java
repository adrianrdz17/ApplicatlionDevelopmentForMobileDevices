package com.learning.adrianrdz.audiovideo2;

import android.app.*; import android.net.*; import android.os.*; import android.view.View;
import android.view.View.*; import android.widget.*;
public class MainActivity extends Activity implements OnClickListener {
    Button jbn;
    VideoView vvw;
    Uri uri;
    MediaController mcr;

    @Override
    public void onCreate(Bundle b) {
        super.onCreate(b);
        setContentView(R.layout.activity_main);

        jbn = (Button) findViewById(R.id.xbn);

        jbn.setOnClickListener(this);
    }

    public void onClick(View v) {
        vvw = (VideoView) findViewById(R.id.xvv1);
        uri = Uri.parse("android.resource://" + getPackageName()+ "/" + R.raw.this_is_love);
        Toast.makeText(this,  uri.toString() , Toast.LENGTH_SHORT).show();
        mcr = new MediaController(this);
        vvw.setMediaController(mcr);
        vvw.setVideoURI(uri);
        vvw.start();
    }
}