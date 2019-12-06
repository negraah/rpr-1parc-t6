package ba.unsa.etf.rpr;

public class Osnovac extends Ucenik {
    private String brojKnjizice="";

    public Osnovac(String imeip) {
        super(imeip);
    }

    public String getBrojKnjizice() {
        return brojKnjizice;
    }

    public void setBrojKnjizice(String brojKnjizice) {
        this.brojKnjizice = brojKnjizice;
    }

    @Override
    public String toString() {
        String rez =  "Učenik osnovne škole " + getImePrezime() + " (" + getBrojKnjizice() + "), prosjek ocjena: ";
        double zaokruzen = Math.round(prosjek() * 10);
        zaokruzen /= 10;
        rez += zaokruzen;
        return rez;
    }
}
