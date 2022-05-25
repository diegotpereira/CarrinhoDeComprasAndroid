package br.com.java.carrinhodecomprasandroid.fragment;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.FrameLayout;

import br.com.java.carrinhodecomprasandroid.R;

public class CadastrarFragmento extends Fragment {

    public static boolean disableCloseBtn=false;
    private FrameLayout parentFrameLayout;
    private EditText fnome;
    private EditText lnome;
    private EditText endereco;
    private EditText email;
    private EditText passsword;
    private EditText confirmarPassword;
    private EditText celularNo;

    public CadastrarFragmento() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view=inflater.inflate(R.layout.fragmento_cadastrar, container, false);
        parentFrameLayout=getActivity().findViewById(R.id.registrar_framelayout);

        fnome=view.findViewById(R.id.cadastrar_fnome);
        lnome=view.findViewById(R.id.cadastrar_lnome);
        endereco=view.findViewById(R.id.cadastrar_endereco);
        celularNo=view.findViewById(R.id.cadastrar_telefone);
        email=view.findViewById(R.id.cadastrar_email);
        passsword=view.findViewById(R.id.cadastrar_senha);
        confirmarPassword=view.findViewById(R.id.cadastrar_confirmar_senha);


        return view;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
    }
}