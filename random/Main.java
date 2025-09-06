import java.io.IOException;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) throws IOException {
        Kniha kniha = new Kniha("a", "a", "a", 2000);
        Kniha kniha1 = new Kniha("b", "b", "b", 100);
        Kniha kniha2 = new Kniha("c", "c", "c", 3972);

        Kniznica kniznica = new Kniznica("ahoj.txt");
        kniznica.pridajKnihu(kniha);
        kniznica.pridajKnihu(kniha2);

        System.out.println(Arrays.toString(kniznica.getZoznamVsetkychKnih()));

        System.out.println(kniznica.getPocetKnih());
        System.out.println(kniznica.getZoznamDostupnychKnih());
        System.out.println(kniznica.getZoznamPozicanychKnih());
        kniznica.pridajKnihu(kniha1);
        System.out.println(kniznica.getPocetKnih());
        kniznica.ulozKnihyDoSuboru("ahoj.txt");
        kniznica.nacitajKnihyZoSuboru("ahoj.txt");
        System.out.println(kniznica.getPocetKnih());
        System.out.println(Arrays.toString(kniznica.getZoznamVsetkychKnih()));
    }
}
