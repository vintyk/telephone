package by.ecp.telephone.repositories;

import by.ecp.telephone.configuration.RepositoryConfiguration;
import by.ecp.telephone.entity.PresentPosition;
import by.ecp.telephone.repository.PresentPositionRepository;
import by.ecp.telephone.service.interfaces.PresentPositionService;
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
public class PresentPositionRepositoryTest {
    private PresentPositionRepository presentPositionRepository;
    private PresentPositionService presentPositionService;

    @Autowired
    public void setPresentPositionRepository(PresentPositionRepository presentPositionRepository) {
        this.presentPositionRepository = presentPositionRepository;
    }

    @Test
    public void testSavePresentRepository() {
        PresentPosition presentPosition = new PresentPosition();
        presentPosition.setName("специалист");

//        assertNull(presentPosition.getId());
//        presentPositionRepository.save(presentPosition);
//        assertNotNull(presentPosition.getId());

        Optional<PresentPosition> fetchPresentPosition = presentPositionRepository.findById(1L);
        fetchPresentPosition.ifPresent(presentPosition1 -> assertEquals(presentPosition1.getName(), presentPosition.getName()));

        long countPresentPosition = presentPositionRepository.count();
        assertEquals(countPresentPosition, 2);

//        long countPresentPosition2 = presentPositionService.count();
//        assertEquals(countPresentPosition2, 2);

        Iterable<PresentPosition> presentPositions = presentPositionRepository.findAll();
                int count = 0;
                for (PresentPosition p : presentPositions){
                    count++;
                    System.out.println("-------------------"+p);
                }
                assertEquals(count, 2);
    }
}
