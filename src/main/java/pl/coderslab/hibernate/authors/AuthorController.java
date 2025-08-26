package pl.coderslab.hibernate.authors;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
public class AuthorController {
    private final AuthorDao authorDao;
    private final AuthorRepository authorRepository;

    public AuthorController(AuthorDao authorDao, AuthorRepository authorRepository) {
        this.authorDao = authorDao;
        this.authorRepository = authorRepository;
    }

    @RequestMapping("/author/create")
    @ResponseBody
    public String createAuthor() {
        Author author = new Author();
        author.setFirstName("Jan");
        author.setLastName("Kowalski");
        author.setEmail("Jan@gmail.com");
        author.setPesel("123456789");
        authorDao.save(author);
        return "Author has been saved with an id:" + author.getId();
    }

    @RequestMapping("/author/read/{id}")
    @ResponseBody
    public String readAuthor(@PathVariable Long id) {
        Author author = authorDao.findById(id);
        return author.toString();
    }

    @RequestMapping("/author/delete/{id}")
    @ResponseBody
    public String deleteAuthor(@PathVariable Long id) {
        Author author = authorDao.findById(id);
        authorDao.delete(author);
        return "Author deleted: " + author.toString();
    }

    @RequestMapping("/author/update/{id}/{firstname}")
    @ResponseBody
    public String updateAuthor(@PathVariable Long id, @PathVariable String firstname) {
        Author author = authorDao.findById(id);
        author.setFirstName(firstname);
        authorDao.update(author);
        return "Author with id: " + author.getId() + " updated";

    }

    @RequestMapping("/author/findbyemail/{email}")
    @ResponseBody
    public String findAuthorByEmail(@PathVariable String email) {
        Author author = authorRepository.findByEmail(email);
        return author.toString();
    }

    @RequestMapping("/author/findbypesel/{pesel}")
    @ResponseBody
    public String findAuthorByPesel(@PathVariable String pesel) {
        Author author = authorRepository.findByPesel(pesel);
        return author.toString();
    }
    @RequestMapping("/author/findAllLastname")
    @ResponseBody
    public String findAllLastname() {
        List<Author> authors = authorRepository.findAllByLastName("Kowalski");
        return authors.toString();
    }
}
