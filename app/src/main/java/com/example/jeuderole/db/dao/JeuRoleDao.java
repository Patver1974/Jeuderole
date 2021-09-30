package com.example.jeuderole.db.dao;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.util.Log;

import com.example.jeuderole.db.DbInfo;
import com.example.jeuderole.models.Capacite;

import java.util.ArrayList;
import java.util.List;

public class JeuRoleDao extends DaoBase<Capacite> {

    public JeuRoleDao(Context context) {
        super(context);
    }


    // Méthode du CRUD
    private ContentValues generateContentValues(Capacite capacite) {
        ContentValues cv = new ContentValues();
        cv.put(DbInfo.JeuDeRoleTable.COLUMN_ABREVIATION, capacite.getAbrev() == null ? "" : capacite.getAbrev());
        cv.put(DbInfo.JeuDeRoleTable.COLUMN_CATEGORIE, capacite.getCategorie() == null ? "" : capacite.getCategorie());
        cv.put(DbInfo.JeuDeRoleTable.COLUMN_NOMCOMPLET, capacite.getNomComplet() == null ? "" : capacite.getNomComplet());
        cv.put(DbInfo.JeuDeRoleTable.COLUMN_MAXPOINTS, capacite.getMaxPoints() == null ? "" : capacite.getMaxPoints().toString());
        cv.put(DbInfo.JeuDeRoleTable.COLUMN_DEGATS , capacite.getDegats() == null ? "" : capacite.getDegats().toString());
        cv.put(DbInfo.JeuDeRoleTable.COLUMN_POINTACTUEL, capacite.getPointActuel() == null ? "" : capacite.getPointActuel().toString());
        cv.put(DbInfo.JeuDeRoleTable.COLUMN_REGLESPECIALE, capacite.getRegleSpeciale() == null ? "" : capacite.getRegleSpeciale().toString());
        cv.put(DbInfo.JeuDeRoleTable.COLUMN_INITIATION, capacite.getInitiation() == null ? "" : capacite.getInitiation().toString());
        cv.put(DbInfo.JeuDeRoleTable.COLUMN_ENTRAINEMENT, capacite.getEntrainement() == null ? "" : capacite.getEntrainement().toString());
        cv.put(DbInfo.JeuDeRoleTable.COLUMN_MAITRISE, capacite.getMaitrise() == null ? "" : capacite.getMaitrise().toString());
        cv.put(DbInfo.JeuDeRoleTable.COLUMN_INITIATIONPOINT, capacite.getInitiationPoint() == null ? "" : capacite.getInitiationPoint().toString());
        cv.put(DbInfo.JeuDeRoleTable.COLUMN_ENTRAINEMENTPOINT, capacite.getEntrainementPoint() == null ? "" : capacite.getEntrainementPoint().toString());
        cv.put(DbInfo.JeuDeRoleTable.COLUMN_MAITRISEPOINT, capacite.getMaitrisePoint() == null ? "" : capacite.getMaitrisePoint().toString());


        return cv;
    }

    private Capacite cursorToData(Cursor cursor) {

        long id = cursor.getLong(cursor.getColumnIndex(DbInfo.JeuDeRoleTable.COLUMN_ID));
        String categorie = cursor.getString(cursor.getColumnIndex(DbInfo.JeuDeRoleTable.COLUMN_CATEGORIE));
        String abrev = cursor.getString(cursor.getColumnIndex(DbInfo.JeuDeRoleTable.COLUMN_ABREVIATION));
        String nomComplet = cursor.getString(cursor.getColumnIndex(DbInfo.JeuDeRoleTable.COLUMN_NOMCOMPLET));
        Integer maxPoints = Integer.valueOf(cursor.getString(cursor.getColumnIndex(DbInfo.JeuDeRoleTable.COLUMN_MAXPOINTS)));
        String degats = cursor.getString(cursor.getColumnIndex(DbInfo.JeuDeRoleTable.COLUMN_DEGATS));
        Integer pointactuel = Integer.valueOf(cursor.getString(cursor.getColumnIndex(DbInfo.JeuDeRoleTable.COLUMN_POINTACTUEL)));
        String reglespeciale = cursor.getString(cursor.getColumnIndex(DbInfo.JeuDeRoleTable.COLUMN_REGLESPECIALE));
        String initiation = cursor.getString(cursor.getColumnIndex(DbInfo.JeuDeRoleTable.COLUMN_INITIATION));
        String entrainement = cursor.getString(cursor.getColumnIndex(DbInfo.JeuDeRoleTable.COLUMN_ENTRAINEMENT));
        String maitrise = cursor.getString(cursor.getColumnIndex(DbInfo.JeuDeRoleTable.COLUMN_MAITRISE));
        Integer initiationpoint = Integer.valueOf(cursor.getString(cursor.getColumnIndex(DbInfo.JeuDeRoleTable.COLUMN_INITIATIONPOINT)));
        Integer entrainementpoint = Integer.valueOf(cursor.getString(cursor.getColumnIndex(DbInfo.JeuDeRoleTable.COLUMN_ENTRAINEMENTPOINT)));
        Integer maitrisepoint = Integer.valueOf(cursor.getString(cursor.getColumnIndex(DbInfo.JeuDeRoleTable.COLUMN_MAITRISEPOINT)));

        return new Capacite(id,categorie, abrev, nomComplet, maxPoints,degats,pointactuel,reglespeciale,initiation,entrainement,maitrise,initiationpoint,entrainementpoint,maitrisepoint);
    }

    // - Create
    public long insert(Capacite capacite) {
        ContentValues cv = generateContentValues(capacite);

        return db.insert(DbInfo.JeuDeRoleTable.TABLE_NAME, null, cv);
    }

    // - Read
    public Capacite get(long id) {
        String whereClause = DbInfo.JeuDeRoleTable.COLUMN_ID + " = ?";
        String[] whereArg = new String[]{
                String.valueOf(id)
        };

        // Création d'un curseur qui permet d'obtenir le resultat d'un select
        Cursor cursor = db.query(DbInfo.JeuDeRoleTable.TABLE_NAME, null, whereClause, whereArg, null, null, null);

        // Tester si on a un resultat
        if (cursor.getCount() == 0) {
            return null;
        }

        // On déplace le curseur sur le resutlat
        cursor.moveToFirst();

        // On lire les données pointée par le curseur
        Capacite result = cursorToData(cursor);

        // On cloture le curseur
        cursor.close();

        return result;
    }

    public List<Capacite> getAll() {
        // Création d'un curseur qui permet d'obtenir le resultat d'un select
        Cursor cursor = db.query(DbInfo.JeuDeRoleTable.TABLE_NAME, null, null, null, null, null, null);

        // Initialise la liste de resultat
        List<Capacite> results = new ArrayList<>();

        // Verification qu'il y a un resultat
        if (cursor.getCount() == 0) {
            return results; // Liste vide
        }

        // On place le curseur sur le premier resultat
        cursor.moveToFirst();

        while (!cursor.isAfterLast()) {  // On continue tant qu'on a pas fait toute les resultats

            // On extrait les données du curseur
            Capacite cat = cursorToData(cursor);
            results.add(cat);

            // On passe à la prochain valeur de resultat
            cursor.moveToNext();
        }

        // On cloture le curseur
        cursor.close();

        // On renvoie les resultats
        return results;
    }


    public List<Capacite> getAllWithCategorie(String colonneCategories) {
        // Création d'un curseur qui permet d'obtenir le resultat d'un select
        Cursor cursor = db.query(DbInfo.JeuDeRoleTable.TABLE_NAME, null, DbInfo.JeuDeRoleTable.COLUMN_CATEGORIE + " = ?", new String[]{colonneCategories}, null, null, null);

        // Initialise la liste de resultat
        List<Capacite> results = new ArrayList<>();

        // Verification qu'il y a un resultat
        if (cursor.getCount() == 0) {
            return results; // Liste vide
        }

        // On place le curseur sur le premier resultat
        cursor.moveToFirst();

        while (!cursor.isAfterLast()) {  // On continue tant qu'on a pas fait toute les resultats

            // On extrait les données du curseur
            Capacite cat = cursorToData(cursor);
            results.add(cat);

            // On passe à la prochain valeur de resultat
            cursor.moveToNext();
        }

        // On cloture le curseur
        cursor.close();

        // On renvoie les resultats
        return results;
    }
    // - Update
    public boolean update(long id, Capacite data) {
        ContentValues cv = generateContentValues(data);

        String whereClause = DbInfo.JeuDeRoleTable.COLUMN_ID + " = ?";
        String[] whereArg = new String[]{
                String.valueOf(id)
        };

        int nbRow = db.update(DbInfo.JeuDeRoleTable.TABLE_NAME, cv, whereClause, whereArg);
        return nbRow == 1;
    }

    // - Delete
    public boolean delete(long id) {
        String whereClause = DbInfo.JeuDeRoleTable.COLUMN_ID + " = ?";
        String[] whereArg = new String[]{
                String.valueOf(id)
        };

        int nbRow = db.delete(DbInfo.JeuDeRoleTable.TABLE_NAME, whereClause, whereArg);
        return nbRow == 1;
    }

}
