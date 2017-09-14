package by.ecp.telephone.service.interfaces.impl;

import by.ecp.telephone.dto.PersonDto;
import by.ecp.telephone.entity.Person;
import by.ecp.telephone.entity.PresentPosition;
import by.ecp.telephone.entity.Tree;
import by.ecp.telephone.repository.PersonRepository;
import by.ecp.telephone.service.interfaces.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Transactional
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
    public void savePerson(PersonDto personDto) {
        Person person = new Person();

        PresentPosition presentPosition = new PresentPosition();
        presentPosition.setId(personDto.getPresentPosition());

        Tree tree = new Tree();
        tree.setId(personDto.getTreeId());

        person.setId(personDto.getId());
        person.setFirstName(personDto.getFirstName());
        person.setLastName(personDto.getLastName());
        person.setSName(personDto.getSName());
        person.setNumberShot(personDto.getNumberShot());
        person.setNumberCity(personDto.getNumberCity());
        person.setNumberMobil(personDto.getNumberMobil());
        person.setAlphabet(personDto.getAlphabet());
        person.setPresentPosition(presentPosition);
        person.setTreeId(tree);
        this.personRepository.save(person);
    }

    @Override
    public void savePersonClone(PersonDto personDto) {
        Person person = new Person();

        PresentPosition presentPosition = new PresentPosition();
        presentPosition.setId(personDto.getPresentPosition());

        Tree tree = new Tree();
        tree.setId(personDto.getTreeId());

        person.setFirstName(personDto.getFirstName());
        person.setLastName(personDto.getLastName());
        person.setSName(personDto.getSName());
        person.setNumberShot(personDto.getNumberShot());
        person.setNumberCity(personDto.getNumberCity());
        person.setNumberMobil(personDto.getNumberMobil());
        person.setAlphabet(personDto.getAlphabet());
        person.setPresentPosition(presentPosition);
        person.setTreeId(tree);
        this.personRepository.save(person);
    }

    @Override
    public void savePersonAlphabet(PersonDto personDto) {
        Person personWithAlphabetDigit = new Person();

        PresentPosition presentPosition = new PresentPosition();
        presentPosition.setId(personDto.getPresentPosition());

        Tree tree = new Tree();
        tree.setId(personDto.getTreeId());

        personWithAlphabetDigit.setFirstName(personDto.getFirstName());
        personWithAlphabetDigit.setLastName(personDto.getLastName());
        personWithAlphabetDigit.setSName(personDto.getSName());
        personWithAlphabetDigit.setNumberShot(personDto.getNumberShot());
        personWithAlphabetDigit.setNumberCity(personDto.getNumberCity());
        personWithAlphabetDigit.setNumberMobil(personDto.getNumberMobil());
        personWithAlphabetDigit.setAlphabet(cutFromWordFirstChar(personDto.getLastName()));
        personWithAlphabetDigit.setPresentPosition(presentPosition);
        personWithAlphabetDigit.setTreeId(tree);
        this.personRepository.save(personWithAlphabetDigit);
    }

    @Override
    public void deletePerson(Long id) {
        this.personRepository.deleteById(id);
    }


    @Override
    public Page<PersonDto> findAllPageableOrderBylastName(Pageable pageable) {
        Page<Person> personPage = personRepository.findAllByLastNameIsNotNullOrderByLastName(pageable);
        int totalElements = (int) personPage.getTotalElements();
        return new PageImpl<PersonDto>(personPage
                .stream()
                .map(person -> new PersonDto(
                        person.getId(),
                        person.getFirstName(),
                        person.getLastName(),
                        person.getSName(),
                        person.getNumberMobil(),
                        person.getNumberShot(),
                        person.getNumberCity(),
                        person.getAlphabet(),
                        person.getPresentPosition().getId(),
                        person.getTreeId().getId()))
                .collect(Collectors.toList()), pageable, totalElements);
        }

    @Override
    public Page<PersonDto> findAllPageableOrderBylastNameStringPresentPosition(Pageable pageable) {
        Page<Person> personPage = personRepository.findAllByLastNameIsNotNullOrderByLastName(pageable);
        int totalElements = (int) personPage.getTotalElements();
        return new PageImpl<PersonDto>(personPage
                .stream()
                .map(person -> new PersonDto(
                        person.getId(),
                        person.getFirstName(),
                        person.getLastName(),
                        person.getSName(),
                        person.getNumberMobil(),
                        person.getNumberShot(),
                        person.getNumberCity(),
                        person.getAlphabet(),
                        person.getPresentPosition().getName(),
                        person.getTreeId().getId()))
                .collect(Collectors.toList()), pageable, totalElements);
    }

    @Override
    public Page<PersonDto> findAllByAlphabetEqualsOrderByLastName(Pageable pageable, String searchResult) {
        Page<Person> personPage = personRepository.findAllByAlphabetEqualsOrderByLastName(pageable, searchResult);
        int totalElements = (int) personPage.getTotalElements();
        return new PageImpl<PersonDto>(personPage
                .stream()
                .map(person -> new PersonDto(
                        person.getId(),
                        person.getFirstName(),
                        person.getLastName(),
                        person.getSName(),
                        person.getNumberMobil(),
                        person.getNumberShot(),
                        person.getNumberCity(),
                        person.getAlphabet(),
                        person.getPresentPosition().getId(),
                        person.getTreeId().getId()))
                .collect(Collectors.toList()), pageable, totalElements);
        }

    @Override
    public Page<PersonDto> findAllByAlphabetEqualsOrderByLastNameStringPresentPosition(Pageable pageable, String searchResult) {
        Page<Person> personPage = personRepository.findAllByAlphabetEqualsOrderByLastName(pageable, searchResult);
        int totalElements = (int) personPage.getTotalElements();
        return new PageImpl<PersonDto>(personPage
                .stream()
                .map(person -> new PersonDto(
                        person.getId(),
                        person.getFirstName(),
                        person.getLastName(),
                        person.getSName(),
                        person.getNumberMobil(),
                        person.getNumberShot(),
                        person.getNumberCity(),
                        person.getAlphabet(),
                        person.getPresentPosition().getName(),
                        person.getTreeId().getId()))
                .collect(Collectors.toList()), pageable, totalElements);
    }

    @Override
    public Page<PersonDto> findAllByLastNameContainsOrderByLastName(Pageable pageable, String searchRes) {
        Page<Person> personPage = personRepository.findAllByLastNameContainsOrderByLastName(pageable, searchRes);
        int totalElements = (int) personPage.getTotalElements();
        return new PageImpl<PersonDto>(personPage
                .stream()
                .map(person -> new PersonDto(
                        person.getId(),
                        person.getFirstName(),
                        person.getLastName(),
                        person.getSName(),
                        person.getNumberMobil(),
                        person.getNumberShot(),
                        person.getNumberCity(),
                        person.getAlphabet(),
                        person.getPresentPosition().getId(),
                        person.getTreeId().getId()))
                .collect(Collectors.toList()), pageable, totalElements);
    }

    @Override
    public Page<PersonDto> findAllByLastNameContainsOrderByLastNameStringPresentPosition(Pageable pageable, String searchRes) {
        Page<Person> personPage = personRepository.findAllByLastNameContainsOrderByLastName(pageable, searchRes);
        int totalElements = (int) personPage.getTotalElements();
        return new PageImpl<PersonDto>(personPage
                .stream()
                .map(person -> new PersonDto(
                        person.getId(),
                        person.getFirstName(),
                        person.getLastName(),
                        person.getSName(),
                        person.getNumberMobil(),
                        person.getNumberShot(),
                        person.getNumberCity(),
                        person.getAlphabet(),
                        person.getPresentPosition().getName(),
                        person.getTreeId().getId()))
                .collect(Collectors.toList()), pageable, totalElements);
    }

    @Override
    public Person findPersonByLastName(String lastName) {
        return personRepository.findPersonByLastName(lastName);
    }

    @Override
    public List<PersonDto> findPersonByBranch(String branchId) {
        List<Person> personList = personRepository.findNativeByBranch(branchId);
        return new ArrayList<PersonDto>(personList
                .stream()
                .map(person -> new PersonDto(
                        person.getId(),
                        person.getFirstName(),
                        person.getLastName(),
                        person.getSName(),
                        person.getNumberMobil(),
                        person.getNumberShot(),
                        person.getNumberCity(),
                        person.getAlphabet(),
                        person.getPresentPosition().getName(),
                        person.getTreeId().getId()))
                .collect(Collectors.toList()));
    }

    private String cutFromWordFirstChar(String word) {
        String result = word.toLowerCase().substring(0, 1);
        switch (result) {
            case "ж":
                result = "е";
                break;
            case "ф":
                result = "у";
                break;
            case "ц":
                result = "х";
                break;
            case "щ":
                result = "ш";
                break;
            case "ю":
            case "я":
                result = "э";
                break;
        }
        return result;
    }
}
