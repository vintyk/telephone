package by.ecp.telephone.controller;

import by.ecp.telephone.dto.PersonDto;
import by.ecp.telephone.service.interfaces.PersonService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
public class PersonBranchByRoomController {

    private PersonService personService;

    public PersonBranchByRoomController(PersonService personServiceService) {
        this.personService = personServiceService;
    }

    @RequestMapping(value = "personBranch/byRoom/{idPerson}", produces = "text/plain;charset=UTF-8", method = RequestMethod.GET)
    public ModelAndView showPersonsPageSearchByPerson(@PathVariable String idPerson) {
        ModelAndView modelAndView = new ModelAndView("personsBranchByRoom");
        List<PersonDto> listAllPersons = personService.findNativeByRoom(idPerson);
        modelAndView.addObject("persons", listAllPersons);
        return modelAndView;
    }
}
