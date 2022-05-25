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
    private EditText fname,lname,address,email,passsword,confirmPassword,mobileNo;

    public CadastrarFragmento() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view=inflater.inflate(R.layout.fragmento_cadastrar, container, false);
        parentFrameLayout=getActivity().findViewById(R.id.registrar_framelayout);

        fname=view.findViewById(R.id.sign_up_fname);
        lname=view.findViewById(R.id.sign_up_lname);
        address=view.findViewById(R.id.sign_up_address);
        mobileNo=view.findViewById(R.id.sign_up_phone);
        email=view.findViewById(R.id.sign_up_email);
        passsword=view.findViewById(R.id.sign_up_password);
        confirmPassword=view.findViewById(R.id.sign_up_confirm_password);


        return view;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
    }
}