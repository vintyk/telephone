package by.ecp.telephone.repositories;


import by.ecp.telephone.configuration.RepositoryConfiguration;
import by.ecp.telephone.entity.Person;
import by.ecp.telephone.entity.PresentPosition;
import by.ecp.telephone.repository.PersonRepository;
import by.ecp.telephone.repository.PresentPositionRepository;
import by.ecp.telephone.service.interfaces.PersonService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.Optional;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes = {RepositoryConfiguration.class})
public class PersonServiceTest {
    private PersonRepository personRepository;
    private PresentPositionRepository presentPositionRepository;

    @Autowired
    public void setPersonRepository(PersonRepository personRepository) {
        this.personRepository = personRepository;
    }
    @Autowired
    public void setPresentPositionRepository(PresentPositionRepository presentPositionRepository) {
        this.presentPositionRepository = presentPositionRepository;
    }

    @Test
    public void testSavePerson() {
        PresentPosition presentPositionFromDb = new PresentPosition();
        presentPositionFromDb.setId(1L);
        presentPositionFromDb.setName("зав. сектором");
        assertNotNull(presentPositionFromDb);


        Person person = new Person();
        person.setLastName("Авдотьев");
        person.setFirstName("Андрей");
        person.setAlphabet("а");
        person.setPresentPosition(presentPositionFromDb);
        personRepository.save(person);

        Person personFromDb = personRepository.findPersonByLastName("Авдотьев");
        Long idForDelete = personFromDb.getId();
        assertEquals("Авдотьев", personFromDb.getLastName());
        System.out.println("------------------" + personFromDb);
        personRepository.deleteById(idForDelete);
    }
}