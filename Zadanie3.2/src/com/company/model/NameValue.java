package com.company.model;

import java.util.Objects;

public class NameValue {
    private String name;
    private TypePair typePair;

    public NameValue(String name, TypePair typePair) {
        this.name = name;
        this.typePair = typePair;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public TypePair getTypePair() {
        return typePair;
    }

    public void setTypePair(TypePair typePair) {
        this.typePair = typePair;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof NameValue)) return false;
        NameValue nameValue = (NameValue) o;
        return name.equals(nameValue.name) &&
                typePair.equals(nameValue.typePair);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, typePair);
    }
}
