package ba.unsa.etf.rpr;

public class Ucenik extends Osoba implements Comparable{
    private String brojKnjizice;
    private int[] ocjene = new int [100];
    protected int velicina=0;

    public Ucenik(String imePrezime) {
        super(imePrezime);
    }

    public int[] getOcjene() {
        return ocjene;
    }

    public void dodajOcjenu(int ocjena) throws IlegalnaOcjena {
        if(ocjena<1 ||ocjena>5) {
        throw new IlegalnaOcjena("Ilegalna ocjena 6");
        }
        if(velicina>=100) {
            throw new IllegalArgumentException("Dosegnut maksimalan broj ocjena");
        }
        ocjene[velicina++]= ocjena;
    }

    public double prosjek() {
        if(velicina==0){
            return 0;
        }
        double suma = 0;
        for (double ocjena : ocjene) {
            suma += ocjena;
        }
        return suma/velicina;
    }

    public String getBrojKnjizice() {
        return brojKnjizice;
    }

    public void setBrojKnjizice(String s) {
        this.brojKnjizice = s;
    }


    @Override
    public int compareTo(Object o) {
        if(o instanceof Ucenik){
            Ucenik ucenik = (Ucenik) o;
            int comp = Double.compare(ucenik.prosjek(),this.prosjek());
            if(comp==0) {
                comp = ucenik.getImePrezime().compareTo(getImePrezime());
            }
            return  comp;
        }
        return 0;
    }
}
