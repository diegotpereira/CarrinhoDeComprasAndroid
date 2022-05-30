package br.com.java.carrinhodecomprasandroid.activity;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.viewpager.widget.ViewPager;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.widget.ImageView;
import android.widget.TextView;


import com.google.android.material.tabs.TabLayout;

import br.com.java.carrinhodecomprasandroid.R;

public class ProdutoDetalhesActivity extends AppCompatActivity {

    private ViewPager produtoImagemViewPager;
    private TabLayout exibirPaginaIndicador;

    private TextView produtoTitulo;
    private TextView mediaAvalicaoMinView;
    private TextView produtoPreco;
    private TextView reducaoPreco;
    private ImageView cod_indicador;


    // descrição do produto
    private ViewPager produtoDetalhesViewPager;
    private TabLayout produtoDetalhesLayout;
    private String produtoDescricao;
    private String produtoOutrosDetalhes;

    public static Activity produtoDetalheActivity;
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