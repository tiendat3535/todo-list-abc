package com.pyco.coreapplication.service;

import com.pyco.coreapplication.exception.UserAlreadyExistsException;
import com.pyco.coreapplication.doimain.Person;

import java.util.Optional;

public interface PersonService {
    /**
     * Register a Person with username and password
     * @param person {@link Person} the information of person want to register (username and password)
     * @return registered person
     */
    Person registerPerson(Person person) throws UserAlreadyExistsException;

    /**
     * Find Person based on its username
     * @param username username of person
     * @return found {@link Person}
     */
    Optional<Person> findPersonByUsername(String username);

}
