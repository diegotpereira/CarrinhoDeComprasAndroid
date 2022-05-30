package br.com.java.carrinhodecomprasandroid.model;

import java.util.List;

public class PrincipalPaginaModelo {

    public static final int BANNER_SLIDE = 0;
    public static final int HORIZONTAL_PRODUTO_EXIBIR = 1;
    public static final int GRID_PRODUTO_EXIBIR = 2;

    // banner
    private int tipo;
    private List<SliderModelo> sliderModels;

    public PrincipalPaginaModelo(int tipo, List<SliderModelo> sliderModels) {
        this.tipo = tipo;
        this.sliderModels =  sliderModels;
    }
    // horizontal
    private String titulo;
    private String corDeFundo;
    private List<HorizontalProdutoScrollModelo> horizontalProdutoScrollModeloLista;
    private List<ListaComprasModelo> exibirTodosProdutosLista;

    // exibir todos produto na recyclerView
    public PrincipalPaginaModelo(int tipo, String titulo, String corDeFundo,
                                 List<HorizontalProdutoScrollModelo> horizontalProdutoScrollModeloLista,
                                 List<ListaComprasModelo> exibirTodosProdutosLista) {
        this.tipo = tipo;
        this.titulo = titulo;
        this.corDeFundo = corDeFundo;
        this.horizontalProdutoScrollModeloLista = horizontalProdutoScrollModeloLista;
        this.exibirTodosProdutosLista = exibirTodosProdutosLista;
    }
    // exibir produtos apenas na horizontal recyclerView

    public PrincipalPaginaModelo(int tipo, String titulo, String corDeFundo,
                                 List<HorizontalProdutoScrollModelo> horizontalProdutoScrollModeloLista) {
        this.tipo = tipo;
        this.titulo = titulo;
        this.corDeFundo = corDeFundo;
        this.horizontalProdutoScrollModeloLista = horizontalProdutoScrollModeloLista;
    }

    //  getters e setters

    public int getTipo() {
        return tipo;
    }

    public void setTipo(int tipo) {
        this.tipo = tipo;
    }

    public List<SliderModelo> getSliderModels() {
        return sliderModels;
    }

    public void setSliderModels(List<SliderModelo> sliderModels) {
        this.sliderModels = sliderModels;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getCorDeFundo() {
        return corDeFundo;
    }

    public void setCorDeFundo(String corDeFundo) {
        this.corDeFundo = corDeFundo;
    }

    public List<HorizontalProdutoScrollModelo> getHorizontalProdutoScrollModeloLista() {
        return horizontalProdutoScrollModeloLista;
    }

    public void setHorizontalProdutoScrollModeloLista(List<HorizontalProdutoScrollModelo> horizontalProdutoScrollModeloLista) {
        this.horizontalProdutoScrollModeloLista = horizontalProdutoScrollModeloLista;
    }

    public List<ListaComprasModelo> getExibirTodosProdutosLista() {
        return exibirTodosProdutosLista;
    }

    public void setExibirTodosProdutosLista(List<ListaComprasModelo> exibirTodosProdutosLista) {
        this.exibirTodosProdutosLista = exibirTodosProdutosLista;
    }
}
