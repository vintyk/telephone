package by.ecp.telephone.controller;

import by.ecp.telephone.dto.PersonDto;
import by.ecp.telephone.entity.Branch;
import by.ecp.telephone.entity.Pager;
import by.ecp.telephone.entity.Person;
import by.ecp.telephone.entity.PresentPosition;
import by.ecp.telephone.service.interfaces.BranchService;
import by.ecp.telephone.service.interfaces.PersonService;
import by.ecp.telephone.service.interfaces.PresentPositionService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpSession;
import java.util.List;
import java.util.Optional;

@Controller
public class PersonBranchController {

    private PersonService personService;
    private PresentPositionService presentPositionService;
    private BranchService branchService;
    private String branchIdTemp;

    public PersonBranchController(PersonService personServiceService,
                                  PresentPositionService presentPositionService,
                                  BranchService branchService) {
        this.personService = personServiceService;
        this.presentPositionService = presentPositionService;
        this.branchService = branchService;
    }

    @ModelAttribute("listAllOffices")
    public Iterable<PresentPosition> listAllOffices(HttpSession httpSession) {
        return presentPositionService.findNativeByBranchId((String) httpSession.getAttribute("branchId"));
    }
    @ModelAttribute("listAllBranchName")
    public Optional<Branch> findBranchById(Long branchId, HttpSession httpSession) {
        String branchName = "";
        String officeName = "все подразделения";
        if (branchId == null){
            branchId = Long.valueOf(branchIdTemp);
        }

        Optional<Branch> optionBranchName = branchService.getBranchById(branchId);

        if (optionBranchName.isPresent()){
            branchName = optionBranchName.get().getName();
        }else {
            branchName = (String) httpSession.getAttribute("branchId");
        }
        httpSession.setAttribute("branchName", branchName);
        return branchService.getBranchById(branchId);
    }

    @RequestMapping(value = "/personBranch/myBranch/{searchResult}", produces = "text/plain;charset=UTF-8", method = RequestMethod.GET)
    public ModelAndView showPersonsPageSearchByBranch(@PathVariable String searchResult) {
        ModelAndView modelAndView = new ModelAndView("personsBranch");
        List<PersonDto> listAllPersons = personService.findPersonByBranch(searchResult);
        modelAndView.addObject("listAllPersons", listAllPersons);
        return modelAndView;
    }

    @RequestMapping(value = "/personBranch/office/{searchResult}", produces = "text/plain;charset=UTF-8", method = RequestMethod.GET)
    public ModelAndView showPersonsPageSearchByOffice(@PathVariable String searchResult, HttpSession httpSession) {
        ModelAndView modelAndView = new ModelAndView("personsBranch");
        modelAndView.addObject("branchId", httpSession.getAttribute("branchId"));
        String branchId = (String) httpSession.getAttribute("branchId");
        String officeId = (String) httpSession.getAttribute("officeId");
        List<PersonDto> listAllPersons = personService.findPersonByBranchAndOffice(branchId, officeId);
        modelAndView.addObject("listAllPersons", listAllPersons);
        return modelAndView;
    }

//    @RequestMapping(value = "/personBranch/byPersonId/{searchResult}", produces = "text/plain;charset=UTF-8", method = RequestMethod.GET)
//    public ModelAndView showPersonsPageSearchByPerson(@PathVariable String treeId) {
//        ModelAndView modelAndView = new ModelAndView("personsBranch");
//        List<PersonDto> listAllPersons = personService.findNativeByTreeId(treeId);
//        modelAndView.addObject("listAllPersons", listAllPersons);
//        return modelAndView;
//    }

    @PostMapping(path = "/personBranch/myBranch")
    public String search(@RequestParam String branchId,
                         HttpSession httpSession) {
        httpSession.setAttribute("branchId", branchId);
        String result = "/personBranch/myBranch/" + branchId;
        branchIdTemp = branchId;
        return "redirect:/personBranch/myBranch/" + branchId;
    }

    @PostMapping(path = "/personsBranch/office")
    public String searchByBranchId(@RequestParam String officeId,
                         HttpSession httpSession) {
        httpSession.setAttribute("officeId", officeId);
        Optional<PresentPosition> optionalPresentPosition = presentPositionService.getPresentPositionById(Long.valueOf(officeId));
        if (optionalPresentPosition.isPresent()){
            httpSession.setAttribute("officeName", (String) optionalPresentPosition.get().getName());
        }
        return "redirect:/personBranch/office/" + officeId;
    }
}
