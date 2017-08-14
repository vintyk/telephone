package by.ecp.telephone.controller;

import by.ecp.telephone.dto.PersonDto;
import by.ecp.telephone.entity.Pager;
import by.ecp.telephone.entity.Person;
import by.ecp.telephone.service.interfaces.PersonService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpSession;
import java.util.Optional;

@Controller
public class AdminEditController {

    private static final int BUTTONS_TO_SHOW = 5;
    private static final int INITIAL_PAGE = 0;
    private static final int INITIAL_PAGE_SIZE = 7;
    private static final int[] PAGE_SIZES = {10, 15, 50};
    public static String searchR = "";
    private PersonService personService;


    public AdminEditController(PersonService personService) {
        this.personService = personService;
    }

    @RequestMapping(value = "/adminEdit", produces = "text/plain;charset=UTF-8", method = RequestMethod.GET)
    @ResponseBody
    public ModelAndView showPersonsPage(
            HttpSession httpSession,
            @RequestParam("pageSize") Optional<Integer> pageSize,
            @RequestParam("page") Optional<Integer> page) {
        ModelAndView modelAndView = new ModelAndView("adminEdit");
        int evalPageSize = pageSize.orElse(INITIAL_PAGE_SIZE);
        int evalPage = (page.orElse(0) < 1) ? INITIAL_PAGE : page.get() - 1;
        Page<Person> persons = personService.findAllPageableOrderBylastName(new PageRequest(evalPage, evalPageSize));
        Pager pager = new Pager(persons.getTotalPages(), persons.getNumber(), BUTTONS_TO_SHOW);
        PersonDto personDto = new PersonDto();
        searchR = "";
        httpSession.setAttribute("litera", "");
        modelAndView.addObject("person", personDto);
        modelAndView.addObject("persons", persons);
        modelAndView.addObject("selectedPageSize", evalPageSize);
        modelAndView.addObject("pageSizes", PAGE_SIZES);
        modelAndView.addObject("pager", pager);
        return modelAndView;
    }

    @RequestMapping(value = "/adminEdit/save", method = RequestMethod.POST)
    public String save(PersonDto personDto) {
        personService.savePersonAlphabet(personDto);
        return "redirect:/adminEdit";
    }

    @RequestMapping(value = "/adminEdit/delete/{id}", method = RequestMethod.GET)
    public String deletePerson(@PathVariable Long id) {
        this.personService.deletePerson(id);
        return "redirect:/adminEdit";
    }

    @RequestMapping(value = "/adminEdit/clone/{id}", method = RequestMethod.GET)
    public String clonePerson(@PathVariable Long id) {
        Optional<Person> personOptional = this.personService.getPersonById(id);
        if (personOptional.isPresent()) {
            PersonDto personEdit = new PersonDto();
            personEdit.setId(personOptional.get().getId());
            personEdit.setFirstName(personOptional.get().getFirstName());
            personEdit.setLastName(personOptional.get().getLastName());
            personEdit.setSName(personOptional.get().getSName());
            personEdit.setNumberShot(personOptional.get().getNumberShot());
            personEdit.setNumberCity(personOptional.get().getNumberCity());
            personEdit.setNumberMobil(personOptional.get().getNumberMobil());
            personEdit.setAlphabet(personOptional.get().getAlphabet());
            this.personService.savePersonClone(personEdit);
        }
        return "redirect:/adminEdit";
    }

    @RequestMapping(value = "/adminEdit/view/{id}")
    public String viewContact(@PathVariable Long id, Model model) {
        Optional<Person> personOptional = this.personService.getPersonById(id);
        if (personOptional.isPresent()) {
            Person person = new Person();
            person.setId(personOptional.get().getId());
            person.setFirstName(personOptional.get().getFirstName());
            person.setLastName(personOptional.get().getLastName());
            person.setSName(personOptional.get().getSName());
            person.setNumberShot(personOptional.get().getNumberShot());
            person.setNumberCity(personOptional.get().getNumberCity());
            person.setNumberMobil(personOptional.get().getNumberMobil());
            person.setAlphabet(personOptional.get().getAlphabet());
            model.addAttribute("person", person);
        } else {
            return "adminEdit";
        }
        return "view";
    }

    @RequestMapping(value = "/adminEdit/edit/{id}")
    public String editPerson(@PathVariable Long id, Model model) {
        Optional<Person> personOptional = this.personService.getPersonById(id);
        if (personOptional.isPresent()) {
            Person personEdit = new Person();
            personEdit.setId(personOptional.get().getId());
            personEdit.setFirstName(personOptional.get().getFirstName());
            personEdit.setLastName(personOptional.get().getLastName());
            personEdit.setSName(personOptional.get().getSName());
            personEdit.setNumberShot(personOptional.get().getNumberShot());
            personEdit.setNumberCity(personOptional.get().getNumberCity());
            personEdit.setNumberMobil(personOptional.get().getNumberMobil());
            personEdit.setAlphabet(personOptional.get().getAlphabet());
            model.addAttribute("person", Optional.of(personEdit));
//            model.addAttribute("person", personEdit);
        } else {
            return "adminEdit";
        }
        return "edit";
    }

    @PostMapping(path = "/adminEdit/edit/update", produces = "text/html; charset=utf-8")
    public String updatePerson(PersonDto personDto) {
        this.personService.savePerson(personDto);
        return "redirect:/adminEdit";
    }

    @RequestMapping(value = "/adminEdit/{searchResult}", produces = "text/plain;charset=UTF-8", method = RequestMethod.GET)
    @ResponseBody
    public ModelAndView showPersonsPageSearchByChar(
            HttpSession httpSession,
            @PathVariable String searchResult,
            @RequestParam("pageSize") Optional<Integer> pageSize,
            @RequestParam("page") Optional<Integer> page) {
        ModelAndView modelAndView = new ModelAndView("adminEdit");
        int evalPageSize = pageSize.orElse(INITIAL_PAGE_SIZE);
        int evalPage = (page.orElse(0) < 1) ? INITIAL_PAGE : page.get() - 1;

        if (searchResult.equals("${litera}")) {
            searchResult = searchR;
            if (searchResult.equals("")) {
                Page<Person> persons = personService.findAllPageableOrderBylastName(new PageRequest(evalPage, evalPageSize));
                Pager pager = new Pager(persons.getTotalPages(), persons.getNumber(), BUTTONS_TO_SHOW);
                Person person = new Person();
                modelAndView.addObject("litera", httpSession.getAttribute("litera"));
                modelAndView.addObject("persons", persons);
                modelAndView.addObject("person", person);
                modelAndView.addObject("selectedPageSize", evalPageSize);
                modelAndView.addObject("pageSizes", PAGE_SIZES);
                modelAndView.addObject("pager", pager);
                return modelAndView;
            }
        }
        searchR = searchResult;
        if (searchR.length() > 0) {
            httpSession.setAttribute("litera", searchR);
        }
        if (searchR.length() > 1) {
            Page<Person> persons = personService.findAllByLastNameContainsOrderByLastName(new PageRequest(evalPage, evalPageSize), searchResult);
            Pager pager = new Pager(persons.getTotalPages(), persons.getNumber(), BUTTONS_TO_SHOW);
            Person person = new Person();
            modelAndView.addObject("person", person);
            modelAndView.addObject("persons", persons);
            modelAndView.addObject("selectedPageSize", evalPageSize);
            modelAndView.addObject("pageSizes", PAGE_SIZES);
            modelAndView.addObject("pager", pager);
            return modelAndView;
        }
        Page<Person> persons = personService.findAllByAlphabetEqualsOrderByLastName(new PageRequest(evalPage, evalPageSize), searchResult);
        Pager pager = new Pager(persons.getTotalPages(), persons.getNumber(), BUTTONS_TO_SHOW);
        Person person = new Person();
        modelAndView.addObject("litera", httpSession.getAttribute("litera"));
        modelAndView.addObject("persons", persons);
        modelAndView.addObject("person", person);
        modelAndView.addObject("selectedPageSize", evalPageSize);
        modelAndView.addObject("pageSizes", PAGE_SIZES);
        modelAndView.addObject("pager", pager);
        return modelAndView;
    }

    @PostMapping(path = "/adminEdit")
    public ModelAndView search(@RequestParam String litera,
                               HttpSession httpSession,
                               @RequestParam("pageSize") Optional<Integer> pageSize,
                               @RequestParam("page") Optional<Integer> page) {
        ModelAndView modelAndView = new ModelAndView("adminEdit");
        int evalPageSize = pageSize.orElse(INITIAL_PAGE_SIZE);
        int evalPage = (page.orElse(0) < 1) ? INITIAL_PAGE : page.get() - 1;

        searchR = litera;
        Page<Person> persons = personService.findAllByLastNameContainsOrderByLastName(new PageRequest(evalPage, evalPageSize), litera);
        Pager pager = new Pager(persons.getTotalPages(), persons.getNumber(), BUTTONS_TO_SHOW);
        Person person = new Person();
        modelAndView.addObject("litera", httpSession.getAttribute("litera"));
        modelAndView.addObject("persons", persons);
        modelAndView.addObject("person", person);
        modelAndView.addObject("selectedPageSize", evalPageSize);
        modelAndView.addObject("pageSizes", PAGE_SIZES);
        modelAndView.addObject("pager", pager);
        return modelAndView;
    }
}
