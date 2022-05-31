package br.com.java.carrinhodecomprasandroid.activity;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.viewpager.widget.ViewPager;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ImageView;
import android.widget.TextView;


import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.android.material.tabs.TabLayout;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.firestore.DocumentSnapshot;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.Query;
import com.google.firebase.firestore.QuerySnapshot;

import java.util.ArrayList;
import java.util.List;

import br.com.java.carrinhodecomprasandroid.R;

public class ProdutoDetalhesActivity extends AppCompatActivity {

    private ViewPager produtoImagemViewPager;
    private TabLayout exibirPaginaIndicador;

    private TextView produtoTitulo;
    private TextView mediaAvalicaoMinView;
    private TextView produtoPreco;
    private TextView reducaoPreco;
    private ImageView cod_indicador;
    private TextView tv_cod_indicator;


    // descrição do produto
    private ViewPager produtoDetalhesViewPager;
    private TabLayout produtoDetalhesLayout;
    private String produtoDescricao;
    private String produtoOutrosDetalhes;

    //
    private FirebaseUser atualUsuario;

    // variável para o ID do produto da loja
    public static String produtoID;

    public static Activity produtoDetalheActivity;

    private FirebaseFirestore firebaseFirestore;
    private DocumentSnapshot documentSnapshot;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_produto_detalhes);

        Toolbar meuToolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(meuToolbar);
        getSupportActionBar().setDisplayShowTitleEnabled(false);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        produtoDetalhesViewPager = findViewById(R.id.produto_detalhes_viewpager);

        produtoImagemViewPager = findViewById(R.id.produto_imagens_viewpager);
        exibirPaginaIndicador = findViewById(R.id.exibirpagina_indicador);

        produtoDetalhesLayout = findViewById(R.id.produto_detalhes_tablayout);

        // carregar imagens do firebase
        firebaseFirestore = FirebaseFirestore.getInstance();
        final List<String> produtoImagens = new ArrayList<>(1);

        produtoID = getIntent().getStringExtra("PRODUTO_ID");

        firebaseFirestore.collection("PRODUTOS").document(produtoID)
                .get().addOnCompleteListener(new OnCompleteListener<DocumentSnapshot>() {
                    @Override
                    public void onComplete(@NonNull Task<DocumentSnapshot> task) {
                        if (task.isSuccessful()) {
                            documentSnapshot = task.getResult();

                            firebaseFirestore.collection("PRODUTOS").document(produtoID)
                                    .collection("QUANTIDADE")
                                    .orderBy("tempo", Query.Direction.ASCENDING)
                                    .get()
                                    .addOnCompleteListener(new OnCompleteListener<QuerySnapshot>() {
                                        @Override
                                        public void onComplete(@NonNull Task<QuerySnapshot> task) {
                                            if (task.isSuccessful()) {
                                                for(long x = 1; x <= (long) documentSnapshot.get("sem_produto_imagens"); x++) {
                                                    produtoImagens.add(documentSnapshot.get("produto_imagens_" + x).toString());
                                                }
                                            }
                                        }
                                    });
                        }
                    }
                });


    }

    @Override
    protected void onStart() {
        super.onStart();
        atualUsuario = FirebaseAuth.getInstance().getCurrentUser();
        if (atualUsuario == null) {

        }
        if (atualUsuario != null) {

        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.busca_eh_carrinho_icone, menu);
        ActionBar actionBar = getSupportActionBar();
        actionBar.setDisplayUseLogoEnabled(true);
        actionBar.setDisplayShowHomeEnabled(true);

        return super.onCreateOptionsMenu(menu);
    }

    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        if (item.getItemId() == android.R.id.home) {
            produtoDetalheActivity = null;
            finish();
            return true;
        } else if (item.getItemId() == R.id.principal_pesquisar_icone) {

        } else if (item.getItemId() == R.id.principal_meu_carrinho) {
            Intent carrinhoIntent = new Intent(ProdutoDetalhesActivity.this, PaginaPrincipalActivity.class);
            startActivity(carrinhoIntent);

            return true;
        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();

    }

    @Override
    public void onBackPressed() {
        produtoDetalheActivity = null;
        super.onBackPressed();
    }
}