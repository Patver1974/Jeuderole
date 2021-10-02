package com.example.jeuderole.ui;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
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
    private TextView tvIndex;
    private Spinner spinnerDiffCompetences;
    private List<Capacite> ListeAModifier = new ArrayList<>();
    private Integer postionliste = 0;
    private JeuRoleDao dao;
    private Integer maxIdListeCapacite = 0;

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
        tvIndex = v.findViewById(R.id.tv_capacitemodification_index);
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

        return v;
    }

    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
        ListeAModifier.clear();
        dao = new JeuRoleDao(getContext());
        dao.openReadable();
        ListeAModifier = dao.getAllWithCategorie(spinnerDiffCompetences.getSelectedItem().toString());
        dao.close();
        maxIdListeCapacite = ListeAModifier.size() - 1;

        postionliste = 0;
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
        }
    }

    private void Afficherdonnee() {
        tvIndex.setText(String.valueOf(postionliste));
    }
}