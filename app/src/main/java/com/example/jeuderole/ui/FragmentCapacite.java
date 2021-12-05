package com.example.jeuderole.ui;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;

import android.widget.LinearLayout;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.example.jeuderole.Adapter.AdapterCapacite;
import com.example.jeuderole.AdatperTitre.AdapterTitre;
import com.example.jeuderole.R;
import com.example.jeuderole.db.dao.JeuRoleDao;
import com.example.jeuderole.models.Capacite;

import java.util.ArrayList;
import java.util.List;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link FragmentCapacite#newInstance} factory method to
 * create an instance of this fragment.
 */
public class FragmentCapacite extends Fragment implements AdapterView.OnItemSelectedListener {
    // TODO: Rename parameter arguments, choose names that match
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private TextView tvAbreviation, tvNomComplet, tvCapaciteMaximum, tvcategorie, tvDegats, tvPointActuel,
            tvInitiation, tvEntrainement, tvMaitrise, tvInitiationPoint, tvEntrainementPoint, tvMaitrisePoint, tvRegleSpeciale;
private Integer tailleTextView;
private static final Integer  hauteur_Tv = 43 ;
    private String mParam1;
    private String mParam2;
    private RecyclerView rvActivite,rvActiviteTitre;
    private JeuRoleDao dao;
    private List<Capacite> listecapacitetitre = new ArrayList<>();
    private List<Capacite> listecapacite = new ArrayList<>();
    private Capacite capacite;
    private Spinner spinnerDiffCompetences;
    private LinearLayout lltitreun, lltitredeux;
    private static final String[] titlename = new String[] {"Catégorie","Abrév.","Nom","Point Max","Dégats","Point Actuel","Règle Spéciale","Initiation","Entraînement","Maîtrise","Point Initiation","Point Entrain.","Point Maîtrise"};


    public FragmentCapacite() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment FragmentCapacite.
     */
    // TODO: Rename and change types and number of parameters
    public static FragmentCapacite newInstance(String param1, String param2) {
        FragmentCapacite fragment = new FragmentCapacite();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_capacite, container, false);

        rvActivite = v.findViewById(R.id.rv_capacite);
        rvActiviteTitre = v.findViewById(R.id.rv_titrecapacite);
        spinnerDiffCompetences = v.findViewById(R.id.sp_capacite_categoriePersonnage);



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

        //dao = new JeuRoleDao(getContext());
        //dao.openReadable();
        //listecapacite = dao.getAll();
        ///dao.close();

        //AdapterCapacite adapater = new AdapterCapacite(getContext(), listecapacite);
        //rvActivite.setAdapter(adapater);
        //LinearLayoutManager llm = new LinearLayoutManager(getContext());
        //llm.setOrientation(RecyclerView.VERTICAL);
        //rvActivite.setLayoutManager(llm);

        return v;
    }

    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
        Log.d("LISTENNER", spinnerDiffCompetences.getSelectedItem().toString());
        Toast.makeText(getContext(),spinnerDiffCompetences.getSelectedItem().toString(),Toast.LENGTH_LONG).show();

        dao = new JeuRoleDao(getContext());
        dao.openReadable();
        listecapacite = dao.getAllWithCategorie(spinnerDiffCompetences.getSelectedItem().toString());
        dao.close();


        Capacite capaciteItem = new Capacite("a", "a","a",0);
        listecapacitetitre.add(capaciteItem);
        AdapterTitre adapterT = new AdapterTitre(getContext(), listecapacite);
        rvActiviteTitre.setAdapter(adapterT);
        LinearLayoutManager llmt = new LinearLayoutManager(getContext());
        llmt.setOrientation(RecyclerView.VERTICAL);
        rvActiviteTitre.setLayoutManager(llmt);

        AdapterCapacite adapater = new AdapterCapacite(getContext(), listecapacite);
        rvActivite.setAdapter(adapater);
        LinearLayoutManager llm = new LinearLayoutManager(getContext());
        llm.setOrientation(RecyclerView.VERTICAL);
        rvActivite.setLayoutManager(llm);

    }



    @Override
    public void onNothingSelected(AdapterView<?> parent) {

    }
}