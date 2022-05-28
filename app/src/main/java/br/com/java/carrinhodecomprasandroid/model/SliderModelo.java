package br.com.java.carrinhodecomprasandroid.model;

public class SliderModelo {

    private String banner;
    private String corDeFundo;

    public SliderModelo(String banner, String corDeFundo) {
        this.banner = banner;
        this.corDeFundo = corDeFundo;
    }

    public String getBanner() {
        return banner;
    }

    public void setBanner(String banner) {
        this.banner = banner;
    }

    public String getCorDeFundo() {
        return corDeFundo;
    }

    public void setCorDeFundo(String corDeFundo) {
        this.corDeFundo = corDeFundo;
    }
}
