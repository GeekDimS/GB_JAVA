package org.example.Sem3_OOP;

public class Human implements FingerPrint {
    private String name;

    public Human(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    @Override
    public String getFingerprint() {
        return "Отпечаток пальца " + name;
    }
}
