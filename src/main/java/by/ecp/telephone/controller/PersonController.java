package by.ecp.telephone.controller;

import by.ecp.telephone.entity.Pager;
import by.ecp.telephone.entity.Person;
import by.ecp.telephone.service.interfaces.PersonService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpSession;
import java.util.Optional;

@Controller
//@SessionAttributes("litera")
public class PersonController {

    private static final int BUTTONS_TO_SHOW = 5;
    private static final int INITIAL_PAGE = 0;
    private static final int INITIAL_PAGE_SIZE = 15;
    private static final int[] PAGE_SIZES = {10, 15, 50};
    public static String searchR = "";
    private PersonService personService;

    public PersonController(PersonService studentService) {
        this.personService = studentService;
    }

    @GetMapping("/")
    public ModelAndView showPersonsPage(
            HttpSession httpSession,
            @RequestParam("pageSize") Optional<Integer> pageSize,
            @RequestParam("page") Optional<Integer> page) {
        ModelAndView modelAndView = new ModelAndView("persons");
        int evalPageSize = pageSize.orElse(INITIAL_PAGE_SIZE);
        int evalPage = (page.orElse(0) < 1) ? INITIAL_PAGE : page.get() - 1;
        Page<Person> persons = personService.findAllPageableOrderBylastName(new PageRequest(evalPage, evalPageSize));
        Pager pager = new Pager(persons.getTotalPages(), persons.getNumber(), BUTTONS_TO_SHOW);
        Person person = new Person();
        searchR = "";
        httpSession.setAttribute("litera", "");
        modelAndView.addObject("person", person);
        modelAndView.addObject("persons", persons);
        modelAndView.addObject("selectedPageSize", evalPageSize);
        modelAndView.addObject("pageSizes", PAGE_SIZES);
        modelAndView.addObject("pager", pager);
        return modelAndView;
    }

    @GetMapping("/{searchResult}")
    public ModelAndView showPersonsPageSearchByChar(
            HttpSession httpSession,
            @PathVariable String searchResult,
            @RequestParam("pageSize") Optional<Integer> pageSize,
            @RequestParam("page") Optional<Integer> page) {
        ModelAndView modelAndView = new ModelAndView("persons");
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
    @PostMapping(path = "/")
    public String search(@RequestParam String litera){
        return "redirect:"+litera;
    }
}
