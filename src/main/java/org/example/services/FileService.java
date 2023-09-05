package org.example.services;

import org.example.model.Person;

import java.io.FileWriter;
import java.io.IOException;
import java.lang.reflect.Field;

public class FileService {
    public void setPerson(Person person) {
        this.person = person;
    }

    private Person person;
    private final String fileName = "text.txt";



    public void createFile(){
        try (FileWriter fw = new FileWriter(fileName, true)){
            fw.write(fieldChecker());
            fw.write("\n");
        } catch (IOException e) {
            e.getStackTrace();
            System.out.println(e.getMessage());
        }
    }

    private String fieldChecker() {
        StringBuilder res = new StringBuilder();
        Field[] fields = person.getClass().getDeclaredFields();
        try {
            for (Field field : fields) {
                field.setAccessible(true);
                Object value = field.get(person);
                if(value != null){
                    res.append(value);
                    res.append(" ");
                }
            }
        } catch (IllegalAccessException e){
            e.getStackTrace();
            System.out.println(e.getMessage());
        }
        return res.toString().trim();
    }
}
