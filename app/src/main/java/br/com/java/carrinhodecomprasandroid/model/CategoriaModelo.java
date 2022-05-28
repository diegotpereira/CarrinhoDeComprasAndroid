package br.com.java.carrinhodecomprasandroid.model;

public class CategoriaModelo {
    private String categoriaIconeLink;
    private String categoriaNome;

    public CategoriaModelo(String categoriaIconeLink, String categoriaNome) {
        this.categoriaIconeLink = categoriaIconeLink;
        this.categoriaNome = categoriaNome;
    }

    public String getCategoriaIconeLink() {
        return categoriaIconeLink;
    }

    public void setCategoriaIconeLink(String categoriaIconeLink) {
        this.categoriaIconeLink = categoriaIconeLink;
    }

    public String getCategoriaNome() {
        return categoriaNome;
    }

    public void setCategoriaNome(String categoriaNome) {
        this.categoriaNome = categoriaNome;
    }
}
