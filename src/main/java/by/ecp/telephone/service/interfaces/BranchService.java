package by.ecp.telephone.service.interfaces;

import by.ecp.telephone.dto.BranchDto;
import by.ecp.telephone.entity.Branch;

import java.util.Optional;

public interface BranchService {

    Iterable<Branch> listAllBranch();

    Optional<Branch> getBranchById(Long id);

    Branch saveBranch(BranchDto branchDto);

    void deleteBranch(Long id);
}
