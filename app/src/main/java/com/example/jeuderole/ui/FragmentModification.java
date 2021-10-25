package com.example.jeuderole.ui;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Patterns;
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
import java.util.regex.Pattern;
import java.util.regex.PatternSyntaxException;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link FragmentModification#newInstance} factory method to
 * create an instance of this fragment.
 */
public class FragmentModification extends Fragment implements AdapterView.OnItemSelectedListener, View.OnClickListener {

    private Button btReinitialiser, btModifier, btMiseAZero, btAjouter;
    private Button btSuivant, btPrecedent;
    private Button btDebut, btFin;
    private TextView tvIndex;
    private Spinner spinnerDiffCompetences;
    private List<Capacite> ListeAModifier = new ArrayList<>();
    private Integer positionliste = 0;
    private JeuRoleDao dao;
    private Integer maxIdListeCapacite = 0;
    private EditText etId, etAbreviation, etCategorie, etNomComplet, etMaxPoint, etDegats, etPointActuel, etRegleSpeciale,
            etInitiation, etEntrainement, etMaitrise, etInitiationPoint, etEntrainementPoint, etMaitrisePoint;
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
        btReinitialiser = v.findViewById(R.id.bt_capacitemodification_reinitialisation);
        btMiseAZero = v.findViewById(R.id.bt_capacitemodification_miseazero);
        btAjouter = v.findViewById(R.id.bt_capacitemodification_ajouter);
        btModifier = v.findViewById(R.id.bt_capacitemodification_modifier);
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

        btReinitialiser.setOnClickListener(this);
        btModifier.setOnClickListener(this);
        btMiseAZero.setOnClickListener(this);
        btAjouter.setOnClickListener(this);
        return v;
    }

    private void MettrePaddingZero() {
        etId.setPadding(0, 0, 0, 0);
        etAbreviation.setPadding(0, 0, 0, 0);
        etCategorie.setPadding(0, 0, 0, 0);
        etNomComplet.setPadding(0, 0, 0, 0);
        etMaxPoint.setPadding(0, 0, 0, 0);
        etDegats.setPadding(0, 0, 0, 0);
        etPointActuel.setPadding(0, 0, 0, 0);
        etRegleSpeciale.setPadding(0, 0, 0, 0);
        etInitiation.setPadding(0, 0, 0, 0);
        etEntrainement.setPadding(0, 0, 0, 0);
        etMaitrise.setPadding(0, 0, 0, 0);
        etInitiationPoint.setPadding(0, 0, 0, 0);
        etEntrainementPoint.setPadding(0, 0, 0, 0);
        etMaitrisePoint.setPadding(0, 0, 0, 0);
    }

    private void RendreTextInvisible() {
        etId.setVisibility(View.INVISIBLE);
        etAbreviation.setVisibility(View.INVISIBLE);
        etCategorie.setVisibility(View.INVISIBLE);
        etNomComplet.setVisibility(View.INVISIBLE);
        etMaxPoint.setVisibility(View.INVISIBLE);
        etDegats.setVisibility(View.INVISIBLE);
        etPointActuel.setVisibility(View.INVISIBLE);
        etRegleSpeciale.setVisibility(View.INVISIBLE);
        etInitiation.setVisibility(View.INVISIBLE);
        etEntrainement.setVisibility(View.INVISIBLE);
        etMaitrise.setVisibility(View.INVISIBLE);
        etInitiationPoint.setVisibility(View.INVISIBLE);
        etEntrainementPoint.setVisibility(View.INVISIBLE);
        etMaitrisePoint.setVisibility(View.INVISIBLE);
    }

    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
        RendreTextInvisible();
        MettrePaddingZero();

        ListeAModifier.clear();

        dao = new JeuRoleDao(getContext());
        dao.openReadable();
        categorieSelectionnee = spinnerDiffCompetences.getSelectedItem().toString();
        ListeAModifier = dao.getAllWithCategorie(categorieSelectionnee);
        dao.close();
        maxIdListeCapacite = ListeAModifier.size() - 1;

        positionliste = 0;
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
                if (positionliste != 0) {
                    if (maxIdListeCapacite == -1) {
                        Toast.makeText(getContext(), "Pas d'enregistrement !!!", Toast.LENGTH_LONG).show();
                    } else {
                        positionliste = positionliste - 1;
                        Afficherdonnee();
                    }
                } else {
                    Toast.makeText(getContext(), "Debut du fichier", Toast.LENGTH_LONG).show();
                }
                break;
            case R.id.bt_capacitemodification_suivant:
                if (!positionliste.equals(maxIdListeCapacite)) {
                    if (maxIdListeCapacite == -1) {
                        Toast.makeText(getContext(), "Pas d'enregistrement !!!", Toast.LENGTH_LONG).show();
                    } else {
                        positionliste = positionliste + 1;
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
                    positionliste = 0;
                    Afficherdonnee();
                }
                break;
            case R.id.bt_capacitemodification_fin:

                if (maxIdListeCapacite == -1) {
                    Toast.makeText(getContext(), "Pas d'enregistrement !!!", Toast.LENGTH_LONG).show();
                } else {
                    positionliste = maxIdListeCapacite;
                    Afficherdonnee();
                }
                break;
            case R.id.bt_capacitemodification_reinitialisation:
                Afficherdonnee();
                break;
            case R.id.bt_capacitemodification_miseazero:
                MiseAzero();
                break;
            case R.id.bt_capacitemodification_modifier:
                Updatebsd();

                break;
            case R.id.bt_capacitemodification_ajouter:

                break;
        }
    }

    private void Updatebsd() {



        Boolean testErreur = false;
        Long idCapacite = Long.valueOf(etId.getText().toString());
        String tmpmaxpointstr = etMaxPoint.getText().toString().trim();
        String tmppointactuelstr = etPointActuel.getText().toString().trim();
        String tmppointinitiationstr = etInitiationPoint.getText().toString().trim();
        String tmppointentrainementstr = etEntrainementPoint.getText().toString().trim();
        String tmppointmaitrisestr = etMaitrisePoint.getText().toString().trim();

        tmpmaxpointstr = tmpmaxpointstr.isEmpty() ? "0" : tmpmaxpointstr;
        tmppointactuelstr = tmppointactuelstr.isEmpty() ? "0" : tmppointactuelstr;
        tmppointinitiationstr = tmppointinitiationstr.isEmpty() ? "0" : tmppointinitiationstr;
        tmppointentrainementstr = tmppointentrainementstr.isEmpty() ? "0" : tmppointentrainementstr;
        tmppointmaitrisestr = tmppointmaitrisestr.isEmpty() ? "0" : tmppointmaitrisestr;

        Integer tmpmaxpointint = null;
        Integer tmppointactuelint = null;
        Integer tmppointinitiationint = null;
        Integer tmppointentrainementint = null;
        Integer tmppointmaitriseint = null;

        if (Pattern.matches("^[0-9]+$", tmpmaxpointstr)) {
            tmpmaxpointint = Integer.valueOf(tmpmaxpointstr);
        } else {
            Toast.makeText(getContext(), "Données non valide !!!", Toast.LENGTH_LONG).show();
            testErreur = true;
        }

        if (Pattern.matches("^[0-9]+$", tmppointactuelstr)) {
            tmppointactuelint = Integer.valueOf(tmppointactuelstr);
        } else {
            Toast.makeText(getContext(), "Données non valide !!!", Toast.LENGTH_LONG).show();
            testErreur = true;
        }

        if (Pattern.matches("^[0-9]+$", tmppointinitiationstr)) {
            tmppointinitiationint = Integer.valueOf(tmppointinitiationstr);
        } else {
            Toast.makeText(getContext(), "Données non valide !!!", Toast.LENGTH_LONG).show();
            testErreur = true;
        }

        if (Pattern.matches("^[0-9]+$", tmppointentrainementstr)) {
            tmppointentrainementint = Integer.valueOf(tmppointentrainementstr);
        } else {
            Toast.makeText(getContext(), "Données non valide !!!", Toast.LENGTH_LONG).show();
            testErreur = true;
        }

        if (Pattern.matches("^[0-9]+$", tmppointmaitrisestr)) {
            tmppointmaitriseint = Integer.valueOf(tmppointmaitrisestr);
        } else {
            Toast.makeText(getContext(), "Données non valide !!!", Toast.LENGTH_LONG).show();
            testErreur = true;
        }


        if (testErreur == false) {


            dao.openWritable();
            Capacite capaciteItem = new Capacite(etCategorie.getText().toString(), etAbreviation.getText().toString(),
                    etNomComplet.getText().toString(), tmpmaxpointint, etDegats.getText().toString(), tmppointactuelint, etRegleSpeciale.getText().toString(),
                    etInitiation.getText().toString(), etEntrainement.getText().toString(), etMaitrise.getText().toString(),
                    tmppointinitiationint, tmppointentrainementint, tmppointmaitriseint);
            dao.update(idCapacite, capaciteItem);
            dao.close();

            ListeAModifier.set(positionliste,capaciteItem);


        }
    }

    private void MiseAzero() {
        etId.setText("");
        etAbreviation.setText("");
        etCategorie.setText("");
        etNomComplet.setText("");
        etMaxPoint.setText("");
        etDegats.setText("");
        etPointActuel.setText("");
        etRegleSpeciale.setText("");
        etInitiation.setText("");
        etEntrainement.setText("");
        etMaitrise.setText("");
        etInitiationPoint.setText("");
        etEntrainementPoint.setText("");
        etMaitrisePoint.setText("");
    }

    private void Afficherdonnee() {
        MiseAzero();
        tvIndex.setText(String.valueOf(positionliste));

        etNomComplet.setText("");
//        etId.setText(String.valueOf(ListeAModifier.get(positionliste).getId()));
//        etAbreviation.setText(String.valueOf(ListeAModifier.get(positionliste).getAbrev()));
//        etCategorie.setText(String.valueOf(ListeAModifier.get(positionliste).getCategorie()));
//        etNomComplet.setText(String.valueOf(ListeAModifier.get(positionliste).getNomComplet()));
//        etMaxPoint.setText(String.valueOf(ListeAModifier.get(positionliste).getMaxPoints()));
//        etDegats.setText(String.valueOf(ListeAModifier.get(positionliste).getDegats()));
//        etPointActuel.setText(String.valueOf(ListeAModifier.get(positionliste).getPointActuel()));
//        etRegleSpeciale.setText(String.valueOf(ListeAModifier.get(positionliste).getRegleSpeciale()));
//        etInitiation.setText(String.valueOf(ListeAModifier.get(positionliste).getInitiation()));
//        etEntrainement.setText(String.valueOf(ListeAModifier.get(positionliste).getEntrainement()));
//        etMaitrise.setText(String.valueOf(ListeAModifier.get(positionliste).getMaitrise()));
//        etInitiationPoint.setText(String.valueOf(ListeAModifier.get(positionliste).getInitiationPoint()));
//        etEntrainementPoint.setText(String.valueOf(ListeAModifier.get(positionliste).getEntrainementPoint()));
//        etMaitrisePoint.setText(String.valueOf(ListeAModifier.get(positionliste).getMaitrisePoint()));

        switch (categorieSelectionnee) {

            case "Capacités":
                etCategorie.setText(String.valueOf(ListeAModifier.get(positionliste).getCategorie()));
                etAbreviation.setText(String.valueOf(ListeAModifier.get(positionliste).getAbrev()));
                etNomComplet.setText(String.valueOf(ListeAModifier.get(positionliste).getNomComplet()));
                etMaxPoint.setText(String.valueOf(ListeAModifier.get(positionliste).getMaxPoints()));

                etAbreviation.setVisibility(View.VISIBLE);
                etNomComplet.setVisibility(View.VISIBLE);
                etMaxPoint.setVisibility(View.VISIBLE);

                break;
            case "5 Sens":
                etCategorie.setText(String.valueOf(ListeAModifier.get(positionliste).getCategorie()));
                etNomComplet.setText(String.valueOf(ListeAModifier.get(positionliste).getNomComplet()));
                etMaxPoint.setText(String.valueOf(ListeAModifier.get(positionliste).getMaxPoints()));

                etNomComplet.setVisibility(View.VISIBLE);
                etMaxPoint.setVisibility(View.VISIBLE);
                break;
            case "Compétences de combat":
                etCategorie.setText(String.valueOf(ListeAModifier.get(positionliste).getCategorie()));
                etNomComplet.setText(String.valueOf(ListeAModifier.get(positionliste).getNomComplet()));
                etDegats.setText(String.valueOf(ListeAModifier.get(positionliste).getDegats()));
                etRegleSpeciale.setText(String.valueOf(ListeAModifier.get(positionliste).getRegleSpeciale()));

                etNomComplet.setVisibility(View.VISIBLE);
                etDegats.setVisibility(View.VISIBLE);
                etRegleSpeciale.setVisibility(View.VISIBLE);
                break;
            case "Compétences de tir":
                etCategorie.setText(String.valueOf(ListeAModifier.get(positionliste).getCategorie()));
                etNomComplet.setText(String.valueOf(ListeAModifier.get(positionliste).getNomComplet()));
                etDegats.setText(String.valueOf(ListeAModifier.get(positionliste).getDegats()));
                etEntrainementPoint.setText(String.valueOf(ListeAModifier.get(positionliste).getEntrainementPoint()));
                etRegleSpeciale.setText(String.valueOf(ListeAModifier.get(positionliste).getRegleSpeciale()));

                etNomComplet.setVisibility(View.VISIBLE);
                etDegats.setVisibility(View.VISIBLE);
                etEntrainementPoint.setVisibility(View.VISIBLE);
                etRegleSpeciale.setVisibility(View.VISIBLE);
                break;
            case "Compétences":
            case "Compétences utilisées":
            case "Compétences complexes":
                etCategorie.setText(String.valueOf(ListeAModifier.get(positionliste).getCategorie()));
                etAbreviation.setText(String.valueOf(ListeAModifier.get(positionliste).getAbrev()));
                etNomComplet.setText(String.valueOf(ListeAModifier.get(positionliste).getNomComplet()));
                etPointActuel.setText(String.valueOf(ListeAModifier.get(positionliste).getPointActuel()));
                etInitiation.setText(String.valueOf(ListeAModifier.get(positionliste).getInitiation()));
                etEntrainement.setText(String.valueOf(ListeAModifier.get(positionliste).getEntrainement()));
                etMaitrise.setText(String.valueOf(ListeAModifier.get(positionliste).getMaitrise()));
                etInitiationPoint.setText(String.valueOf(ListeAModifier.get(positionliste).getInitiationPoint()));
                etEntrainementPoint.setText(String.valueOf(ListeAModifier.get(positionliste).getEntrainementPoint()));
                etMaitrisePoint.setText(String.valueOf(ListeAModifier.get(positionliste).getMaitrisePoint()));

                etAbreviation.setVisibility(View.VISIBLE);
                etNomComplet.setVisibility(View.VISIBLE);
                etPointActuel.setVisibility(View.VISIBLE);
                etInitiation.setVisibility(View.VISIBLE);
                etEntrainement.setVisibility(View.VISIBLE);
                etMaitrise.setVisibility(View.VISIBLE);
                etInitiationPoint.setVisibility(View.VISIBLE);
                etEntrainementPoint.setVisibility(View.VISIBLE);
                etMaitrisePoint.setVisibility(View.VISIBLE);
                break;

            case "Sortilèges":
                etCategorie.setText(String.valueOf(ListeAModifier.get(positionliste).getCategorie()));
                etId.setText(String.valueOf(ListeAModifier.get(positionliste).getId()));
                etAbreviation.setText(String.valueOf(ListeAModifier.get(positionliste).getAbrev()));
                etNomComplet.setText(String.valueOf(ListeAModifier.get(positionliste).getNomComplet()));
                etDegats.setText(String.valueOf(ListeAModifier.get(positionliste).getDegats()));
                etRegleSpeciale.setText(String.valueOf(ListeAModifier.get(positionliste).getRegleSpeciale()));
                etInitiation.setText(String.valueOf(ListeAModifier.get(positionliste).getInitiation()));
                etEntrainement.setText(String.valueOf(ListeAModifier.get(positionliste).getEntrainement()));
                etMaitrise.setText(String.valueOf(ListeAModifier.get(positionliste).getMaitrise()));
                etInitiationPoint.setText(String.valueOf(ListeAModifier.get(positionliste).getInitiationPoint()));
                etEntrainementPoint.setText(String.valueOf(ListeAModifier.get(positionliste).getEntrainementPoint()));
                etMaitrisePoint.setText(String.valueOf(ListeAModifier.get(positionliste).getMaitrisePoint()));

                etId.setVisibility(View.VISIBLE);
                etAbreviation.setVisibility(View.VISIBLE);
                etNomComplet.setVisibility(View.VISIBLE);
                etDegats.setVisibility(View.VISIBLE);
                etRegleSpeciale.setVisibility(View.VISIBLE);
                etInitiation.setVisibility(View.VISIBLE);
                etEntrainement.setVisibility(View.VISIBLE);
                etMaitrise.setVisibility(View.VISIBLE);
                etInitiationPoint.setVisibility(View.VISIBLE);
                etEntrainementPoint.setVisibility(View.VISIBLE);
                etMaitrisePoint.setVisibility(View.VISIBLE);
                break;
            default:


        }


    }
}