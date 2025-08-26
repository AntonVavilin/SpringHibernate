package pl.coderslab.hibernate.person;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@Transactional
public class PersonDetailsDao {
    @PersistenceContext
    private EntityManager em;
    public PersonDetails findById(Long id) {
        return em.find(PersonDetails.class, id);
    }
    public void save(PersonDetails personDetails){
        em.persist(personDetails);
    }
    public void update(PersonDetails personDetails){
        em.merge(personDetails);
    }
    public void delete(PersonDetails personDetails){
        em.remove(em.contains(personDetails) ? personDetails : em.merge(personDetails));
    }
    public List<PersonDetails> findAll(){
        return em.createQuery("select p from PersonDetails p", PersonDetails.class).getResultList();
    }
}
