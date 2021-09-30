package com.example.jeuderole.Adapter;

import android.annotation.SuppressLint;
import android.content.Context;
import android.location.Location;
import android.location.LocationManager;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.jeuderole.R;
import com.example.jeuderole.models.Capacite;

import java.util.Calendar;
import java.util.List;

public class AdapterCapacite extends RecyclerView.Adapter<AdapterCapacite.ViewHolder> {

    public static class ViewHolder extends RecyclerView.ViewHolder {

        private TextView tvAbreviation, tvNomComplet, tvCapaciteMaximum, tvcategorie, tvDegats, tvPointActuel,
                tvInitiation, tvEntrainement, tvMaitrise, tvInitiationPoint, tvEntrainementPoint, tvMaitrisePoint, tvRegleSpeciale;


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
            tvRegleSpeciale =view.findViewById(R.id.tv_item_capacite_reglespeciale);

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
        return new ViewHolder(view);
    }

    @SuppressLint("MissingPermission")
    @Override
    public void onBindViewHolder(@NonNull AdapterCapacite.ViewHolder holder, int position) {
        String strCategorie;
        Capacite capacite = dataSet.get(position);
        holder.tvAbreviation.setText(capacite.getAbrev());
        holder.tvNomComplet.setText(capacite.getNomComplet());
        holder.tvcategorie.setText(String.valueOf(capacite.getCategorie()));
        holder.tvCapaciteMaximum.setText(String.valueOf(capacite.getMaxPoints()));
        strCategorie = capacite.getCategorie();
        holder.tvDegats.setText(String.valueOf(capacite.getDegats()));
        holder.tvPointActuel.setText(String.valueOf(capacite.getPointActuel()));
        holder.tvInitiation.setText(String.valueOf(capacite.getInitiation()));
        holder.tvEntrainement.setText(String.valueOf(capacite.getEntrainement()));
        holder.tvMaitrise.setText(String.valueOf(capacite.getMaitrise()));
        holder.tvInitiationPoint.setText(String.valueOf(capacite.getInitiationPoint()));
        holder.tvEntrainementPoint.setText(String.valueOf(capacite.getEntrainementPoint()));
        holder.tvMaitrisePoint.setText(String.valueOf(capacite.getMaitrisePoint()));
        holder.tvRegleSpeciale.setText(String.valueOf(capacite.getRegleSpeciale()));
        switch (strCategorie) {
          case "Capacités":
              excapacites(holder);
              break;
            case "5 Sens":
                ex5sens(holder);
                break;
            case "Compétences de combat":
                exCompetencesCombat(holder);
                break;
            case "Compétences de tir":
                exCompetencesTir(holder);
                break;
            case "Compétences":
                exCompetences(holder);
                break;
            case "Compétences utilisées":
                exCompetencesutilisees(holder);
                break;
            case "Compétences complexes":
                exCompetencesComplexes(holder);
                break;
            case "Sortilèges":
                exSortileges(holder);
                break;
            default:
        }
    }

    private void exCompetencesComplexes(ViewHolder holder) {
        //holder.tvAbreviation.setText("");
        //holder.tvNomComplet.setText("");
        holder.tvcategorie.setText("");
        holder.tvCapaciteMaximum.setText("");
        holder.tvDegats.setText("");
        //holder.tvPointActuel.setText("");
        holder.tvInitiation.setText("");
        holder.tvEntrainement.setText("");
        holder.tvMaitrise.setText("");
        holder.tvInitiationPoint.setText("");
        holder.tvEntrainementPoint.setText("");
        holder.tvMaitrisePoint.setText("");
        holder.tvRegleSpeciale.setText("");
    }

    private void exCompetencesutilisees(ViewHolder holder) {
        //holder.tvAbreviation.setText("");
        //holder.tvNomComplet.setText("");
        holder.tvcategorie.setText("");
        holder.tvCapaciteMaximum.setText("");
        holder.tvDegats.setText("");
        //holder.tvPointActuel.setText("");
        holder.tvInitiation.setText("");
        holder.tvEntrainement.setText("");
        holder.tvMaitrise.setText("");
        holder.tvInitiationPoint.setText("");
        holder.tvEntrainementPoint.setText("");
        holder.tvMaitrisePoint.setText("");
        holder.tvRegleSpeciale.setText("");
    }

    private void exCompetences(ViewHolder holder) {
        //holder.tvAbreviation.setText("");
        //holder.tvNomComplet.setText("");
        holder.tvcategorie.setText("");
        holder.tvCapaciteMaximum.setText("");
        holder.tvDegats.setText("");
        //holder.tvPointActuel.setText("");
        holder.tvInitiation.setText("");
        holder.tvEntrainement.setText("");
        holder.tvMaitrise.setText("");
        holder.tvInitiationPoint.setText("");
        holder.tvEntrainementPoint.setText("");
        holder.tvMaitrisePoint.setText("");
        holder.tvRegleSpeciale.setText("");
    }

    private void exCompetencesTir(ViewHolder holder) {
        //holder.tvAbreviation.setText("");
        //holder.tvNomComplet.setText("");
        holder.tvcategorie.setText("");
        holder.tvCapaciteMaximum.setText("");
        //holder.tvDegats.setText("");
        //holder.tvPointActuel.setText("");
        holder.tvInitiation.setText("");
        holder.tvEntrainement.setText("");
        holder.tvMaitrise.setText("");
        holder.tvInitiationPoint.setText("");
        holder.tvEntrainementPoint.setText("");
        holder.tvMaitrisePoint.setText("");
        //holder.tvRegleSpeciale.setText("");
    }

    private void exSortileges(AdapterCapacite.ViewHolder holder) {
        //holder.tvAbreviation.setText("");
        //holder.tvNomComplet.setText("");
        holder.tvcategorie.setText("");
        holder.tvCapaciteMaximum.setText("");
        holder.tvDegats.setText("");
        //holder.tvPointActuel.setText("");
        holder.tvInitiation.setText("");
        holder.tvEntrainement.setText("");
        holder.tvMaitrise.setText("");
        holder.tvInitiationPoint.setText("");
        holder.tvEntrainementPoint.setText("");
        holder.tvMaitrisePoint.setText("");
        //holder.tvRegleSpeciale.setText("");
    }

    private void exCompetencesCombat(ViewHolder holder) {
        //holder.tvAbreviation.setText("");
        //holder.tvNomComplet.setText("");
        holder.tvcategorie.setText("");
        holder.tvCapaciteMaximum.setText("");
        //holder.tvDegats.setText("");
        holder.tvPointActuel.setText("");
        holder.tvInitiation.setText("");
        holder.tvEntrainement.setText("");
        holder.tvMaitrise.setText("");
        holder.tvInitiationPoint.setText("");
        holder.tvEntrainementPoint.setText("");
        holder.tvMaitrisePoint.setText("");
        //holder.tvRegleSpeciale.setText("");
    }

    private void ex5sens(ViewHolder holder) {
        holder.tvAbreviation.setText("");
        //holder.tvNomComplet.setText("");
        holder.tvcategorie.setText("");
        //holder.tvCapaciteMaximum.setText("");
        holder.tvDegats.setText("");
        holder.tvPointActuel.setText("");
        holder.tvInitiation.setText("");
        holder.tvEntrainement.setText("");
        holder.tvMaitrise.setText("");
        holder.tvInitiationPoint.setText("");
        holder.tvEntrainementPoint.setText("");
        holder.tvMaitrisePoint.setText("");
        holder.tvRegleSpeciale.setText("");

    }

    private void excapacites(ViewHolder holder) {
        //holder.tvAbreviation.setText("");
        //holder.tvNomComplet.setText("");
        holder.tvcategorie.setText("");
        //holder.tvCapaciteMaximum.setText("");
        holder.tvDegats.setText("");
        holder.tvPointActuel.setText("");
        holder.tvInitiation.setText("");
        holder.tvEntrainement.setText("");
        holder.tvMaitrise.setText("");
        holder.tvInitiationPoint.setText("");
        holder.tvEntrainementPoint.setText("");
        holder.tvMaitrisePoint.setText("");
        holder.tvRegleSpeciale.setText("");
    }

    @Override
    public int getItemCount() {
        return dataSet.size();
    }
}

