package com.pyco.coreapplication.service;

import com.pyco.coreapplication.CoreApplication;
import com.pyco.coreapplication.doimain.Person;
import com.pyco.coreapplication.exception.UserAlreadyExistsException;
import com.pyco.coreapplication.repository.PersonRepository;
import com.pyco.coreapplication.service.PersonService;
import org.junit.After;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.data.mongo.DataMongoTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

import static org.assertj.core.api.Assertions.assertThat;

@ActiveProfiles(value = {"test"})
@RunWith(SpringRunner.class)
@SpringBootTest(classes = CoreApplication.class)
@EnableWebMvc
@DataMongoTest
@Ignore
public class PersonServiceTest {

    @Autowired
    private PersonService personService;

    @Autowired
    private PersonRepository personRepository;

    @Autowired
    private MongoTemplate mongoTemplate;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Before
    public void setUp() throws Exception {
        cleanUpDatabase();
    }

    @Test
    public void testRegisterPersonSuccessfully() throws UserAlreadyExistsException {
        // Given
        Person person = new Person("person", "123456");
        String password = person.getPassword();
        // When
        Person registeredPerson = personService.registerPerson(person);
        // Then
        assertThat(registeredPerson.getUsername()).isEqualTo(person.getUsername());
        assertThat(passwordEncoder.matches(password, registeredPerson.getPassword())).isTrue();
    }

    @Test(expected = UserAlreadyExistsException.class)
    public void testRegisterPersonThrowException() {
        // Given
        Person person1 = new Person("person1", "123456");
        personRepository.save(person1);
        Person duplicatedUsernamePerson = new Person("person1", "123456");
        // When
        personService.registerPerson(duplicatedUsernamePerson);
    }

    @After
    public void tearDown() throws Exception {
        cleanUpDatabase();
    }

    private void cleanUpDatabase() {
        mongoTemplate.getDb().dropDatabase();
    }
}
