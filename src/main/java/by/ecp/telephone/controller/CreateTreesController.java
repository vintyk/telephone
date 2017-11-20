package by.ecp.telephone.controller;

import by.ecp.telephone.dto.TreeDto;
import by.ecp.telephone.entity.Branch;
import by.ecp.telephone.entity.PresentPosition;
import by.ecp.telephone.entity.Tree;
import by.ecp.telephone.repository.BranchRepository;
import by.ecp.telephone.repository.PresentPositionRepository;
import by.ecp.telephone.repository.TreeRepository;
import by.ecp.telephone.service.interfaces.PresentPositionService;
import by.ecp.telephone.service.interfaces.TreeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class CreateTreesController {

    private BranchRepository branchRepository;
    private TreeRepository treeRepository;
    private TreeService treeService;
    private PresentPositionRepository presentPositionRepository;

    @Autowired
    public CreateTreesController(
            BranchRepository branchRepository,
            TreeService treeService,
            TreeRepository treeRepository,
            PresentPositionRepository presentPositionRepository
    ) {
        this.branchRepository = branchRepository;
        this.treeService = treeService;
        this.treeRepository = treeRepository;
        this.presentPositionRepository = presentPositionRepository;
    }


    @ModelAttribute("newTree")
    public TreeDto treeDto() {
        return new TreeDto();
    }

    @ModelAttribute("listAllBranches")
    public Iterable<Branch> listAllBranches() {
        return branchRepository.findAllByNameIsNotNullOrderByNameAsc();
    }

    @ModelAttribute("listAllPositions")
    public Iterable<PresentPosition> listAllPositions() {
        return presentPositionRepository.findAllPresentPositionFlagIsNull();
    }

    @GetMapping("/handbooks/createTree")
    public String showLoginPage(Model model) {
        return "createTree";
    }

    @RequestMapping(value = "/handbooks/saveTree", method = RequestMethod.POST)
    public String save(TreeDto treeDto) {
        treeService.saveTree(treeDto);
        return "redirect:/handbooks/createTree";
    }
}
