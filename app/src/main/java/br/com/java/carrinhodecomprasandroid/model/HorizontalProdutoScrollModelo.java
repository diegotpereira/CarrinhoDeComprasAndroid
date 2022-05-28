package br.com.java.carrinhodecomprasandroid.model;

public class HorizontalProdutoScrollModelo {

    private String produtoId;
    private String produtoImagem;
    private String produtoNome;
    private String produtoDes;
    private String produtoPreco;

    public HorizontalProdutoScrollModelo(String produtoId, String produtoImagem, String produtoNome,
                                         String produtoDes, String produtoPreco) {
        this.produtoId = produtoId;
        this.produtoImagem = produtoImagem;
        this.produtoNome = produtoNome;
        this.produtoDes = produtoDes;
        this.produtoPreco = produtoPreco;
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

    public String getProdutoNome() {
        return produtoNome;
    }

    public void setProdutoNome(String produtoNome) {
        this.produtoNome = produtoNome;
    }

    public String getProdutoDes() {
        return produtoDes;
    }

    public void setProdutoDes(String produtoDes) {
        this.produtoDes = produtoDes;
    }

    public String getProdutoPreco() {
        return produtoPreco;
    }

    public void setProdutoPreco(String produtoPreco) {
        this.produtoPreco = produtoPreco;
    }
}
