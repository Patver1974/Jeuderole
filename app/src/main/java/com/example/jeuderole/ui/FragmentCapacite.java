package com.example.jeuderole.ui;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.Toast;

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
public class FragmentCapacite extends Fragment {
    Button btAjouter, btExit;
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;
    private JeuRoleDao dao;
    private List<Capacite> listecapacite = new ArrayList<>();
    private Capacite capacite;
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
        btAjouter = v.findViewById(R.id.bt_capacite_ajouter);
        btAjouter.setOnClickListener(v1 -> {
            capacite = new Capacite("abc","arbre ballon courrier",10);
            JeuRoleDao jeuRoleDao = new JeuRoleDao(v1.getContext());
            jeuRoleDao.openWritable();
            jeuRoleDao.insert(capacite);
            jeuRoleDao.close();
            Capacite capa2;

            dao = new JeuRoleDao(v1.getContext());
            dao.openReadable();
            listecapacite = dao.getAll();
            dao.close();
            Toast.makeText(getView().getContext(), String.valueOf(listecapacite.size()),Toast.LENGTH_LONG).show();
        });


        return  v;
    }
}