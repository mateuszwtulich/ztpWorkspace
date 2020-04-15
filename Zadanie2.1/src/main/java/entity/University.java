package entity;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.Arrays;
import java.util.Objects;

public class University implements Cloneable, Serializable {
    public String name;
    public LocalDate dateOfEstablishment;
    public String type;
    public Faculty[] faculties;

    public University(String name, LocalDate dateOfEstablishment, String type, Faculty[] faculties) {
        this.name = name;
        this.dateOfEstablishment = dateOfEstablishment;
        this.type = type;
        this.faculties = faculties;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public LocalDate getDateOfEstablishment() {
        return dateOfEstablishment;
    }

    public void setDateOfEstablishment(LocalDate dateOfEstablishment) {
        this.dateOfEstablishment = dateOfEstablishment;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public Faculty[] getFaculties() {
        return faculties;
    }

    public void setFaculties(Faculty[] faculties) {
        this.faculties = faculties;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof University)) return false;
        University that = (University) o;
        return name.equals(that.name) &&
                dateOfEstablishment.equals(that.dateOfEstablishment) &&
                type.equals(that.type) &&
                Arrays.equals(faculties, that.faculties);
    }

    @Override
    public int hashCode() {
        int result = Objects.hash(name, dateOfEstablishment, type);
        result = 31 * result + Arrays.hashCode(faculties);
        return result;
    }

    @Override
    public Object clone() throws CloneNotSupportedException {
        University university = (University) super.clone();
        for (int i = 0; i < faculties.length; i++) {
            university.faculties[i] = (Faculty) faculties[i].clone();
        }

        return university;
    }
}
