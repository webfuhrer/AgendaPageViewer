package com.example.luis.agendapageviewer;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import java.util.ArrayList;
import java.util.List;


/**
 * Created by luis on 23/11/2017.
 */

public class AccesoBD {
    private static SQLiteDatabase obtenterSQLiteDB(Context contexto)
    {
        SQLiteOpenHelper sq=new SQLiteOpenHelper(contexto, "agenda", null, 1) {
            @Override
            public void onCreate(SQLiteDatabase sqLiteDatabase) {
                String sql="CREATE TABLE contactos(nombre TEXT, telefono, TEXT);";
                sqLiteDatabase.execSQL(sql);
            }

            @Override
            public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {

            }
        };
        SQLiteDatabase bd=sq.getWritableDatabase();
        return bd;
    }

    public static void grabarContacto(Contacto contacto, Context contexto) {
        String nombre=contacto.getNombre();
        String telefono=contacto.getTelefono();

        String[]valores={nombre, telefono};
        String sql="INSERT INTO contactos(nombre, telefono) VALUES('"+nombre+"','"+telefono+"');";
        SQLiteDatabase db=obtenterSQLiteDB(contexto);
        db.execSQL(sql);

    }
    public static List devolverContactos(Context contexto)
    {
        List<Contacto> lista_contactos=new ArrayList<>();
        String sql="SELECT * FROM contactos";
        SQLiteDatabase db=obtenterSQLiteDB(contexto);
        Cursor resultado=db.rawQuery(sql, null);
        while(resultado.moveToNext())
        {
            String nombre_bd=resultado.getString(0);
            String telefono_bd=resultado.getString(1);
            lista_contactos.add(new Contacto(nombre_bd, telefono_bd));

        }
        return lista_contactos;
    }
}
