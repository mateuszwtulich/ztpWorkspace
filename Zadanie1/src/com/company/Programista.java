package com.company;

import java.util.Objects;

public class Programista extends Pracownik {

    private String nazwaProjektu;
    private String specjalizacja;
    private double lataDoswiadczenia;

    public Programista(String pesel, String imie, String nazwisko, int wiek, int wynagordzenie, String pracodawca,
                       String rodzajUmowy, String nazwaProjektu, String specjalizacja, double lataDoswiadczenia) {
        super(pesel, imie, nazwisko, wiek, wynagordzenie, pracodawca, rodzajUmowy);
        this.nazwaProjektu = nazwaProjektu;
        this.specjalizacja = specjalizacja;
        this.lataDoswiadczenia = lataDoswiadczenia;
    }

    public void zaktualizuj(Double lataDoswiadczenia){
        this.lataDoswiadczenia = lataDoswiadczenia;
        System.out.println("Zaktualizowano lata doswiadczenia pracownika na " + lataDoswiadczenia + "!\n");
    }

    @Override
    public String toString() {
        return "Programista{" +
                "pesel='" + pesel + '\'' +
                ", imie='" + imie + '\'' +
                ", nazwisko='" + nazwisko + '\'' +
                ", wiek=" + wiek +
                ", wynagordzenie=" + wynagordzenie +
                ", pracodawca='" + pracodawca + '\'' +
                ", rodzajUmowy='" + rodzajUmowy + '\'' +
                ", nazwaProjektu='" + nazwaProjektu + '\'' +
                ", specjalizacja='" + specjalizacja + '\'' +
                ", lataDoswiadczenia=" + lataDoswiadczenia +
                "}";
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Programista)) return false;
        if (!super.equals(o)) return false;
        Programista that = (Programista) o;
        return lataDoswiadczenia == that.lataDoswiadczenia &&
                nazwaProjektu.equals(that.nazwaProjektu) &&
                specjalizacja.equals(that.specjalizacja);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), nazwaProjektu, specjalizacja, lataDoswiadczenia);
    }
}
