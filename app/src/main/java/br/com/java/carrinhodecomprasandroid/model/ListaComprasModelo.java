package br.com.java.carrinhodecomprasandroid.model;

import java.util.ArrayList;

public class ListaComprasModelo {

    private String produtoId;
    private String produtoImagem;
    private String produtoTitulo;
    private long cupomGratis;
    private String avaliacao;
    private long totalAvaliacao;
    private String produtoPreco;
    private String reduzidoPreco;
    private boolean COD;
    private boolean emEstoque;
    private ArrayList<String> tags;

    public ListaComprasModelo(String produtoId, String produtoImagem, String produtoTitulo,
                              long cupomGratis, String avaliacao, long totalAvaliacao,
                              String produtoPreco, String reduzidoPreco, boolean COD,
                              boolean emEstoque) {
        this.produtoId = produtoId;
        this.produtoImagem = produtoImagem;
        this.produtoTitulo = produtoTitulo;
        this.cupomGratis = cupomGratis;
        this.avaliacao = avaliacao;
        this.totalAvaliacao = totalAvaliacao;
        this.produtoPreco = produtoPreco;
        this.reduzidoPreco = reduzidoPreco;
        this.COD = COD;
        this.emEstoque = emEstoque;
    }

    public String getProdutoId() {
        return produtoId;
    }

    public void setProdutoId(String produtoId) {
        this.produtoId = produtoId;
    }

    public String getProdutoImagem() {
        return produtoImagem;
    }

    public void setProdutoImagem(String produtoImagem) {
        this.produtoImagem = produtoImagem;
    }

    public String getProdutoTitulo() {
        return produtoTitulo;
    }

    public void setProdutoTitulo(String produtoTitulo) {
        this.produtoTitulo = produtoTitulo;
    }

    public long getCupomGratis() {
        return cupomGratis;
    }

    public void setCupomGratis(long cupomGratis) {
        this.cupomGratis = cupomGratis;
    }

    public String getAvaliacao() {
        return avaliacao;
    }

    public void setAvaliacao(String avaliacao) {
        this.avaliacao = avaliacao;
    }

    public long getTotalAvaliacao() {
        return totalAvaliacao;
    }

    public void setTotalAvaliacao(long totalAvaliacao) {
        this.totalAvaliacao = totalAvaliacao;
    }

    public String getProdutoPreco() {
        return produtoPreco;
    }

    public void setProdutoPreco(String produtoPreco) {
        this.produtoPreco = produtoPreco;
    }

    public String getReduzidoPreco() {
        return reduzidoPreco;
    }

    public void setReduzidoPreco(String reduzidoPreco) {
        this.reduzidoPreco = reduzidoPreco;
    }

    public boolean isCOD() {
        return COD;
    }

    public void setCOD(boolean COD) {
        this.COD = COD;
    }

    public boolean isEmEstoque() {
        return emEstoque;
    }

    public void setEmEstoque(boolean emEstoque) {
        this.emEstoque = emEstoque;
    }

    public ArrayList<String> getTags() {
        return tags;
    }

    public void setTags(ArrayList<String> tags) {
        this.tags = tags;
    }
}
