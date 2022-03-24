package com.example.tarea9;
import com.example.tarea9.*;
import android.app.Activity;
import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import  android.view.View.OnClickListener;
import android.widget.*;

public class MainActivity extends Activity {
    String id, nombre;
    EditText jetI, jetN;
    Button jbnA, jbnD, jbnU, jbnS, jbnL;
    TextView jtvL; SQLiteDatabase sqld;
    @Override
    protected void onCreate(Bundle b) {
        super.onCreate(b);
        setContentView(R.layout.activity_main);
        jetI = (EditText) findViewById(R.id.xetI);
        jetN = (EditText) findViewById(R.id.xetN);
        jbnA = (Button) findViewById(R.id.xbnA);
        jbnD = (Button) findViewById(R.id.xbnD);
        jbnU = (Button) findViewById(R.id.xbnU);
        jbnS = (Button) findViewById(R.id.xbnS);
        jbnL = (Button) findViewById(R.id.xbnL);
        jtvL = (TextView) findViewById(R.id.xtvL);
        jbnA.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Agregar(view);
            }
        });
        jbnS.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View view) {
                Buscar(view);
            }
        });
        jbnD.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View view) {
                Eliminar(view);
            }
        });
        jbnL.setOnClickListener(new OnClickListener() {
            public void onClick(View v) {
                Lista(v);
            }
        });
        jbnU.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View view) {
                Modificar(view);
            }
        });
    }
    public void Modificar(View view) {
        DbmsSQLiteHelper dsqlh = new DbmsSQLiteHelper(this, "DBContactos", null, 1);
        sqld = dsqlh.getWritableDatabase();
        String Mid = jetI.getText().toString();
        String Mnombre = jetN.getText().toString();
        if(!Mid.isEmpty() && !Mnombre.isEmpty()) {
            ContentValues modification = new ContentValues();
            modification.put("id", Mid);
            modification.put("nombre", Mnombre);
            int cantidad = sqld.update("Contactos", modification, "id="+Mid, null);
            sqld.close();
            if(cantidad == 1){
                Toast.makeText(this, "Se modifico con exito", Toast.LENGTH_SHORT).show();
            }else {
                Toast.makeText(this, "No existe", Toast.LENGTH_SHORT).show();
            }
        } else {
            Toast.makeText(this, "Campos vacios", Toast.LENGTH_LONG).show();
        }

    }

    public void Lista(View view) {
        DbmsSQLiteHelper dsqlh = new DbmsSQLiteHelper(this, "DBContactos", null, 1);
        sqld = dsqlh.getWritableDatabase();
        String id, nombre;
        Cursor c = sqld.rawQuery("SELECT id,nombre FROM Contactos", null);
        jtvL.setText("");
        if (c.moveToFirst()) {
            do {
                id = c.getString(0);
                nombre = c.getString(1);
                jtvL.append(" " + id + "\t" + nombre + "\n");
            } while (c.moveToNext());
        }
    }

    public void Agregar(View view) {
        DbmsSQLiteHelper dsqlh = new DbmsSQLiteHelper(this, "DBContactos", null, 1);
        sqld = dsqlh.getWritableDatabase();
        String id = jetI.getText().toString();
        String nombre = jetN.getText().toString();
        ContentValues cv = new ContentValues();
        cv.put("id", id);
        cv.put("nombre", nombre);
        sqld.insert("Contactos", null, cv);
        sqld.close();
        jetI.setText("");
        jetN.setText("");
    }
    public void Buscar(View view) {
        DbmsSQLiteHelper dsqlh = new DbmsSQLiteHelper(this, "DBContactos", null, 1);
        SQLiteDatabase sqld = dsqlh.getWritableDatabase();
        String bId = jetI.getText().toString();
        if(!bId.isEmpty()){
            Cursor file = sqld.rawQuery("SELECT nombre FROM Contactos WHERE id="+bId, null);
            if(file.moveToFirst()){
                jetN.setText(file.getString(0));
                sqld.close();
            }else{
                Toast.makeText(this, "No existe el file", Toast.LENGTH_LONG).show();
                sqld.close();
            }
        }else {
            Toast.makeText(this, "No se encontre el id", Toast.LENGTH_LONG).show();
        }

    }
    public void Eliminar(View view) {
        DbmsSQLiteHelper dsqlh = new DbmsSQLiteHelper(this, "DBContactos", null, 1);
        SQLiteDatabase sqld = dsqlh.getWritableDatabase();
        String Rid = jetI.getText().toString();
        if(!Rid.isEmpty()){
            int cantidad = sqld.delete("Contactos", "id="+Rid, null);
            sqld.close();
            jetI.setText("");
            jetN.setText("");

            if(cantidad == 1){
                Toast.makeText(this, "Se elimino correctamente", Toast.LENGTH_LONG).show();
            } else {
                Toast.makeText(this, "no se encontro", Toast.LENGTH_LONG).show();
            }
        }else {
            Toast.makeText(this, "No se encontro el id para eliminar", Toast.LENGTH_LONG).show();
        }
    }
}