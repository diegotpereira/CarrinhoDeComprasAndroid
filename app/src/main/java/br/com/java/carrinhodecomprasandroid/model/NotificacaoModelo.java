package br.com.java.carrinhodecomprasandroid.model;

public class NotificacaoModelo {

    private String imagem;
    private String corpo;
    private boolean lida;

    public NotificacaoModelo(String imagem, String corpo, boolean lida) {
        this.imagem = imagem;
        this.corpo = corpo;
        this.lida = lida;
    }

    public String getImagem() {
        return imagem;
    }

    public void setImagem(String imagem) {
        this.imagem = imagem;
    }

    public String getCorpo() {
        return corpo;
    }

    public void setCorpo(String corpo) {
        this.corpo = corpo;
    }

    public boolean isLida() {
        return lida;
    }

    public void setLida(boolean lida) {
        this.lida = lida;
    }
}
