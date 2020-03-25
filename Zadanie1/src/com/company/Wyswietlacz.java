package com.company;

public class Wyswietlacz {

    public static void main(String[] args) {
        Osoba osoba = new Osoba("87062303244", "Jan", "Kowalski", 32);
        Pracownik pracownik = new Pracownik("324324324", "Kamil", "Polak", 87,
                                            23123, "PolTrans", "umowa o prace");
        Programista programista = new Programista("89898898898", "Tomasz", "Nowak", 27,
                                    6600, "SoftNet", "umowa zlecenie",
                                        "IPKO", "systemy mobilne", 3);

	    Kontener<Osoba> osobaKontener = new Kontener<>(osoba);
	    Kontener<Pracownik> pracownikKontener = new Kontener<>(pracownik);
	    Kontener<Programista> programistaKontener = new Kontener<>(programista);

	    pokazDaneOsoby(osobaKontener);
//	    pokazDaneOsoby(pracownikKontener);
	    pokazDanePracownika(pracownikKontener);
//	    pokazDanePracownika(programistaKontener);
        pokazDaneProgrmaisty(programistaKontener);

        osobaKontener.getT().zaktualizuj(34);
        pracownikKontener.getT().zaktualizuj("umowa o dzieło");
        programistaKontener.getT().zaktualizuj(4.5);
    }

    public static void pokazDaneOsoby(Kontener<Osoba> kontener){
        System.out.println(kontener.toString());
    }

    public static void pokazDanePracownika(Kontener<Pracownik> kontener){
        System.out.println(kontener.toString());
    }

    public static void pokazDaneProgrmaisty(Kontener<Programista> kontener){
        System.out.println(kontener.toString());
    }
}
