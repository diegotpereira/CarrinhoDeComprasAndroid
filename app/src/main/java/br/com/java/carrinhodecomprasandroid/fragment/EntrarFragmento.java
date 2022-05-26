package br.com.java.carrinhodecomprasandroid.fragment;

import android.content.Intent;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import android.text.TextUtils;
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

import br.com.java.carrinhodecomprasandroid.R;
import br.com.java.carrinhodecomprasandroid.activity.PaginaPrincipalActivity;
import br.com.java.carrinhodecomprasandroid.activity.RegistrarActivity;
import java.util.Objects;

public class EntrarFragmento extends Fragment {

    private TextView naoTemUmaConta;
    private TextView esqueceuSenha;
    private FrameLayout parentFrameLayout;
    private EditText email;
    private EditText password;
    private Button entrarBtn;
    private ImageButton fecharLogin;
    private ProgressBar progressBar;
    private FirebaseAuth firebaseAuth;
    public static boolean desabilitarFecharBtn = false;

    public EntrarFragmento() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragmento_entrar, container, false);
        naoTemUmaConta = view.findViewById(R.id.tv_nao_tem_uma_conta);
        parentFrameLayout = getActivity().findViewById(R.id.registrar_framelayout);
        esqueceuSenha = view.findViewById(R.id.entrar_esqueceu_senha);
        email = view.findViewById(R.id.entrar_email);
        password = view.findViewById(R.id.entrar_password);
        entrarBtn = view.findViewById(R.id.entrar_btn);
        progressBar = view.findViewById(R.id.entrar_progressBar);
        fecharLogin = view.findViewById(R.id.entrar_fechar_btn);

        firebaseAuth = FirebaseAuth.getInstance();

        if (desabilitarFecharBtn) {
            fecharLogin.setVisibility(View.GONE);
        } else {
            fecharLogin.setVisibility(View.VISIBLE);
        }

        return view;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        naoTemUmaConta.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                setFragmento(new CadastrarFragmento());
            }
        });
        fecharLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                principalIntent();
            }
        });
        esqueceuSenha.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
//                RegistrarActivity.onRedifinirSenhaFragmento = true;
//                setFragmento(new RedifinirSenhaFragmento());
            }
        });
        entrarBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                entrarBtn.setEnabled(false);
                progressBar.setVisibility(View.VISIBLE);

                if (validacao()) {
                    firebaseAuth.signInWithEmailAndPassword(email.getText().toString(),
                            password.getText().toString())
                            .addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                        @Override
                        public void onComplete(@NonNull Task<AuthResult> task) {
                            if (task.isSuccessful()) {
                                principalIntent();
                            } else {
                                progressBar.setVisibility(View.INVISIBLE);

                                entrarBtn.setEnabled(true);
                                String erro = task.getException().getMessage();
                                Toast.makeText(getActivity(), erro, Toast.LENGTH_SHORT).show();
                            }
                        }
                    });
                } else {
                    progressBar.setVisibility(View.INVISIBLE);
                    entrarBtn.setEnabled(true);

                    Toast.makeText(getActivity(), "Email ou senha está incorreta!!", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
    private void setFragmento(Fragment fragment) {
        FragmentTransaction fragmentTransaction = getActivity().getSupportFragmentManager().beginTransaction();
//        fragmentTransaction.setCustomAnimations(R.anim.slide_from_right, R.anim.slideout_from_left);
        fragmentTransaction.replace(parentFrameLayout.getId(), fragment);
        fragmentTransaction.commit();
    }
    private void principalIntent() {
        if (desabilitarFecharBtn) {
            desabilitarFecharBtn = false;
        } else {
            Intent intent = new Intent(getActivity(), PaginaPrincipalActivity.class);
            startActivity(intent);
        }
        getActivity().finish();
    }
    private boolean validacao() {
        if (!ehValidoEmail(email.getText().toString()))
            return false;
        if (TextUtils.isEmpty(password.getText()))
            return false;
        if (password.getText().length() <= 5)
            return false;

        return true;
    }
    private boolean ehValidoEmail(String email) {
        return android.util.Patterns.EMAIL_ADDRESS.matcher(email).matches();
    }
}