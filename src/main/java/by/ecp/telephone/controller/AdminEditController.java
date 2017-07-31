package by.ecp.telephone.controller;

import by.ecp.telephone.entity.Pager;
import by.ecp.telephone.entity.Person;
import by.ecp.telephone.service.interfaces.PersonService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.Optional;

@Controller
public class AdminEditController {

	private static final int BUTTONS_TO_SHOW = 5;
	private static final int INITIAL_PAGE = 0;
	private static final int INITIAL_PAGE_SIZE = 5;
	private static final int[] PAGE_SIZES = { 10, 15, 50 };

	private PersonService personService;

	public AdminEditController(PersonService studentService) {
		this.personService = studentService;
	}

	@GetMapping("/adminEdit")
	public ModelAndView showPersonsPage(@RequestParam("pageSize") Optional<Integer> pageSize,
										@RequestParam("page") Optional<Integer> page) {
		ModelAndView modelAndView = new ModelAndView("adminEdit");

		// Evaluate page size. If requested parameter is null, return initial
		// page size
		int evalPageSize = pageSize.orElse(INITIAL_PAGE_SIZE);
		// Evaluate page. If requested parameter is null or less than 0 (to
		// prevent exception), return initial size. Otherwise, return value of
		// param. decreased by 1.
		int evalPage = (page.orElse(0) < 1) ? INITIAL_PAGE : page.get() - 1;

		Page<Person> persons = personService.findAllPageableOrderBylastName(new PageRequest(evalPage, 	evalPageSize));
		Pager pager = new Pager(persons.getTotalPages(), persons.getNumber(), BUTTONS_TO_SHOW);
		Person person = new Person();
		modelAndView.addObject("persons", persons);
		modelAndView.addObject("person", person);
		modelAndView.addObject("selectedPageSize", evalPageSize);
		modelAndView.addObject("pageSizes", PAGE_SIZES);
		modelAndView.addObject("pager", pager);
		return modelAndView;
	}
	@RequestMapping(value = "/adminEdit/view/{id}")
	public String viewContact(@PathVariable Long id, Model model) {
		model.addAttribute("person", this.personService.getPersonById(id));
		model.addAttribute("activePage", this.personService.getAllPerson());
		return "view";
	}

	@RequestMapping(value = "/adminEdit/save", method = RequestMethod.POST)
	public String save( Person person) {
		System.out.println("person.id = " + person.getId());
		personService.savePerson(person);
		return "redirect:/adminEdit";
	}
}
