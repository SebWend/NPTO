/**
 * Klasa glowna programu uruchamiajaca testy hierarchii dokumentow.
 * <p>
 * Krótki opis struktury atrybutów wykorzystywanych lokalnie w sekcji testowej:
 * </p>
 * <ul>
 * <li><b>baza</b> - Tablica obiektow klasy Dokument, umozliwiajaca polimorficzne wywolanie metod.</li>
 * <li><b>podbaza</b> - Tablica obiektow klasy DokumentTresc, grupujaca dokumenty tekstowe.</li>
 * </ul>
 */
public class Dokumentacja {

    /**
     * Klasa bazowa reprezentujaca ogolny dokument.
     */
    public static class Dokument {
        /** Tytul dokumentu */
        private String tytul;
        /** Autor dokumentu */
        private String autor;

        /**
         * Konstruktor klasy Dokument.
         * @param tytul Tytul dokumentu.
         * @param autor Autor dokumentu.
         */
        public Dokument(String tytul, String autor) {
            this.tytul = tytul;
            this.autor = autor;
        }

        /**
         * Zwraca tytul dokumentu.
         * @return tytul jako String.
         */
        public String getTytul() { return tytul; }

        /**
         * Zwraca autora dokumentu.
         * @return autor jako String.
         */
        public String getAutor() { return autor; }

        /**
         * Wyswietla podstawowe dane dokumentu na standardowym wyjsciu.
         */
        public void pokazDane() {
            System.out.println("Dokument: " + tytul + " | Autor: " + autor);
        }
    }

    /**
     * Klasa reprezentujaca dokument zawierajacy tresc, dziedziczaca po Dokument.
     */
    public static class DokumentTresc extends Dokument {
        /** Tresc zawarta w dokumencie */
        private String tresc;

        /**
         * Konstruktor klasy DokumentTresc.
         * @param tytul Tytul dokumentu.
         * @param autor Autor dokumentu.
         * @param tresc Tresc dokumentu.
         */
        public DokumentTresc(String tytul, String autor, String tresc) {
            super(tytul, autor);
            this.tresc = tresc;
        }

        /**
         * Zwraca tresc dokumentu.
         * @return tresc jako String.
         */
        public String getTresc() { return tresc; }
    }

    /**
     * Klasa reprezentujaca dokument formalny posiadajacy numer identyfikacyjny.
     */
    public static class DokumentFormalny extends Dokument {
        /** Unikalny numer dokumentu */
        private String numer;

        /**
         * Konstruktor klasy DokumentFormalny.
         * @param tytul Tytul dokumentu.
         * @param autor Autor dokumentu.
         * @param numer Numer dokumentu.
         */
        public DokumentFormalny(String tytul, String autor, String numer) {
            super(tytul, autor);
            this.numer = numer;
        }

        /**
         * Zwraca numer dokumentu.
         * @return numer jako String.
         */
        public String getNumer() { return numer; }
    }

    /**
     * Klasa reprezentujaca raport, ktory posiada okreslona liczbe stron.
     */
    public static class Raport extends DokumentTresc {
        /** Liczba stron raportu */
        private int strony;

        /**
         * Konstruktor klasy Raport.
         * @param tytul Tytul raportu.
         * @param autor Autor raportu.
         * @param tresc Tresc raportu.
         * @param strony Liczba stron.
         */
        public Raport(String tytul, String autor, String tresc, int strony) {
            super(tytul, autor, tresc);
            this.strony = strony;
        }

        /**
         * Wyswietla informacje o liczbie stron raportu.
         */
        public void info() {
            System.out.println("Raport ma " + strony + " stron.");
        }
    }

    /**
     * Klasa reprezentujaca notatke o okreslonym stopniu pilnosci.
     */
    public static class Notatka extends DokumentTresc {
        /** Stopien pilnosci notatki (np. Wysoka, Niska) */
        private String pilnosc;

        /**
         * Konstruktor klasy Notatka.
         * @param tytul Tytul notatki.
         * @param autor Autor notatki.
         * @param tresc Tresc notatki.
         * @param pilnosc Stopien pilnosci.
         */
        public Notatka(String tytul, String autor, String tresc, String pilnosc) {
            super(tytul, autor, tresc);
            this.pilnosc = pilnosc;
        }

        /**
         * Wyswietla informacje o pilnosci notatki.
         */
        public void info() {
            System.out.println("To notatka o pilnosci: " + pilnosc);
        }
    }

    /**
     * Klasa reprezentujaca fakture z cena brutto.
     */
    public static class Faktura extends DokumentFormalny {
        /** Cena netto/brutto na fakturze */
        private double cena;

        /**
         * Konstruktor klasy Faktura.
         * @param tytul Tytul faktury.
         * @param autor Autor faktury.
         * @param numer Numer faktury.
         * @param cena Cena faktury.
         */
        public Faktura(String tytul, String autor, String numer, double cena) {
            super(tytul, autor, numer);
            this.cena = cena;
        }

        /**
         * Oblicza i wyswietla wartosc podatku VAT (23%) dla podanej ceny.
         */
        public void obliczVat() {
            System.out.println("VAT dla tej faktury to: " + (cena * 0.23));
        }
    }

    /**
     * Klasa reprezentujaca umowe, ktora moze zostac podpisana.
     */
    public static class Umowa extends DokumentFormalny {
        /** Status podpisania umowy */
        private boolean czyPodpisana;

        /**
         * Konstruktor klasy Umowa.
         * @param tytul Tytul umowy.
         * @param autor Autor umowy.
         * @param numer Numer umowy.
         * @param czyPodpisana Poczatkowy status podpisania.
         */
        public Umowa(String tytul, String autor, String numer, boolean czyPodpisana) {
            super(tytul, autor, numer);
            this.czyPodpisana = czyPodpisana;
        }

        /**
         * Zmienia status umowy na podpisana i wyswietla komunikat.
         */
        public void podpisz() {
            this.czyPodpisana = true;
            System.out.println("Umowa zostala wlasnie podpisana!");
        }

        /**
         * Zwraca informacje, czy umowa jest podpisana.
         * @return true jesli podpisana, false w przeciwnym razie.
         */
        public boolean getCzyPodpisana() { return czyPodpisana; }
    }

    /**
     * Glowna metoda uruchomieniowa programu.
     * @param args Argumenty wiersza polecen.
     */
    public static void main(String[] args) {

        Raport rap = new Raport("Raport Roczny", "Jan", "Wyniki sa dobre", 10);
        Notatka not = new Notatka("Kupic mleko", "Marek", "Brak mleka w lodowce", "Wysoka");
        Faktura fak = new Faktura("Faktura 1", "Sklep", "FV/01", 100.0);
        Umowa umowa = new Umowa("Praca", "Szef", "U/2026", false);

        Dokument[] baza = {rap, not, fak, umowa};
        DokumentTresc[] podbaza = {rap, not};

        System.out.println("--- TEST RAPORTU ---");
        rap.pokazDane();
        System.out.println("Tresc: " + rap.getTresc());
        rap.info();

        System.out.println("\n--- TEST NOTATKI ---");
        not.pokazDane();
        System.out.println("Tresc: " + not.getTresc());
        not.info();

        System.out.println("\n--- TEST FAKTURY ---");
        fak.pokazDane();
        System.out.println("Numer: " + fak.getNumer());
        fak.obliczVat();

        System.out.println("\n--- TEST UMOWY ---");
        umowa.pokazDane();
        System.out.println("Numer: " + umowa.getNumer());
        System.out.println("Czy podpisana? " + umowa.getCzyPodpisana());
        umowa.umowa.podpisz();

        System.out.println("\n--- TEST OPERACJI WSPOLNYCH ---");
        for (Dokument d : baza) {
            d.pokazDane(); 
        }
        for (DokumentTresc dt : podbaza) {
            System.out.print("DokumentTresc: " + dt.getTytul());
            System.out.println(" | Tresc dokumentu: " + dt.getTresc());
        }
    }
}