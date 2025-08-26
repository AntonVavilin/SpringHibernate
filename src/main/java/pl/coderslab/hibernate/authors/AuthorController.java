package pl.coderslab.hibernate.authors;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class AuthorController {
    private final AuthorDao authorDao;

    public AuthorController(AuthorDao authorDao) {
        this.authorDao = authorDao;
    }

    @RequestMapping("/author/create")
    @ResponseBody
    public String createAuthor() {
        Author author = new Author();
        author.setFirstName("Jan");
        author.setLastName("Kowalski");
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
}
