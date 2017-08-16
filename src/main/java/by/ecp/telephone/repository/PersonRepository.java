package by.ecp.telephone.repository;


import by.ecp.telephone.entity.Person;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;
@Transactional
@Repository
public interface PersonRepository extends PagingAndSortingRepository<Person, Long> {

    Page<Person> findAllByLastNameIsNotNullOrderByLastName(Pageable pageable);

    Page<Person> findAllByAlphabetEqualsOrderByLastName(Pageable pageable, String searchResult);

    Page<Person> findAllByLastNameContainsOrderByLastName(Pageable pageable, String searchRes);

    Person findPersonByLastName(String lastName);
}
