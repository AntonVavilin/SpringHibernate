package pl.coderslab.hibernate.books;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
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
    Book findFirstByCategoryIdOrderByTitle(Long id);

    @Query(value = "SELECT * from books WHERE title = ?1",nativeQuery = true)
    List<Book> findAllByTitle(String title);

    @Query(value = "SELECT * from books WHERE category_id = ?1", nativeQuery = true)
    List<Book> findAllByCategory(String category);

    @Query(value = "SELECT * from books where rating BETWEEN ?1 and ?2", nativeQuery = true)
    List<Book> findAllByRatingBetween(int rating1, int rating2);

    @Query(value = "SELECT * from books where publihser_id = ?1",nativeQuery = true)
    List<Book> findAllBooksByPublisherId(Long publisherId);

    @Query(value = "select * from books where category_id = ?1 ORDER BY asc limit 1", nativeQuery = true)
    List<Book> findAllByCategoryOrderByAsc(String category);


}
