package com.example.juancarlosmilena.exemplerecyclerview;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.LinearLayout;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity implements JuegoFragment.JuegoListener, PartidaFragment.PartidasListener {

    int pulsaciones=0;
    List<Partida> listado_partidas;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        listado_partidas= new ArrayList<>();

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
    public void mostrar_clasificacion() {

        Partida p = new Partida(pulsaciones);
        listado_partidas.add(p);
        pulsaciones=0;

        Fragment fragment = new PartidaFragment();
        cargar_fragment(fragment);
    }

    @Override
    public List<Partida> cargar_partidas() {
        return listado_partidas;
    }

}
