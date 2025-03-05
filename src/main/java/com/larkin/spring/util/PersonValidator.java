package com.larkin.spring.util;

import com.larkin.spring.dao.PersonDao;
import com.larkin.spring.models.Person;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

@Component
public class PersonValidator implements Validator {

    private final PersonDao personDao;

    public PersonValidator(PersonDao personDao) {
        this.personDao = personDao;
    }

    @Override
    public boolean supports(Class<?> clazz) {
        return Person.class.equals(clazz);
    }

    @Override
    public void validate(Object target, Errors errors) {
        Person person = (Person) target;
        if (personDao.show(person.getEmail()).isPresent()) {
            errors.rejectValue("email", "", "This email is already in use");
        }
    }
}





























