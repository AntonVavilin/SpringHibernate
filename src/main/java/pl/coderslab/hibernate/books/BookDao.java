package pl.coderslab.hibernate.books;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.Query;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@Transactional
public class BookDao {
    @PersistenceContext
    private EntityManager em;

    public void save(Book book) {
        em.persist(book);
    }

    public void update(Book book) {
        em.merge(book);
    }

    public void delete(Book book) {
        em.remove(em.contains(book) ? book : em.merge(book));
    }

    public Book findById(Long id) {
        return em.find(Book.class, id);
    }

    public List findAll() {
        Query query = em.createQuery("select b from Book b");
        return query.getResultList();
    }
    public List<Book> findByPusbliser(String pusbliser) {
        Query query = em.createQuery("select b from Book b where b.pusbliser=:pusbliser");
        query.setParameter("pusbliser", pusbliser);
        return query.getResultList();


    }
    public List<Book> findByAuthor(String author) {
        Query query = em.createQuery("select b from Book b where b.author = :author");
        query.setParameter("author", author);
        return query.getResultList();
    }

}



