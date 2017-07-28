package by.ecp.telephone.controller;


import by.ecp.telephone.entity.Person;
import by.ecp.telephone.repository.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class EditPersonController {
    
    @Autowired
    PersonRepository personRepository;
    
    @RequestMapping(value = "/edit/new", method = RequestMethod.GET)
    public String newPerson(Model model) {
        model.addAttribute("person", new Person());
        return "edit";
    }
//
//    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
//    public String getPerson(@PathVariable String id, Model model) {
//        model.addAttribute("id", id);
//        Person person = personRepository.findOne(id);
//        model.addAttribute("person", person);
//        return "edit";
//    }
//
    @RequestMapping(value = "/edit/save", method = RequestMethod.POST)
    public String save( Person person) {
        System.out.println("person.id = " + person.getId());
        personRepository.save(person);

        return "redirect:/edit";
    }
//
//    @RequestMapping(value = "/remove/{id}", method = RequestMethod.GET)
//    public String remove(@PathVariable String id, Model model) {
//        Person person = personRepository.findOne(id);
//        person.setDeleted(true);
//        personRepository.save(person);
//        return "redirect:/home/list";
//    }
}
