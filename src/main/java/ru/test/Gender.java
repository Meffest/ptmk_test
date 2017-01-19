package ru.test;

/**
 * Пол пользователя
 */
public enum Gender {
    MAN("М"),
    WOMAN("Ж");
    private String name;

    public String getName() {
        return name;
    }

    Gender(String name) {
        this.name = name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
