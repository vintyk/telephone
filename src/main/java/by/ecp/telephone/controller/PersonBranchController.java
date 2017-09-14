package by.ecp.telephone.controller;

import by.ecp.telephone.dto.PersonDto;
import by.ecp.telephone.entity.Person;
import by.ecp.telephone.service.interfaces.PersonService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
public class PersonBranchController {

    private PersonService personService;

    public PersonBranchController(PersonService personServiceService) {
        this.personService = personServiceService;
    }

    @RequestMapping(value = "/personBranch/{searchResult}", produces = "text/plain;charset=UTF-8", method = RequestMethod.GET)
    public ModelAndView showPersonsPageSearchByBranch(@PathVariable String searchResult) {
        ModelAndView modelAndView = new ModelAndView("personsBranch");
        List<PersonDto> listAllPersons = personService.findPersonByBranch(searchResult);
        modelAndView.addObject("listAllPersons", listAllPersons);
        return modelAndView;
    }
    @RequestMapping(value = "/personBranch/{searchResult}", produces = "text/plain;charset=UTF-8", method = RequestMethod.POST)
    public ModelAndView showPersonsSearchByBranchPost(@PathVariable String searchResult) {
        ModelAndView modelAndView = new ModelAndView("personsBranch");
        List<PersonDto> listAllPersons = personService.findPersonByBranch(searchResult);
        modelAndView.addObject("listAllPersons", listAllPersons);
        return modelAndView;
    }
}
