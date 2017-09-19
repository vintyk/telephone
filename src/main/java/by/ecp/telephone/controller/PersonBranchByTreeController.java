package by.ecp.telephone.controller;

import by.ecp.telephone.dto.PersonDto;
import by.ecp.telephone.entity.Branch;
import by.ecp.telephone.entity.PresentPosition;
import by.ecp.telephone.service.interfaces.BranchService;
import by.ecp.telephone.service.interfaces.PersonService;
import by.ecp.telephone.service.interfaces.PresentPositionService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpSession;
import java.util.List;
import java.util.Optional;

@Controller
public class PersonBranchByTreeController {

    private PersonService personService;

    public PersonBranchByTreeController(PersonService personServiceService) {
        this.personService = personServiceService;
    }

    @RequestMapping(value = "personBranch/byTreeId/{treeId}", produces = "text/plain;charset=UTF-8", method = RequestMethod.GET)
    public ModelAndView showPersonsPageSearchByPerson(@PathVariable String treeId) {
        ModelAndView modelAndView = new ModelAndView("personsBranchByTree");
        List<PersonDto> listAllPersons = personService.findNativeByTreeId(treeId);
        modelAndView.addObject("listAllPersons", listAllPersons);
        return modelAndView;
    }
}
