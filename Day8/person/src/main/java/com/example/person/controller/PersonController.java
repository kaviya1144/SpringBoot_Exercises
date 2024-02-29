package com.example.person.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.person.model.Person;
import com.example.person.service.PersonService;

@RestController
public class PersonController {
    
    private final PersonService personService;

   
    public PersonController(PersonService personService) {
        this.personService = personService;
    }

    @PostMapping("/personkavi")
    public ResponseEntity<Person> createPerson(@RequestBody Person person) {
        try {
            Person createdPerson = personService.createPerson(person);
            return new ResponseEntity<>(createdPerson, HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/person/startsWithName/{value}")
    public ResponseEntity<List<Person>> getStart(@PathVariable ("value") String value) {
        List<Person> personbystart = personService.getPersonByStart(value);
        if (personbystart != null) {
            return new ResponseEntity<>(personbystart, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping("/person/endsWithName/{value}")
    public ResponseEntity<List<Person>> getEnd(@PathVariable ("value") String value) {
        List<Person> personbyend = personService.getPersonByEnd(value);
        if (personbyend != null) {
            return new ResponseEntity<>(personbyend, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
}
