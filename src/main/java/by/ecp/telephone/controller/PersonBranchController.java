package by.ecp.telephone.controller;

import by.ecp.telephone.dto.PersonDto;
import by.ecp.telephone.entity.Branch;
import by.ecp.telephone.entity.Pager;
import by.ecp.telephone.entity.Person;
import by.ecp.telephone.entity.PresentPosition;
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

    public PersonBranchController(PersonService personServiceService, PresentPositionService presentPositionService) {
        this.personService = personServiceService;
        this.presentPositionService = presentPositionService;
    }

    @ModelAttribute("listAllOffices")
    public Iterable<PresentPosition> listAllOffices(HttpSession httpSession) {
        return presentPositionService.findNativeByBranchId((String) httpSession.getAttribute("branchId"));
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
//        List<PersonDto> listAllPersons = personService.findPersonByOffice(searchResult, branchId);
//        modelAndView.addObject("listAllPersons", listAllPersons);
        return modelAndView;
    }

    @PostMapping(path = "/personBranch")
    public String search(@RequestParam String branchId,
                         HttpSession httpSession) {
        httpSession.setAttribute("branchId", branchId);
        String result = "/personBranch/myBranch/" + branchId;
        return "redirect:/personBranch/myBranch/" + branchId;
    }

    @PostMapping(path = "/personBranch/office")
    public String searchByBranchId(@RequestParam String branchId,
                         HttpSession httpSession) {
        httpSession.setAttribute("branchId", branchId);
        String result = "/personBranch" + branchId;
        return "redirect:/personBranch/myBranch/" + branchId;
    }
}
