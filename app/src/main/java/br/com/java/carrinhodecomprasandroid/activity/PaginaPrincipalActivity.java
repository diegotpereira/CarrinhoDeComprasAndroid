package br.com.java.carrinhodecomprasandroid.activity;

import static br.com.java.carrinhodecomprasandroid.activity.RegistrarActivity.setCadastrarFragmento;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import android.app.Activity;
import android.app.Dialog;
import android.content.Intent;
import android.content.res.Configuration;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;

import com.google.android.material.navigation.NavigationView;
import com.google.firebase.auth.FirebaseUser;

import br.com.java.carrinhodecomprasandroid.R;
import br.com.java.carrinhodecomprasandroid.fragment.CadastrarFragmento;
import br.com.java.carrinhodecomprasandroid.fragment.CarrinhoFragmento;
import br.com.java.carrinhodecomprasandroid.fragment.EntrarFragmento;
import br.com.java.carrinhodecomprasandroid.fragment.MinhasOrdensFragmento;
import br.com.java.carrinhodecomprasandroid.fragment.PrincipalFragmento;
import de.hdodenhof.circleimageview.CircleImageView;

public class PaginaPrincipalActivity extends AppCompatActivity implements
        NavigationView.OnNavigationItemSelectedListener {

    private FrameLayout frameLayout;
    private DrawerLayout drawerLayout;
    private ActionBarDrawerToggle toggle;

    private static final int PRINCIPAL_FRAGMENTO = 0;
    private static final int CARRINHO_FRAGMENTO = 3;
    private static final int ORDENS_FRAGMENTO = 1;
    private int atualFragmento = -1;

    public static Boolean exibirCarrinho = false;
    public static Activity principalActivity=null;
    public static boolean redefinirPrincipalActivity = false;

    NavigationView navigationView;
    private ActionBar actionBar;
    private Dialog entrarDialog;

    private FirebaseUser atualUsuario;

    private TextView crachaContar;
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

        if (exibirCarrinho) {
            principalActivity = PaginaPrincipalActivity.this;
            drawerLayout.setDrawerLockMode(DrawerLayout.LOCK_MODE_LOCKED_CLOSED);
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
            irParaFragmento("Meu Carrinho", new CarrinhoFragmento(), CARRINHO_FRAGMENTO);
        } else {
            toggle = new ActionBarDrawerToggle(this, drawerLayout, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
            drawerLayout.addDrawerListener(toggle);
            toggle.syncState();
            irParaFragmento("Principal", new PrincipalFragmento(), PRINCIPAL_FRAGMENTO);
        }

        //Tarefa: mostra a caixa de diálogo de login
        entrarDialog = new Dialog(PaginaPrincipalActivity.this);
        entrarDialog.setContentView(R.layout.entrar_dialog);
        entrarDialog.setCancelable(true);
        entrarDialog.getWindow().setLayout(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT);

        Button dialogEntrarBtn = entrarDialog.findViewById(R.id.entrar_btn);
        Button dialogCadastrarBtn = entrarDialog.findViewById(R.id.cadastrar_btn);

        final Intent registrarIntent = new Intent(PaginaPrincipalActivity.this, RegistrarActivity.class);

        dialogEntrarBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                EntrarFragmento.desabilitarFecharBtn =  true;
                CadastrarFragmento.desabilitarFecharBtn = true;

                entrarDialog.dismiss();
                setCadastrarFragmento = false;
                startActivity(registrarIntent);
            }
        });
        dialogCadastrarBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                EntrarFragmento.desabilitarFecharBtn =  true;
                CadastrarFragmento.desabilitarFecharBtn = true;

                entrarDialog.dismiss();
                setCadastrarFragmento = true;
                startActivity(registrarIntent);
            }
        });
    }

    @Override
    protected void onStart() {
        super.onStart();
        //Tarefa:verifica se o usuário atual está logado ou não
        if (atualUsuario == null) {
            navigationView.getMenu().getItem(navigationView.getMenu().size()-1).setEnabled(true);
        } else {

            navigationView.getMenu().getItem(navigationView.getMenu().size()-1).setEnabled(true);
        }
        if (redefinirPrincipalActivity) {
            redefinirPrincipalActivity = false;
            irParaFragmento("Principal", new PrincipalFragmento(), PRINCIPAL_FRAGMENTO);
        }
        PaginaPrincipalActivity.this.invalidateOptionsMenu();
    }

    @Override
    protected void onPause() {
        super.onPause();
    }
    private void setFragmento(Fragment fragment, int fragmentoNo) {
        if (atualFragmento != fragmentoNo) {
            atualFragmento = fragmentoNo;

            FragmentTransaction fragmentTransaction = getSupportFragmentManager().beginTransaction();
//            fragmentTransaction.setCustomAnimations(R.anim.fade_in, R.anim.fade_out);
            fragmentTransaction.replace(frameLayout.getId(), fragment);
            fragmentTransaction.commit();
        }
    }
    private void irParaFragmento(String titulo, Fragment fragment, int fragmentoNo) {
        getSupportActionBar().setDisplayShowTitleEnabled(true);
        getSupportActionBar().setTitle(titulo);
        setFragmento(fragment, fragmentoNo);

        invalidateOptionsMenu();

        if (fragmentoNo == CARRINHO_FRAGMENTO) {
            navigationView.getMenu().getItem(3).setChecked(true);
        } else if (fragmentoNo == ORDENS_FRAGMENTO) {
            navigationView.getMenu().getItem(1).setChecked(true);
        } else if (fragmentoNo == PRINCIPAL_FRAGMENTO) {
            navigationView.getMenu().getItem(0).setChecked(true);
        }
    }

    @Override
    protected void onPostCreate(@Nullable Bundle savedInstanceState) {
        super.onPostCreate(savedInstanceState);
    }

    @Override
    public void onConfigurationChanged(@NonNull Configuration newConfig) {
        super.onConfigurationChanged(newConfig);
        toggle.onConfigurationChanged(newConfig);
    }

    MenuItem menuItem;
    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {

        drawerLayout.closeDrawer(GravityCompat.START);
        menuItem = item;

        if (atualUsuario == null) {
            drawerLayout.addDrawerListener(new DrawerLayout.SimpleDrawerListener() {
                @Override
                public void onDrawerClosed(View drawerView) {
                    super.onDrawerClosed(drawerView);

                    int id =menuItem.getItemId();
                    if (id == R.id.nav_minha_loja) {
                        irParaFragmento("Principal", new PrincipalFragmento(), PRINCIPAL_FRAGMENTO);
                    } else {
                        navigationView.getMenu().getItem(0).setChecked(false);
                    }
                    if (id == R.id.nav_meu_carrinho) {
                        irParaFragmento("Meu Carrinho", new CarrinhoFragmento(), CARRINHO_FRAGMENTO);
                    } else {
                        navigationView.getMenu().getItem(3).setChecked(false);
                    }
                    if (id == R.id.nav_my_order) {
                        irParaFragmento("Meus Pedidos", new MinhasOrdensFragmento(), ORDENS_FRAGMENTO);
                    }
                }
            });
            return true;
        } else {
            entrarDialog.show();
            return false;
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {

        if (atualFragmento == PRINCIPAL_FRAGMENTO) {

            getMenuInflater().inflate(R.menu.principal_pagina, menu);

            MenuItem carrinhoItem = menu.findItem(R.id.principal_meu_carrinho);
            carrinhoItem.setActionView(R.layout.layout_cracha);

            ImageView crachaIcone = carrinhoItem.getActionView().findViewById(R.id.cracha_icone);
            crachaIcone.setImageResource(R.drawable.white_cart);
            crachaContar = carrinhoItem.getActionView().findViewById(R.id.badge_count);

            if (atualUsuario != null) {

            }
            carrinhoItem.getActionView().setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    if (atualUsuario == null) {
                        entrarDialog.show();
                    } else {
                        navigationView.getMenu().getItem(3).setChecked(true);
                        irParaFragmento("Meu Carrinho", new CarrinhoFragmento(), CARRINHO_FRAGMENTO);
                    }
                }
            });
            MenuItem notificaItem = menu.findItem(R.id.principal_notificacao_logo);
            notificaItem.setActionView(R.layout.layout_cracha);

            ImageView notificaIcone = notificaItem.getActionView().findViewById(R.id.cracha_icone);
            notificaIcone.setImageResource(R.drawable.notifications_logo);

            TextView notificaContar = notificaItem.getActionView().findViewById(R.id.badge_count);
        }
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        if (!exibirCarrinho) {
            if (toggle.onOptionsItemSelected(item)) {
                return true;
            }
        }
        if (item.getItemId() == R.id.principal_pesquisar_icone) {

            return true;
        } else if (item.getItemId() == R.id.principal_notificacao_logo) {

            return true;
        } else if (item.getItemId() == R.id.principal_meu_carrinho) {
            if (atualUsuario == null) {
                entrarDialog.show();
            } else {
                navigationView.getMenu().getItem(3).setChecked(true);
                irParaFragmento("Meu Carrinho", new CarrinhoFragmento(), CARRINHO_FRAGMENTO);
            }
            return true;
        } else if (item.getItemId() == android.R.id.home) {
            if (exibirCarrinho) {
                principalActivity = null;
                exibirCarrinho = false;
                finish();

                return true;
            }
        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    public void onBackPressed() {

        if (drawerLayout.isDrawerOpen(GravityCompat.START)) {
            drawerLayout.closeDrawer(GravityCompat.START);
        } else {
            if (atualFragmento == PRINCIPAL_FRAGMENTO) {
                atualFragmento = -1;
                super.onBackPressed();
            } else {
                if (exibirCarrinho) {
                    principalActivity = null;
                    exibirCarrinho = false;
                    finish();
                } else {
                    irParaFragmento("Principal", new PrincipalFragmento(), PRINCIPAL_FRAGMENTO);
                }
            }
        }
    }
}