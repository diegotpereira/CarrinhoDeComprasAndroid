package br.com.java.carrinhodecomprasandroid.fragment;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;

import br.com.java.carrinhodecomprasandroid.R;

public class CadastrarFragmento extends Fragment {

    public static boolean disableCloseBtn=false;
    private FrameLayout parentFrameLayout;

    public CadastrarFragmento() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view=inflater.inflate(R.layout.fragmento_cadastrar, container, false);
        parentFrameLayout=getActivity().findViewById(R.id.registrar_framelayout);
        return view;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
    }
}