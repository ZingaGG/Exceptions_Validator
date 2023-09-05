package org.example.model;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Scanner;

public class Person {
    public String surname;
    public String name;
    public String patronymic;
    public String birthday;
    public Integer number;
    public char sex;

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPatronymic() {
        return patronymic;
    }

    public void setPatronymic(String patronymic) {
        this.patronymic = patronymic;
    }

    public String getBirthday() {
        return birthday;
    }

    public void setBirthday(String birthday) {
        this.birthday = birthday;
    }

    public Integer getNumber() {
        return number;
    }

    public void setNumber(Integer number) {
        this.number = number;
    }

    public char getSex() {
        return sex;
    }

    public void setSex(char sex) {
        this.sex = sex;
    }

    public void flush(){
        this.surname = null;
        this.name = null;
        this.patronymic = null;
        this.birthday = null;
        this.number = null;
        this.sex = ' ';
    }

    @Override
    public String toString() {
        return "Surname - " + surname + " \n" +
                "Name - " + name + " \n" +
                "Patronymic - " + patronymic + " \n" +
                "Birthday date - " + birthday + " \n" +
                "Telephone number - " + number + " \n" +
                "Sex - " + sex + " \n";

    }
}
