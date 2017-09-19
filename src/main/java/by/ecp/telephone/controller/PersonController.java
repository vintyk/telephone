package by.ecp.telephone.controller;

import by.ecp.telephone.dto.PersonDto;
import by.ecp.telephone.entity.Branch;
import by.ecp.telephone.entity.Pager;
import by.ecp.telephone.entity.Person;
import by.ecp.telephone.repository.BranchRepository;
import by.ecp.telephone.service.interfaces.PersonService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpSession;
import java.util.Optional;

@Controller
//@SessionAttributes("litera")
public class PersonController {

    private static final int BUTTONS_TO_SHOW = 5;
    private static final int INITIAL_PAGE = 0;
    private static final int INITIAL_PAGE_SIZE = 10;
    private static final int[] PAGE_SIZES = {10, 15, 50};
    public static String searchR = "";
    private PersonService personService;
    private BranchRepository branchRepository;

    public PersonController(PersonService personServiceService, BranchRepository branchRepository) {
        this.personService = personServiceService;
        this.branchRepository = branchRepository;
    }

    @ModelAttribute("listAllBranches")
    public Iterable<Branch> listAllBranches() {
        return branchRepository.findAllByNameIsNotNullOrderByNameAsc();
    }

    //    @GetMapping("/")
    @RequestMapping(value = "/", produces = "text/plain;charset=UTF-8", method = RequestMethod.GET)
    @ResponseBody
    public ModelAndView showPersonsPage(
            HttpSession httpSession,
            @RequestParam("pageSize") Optional<Integer> pageSize,
            @RequestParam("page") Optional<Integer> page) {
        ModelAndView modelAndView = new ModelAndView("persons");
        int evalPageSize = pageSize.orElse(INITIAL_PAGE_SIZE);
        int evalPage = (page.orElse(0) < 1) ? INITIAL_PAGE : page.get() - 1;
        Page<PersonDto> persons = personService.findAllPageableOrderBylastNameStringPresentPosition(new PageRequest(evalPage, evalPageSize));

        Pager pager = new Pager(persons
                .getTotalPages(),
                persons.getNumber(),
                BUTTONS_TO_SHOW);
        PersonDto personDto = new PersonDto();
        searchR = "";
        httpSession.setAttribute("litera", "");
        httpSession.setAttribute("branchId", "");
        httpSession.setAttribute("officeName", "");
        modelAndView.addObject("person", personDto);
        modelAndView.addObject("persons", persons);
        modelAndView.addObject("selectedPageSize", evalPageSize);
        modelAndView.addObject("pageSizes", PAGE_SIZES);
        modelAndView.addObject("pager", pager);
        return modelAndView;
    }

    //    @GetMapping("/{searchResult}")
    @RequestMapping(value = "/{searchResult}", produces = "text/plain;charset=UTF-8", method = RequestMethod.GET)
    @ResponseBody
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
                Page<PersonDto> persons = personService.findAllPageableOrderBylastNameStringPresentPosition(new PageRequest(evalPage, evalPageSize));
                Pager pager = new Pager(persons.getTotalPages(), persons.getNumber(), BUTTONS_TO_SHOW);
                PersonDto personDto = new PersonDto();
                modelAndView.addObject("litera", httpSession.getAttribute("litera"));
                modelAndView.addObject("persons", persons);
                modelAndView.addObject("person", personDto);
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
            Page<PersonDto> persons = personService.findAllByLastNameContainsOrderByLastNameStringPresentPosition(new PageRequest(evalPage, evalPageSize), searchResult);
            Pager pager = new Pager(persons.getTotalPages(), persons.getNumber(), BUTTONS_TO_SHOW);
            PersonDto personDto = new PersonDto();
            modelAndView.addObject("persons", persons);
            modelAndView.addObject("selectedPageSize", evalPageSize);
            modelAndView.addObject("pageSizes", PAGE_SIZES);
            modelAndView.addObject("pager", pager);
            return modelAndView;
        }
        Page<PersonDto> persons = personService.findAllByAlphabetEqualsOrderByLastNameStringPresentPosition(new PageRequest(evalPage, evalPageSize), searchResult);
        Pager pager = new Pager(persons.getTotalPages(), persons.getNumber(), BUTTONS_TO_SHOW);
        PersonDto personDto = new PersonDto();
        modelAndView.addObject("litera", httpSession.getAttribute("litera"));
        modelAndView.addObject("persons", persons);
        modelAndView.addObject("person", personDto);
        modelAndView.addObject("selectedPageSize", evalPageSize);
        modelAndView.addObject("pageSizes", PAGE_SIZES);
        modelAndView.addObject("pager", pager);
        return modelAndView;
    }

    @PostMapping(path = "/")
    public ModelAndView search(@RequestParam String litera,
                               HttpSession httpSession,
                               @RequestParam("pageSize") Optional<Integer> pageSize,
                               @RequestParam("page") Optional<Integer> page) {
        ModelAndView modelAndView = new ModelAndView("persons");
        int evalPageSize = pageSize.orElse(INITIAL_PAGE_SIZE);
        int evalPage = (page.orElse(0) < 1) ? INITIAL_PAGE : page.get() - 1;

            searchR = litera;
                Page<PersonDto> persons = personService.findAllByLastNameContainsOrderByLastNameStringPresentPosition(new PageRequest(evalPage, evalPageSize), litera);
                Pager pager = new Pager(persons.getTotalPages(), persons.getNumber(), BUTTONS_TO_SHOW);
                PersonDto personDto = new PersonDto();
                modelAndView.addObject("litera", httpSession.getAttribute("litera"));
                modelAndView.addObject("persons", persons);
                modelAndView.addObject("person", personDto);
                modelAndView.addObject("selectedPageSize", evalPageSize);
                modelAndView.addObject("pageSizes", PAGE_SIZES);
                modelAndView.addObject("pager", pager);
                return modelAndView;
    }
}
