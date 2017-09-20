package by.ecp.telephone.service.interfaces;

import by.ecp.telephone.dto.PersonDto;
import by.ecp.telephone.entity.Person;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;
import java.util.Optional;

public interface PersonService {

    Iterable<Person> getAllPerson();

    Optional<Person> getPersonById(Long id);

    void savePerson(PersonDto personDto);

    void savePersonClone(PersonDto personDto);

    void savePersonAlphabet(PersonDto person);

    void deletePerson(Long id);

    Page<PersonDto> findAllPageableOrderBylastName(Pageable pageable);

    Page<PersonDto> findAllPageableOrderBylastNameStringPresentPosition(Pageable pageable);

    Page<PersonDto> findAllByAlphabetEqualsOrderByLastName(Pageable pageable, String searchResult);

    Page<PersonDto> findAllByAlphabetEqualsOrderByLastNameStringPresentPosition(Pageable pageable, String searchResult);

    Page<PersonDto> findAllByLastNameContainsOrderByLastName(Pageable pageable, String searchRes);

    Page<PersonDto> findAllByLastNameContainsOrderByLastNameStringPresentPosition(Pageable pageable, String searchRes);

    Person findPersonByLastName(String lastName);

    List<PersonDto> findPersonByBranch(String branchId);

    List<PersonDto> findPersonByBranchAndOffice(String branchId, String officeId);

    List<PersonDto> findNativeByTreeId(String treeId);

    List<PersonDto> findNativeByRoom(String room);
}
