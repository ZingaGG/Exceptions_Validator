package org.example;

import org.example.model.Person;
import org.example.services.FileService;
import org.example.services.StringService;
import org.example.validator.StringValidatorService;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws IllegalAccessException {
        boolean flag = true;
        StringService stringService = new StringService(new StringValidatorService());
        Person result;
        FileService fileService = new FileService();
        Scanner scanner = new Scanner(System.in);
        String answer;

        while (flag){
            stringService.takeInfo();
            result = stringService.createPerson();
            System.out.println(result);
            fileService.setPerson(result);
            fileService.createFile();
            result.flush();

            System.out.println("Do you want to continue? Input \"no\" or \"stop\" to finish");
            answer = scanner.nextLine();
            if((answer.equalsIgnoreCase("no")) || (answer.equalsIgnoreCase("stop"))){
                flag = false;
                System.out.println("Exiting...");
            }
        }



        // Ter Il Ser 27.09.2002 8909 m

    }
}