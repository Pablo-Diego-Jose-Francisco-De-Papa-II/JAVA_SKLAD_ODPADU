import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class Kniznica {
    private final ArrayList<Kniha> zoznamKnih;

    public Kniznica(String nazov) {
        this.zoznamKnih = new ArrayList<>();
    }

    public void pridajKnihu(Kniha kniha) {
        this.zoznamKnih.add(kniha);
    }

    public void vyradKnihu(Kniha kniha) {
        this.zoznamKnih.remove(kniha);
    }

    public void pozicajKnihu(Kniha kniha) {
        for (Kniha k : this.zoznamKnih) {
            if (k.equals(kniha) && !k.getPozicana()) {
                kniha.setPozicana(true);
            }
        }
    }

    public void vratKnihu(Kniha kniha) {
        for (Kniha k : this.zoznamKnih) {
            if (k.equals(kniha) && k.getPozicana()) {
                kniha.setPozicana(false);
            }
        }
    }

    public void ulozKnihyDoSuboru(String nazovSuboru) throws IOException {
        FileWriter writer = new FileWriter(nazovSuboru);

        for (Kniha k : this.zoznamKnih) {
            writer.write(k.getNazov() + ","
                    + k.getMenoAutora() + ","
                    + k.getPriezviskoAutora() + ","
                    + k.getRokVydania() + ","
                    + k.getPozicana() + "\n");
        }
        writer.close();
    }

    public void nacitajKnihyZoSuboru(String nazovSuboru) throws FileNotFoundException{
        Scanner scanner = new Scanner(new File(nazovSuboru));
        this.zoznamKnih.clear();

        while (scanner.hasNextLine()) {
            String line = scanner.nextLine();
            String[] split = line.split(",");

            if (split.length == 5) {
                Kniha kniha = new Kniha(split[0], split[1], split[2], Integer.parseInt(split[3]));
                kniha.setPozicana(Boolean.parseBoolean(split[4]));
                this.zoznamKnih.add(kniha);
            }
        }
    }

    public Kniha[] getZoznamDostupnychKnih() {
        ArrayList<Kniha> dostupneKnihy = new ArrayList<>();

        for (Kniha k : this.zoznamKnih) {
            if (!k.getPozicana()) {
                dostupneKnihy.add(k);
            }
        }

        return dostupneKnihy.toArray(new Kniha[0]);
    }

    public Kniha[] getZoznamPozicanychKnih() {
        ArrayList<Kniha> pozicaneKnihy = new ArrayList<>();

        for (Kniha k : this.zoznamKnih) {
            if (k.getPozicana()) {
                pozicaneKnihy.add(k);
            }
        }

        return pozicaneKnihy.toArray(new Kniha[0]);
    }

    public boolean jeKnihaDostupna(Kniha kniha) {
        for (Kniha k : this.zoznamKnih) {
            if (k.equals(kniha) && !kniha.getPozicana()) {
                return true;
            }
        }

        return false;
    }

    public int getPocetKnih() {
        return this.zoznamKnih.size();
    }

    public Kniha[] getZoznamVsetkychKnih() {
        return this.zoznamKnih.toArray(new Kniha[0]);
    }
}
