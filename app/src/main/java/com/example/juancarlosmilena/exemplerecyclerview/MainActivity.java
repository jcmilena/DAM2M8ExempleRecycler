package com.example.juancarlosmilena.exemplerecyclerview;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.LinearLayout;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class MainActivity extends AppCompatActivity implements JuegoFragment.JuegoListener, PartidaFragment.PartidasListener {

    int pulsaciones=0;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Fragment fragment = new JuegoFragment();
        cargar_fragment(fragment);
    }

    private void cargar_fragment(Fragment fragment) {

        FragmentManager fm = getSupportFragmentManager();
        fm.beginTransaction().replace(R.id.fragment_container,fragment).addToBackStack(null).commit();

    }

    @Override
    public void contar_pulsaciones(int pulsac) {
        pulsaciones = pulsac;
    }

    @Override
    public int mostrar_clasificacion() {

        Partida p = new Partida(pulsaciones);
        //listado_partidas.add(p);  -- NO NECESARIO CON SQLite

        guardar_partida(p);

        Fragment fragment = new PartidaFragment();
        cargar_fragment(fragment);
        return 0;
    }

    private void guardar_partida(Partida p) {

        ContentValues values = new ContentValues();
        values.put(Classif_DBDiseny.Classif_Entrada.COLUMNA_1, new Date().toString());
        values.put(Classif_DBDiseny.Classif_Entrada.COLUMNA_2, p.getJugador());
        values.put(Classif_DBDiseny.Classif_Entrada.COLUMNA_3, String.valueOf(p.getPuntuacion()));

        Classif_DBHelper dbHelper = new Classif_DBHelper(this);
        SQLiteDatabase db = dbHelper.getWritableDatabase();

        db.insert(Classif_DBDiseny.Classif_Entrada.TABLE_NAME, null, values);

        db.close();

    }

    @Override
    public List<Partida> cargar_partidas() {

        List<Partida> listado_partidas = new ArrayList<>();


        Classif_DBHelper dbHelper = new Classif_DBHelper(this);
        SQLiteDatabase db = dbHelper.getWritableDatabase();

        Cursor cursor = db.query(
                Classif_DBDiseny.Classif_Entrada.TABLE_NAME,
                null,
                null,
                null,
                null,
                null,
                Classif_DBDiseny.Classif_Entrada.COLUMNA_3 + " DESC");

        while(cursor.moveToNext()){

            Partida p = new Partida(
                    cursor.getString(cursor.getColumnIndex(Classif_DBDiseny.Classif_Entrada.COLUMNA_1)),
                    cursor.getString(cursor.getColumnIndex(Classif_DBDiseny.Classif_Entrada.COLUMNA_2)),
                    cursor.getString(cursor.getColumnIndex(Classif_DBDiseny.Classif_Entrada.COLUMNA_3))
                    );

            listado_partidas.add(p);
        }

        db.close();
        return listado_partidas;
    }


}
