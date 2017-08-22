package by.ecp.telephone.controller;

import by.ecp.telephone.dto.BranchDto;
import by.ecp.telephone.dto.PresentPositionDto;
import by.ecp.telephone.dto.TreeDto;
import by.ecp.telephone.entity.Branch;
import by.ecp.telephone.entity.PresentPosition;
import by.ecp.telephone.entity.Tree;
import by.ecp.telephone.repository.BranchRepository;
import by.ecp.telephone.repository.PresentPositionRepository;
import by.ecp.telephone.repository.TreeRepository;
import by.ecp.telephone.service.interfaces.BranchService;
import by.ecp.telephone.service.interfaces.PresentPositionService;
import by.ecp.telephone.service.interfaces.TreeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class TreesController {

    private TreeRepository treeRepository;
    private TreeService treeService;
    private BranchRepository branchRepository;

    @Autowired
    public TreesController(
            TreeService treeService,
            TreeRepository treeRepository,
            BranchRepository branchRepository
    ) {
        this.treeService = treeService;
        this.treeRepository = treeRepository;
        this.branchRepository = branchRepository;
    }

    @ModelAttribute("listAllTrees")
    public Iterable<Tree> listAlllistAllTrees() {
        return treeRepository.findAll();
    }

    @GetMapping("/handbooks/tree")
    public String showLoginPage(Model model) {
        return "tree";
    }

    @RequestMapping(value = "/handbooks/tree/deleteTree/{id}", method = RequestMethod.GET)
    public String deleteTree(@PathVariable Long id) {
        this.treeService.deleteTree(id);
        return "redirect:/handbooks/tree";
    }

}
