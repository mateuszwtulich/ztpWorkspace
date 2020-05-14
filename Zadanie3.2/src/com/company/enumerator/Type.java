package com.company.enumerator;

public enum Type {
    INT("int"),
    STRING("String"),
    BYTE("byte"),
    CHAR("char"),
    SHORT("short"),
    LONG("long"),
    FLOAT("float"),
    DOUBLE("double"),
    BOOLEAN("boolean")
    ;

    Type(String s) {
    this.type = s;
    }

    private String type;

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }
}
