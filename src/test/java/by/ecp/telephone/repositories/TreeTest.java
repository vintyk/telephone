package by.ecp.telephone.repositories;


import by.ecp.telephone.configuration.RepositoryConfigurationTest;
import by.ecp.telephone.entity.Branch;
import by.ecp.telephone.entity.PresentPosition;
import by.ecp.telephone.entity.Tree;
import by.ecp.telephone.repository.TreeRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.Optional;

import static org.junit.Assert.assertEquals;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes = {RepositoryConfigurationTest.class})
public class TreeTest {
    private TreeRepository treeRepository;

    @Autowired
    public void setTreeRepository(TreeRepository treeRepository){
        this.treeRepository = treeRepository;
    }

    @Test
    public void testSaveTree(){
        Tree tree = new Tree();
        Branch branch = new Branch();
        branch.setId(8L);
        PresentPosition presentPositionChiefExecutive = new PresentPosition();
        presentPositionChiefExecutive.setId(12L);

        PresentPosition presentPosition1 = new PresentPosition();
        PresentPosition presentPosition2 = new PresentPosition();
        PresentPosition presentPosition3 = new PresentPosition();
        PresentPosition presentPosition4 = new PresentPosition();
        PresentPosition presentPosition5 = new PresentPosition();

        presentPosition1.setId(20L);
        presentPosition2.setId(21L);
        presentPosition3.setId(2L);
        presentPosition4.setId(11L);
        presentPosition5.setId(1L);

        tree.setBranchId(branch);
        tree.setChiefExecutiveId(presentPositionChiefExecutive);
        tree.setPresentPosition1Id(presentPosition1);
        tree.setPresentPosition2Id(presentPosition2);
        tree.setPresentPosition3Id(presentPosition3);
        tree.setPresentPosition4Id(presentPosition4);
        tree.setPresentPosition5Id(presentPosition5);

        treeRepository.save(tree);
        Iterable<Tree> trees = treeRepository.findAll();
        for (Tree tree1 : trees){
            System.out.println("-------------------"+tree1);
        }
        Optional<Tree> fetchTree = treeRepository.findById(1L);
        fetchTree
                .ifPresent(tree1 -> assertEquals(tree1.getBranchId(), tree.getBranchId()));
        treeRepository.deleteById(tree.getId());
    }
}
