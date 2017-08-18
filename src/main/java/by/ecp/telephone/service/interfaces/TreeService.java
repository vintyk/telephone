package by.ecp.telephone.service.interfaces;

import by.ecp.telephone.dto.BranchDto;
import by.ecp.telephone.dto.TreeDto;
import by.ecp.telephone.entity.Branch;
import by.ecp.telephone.entity.Tree;

import java.util.Optional;

public interface TreeService {

    Iterable<Tree> listAllTree();

    Optional<Tree> getTreeById(Long id);

    Tree saveTree(TreeDto treeDto);

    void deleteTree(Long id);
}
