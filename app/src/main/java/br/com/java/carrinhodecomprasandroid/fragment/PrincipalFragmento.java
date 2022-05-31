package br.com.java.carrinhodecomprasandroid.fragment;

import static br.com.java.carrinhodecomprasandroid.queries.BDConsultas.carregarCategorias;
import static br.com.java.carrinhodecomprasandroid.queries.BDConsultas.carregarCategoriasNomes;
import static br.com.java.carrinhodecomprasandroid.queries.BDConsultas.carregarFragmentoDado;
import static br.com.java.carrinhodecomprasandroid.queries.BDConsultas.listas;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

import br.com.java.carrinhodecomprasandroid.R;
import br.com.java.carrinhodecomprasandroid.activity.PaginaPrincipalActivity;
import br.com.java.carrinhodecomprasandroid.adapter.PrincipalPaginaAdapter;
import br.com.java.carrinhodecomprasandroid.model.CategoriaModelo;
import br.com.java.carrinhodecomprasandroid.model.HorizontalProdutoScrollModelo;
import br.com.java.carrinhodecomprasandroid.model.PrincipalPaginaModelo;
import br.com.java.carrinhodecomprasandroid.model.SliderModelo;


public class PrincipalFragmento extends Fragment {

    private ConnectivityManager connectivityManager;
    private NetworkInfo networkInfo;

    private RecyclerView principalPaginaRecycleView;
    private RecyclerView categoriaRecycleView;

    private LinearLayoutManager linearLayout;
    public static SwipeRefreshLayout swipeRefreshLayout;

    // Adptadores
    private PrincipalPaginaAdapter principalPaginaAdapter;

    // listas fakes
    private List<CategoriaModelo> categoriaModeloFakeLista = new ArrayList<>();
    private List<PrincipalPaginaModelo> principalPaginaModeloFakeLista = new ArrayList<>();

    // componente
    private Button tenteNovamenteBtn;


    public PrincipalFragmento() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragmento_principal, container, false);
        tenteNovamenteBtn = view.findViewById(R.id.tente_novamente_btn);
        swipeRefreshLayout = view.findViewById(R.id.atualizar_layout);
        swipeRefreshLayout.setColorSchemeColors(getContext().getResources()
                .getColor(R.color.colorPrimary),
                getContext().getResources().getColor(R.color.colorPrimary));

        // definir a visualização do recyclerview de categorias
        categoriaRecycleView = view.findViewById(R.id.categoriaRecyclerView);
        linearLayout = new LinearLayoutManager(getActivity());
        linearLayout.setOrientation(LinearLayoutManager.HORIZONTAL);
        categoriaRecycleView.setLayoutManager(linearLayout);

        // definir todos os outros recyclerview
        // carregar imagens para layout horizontal e layout de grade
        principalPaginaRecycleView = view.findViewById(R.id.principalPaginaRecyclerView);
        LinearLayoutManager linearLayoutManagerxyz = new LinearLayoutManager(getContext());
        linearLayoutManagerxyz.setOrientation(LinearLayoutManager.VERTICAL);
        principalPaginaRecycleView.setLayoutManager(linearLayoutManagerxyz);

        categoriaModeloFakeLista.add(new CategoriaModelo("null", ""));
        categoriaModeloFakeLista.add(new CategoriaModelo("null", ""));
        categoriaModeloFakeLista.add(new CategoriaModelo("null", ""));
        categoriaModeloFakeLista.add(new CategoriaModelo("null", ""));
        categoriaModeloFakeLista.add(new CategoriaModelo("null", ""));
        categoriaModeloFakeLista.add(new CategoriaModelo("null", ""));
        categoriaModeloFakeLista.add(new CategoriaModelo("null", ""));
        categoriaModeloFakeLista.add(new CategoriaModelo("null", ""));
        categoriaModeloFakeLista.add(new CategoriaModelo("null", ""));

        List<SliderModelo> sliderModeloFakeLista = new ArrayList<>();
        sliderModeloFakeLista.add(new SliderModelo("null", "#FFFFFF"));
        sliderModeloFakeLista.add(new SliderModelo("null", "#FFFFFF"));
        sliderModeloFakeLista.add(new SliderModelo("null", "#FFFFFF"));
        sliderModeloFakeLista.add(new SliderModelo("null", "#FFFFFF"));
        sliderModeloFakeLista.add(new SliderModelo("null", "#FFFFFF"));

        List<HorizontalProdutoScrollModelo> horizontalProdutoScrollModeloFakeLista = new ArrayList<>();
        horizontalProdutoScrollModeloFakeLista.add(new HorizontalProdutoScrollModelo("", "", "", "", ""));
        horizontalProdutoScrollModeloFakeLista.add(new HorizontalProdutoScrollModelo("", "", "", "", ""));
        horizontalProdutoScrollModeloFakeLista.add(new HorizontalProdutoScrollModelo("", "", "", "", ""));
        horizontalProdutoScrollModeloFakeLista.add(new HorizontalProdutoScrollModelo("", "", "", "", ""));
        horizontalProdutoScrollModeloFakeLista.add(new HorizontalProdutoScrollModelo("", "", "", "", ""));
        horizontalProdutoScrollModeloFakeLista.add(new HorizontalProdutoScrollModelo("", "", "", "", ""));
        horizontalProdutoScrollModeloFakeLista.add(new HorizontalProdutoScrollModelo("", "", "", "", ""));

        principalPaginaModeloFakeLista.add(new PrincipalPaginaModelo(0, sliderModeloFakeLista));
        principalPaginaModeloFakeLista.add(new PrincipalPaginaModelo(2,"", "#FFFFFF", horizontalProdutoScrollModeloFakeLista));
        principalPaginaModeloFakeLista.add(new PrincipalPaginaModelo(1,"", "#FFFFFF", horizontalProdutoScrollModeloFakeLista));

        // definir lista falsa de principalPaginaListas
        principalPaginaAdapter = new PrincipalPaginaAdapter(principalPaginaModeloFakeLista);

        // verifique se a conexão com a internet está estabelecida ou não
        connectivityManager = (ConnectivityManager) getActivity().getSystemService(Context.CONNECTIVITY_SERVICE);
        if (networkInfo != null && networkInfo.isConnected()) {
            tenteNovamenteBtn.setVisibility(View.GONE);

            categoriaRecycleView.setVisibility(View.VISIBLE);
            principalPaginaRecycleView.setVisibility(View.VISIBLE);

            // usar a data do Firebase para categorias de programas
            if (listas.size() == 0) {
                carregarCategoriasNomes.add("PRINCIPAL");
                listas.add(new ArrayList<PrincipalPaginaModelo>());
                carregarFragmentoDado(principalPaginaRecycleView, getContext(), 0 , "PRINCIPAL");
            } else {
                principalPaginaAdapter = new PrincipalPaginaAdapter(listas.get(0));
                principalPaginaAdapter.notifyDataSetChanged();
            }
            // lista fake adapter
            principalPaginaRecycleView.setAdapter(principalPaginaAdapter);
        } else {
            categoriaRecycleView.setVisibility(View.GONE);
            principalPaginaRecycleView.setVisibility(View.GONE);
            tenteNovamenteBtn.setVisibility(View.VISIBLE);

        }

        // atualizar
        swipeRefreshLayout.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {
                swipeRefreshLayout.setRefreshing(true);
                recarregarPagina();
            }
        });
        // tente novamente botão
        tenteNovamenteBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                recarregarPagina();
            }
        });
        return view;
    }

    private void recarregarPagina() {
        networkInfo = connectivityManager.getActiveNetworkInfo();

        if (networkInfo != null && networkInfo.isConnected()) {
            tenteNovamenteBtn.setVisibility(View.GONE);
            categoriaRecycleView.setVisibility(View.VISIBLE);
            principalPaginaRecycleView.setVisibility(View.VISIBLE);

            principalPaginaAdapter = new PrincipalPaginaAdapter(principalPaginaModeloFakeLista);

            principalPaginaRecycleView.setAdapter(principalPaginaAdapter);

            carregarCategorias(categoriaRecycleView, getContext());
            carregarCategoriasNomes.add("PRINCIPAL");
            listas.add(new ArrayList<PrincipalPaginaModelo>());
            carregarFragmentoDado(principalPaginaRecycleView, getContext(), 0, "PRINCIPAL");
        } else {
            Toast.makeText(getContext(), "Sem conexão na internet", Toast.LENGTH_SHORT).show();
            swipeRefreshLayout.setRefreshing(false);
            categoriaRecycleView.setVisibility(View.GONE);
            principalPaginaRecycleView.setVisibility(View.GONE);
            tenteNovamenteBtn.setVisibility(View.VISIBLE);

        }
    }
}