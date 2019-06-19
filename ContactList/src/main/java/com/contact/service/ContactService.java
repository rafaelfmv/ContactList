package com.contact.service;

import com.contact.model.Person;
import java.util.List;


public interface ContactService {
    
    List<Person> getPerson();
    Person getPersonById(int id);
    Person save(Person person);
    void delete(int id);
    
}
