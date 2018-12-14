package com.example.juancarlosmilena.exemplerecyclerview;

public class Classif_DBDiseny {

    public static final String SQL_CREATE_ENTRIES = "CREATE TABLE " +
            Classif_Entrada.TABLE_NAME + " (" +
            "_id integer primary key autoincrement," +
            Classif_Entrada.COLUMNA_1 + " TEXT," +
            Classif_Entrada.COLUMNA_2 + " TEXT," +
            Classif_Entrada.COLUMNA_3 + " INTEGER)";

    public static final String SQL_DELETE_ENTRIES =
            "DROP TABLE IF EXISTS " + Classif_Entrada.TABLE_NAME;

    private Classif_DBDiseny(){}

    public static class Classif_Entrada {

        public static final String TABLE_NAME = "classificacio";
        public static final String COLUMNA_1 = "data";
        public static final String COLUMNA_2 = "jugador";
        public static final String COLUMNA_3 = "puntuacio";
    }
}
