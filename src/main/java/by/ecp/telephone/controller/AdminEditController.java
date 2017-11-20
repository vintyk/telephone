package by.ecp.telephone.controller;

import by.ecp.telephone.dto.PersonDto;
import by.ecp.telephone.entity.Pager;
import by.ecp.telephone.entity.Person;
import by.ecp.telephone.entity.PresentPosition;
import by.ecp.telephone.entity.Tree;
import by.ecp.telephone.repository.PresentPositionRepository;
import by.ecp.telephone.service.interfaces.PersonService;
import by.ecp.telephone.service.interfaces.PresentPositionService;
import by.ecp.telephone.service.interfaces.TreeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpSession;
import java.util.List;
import java.util.Optional;

@Controller
public class AdminEditController {

    private static final int BUTTONS_TO_SHOW = 5;
    private static final int INITIAL_PAGE = 0;
    private static final int INITIAL_PAGE_SIZE = 5;
    private static final int[] PAGE_SIZES = {10, 15, 50};
    public static String searchR = "";
    private PersonService personService;
    private PresentPositionRepository presentPositionRepository;
    private TreeService treeService;

    @Autowired
    public AdminEditController(PersonService personService,
                               PresentPositionRepository presentPositionRepository,
                               TreeService treeService) {
        this.personService = personService;
        this.presentPositionRepository = presentPositionRepository;
        this.treeService = treeService;
    }

    @ModelAttribute("listAllPositions")
    public Iterable<PresentPosition> listAllPositions(){
        return presentPositionRepository.findAllPresentPositionFlagIsOne();
    }
    @ModelAttribute("listAllTrees")
    public Iterable<Tree> listAllTree(){
        return treeService.listAllTree();
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

        Page<PersonDto> persons = personService.findAllPageableOrderBylastName(new PageRequest(evalPage, evalPageSize));
//        Iterable<PresentPosition> presentPositions = presentPositionRepository.findAll();
        Pager pager = new Pager(persons.getTotalPages(), persons.getNumber(), BUTTONS_TO_SHOW);
        PersonDto personDto = new PersonDto();

        searchR = "";
        httpSession.setAttribute("litera", "");
//        modelAndView.addObject("listAllPositions", presentPositions);
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
            PersonDto personEditDto = new PersonDto();
            personEditDto.setId(personOptional.get().getId());
            personEditDto.setFirstName(personOptional.get().getFirstName());
            personEditDto.setLastName(personOptional.get().getLastName());
            personEditDto.setSName(personOptional.get().getSName());
            personEditDto.setNumberShot(personOptional.get().getNumberShot());
            personEditDto.setNumberCity(personOptional.get().getNumberCity());
            personEditDto.setNumberMobil(personOptional.get().getNumberMobil());
            personEditDto.setAlphabet(personOptional.get().getAlphabet());
            personEditDto.setPresentPosition(personOptional.get().getPresentPosition().getId());
            personEditDto.setTreeId(personOptional.get().getTreeId().getId());
            personEditDto.setRoom(personOptional.get().getRoom());
            this.personService.savePersonClone(personEditDto);
        }
        return "redirect:/adminEdit";
    }

    @RequestMapping(value = "/adminEdit/view/{id}")
    public String viewContact(@PathVariable Long id, Model model) {
        Optional<Person> personOptional = this.personService.getPersonById(id);
        if (personOptional.isPresent()) {
            PersonDto personDto = new PersonDto();
            personDto.setId(personOptional.get().getId());
            personDto.setFirstName(personOptional.get().getFirstName());
            personDto.setLastName(personOptional.get().getLastName());
            personDto.setSName(personOptional.get().getSName());
            personDto.setNumberShot(personOptional.get().getNumberShot());
            personDto.setNumberCity(personOptional.get().getNumberCity());
            personDto.setNumberMobil(personOptional.get().getNumberMobil());
            personDto.setAlphabet(personOptional.get().getAlphabet());
            personDto.setPresentPosition(personOptional.get().getPresentPosition().getId());
            personDto.setTreeId(personOptional.get().getTreeId().getId());
            personDto.setRoom(personOptional.get().getRoom());
            model.addAttribute("person", personDto);
        } else {
            return "adminEdit";
        }
        return "view";
    }

    @RequestMapping(value = "/adminEdit/edit/{id}")
    public String editPerson(@PathVariable Long id, Model model) {
        Optional<Person> personOptional = this.personService.getPersonById(id);
        if (personOptional.isPresent()) {
            PersonDto personEditDto = new PersonDto();
            personEditDto.setId(personOptional.get().getId());
            personEditDto.setFirstName(personOptional.get().getFirstName());
            personEditDto.setLastName(personOptional.get().getLastName());
            personEditDto.setSName(personOptional.get().getSName());
            personEditDto.setNumberShot(personOptional.get().getNumberShot());
            personEditDto.setNumberCity(personOptional.get().getNumberCity());
            personEditDto.setNumberMobil(personOptional.get().getNumberMobil());
            personEditDto.setAlphabet(personOptional.get().getAlphabet());
            personEditDto.setPresentPosition(personOptional.get().getPresentPosition().getId());
            personEditDto.setTreeId(personOptional.get().getTreeId().getId());
            personEditDto.setRoom(personOptional.get().getRoom());
            model.addAttribute("person", Optional.of(personEditDto));

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
                Page<PersonDto> persons = personService.findAllPageableOrderBylastName(new PageRequest(evalPage, evalPageSize));
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
            Page<PersonDto> persons = personService.findAllByLastNameContainsOrderByLastName(new PageRequest(evalPage, evalPageSize), searchResult);
            Pager pager = new Pager(persons.getTotalPages(), persons.getNumber(), BUTTONS_TO_SHOW);
            PersonDto personDto = new PersonDto();
            modelAndView.addObject("person", personDto);
            modelAndView.addObject("persons", persons);
            modelAndView.addObject("selectedPageSize", evalPageSize);
            modelAndView.addObject("pageSizes", PAGE_SIZES);
            modelAndView.addObject("pager", pager);
            return modelAndView;
        }
        Page<PersonDto> persons = personService.findAllByAlphabetEqualsOrderByLastName(new PageRequest(evalPage, evalPageSize), searchResult);
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

    @PostMapping(path = "/adminEdit")
    public ModelAndView search(@RequestParam String litera,
                               HttpSession httpSession,
                               @RequestParam("pageSize") Optional<Integer> pageSize,
                               @RequestParam("page") Optional<Integer> page) {
        ModelAndView modelAndView = new ModelAndView("adminEdit");
        int evalPageSize = pageSize.orElse(INITIAL_PAGE_SIZE);
        int evalPage = (page.orElse(0) < 1) ? INITIAL_PAGE : page.get() - 1;

        searchR = litera;
        Page<PersonDto> persons = personService.findAllByLastNameContainsOrderByLastName(new PageRequest(evalPage, evalPageSize), litera);
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
