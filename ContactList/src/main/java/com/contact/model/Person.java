package com.contact.model;

import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;

@Entity(name = "person")
public class Person {
    
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Integer id;    
    private String nome;
    
    @OneToMany(cascade = {CascadeType.ALL})
    @JoinColumn(name = "contact")
    private List<Contact> contacts;

    public Integer getId() {
        return id;
    }

      public void setId(Integer id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public List<Contact> getContacts() {
        return contacts;
    }

    public void setContacts(List<Contact> contacts) {
        this.contacts = contacts;
    }
}
