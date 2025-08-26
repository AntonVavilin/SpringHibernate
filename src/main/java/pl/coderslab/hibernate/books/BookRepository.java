package pl.coderslab.hibernate.books;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pl.coderslab.hibernate.authors.Author;
import pl.coderslab.hibernate.publishers.Publisher;

import java.awt.print.Pageable;
import java.util.List;
import java.util.Optional;

@Repository
public interface BookRepository extends JpaRepository<Book, Long> {
    List<Book> findByTitle(String title);
    List<Book> findAllByAuthors_Id(Long authorId);
    List<Book> findAllByPublisherId(Long publisherId);
    List<Book> findAllByRating(int rating);
    Book findFirstByCategoryIdOrderByTitle(Long id);


}
