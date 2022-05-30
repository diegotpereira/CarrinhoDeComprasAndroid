package br.com.java.carrinhodecomprasandroid.adapter;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.content.res.ColorStateList;
import android.graphics.Color;
import android.os.Handler;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.GridLayout;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager.widget.ViewPager;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;

import java.util.ArrayList;
import java.util.List;
import java.util.Timer;
import java.util.TimerTask;

import br.com.java.carrinhodecomprasandroid.R;
import br.com.java.carrinhodecomprasandroid.activity.ProdutoDetalhesActivity;
import br.com.java.carrinhodecomprasandroid.model.HorizontalProdutoScrollModelo;
import br.com.java.carrinhodecomprasandroid.model.PrincipalPaginaModelo;
import br.com.java.carrinhodecomprasandroid.model.SliderModelo;

public class PrincipalPaginaAdapter extends RecyclerView.Adapter {

    public static final int BANNER_SLIDER = 0;

    private int ultimaPosicao = -1;
    private List<PrincipalPaginaModelo> principalPaginaModeloLista;
    private RecyclerView.RecycledViewPool recycledViewPool;

    public PrincipalPaginaAdapter(List<PrincipalPaginaModelo> principalPaginaModeloLista) {
        this.principalPaginaModeloLista = principalPaginaModeloLista;
        recycledViewPool = new RecyclerView.RecycledViewPool();
    }

    @Override
    public int getItemViewType(int position) {
        switch (principalPaginaModeloLista.get(position).getTipo()) {
            case 0:
                return BANNER_SLIDER;
            case 1:
                return PrincipalPaginaModelo.HORIZONTAL_PRODUTO_EXIBIR;
            case 2:
                return PrincipalPaginaModelo.GRID_PRODUTO_EXIBIR;

            default:
                return -1;
        }
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        switch (viewType) {
            case BANNER_SLIDER:
                View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.sliding_ad_layout, parent, false);
                return new BannerSliderViewHolder(view);

            case PrincipalPaginaModelo.GRID_PRODUTO_EXIBIR:
                View gridHorizontalView = LayoutInflater.from(parent.getContext()).inflate(R.layout.grid_produto_layout, parent, false);
                return new GridProdutoViewHolder(gridHorizontalView);

            default:
                return null;
        }
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        switch (principalPaginaModeloLista.get(position).getTipo()) {
            case PrincipalPaginaModelo.HORIZONTAL_PRODUTO_EXIBIR:
                String cor = principalPaginaModeloLista.get(position).getCorDeFundo();
                String titulo = principalPaginaModeloLista.get(position).getTitulo();

                List<HorizontalProdutoScrollModelo> horizontalProdutoScrollModeloLista = principalPaginaModeloLista.get(position).getHorizontalProdutoScrollModeloLista();
//                ((HorizontalProdutoViewHolder)holder).setHorizontalProdutoLayout(horizontalProdutoScrollModeloLista, titulo, cor, exibirTodosProdutoLista);
                 break;

            default:
        }
    }

    @Override
    public int getItemCount() {
        return 0;
    }

    public static class BannerSliderViewHolder extends RecyclerView.ViewHolder {

        private ViewPager bannerSliderViewPager;
        private int atualPagina;
        private Timer timer;
        final private long atraso = 3000, peridoTempo = 3000;
        List<SliderModelo> listaOrganizada;

        public BannerSliderViewHolder(@NonNull View itemView) {
            super(itemView);
            bannerSliderViewPager = itemView.findViewById(R.id.exibirPaginaBannerSlider);
        }
        @SuppressLint("ClickableViewAccessibility")
        private void definirBannerSlider(final List<SliderModelo> sliderModelos) {
            atualPagina = 2;
            if (timer != null) {
                timer.cancel();
            }
            listaOrganizada = new ArrayList<>(sliderModelos);

            listaOrganizada.set(0, sliderModelos.get(sliderModelos.size() -2));
            listaOrganizada.set(1, sliderModelos.get(sliderModelos.size() -1));

            listaOrganizada.add(sliderModelos.get(0));
            listaOrganizada.add(sliderModelos.get(1));

            SliderAdapter sliderAdapter = new SliderAdapter(listaOrganizada);
            bannerSliderViewPager.setAdapter(sliderAdapter);
            bannerSliderViewPager.setClipToPadding(false);
            bannerSliderViewPager.setPageMargin(20);

            bannerSliderViewPager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
                @Override
                public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

                }

                @Override
                public void onPageSelected(int position) {
                    atualPagina = position;
                }

                @Override
                public void onPageScrollStateChanged(int state) {
                    if (state == ViewPager.SCROLL_STATE_IDLE) {
                        repetidorPagina(listaOrganizada);
                    }
                }
            });
            iniciarBannerSlideExibir(listaOrganizada);

            bannerSliderViewPager.setOnTouchListener(new View.OnTouchListener() {
                @Override
                public boolean onTouch(View view, MotionEvent motionEvent) {
                    repetidorPagina(listaOrganizada);
                    pararBannerSlideExibir();

                    if (motionEvent.getAction() == MotionEvent.ACTION_UP) {
                        iniciarBannerSlideExibir(listaOrganizada);
                    }
                    return false;
                }
            });
        }
        private void repetidorPagina(List<SliderModelo> sliderModelos) {
            if (atualPagina == sliderModelos.size() -2) {
                atualPagina = 2;
                bannerSliderViewPager.setCurrentItem(atualPagina, false);
            }
            if (atualPagina == 1) {
                atualPagina = sliderModelos.size() -3;
                bannerSliderViewPager.setCurrentItem(atualPagina, false);
            }
        }
        private void iniciarBannerSlideExibir(final List<SliderModelo> sliderModelos) {
            final Handler handler = new Handler();
            final Runnable atualizar = new Runnable() {
                @Override
                public void run() {
                    if (atualPagina >= sliderModelos.size()) {
                        atualPagina = 1;
                    }
                    bannerSliderViewPager.setCurrentItem(atualPagina++, true);
                }
            };
            timer = new Timer();
            timer.schedule(new TimerTask() {
                @Override
                public void run() {
                    handler.post(atualizar);
                }
            }, atraso, peridoTempo);
        }
        private void pararBannerSlideExibir() {
            timer.cancel();
        }
    }
    public class HorizontalProdutoViewHolder extends RecyclerView.ViewHolder {

        public HorizontalProdutoViewHolder(@NonNull View itemView) {
            super(itemView);
        }
    }
    public class GridProdutoViewHolder extends RecyclerView.ViewHolder {

        private TextView gridLayoutTitulo;
        private Button gridLayoutExibirTodosBotoes;
        private ConstraintLayout container;
        private GridLayout gridProdutoLayout;

        public GridProdutoViewHolder(@NonNull View itemView) {
            super(itemView);

            container = itemView.findViewById(R.id.gridProdutoLayout);
            gridLayoutTitulo = itemView.findViewById(R.id.gridProdutoLayoutTitulo);
            gridLayoutExibirTodosBotoes = itemView.findViewById(R.id.gridProdutoLayoutExibirTodosBtn);

        }
        private void setGridLayout(final List<HorizontalProdutoScrollModelo> horizontalProdutoScrollModeloLista, final String titulo, String cor) {

            container.setBackgroundTintList(ColorStateList.valueOf(Color.parseColor(cor)));
            gridLayoutTitulo.setText(titulo);

            GridProdutoLayoutAdapter gridProdutoLayoutAdapter = new GridProdutoLayoutAdapter(horizontalProdutoScrollModeloLista);

            for (int index = 0; index < 4; index++) {
                ImageView produtoImagem = gridProdutoLayout.getChildAt(index).findViewById(R.id.hspImagem);
                TextView produtoTitulo = gridProdutoLayout.getChildAt(index).findViewById(R.id.hspNome);
                TextView produtoDes = gridProdutoLayout.getChildAt(index).findViewById(R.id.hspDes);
                TextView produtoPreco = gridProdutoLayout.getChildAt(index).findViewById(R.id.hspPreco);

                Glide.with(itemView.getContext()).load(horizontalProdutoScrollModeloLista.get(index).getProdutoImagem()).apply(new RequestOptions().placeholder(R.mipmap.home_logo_icon)).into(produtoImagem);
                produtoTitulo.setText(horizontalProdutoScrollModeloLista.get(index).getProdutoNome());
                produtoDes.setText(horizontalProdutoScrollModeloLista.get(index).getProdutoDes());
                produtoPreco.setText(horizontalProdutoScrollModeloLista.get(index).getProdutoPreco() + "/-");

                gridProdutoLayout.getChildAt(index).setBackgroundColor(Color.parseColor("#ffffff"));

                if (!titulo.equals("")) {
                    final int finalI = index;

                    gridProdutoLayout.getChildAt(index).setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View view) {
                            Intent intent = new Intent(itemView.getContext(), ProdutoDetalhesActivity.class);

                            // para enviar o ID do produto para a atividade da página inicial
                            intent.putExtra("PRODUTO_ID", horizontalProdutoScrollModeloLista.get(finalI).getProdutoId());
                            itemView.getContext().startActivity(intent);
                        }
                    });
                }
                gridProdutoLayoutAdapter.notifyDataSetChanged();

                if (!titulo.equals("")) {
                    gridLayoutExibirTodosBotoes.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View view) {
                            
                        }
                    });
                }
            }
        }
    }
}
