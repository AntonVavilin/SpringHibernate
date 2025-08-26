package pl.coderslab.hibernate.books;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import pl.coderslab.hibernate.authors.Author;
import pl.coderslab.hibernate.authors.AuthorDao;
import pl.coderslab.hibernate.publishers.Publisher;
import pl.coderslab.hibernate.publishers.PublisherController;
import pl.coderslab.hibernate.publishers.PublisherDao;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/book")
public class BookController {
    private final BookDao bookDao;
    private final AuthorDao authorDao;
    private final PublisherDao publisherDao;

    public BookController(BookDao bookDao, AuthorDao authorDao, PublisherDao publisherDao) {
        this.bookDao = bookDao;
        this.authorDao = authorDao;
        this.publisherDao = publisherDao;
    }

    @GetMapping("/create")
    public String createBook() {
        Publisher publisher = new Publisher();
        publisher.setName("Publisher 1");
        publisherDao.save(publisher);

        List<Author> authors = new ArrayList<>();
        authors.add(authorDao.findById(2L));
        authors.add(authorDao.findById(3L));


        Book book = new Book();
        book.setTitle("Book Title");
        book.setPublisher(publisher);
        book.setAuthors(authors);
        bookDao.save(book);
        return "Id of book added to the database: " + book.getId();
    }

    @GetMapping("/read/{id}")
    public String getBookById(@PathVariable("id") Long id) {
        Book book = bookDao.findById(id);
        return book.toString();

    }

    @GetMapping("/delete/{id}")
    public String deleteBookById(@PathVariable("id") Long id) {
        Book book = bookDao.findById(id);
        bookDao.delete(book);
        return "Id of book deleted from the database: " + book.getId();
    }

    @GetMapping("/update/{id}/{title}")
    public String updateBookById(@PathVariable("id") Long id, @PathVariable("title") String title) {
        Book book = bookDao.findById(id);
        book.setTitle(title);
        bookDao.update(book);
        return "Id of book updated from the database: " + book.getId();
    }

    //    @GetMapping("/all")
//    public List<Book> getAllBooks() {
//        List<Book> books = bookDao.findAll();
//        return books;
//    }
    @GetMapping("/all")
    public String findAll() {
        List<Book> all = bookDao.findAll();
        all.forEach(b -> System.out.println(b.toString()));
        return all.toString();
    }
    @GetMapping("/all/rating")
    public String findAllByRating() {
        List<Book> all = bookDao.findAll();
        all.forEach(b -> System.out.println(b.toString()));
        return all.toString();
    }
}
