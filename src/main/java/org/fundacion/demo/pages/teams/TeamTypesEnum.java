package org.fundacion.demo.pages.teams;

public enum TeamTypesEnum {
    EDUCATION("education");

    private final String value;

    TeamTypesEnum(final String value) {
        this.value = value;
    }

    @Override
    public String toString() {
        return value;
    }
}
