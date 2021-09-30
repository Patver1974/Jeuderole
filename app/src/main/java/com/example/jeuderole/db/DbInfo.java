package com.example.jeuderole.db;

public class DbInfo {

    public static final String DB_NAME = "DbJeuDeRole";

    public static final int DB_VERSION = 2;

    public static class JeuDeRoleTable {
        // Le nom de la table
        public static final String TABLE_NAME = "tableCapacite";

        // Les noms des colonnes
        public static final String COLUMN_ID = "_id";
        public static final String COLUMN_ABREVIATION = "abrev";
        public static final String COLUMN_CATEGORIE = "categorie";
        public static final String COLUMN_NOMCOMPLET = "nomComplet";
        public static final String COLUMN_MAXPOINTS = "maxPoints";
        public static final String COLUMN_DEGATS = "degats";
        public static final String COLUMN_POINTACTUEL = "pointActuel";
        public static final String COLUMN_REGLESPECIALE = "regleSpeciale";
        public static final String COLUMN_INITIATION = "initiation";
        public static final String COLUMN_ENTRAINEMENT = "entrainement";
        public static final String COLUMN_MAITRISE = "maitrise";
        public static final String COLUMN_INITIATIONPOINT = "initiationPoint";
        public static final String COLUMN_ENTRAINEMENTPOINT = "entrainementPoint";
        public static final String COLUMN_MAITRISEPOINT = "maitrisePoint";


        // Les requetes SQL (DDL)
        public static final String REQUEST_CREATE =
                "CREATE TABLE " + TABLE_NAME + " ( "
                        + COLUMN_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, "
                        + COLUMN_CATEGORIE + " TEXT NOT NULL, "
                        + COLUMN_ABREVIATION + " TEXT NOT NULL, "
                        + COLUMN_NOMCOMPLET + " TEXT NOT NULL, "
                        + COLUMN_MAXPOINTS + " , "
                        + COLUMN_DEGATS + " , "
                        + COLUMN_POINTACTUEL + " , "
                        + COLUMN_REGLESPECIALE + " , "
                        + COLUMN_INITIATION + " , "
                        + COLUMN_ENTRAINEMENT + " , "
                        + COLUMN_MAITRISE + " , "
                        + COLUMN_INITIATIONPOINT + " , "
                        + COLUMN_ENTRAINEMENTPOINT + " , "
                        + COLUMN_MAITRISEPOINT + "  "
                        + ");" ;

        public static final String REQUEST_DROP =
                "DROP TABLE IF EXISTS " + TABLE_NAME + ";" ;

        // Les requetes SQL (DML)
        public static final String REQUEST_ADD_INITIAL_DATA =
                "INSERT INTO " + TABLE_NAME + " (" + COLUMN_ABREVIATION + ") VALUES (?) ;";
    }


}





