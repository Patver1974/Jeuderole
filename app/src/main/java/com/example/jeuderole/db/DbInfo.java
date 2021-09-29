package com.example.jeuderole.db;

public class DbInfo {

    public static final String DB_NAME = "DbJeuDeRole";

    public static final int DB_VERSION = 1;

    public static class JeuDeRoleTable {
        // Le nom de la table
        public static final String TABLE_NAME = "tableCapacite";

        // Les noms des colonnes
        public static final String COLUMN_ID = "_id";
        public static final String COLUMN_ABREVIATION = "abrev";
        public static final String COLUMN_NOMCOMPLET = "nomComplet";
        public static final String COLUMN_MAXPOINTS = "maxPoints";


        // Les requetes SQL (DDL)
        public static final String REQUEST_CREATE =
                "CREATE TABLE " + TABLE_NAME + " ( "
                        + COLUMN_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, "
                        + COLUMN_ABREVIATION + " TEXT NOT NULL, "
                        + COLUMN_NOMCOMPLET + " TEXT NOT NULL, "
                        + COLUMN_MAXPOINTS + " TEXT NOT NULL "
                        + ");" ;

        public static final String REQUEST_DROP =
                "DROP TABLE IF EXISTS " + TABLE_NAME + ";" ;

        // Les requetes SQL (DML)
        public static final String REQUEST_ADD_INITIAL_DATA =
                "INSERT INTO " + TABLE_NAME + " (" + COLUMN_ABREVIATION + ") VALUES (?) ;";
    }


}





