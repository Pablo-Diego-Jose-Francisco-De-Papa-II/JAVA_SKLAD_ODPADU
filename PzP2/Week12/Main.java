package Week12;

public class Main {
    public static void main(String[] args) {
        Obchod obchod = new Obchod();
        obchod.nacitajPotraviny();

        System.out.println("== Potraviny ==");
        obchod.vypisPotraviny();

        Predavac predavac = new Predavac("Predavac", "1", 2025, true);
        Zakaznik zakaznik1 = new Zakaznik("Zakaznik", "1");
        Zakaznik zakaznik2 = new Zakaznik("Zakaznik", "2");

        obchod.pridajCloveka(zakaznik1);
        obchod.pridajCloveka(zakaznik2);
        obchod.pridajCloveka(predavac);

        System.out.println("\n== Ľudia v obchode ==");
        obchod.vypisLudi();
    }
}

