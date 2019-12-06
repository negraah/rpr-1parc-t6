package ba.unsa.etf.rpr;


import java.time.LocalDate;
import java.time.Month;

import static java.time.LocalDate.now;

public class Ucitelj extends Nastavnik implements Slavljenik{
    public Ucitelj(String imep) {
        super(imep);
    }

    public String rodjendan(LocalDate datum) {
        int dan =  now().getDayOfMonth();
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
        return "Učitelj " + getImePrezime();
    }
}
