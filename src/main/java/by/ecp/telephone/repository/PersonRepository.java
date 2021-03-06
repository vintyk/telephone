package by.ecp.telephone.repository;


import by.ecp.telephone.entity.Person;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Transactional
@Repository
public interface PersonRepository extends PagingAndSortingRepository<Person, Long> {

    Page<Person> findAllByLastNameIsNotNullOrderByLastName(Pageable pageable);

    Page<Person> findAllByAlphabetEqualsOrderByLastName(Pageable pageable, String searchResult);

    Page<Person> findAllByLastNameContainsOrderByLastName(Pageable pageable, String searchRes);

    Person findPersonByLastName(String lastName);

    @Query(value = "SELECT * from person p where p.tree_id in (select t.id from tree t where t.branch_id = ?1) ORDER BY p.last_name", nativeQuery = true)
    List<Person> findNativeByBranch(String branchId);

    @Query(value = "SELECT * from person p where p.tree_id in (select t.id from tree t where t.branch_id = ?1 and t.present_position_1_id = ?2) ORDER BY p.id", nativeQuery = true)
    List<Person> findNativeByBranchAndOffice(String branchId, String officeId);

    @Query(value = "SELECT * from person p where p.tree_id = ?1 ORDER BY p.id", nativeQuery = true)
    List<Person> findNativeByTreeId(String officeId);

    //    @Query(value = "SELECT * from person p where p.room = ?1 ORDER BY p.id", nativeQuery = true)
    @Query(value = "SELECT * FROM person p JOIN tree t ON t.id = p.tree_id WHERE " +
            "p.room=(SELECT p.room FROM person p JOIN tree t ON t.id = p.tree_id WHERE p.id=?1)\n" +
            "    AND\n" +
            "t.branch_id=(SELECT t1.branch_id FROM person p JOIN tree t1 ON t1.id = p.tree_id WHERE p.id = ?1)", nativeQuery = true)
    List<Person> findNativeByRoom(String idPerson);

}
