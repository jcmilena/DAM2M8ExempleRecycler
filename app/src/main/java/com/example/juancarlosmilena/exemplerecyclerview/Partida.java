package com.example.juancarlosmilena.exemplerecyclerview;

import java.util.Date;

public class Partida {

    String date;
    String jugador;
    int puntuacion;

    public Partida(int puntuacion) {
        this.date = new Date().toString();
        this.jugador = "Jugador Inventado";
        this.puntuacion = puntuacion;
    }

    public Partida (String data, String jug, String punt){
        this.date = data;
        this.jugador = jug;
        this.puntuacion = Integer.valueOf(punt);
    }

    public String getDate() {
        return date;
    }

    public String getJugador() {
        return jugador;
    }

    public int getPuntuacion() {
        return puntuacion;
    }
}
