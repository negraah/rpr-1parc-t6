package ba.unsa.etf.rpr;

public class NastavnikOsnovneSkole extends Nastavnik {
    public NastavnikOsnovneSkole(String ime) {
        super(ime);
    }

    @Override
    public String toString() {
        return "Nastavnik osnovne škole " + getImePrezime();
    }
}
