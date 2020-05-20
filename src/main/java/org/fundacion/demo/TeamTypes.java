package org.fundacion.demo;

public enum TeamTypes {
    EDUCATION("education");

    private final String value;

    TeamTypes(String value) {

        this.value = value;
    }

    @Override
    public String toString() {
        return value;
    }
}
