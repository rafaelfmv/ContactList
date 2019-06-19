package com.contact.controller;

import com.contact.model.Person;
import com.contact.service.ContactService;
import java.net.URI;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

@RestController
@RequestMapping(value = "/contact")
public class ContactController {

    @Autowired
    private ContactService contactService;

    @ResponseStatus(HttpStatus.OK)
    @RequestMapping(value = "/person/{ID}",
            method = RequestMethod.GET)
    public Person getPerson(@PathVariable("id") int id) {
        return contactService.getPersonById(id);
    }

    @ResponseStatus(HttpStatus.OK)
    @RequestMapping(value = "/persons",
            method = RequestMethod.GET)
    public List<Person> getPerson() {
        return contactService.getPerson();
    }

    @RequestMapping(value = "/delete/{id}", method = {RequestMethod.DELETE})
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deletePerson(@PathVariable Integer id) {
        contactService.delete(id);
    }

    @RequestMapping(value = "/person", method = {RequestMethod.POST})
    public ResponseEntity<?> addPerson(@RequestBody Person person) {
        return save(person);
    }

    @RequestMapping(value = "/person", method = {RequestMethod.PUT})
    public ResponseEntity<?> updatePerson(@RequestBody Person person) {
        return save(person);
    }

    private ResponseEntity<?> save(Person person) {
        Person result = contactService.save(person);
        final URI location = ServletUriComponentsBuilder.fromCurrentServletMapping().path("/directory/{id}").build()
                .expand(person.getId()).toUri();
        return ResponseEntity.created(location).body(result);
    }

}
