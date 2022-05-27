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

    private RecyclerView principalPaginaRecycleView;
    private RecyclerView categoriaRecycleView;
    private LinearLayoutManager linearLayout;

    public PrincipalFragmento() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragmento_principal, container, false);


        principalPaginaRecycleView = view.findViewById(R.id.principalPaginaRecyclerView);

        // define a visualização do Recycler de categorias
        categoriaRecycleView = view.findViewById(R.id.categoriaRecyclerView);
        linearLayout = new LinearLayoutManager(getActivity());
        linearLayout.setOrientation(LinearLayoutManager.HORIZONTAL);
        categoriaRecycleView.setLayoutManager(linearLayout);

        // define todos os outros recyclerview
        // carrega imagens para layout horizontal e layout de grade
        LinearLayoutManager linearLayoutManagerxyz = new LinearLayoutManager(getContext());
        linearLayoutManagerxyz.setOrientation(LinearLayoutManager.VERTICAL);

        principalPaginaRecycleView.setLayoutManager(linearLayoutManagerxyz);
        return view;
    }
}