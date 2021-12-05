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
private Long IdActuel = Long.valueOf("0");
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
    //variable controle champs
    Boolean testErreur = false;
    Integer tmpmaxpointint = null;
    Integer tmppointactuelint = null;
    Integer tmppointinitiationint = null;
    Integer tmppointentrainementint = null;
    Integer tmppointmaitriseint = null;
    private String positionbuttonAddDel ="Supprimer";

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
        //etCategorie = v.findViewById(R.id.et_capacitemodification_categorie);
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
        Inititialisation();

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

    private void Inititialisation() {
        RendreTextInvisible();
        MettrePaddingZero();
        btAjouter.setVisibility(View.VISIBLE);

        ListeAModifier.clear();
        dao = new JeuRoleDao(getContext());
        dao.openReadable();

        categorieSelectionnee = "Capacités";
        ListeAModifier = dao.getAllWithCategorie(categorieSelectionnee);
        dao.close();
        maxIdListeCapacite = ListeAModifier.size() - 1;


        positionliste = 0;
        if (maxIdListeCapacite >= 0) {
            Afficherdonnee();
        }
    }

    private void MettrePaddingZero() {
        etId.setPadding(0, 0, 0, 0);
        etAbreviation.setPadding(0, 0, 0, 0);
        //etCategorie.setPadding(0, 0, 0, 0);
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
        //etCategorie.setVisibility(View.INVISIBLE);
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
        CategorieSelectionnee();

    }

    private void CategorieSelectionnee() {
        RendreTextInvisible();
        MettrePaddingZero();
        positionbuttonAddDel = "Supprimer";
        Apparencebouton(positionbuttonAddDel);


        btMiseAZero.setVisibility(View.VISIBLE);
        MiseAJourBDD();
        positionliste = 0;
        if (maxIdListeCapacite >= 0) {
            Afficherdonnee();
        }
        String nbrEnregistrement = String.valueOf(maxIdListeCapacite+1) + " enregistrements";
        Toast.makeText(getView().getContext(), nbrEnregistrement , Toast.LENGTH_SHORT).show();
    }

    private void Apparencebouton(String position) {
        if (position=="Supprimer"){
            btAjouter.setText("Supprimer");
            btMiseAZero.setVisibility(View.VISIBLE);
        }
        if (position=="Ajouter"){
            btAjouter.setText("Ajouter");
            btMiseAZero.setVisibility(View.INVISIBLE);
        }
    }

    private void MiseAJourBDD() {
        ListeAModifier.clear();
        dao = new JeuRoleDao(getContext());
        dao.openReadable();
        categorieSelectionnee = spinnerDiffCompetences.getSelectedItem().toString();
        ListeAModifier = dao.getAllWithCategorie(categorieSelectionnee);
        dao.close();
        maxIdListeCapacite = ListeAModifier.size() - 1;
    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.bt_capacitemodification_precedent:
                positionbuttonAddDel = "Supprimer";
                Apparencebouton(positionbuttonAddDel);
                if (maxIdListeCapacite == -2) {
                    MiseAJourBDD();
                }
                if (positionliste != 0) {
                    if (maxIdListeCapacite == -1) {
                        Toast.makeText(getContext(), "Pas d'enregistrement !!!", Toast.LENGTH_SHORT).show();
                        MiseaZeroCasDelete();
                    } else {
                        positionliste = positionliste - 1;
                        Afficherdonnee();
                    }
                } else {
                    Toast.makeText(getContext(), "Debut du fichier", Toast.LENGTH_SHORT).show();
                }
                break;
            case R.id.bt_capacitemodification_suivant:
                positionbuttonAddDel = "Supprimer";
                Apparencebouton(positionbuttonAddDel);
                if (maxIdListeCapacite == -2) {
                    MiseAJourBDD();
                }
                if (!positionliste.equals(maxIdListeCapacite)) {
                    if (maxIdListeCapacite == -1) {
                        Toast.makeText(getContext(), "Pas d'enregistrement !!!", Toast.LENGTH_SHORT).show();
                        MiseaZeroCasDelete();
                    } else {
                        positionliste = positionliste + 1;
                        Afficherdonnee();
                    }
                } else {
                    Toast.makeText(getContext(), "Fin du fichier", Toast.LENGTH_SHORT).show();
                }
                break;
            case R.id.bt_capacitemodification_debut:
                positionbuttonAddDel = "Supprimer";
                Apparencebouton(positionbuttonAddDel);
                if (maxIdListeCapacite == -2) {
                    MiseAJourBDD();
                }
                if (maxIdListeCapacite == -1) {
                    Toast.makeText(getContext(), "Pas d'enregistrement !!!", Toast.LENGTH_SHORT).show();
                    MiseaZeroCasDelete();
                } else {
                    positionliste = 0;
                    Afficherdonnee();
                }
                break;
            case R.id.bt_capacitemodification_fin:
                positionbuttonAddDel = "Supprimer";
                Apparencebouton(positionbuttonAddDel);
                if (maxIdListeCapacite == -2) {
                    MiseAJourBDD();
                }
                if (maxIdListeCapacite == -1) {
                    Toast.makeText(getContext(), "Pas d'enregistrement !!!", Toast.LENGTH_SHORT).show();
                    MiseaZeroCasDelete();

                } else {
                    positionliste = maxIdListeCapacite;
                    Afficherdonnee();
                }
                break;
            case R.id.bt_capacitemodification_reinitialisation:
                Afficherdonnee();
                break;
            case R.id.bt_capacitemodification_miseazero:

                ListeAModifier.clear();
                Capacite capaciteitem = new Capacite(0, categorieSelectionnee, "", "", 0, "", 0, "", "", "", "", 0, 0, 0);
                ListeAModifier.add(capaciteitem);
                maxIdListeCapacite = -2;
                positionliste = 0;
                Afficherdonnee();
                positionbuttonAddDel = "Ajouter";
                Apparencebouton(positionbuttonAddDel);
                etId.setVisibility(View.INVISIBLE);
                break;
            case R.id.bt_capacitemodification_modifier:
                Updatebsd();
                break;
            case R.id.bt_capacitemodification_ajouter:
                if (positionbuttonAddDel =="Supprimer"){
Deletebsd();
                }
                if (positionbuttonAddDel =="Ajouter"){
                AjouterBsd();
                if (!testErreur) {
                    Afficherdonnee();
                    positionbuttonAddDel = "Supprimer";
                    Apparencebouton(positionbuttonAddDel);
                    etId.setVisibility(View.VISIBLE);
                    MiseAJourBDD();
                }}
                break;
        }
    }

    private void MiseaZeroCasDelete() {
        ListeAModifier.clear();
        Capacite capaciteitem = new Capacite(0, categorieSelectionnee, "", "", 0, "", 0, "", "", "", "", 0, 0, 0);
        ListeAModifier.add(capaciteitem);
        maxIdListeCapacite = -2;
        positionliste = 0;
        Afficherdonnee();
        IdActuel = Long.valueOf("-2");
    }

    private void Deletebsd() {
        if (IdActuel!=-2){
        dao.openWritable();
                dao.delete(IdActuel);
        CategorieSelectionnee();
    }}


    private void AjouterBsd() {
        testErreur = controleChamp();

        if (testErreur == false) {


            dao.openWritable();
            Capacite capaciteItem = new Capacite(categorieSelectionnee, etAbreviation.getText().toString(),
                    etNomComplet.getText().toString(), tmpmaxpointint, etDegats.getText().toString(), tmppointactuelint, etRegleSpeciale.getText().toString(),
                    etInitiation.getText().toString(), etEntrainement.getText().toString(), etMaitrise.getText().toString(),
                    tmppointinitiationint, tmppointentrainementint, tmppointmaitriseint);
            dao.insert(capaciteItem);
            dao.close();
            positionliste = 0;
            ListeAModifier.add(capaciteItem);


        }
    }

    private void Updatebsd() {
        testErreur = controleChamp();

        if (testErreur == false) {

            Long idCapacite = IdActuel;

            dao.openWritable();
            Capacite capaciteItem = new Capacite(categorieSelectionnee, etAbreviation.getText().toString(),
                    etNomComplet.getText().toString(), tmpmaxpointint, etDegats.getText().toString(), tmppointactuelint, etRegleSpeciale.getText().toString(),
                    etInitiation.getText().toString(), etEntrainement.getText().toString(), etMaitrise.getText().toString(),
                    tmppointinitiationint, tmppointentrainementint, tmppointmaitriseint);
            dao.update(idCapacite, capaciteItem);
            dao.close();

            ListeAModifier.set(positionliste, capaciteItem);


        }
    }

    private boolean controleChamp() {
        testErreur = false;

        String tmpmaxpointstr = etMaxPoint.getText().toString().trim();
        String tmppointactuelstr = etPointActuel.getText().toString().trim();
        String tmppointinitiationstr = etInitiationPoint.getText().toString().trim();
        String tmppointentrainementstr = etEntrainementPoint.getText().toString().trim();
        String tmppointmaitrisestr = etMaitrisePoint.getText().toString().trim();
        String tmpAbreviation = etAbreviation.getText().toString().trim();
        String tmpNomComplet = etNomComplet.getText().toString().trim();

        tmpmaxpointstr = tmpmaxpointstr.isEmpty() ? "0" : tmpmaxpointstr;
        tmppointactuelstr = tmppointactuelstr.isEmpty() ? "0" : tmppointactuelstr;
        tmppointinitiationstr = tmppointinitiationstr.isEmpty() ? "0" : tmppointinitiationstr;
        tmppointentrainementstr = tmppointentrainementstr.isEmpty() ? "0" : tmppointentrainementstr;
        tmppointmaitrisestr = tmppointmaitrisestr.isEmpty() ? "0" : tmppointmaitrisestr;


        tmpmaxpointint = null;
        tmppointactuelint = null;
        tmppointinitiationint = null;
        tmppointentrainementint = null;
        tmppointmaitriseint = null;

        if (tmpAbreviation.length() > 5) {
            Toast.makeText(getContext(), "Longueur abréviation trop longue (max 5 caractères !!!)", Toast.LENGTH_LONG).show();
            testErreur = true;
        }
        if (tmpNomComplet.length() > 40) {
            Toast.makeText(getContext(), "Longueur abréviation trop longue (max 40 caractères !!!)", Toast.LENGTH_LONG).show();
            testErreur = true;
        }
//TODO faire les diffèrents controles possible et inimaginable


        if (Pattern.matches("^[0-9]+$", tmpmaxpointstr)) {
            tmpmaxpointint = Integer.valueOf(tmpmaxpointstr);
        } else {
            Toast.makeText(getContext(), "Points Max non valide !!!", Toast.LENGTH_SHORT).show();
            testErreur = true;
        }

        if (Pattern.matches("^[0-9]+$", tmppointactuelstr)) {
            tmppointactuelint = Integer.valueOf(tmppointactuelstr);
        } else {
            Toast.makeText(getContext(), "Points actuels non valide !!!", Toast.LENGTH_SHORT).show();
            testErreur = true;
        }

        if (Pattern.matches("^[0-9]+$", tmppointinitiationstr)) {
            tmppointinitiationint = Integer.valueOf(tmppointinitiationstr);
        } else {
            Toast.makeText(getContext(), "Points Initiation non valide !!!", Toast.LENGTH_SHORT).show();
            testErreur = true;
        }

        if (Pattern.matches("^[0-9]+$", tmppointentrainementstr)) {
            tmppointentrainementint = Integer.valueOf(tmppointentrainementstr);
        } else {
            Toast.makeText(getContext(), "Points entrainement non valide !!!", Toast.LENGTH_SHORT).show();
            testErreur = true;
        }

        if (Pattern.matches("^[0-9]+$", tmppointmaitrisestr)) {
            tmppointmaitriseint = Integer.valueOf(tmppointmaitrisestr);
        } else {
            Toast.makeText(getContext(), "Point Maîtrise non valide !!!", Toast.LENGTH_SHORT).show();
            testErreur = true;
        }
        return testErreur;
    }


    private void MiseAzero() {
        etId.setText("");
        etAbreviation.setText("");
        // etCategorie.setText("");
        etNomComplet.setText("");
        etMaxPoint.setText("0");
        etDegats.setText("");
        etPointActuel.setText("0");
        etRegleSpeciale.setText("");
        etInitiation.setText("");
        etEntrainement.setText("");
        etMaitrise.setText("");
        etInitiationPoint.setText("0");
        etEntrainementPoint.setText("0");
        etMaitrisePoint.setText("0");


    }

    private void Afficherdonnee() {
        MiseAzero();
        tvIndex.setText(String.valueOf(positionliste));
        IdActuel = ListeAModifier.get(positionliste).getId();
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

                etAbreviation.setText(String.valueOf(ListeAModifier.get(positionliste).getAbrev()));
                etNomComplet.setText(String.valueOf(ListeAModifier.get(positionliste).getNomComplet()));
                etMaxPoint.setText(String.valueOf(ListeAModifier.get(positionliste).getMaxPoints()));

                etAbreviation.setVisibility(View.VISIBLE);
                etNomComplet.setVisibility(View.VISIBLE);
                etMaxPoint.setVisibility(View.VISIBLE);

                break;
            case "5 Sens":
                //etCategorie.setText(String.valueOf(ListeAModifier.get(positionliste).getCategorie()));
                etNomComplet.setText(String.valueOf(ListeAModifier.get(positionliste).getNomComplet()));
                etMaxPoint.setText(String.valueOf(ListeAModifier.get(positionliste).getMaxPoints()));

                etNomComplet.setVisibility(View.VISIBLE);
                etMaxPoint.setVisibility(View.VISIBLE);
                break;
            case "Compétences de combat":
                //etCategorie.setText(String.valueOf(ListeAModifier.get(positionliste).getCategorie()));
                etNomComplet.setText(String.valueOf(ListeAModifier.get(positionliste).getNomComplet()));
                etDegats.setText(String.valueOf(ListeAModifier.get(positionliste).getDegats()));
                etRegleSpeciale.setText(String.valueOf(ListeAModifier.get(positionliste).getRegleSpeciale()));

                etNomComplet.setVisibility(View.VISIBLE);
                etDegats.setVisibility(View.VISIBLE);
                etRegleSpeciale.setVisibility(View.VISIBLE);
                break;
            case "Compétences de tir":
                //etCategorie.setText(String.valueOf(ListeAModifier.get(positionliste).getCategorie()));
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
                //etCategorie.setText(String.valueOf(ListeAModifier.get(positionliste).getCategorie()));
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
                //etCategorie.setText(String.valueOf(ListeAModifier.get(positionliste).getCategorie()));
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