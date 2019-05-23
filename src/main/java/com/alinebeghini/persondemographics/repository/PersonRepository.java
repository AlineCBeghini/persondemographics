package com.alinebeghini.persondemographics.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.alinebeghini.persondemographics.entity.Person;

public interface PersonRepository extends JpaRepository<Person, String> {

	/**
     * Find all register.
     * 
     * @return list of people
     */
    List<Person> findAll();
}
