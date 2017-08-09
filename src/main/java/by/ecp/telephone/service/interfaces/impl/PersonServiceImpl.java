package by.ecp.telephone.service.interfaces.impl;

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
    public void savePerson(Person person) {
        person.getLastName();
        person.getAlphabet();
        this.personRepository.save(person);
    }

    @Override
    public void savePersonAlphabet(Person person) {
        Person personWithAlphabetDigit = new Person();
        personWithAlphabetDigit.setFirstName(person.getFirstName());
        personWithAlphabetDigit.setLastName(person.getLastName());
        personWithAlphabetDigit.setNumberShot(person.getNumberShot());
        personWithAlphabetDigit.setNumberCity(person.getNumberCity());
        personWithAlphabetDigit.setNumberMobil(person.getNumberMobil());
        personWithAlphabetDigit.setAlphabet(cutFromWordFirstChar(person.getLastName()));
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

    public String cutFromWordFirstChar(String word) {
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
