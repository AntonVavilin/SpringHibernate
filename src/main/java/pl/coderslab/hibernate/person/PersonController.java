package pl.coderslab.hibernate.person;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/person")
public class PersonController {
    private final PersonDao personDao;
    private final PersonDetailsDao personDetailsDao;

    public PersonController(PersonDao personDao, PersonDetailsDao personDetailsDao) {
        this.personDao = personDao;
        this.personDetailsDao = personDetailsDao;

    }
    @GetMapping("/create")
    public String createPerson() {
        PersonDetails personDetails = new PersonDetails();
        personDetails.setFirstName("Karl");
        personDetails.setLastName("Walter");
        personDetails.setStreetNumber("12");
        personDetails.setStreet("Prosta");
        personDetails.setCity("Warsaw");
        personDetailsDao.save(personDetails);

        Person person = new Person();
        person.setEmail("asdasdsa@gmail.com");
        person.setLogin("Anton");
        person.setPassword("1234");
        person.setPersonDetails(personDetails);
        personDao.save(person);
        return "Data for " + person + " created";

    }
    @GetMapping("/read/{id}")
    public String readPerson(@PathVariable Long id) {
        Person person = personDao.findById(id);
        PersonDetails personDetails = personDetailsDao.findById(person.getId());
        return person.toString() + " " + personDetails.toString();
    }

    @GetMapping("/update/{id}/{password}")
    public String updatePerson(@PathVariable Long id, @PathVariable String password) {
        Person person = personDao.findById(id);
        person.setPassword(password);
        personDao.update(person);
        return "Data for " + person + " updated";
    }
    @GetMapping("/delete/{id}")
    public String deletePerson(@PathVariable Long id) {
        Person person = personDao.findById(id);
        personDao.delete(person);
        return "Data for " + person + " deleted";
    }
}
