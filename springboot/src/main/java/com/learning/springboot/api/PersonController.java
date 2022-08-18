package com.learning.springboot.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import com.learning.springboot.model.Person;
import com.learning.springboot.service.PersonService;

@RestController
public class PersonController {
  private final PersonService personService;

  @Autowired
  public PersonController(PersonService personService) {
    this.personService = personService;
  }

  @PostMapping
  public void addPerson(Person person) {
    personService.addPerson(person);
  }
}
