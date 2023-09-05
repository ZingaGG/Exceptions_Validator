package org.example.validator;

import org.example.model.Person;
import org.example.exception.WrongInputFormat;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class StringValidatorService implements StringValidator {
    private Person person = new Person();
    private String[] info;

    public StringValidatorService(){

    };

    public void setInfo(String[] info) {
        this.info = info;
    }

    public Person getPerson() {
        return person;
    }

    public void validateLength(){
        try {
            if(!(info.length == 6)) {
                throw new WrongInputFormat(-1 ,"Wrong input! Expected 6 fields, received " + info.length);
            }
        } catch (WrongInputFormat e){
            System.out.println("Error code = " + e.getErrorCode());
            System.out.println(e.getMessage());
        }
    }

    public void validateSurname() throws ArrayIndexOutOfBoundsException{
        try {
            if (!(info[0].matches("^[a-zA-Z]*$"))) {
                throw new WrongInputFormat("Wrong Surname format!");
            }
            person.setSurname(info[0]);
        } catch (WrongInputFormat e) {
            System.out.println(e.getMessage());
        }
    }

    public void validateName() throws ArrayIndexOutOfBoundsException{
        try {
            if (!(info[1].matches("^[a-zA-Z]*$"))) {
                throw new WrongInputFormat("Wrong Name format!");
            }
            person.setName(info[1]);
        } catch (WrongInputFormat e) {
            System.out.println(e.getMessage());
        }
    }

    public void validatePatronymic() throws ArrayIndexOutOfBoundsException{
        try {
            if (!(info[2].matches("^[a-zA-Z]*$"))) {
                throw new WrongInputFormat("Wrong Patronymic format!");
            }
            person.setPatronymic(info[2]);
        } catch (WrongInputFormat e) {
            System.out.println(e.getMessage());
        }
    }
    public void validateDate() throws ArrayIndexOutOfBoundsException{
        try {
            SimpleDateFormat formatter = new SimpleDateFormat("dd.MM.yyyy");
            Date date;
            date = formatter.parse(info[3]);
            person.setBirthday(formatter.format(date));
        } catch (ParseException e) {
            System.out.println("Wrong date format!");
        }
    }

    public void validateNumber() throws ArrayIndexOutOfBoundsException{
        try {
            person.setNumber(Integer.parseInt(info[4]));
        } catch (NumberFormatException e){
            System.out.println("Wrong number format!");
        }
    }

    public void validateSex() throws ArrayIndexOutOfBoundsException{
        try {
            if(!(info[5].equalsIgnoreCase("f")) && !(info[5].equalsIgnoreCase("m"))) {
                throw new WrongInputFormat();
            }
            person.setSex(info[5].charAt(0));
        } catch (WrongInputFormat e){
            System.out.println("Wrong sex format!");
        }
    }

    @Override
    public void validate() throws IOException {
        validateLength();
        try {
            validateSurname();
            validateName();
            validatePatronymic();
            validateDate();
            validateNumber();
            validateSex();
        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("No more person info!");
        }

    }
}
