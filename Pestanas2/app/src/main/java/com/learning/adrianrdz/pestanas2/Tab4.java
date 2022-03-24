package com.learning.adrianrdz.pestanas2;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Rect;
import android.os.*;
import android.view.*;
import android.widget.FrameLayout;

import androidx.fragment.app.Fragment;

public class Tab4 extends Fragment {
    @Override
    public void onCreate(Bundle b){
        super.onCreate(b);
    }
    @Override
    public View onCreateView(LayoutInflater li, ViewGroup vg, Bundle bn) {
        View rootView = li.inflate(R.layout.fragment_tab4, vg, false);

        FrameLayout relativeLayout = (FrameLayout) rootView.findViewById(R.id.logo);
        relativeLayout.addView(new Lienzo(getActivity()));

        return rootView;
    }

    private class Lienzo extends View {
        Paint p = new Paint();

        public Lienzo(Context context) {
            super(context);
        }
        @Override
        public void onDraw(Canvas c) {
            int x = c.getWidth();
            int y = c.getHeight();
//            p.setColor(Color.WHITE); // Fondo blanco
            c.drawPaint(p);

            float centroX = x/2 , centroY = y/2 , radio=centroX;

            for(int i = 0;i<15;i++){//El limite del for determina la 'profundidad' de la figura
                //Pintar cuadrados rojos
                p.setColor(Color.RED);
                c.drawRect(centroX-radio,centroY-radio,centroX+radio,centroY+radio,p);

                //Pintar circulos blancos
                p.setColor(Color.WHITE);
                c.drawCircle(centroX,centroY,radio,p);

                radio = (float) Math.sqrt((radio*radio)/2);
            }








        }
    }
}