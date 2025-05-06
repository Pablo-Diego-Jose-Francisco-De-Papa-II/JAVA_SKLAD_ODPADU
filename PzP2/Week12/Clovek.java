package Week12;

public abstract class Clovek {
    private String meno;
    private String priezvisko;

    public Clovek(String meno, String priezvisko) {
        this.meno = meno;
        this.priezvisko = priezvisko;
    }

    public String getMeno() {
        return this.meno;
    }

    public void setMeno(String meno) {
        this.meno = meno;
    }

    public String getPriezvisko() {
        return this.priezvisko;
    }

    public void setPriezvisko(String priezvisko) {
        this.priezvisko = priezvisko;
    }

    @Override
    public String toString() {
        return this.meno + " " + this.priezvisko;
    }

    public abstract String vypisCinnost();
}

