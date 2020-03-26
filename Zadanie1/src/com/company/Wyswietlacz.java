package com.company;

import java.util.ArrayList;

public class Wyswietlacz {

    public static void main(String[] args) {
        Osoba osoba = new Osoba("87062303244", "Jan", "Kowalski", 32);
        Pracownik pracownik = new Pracownik("324324324", "Kamil", "Polak", 87,
                                            23123, "PolTrans", "umowa o prace");
        Programista programista = new Programista("89898898898", "Tomasz", "Nowak", 27,
                                    6600, "SoftNet", "umowa zlecenie",
                                        "IPKO", "systemy mobilne", 3);

	    Kontener<Osoba> osobaKontener = new Kontener<>();
	    osobaKontener.add(osoba);
	    osobaKontener.add(pracownik);
	    osobaKontener.add(programista);

	    Kontener<Pracownik> pracownikKontener = new Kontener<>();
        pracownikKontener.add(pracownik);
        pracownikKontener.add(programista);

	    Kontener<Programista> programistaKontener = new Kontener<>();
        programistaKontener.add(programista);

	    pokazDaneOsoby(osobaKontener);
//	    pokazDaneOsoby(pracownikKontener);
	    pokazDanePracownika(pracownikKontener);
//	    pokazDanePracownika(programistaKontener);
        pokazDaneProgramisty(programistaKontener);

        osobaKontener.getAll().forEach(o -> o.zaktualizuj(34));
        pracownikKontener.getAll().forEach(p -> p.zaktualizuj("umowa o dzieło"));
        programistaKontener.getAll().forEach(pr -> pr.zaktualizuj(4.5));
    }

    public static void pokazDaneOsoby(Kontener<Osoba> kontener){
        System.out.println("OSOBY:");
        kontener.getAll().forEach(osoba -> System.out.println(osoba.getDane(osoba)));
        System.out.println();
    }

    public static void pokazDanePracownika(Kontener<Pracownik> kontener){
        System.out.println("PRACOWNICY:");
        kontener.getAll().forEach(pracownik -> System.out.println(pracownik.getDane(pracownik)));
        System.out.println();
    }

    public static void pokazDaneProgramisty(Kontener<Programista> kontener){
        System.out.println("PROGRAMISCI:");
        kontener.getAll().forEach(programista -> System.out.println(programista.getDane(programista)));
        System.out.println();
    }
}
