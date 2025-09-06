package Week12;

import java.io.*;
import java.util.*;

public class Obchod {
    private HashMap<String, Potravina> potraviny;
    private ArrayList<Clovek> ludia;

    public Obchod() {
        this.potraviny = new HashMap<>();
        this.ludia = new ArrayList<>();
    }

    public void pridajPotravinu(String kod, Potravina potravina) {
        this.potraviny.put(kod, potravina);
    }

    public void pridajCloveka(Clovek clovek) {
        this.ludia.add(clovek);
    }

    public void vypisPotraviny() {
        for (Potravina p : this.potraviny.values()) {
            p.vypisInfo();
        }
    }

    public void vypisKody() {
        for (String kod : this.potraviny.keySet()) {
            System.out.println(kod);
        }
    }

    public void vypisLudi() {
        for (Clovek c : this.ludia) {
            System.out.println(c + " – " + c.vypisCinnost());
        }
    }

    public boolean obsahujeKod(String kod) {
        return this.potraviny.containsKey(kod);
    }

    public int pocetPotravin() {
        return this.potraviny.size();
    }

    public void vymazPotravinu(String kod) {
        this.potraviny.remove(kod);
    }

    public void zapisPotraviny() {
        try (PrintWriter writer = new PrintWriter("Week12/potraviny.txt")) {
            for (Map.Entry<String, Potravina> entry : this.potraviny.entrySet()) {
                String kod = entry.getKey();
                Potravina p = entry.getValue();
                writer.println(kod + " " + p.getTyp() + " " + p.getNazov() + " " + p.getHmotnost() + " " + p.isTrvanliva());
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void nacitajPotraviny() {
        try (Scanner sc = new Scanner(new File("Week12/potraviny.txt"))) {
            while (sc.hasNextLine()) {
                String[] casti = sc.nextLine().split(" ");
                if (casti.length == 5) {
                    String kod = casti[0];
                    TypPotraviny typ = TypPotraviny.valueOf(casti[1]);
                    String nazov = casti[2];
                    double hmotnost = Double.parseDouble(casti[3]);
                    boolean trvanliva = Boolean.parseBoolean(casti[4]);
                    pridajPotravinu(kod, new Potravina(typ, nazov, hmotnost, trvanliva));
                }
            }
        } catch (FileNotFoundException e) {
            System.out.println("Súbor potraviny.txt nebol nájdený.");
        }
    }
}

