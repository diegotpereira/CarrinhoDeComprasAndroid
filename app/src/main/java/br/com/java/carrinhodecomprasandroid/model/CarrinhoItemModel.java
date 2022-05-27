package br.com.java.carrinhodecomprasandroid.model;

import java.util.List;

public class CarrinhoItemModel {

    public static final int CARRINHO_ITEM = 0;
    public static final int TOTAL_QUANTIDADE = 1;
    private int tipo;

    public int getTipo() {
        return tipo;
    }

    public void setTipo(int tipo) {
        this.tipo = tipo;
    }

    // carrinho item
    private String produtoID;
    private String produtoImagem;
    private String produtoTitulo;

    private Long cuponsGratis;

    private String produtoPreco;
    private String reduzidoPreco;

    private Long produtoQuantidade;
    private Long maxQuantidade;
    private Long estoqueQuantidade;
    private Long ofertasAplicadas;
    private Long cuponsAplicados;

    private boolean emEstoque;
    private List<String> qtdIDs;
    private boolean qtdErro;
    private String selecionadoCupomId;
    private String descontoPreco;
    private boolean COD;

    public CarrinhoItemModel(String produtoID, String produtoImagem,
                             String produtoTitulo, Long cuponsGratis, String produtoPreco,
                             String reduzidoPreco, Long produtoQuantidade, Long maxQuantidade,
                             Long estoqueQuantidade, Long ofertasAplicadas, Long cuponsAplicados,
                             boolean emEstoque, List<String> qtdIDs, boolean qtdErro,
                             String selecionadoCupomId, String descontoPreco, boolean COD) {
        this.produtoID = produtoID;
        this.produtoImagem = produtoImagem;
        this.produtoTitulo = produtoTitulo;
        this.cuponsGratis = cuponsGratis;
        this.produtoPreco = produtoPreco;
        this.reduzidoPreco = reduzidoPreco;
        this.produtoQuantidade = produtoQuantidade;
        this.maxQuantidade = maxQuantidade;
        this.estoqueQuantidade = estoqueQuantidade;
        this.ofertasAplicadas = ofertasAplicadas;
        this.cuponsAplicados = cuponsAplicados;
        this.emEstoque = emEstoque;
        this.qtdIDs = qtdIDs;
        this.qtdErro = qtdErro;
        this.selecionadoCupomId = selecionadoCupomId;
        this.descontoPreco = descontoPreco;
        this.COD = COD;
    }

    public String getProdutoID() {
        return produtoID;
    }

    public void setProdutoID(String produtoID) {
        this.produtoID = produtoID;
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

    public Long getCuponsGratis() {
        return cuponsGratis;
    }

    public void setCuponsGratis(Long cuponsGratis) {
        this.cuponsGratis = cuponsGratis;
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

    public Long getProdutoQuantidade() {
        return produtoQuantidade;
    }

    public void setProdutoQuantidade(Long produtoQuantidade) {
        this.produtoQuantidade = produtoQuantidade;
    }

    public Long getMaxQuantidade() {
        return maxQuantidade;
    }

    public void setMaxQuantidade(Long maxQuantidade) {
        this.maxQuantidade = maxQuantidade;
    }

    public Long getEstoqueQuantidade() {
        return estoqueQuantidade;
    }

    public void setEstoqueQuantidade(Long estoqueQuantidade) {
        this.estoqueQuantidade = estoqueQuantidade;
    }

    public Long getOfertasAplicadas() {
        return ofertasAplicadas;
    }

    public void setOfertasAplicadas(Long ofertasAplicadas) {
        this.ofertasAplicadas = ofertasAplicadas;
    }

    public Long getCuponsAplicados() {
        return cuponsAplicados;
    }

    public void setCuponsAplicados(Long cuponsAplicados) {
        this.cuponsAplicados = cuponsAplicados;
    }

    public boolean isEmEstoque() {
        return emEstoque;
    }

    public void setEmEstoque(boolean emEstoque) {
        this.emEstoque = emEstoque;
    }

    public List<String> getQtdIDs() {
        return qtdIDs;
    }

    public void setQtdIDs(List<String> qtdIDs) {
        this.qtdIDs = qtdIDs;
    }

    public boolean isQtdErro() {
        return qtdErro;
    }

    public void setQtdErro(boolean qtdErro) {
        this.qtdErro = qtdErro;
    }

    public String getSelecionadoCupomId() {
        return selecionadoCupomId;
    }

    public void setSelecionadoCupomId(String selecionadoCupomId) {
        this.selecionadoCupomId = selecionadoCupomId;
    }

    public String getDescontoPreco() {
        return descontoPreco;
    }

    public void setDescontoPreco(String descontoPreco) {
        this.descontoPreco = descontoPreco;
    }

    public boolean isCOD() {
        return COD;
    }

    public void setCOD(boolean COD) {
        this.COD = COD;
    }

    // carrinho total
    private int totalItens;
    private int totalItemPreco;
    private int totalMontante;
    private int salvarMontante;
    private String entregaPreco;

    public CarrinhoItemModel(int tipo) {
        this.tipo = tipo;
    }

    public int getTotalItens() {
        return totalItens;
    }

    public void setTotalItens(int totalItens) {
        this.totalItens = totalItens;
    }

    public int getTotalItemPreco() {
        return totalItemPreco;
    }

    public void setTotalItemPreco(int totalItemPreco) {
        this.totalItemPreco = totalItemPreco;
    }

    public int getTotalMontante() {
        return totalMontante;
    }

    public void setTotalMontante(int totalMontante) {
        this.totalMontante = totalMontante;
    }

    public int getSalvarMontante() {
        return salvarMontante;
    }

    public void setSalvarMontante(int salvarMontante) {
        this.salvarMontante = salvarMontante;
    }

    public String getEntregaPreco() {
        return entregaPreco;
    }

    public void setEntregaPreco(String entregaPreco) {
        this.entregaPreco = entregaPreco;
    }
}
