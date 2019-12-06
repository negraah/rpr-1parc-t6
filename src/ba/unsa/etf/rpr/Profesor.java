package ba.unsa.etf.rpr;

public class Profesor extends Nastavnik {
    public Profesor(String imep) {
        super(imep);
    }

    @Override
    public String toString() {
        return "Profesor " + getImePrezime();
    }
}

