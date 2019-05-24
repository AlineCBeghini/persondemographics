package com.alinebeghini.persondemographics.controller;

import java.sql.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.alinebeghini.persondemographics.entity.Person;
import com.alinebeghini.persondemographics.repository.PersonRepository;

/**
 * Class controller of the person entity.
 * 
 * @author Aline
 *
 */
@Controller
@RequestMapping("/")
public class PersonController {

	private static final String ERROR_PPS_NUMBER_ALREADY_REGISTERED = "PPS number already registered!";
	private static final String REGISTRATION_ADDED_SUCCESSFULLY = "Registration added successfully!";
	private static final String PHONE_PREFIX = "08";
	
	private PersonRepository personRepository;

	@Autowired
	public PersonController(PersonRepository personRepository) {
		this.personRepository = personRepository;
	}

	@RequestMapping(method = RequestMethod.GET, value = "/restrationperson")
	public String start() {
		return "registrationperson.html";
	}

	@RequestMapping(method = RequestMethod.GET, value = "/back")
	public String back() {
		return "index.html";
	}
	
	/**
	 * Executes the findAll method to get a list of people and adds that list as
	 * an attribute in the model.
	 * 
	 * @param model
	 * @return
	 */
	@RequestMapping(method = RequestMethod.GET, value = "/listpeople")
	public String listPeople(Model model) {
		List<Person> listPeople = personRepository.findAll(new Sort(Sort.Direction.ASC, "createdDate"));
        if (listPeople != null) {
              model.addAttribute("people", listPeople);
        }
        return "listPeople";
	}

	/**
	 * If the PPS number does not exist, save the person.
	 * 
	 * @param person
	 * @return
	 */
	@RequestMapping(method = RequestMethod.POST, value = "/saveperson")
	public ModelAndView savePerson(Person person) {
		ModelAndView modelAndView = new ModelAndView("/registrationperson");
		if( personRepository.findByPpsn(person.getPpsn()) == null ) {
			person.setCreatedDate(new Date(System.currentTimeMillis()));
			person.setMobilePhone(PHONE_PREFIX + person.getMobilePhone());
			personRepository.save(person);
			modelAndView.addObject("sucessMessage", REGISTRATION_ADDED_SUCCESSFULLY);
		} else {
			modelAndView.addObject("errorMessage", ERROR_PPS_NUMBER_ALREADY_REGISTERED);
		}
        return modelAndView;
	}
	
}
