package br.com.java.carrinhodecomprasandroid.model;

import java.util.Date;

public class MeuPedidoItemModelo {

    private String produtoId;
    private String produtoTitulo;
    private String produtoImagem;
    private String pedidoStatus;
    private String endereco;
    private String cupomId;
    private String reduzidoPreco;
    private Date pedidoData;
    private Date separacaoData;
    private Date envioData;
    private Date entregaData;
    private Date canceladoData;

    private String descontoPreco;
    private Long cupomGratis;
    private String nome;
    private String pedidoID;
    private String pagamentoMetodo;
    private String cep;
    private String produtoPreco;
    private Long produtoQuantidade;
    private String usuarioId;
    private String entregaPreco;
    private boolean cancelamentoSolicitado;
    private int avaliacoes = 0;

    public MeuPedidoItemModelo(String produtoId, String produtoTitulo, String produtoImagem, String pedidoStatus, String endereco, String cupomId, String reduzidoPreco, Date pedidoData, Date separacaoData, Date envioData, Date entregaData, Date canceladoData, String descontoPreco, Long cupomGratis, String nome, String pedidoID, String pagamentoMetodo, String cep, String produtoPreco, Long produtoQuantidade, String usuarioId, String entregaPreco, boolean cancelamentoSolicitado, int avaliacoes) {
        this.produtoId = produtoId;
        this.produtoTitulo = produtoTitulo;
        this.produtoImagem = produtoImagem;
        this.pedidoStatus = pedidoStatus;
        this.endereco = endereco;
        this.cupomId = cupomId;
        this.reduzidoPreco = reduzidoPreco;
        this.pedidoData = pedidoData;
        this.separacaoData = separacaoData;
        this.envioData = envioData;
        this.entregaData = entregaData;
        this.canceladoData = canceladoData;
        this.descontoPreco = descontoPreco;
        this.cupomGratis = cupomGratis;
        this.nome = nome;
        this.pedidoID = pedidoID;
        this.pagamentoMetodo = pagamentoMetodo;
        this.cep = cep;
        this.produtoPreco = produtoPreco;
        this.produtoQuantidade = produtoQuantidade;
        this.usuarioId = usuarioId;
        this.entregaPreco = entregaPreco;
        this.cancelamentoSolicitado = cancelamentoSolicitado;
        this.avaliacoes = avaliacoes;
    }

    public String getProdutoId() {
        return produtoId;
    }

    public void setProdutoId(String produtoId) {
        this.produtoId = produtoId;
    }

    public String getProdutoTitulo() {
        return produtoTitulo;
    }

    public void setProdutoTitulo(String produtoTitulo) {
        this.produtoTitulo = produtoTitulo;
    }

    public String getProdutoImagem() {
        return produtoImagem;
    }

    public void setProdutoImagem(String produtoImagem) {
        this.produtoImagem = produtoImagem;
    }

    public String getPedidoStatus() {
        return pedidoStatus;
    }

    public void setPedidoStatus(String pedidoStatus) {
        this.pedidoStatus = pedidoStatus;
    }

    public String getEndereco() {
        return endereco;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    public String getCupomId() {
        return cupomId;
    }

    public void setCupomId(String cupomId) {
        this.cupomId = cupomId;
    }

    public String getReduzidoPreco() {
        return reduzidoPreco;
    }

    public void setReduzidoPreco(String reduzidoPreco) {
        this.reduzidoPreco = reduzidoPreco;
    }

    public Date getPedidoData() {
        return pedidoData;
    }

    public void setPedidoData(Date pedidoData) {
        this.pedidoData = pedidoData;
    }

    public Date getSeparacaoData() {
        return separacaoData;
    }

    public void setSeparacaoData(Date separacaoData) {
        this.separacaoData = separacaoData;
    }

    public Date getEnvioData() {
        return envioData;
    }

    public void setEnvioData(Date envioData) {
        this.envioData = envioData;
    }

    public Date getEntregaData() {
        return entregaData;
    }

    public void setEntregaData(Date entregaData) {
        this.entregaData = entregaData;
    }

    public Date getCanceladoData() {
        return canceladoData;
    }

    public void setCanceladoData(Date canceladoData) {
        this.canceladoData = canceladoData;
    }

    public String getDescontoPreco() {
        return descontoPreco;
    }

    public void setDescontoPreco(String descontoPreco) {
        this.descontoPreco = descontoPreco;
    }

    public Long getCupomGratis() {
        return cupomGratis;
    }

    public void setCupomGratis(Long cupomGratis) {
        this.cupomGratis = cupomGratis;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getPedidoID() {
        return pedidoID;
    }

    public void setPedidoID(String pedidoID) {
        this.pedidoID = pedidoID;
    }

    public String getPagamentoMetodo() {
        return pagamentoMetodo;
    }

    public void setPagamentoMetodo(String pagamentoMetodo) {
        this.pagamentoMetodo = pagamentoMetodo;
    }

    public String getCep() {
        return cep;
    }

    public void setCep(String cep) {
        this.cep = cep;
    }

    public String getProdutoPreco() {
        return produtoPreco;
    }

    public void setProdutoPreco(String produtoPreco) {
        this.produtoPreco = produtoPreco;
    }

    public Long getProdutoQuantidade() {
        return produtoQuantidade;
    }

    public void setProdutoQuantidade(Long produtoQuantidade) {
        this.produtoQuantidade = produtoQuantidade;
    }

    public String getUsuarioId() {
        return usuarioId;
    }

    public void setUsuarioId(String usuarioId) {
        this.usuarioId = usuarioId;
    }

    public String getEntregaPreco() {
        return entregaPreco;
    }

    public void setEntregaPreco(String entregaPreco) {
        this.entregaPreco = entregaPreco;
    }

    public boolean isCancelamentoSolicitado() {
        return cancelamentoSolicitado;
    }

    public void setCancelamentoSolicitado(boolean cancelamentoSolicitado) {
        this.cancelamentoSolicitado = cancelamentoSolicitado;
    }

    public int getAvaliacoes() {
        return avaliacoes;
    }

    public void setAvaliacoes(int avaliacoes) {
        this.avaliacoes = avaliacoes;
    }
}
