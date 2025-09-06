public class Kniha {
    private final String nazov;
    private final String menoAutora;
    private final String priezviskoAutora;
    private final int rokVydania;
    private boolean jePozicana;

    public Kniha(String nazov, String menoAutora, String priezviskoAutora, int rokVydania) {
        this.nazov = nazov;
        this.menoAutora = menoAutora;
        this.priezviskoAutora = priezviskoAutora;
        this.rokVydania = rokVydania;
        this.jePozicana = false;
    }

    public void setPozicana(boolean jePozicana) {
        this.jePozicana = jePozicana;
    }

    public String getNazov() {
        return this.nazov;
    }

    public String getMenoAutora() {
        return this.menoAutora;
    }

    public String getPriezviskoAutora() {
        return this.priezviskoAutora;
    }

    public int getRokVydania() {
        return this.rokVydania;
    }

    public boolean getPozicana() {
        return this.jePozicana;
    }
}
