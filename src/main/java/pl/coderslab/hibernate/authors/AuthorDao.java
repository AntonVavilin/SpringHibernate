package pl.coderslab.hibernate.authors;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@Transactional
public class AuthorDao {
    @PersistenceContext
    private EntityManager em;
    public Author findById(Long id) {
        return em.find(Author.class, id);
    }
    public void  save(Author author) {
        em.persist(author);
    }
    public void delete(Author author) {
        em.remove(em.contains(author) ? author : em.merge(author));
    }
    public List<Author> findAll() {
        return em.createQuery("from Author", Author.class).getResultList();
    }
    public void update(Author author) {
        em.merge(author);
    }

}
