package com.company.enumerator;

public enum Flag {
    GETTERS("getters"),
    SETTERS("setters"),
    BUILDER("builder"),
    SAVE("save");

    Flag(String s) {
        this.flag = s;
    }

    private String flag;

    public String getFlag() {
        return flag;
    }

    public void setFlag(String flag) {
        this.flag = flag;
    }
}
