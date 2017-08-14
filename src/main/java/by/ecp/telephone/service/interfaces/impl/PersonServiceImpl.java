package by.ecp.telephone.service.interfaces.impl;

import by.ecp.telephone.dto.PersonDto;
import by.ecp.telephone.entity.Person;
import by.ecp.telephone.repository.PersonRepository;
import by.ecp.telephone.service.interfaces.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.Optional;

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
        person.setId(personDto.getId());
        person.setFirstName(personDto.getFirstName());
        person.setLastName(personDto.getLastName());
        person.setSName(personDto.getSName());
        person.setNumberShot(personDto.getNumberShot());
        person.setNumberCity(personDto.getNumberCity());
        person.setNumberMobil(personDto.getNumberMobil());
        person.setAlphabet(personDto.getAlphabet());
        this.personRepository.save(person);
    }
    @Override
    public void savePersonClone(PersonDto personDto) {
        Person person = new Person();
        person.setFirstName(personDto.getFirstName());
        person.setLastName(personDto.getLastName());
        person.setSName(personDto.getSName());
        person.setNumberShot(personDto.getNumberShot());
        person.setNumberCity(personDto.getNumberCity());
        person.setNumberMobil(personDto.getNumberMobil());
        person.setAlphabet(personDto.getAlphabet());
        this.personRepository.save(person);
    }

    @Override
    public void savePersonAlphabet(PersonDto personDto) {
        Person personWithAlphabetDigit = new Person();
        personWithAlphabetDigit.setFirstName(personDto.getFirstName());
        personWithAlphabetDigit.setLastName(personDto.getLastName());
        personWithAlphabetDigit.setSName(personDto.getSName());
        personWithAlphabetDigit.setNumberShot(personDto.getNumberShot());
        personWithAlphabetDigit.setNumberCity(personDto.getNumberCity());
        personWithAlphabetDigit.setNumberMobil(personDto.getNumberMobil());
        personWithAlphabetDigit.setAlphabet(cutFromWordFirstChar(personDto.getLastName()));
        this.personRepository.save(personWithAlphabetDigit);
    }

    @Override
    public void deletePerson(Long id) {
        this.personRepository.deleteById(id);
    }

    @Override
    public Page<Person> findAllPageableOrderBylastName(Pageable pageable) {
        return personRepository.findAllByLastNameIsNotNullOrderByLastName(pageable);
    }

    @Override
    public Page<Person> findAllByAlphabetEqualsOrderByLastName(Pageable pageable, String searchResult) {
        return personRepository.findAllByAlphabetEqualsOrderByLastName(pageable, searchResult);
    }

    @Override
    public Page<Person> findAllByLastNameContainsOrderByLastName(Pageable pageable, String searchRes) {
        return personRepository.findAllByLastNameContainsOrderByLastName(pageable, searchRes);
    }

    private String cutFromWordFirstChar(String word) {
        String result = word.toLowerCase().substring(0, 1);
        if (result.equals("ж")) {
            result = "е";
        } else if (result.equals("ф")) {
            result = "у";
        } else if (result.equals("ц")) {
            result = "х";
        } else if (result.equals("щ")) {
            result = "ш";
        } else if (result.equals("ю") || result.equals("я")) {
            result = "э";
        }
        return result;
    }
}
