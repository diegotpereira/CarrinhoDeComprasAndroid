package br.com.java.carrinhodecomprasandroid.fragment;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import br.com.java.carrinhodecomprasandroid.R;


public class PrincipalFragmento extends Fragment {

    private RecyclerView homePageRecycleView;


    public PrincipalFragmento() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragmento_principal, container, false);


        homePageRecycleView = view.findViewById(R.id.homePageRecyclerView);
        LinearLayoutManager linearLayoutManagerxyz = new LinearLayoutManager(getContext());
        linearLayoutManagerxyz.setOrientation(LinearLayoutManager.VERTICAL);

        homePageRecycleView.setLayoutManager(linearLayoutManagerxyz);
        return view;
    }
}