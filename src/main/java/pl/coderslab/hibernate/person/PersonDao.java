package pl.coderslab.hibernate.person;

import jakarta.persistence.Entity;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@Transactional
public class PersonDao {
    @PersistenceContext
    private EntityManager em;
    public void save(Person person) {
        em.persist(person);
    }
    public void update(Person person) {
        em.merge(person);
    }
    public void delete(Person person) {
        em.remove(em.contains(person) ? person : em.merge(person));
    }
    public Person findById(Long id) {
        return em.find(Person.class, id);
    }
    public List<Person> findAll() {
        return em.createQuery("select p from Person p", Person.class).getResultList();
    }
}
