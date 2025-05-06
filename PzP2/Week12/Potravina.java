package Week12;

public class Potravina implements Tovar {

    private TypPotraviny typ;
    private String nazov;
    private double hmotnost;
    private boolean trvanliva;

    public Potravina(TypPotraviny typ, String nazov, double hmotnost, boolean trvanliva) {
        this.typ = typ;
        this.nazov = nazov;
        setHmotnost(hmotnost);
        this.trvanliva = trvanliva;
    }

    public Potravina() {
        this.typ = TypPotraviny.OVOCIE;
        this.nazov = "Mandarínka";
        this.hmotnost = 0.2;
        this.trvanliva = false;
    }

    public TypPotraviny getTyp() {
        return this.typ;
    }

    public void setTyp(TypPotraviny typ) {
        this.typ = typ;
    }

    public String getNazov() {
        return this.nazov;
    }

    public void setNazov(String nazov) {
        this.nazov = nazov;
    }

    public double getHmotnost() {
        return this.hmotnost;
    }

    public void setHmotnost(double hmotnost) {
        if (hmotnost < 0) {
            throw new IllegalArgumentException("Hmotnosť nemôže byť záporná.");
        }
        this.hmotnost = hmotnost;
    }

    public boolean isTrvanliva() {
        return this.trvanliva;
    }

    public void setTrvanliva(boolean trvanliva) {
        this.trvanliva = trvanliva;
    }

    @Override
    public String toString() {
        return this.typ + " " + this.nazov + " " + this.hmotnost + " " + this.trvanliva;
    }

    @Override
    public void vypisInfo() {
        System.out.println("POTRAVINA " + toString());
    }

}
