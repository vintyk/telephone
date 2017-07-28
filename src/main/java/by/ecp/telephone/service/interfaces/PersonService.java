package by.ecp.telephone.service.interfaces;

import by.ecp.telephone.entity.Person;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface PersonService {

	Iterable<Person> getAllPerson();
	Person getPersonById(Integer id);
	Person savePerson(Person contact);
	void deletePerson(Integer id);
	Page<Person> findAllPageableOrderBylastName(Pageable pageable);
}
