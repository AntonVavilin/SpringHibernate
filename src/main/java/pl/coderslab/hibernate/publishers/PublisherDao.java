package pl.coderslab.hibernate.publishers;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@Transactional
public class PublisherDao {
    @PersistenceContext
    private EntityManager entityManager;
    public void save(Publisher publisher) {
        entityManager.persist(publisher);
    }
    public void update(Publisher publisher) {
        entityManager.merge(publisher);
    }
    public void delete(Publisher publisher) {
        entityManager.remove(entityManager.contains(publisher) ? publisher : entityManager.merge(publisher));
    }
    public Publisher findById(Long id) {
        return entityManager.find(Publisher.class, id);
    }
    public List<Publisher> findAll() {
        return entityManager.createQuery("from Publisher", Publisher.class).getResultList();
    }
}
