package com.company.model;

import java.util.Date;
import java.util.Objects;

public class Faculty {
    private String name;
    private Date dateOfEstablishment;
    private String address;

    public Faculty(String name, Date dateOfEstablishment, String address) {
        this.name = name;
        this.dateOfEstablishment = dateOfEstablishment;
        this.address = address;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Date getDateOfEstablishment() {
        return dateOfEstablishment;
    }

    public void setDateOfEstablishment(Date dateOfEstablishment) {
        this.dateOfEstablishment = dateOfEstablishment;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    @Override
    public String toString() {
        return "Wydział " +
                " " + name +
                ", data powstania: " + dateOfEstablishment +
                ", adres: " + address;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Faculty)) return false;
        Faculty faculty = (Faculty) o;
        return name.equals(faculty.name) &&
                dateOfEstablishment.equals(faculty.dateOfEstablishment) &&
                address.equals(faculty.address);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, dateOfEstablishment, address);
    }
}
