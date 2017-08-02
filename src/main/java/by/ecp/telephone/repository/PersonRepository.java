package by.ecp.telephone.repository;


import by.ecp.telephone.entity.Person;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface PersonRepository extends PagingAndSortingRepository<Person, Long> {
    Page<Person> findAllByLastNameIsNotNullOrderByLastName(Pageable pageable);
    Page<Person> findAllByAlphabetEqualsOrderByLastName(Pageable pageable, String searchResult);

}
