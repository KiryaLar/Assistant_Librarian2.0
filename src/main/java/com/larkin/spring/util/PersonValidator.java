package com.larkin.spring.util;

import com.larkin.spring.dao.PersonDao;
import com.larkin.spring.models.Person;
import com.larkin.spring.repositories.PersonRepository;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

@Component
public class PersonValidator implements Validator {

    private final PersonRepository personRepository;

    public PersonValidator(PersonRepository personRepository) {
        this.personRepository = personRepository;
    }

    @Override
    public boolean supports(Class<?> clazz) {
        return Person.class.equals(clazz);
    }

    @Override
    public void validate(Object target, Errors errors) {
        Person person = (Person) target;
        if (personRepository.findByEmail(person.getEmail()).isPresent()) {
            errors.rejectValue("email", "email.error", "This email is already in use");
        }
    }
}





























