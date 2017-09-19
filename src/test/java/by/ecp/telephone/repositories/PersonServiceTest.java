package by.ecp.telephone.repositories;


import by.ecp.telephone.configuration.RepositoryConfigurationTest;
import by.ecp.telephone.entity.Branch;
import by.ecp.telephone.entity.Person;
import by.ecp.telephone.entity.PresentPosition;
import by.ecp.telephone.entity.Tree;
import by.ecp.telephone.repository.PersonRepository;
import by.ecp.telephone.repository.PresentPositionRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes = {RepositoryConfigurationTest.class})
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
//        PresentPosition presentPositionFromDb = new PresentPosition();
//        presentPositionFromDb.setId(1L);
//        presentPositionFromDb.setName("зав. сектором");
//        assertNotNull(presentPositionFromDb);
//
//        Branch branch = new Branch();
//        branch.setId(1L);
//
//        PresentPosition chiefExecutive = new PresentPosition();
//        chiefExecutive.setId(12L);
//
//        Tree treeFromDb = new Tree();
//        treeFromDb.setId(38L);
//        treeFromDb.setBranchId(branch);
//        treeFromDb.setChiefExecutiveId(chiefExecutive);
//
//        Person person = new Person();
//        person.setLastName("Авдотьев");
//        person.setFirstName("Андрей");
//        person.setAlphabet("а");
//        person.setPresentPosition(presentPositionFromDb);
//        person.setTreeId(treeFromDb);
//        personRepository.save(person);
//
//        Person personFromDb = personRepository.findPersonByLastName("Авдотьев");
//        Long idForDelete = personFromDb.getId();
//        assertEquals("Авдотьев", personFromDb.getLastName());
//        System.out.println("------------------" + personFromDb);
//        personRepository.deleteById(idForDelete);
    }
}
