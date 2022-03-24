package com.learning.adrianrdz.lienzo2;

import android.content.*;
import android.graphics.*;
import android.view.View;
public class Lienzo extends View{
    Paint   p;
    Path    r;
    int     x, y, x0, y0;
    public Lienzo(Context c){
        super(c);
    }

    protected void onDraw(Canvas c){
        super.onDraw(c);
        p = new Paint();
        r = new Path();
        x = c.getWidth();
        y = c.getHeight();
        x0 = x/2;
        y0=y/2;// También: getMeasuredHeight(), o getBottom(), y=762
        p.setColor(Color.WHITE); // Fondo blanco
        c.drawPaint(p);
        p.setColor(Color.BLACK); // Texto negro p.
        p.setTextSize(20);
        c.drawText("0,0", x0 + 5, y0 + 20, p);
        p.setColor(Color.rgb(0, 0, 255));// Ejes azules c.drawLine(x0, 0, x0, y, p);
        c.drawLine(0, y0, x, y0, p);
        c.drawLine(x/2,0,x/2,y,p);
        p.setColor(Color.BLUE);
        p.setTextSize(40);
        c.drawText("senA", 20, 50, p); p.setColor(Color.RED);
        c.drawText("cosA", 20, 100, p); p.setStyle(Paint.Style.STROKE);
        p.setStrokeWidth(2);
        p.setAntiAlias(true);

        /*
        r = new Path();
        x = getMeasuredWidth();
        r.moveTo(0, 0); p.setColor(Color.BLUE);
        for(int i=1; i<x; i++) r.lineTo(i, (float) Math.sin(i / 50f) * (-180f));
        r.offset(-10, y0);
        c.drawPath(r, p);
        r = new Path();
        r.moveTo(0, 0); p.setColor(Color.RED);
        for(int i=1; i<x; i++) r.lineTo(i, (float) Math.cos(i / 50f) * (-300f));
        r.offset(-10, y0);
        c.drawPath(r, p);
         */

        r = new Path();
        x = getMeasuredWidth();
        r.moveTo(0, 0); p.setColor(Color.BLUE);
        for(int i=1; i<x; i++) r.lineTo(i, (float) Math.sin(i / 20f) * (-100f));
        r.offset(-10, y0);
        c.drawPath(r, p);
        r = new Path();
        r.moveTo(0, 0); p.setColor(Color.RED);
        for(int i=1; i<x; i++) r.lineTo(i, (float) Math.cos(i / 20f) * (-100f));
        r.offset(-10, y0);
        c.drawPath(r, p);
    }
}