package by.ecp.telephone.controller;

import by.ecp.telephone.entity.Pager;
import by.ecp.telephone.entity.Person;
import by.ecp.telephone.service.interfaces.PersonService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.Objects;
import java.util.Optional;

@Controller
public class PersonController {

	private static final int BUTTONS_TO_SHOW = 5;
	private static final int INITIAL_PAGE = 0;
	private static final int INITIAL_PAGE_SIZE = 15;
	private static final int[] PAGE_SIZES = { 10, 15, 50 };
	public static String searchR="";
	public String searchR2="";
	private PersonService personService;

	public PersonController(PersonService studentService) {
		this.personService = studentService;
	}

	@GetMapping("/")
	public ModelAndView showPersonsPage(@RequestParam("pageSize") Optional<Integer> pageSize,
                                        @RequestParam("page") Optional<Integer> page) {
		ModelAndView modelAndView = new ModelAndView("persons");
		int evalPageSize = pageSize.orElse(INITIAL_PAGE_SIZE);
		int evalPage = (page.orElse(0) < 1) ? INITIAL_PAGE : page.get() - 1;
		Page<Person> persons = personService.findAllPageableOrderBylastName(new PageRequest(evalPage, evalPageSize));
		Pager pager = new Pager(persons.getTotalPages(), persons.getNumber(), BUTTONS_TO_SHOW);
		Person person = new Person();
//
		modelAndView.addObject("litera", searchR);
//
		modelAndView.addObject("person", person);
		modelAndView.addObject("persons", persons);
		modelAndView.addObject("selectedPageSize", evalPageSize);
		modelAndView.addObject("pageSizes", PAGE_SIZES);
		modelAndView.addObject("pager", pager);
		return modelAndView;
	}
	@GetMapping("/{searchResult}")
	public ModelAndView showPersonsPageSearchByChar(@PathVariable String searchResult,
											  @RequestParam("pageSize") Optional<Integer> pageSize,
											  @RequestParam("page") Optional<Integer> page) {
		ModelAndView modelAndView = new ModelAndView("persons");
//
//		if (Objects.equals(searchR, "")){
//			searchR=searchResult;
//		}

//
		int evalPageSize = pageSize.orElse(INITIAL_PAGE_SIZE);
		int evalPage = (page.orElse(0) < 1) ? INITIAL_PAGE : page.get() - 1;

		Page<Person> persons = personService.findAllByAlphabetEqualsOrderByLastName(new PageRequest(evalPage, evalPageSize), searchResult);
		Pager pager = new Pager(persons.getTotalPages(), persons.getNumber(), BUTTONS_TO_SHOW);
		Person person = new Person();
		modelAndView.addObject("persons", persons);
		modelAndView.addObject("person", person);
		modelAndView.addObject("selectedPageSize", evalPageSize);
		modelAndView.addObject("pageSizes", PAGE_SIZES);
		modelAndView.addObject("pager", pager);
		searchR=searchResult;

		//	Собака зарыта тут
//		modelAndView.addObject("litera", person.getAlphabet());
//
		return modelAndView;
	}
//	@RequestMapping(value = "/adminEdit/search", method = RequestMethod.POST)
//	public String search(Person person) {
//		personService.findAllByLastNameContainsOrderByLastName();
//		return "redirect:/adminEdit";
//	}
	@GetMapping("/search/{searchRes}")
	public ModelAndView showPersonsPageSearch(@PathVariable String searchRes,
											  @RequestParam("pageSize") Optional<Integer> pageSize,
											  @RequestParam("page") Optional<Integer> page) {
		ModelAndView modelAndView = new ModelAndView("persons");
		int evalPageSize = pageSize.orElse(INITIAL_PAGE_SIZE);
		int evalPage = (page.orElse(0) < 1) ? INITIAL_PAGE : page.get() - 1;

		Page<Person> persons = personService.findAllByLastNameContainsOrderByLastName(new PageRequest(evalPage, evalPageSize), searchRes);
		Pager pager = new Pager(persons.getTotalPages(), persons.getNumber(), BUTTONS_TO_SHOW);
		Person person = new Person();
		modelAndView.addObject("persons", persons);
		modelAndView.addObject("selectedPageSize", evalPageSize);
		modelAndView.addObject("pageSizes", PAGE_SIZES);
		modelAndView.addObject("pager", pager);
		return modelAndView;
	}

}
