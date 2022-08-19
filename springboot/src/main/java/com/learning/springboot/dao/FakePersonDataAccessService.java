package com.learning.springboot.dao;

import com.learning.springboot.model.Person;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

import org.springframework.stereotype.Repository;

@Repository("fakeDao")
public class FakePersonDataAccessService implements PersonDao {
  private static List<Person> DB = new ArrayList<Person>();

  @Override
  public int insertPerson(UUID id, Person person) {
    DB.add(new Person(id, person.getName()));
    return 1;
  }

  @Override
  public List<Person> selectAllPeople() {
    return DB;
  }

  public Optional<Person> selectPersonById(UUID id) {
    return DB.stream().filter(person -> person.getId().equals(id)).findFirst();
  }

  public int updatePersonById(UUID id, Person newPerson) {
    return selectPersonById(id).map(person -> {
      int index = DB.indexOf(person);
      if (index >= 0) {
        DB.set(index, new Person(id, newPerson.getName()));
        return 1;
      }
      return 0;
    }).orElse(0);
  }

  public int deletePersonById(UUID id) {
    Optional<Person> person = selectPersonById(id);
    if (person.isEmpty()) {
      return 0;
    }
    DB.remove(person.get());
    return 1;
  }
}