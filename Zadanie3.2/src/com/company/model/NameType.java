package com.company.model;

import java.util.Objects;

public class NameType {
    private String name;
    private TypeValue typeValue;

    public NameType(String name, TypeValue typeValue) {
        this.name = name;
        this.typeValue = typeValue;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public TypeValue getTypeValue() {
        return typeValue;
    }

    public void setTypeValue(TypeValue typeValue) {
        this.typeValue = typeValue;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof NameType)) return false;
        NameType nameType = (NameType) o;
        return name.equals(nameType.name) &&
                typeValue.equals(nameType.typeValue);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, typeValue);
    }
}
