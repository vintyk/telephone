package by.ecp.telephone.repository;


import by.ecp.telephone.dto.PersonDto;
import by.ecp.telephone.entity.Branch;
import by.ecp.telephone.entity.Person;
import by.ecp.telephone.entity.Tree;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;
@Transactional
@Repository
public interface PersonRepository extends PagingAndSortingRepository<Person, Long> {

    Page<Person> findAllByLastNameIsNotNullOrderByLastName(Pageable pageable);

    Page<Person> findAllByAlphabetEqualsOrderByLastName(Pageable pageable, String searchResult);

    Page<Person> findAllByLastNameContainsOrderByLastName(Pageable pageable, String searchRes);

    Person findPersonByLastName(String lastName);

    @Query(value = "SELECT * from person p where p.tree_id in (select t.id from tree t where t.branch_id = ?1)", nativeQuery = true)
    List<Person> findNativeByBranch(String branchId);
}
