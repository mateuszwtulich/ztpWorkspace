package com.company.model;

import java.util.Objects;

public class TypeValue {
    private String name;
    private String value;

    public TypeValue(String name, String value) {
        this.name = name;
        this.value = value;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof TypeValue)) return false;
        TypeValue pair = (TypeValue) o;
        return Objects.equals(name, pair.name) &&
                Objects.equals(value, pair.value);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, value);
    }
}
