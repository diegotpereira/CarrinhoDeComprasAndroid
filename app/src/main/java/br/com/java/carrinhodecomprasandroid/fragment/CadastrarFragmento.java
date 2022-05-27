package br.com.java.carrinhodecomprasandroid.fragment;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.FrameLayout;
import android.widget.ImageButton;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.firestore.CollectionReference;
import com.google.firebase.firestore.FirebaseFirestore;

import java.util.HashMap;
import java.util.Map;

import br.com.java.carrinhodecomprasandroid.R;

public class CadastrarFragmento extends Fragment {

    private FrameLayout parentFrameLayout;
    private EditText fnome;
    private EditText lnome;
    private EditText endereco;
    private EditText email;
    private EditText passsword;
    private EditText confirmarPassword;
    private EditText telefoneNo;

    public static boolean desabilitarFecharBtn=false;

    private ImageButton fecharBtn;
    private Button cadastrarBtn;
    private ProgressBar progressBar;

    private FirebaseAuth firebaseAuth;
    private FirebaseFirestore firebaseFirestore;

    private static final String TAG = "773";
    private TextView jaTemUmaConta;

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
        telefoneNo=view.findViewById(R.id.cadastrar_telefone);
        email=view.findViewById(R.id.cadastrar_email);
        passsword=view.findViewById(R.id.cadastrar_senha);
        confirmarPassword=view.findViewById(R.id.cadastrar_confirmar_senha);

        fecharBtn = view.findViewById(R.id.cadastrar_fechar_botao);
        cadastrarBtn = view.findViewById(R.id.btn_cadastrar);
        progressBar = view.findViewById(R.id.cadastrar_progressBar);

        firebaseAuth = FirebaseAuth.getInstance();
        firebaseFirestore = FirebaseFirestore.getInstance();

        if (desabilitarFecharBtn) {
            fecharBtn.setVisibility(View.GONE);
        } else {
            fecharBtn.setVisibility(View.VISIBLE);
        }
        return view;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        jaTemUmaConta.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
//                setFragmento(new EntrarFragmento);
            }
        });
        fecharBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                principalIntent();
            }
        });
        cadastrarBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                cadastrarBtn.setEnabled(false);
                progressBar.setVisibility(View.VISIBLE);

                if (validacaoDeFormulario()) {
                    firebaseAuth.createUserWithEmailAndPassword(
                            email.getText().toString(),
                            passsword.getText().toString()).addOnCompleteListener(getActivity(),
                            new OnCompleteListener<AuthResult>() {
                                @Override
                                public void onComplete(@NonNull Task<AuthResult> task) {
                                    if (task.isSuccessful()) {
                                        Map<String, Object> usuarioDado = new HashMap<>();
                                        usuarioDado.put("email", email.getText().toString());
                                        usuarioDado.put("perfil", "");
                                        usuarioDado.put("nome", fnome.getText().toString());
                                        usuarioDado.put("sobrenome", lnome.getText().toString());
                                        usuarioDado.put("endereco", endereco.getText().toString());
                                        usuarioDado.put("telefoneNo", telefoneNo.getText().toString());

                                        firebaseFirestore.collection("USUARIOS").document(firebaseAuth.getUid())
                                                .set(usuarioDado).addOnCompleteListener(new OnCompleteListener<Void>() {
                                                    @Override
                                                    public void onComplete(@NonNull Task<Void> task) {
                                                        if (task.isSuccessful()) {
                                                            CollectionReference usuarioDadoReferencia = firebaseFirestore.collection("USUARIOS").document(firebaseAuth.getUid()).collection("USUARIO_DADO");
                                                        } else {
                                                            String erro = task.getException().getMessage();

                                                            Toast.makeText(getActivity(), erro, Toast.LENGTH_SHORT).show();
                                                        }
                                                    }
                                                });
                                    } else {
                                        progressBar.setVisibility(View.INVISIBLE);
                                        cadastrarBtn.setEnabled(true);

                                        String erro = task.getException().getMessage();

                                        Toast.makeText(getActivity(), erro, Toast.LENGTH_SHORT).show();
                                    }
                                }
                            });
                } else {
                    progressBar.setVisibility(View.INVISIBLE);
                    cadastrarBtn.setEnabled(true);
                }
            }
        });
    }
    private void principalIntent() {

    }
    private boolean validacaoDeFormulario() {
        return true;
    }
}