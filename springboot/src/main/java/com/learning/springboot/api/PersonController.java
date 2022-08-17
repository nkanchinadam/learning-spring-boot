package com.learning.springboot.api;

import com.learning.springboot.model.Person;
import com.learning.springboot.service.PersonService;

public class PersonController {
  private final PersonService personService;

  public PersonController(PersonService personService) {
    this.personService = personService;
  }

  public void addPerson(Person person) {
    personService.addPerson(person);
  }
}
