package com.company;

import java.util.Objects;

public class Pracownik extends Osoba {

    protected int wynagordzenie;
    protected String pracodawca;
    protected String rodzajUmowy;

    public Pracownik(String pesel, String imie, String nazwisko, int wiek,
                     int wynagordzenie, String pracodawca, String rodzajUmowy) {
        super(pesel, imie, nazwisko, wiek);
        this.wynagordzenie = wynagordzenie;
        this.pracodawca = pracodawca;
        this.rodzajUmowy = rodzajUmowy;
    }

    public String getDane(Pracownik pracownik){
        return "Pracownik{" +
                "wynagordzenie=" + wynagordzenie +
                ", pracodawca='" + pracodawca + '\'' +
                ", rodzajUmowy='" + rodzajUmowy + '\'' +
                ", pesel='" + pesel + '\'' +
                ", imie='" + imie + '\'' +
                ", nazwisko='" + nazwisko + '\'' +
                ", wiek=" + wiek +
                '}';
    }

    @Override
    public String getDane(Osoba osoba) {
        return super.getDane(osoba);
    }

    public void zaktualizuj(String rodzajUmowy) {
        this.rodzajUmowy = rodzajUmowy;
        System.out.println("Zaktualizowano rodzaj umowy pracownika na " + rodzajUmowy + "!\n");
    }

    @Override
    public String toString() {
        return "Pracownik{" +
                "wynagordzenie=" + wynagordzenie +
                ", pracodawca='" + pracodawca + '\'' +
                ", rodzajUmowy='" + rodzajUmowy + '\'' +
                ", pesel='" + pesel + '\'' +
                ", imie='" + imie + '\'' +
                ", nazwisko='" + nazwisko + '\'' +
                ", wiek=" + wiek +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Pracownik)) return false;
        if (!super.equals(o)) return false;
        Pracownik pracownik = (Pracownik) o;
        return wynagordzenie == pracownik.wynagordzenie &&
                pracodawca.equals(pracownik.pracodawca) &&
                rodzajUmowy.equals(pracownik.rodzajUmowy);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), wynagordzenie, pracodawca, rodzajUmowy);
    }
}
