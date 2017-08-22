package by.ecp.telephone.repositories;


import by.ecp.telephone.configuration.RepositoryConfigurationTest;
import by.ecp.telephone.entity.Branch;
import by.ecp.telephone.repository.BranchRepository;
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
@SpringBootTest(classes = {RepositoryConfigurationTest.class})
public class BranchTest {
    private BranchRepository branchRepository;

    @Autowired
    public void setBranchRepository(BranchRepository branchRepository){
        this.branchRepository = branchRepository;
    }
    @Test
    public void testSaveBranch(){
        Branch branch = new Branch();
        branch.setName("Колядичи");
        branchRepository.save(branch);
        Iterable<Branch> branches = branchRepository.findAll();
        for (Branch branch1 : branches){
            System.out.println("-------------------"+branch1);
        }
        Optional<Branch> fetchBranch = branchRepository.findById(1L);
        fetchBranch
                .ifPresent(branch1 -> assertEquals(branch1.getName(), branch.getName()));
        branchRepository.deleteById(branch.getId());
    }
}
