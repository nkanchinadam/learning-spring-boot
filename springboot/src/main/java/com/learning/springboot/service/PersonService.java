package com.learning.springboot.service;

import com.learning.springboot.dao.PersonDao;
import com.learning.springboot.model.Person;

public class PersonService {
  private final PersonDao personDao;

  public PersonService(PersonDao personDao) {
    this.personDao = personDao;
  }

  public int addPerson(Person person) {
    return personDao.addPerson(person);
  }
}