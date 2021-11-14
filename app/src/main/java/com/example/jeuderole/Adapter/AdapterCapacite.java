package com.example.jeuderole.Adapter;

import android.annotation.SuppressLint;
import android.content.Context;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;

import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.example.jeuderole.R;
import com.example.jeuderole.models.Capacite;


import java.util.List;

public class AdapterCapacite extends RecyclerView.Adapter<AdapterCapacite.ViewHolder> {

    public static class ViewHolder extends RecyclerView.ViewHolder {

        private TextView tvAbreviation, tvNomComplet, tvCapaciteMaximum, tvcategorie, tvDegats, tvPointActuel,
                tvInitiation, tvEntrainement, tvMaitrise, tvInitiationPoint, tvEntrainementPoint, tvMaitrisePoint, tvRegleSpeciale;
        private static final String[] titlename = new String[] {"Catégorie","Abrév.","Nom","Point Max","Dégats","Point Actuel","Règle Spéciale","Initiation","Entraînement","Maîtrise","Point Initiation","Point Entrain.","Point Maîtrise"};


        public ViewHolder(@NonNull View view) {
            super(view);

            tvAbreviation = view.findViewById(R.id.tv_item_capacite_abreviation);
            tvNomComplet = view.findViewById(R.id.tv_item_capacite_nomcomplet);
            tvCapaciteMaximum = view.findViewById(R.id.tv_item_capacite_maxpoints);
            tvcategorie = view.findViewById(R.id.tv_item_capacite_categorie);
            tvDegats = view.findViewById(R.id.tv_item_capacite_degats);
            tvPointActuel = view.findViewById(R.id.tv_item_capacite_pointactuel);
            tvInitiation = view.findViewById(R.id.tv_item_capacite_initiation);
            tvEntrainement = view.findViewById(R.id.tv_item_capacite_entrainement);
            tvMaitrise = view.findViewById(R.id.tv_item_capacite_maitrise);
            tvInitiationPoint = view.findViewById(R.id.tv_item_capacite_initiationpoint);
            tvEntrainementPoint = view.findViewById(R.id.tv_item_capacite_entrainementpoint);
            tvMaitrisePoint = view.findViewById(R.id.tv_item_capacite_matrisepoint);
            tvRegleSpeciale = view.findViewById(R.id.tv_item_capacite_reglespeciale);

        }

        public TextView getTvAbreviation() {
            return tvAbreviation;
        }

        public TextView getTvNomComplet() {
            return tvNomComplet;
        }

        public TextView getTvCapaciteMaximum() {
            return tvCapaciteMaximum;
        }
    }


    private List<Capacite> dataSet; // Utilisation du type interface (Découplage)
    private Context context;


    public AdapterCapacite(Context context, List<Capacite> dataSet) {
        this.context = context;
        this.dataSet = dataSet;

    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.item_capacite, parent, false);
        LinearLayout.LayoutParams params = new LinearLayout.LayoutParams(RecyclerView.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT);
        params.setMargins(0,3,0,3);
        view.setLayoutParams(params);
        return new ViewHolder(view);
    }

    @SuppressLint("MissingPermission")
    @Override
    public void onBindViewHolder(@NonNull AdapterCapacite.ViewHolder holder, int position) {
        String strCategorie;
        Capacite capacite = dataSet.get(position);
        strCategorie = capacite.getCategorie();

        switch (strCategorie) {
            case "Capacités":
                excapacites(holder, capacite);
                break;
            case "5 Sens":
                ex5sens(holder, capacite);
                break;
            case "Compétences de combat":
                exCompetencesCombat(holder, capacite);
                break;
            case "Compétences de tir":
                exCompetencesTir(holder, capacite);
                break;
            case "Compétences":
                exCompetences(holder, capacite);
                break;
            case "Compétences utilisées":
                exCompetencesutilisees(holder, capacite);
                break;
            case "Compétences complexes":
                exCompetencesComplexes(holder, capacite);
                break;
            case "Sortilèges":
                exSortileges(holder, capacite);
                break;
            default:
                break;
        }
    }

    private void exCompetencesComplexes(ViewHolder holder, Capacite capacite) {
        holder.tvAbreviation.setText(capacite.getAbrev());
        holder.tvNomComplet.setText(capacite.getNomComplet());
        holder.tvPointActuel.setText(String.valueOf(capacite.getPointActuel()));

        holder.tvAbreviation.setPadding(3, 0, 3, 0);
        holder.tvNomComplet.setPadding(3, 0, 3, 0);
        holder.tvPointActuel.setPadding(3, 0, 3, 0);

        holder.tvRegleSpeciale.setVisibility(View.INVISIBLE);
        holder.tvRegleSpeciale.setHeight(0);

        holder.tvAbreviation.setWidth(100);
        holder.tvNomComplet.setWidth(400);
        holder.tvPointActuel.setWidth(100);

        holder.tvPointActuel.setGravity(Gravity.CENTER_HORIZONTAL);
    }

    private void exCompetencesutilisees(ViewHolder holder, Capacite capacite) {
        holder.tvAbreviation.setText(capacite.getAbrev());
        holder.tvNomComplet.setText(capacite.getNomComplet());
        holder.tvPointActuel.setText(String.valueOf(capacite.getPointActuel()));

        holder.tvAbreviation.setPadding(3, 0, 3, 0);
        holder.tvNomComplet.setPadding(3, 0, 3, 0);
        holder.tvPointActuel.setPadding(3, 0, 3, 0);

        holder.tvRegleSpeciale.setVisibility(View.INVISIBLE);
        holder.tvRegleSpeciale.setHeight(0);

        holder.tvAbreviation.setWidth(100);
        holder.tvNomComplet.setWidth(400);
        holder.tvPointActuel.setWidth(100);

        holder.tvPointActuel.setGravity(Gravity.CENTER_HORIZONTAL);
    }

    private void exCompetences(ViewHolder holder, Capacite capacite) {

        holder.tvAbreviation.setText(capacite.getAbrev());
        holder.tvNomComplet.setText(capacite.getNomComplet());
        holder.tvCapaciteMaximum.setText(String.valueOf(capacite.getMaxPoints()));
        holder.tvPointActuel.setText(String.valueOf(capacite.getPointActuel()));
        holder.tvRegleSpeciale.setText(String.valueOf(capacite.getRegleSpeciale()));

        holder.tvAbreviation.setPadding(3, 0, 3, 0);
        holder.tvCapaciteMaximum.setPadding(3, 0, 3, 0);
        holder.tvNomComplet.setPadding(3, 0, 3, 0);
        holder.tvPointActuel.setPadding(3, 0, 3, 0);
        holder.tvRegleSpeciale.setPadding(3, 0, 3, 0);

        holder.tvAbreviation.setWidth(100);
        holder.tvCapaciteMaximum.setWidth(100);
        holder.tvNomComplet.setWidth(400);
        holder.tvPointActuel.setWidth(100);

        holder.tvCapaciteMaximum.setGravity(Gravity.CENTER_HORIZONTAL);
        holder.tvPointActuel.setGravity(Gravity.CENTER_HORIZONTAL);
    }

    private void exCompetencesTir(ViewHolder holder, Capacite capacite) {

        holder.tvAbreviation.setText(capacite.getAbrev());
        holder.tvNomComplet.setText(capacite.getNomComplet());
        holder.tvDegats.setText(capacite.getDegats());
        holder.tvPointActuel.setText(String.valueOf(capacite.getPointActuel()));
        holder.tvRegleSpeciale.setText(String.valueOf(capacite.getRegleSpeciale()));

        holder.tvAbreviation.setPadding(3, 0, 3, 0);
        holder.tvNomComplet.setPadding(3, 0, 3, 0);
        holder.tvDegats.setPadding(3,0,3,0);
        holder.tvPointActuel.setPadding(3, 0, 3, 0);
        holder.tvRegleSpeciale.setPadding(3, 0, 3, 0);

        holder.tvAbreviation.setWidth(100);
        holder.tvNomComplet.setWidth(400);
        holder.tvDegats.setWidth(100);
        holder.tvPointActuel.setWidth(100);

        holder.tvDegats.setGravity(Gravity.CENTER_HORIZONTAL);
        holder.tvPointActuel.setGravity(Gravity.CENTER_HORIZONTAL);

    }

    private void exSortileges(ViewHolder holder, Capacite capacite) {

        holder.tvAbreviation.setText(capacite.getAbrev());
        holder.tvNomComplet.setText(capacite.getNomComplet());
        holder.tvPointActuel.setText(String.valueOf(capacite.getPointActuel()));
        holder.tvRegleSpeciale.setText(String.valueOf(capacite.getRegleSpeciale()));

        holder.tvAbreviation.setPadding(3, 0, 3, 0);
        holder.tvNomComplet.setPadding(3, 0, 3, 0);
        holder.tvPointActuel.setPadding(3, 0, 3, 0);
        holder.tvRegleSpeciale.setPadding(3, 0, 3, 0);

        holder.tvAbreviation.setWidth(100);
        holder.tvNomComplet.setWidth(400);
        holder.tvPointActuel.setWidth(100);

        holder.tvPointActuel.setGravity(Gravity.CENTER_HORIZONTAL);
    }

    private void exCompetencesCombat(ViewHolder holder, Capacite capacite) {

        holder.tvAbreviation.setText(capacite.getAbrev());
        holder.tvNomComplet.setText(capacite.getNomComplet());
        holder.tvDegats.setText(String.valueOf(capacite.getDegats()));
        holder.tvRegleSpeciale.setText(String.valueOf(capacite.getRegleSpeciale()));

        holder.tvAbreviation.setPadding(3, 0, 3, 0);
        holder.tvNomComplet.setPadding(3, 0, 3, 0);
        holder.tvDegats.setPadding(3, 0, 3, 0);
        holder.tvRegleSpeciale.setPadding(3, 0, 3, 0);

        holder.tvAbreviation.setWidth(100);
        holder.tvNomComplet.setWidth(400);
        holder.tvDegats.setWidth(100);

        holder.tvDegats.setGravity(Gravity.CENTER_HORIZONTAL);
    }

    private void ex5sens(ViewHolder holder, Capacite capacite) {

        holder.tvNomComplet.setText(capacite.getNomComplet());
        holder.tvCapaciteMaximum.setText(String.valueOf(capacite.getMaxPoints()));

        holder.tvNomComplet.setPadding(3, 0, 3, 0);
        holder.tvCapaciteMaximum.setPadding(3, 0, 3, 0);

        holder.tvRegleSpeciale.setVisibility(View.INVISIBLE);
        holder.tvRegleSpeciale.setHeight(0);

        holder.tvNomComplet.setWidth(400);
        holder.tvCapaciteMaximum.setWidth(100);

        holder.tvCapaciteMaximum.setGravity(Gravity.CENTER_HORIZONTAL);
    }

    private void excapacites(ViewHolder holder, Capacite capacite) {
        holder.tvAbreviation.setText(capacite.getAbrev());
        holder.tvNomComplet.setText(capacite.getNomComplet());
        holder.tvCapaciteMaximum.setText(String.valueOf(capacite.getMaxPoints()));

        holder.tvAbreviation.setPadding(3, 0, 3, 0);
        holder.tvNomComplet.setPadding(3, 0, 3, 0);
        holder.tvCapaciteMaximum.setPadding(3, 0, 3, 0);

        holder.tvRegleSpeciale.setVisibility(View.INVISIBLE);
        holder.tvRegleSpeciale.setHeight(0);

        holder.tvAbreviation.setWidth(100);
        holder.tvNomComplet.setWidth(400);
        holder.tvCapaciteMaximum.setWidth(100);

        holder.tvCapaciteMaximum.setGravity(Gravity.CENTER_HORIZONTAL);

    }

    @Override
    public int getItemCount() {
        return dataSet.size();
    }
}

