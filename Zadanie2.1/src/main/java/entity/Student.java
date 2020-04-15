package entity;

import java.io.Serializable;
import java.util.Objects;

public class Student implements Cloneable, Serializable {
    public String name;
    public String surname;
    public Integer index;

    public Student(String name, String surname, Integer index) {
        this.name = name;
        this.surname = surname;
        this.index = index;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public Integer getIndex() {
        return index;
    }

    public void setIndex(Integer index) {
        this.index = index;
    }



    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Student)) return false;
        Student student = (Student) o;
        return name.equals(student.name) &&
                surname.equals(student.surname) &&
                index.equals(student.index);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, surname, index);
    }

    @Override
    public Object clone() throws CloneNotSupportedException {
        return super.clone();
    }
}
