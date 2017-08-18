package by.ecp.telephone.service.interfaces.impl;

import by.ecp.telephone.dto.BranchDto;
import by.ecp.telephone.dto.PresentPositionDto;
import by.ecp.telephone.entity.Branch;
import by.ecp.telephone.entity.PresentPosition;
import by.ecp.telephone.repository.BranchRepository;
import by.ecp.telephone.repository.PresentPositionRepository;
import by.ecp.telephone.service.interfaces.BranchService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Transactional
@Service
public class BranchServiceImpl implements BranchService {

    private BranchRepository branchRepository;

    @Autowired
    public BranchServiceImpl(BranchRepository branchRepository) {
        this.branchRepository = branchRepository;
    }

    @Override
    public Iterable<Branch> listAllBranch() {
        return branchRepository.findAll();
    }

    @Override
    public Optional<Branch> getBranchById(Long id) {
        return branchRepository.findById(id);
    }

    @Override
    public Branch saveBranch(BranchDto branchDto) {
        Branch branch = new Branch();
        branch.setName(branchDto.getName());
        return branchRepository.save(branch);
    }

    @Override
    public void deleteBranch(Long id){
        branchRepository.deleteById(id);
    }
}
