package com.alinebeghini.persondemographics.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.alinebeghini.persondemographics.entity.Person;

/**
 * Class repository of the person entity.
 * 
 * @author Aline
 *
 */
public interface PersonRepository extends JpaRepository<Person, String> {

	/**
     * Find by pps number.
     * 
     * @return person
     */
    Person findByPpsn(String ppsn);
}
