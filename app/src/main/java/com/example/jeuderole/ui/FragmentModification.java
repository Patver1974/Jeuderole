package com.example.jeuderole.ui;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.example.jeuderole.R;
import com.example.jeuderole.db.dao.JeuRoleDao;
import com.example.jeuderole.models.Capacite;

import java.util.ArrayList;
import java.util.List;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link FragmentModification#newInstance} factory method to
 * create an instance of this fragment.
 */
public class FragmentModification extends Fragment implements AdapterView.OnItemSelectedListener, View.OnClickListener {

    private Button btSuivant, btPrecedent;
    private Button btDebut, btFin;
    private TextView tvIndex;
    private Spinner spinnerDiffCompetences;
    private List<Capacite> ListeAModifier = new ArrayList<>();
    private Integer postionliste = 0;
    private JeuRoleDao dao;
    private Integer maxIdListeCapacite = 0;
    private EditText etId, etAbreviation, etCategorie, etNomComplet, etMaxPoint, etDegats, etPointActuel, etRegleSpeciale,
            etInitiation, etEntrainement, etMaitrise, etInitiationPoint, etEntrainementPoint, etMaitrisePoint;
    private View viewId, viewAbreviation, viewCategorie, viewNomComplet, viewMaxPoint, viewDegats, viewPointActuel, viewRegleSpeciale,
            viewInitiation, viewEntrainement, viewMaitrise, viewInitiationPoint, viewEntrainementPoint, viewMaitrisePoint;
    private String categorieSelectionnee;


    public FragmentModification() {
        // Required empty public constructor
    }


    // TODO: Rename and change types and number of parameters
    public static FragmentModification newInstance(String param1, String param2) {
        FragmentModification fragment = new FragmentModification();
        Bundle args = new Bundle();

        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_modification, container, false);
        spinnerDiffCompetences = v.findViewById(R.id.sp_capacitemodification_categoriePersonnage);
        btPrecedent = v.findViewById(R.id.bt_capacitemodification_precedent);
        btSuivant = v.findViewById(R.id.bt_capacitemodification_suivant);
        btDebut = v.findViewById(R.id.bt_capacitemodification_debut);
        btFin = v.findViewById(R.id.bt_capacitemodification_fin);
        tvIndex = v.findViewById(R.id.tv_capacitemodification_index);
        etId = v.findViewById(R.id.et_capacitemodification_id);
        etAbreviation = v.findViewById(R.id.et_capacitemodification_abreviation);
        etCategorie = v.findViewById(R.id.et_capacitemodification_categorie);
        etNomComplet = v.findViewById(R.id.et_capacitemodification_nomcomplet);
        etMaxPoint = v.findViewById(R.id.et_capacitemodification_maxpoint);
        etDegats = v.findViewById(R.id.et_capacitemodification_degats);
        etPointActuel = v.findViewById(R.id.et_capacitemodification_pointactuel);
        etRegleSpeciale = v.findViewById(R.id.et_capacitemodification_reglespeciale);
        etInitiation = v.findViewById(R.id.et_capacitemodification_initiation);
        etEntrainement = v.findViewById(R.id.et_capacitemodification_entrainement);
        etMaitrise = v.findViewById(R.id.et_capacitemodification_maitrise);
        etInitiationPoint = v.findViewById(R.id.et_capacitemodification_initiationpoint);
        etEntrainementPoint = v.findViewById(R.id.et_capacitemodification_entrainementpoint);
        etMaitrisePoint = v.findViewById(R.id.et_capacitemodification_maitrisepoint);
        viewId = v.findViewById(R.id.view_capacitemodification_view_id);
        viewAbreviation = v.findViewById(R.id.view_capacitemodification_view_abreviation);
        viewCategorie = v.findViewById(R.id.view_capacitemodification_view_categorie);
        viewNomComplet = v.findViewById(R.id.view_capacitemodification_view_nomcomplet);
        viewMaxPoint = v.findViewById(R.id.view_capacitemodification_view_maxpoint);
        viewDegats = v.findViewById(R.id.view_capacitemodification_view_degats);
        viewPointActuel = v.findViewById(R.id.view_capacitemodification_view_pointactuel);
        viewRegleSpeciale = v.findViewById(R.id.view_capacitemodification_view_reglespeciale);
        viewInitiation = v.findViewById(R.id.view_capacitemodification_view_initiation);
        viewEntrainement = v.findViewById(R.id.view_capacitemodification_view_entrainement);
        viewMaitrise = v.findViewById(R.id.view_capacitemodification_view_maitrise);
        viewInitiationPoint = v.findViewById(R.id.view_capacitemodification_view_initiationpoint);
        viewEntrainementPoint = v.findViewById(R.id.view_capacitemodification_view_entrainementpoint);
        viewMaitrisePoint = v.findViewById(R.id.view_capacitemodification_view_maitrisepoint);



//spinner

// Create an ArrayAdapter using the string array and a default spinner layout
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(getContext(),
                R.array.categorie_personnage, android.R.layout.simple_spinner_item);
// Specify the layout to use when the list of choices appears
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
// Apply the adapter to the spinner


        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

        spinnerDiffCompetences.setAdapter(adapter);
        spinnerDiffCompetences.setSelection(0);

        spinnerDiffCompetences.setOnItemSelectedListener(this);

        btSuivant.setOnClickListener(this);
        btPrecedent.setOnClickListener(this);
        btFin.setOnClickListener(this);
        btDebut.setOnClickListener(this);

        return v;
    }

    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
        ListeAModifier.clear();
        dao = new JeuRoleDao(getContext());
        dao.openReadable();
        categorieSelectionnee = spinnerDiffCompetences.getSelectedItem().toString();
        ListeAModifier = dao.getAllWithCategorie(categorieSelectionnee);
        dao.close();
        maxIdListeCapacite = ListeAModifier.size() - 1;

        postionliste = 0;
        if (maxIdListeCapacite >= 0) {
            Afficherdonnee();
        }

        Toast.makeText(getView().getContext(), String.valueOf(maxIdListeCapacite), Toast.LENGTH_LONG).show();
    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.bt_capacitemodification_precedent:
                if (postionliste != 0) {
                    if (maxIdListeCapacite == -1) {
                        Toast.makeText(getContext(), "Pas d'enregistrement !!!", Toast.LENGTH_LONG).show();
                    } else {
                        postionliste = postionliste - 1;
                        Afficherdonnee();
                    }
                } else {
                    Toast.makeText(getContext(), "Debut du fichier", Toast.LENGTH_LONG).show();
                }
                break;
            case R.id.bt_capacitemodification_suivant:
                if (!postionliste.equals(maxIdListeCapacite)) {
                    if (maxIdListeCapacite == -1) {
                        Toast.makeText(getContext(), "Pas d'enregistrement !!!", Toast.LENGTH_LONG).show();
                    } else {
                        postionliste = postionliste + 1;
                        Afficherdonnee();
                    }
                } else {
                    Toast.makeText(getContext(), "Fin du fichier", Toast.LENGTH_LONG).show();
                }
                break;
            case R.id.bt_capacitemodification_debut:
                if (maxIdListeCapacite == -1) {
                    Toast.makeText(getContext(), "Pas d'enregistrement !!!", Toast.LENGTH_LONG).show();
                } else {
                    postionliste = 0;
                    Afficherdonnee();
                }
            case R.id.bt_capacitemodification_fin:

                if (maxIdListeCapacite == -1) {
                    Toast.makeText(getContext(), "Pas d'enregistrement !!!", Toast.LENGTH_LONG).show();
                } else {
                    postionliste = maxIdListeCapacite;
                    Afficherdonnee();
                }

        }
    }

    private void Afficherdonnee() {
        tvIndex.setText(String.valueOf(postionliste));

        etNomComplet.setText("");
//        etId.setText(String.valueOf(ListeAModifier.get(postionliste).getId()));
//        etAbreviation.setText(String.valueOf(ListeAModifier.get(postionliste).getAbrev()));
//        etCategorie.setText(String.valueOf(ListeAModifier.get(postionliste).getCategorie()));
//        etNomComplet.setText(String.valueOf(ListeAModifier.get(postionliste).getNomComplet()));
//        etMaxPoint.setText(String.valueOf(ListeAModifier.get(postionliste).getMaxPoints()));
//        etDegats.setText(String.valueOf(ListeAModifier.get(postionliste).getDegats()));
//        etPointActuel.setText(String.valueOf(ListeAModifier.get(postionliste).getPointActuel()));
//        etRegleSpeciale.setText(String.valueOf(ListeAModifier.get(postionliste).getRegleSpeciale()));
//        etInitiation.setText(String.valueOf(ListeAModifier.get(postionliste).getInitiation()));
//        etEntrainement.setText(String.valueOf(ListeAModifier.get(postionliste).getEntrainement()));
//        etMaitrise.setText(String.valueOf(ListeAModifier.get(postionliste).getMaitrise()));
//        etInitiationPoint.setText(String.valueOf(ListeAModifier.get(postionliste).getInitiationPoint()));
//        etEntrainementPoint.setText(String.valueOf(ListeAModifier.get(postionliste).getEntrainementPoint()));
//        etMaitrisePoint.setText(String.valueOf(ListeAModifier.get(postionliste).getMaitrisePoint()));

        switch (categorieSelectionnee) {

            case "Capacités":
                etAbreviation.setText(String.valueOf(ListeAModifier.get(postionliste).getAbrev()));
                etNomComplet.setText(String.valueOf(ListeAModifier.get(postionliste).getNomComplet()));
                etMaxPoint.setText(String.valueOf(ListeAModifier.get(postionliste).getMaxPoints()));

                break;
            case "5 Sens":
                etNomComplet.setText(String.valueOf(ListeAModifier.get(postionliste).getNomComplet()));
                etMaxPoint.setText(String.valueOf(ListeAModifier.get(postionliste).getMaxPoints()));

                break;
            case "Compétences de combat":
                etNomComplet.setText(String.valueOf(ListeAModifier.get(postionliste).getNomComplet()));
                etDegats.setText(String.valueOf(ListeAModifier.get(postionliste).getDegats()));
                etRegleSpeciale.setText(String.valueOf(ListeAModifier.get(postionliste).getRegleSpeciale()));

                break;
            case "Compétences de tir":
                etNomComplet.setText(String.valueOf(ListeAModifier.get(postionliste).getNomComplet()));
                etDegats.setText(String.valueOf(ListeAModifier.get(postionliste).getDegats()));
                etEntrainementPoint.setText(String.valueOf(ListeAModifier.get(postionliste).getEntrainementPoint()));
                etRegleSpeciale.setText(String.valueOf(ListeAModifier.get(postionliste).getRegleSpeciale()));

                break;
            case "Compétences":
            case "Compétences utilisées":
            case "Compétences complexes":
                etAbreviation.setText(String.valueOf(ListeAModifier.get(postionliste).getAbrev()));
                etNomComplet.setText(String.valueOf(ListeAModifier.get(postionliste).getNomComplet()));
                etPointActuel.setText(String.valueOf(ListeAModifier.get(postionliste).getPointActuel()));
                etInitiation.setText(String.valueOf(ListeAModifier.get(postionliste).getInitiation()));
                etEntrainement.setText(String.valueOf(ListeAModifier.get(postionliste).getEntrainement()));
                etMaitrise.setText(String.valueOf(ListeAModifier.get(postionliste).getMaitrise()));
                etInitiationPoint.setText(String.valueOf(ListeAModifier.get(postionliste).getInitiationPoint()));
                etEntrainementPoint.setText(String.valueOf(ListeAModifier.get(postionliste).getEntrainementPoint()));
                etMaitrisePoint.setText(String.valueOf(ListeAModifier.get(postionliste).getMaitrisePoint()));

                break;

            case "Sortilèges":
                etAbreviation.setText(String.valueOf(ListeAModifier.get(postionliste).getAbrev()));
                etNomComplet.setText(String.valueOf(ListeAModifier.get(postionliste).getNomComplet()));
                etDegats.setText(String.valueOf(ListeAModifier.get(postionliste).getDegats()));
                etRegleSpeciale.setText(String.valueOf(ListeAModifier.get(postionliste).getRegleSpeciale()));
                etInitiation.setText(String.valueOf(ListeAModifier.get(postionliste).getInitiation()));
                etEntrainement.setText(String.valueOf(ListeAModifier.get(postionliste).getEntrainement()));
                etMaitrise.setText(String.valueOf(ListeAModifier.get(postionliste).getMaitrise()));
                etInitiationPoint.setText(String.valueOf(ListeAModifier.get(postionliste).getInitiationPoint()));
                etEntrainementPoint.setText(String.valueOf(ListeAModifier.get(postionliste).getEntrainementPoint()));
                etMaitrisePoint.setText(String.valueOf(ListeAModifier.get(postionliste).getMaitrisePoint()));
                etNomComplet.setText("");
                etNomComplet.setEnabled(false);
                etNomComplet.setVisibility(View.INVISIBLE);
                break;
                //g
            default:


        }


    }
}