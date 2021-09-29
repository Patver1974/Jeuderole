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
        cv.put(DbInfo.JeuDeRoleTable.COLUMN_NOMCOMPLET, capacite.getNomComplet() == null ? "" : capacite.getNomComplet());
        cv.put(DbInfo.JeuDeRoleTable.COLUMN_MAXPOINTS, capacite.getMaxPoints() == null ? "0" : capacite.getMaxPoints().toString());

        return cv;
    }

    private Capacite cursorToData(Cursor cursor) {

        long id = cursor.getLong(cursor.getColumnIndex(DbInfo.JeuDeRoleTable.COLUMN_ID));
        String abrev = cursor.getString(cursor.getColumnIndex(DbInfo.JeuDeRoleTable.COLUMN_ABREVIATION));
        String nomComplet = cursor.getString(cursor.getColumnIndex(DbInfo.JeuDeRoleTable.COLUMN_NOMCOMPLET));
        Integer maxPoints = Integer.valueOf(cursor.getString(cursor.getColumnIndex(DbInfo.JeuDeRoleTable.COLUMN_MAXPOINTS)));
        return new Capacite(id, abrev, nomComplet, maxPoints);
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
