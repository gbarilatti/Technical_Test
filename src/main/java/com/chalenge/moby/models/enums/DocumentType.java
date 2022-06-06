package com.chalenge.moby.models.enums;

public enum DocumentType {
    DNI("DNI"),
    LE("LE"),
    LC("LC");

    private final String string;

    DocumentType(final String string)
    {
        this.string = string;
    }

    public String get()
    {
        return string;
    }
}
