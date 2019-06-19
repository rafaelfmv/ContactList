package com.contact.service;

import com.contact.model.Person;
import com.contact.repository.ContactRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("ContactService")
public class ContactServiceImpl implements ContactService {
    
    @Autowired
    ContactRepository contactRepository;

    @Override
    public List<Person> getPerson() {
        return contactRepository.findAll();
    }

    @Override
    public Person getPersonById(int id) {
        return contactRepository.findOne(id);
    }

    @Override
    public Person save(Person person) {
        return contactRepository.save(person);
    }

    @Override
    public void delete(int id) {
        contactRepository.delete(id);        
    }    
}
