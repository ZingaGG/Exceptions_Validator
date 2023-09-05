package org.example.validator;

import org.example.model.Person;

import java.io.IOException;

public interface StringValidator {
    void validate() throws IOException;
    void setInfo(String[] info);
    Person getPerson();

}
