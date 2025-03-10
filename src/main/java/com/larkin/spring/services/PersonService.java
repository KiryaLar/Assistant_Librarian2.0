package com.larkin.spring.services;

import com.larkin.spring.models.Person;
import com.larkin.spring.repositories.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@Service
@Transactional(readOnly = true)
public class PersonService {

    private final PersonRepository repository;
    private final PersonRepository personRepository;

    @Autowired
    public PersonService(PersonRepository repository, PersonRepository personRepository) {
        this.repository = repository;
        this.personRepository = personRepository;
    }

    public List<Person> findAll() {
        return repository.findAll();
    }

    public Person findById(int id) {
        return repository.findById(id).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Person not found"));
    }

    @Transactional
    public void save(Person person) {
        personRepository.save(person);
    }

    @Transactional
    public void update(int id, Person person) {
        person.setId(id);
        personRepository.save(person);
    }

    @Transactional
    public void deleteById(int id) {
        personRepository.deleteById(id);
    }
}
