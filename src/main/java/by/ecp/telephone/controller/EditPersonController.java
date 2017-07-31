package by.ecp.telephone.controller;


import by.ecp.telephone.entity.Person;
import by.ecp.telephone.repository.PersonRepository;
import by.ecp.telephone.service.interfaces.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.Optional;

@Controller
public class EditPersonController {
    
    private final PersonService personService;

    @Autowired
    public EditPersonController(PersonService personService) {
        this.personService = personService;
    }


}
