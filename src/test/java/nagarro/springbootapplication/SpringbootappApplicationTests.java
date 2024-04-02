package nagarro.springbootapplication;


import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import static org.mockito.Mockito.times;

import com.nagarro.springbootapp.model.Person;
import com.nagarro.springbootapp.repository.PersonRepository;
import com.nagarro.springbootapp.service.PersonService;

import static org.mockito.Mockito.when;
import static org.mockito.Mockito.verify;

import java.util.ArrayList;
public class SpringbootappApplicationTests {
	@InjectMocks
    private PersonService personService;

    @Mock
    private PersonRepository personRepository;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    public void testGetAllPersons() {
        List<Person> persons = new ArrayList<>();
        Person person1 = new Person("John", 30);
        Person person2 = new Person("Jane", 25);
        persons.add(person1);
        persons.add(person2);

        when(personRepository.findAll()).thenReturn(persons);

        List<Person> result = personService.getAllPersons();

        assertEquals(2, result.size());
        assertEquals("John", result.get(0).getName());
        assertEquals(30, result.get(0).getAge());
        assertEquals("Jane", result.get(1).getName());
        assertEquals(25, result.get(1).getAge());
    }

    @Test
    public void testGetPersonById() {
        Long id = 1L;
        Person person = new Person("John", 30);
        when(personRepository.findById(id)).thenReturn(Optional.of(person));

        Optional<Person> result = personService.getPersonById(id);

        assertNotNull(result);
        assertEquals("John", result.get().getName());
        assertEquals(30, result.get().getAge());
    }

    @Test
    public void testAddPerson() {
        Person person = new Person("John", 30);
        when(personRepository.save(person)).thenReturn(person);

        Person result = personService.addPerson(person);

        assertNotNull(result);
        assertEquals("John", result.getName());
        assertEquals(30, result.getAge());
    }

    @Test
    public void testDeletePerson() {
        Long id = 1L;
        personService.deletePerson(id);

        verify(personRepository, times(1)).deleteById(id);
    }
}
