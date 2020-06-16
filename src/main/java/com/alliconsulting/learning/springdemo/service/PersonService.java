package com.alliconsulting.learning.springdemo.service;

import com.alliconsulting.learning.springdemo.dao.PersonDAO;
import com.alliconsulting.learning.springdemo.model.Person;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class PersonService {

    private final PersonDAO personDAO;

    @Autowired
    public PersonService(@Qualifier("fakeDao") PersonDAO personDao){
        this.personDAO=personDao;
    }

    public int addPerson( Person person ){
        return personDAO.insertPerson(person);
    }

    public List<Person> getAllPeople(){
        return personDAO.selectAllPeople();
    }

    public Optional<Person> getPersonById(UUID id){
        return personDAO.selectPersonById(id);
    }

    public int deletePerson(UUID id){
        return personDAO.deletePerson(id);
    }

    public void updatePerson(UUID id, Person person){
        personDAO.updatePersonById(id, person);
    }

}
