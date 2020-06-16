package com.alliconsulting.learning.springdemo.dao;

import com.alliconsulting.learning.springdemo.model.Person;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Repository("fakeDao")
public class FakePersonDataAccessService implements PersonDAO{

    private static List<Person> DB = new ArrayList<>();

    @Override
    public int insertPerson(UUID id, Person person) {
        DB.add(new Person(id,person.getName()));
        return 1;
    }

    @Override
    public List<Person> selectAllPeople() {
        return DB;
    }

    @Override
    public Optional<Person> selectPersonById(UUID id) {
        return DB.stream()
                .filter(person -> person.getId().equals(id))
                .findFirst();
    }

    @Override
    public int deletePerson(UUID id) {
        Optional<Person> personMaybe = selectPersonById(id);
        if(!personMaybe.isPresent())
            return 0;
        DB.remove(personMaybe.get());
        return 1;
    }

    private int executeUpdateAsifStrategy(UUID id, Person updatedPersonInfo){
        for(int i=0;i<DB.size();i++){
            Person thisPerson = DB.get(i);
            if(thisPerson.getId().equals(id)) {
                thisPerson.setName(updatedPersonInfo.getName());
                return 1;
            }
        }
        return 0;
    }

    private int executeUpdateTutorialStrategy(UUID id, Person updatedPersonInfo ){
        return selectPersonById(id)
                .map(thisPerson -> {
                    int indexOfPersonToUpdate = DB.indexOf(thisPerson);
                    if (indexOfPersonToUpdate >= 0) {
                        DB.set(indexOfPersonToUpdate, new Person(id,updatedPersonInfo.getName()));
                        return 1;
                    }
                    return 0;
                })
                .orElse(0);
    }

    @Override
    public int updatePersonById(UUID id, Person updatedPersonInfo) {
        return executeUpdateTutorialStrategy(id,updatedPersonInfo);
        //return executeUpdateAsifStrategy(id,updatedPersonInfo);
    }

}
