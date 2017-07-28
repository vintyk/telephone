package by.ecp.telephone.service.interfaces.impl;

import by.ecp.telephone.entity.Person;
import by.ecp.telephone.repository.PersonRepository;
import by.ecp.telephone.service.interfaces.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class PersonServiceImpl implements PersonService {

	private PersonRepository personRepository;
	@Autowired
	public PersonServiceImpl(PersonRepository personRepository) {
		this.personRepository = personRepository;
	}

	@Override
	public Iterable<Person> getAllPerson() {
		return this.personRepository.findAll();
	}

	@Override
	public Optional<Person> getPersonById(Long id) {
		return this.personRepository.findById(id);
	}

	@Override
	public Person savePerson(Person contact) {
		return this.personRepository.save(contact);
	}

	@Override
	public void deletePerson(Long id) {
		this.personRepository.deleteById(id);
	}

	@Override
	public Page<Person> findAllPageableOrderBylastName(Pageable pageable) {
		return personRepository.findAllByLastNameIsNotNullOrderByLastName(pageable);
	}
}
