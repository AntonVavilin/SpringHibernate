package pl.coderslab.hibernate.books;

import org.springframework.web.bind.annotation.*;
import pl.coderslab.hibernate.authors.Author;
import pl.coderslab.hibernate.authors.AuthorDao;
import pl.coderslab.hibernate.category.Category;
import pl.coderslab.hibernate.category.CategoryRepository;
import pl.coderslab.hibernate.publishers.Publisher;
import pl.coderslab.hibernate.publishers.PublisherDao;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/book")
public class BookController {
    private final BookDao bookDao;
    private final AuthorDao authorDao;
    private final PublisherDao publisherDao;
    private final BookRepository bookRepository;
    private final CategoryRepository categoryRepository;

    public BookController(BookDao bookDao, AuthorDao authorDao, PublisherDao publisherDao, BookRepository bookRepository, CategoryRepository categoryRepository) {
        this.bookDao = bookDao;
        this.authorDao = authorDao;
        this.publisherDao = publisherDao;
        this.bookRepository = bookRepository;
        this.categoryRepository = categoryRepository;
    }

    @GetMapping("/create")
    public String createBook() {
        Category category = new Category();
        category.setName("Horror");
        categoryRepository.save(category);




        Publisher publisher = new Publisher();
        publisher.setName("Publisher 2");
        publisherDao.save(publisher);

        List<Author> authors = new ArrayList<>();
        authors.add(authorDao.findById(2L));
        authors.add(authorDao.findById(3L));


        Book book = new Book();
        book.setTitle("Jaws");
        book.setPublisher(publisher);
        book.setAuthors(authors);
        book.setCategory(category);
        book.setRating(4);
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
    @RequestMapping("/test/findall")
    @ResponseBody
    public String testfindAll() {
        bookRepository.findAll().forEach(System.out::println);
        return "xxx";
    }
    @RequestMapping("/jpa/{title}")
    @ResponseBody
    public String findByTitle(@PathVariable("title") String title) {
        List<Book> books = bookRepository.findByTitle(title);
        books.forEach(b -> System.out.println(b.toString()));
        return books.toString();
    }
    @RequestMapping("/bookBy/{author_id}")
    @ResponseBody
    public String findByAuthor(@PathVariable("author_id") Long author_id) {
        List<Book> bookList = bookRepository.findAllByAuthors_Id(author_id);
        return bookList.toString();
    }
    @RequestMapping("/bookBy/publisher/{publisher_id}")
    @ResponseBody
    public String findByPublisher(@PathVariable("publisher_id") Long publisher_id) {
        List<Book> bookList = bookRepository.findAllByPublisherId(publisher_id);
        return bookList.toString();
    }
    @RequestMapping("/firstbook/{id}")
    @ResponseBody
    public String firstBook(@PathVariable("id") Long id) {
        Book book1 = bookRepository.findFirstByCategoryIdOrderByTitle(id);
        return book1.toString();
    }
    @RequestMapping("/byTitle/{title}")
    @ResponseBody
    public String bookByTitle(@PathVariable("title") String title) {
        List<Book> bookList = bookRepository.findAllByTitle(title);
        return bookList.toString();
    }
    @RequestMapping("/queryCategory/{category_id}")
    @ResponseBody
    public String queryCategory(@PathVariable("category_id") Long category_id) {
        List<Book> bookList = bookRepository.findAllByCategory(String.valueOf(category_id));
        return bookList.toString();
    }
    @RequestMapping("/queryRating/between/{a}/{b}")
    @ResponseBody
    public String queryRatingBetween(@PathVariable("a") int a, @PathVariable("b") int b) {
        List<Book> bookList = bookRepository.findAllByRatingBetween(a,b);
        return bookList.toString();
    }
}
