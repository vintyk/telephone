package by.ecp.telephone.controller;

import by.ecp.telephone.dto.BranchDto;
import by.ecp.telephone.dto.PresentPositionDto;
import by.ecp.telephone.entity.Branch;
import by.ecp.telephone.entity.PresentPosition;
import by.ecp.telephone.repository.BranchRepository;
import by.ecp.telephone.repository.PresentPositionRepository;
import by.ecp.telephone.service.interfaces.BranchService;
import by.ecp.telephone.service.interfaces.PresentPositionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
public class HandbooksController {

    private PresentPositionRepository presentPositionRepository;
    private PresentPositionService presentPositionService;
    private BranchRepository branchRepository;
    private BranchService branchService;

    @Autowired
    public HandbooksController(
            PresentPositionRepository presentPositionRepository,
            PresentPositionService presentPositionService,
            BranchRepository branchRepository,
            BranchService branchService) {
        this.presentPositionRepository = presentPositionRepository;
        this.presentPositionService = presentPositionService;
        this.branchRepository = branchRepository;
        this.branchService = branchService;
    }

    @ModelAttribute("listAllPositions")
    public Iterable<PresentPosition> listAllPositions() {
        return presentPositionRepository.findAllPresentPositionFlagIsOne();
    }

    @ModelAttribute("listAllPositionsPresentPositions")
    public Iterable<PresentPosition> listAllPositionsPresentPositions() {
        return presentPositionRepository.findAllPresentPositionFlagIsNull();
    }

    @ModelAttribute("newPresentPosition")
    public PresentPositionDto presentPositionDto() {
        return new PresentPositionDto();
    }

    @ModelAttribute("listAllBranches")
    public Iterable<Branch> listAllBranches() {
        return branchRepository.findAll();
    }

    @ModelAttribute("newBranch")
    public BranchDto branchDto() {
        return new BranchDto();
    }

    @GetMapping("/handbooks")
    public String showLoginPage(Model model) {
        return "handbooks";
    }

    @RequestMapping(value = "/handbooks/savePresentPosition", method = RequestMethod.POST)
    public String save(PresentPositionDto presentPositionDto) {
        presentPositionDto.setIsPresentPositionFlag(0L);
        presentPositionService.savePresentPosition(presentPositionDto);
        return "redirect:/handbooks";
    }
    @RequestMapping(value = "/handbooks/savePresentPositionOne", method = RequestMethod.POST)
    public String saveOne(PresentPositionDto presentPositionDto) {
        presentPositionDto.setIsPresentPositionFlag(1L);
        presentPositionService.savePresentPosition(presentPositionDto);
        return "redirect:/handbooks";
    }

    @RequestMapping(value = "/handbooks/deletePresentPosition/{id}", method = RequestMethod.GET)
    public String deletePerson(@PathVariable Long id) {
        this.presentPositionService.deletePresentPosition(id);
        return "redirect:/handbooks";
    }

    @RequestMapping(value = "/handbooks/saveBranch", method = RequestMethod.POST)
    public String saveBranch(BranchDto branchDto) {
        branchService.saveBranch(branchDto);
        return "redirect:/handbooks";
    }

    @RequestMapping(value = "/handbooks/deleteBranch/{id}", method = RequestMethod.GET)
    public String deleteBranch(@PathVariable Long id) {
        this.branchService.deleteBranch(id);
        return "redirect:/handbooks";
    }
}
