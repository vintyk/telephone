package by.ecp.telephone.service.interfaces.impl;

import by.ecp.telephone.entity.Person;
import by.ecp.telephone.repository.PersonRepository;
import by.ecp.telephone.service.interfaces.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class PersonServiceImpl implements PersonService {

	private PersonRepository personRepository;
	@Autowired
	public PersonServiceImpl(PersonRepository personRepository) {
		this.personRepository = personRepository;
	}

	@Override
	public Iterable<Person> getAllPerson() {
		return this.personRepository.findAll(Sort.by(Person.class.getSimpleName()));
	}

	@Override
	public Person getPersonById(Integer id) {
		return null;
	}

	@Override
	public Person savePerson(Person contact) {
		return this.personRepository.save(contact);
	}

	@Override
	public void deletePerson(Integer id) {

	}

	@Override
	public Page<Person> findAllPageableOrderBylastName(Pageable pageable) {
		return personRepository.findAllByLastNameIsNotNullOrderByLastName(pageable);
	}
}
