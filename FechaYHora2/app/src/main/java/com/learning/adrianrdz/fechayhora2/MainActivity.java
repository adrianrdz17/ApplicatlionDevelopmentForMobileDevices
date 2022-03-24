package com.learning.adrianrdz.fechayhora2;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.app.Activity;
import android.app.DatePickerDialog;
import android.app.TimePickerDialog;
import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.view.View;
import android.widget.*;

import android.os.Bundle;

import com.learning.adrianrdz.fechayhora2.entidades.Births;

import java.util.ArrayList;
import java.util.Calendar;

public class MainActivity extends Activity implements View.OnClickListener {

    EditText jetName, jetDate, jetHour;
    TextView jtvL;
    Button jbtnDate, jbtnHour, jbtnSave, jbtnShow;

    int y, m, d, h, s;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        jbtnDate = findViewById(R.id.xbtn_date); jbtnDate.setOnClickListener(this);
        jbtnHour = findViewById(R.id.xbtn_hour); jbtnHour.setOnClickListener(this);
        jbtnSave = findViewById(R.id.xbtn_save); jbtnSave.setOnClickListener(this);
        jbtnShow = findViewById(R.id.xbtn_show); jbtnShow.setOnClickListener(this);

        jetName = (EditText) findViewById(R.id.xet_name);
        jetDate = (EditText) findViewById(R.id.xet_date);
        jetHour = (EditText) findViewById(R.id.xet_hour);

        jtvL = (TextView) findViewById(R.id.xtv_list);


    }

    @Override
    public void onClick(View v){
        if (v == jbtnDate){
            Calendar c = Calendar.getInstance();
            y = c.get(Calendar.YEAR);
            m = c.get(Calendar.MONTH);
            d = c.get(Calendar.DAY_OF_MONTH);

            DatePickerDialog dpd = new DatePickerDialog(this, new DatePickerDialog.OnDateSetListener() {
                @Override
                public void onDateSet(DatePicker dp, int ye, int mo, int di) {
                    jetDate.setText(di + "-" + (mo + 1) + "-" + ye);
                }
            }, y, m, d);

            dpd.show();
        }

        if (v == jbtnHour){
            Calendar c = Calendar.getInstance();
            h = c.get(Calendar.HOUR_OF_DAY);
            m = c.get(Calendar.MINUTE);

            TimePickerDialog tpd = new TimePickerDialog(this, new TimePickerDialog.OnTimeSetListener() {
                @Override
                public void onTimeSet(TimePicker tp, int hours, int minutes) {
                    jetHour.setText(hours + ":" + minutes);

                }
            }, h, m, false);

            tpd.show();
        }

        if (v == jbtnSave){
            AdminSQLiteOpenHelper admin = new AdminSQLiteOpenHelper(this, "administracion", null, 1);
            SQLiteDatabase sqLiteDatabase = admin.getWritableDatabase();   //Abrimos nuestra base de datos en modo lectura y escritura

            String name = jetName.getText().toString();
            String date = jetDate.getText().toString();
            String hour = jetHour.getText().toString();

            if (!name.isEmpty()  && !date.isEmpty() && !hour.isEmpty()){
                ContentValues registro = new ContentValues();
                registro.put("name", name);
                registro.put("date", date);
                registro.put("hour", hour);

                sqLiteDatabase.insert("nacimientos", null, registro);

                sqLiteDatabase.close();
                jetName.setText("");
                jetDate.setText("");
                jetHour.setText("");

                Toast.makeText(this, "Se ha guardado en la base de datos", Toast.LENGTH_LONG).show();


            }else{
                Toast.makeText(this, "Debes llenar todos los campos", Toast.LENGTH_LONG).show();

            }


        }

        if(v == jbtnShow){
            AdminSQLiteOpenHelper admin = new AdminSQLiteOpenHelper(this, "administracion", null, 1);
            SQLiteDatabase sqLiteDatabase = admin.getWritableDatabase();   //Abrimos nuestra base de datos en modo lectura y escritura

            String name, date, hour;

            Cursor c = sqLiteDatabase.rawQuery("SELECT name, date, hour FROM nacimientos", null); jtvL.setText("");
            if (c.moveToFirst()) {
                do {
                    name = c.getString(0);
                    date = c.getString(1);
                    hour = c.getString(2);

                    jtvL.append(" " + name + "\t\t" + date + "\t\t" + hour + "\n");
                } while(c.moveToNext());

                Toast.makeText(this, "Mostrando datos de la base", Toast.LENGTH_LONG).show();
            }

        }



    }
}