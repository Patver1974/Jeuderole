package com.example.jeuderole.ui;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ListView;
import android.widget.TextView;

import com.example.jeuderole.R;

import java.util.ArrayList;
import java.util.Random;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link FragmentDe#newInstance} factory method to
 * create an instance of this fragment.
 */
public class FragmentDe extends Fragment implements View.OnClickListener {


    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";
    private ArrayList<String> listeHistorique = new ArrayList<>();
    private Button btDe6, btDe12, btDe100;
    private ImageButton ibFaceun, ibFaceDeux;
    private TextView tvAffichageNombre;
    private ArrayAdapter<String> adapter ;
    private Integer nbAleatoire = 0;
    private String mParam1;
    private String mParam2;
private ListView lvHistorique;

    public FragmentDe() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment FragmentDe.
     */
    // TODO: Rename and change types and number of parameters
    public static FragmentDe newInstance(String param1, String param2) {
        FragmentDe fragment = new FragmentDe();
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
        View v = inflater.inflate(R.layout.fragment_de, container, false);
        lvHistorique = v.findViewById(R.id.lv_de_listeview);
        btDe6 = v.findViewById(R.id.bt_de_de6);
        btDe12 = v.findViewById(R.id.bt_de_de12);
        btDe100 = v.findViewById(R.id.bt_de_de100);
        tvAffichageNombre = v.findViewById(R.id.tv_de_affichagenumerique);
        ibFaceun = v.findViewById(R.id.ib_de_faceDeUn);
        ibFaceDeux = v.findViewById(R.id.ib_de_faceDeDeux);

        btDe6.setOnClickListener(this);
        btDe12.setOnClickListener(this);
        btDe100.setOnClickListener(this);

        adapter = new ArrayAdapter<>(
                getContext(),
                android.R.layout.simple_list_item_1,
                android.R.id.text1,
                listeHistorique
        );
        lvHistorique.setAdapter(adapter);
        return v;
    }


    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.bt_de_de6:
                nbAleatoire = 0;
                GenerateNumber(1, 6);

                AffichageImageDe6et12(nbAleatoire);
                break;
            case R.id.bt_de_de12:
                nbAleatoire = 0;
                GenerateNumber(2, 12);

                AffichageImageDe6et12(nbAleatoire);
                break;
            case R.id.bt_de_de100:
                nbAleatoire = 0;
                GenerateNumber(2, 100);

                AffichageImageDe100(nbAleatoire);
                break;

        }
    }

    private void AffichageImageDe100(Integer nbAleatoire) {
        ibFaceun.setImageBitmap(null);
        ibFaceun.setVisibility(View.VISIBLE);
        ibFaceDeux.setImageBitmap(null);
        ibFaceDeux.setVisibility(View.VISIBLE);
        if (nbAleatoire < 10) {
            ibFaceun.setImageResource(R.drawable.de0);
        }
        if (nbAleatoire < 20 && nbAleatoire >= 10) {
            ibFaceun.setImageResource(R.drawable.de10);
            nbAleatoire = nbAleatoire - 10;
        }
        if (nbAleatoire < 30 && nbAleatoire >= 20) {
            ibFaceun.setImageResource(R.drawable.de20);
            nbAleatoire = nbAleatoire - 20;
        }
        if (nbAleatoire < 40 && nbAleatoire >= 30) {
            ibFaceun.setImageResource(R.drawable.de30);
            nbAleatoire = nbAleatoire - 30;
        }
        if (nbAleatoire < 50 && nbAleatoire >= 40) {
            ibFaceun.setImageResource(R.drawable.de40);
            nbAleatoire = nbAleatoire - 40;
        }
        if (nbAleatoire < 60 && nbAleatoire >= 50) {
            ibFaceun.setImageResource(R.drawable.de50);
            nbAleatoire = nbAleatoire - 50;
        }
        if (nbAleatoire < 70 && nbAleatoire >= 60) {
            ibFaceun.setImageResource(R.drawable.de60);
            nbAleatoire = nbAleatoire - 60;
        }
        if (nbAleatoire < 80 && nbAleatoire >= 70) {
            ibFaceun.setImageResource(R.drawable.de70);
            nbAleatoire = nbAleatoire - 70;
        }
        if (nbAleatoire < 90 && nbAleatoire >= 80) {
            ibFaceun.setImageResource(R.drawable.de80);
            nbAleatoire = nbAleatoire - 80;
        }
        if (nbAleatoire < 100 && nbAleatoire >= 90) {
            ibFaceun.setImageResource(R.drawable.de90);
            nbAleatoire = nbAleatoire - 90;
        }
        switch (nbAleatoire) {

            case 0:

                ibFaceDeux.setImageResource(R.drawable.de0);
                break;
            case 1:
                ibFaceDeux.setImageResource(R.drawable.de1);
                break;
            case 2:
                ibFaceDeux.setImageResource(R.drawable.de2);
                break;
            case 3:
                ibFaceDeux.setImageResource(R.drawable.de3);
                break;
            case 4:
                ibFaceDeux.setImageResource(R.drawable.de4);
                break;
            case 5:
                ibFaceDeux.setImageResource(R.drawable.de5);
                break;
            case 6:
                ibFaceDeux.setImageResource(R.drawable.de6);
                break;
            case 7:
                ibFaceDeux.setImageResource(R.drawable.de7);
                break;
            case 8:
                ibFaceDeux.setImageResource(R.drawable.de8);
                ibFaceDeux.setVisibility(View.VISIBLE);
                break;
            case 9:
                ibFaceDeux.setImageResource(R.drawable.de9);
                break;

        }
    }

    private void GenerateNumber(int borneInf, int borneSup) {
        nbAleatoire = 0;
        Random random = new Random();
        borneSup = borneSup + 1;
        nbAleatoire = borneInf + random.nextInt(borneSup - borneInf);
        tvAffichageNombre.setText(String.valueOf(nbAleatoire));
        listeHistorique.add(String.valueOf(nbAleatoire));
        if (listeHistorique.size()>6) {listeHistorique.remove(0);}

        adapter.notifyDataSetChanged();
    }

    private void AffichageImageDe6et12(Integer nbAleatoire) {
        ibFaceDeux.setVisibility(View.VISIBLE);
        switch (nbAleatoire) {
            case 1:
                ibFaceun.setImageResource(R.drawable.de1);
                ibFaceDeux.setVisibility(View.INVISIBLE);
                ibFaceDeux.setImageBitmap(null);
                break;
            case 2:
                ibFaceun.setImageResource(R.drawable.de2);
                ibFaceDeux.setVisibility(View.INVISIBLE);
                ibFaceDeux.setImageBitmap(null);
                break;
            case 3:
                ibFaceun.setImageResource(R.drawable.de3);
                ibFaceDeux.setVisibility(View.INVISIBLE);
                ibFaceDeux.setImageBitmap(null);
                break;
            case 4:
                ibFaceun.setImageResource(R.drawable.de4);
                ibFaceDeux.setVisibility(View.INVISIBLE);
                ibFaceDeux.setImageBitmap(null);
                break;
            case 5:
                ibFaceun.setImageResource(R.drawable.de5);
                ibFaceDeux.setVisibility(View.INVISIBLE);
                ibFaceDeux.setImageBitmap(null);
                break;
            case 6:
                ibFaceun.setImageResource(R.drawable.de6);
                ibFaceDeux.setVisibility(View.INVISIBLE);
                ibFaceDeux.setImageBitmap(null);
                break;
            case 7:
                ibFaceun.setImageResource(R.drawable.de1);
                ibFaceDeux.setVisibility(View.VISIBLE);
                ibFaceDeux.setImageResource(R.drawable.de6);
                break;
            case 8:
                ibFaceun.setImageResource(R.drawable.de2);
                ibFaceDeux.setVisibility(View.VISIBLE);
                ibFaceDeux.setImageResource(R.drawable.de6);
                break;
            case 9:
                ibFaceun.setImageResource(R.drawable.de3);
                ibFaceDeux.setVisibility(View.VISIBLE);
                ibFaceDeux.setImageResource(R.drawable.de6);
                break;
            case 10:
                ibFaceun.setImageResource(R.drawable.de4);
                ibFaceDeux.setVisibility(View.VISIBLE);
                ibFaceDeux.setImageResource(R.drawable.de6);
                break;
            case 11:
                ibFaceun.setImageResource(R.drawable.de5);
                ibFaceDeux.setVisibility(View.VISIBLE);
                ibFaceDeux.setImageResource(R.drawable.de6);
                break;
            case 12:
                ibFaceun.setImageResource(R.drawable.de6);
                ibFaceDeux.setVisibility(View.VISIBLE);
                ibFaceDeux.setImageResource(R.drawable.de6);
                break;

        }
    }


}