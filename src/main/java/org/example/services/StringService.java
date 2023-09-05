package org.example.services;

import org.example.model.Person;
import org.example.validator.StringValidator;

import java.io.IOException;
import java.util.Scanner;

public class StringService {
    StringValidator stringValidator;

    public StringService(StringValidator stringValidator){
        this.stringValidator = stringValidator;
    }
    public void takeInfo() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Input Surname, Name, Patronymic, Birthday(dd.mm.yyyy), Number, Sex");
        String input = scanner.nextLine();
        stringValidator.setInfo(input.split(" "));
    }

    public Person createPerson(){
        try {
            stringValidator.validate();
            return stringValidator.getPerson();
        } catch (IOException e){
            e.getStackTrace();
            System.out.println(e.getMessage());
            return null;
        }
    }

}
