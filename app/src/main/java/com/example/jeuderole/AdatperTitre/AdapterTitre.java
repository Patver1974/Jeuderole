package com.example.jeuderole.AdatperTitre;

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

import com.example.jeuderole.AdatperTitre.AdapterTitre;
import com.example.jeuderole.R;
import com.example.jeuderole.models.Capacite;

import java.util.List;

public class AdapterTitre extends RecyclerView.Adapter<AdapterTitre.ViewHoldertitre>{


        public static class ViewHoldertitre extends RecyclerView.ViewHolder {

            private TextView tvAbreviation, tvNomComplet, tvCapaciteMaximum, tvcategorie, tvDegats, tvPointActuel,
                    tvInitiation, tvEntrainement, tvMaitrise, tvInitiationPoint, tvEntrainementPoint, tvMaitrisePoint, tvRegleSpeciale;


            public ViewHoldertitre(@NonNull View view) {
                super(view);

                tvAbreviation = view.findViewById(R.id.tv_item_titre_capacite_abreviation);
                tvNomComplet = view.findViewById(R.id.tv_item_titre_capacite_nomcomplet);
                tvCapaciteMaximum = view.findViewById(R.id.tv_item_titre_capacite_maxpoints);
                tvcategorie = view.findViewById(R.id.tv_item_titre_capacite_categorie);
                tvDegats = view.findViewById(R.id.tv_item_titre_capacite_degats);
                tvPointActuel = view.findViewById(R.id.tv_item_titre_capacite_pointactuel);
                tvInitiation = view.findViewById(R.id.tv_item_titre_capacite_initiation);
                tvEntrainement = view.findViewById(R.id.tv_item_titre_capacite_entrainement);
                tvMaitrise = view.findViewById(R.id.tv_item_titre_capacite_maitrise);
                tvInitiationPoint = view.findViewById(R.id.tv_item_titre_capacite_initiationpoint);
                tvEntrainementPoint = view.findViewById(R.id.tv_item_titre_capacite_entrainementpoint);
                tvMaitrisePoint = view.findViewById(R.id.tv_item_titre_capacite_matrisepoint);
                tvRegleSpeciale = view.findViewById(R.id.tv_item_titre_capacite_reglespeciale);

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


    public AdapterTitre(Context context, List<Capacite> dataSet) {
        this.context = context;
        this.dataSet = dataSet;

    }

    @NonNull
    @Override
    public AdapterTitre.ViewHoldertitre onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.item_titre_capacite, parent, false);
        LinearLayout.LayoutParams params = new LinearLayout.LayoutParams(RecyclerView.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT);
        params.setMargins(0,3,0,3);
        view.setLayoutParams(params);
        return new AdapterTitre.ViewHoldertitre(view);
    }

    @SuppressLint("MissingPermission")
    @Override
    public void onBindViewHolder( AdapterTitre.ViewHoldertitre holder, int position) {
        String strCategorie;
        Capacite capacite = dataSet.get(position);
        strCategorie = capacite.getCategorie();
        String[] titlename = new String[] {"Catégorie","Abrév.","Nom Complet","Point Max","Dégats","Point Actuel","Règle Spéciale","Initiation","Entraînement","Maîtrise","Point Initiation","Point Entrain.","Point Maîtrise"};
        switch (strCategorie) {
            case "Capacités":
                excapacites(holder, titlename);
                break;
            case "5 Sens":
                ex5sens(holder, titlename);
                break;
            case "Compétences de combat":
                exCompetencesCombat(holder, titlename);
                break;
            case "Compétences de tir":
                exCompetencesTir(holder, titlename);
                break;
            case "Compétences":
                exCompetences(holder, titlename);
                break;
            case "Compétences utilisées":
                exCompetencesutilisees(holder, titlename);
                break;
            case "Compétences complexes":
                exCompetencesComplexes(holder, titlename);
                break;
            case "Sortilèges":
                exSortileges(holder, titlename);
                break;
            default:
                break;
        }
    }

    private void exCompetencesComplexes(AdapterTitre.ViewHoldertitre holder, String[] titlename) {
        holder.tvAbreviation.setText(titlename[1]);
        holder.tvNomComplet.setText(titlename[2]);
        holder.tvPointActuel.setText(titlename[5]);

        holder.tvAbreviation.setPadding(3, 0, 3, 0);
        holder.tvNomComplet.setPadding(3, 0, 3, 0);
        holder.tvPointActuel.setPadding(3, 0, 3, 0);

        holder.tvRegleSpeciale.setVisibility(View.INVISIBLE);
        holder.tvRegleSpeciale.setHeight(0);

        holder.tvAbreviation.setWidth(100);
        holder.tvNomComplet.setWidth(400);
        holder.tvPointActuel.setWidth(100);

        holder.tvPointActuel.setGravity(Gravity.CENTER_HORIZONTAL);
        holder.tvNomComplet.setGravity(Gravity.CENTER_HORIZONTAL);
    }

    private void exCompetencesutilisees(AdapterTitre.ViewHoldertitre holder, String[] titlename) {
        holder.tvAbreviation.setText(titlename[1]);
        holder.tvNomComplet.setText(titlename[2]);
        holder.tvPointActuel.setText(titlename[5]);

        holder.tvAbreviation.setPadding(3, 0, 3, 0);
        holder.tvNomComplet.setPadding(3, 0, 3, 0);
        holder.tvPointActuel.setPadding(3, 0, 3, 0);

        holder.tvRegleSpeciale.setVisibility(View.INVISIBLE);
        holder.tvRegleSpeciale.setHeight(0);

        holder.tvAbreviation.setWidth(100);
        holder.tvNomComplet.setWidth(400);
        holder.tvPointActuel.setWidth(100);

        holder.tvPointActuel.setGravity(Gravity.CENTER_HORIZONTAL);
        holder.tvNomComplet.setGravity(Gravity.CENTER_HORIZONTAL);
        holder.tvRegleSpeciale.setGravity(Gravity.CENTER_HORIZONTAL);
    }

    private void exCompetences(AdapterTitre.ViewHoldertitre holder, String[] titlename) {

        holder.tvAbreviation.setText(titlename[1]);
        holder.tvNomComplet.setText(titlename[2]);
        holder.tvCapaciteMaximum.setText(titlename[3]);
        holder.tvPointActuel.setText(String.valueOf(titlename[5]));
        holder.tvRegleSpeciale.setText(titlename[6]);

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
        holder.tvNomComplet.setGravity(Gravity.CENTER_HORIZONTAL);
        holder.tvRegleSpeciale.setGravity(Gravity.CENTER_HORIZONTAL);
    }

    private void exCompetencesTir(AdapterTitre.ViewHoldertitre holder, String[] titlename) {

        holder.tvAbreviation.setText(titlename[1]);
        holder.tvNomComplet.setText(titlename[2]);
        holder.tvDegats.setText(titlename[4]);
        holder.tvPointActuel.setText(titlename[5]);
        holder.tvRegleSpeciale.setText(titlename[6]);

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
        holder.tvNomComplet.setGravity(Gravity.CENTER_HORIZONTAL);
        holder.tvRegleSpeciale.setGravity(Gravity.CENTER_HORIZONTAL);

    }

    private void exSortileges(AdapterTitre.ViewHoldertitre holder, String[] titlename) {

        holder.tvAbreviation.setText(titlename[1]);
        holder.tvNomComplet.setText(titlename[2]);
        holder.tvPointActuel.setText(titlename[5]);
        holder.tvRegleSpeciale.setText(titlename[6]);

        holder.tvAbreviation.setPadding(3, 0, 3, 0);
        holder.tvNomComplet.setPadding(3, 0, 3, 0);
        holder.tvPointActuel.setPadding(3, 0, 3, 0);
        holder.tvRegleSpeciale.setPadding(3, 0, 3, 0);

        holder.tvAbreviation.setWidth(100);
        holder.tvNomComplet.setWidth(400);
        holder.tvPointActuel.setWidth(100);

        holder.tvPointActuel.setGravity(Gravity.CENTER_HORIZONTAL);
        holder.tvNomComplet.setGravity(Gravity.CENTER_HORIZONTAL);
        holder.tvRegleSpeciale.setGravity(Gravity.CENTER_HORIZONTAL);
    }

    private void exCompetencesCombat(AdapterTitre.ViewHoldertitre holder, String[] titlename) {

        holder.tvAbreviation.setText(titlename[1]);
        holder.tvNomComplet.setText(titlename[2]);
        holder.tvDegats.setText(titlename[4]);
        holder.tvRegleSpeciale.setText(titlename[6]);

        holder.tvAbreviation.setPadding(3, 0, 3, 0);
        holder.tvNomComplet.setPadding(3, 0, 3, 0);
        holder.tvDegats.setPadding(3, 0, 3, 0);
        holder.tvRegleSpeciale.setPadding(3, 0, 3, 0);

        holder.tvAbreviation.setWidth(100);
        holder.tvNomComplet.setWidth(400);
        holder.tvDegats.setWidth(100);

        holder.tvDegats.setGravity(Gravity.CENTER_HORIZONTAL);
        holder.tvNomComplet.setGravity(Gravity.CENTER_HORIZONTAL);
        holder.tvRegleSpeciale.setGravity(Gravity.CENTER_HORIZONTAL);
    }

    private void ex5sens(AdapterTitre.ViewHoldertitre holder, String[] titlename) {

        holder.tvNomComplet.setText(titlename[2]);
        holder.tvCapaciteMaximum.setText(titlename[3]);

        holder.tvNomComplet.setPadding(3, 0, 3, 0);
        holder.tvCapaciteMaximum.setPadding(3, 0, 3, 0);

        holder.tvRegleSpeciale.setVisibility(View.INVISIBLE);
        holder.tvRegleSpeciale.setHeight(0);

        holder.tvNomComplet.setWidth(400);
        holder.tvCapaciteMaximum.setWidth(100);

        holder.tvCapaciteMaximum.setGravity(Gravity.CENTER_HORIZONTAL);
        holder.tvNomComplet.setGravity(Gravity.CENTER_HORIZONTAL);

    }

    private void excapacites(AdapterTitre.ViewHoldertitre holder, String[] titlename) {
        holder.tvAbreviation.setText(titlename[1]);
        holder.tvNomComplet.setText(titlename[1]);
        holder.tvCapaciteMaximum.setText(String.valueOf(titlename[3]));

        holder.tvAbreviation.setPadding(3, 0, 3, 0);
        holder.tvNomComplet.setPadding(3, 0, 3, 0);
        holder.tvCapaciteMaximum.setPadding(3, 0, 3, 0);

        holder.tvRegleSpeciale.setVisibility(View.INVISIBLE);
        holder.tvRegleSpeciale.setHeight(0);

        holder.tvAbreviation.setWidth(100);
        holder.tvNomComplet.setWidth(400);
        holder.tvCapaciteMaximum.setWidth(100);

        holder.tvCapaciteMaximum.setGravity(Gravity.CENTER_HORIZONTAL);
        holder.tvNomComplet.setGravity(Gravity.CENTER_HORIZONTAL);


    }

    @Override
    public int getItemCount() {
        return 1;
    }
}

