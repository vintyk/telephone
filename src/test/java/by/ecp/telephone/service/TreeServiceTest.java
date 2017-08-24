package by.ecp.telephone.service;


import by.ecp.telephone.configuration.RepositoryConfigurationTest;
import by.ecp.telephone.dto.TreeDto;
import by.ecp.telephone.service.interfaces.TreeService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes = {RepositoryConfigurationTest.class})
public class TreeServiceTest {

    private TreeService treeService;

    @Autowired
    public void setTreeServiceTest(TreeService treeService){
        this.treeService = treeService;
    }

    @Test
    public void testSaveTree() {
//        TreeDto treeDto = new TreeDto();
//
//        treeDto.setBranchId(8L);
//        treeDto.setChiefExecutiveId(12L);
//        treeDto.setPresentPosition1Id(20L);
//        treeDto.setPresentPosition2Id(21L);
//        treeDto.setPresentPosition3Id(2L);
//        treeDto.setPresentPosition4Id(11L);
//        treeDto.setPresentPosition5Id(1L);
//
//        treeService.saveTree(treeDto);

    }
}
