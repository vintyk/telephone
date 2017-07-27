package by.ecp.telephone.service.interfaces;

import by.ecp.telephone.entity.Person;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface PersonService {

//	Page<Person> findAllPageable(Pageable pageable);

	Page<Person> findAllPageableOrderBylastName(Pageable pageable);
}
