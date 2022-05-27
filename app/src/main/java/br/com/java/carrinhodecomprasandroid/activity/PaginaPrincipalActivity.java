package br.com.java.carrinhodecomprasandroid.activity;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;

import android.app.Dialog;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;

import com.google.android.material.navigation.NavigationView;
import com.google.firebase.auth.FirebaseUser;

import br.com.java.carrinhodecomprasandroid.R;
import de.hdodenhof.circleimageview.CircleImageView;

public class PaginaPrincipalActivity extends AppCompatActivity implements
        NavigationView.OnNavigationItemSelectedListener {

    private FrameLayout frameLayout;
    private DrawerLayout drawerLayout;
    private ActionBarDrawerToggle toggle;

    private static final int PRINCIPAL_FRAGMENTO = 0;
    private static final int CARRINHO_FRAGMENTO = 3;
    private int atualFragmento = -1;

    NavigationView navigationView;
    private ActionBar actionBar;
    private Dialog entrarDialog;

    private FirebaseUser atualUsuario;

    private TextView contagemDeEmblemas;
    private CircleImageView perfilView;
    private TextView nomeCompleto;
    private TextView email;
    private ImageView addPerfilIcone;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pagina_principal);

        frameLayout = findViewById(R.id.principalFrameLayout);

        Toolbar toolbar = findViewById(R.id.toolbarPrincipalActivity);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        drawerLayout = findViewById(R.id.draw_layout);
        navigationView = findViewById(R.id.nav_view);

        actionBar = getSupportActionBar();
        assert actionBar != null;
        actionBar.setDisplayUseLogoEnabled(true);
        actionBar.setDisplayShowHomeEnabled(true);

        navigationView.setNavigationItemSelectedListener((NavigationView.OnNavigationItemSelectedListener) this);

        perfilView = navigationView.getHeaderView(0).findViewById(R.id.nav_perfil_pic);
        nomeCompleto = navigationView.getHeaderView(0).findViewById(R.id.nav_usuario_nome);
        email = navigationView.getHeaderView(0).findViewById(R.id.nav_email_endereco);
        addPerfilIcone = navigationView.getHeaderView(0).findViewById(R.id.add_perfil_icone);

        //Tarefa: mostra a caixa de diálogo de login
        entrarDialog = new Dialog(PaginaPrincipalActivity.this);
        entrarDialog.setContentView(R.layout.entrar_dialog);
        entrarDialog.setCancelable(true);
        entrarDialog.getWindow().setLayout(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT);
    }

    @Override
    protected void onStart() {
        super.onStart();
        //Tarefa:verifica se o usuário atual está logado ou não
        if (atualUsuario == null) {
            navigationView.getMenu().getItem(navigationView.getMenu().size()-1).setEnabled(true);
        } else {

        }
    }

    @Override
    protected void onPause() {
        super.onPause();
    }

    MenuItem menuItem;
    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {

        drawerLayout.closeDrawer(GravityCompat.START);
        menuItem = item;

        if (atualUsuario != null) {
            drawerLayout.addDrawerListener(new DrawerLayout.SimpleDrawerListener() {
                @Override
                public void onDrawerClosed(View drawerView) {
                    super.onDrawerClosed(drawerView);

                    int id =menuItem.getItemId();
                    if (id == R.id.nav_my_mall) {

                    }
                }
            });
        }
        return true;
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {

        if (atualFragmento == PRINCIPAL_FRAGMENTO) {

            getMenuInflater().inflate(R.menu.principal_pagina, menu);
        }
        return super.onCreateOptionsMenu(menu);
    }
}