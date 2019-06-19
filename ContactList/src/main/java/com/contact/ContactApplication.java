package com.contact;

import com.contact.model.Contact;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import com.contact.model.Person;
import com.contact.repository.ContactRepository;
import java.util.ArrayList;
import java.util.List;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;

@SpringBootApplication
@EnableAutoConfiguration
public class ContactApplication {
	
	public static void main(String[] args) {
		SpringApplication.run(ContactApplication.class, args);
	}
	
	@Bean
	public CommandLineRunner setup(ContactRepository contactRepo) {
		return (args) -> {
			                       
                        
                        Contact c1 = new Contact();
                        c1.setEmail("ccc");
                        c1.setPhone("111");
                        
                        Contact c2 = new Contact();
                        c2.setEmail("ccc");
                        c2.setPhone("111");
                        
                        List<Contact> list = new ArrayList<>();
                        list.add(c2);
                        list.add(c1);
                                
                        
                        Person p = new Person();
                        
                        p.setNome("rafael");
                        p.setContacts(list);
                        
                        contactRepo.save(p);
		};
	}
}
