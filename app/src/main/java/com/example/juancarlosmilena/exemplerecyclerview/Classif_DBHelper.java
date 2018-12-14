package com.example.juancarlosmilena.exemplerecyclerview;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.util.Date;

public class Classif_DBHelper extends SQLiteOpenHelper {

    private static final int VERSION = 2;
    private static final String DATABASE_NAME = "exemple_recycler.db";


    public Classif_DBHelper(Context context) {
        super(context, DATABASE_NAME, null, VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {

        db.execSQL(Classif_DBDiseny.SQL_CREATE_ENTRIES);

        ContentValues values = new ContentValues();
        values.put(Classif_DBDiseny.Classif_Entrada.COLUMNA_1,new Date().toString());
        values.put(Classif_DBDiseny.Classif_Entrada.COLUMNA_2, "SuperChampion");
        values.put(Classif_DBDiseny.Classif_Entrada.COLUMNA_3,"100");
        db.insert(Classif_DBDiseny.Classif_Entrada.TABLE_NAME, null, values);

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

        db.execSQL(Classif_DBDiseny.SQL_DELETE_ENTRIES);
        onCreate(db);
    }
}
