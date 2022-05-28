package br.com.java.carrinhodecomprasandroid.model;

public class ProdutoEspecificaoModelo {

    public static final int ESPECIFICAO_TITULO = 0;
    public static final int ESPECIFICAO_CORPO = 1;
    private int tipo;
    private String titulo;
    private String nomeRecurso;
    private String valorRecurso;

    // especificação titulo
    public ProdutoEspecificaoModelo(int tipo, String titulo) {
        this.tipo = tipo;
        this.titulo = titulo;
    }

    // especificação corpo
    public ProdutoEspecificaoModelo(int tipo, String nomeRecurso, String valorRecurso) {
        this.tipo = tipo;
        this.nomeRecurso = nomeRecurso;
        this.valorRecurso = valorRecurso;
    }

    public int getTipo() {
        return tipo;
    }

    public void setTipo(int tipo) {
        this.tipo = tipo;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getNomeRecurso() {
        return nomeRecurso;
    }

    public void setNomeRecurso(String nomeRecurso) {
        this.nomeRecurso = nomeRecurso;
    }

    public String getValorRecurso() {
        return valorRecurso;
    }

    public void setValorRecurso(String valorRecurso) {
        this.valorRecurso = valorRecurso;
    }
}
