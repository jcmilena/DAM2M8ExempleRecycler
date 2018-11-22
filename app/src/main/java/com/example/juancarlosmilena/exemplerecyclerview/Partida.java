package com.example.juancarlosmilena.exemplerecyclerview;

import java.util.Date;

public class Partida {

    Date date;
    String jugador;
    int puntuacion;

    public Partida(int puntuacion) {
        this.date = new Date();
        this.jugador = "Jugador Inventado";
        this.puntuacion = puntuacion;
    }

    public Date getDate() {
        return date;
    }

    public String getJugador() {
        return jugador;
    }

    public int getPuntuacion() {
        return puntuacion;
    }
}
