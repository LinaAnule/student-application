package com.swedbank.StudentApplication.group;

import com.swedbank.StudentApplication.ControllerExceptionHandler;
import com.swedbank.StudentApplication.person.Person;
import com.swedbank.StudentApplication.person.PersonController;
import com.swedbank.StudentApplication.person.PersonService;
import com.swedbank.StudentApplication.person.exception.PersonNotFoundException;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

@SpringBootTest
public class PersonControllerTests {
    @Mock
    private PersonService service;

    @Mock
    private ControllerExceptionHandler exceptionHandler;

    @InjectMocks
    private PersonController controller;



    public List<Person> setupPersons() {
        return Arrays.asList(createPerson(39001234567L, "Jonas", "Mikalojus", "Jonaitis", "jonas.jonaitis@example.com", "+37061234567"),
                createPerson(49001123456L, "Janina", "Marija", "Petrauskienė", "janina.petrauskiene@example.com", "+37061234568"),
                createPerson(69002234567L, "Domas", null, "Jonaitis", "domas.jonaitis@example.com", "+37061234569"),
                createPerson(49002345678L, "Emilija", "Gražina", "Bružaitė", "emilija.bruzaite@example.com", "+37061234570"),
                createPerson(59003456789L, "Mikalojus", "Linas", "Valinskis", "mikalojus.valinskis@example.com", "+37061234571"));
    }

    @Test
    public void getAllPersons_shouldReturnAllPersons_andStatusOk_whenListIsNotEmpty() {
        List<Person> mockPersons = setupPersons();
        when(service.getAll()).thenReturn(mockPersons);
        ResponseEntity<List<Person>> responseEntity = controller.getAllPersons();
        verify(service, times(1)).getAll();
        assertEquals(HttpStatus.OK, responseEntity.getStatusCode());
        assertEquals(mockPersons, responseEntity.getBody());
    }

    @Test
    public void getAllPersons_shouldReturnEmptyList_andStatusOk_whenListIsEmpty() {
        when(service.getAll()).thenReturn(Collections.emptyList());
        ResponseEntity<List<Person>> responseEntity = controller.getAllPersons();
        verify(service, times(1)).getAll();
        assertEquals(HttpStatus.OK, responseEntity.getStatusCode());
        assertEquals(Collections.emptyList(), responseEntity.getBody());
    }


    @Test
    public void getByPid_shouldReturnPerson_andStatusOk_whenPersonExists() throws PersonNotFoundException {
        List<Person> mockPersons = setupPersons();
        when(service.getById(49001123456L)).thenReturn(mockPersons.get(1));
        ResponseEntity<Person> responseEntity = controller.getByPid(49001123456L);
        verify(service, times(1)).getById(49001123456L);
        assertEquals(HttpStatus.OK, responseEntity.getStatusCode());
        assertEquals(mockPersons.get(1), responseEntity.getBody());
    }


    private Person createPerson(long pid, String firstName, String middleName, String lastName, String email, String phone) {
        Person person = new Person();
        person.setPid(pid);
        person.setName(firstName);
        person.setMiddleName(middleName);
        person.setSurname(lastName);
        person.setEmail(email);
        person.setPhone(phone);
        return person;
    }
}
