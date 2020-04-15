package entity;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.Arrays;
import java.util.Objects;

public class Faculty implements Cloneable, Serializable {
    public String name;
    public LocalDate dateOfEstablishment;
    public Student[] students;

    public Faculty(String name, LocalDate dateOfEstablishment, Student[] students) {
        this.name = name;
        this.dateOfEstablishment = dateOfEstablishment;
        this.students = students;
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

    public Student[] getStudents() {
        return students;
    }

    public void setStudents(Student[] students) {
        this.students = students;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Faculty)) return false;
        Faculty faculty = (Faculty) o;
        return name.equals(faculty.name) &&
                dateOfEstablishment.equals(faculty.dateOfEstablishment) &&
                Arrays.equals(students, faculty.students);
    }

    @Override
    public int hashCode() {
        int result = Objects.hash(name, dateOfEstablishment);
        result = 31 * result + Arrays.hashCode(students);
        return result;
    }

    @Override
    public Object clone() throws CloneNotSupportedException {
        Faculty faculty = (Faculty) super.clone();
        for (int i = 0; i < students.length; i++) {
            faculty.students[i] = (Student) students[i].clone();
        }

        return faculty;
    }
}
