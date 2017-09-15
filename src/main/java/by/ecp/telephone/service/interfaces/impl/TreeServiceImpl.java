package by.ecp.telephone.service.interfaces.impl;

import by.ecp.telephone.dto.BranchDto;
import by.ecp.telephone.dto.TreeDto;
import by.ecp.telephone.entity.Branch;
import by.ecp.telephone.entity.PresentPosition;
import by.ecp.telephone.entity.Tree;
import by.ecp.telephone.repository.BranchRepository;
import by.ecp.telephone.repository.TreeRepository;
import by.ecp.telephone.service.interfaces.BranchService;
import by.ecp.telephone.service.interfaces.TreeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Transactional
@Service
public class TreeServiceImpl implements TreeService {

    private TreeRepository treeRepository;

    @Autowired
    public TreeServiceImpl(TreeRepository treeRepository) {
        this.treeRepository = treeRepository;
    }

    @Override
    public Iterable<Tree> listAllTree() {
        return treeRepository.findAll();
    }

    @Override
    public Optional<Tree> getTreeById(Long id) {
        return treeRepository.findById(id);
    }

    @Override
    public void saveTree(TreeDto treeDto) {
        Tree tree = new Tree();
        Branch branch = new Branch();
        PresentPosition presentPositionChiefExecutive = new PresentPosition();
        PresentPosition presentPosition1 = new PresentPosition();
        PresentPosition presentPosition2 = new PresentPosition();
        PresentPosition presentPosition3 = new PresentPosition();
        PresentPosition presentPosition4 = new PresentPosition();
        PresentPosition presentPosition5 = new PresentPosition();

        branch.setId(treeDto.getBranchId());
        presentPositionChiefExecutive.setId(treeDto.getChiefExecutiveId());
        presentPosition1.setId(treeDto.getPresentPosition1Id());
        presentPosition2.setId(treeDto.getPresentPosition2Id());
        presentPosition3.setId(treeDto.getPresentPosition3Id());
        presentPosition4.setId(treeDto.getPresentPosition4Id());
        presentPosition5.setId(treeDto.getPresentPosition5Id());

        tree.setBranchId(branch);
        tree.setChiefExecutiveId(presentPositionChiefExecutive);
        tree.setPresentPosition1Id(presentPosition1);
        tree.setPresentPosition2Id(presentPosition2);
        tree.setPresentPosition3Id(presentPosition3);
        tree.setPresentPosition4Id(presentPosition4);
        tree.setPresentPosition5Id(presentPosition5);
        this.treeRepository.save(tree);
    }

    @Override
    public void deleteTree(Long id) {
        treeRepository.deleteById(id);
    }


}
