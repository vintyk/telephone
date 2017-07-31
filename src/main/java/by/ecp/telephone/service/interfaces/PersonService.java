package by.ecp.telephone.service.interfaces;

import by.ecp.telephone.entity.Person;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.Optional;

public interface PersonService {

	Iterable<Person> getAllPerson();
	Optional<Person> getPersonById(Long id);
	void savePerson(Person person);
	void update(Person person1, Person person2);
	void deletePerson(Long id);
	Page<Person> findAllPageableOrderBylastName(Pageable pageable);
}
