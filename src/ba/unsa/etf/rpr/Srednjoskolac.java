package ba.unsa.etf.rpr;

import java.time.LocalDate;
import java.time.Month;

import static java.time.LocalDate.*;

public class Srednjoskolac extends Ucenik implements Slavljenik {
    private int[] ocjene_srednja = new int[100];
    private int velicina_srednjih = 0;
    private String brojKnjizice="";


    public Srednjoskolac(String imeip) {
        super(imeip);
    }

    public String getBrojKnjizice() {
        return brojKnjizice;
    }

    public void setBrojKnjizice(String brojKnjizice) {
        this.brojKnjizice = brojKnjizice;
    }

    public void dodajOcjenuSrednja(int ocjena) throws IlegalnaOcjena {
        if(ocjena<1 ||ocjena>5) {
            throw new IlegalnaOcjena("Ilegalna ocjena " + Integer.toString(ocjena));
        }
        if(velicina_srednjih>=100) {
            throw new IllegalArgumentException("Dosegnut maksimalan broj ocjena");
        }
        ocjene_srednja[velicina_srednjih++] = ocjena;
    }

    public double prosjekSrednja() {
        if(velicina_srednjih==0){
            return 0;
        }

        double suma = 0;
        for (int ocjena : ocjene_srednja) {
            suma += ocjena;
        }
        return suma/velicina_srednjih;
    }

    public double prosjek() {

        if(velicina==0 && velicina_srednjih==0){
            return 0;
        }
          double suma = 0;
        int[] niz_osnovna = getOcjene();
        for (int osnovci : niz_osnovna) {
            suma += osnovci;
        }
        for (int srednjoskolci : ocjene_srednja) {
            suma += srednjoskolci;
        }
        return suma/(velicina_srednjih+velicina);
    }

    public String rodjendan(LocalDate datum) {
       int dan =  LocalDate.now().getDayOfMonth();
       Month mjesec = now().getMonth();
     //  int godina = LocalDate.now().getYear();


       int dan1 = datum.getDayOfMonth();
       Month mjesec1 = datum.getMonth();
       //int godina1 = datum.getYear();
        if(dan==dan1 && mjesec1.equals(mjesec)){
            return "Sretan rodjendan!";
        }
        return "";
    }

    @Override
    public String toString() {
        String rez =  "Učenik srednje škole " + getImePrezime() + " (" + getBrojKnjizice() + "), prosjek ocjena: ";
        double zaokruzen = Math.round(prosjek() * 10);
        zaokruzen /= 10;
        rez += zaokruzen;
        return rez;
    }
}
