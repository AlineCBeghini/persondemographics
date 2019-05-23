package com.alinebeghini.persondemographics.controller;

import java.sql.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.alinebeghini.persondemographics.entity.Person;
import com.alinebeghini.persondemographics.repository.PersonRepository;

@Controller
@RequestMapping("/")
public class PersonController {

	private PersonRepository personRepository;

	@Autowired
	public PersonController(PersonRepository personRepository) {
		this.personRepository = personRepository;
	}
	
	@RequestMapping(method = RequestMethod.GET, value = "/back")
	public String back() {
		return "index.html";
	}

	@RequestMapping(method = RequestMethod.GET, value = "/restrationperson")
	public String start() {
		return "registrationperson.html";
	}

	@RequestMapping(method = RequestMethod.GET, value = "/listpeople")
	public String listPeople(Model model) {
		List<Person> listPeople = personRepository.findAll(new Sort(Sort.Direction.ASC, "createdDate"));
        if (listPeople != null) {
              model.addAttribute("people", listPeople);
        }
        return "listPeople";
	}

	@RequestMapping(method = RequestMethod.POST, value = "/saveperson")
	public String savePerson(Person person) {
		person.setCreatedDate(new Date(System.currentTimeMillis()));
		personRepository.save(person);
        return "registrationperson.html";
	}
	
	

}
