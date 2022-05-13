package com.learning.adrianrdz.canvas;

import android.content.Context;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Path;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;

import androidx.annotation.Nullable;

import java.util.List;

public class Lienzo extends View {

    float posx, posy;

    Path path;
    Paint paint;
    List<Path> paths;
    List<Paint> paints;

    public Lienzo(Context c){
        super(c);
    }

    @Override
    protected void onDraw(android.graphics.Canvas canvas) {
        super.onDraw(canvas);
//        Paint paint = new Paint();

        int x = canvas.getWidth();
        int y = canvas.getHeight();

//        Configuracion del fondo del canvas
        paint.setColor(Color.WHITE);
        canvas.drawPaint(paint);

//        paint.setStrokeWidth(10);

//        paint.setColor(Color.rgb(0,255,0));

//        canvas.drawLine(100, 100, 600, 800, paint);

//        paint.setColor(Color.rgb(255, 255, 0));
//        canvas.drawCircle(posx, posy, 300, paint);
        int i = 0;
        for(Path trazo:paths){
            canvas.drawPath(trazo, paints.get(i++));
        }
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        posx = event.getX();
        posy = event.getY();

        switch (event.getAction()){
            case MotionEvent.ACTION_DOWN:
                paint = new Paint();

                paint.setStrokeWidth(5);
                paint.setARGB(255, 255, 0, 0);
                paint.setStyle(Paint.Style.STROKE);
                paints.add(paint);

                path = new Path();
                path.moveTo(posx, posy);
                paths.add(path);



                break;
            case MotionEvent.ACTION_MOVE:
            case MotionEvent.ACTION_UP:
                int puntosHistoricos = event.getHistorySize();
                for (int i = 0; i < puntosHistoricos; i++){
                    path.lineTo(event.getHistoricalX(i), event.getHistoricalY(i));
                }
        }
        invalidate();

        return super.onTouchEvent(event);
    }
}
