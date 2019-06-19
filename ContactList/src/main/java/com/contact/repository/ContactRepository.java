package com.contact.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.contact.model.Person;

@Repository("ContactRepository")
public interface ContactRepository extends JpaRepository<Person, Integer> {}
