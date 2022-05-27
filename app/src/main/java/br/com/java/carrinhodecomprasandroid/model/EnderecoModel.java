package br.com.java.carrinhodecomprasandroid.model;

public class EnderecoModel {

    private boolean selecionado;
    private String cidade;
    private String localizacao;
    private String casaNo;
    private String cep;
    private String pontoReferencia;
    private String nome;
    private String celularNo;
    private String alternativoCelularNo;
    private String estado;

    public EnderecoModel(boolean selecionado, String cidade, String localizacao,
                         String casaNo, String cep, String pontoReferencia, String nome,
                         String celularNo, String alternativoCelularNo, String estado) {
        this.selecionado = selecionado;
        this.cidade = cidade;
        this.localizacao = localizacao;
        this.casaNo = casaNo;
        this.cep = cep;
        this.pontoReferencia = pontoReferencia;
        this.nome = nome;
        this.celularNo = celularNo;
        this.alternativoCelularNo = alternativoCelularNo;
        this.estado = estado;
    }

    public boolean isSelecionado() {
        return selecionado;
    }

    public void setSelecionado(boolean selecionado) {
        this.selecionado = selecionado;
    }

    public String getCidade() {
        return cidade;
    }

    public void setCidade(String cidade) {
        this.cidade = cidade;
    }

    public String getLocalizacao() {
        return localizacao;
    }

    public void setLocalizacao(String localizacao) {
        this.localizacao = localizacao;
    }

    public String getCasaNo() {
        return casaNo;
    }

    public void setCasaNo(String casaNo) {
        this.casaNo = casaNo;
    }

    public String getCep() {
        return cep;
    }

    public void setCep(String cep) {
        this.cep = cep;
    }

    public String getPontoReferencia() {
        return pontoReferencia;
    }

    public void setPontoReferencia(String pontoReferencia) {
        this.pontoReferencia = pontoReferencia;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCelularNo() {
        return celularNo;
    }

    public void setCelularNo(String celularNo) {
        this.celularNo = celularNo;
    }

    public String getAlternativoCelularNo() {
        return alternativoCelularNo;
    }

    public void setAlternativoCelularNo(String alternativoCelularNo) {
        this.alternativoCelularNo = alternativoCelularNo;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }
}
