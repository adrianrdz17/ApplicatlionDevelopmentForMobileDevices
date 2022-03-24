package com.learning.adrianrdz.lienzo;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.RectF;
import android.graphics.Typeface;
import android.view.View;
import android.widget.Toast;

public class Lienzo extends View {
    Paint p;
    int x, y;
    String s = "CENTER";


    public Lienzo(Context c){
        super(c);
    }

    protected void onDraw(Canvas c){

        super.onDraw(c);
        p = new Paint();
        x = c.getWidth();
        y = c.getHeight();
        p.setColor(Color.WHITE);
        c.drawPaint(p);
        p.setColor(Color.BLACK);
        p.setTextSize(20);
        c.drawText("x0=" + x/2 + ", y0=" + y/2, x/2 + 20, y/2-20, p);
        p.setColor(Color.rgb(0, 0, 255)); // Ejes azules
        c.drawLine(x/2, 0, x/2, y, p);
        c.drawLine(0, y/2, x, y/2, p);

        p.setTextAlign(Paint.Align.RIGHT);
        p.setTypeface(Typeface.DEFAULT);
        c.drawText("Eje X", x-5, y/2-10, p);
        p.setTextAlign(Paint.Align.valueOf(s));
        p.setTypeface(Typeface.MONOSPACE);
        c.drawText("Eje Y", x/2+30, 20, p);

        // Dibujando el circulo
        p.setColor(Color.argb(100, 200, 100, 100));
        c.drawCircle(x/4, y/4, 100, p);

        p.setColor(Color.rgb(46, 41, 78));
        c.drawRect(440,806,640,1316,p);

        p.setColor(Color.rgb(215, 38, 61));
        c.drawOval(440,280,640,420,p);

        p.setColor(Color.rgb(27, 153, 139));
        c.drawArc(80,966,280,1166, 0F, -90F, true,p);


    }
}
