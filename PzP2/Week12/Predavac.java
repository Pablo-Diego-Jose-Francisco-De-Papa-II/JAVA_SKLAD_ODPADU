package Week12;

public class Predavac extends Clovek {

    private int rokNastupu;
    private boolean aktualny;

    public Predavac(String meno, String priezvisko, int rokNastupu, boolean aktualny) {
        super(meno, priezvisko);
        this.rokNastupu = rokNastupu;
        this.aktualny = aktualny;
    }

    public int getRokNastupu() {
        return this.rokNastupu;
    }

    public void setRokNastupu(int rokNastupu) {
        this.rokNastupu = rokNastupu;
    }

    public boolean isAktualny() {
        return this.aktualny;
    }

    public void setAktualny(boolean aktualny) {
        this.aktualny = aktualny;
    }

    @Override
    public String toString() {
        return "Predavač " + super.toString()
                + " nastúpil do zamestnania v roku "
                + this.rokNastupu + " a má stav "
                + this.aktualny + ".";
    }

    @Override
    public String vypisCinnost() {
        return "Pracujem!";
    }

}

