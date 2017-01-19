package ru.test;

import java.util.Date;

public class User {
    private int id;
    private String name;
    private Date birthDate;
    private Gender gender;

    public User() {

    }

    public User(String name, Date birthDate) {
        this.name = name;
        this.birthDate = birthDate;
    }

    public User(String name, Date birthDate, Gender gender) {
        this.name = name;
        this.birthDate = birthDate;
        this.gender = gender;
    }

    public Gender getGender() {
        return gender;
    }

    public void setGender(Gender gender) {
        this.gender = gender;
    }

    public void setGender(String gender) {
        if (gender.equals("М")) {
            this.gender = Gender.MAN;
        }else this.gender = Gender.WOMAN;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Date getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(Date birthDate) {
        this.birthDate = birthDate;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", birthDate=" + birthDate +
                ", gender=" + gender +
                '}';
    }
}
