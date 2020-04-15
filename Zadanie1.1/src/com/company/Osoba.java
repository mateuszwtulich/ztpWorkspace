package com.company;

import java.util.Objects;

public class Osoba {

    protected String pesel;
    protected String imie;
    protected String nazwisko;
    protected int wiek;

    public Osoba(String pesel, String imie, String nazwisko, int wiek) {
        this.pesel = pesel;
        this.imie = imie;
        this.nazwisko = nazwisko;
        this.wiek = wiek;
    }

    public String getDane(Osoba osoba){
        return "Osoba{" +
                "pesel='" + pesel + '\'' +
                ", imie='" + imie + '\'' +
                ", nazwisko='" + nazwisko + '\'' +
                ", wiek=" + wiek +
                '}';
    }

    public void zaktualizuj(int wiek){
        this.wiek = wiek;
        System.out.println("Zaktualizowano wiek osoby na " + wiek + " lat!\n");
    }

    public void zaktualizuj(String nazwisko, String imie, int wiek){
        this.wiek = wiek;
        this.nazwisko = nazwisko;
        this.imie = imie;
        System.out.println("Zaktualizowano nazwisko, imie i wiek osoby na !\n");
    }

    public void zaktualizuj(String nazwisko, String imie){
        this.nazwisko = nazwisko;
        this.imie = imie;
        System.out.println("Zaktualizowano nazwisko i imie osoby na !\n");
    }

    public String getPesel() {
        return pesel;
    }

    public void setPesel(String pesel) {
        this.pesel = pesel;
    }

    public String getImie() {
        return imie;
    }

    public void setImie(String imie) {
        this.imie = imie;
    }

    public String getNazwisko() {
        return nazwisko;
    }

    public void setNazwisko(String nazwisko) {
        this.nazwisko = nazwisko;
    }

    public int getWiek() {
        return wiek;
    }

    public void setWiek(int wiek) {
        this.wiek = wiek;
    }

    @Override
    public String toString() {
        return "Osoba{" +
                "pesel='" + pesel + '\'' +
                ", imie='" + imie + '\'' +
                ", nazwisko='" + nazwisko + '\'' +
                ", wiek=" + wiek +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Osoba)) return false;
        Osoba osoba = (Osoba) o;
        return wiek == osoba.wiek &&
                pesel.equals(osoba.pesel) &&
                imie.equals(osoba.imie) &&
                nazwisko.equals(osoba.nazwisko);
    }

    @Override
    public int hashCode() {
        return Objects.hash(pesel, imie, nazwisko, wiek);
    }
}
