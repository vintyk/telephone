package by.ecp.telephone.service.interfaces;

import by.ecp.telephone.entity.Person;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface PersonService {

	void save(Person person);

	Page<Person> findAllPageableOrderBylastName(Pageable pageable);
}
