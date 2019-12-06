package ba.unsa.etf.rpr;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;
import java.util.function.Function;
import java.util.stream.Collectors;

public class Skola {
    private ArrayList<Osoba> lista_osoba = new ArrayList<>();

    public void dodajOsobu(Osoba osoba) {
    lista_osoba.add(osoba);
    }

    @Override
    public String toString() {
        String string = "";
        for (Osoba osoba : lista_osoba) {
            string += osoba + "\n";
        }
    return string;

    }

    public Set<Ucenik> ucenici() {
    Set<Ucenik> setic = new TreeSet<>();
        for (Osoba osoba : lista_osoba) {
            if(osoba instanceof Ucenik){
                setic.add((Ucenik) osoba);
            }
        }
    return setic;
    }

    public List<Osoba> filtriraj(Function<Osoba, Boolean> f) {
        List<Osoba> lista = new ArrayList<>();
        for (Osoba osoba : lista_osoba) {
            if(f.apply(osoba) ){
                lista.add(osoba);
            }
        }
        return lista;
    }

    public List<Osnovac> topOsnovac() {
        //List<Osnovac> lista = new ArrayList<>();
       /* for (Osoba osoba : lista_osoba) {
            if(osoba instanceof Osnovac){
                Osnovac osnovac = (Osnovac)osoba;
                if(osnovac.prosjek()>4){
                    lista.add(osnovac);
                }
            }
        }
return lista;*/

       //map vraca stream!!

     ArrayList<Osoba> listaaaa = (ArrayList<Osoba>) filtriraj(osnovac-> osnovac instanceof Osnovac && ((Osnovac) osnovac).prosjek()>=4);
     return listaaaa.stream().map(osoba->(Osnovac) osoba).collect(Collectors.toList());
    }


    public List<Slavljenik> slavljenici() {
        List<Slavljenik> lista = new ArrayList<>();
        for (Osoba osoba : lista_osoba) {
            if(osoba instanceof Slavljenik && !((Slavljenik) osoba).rodjendan(LocalDate.now()).equals("")){
                lista.add((Slavljenik)osoba);
            }
        }
        return lista;
    }
}
