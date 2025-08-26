package pl.coderslab.hibernate.books;

import jakarta.persistence.*;
import pl.coderslab.hibernate.authors.Author;
import pl.coderslab.hibernate.category.Category;
import pl.coderslab.hibernate.publishers.Publisher;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "books")
public class Book {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String title;
    private String isbn;
    private int rating;
    @ManyToMany
    private List<Author> authors = new ArrayList<>();
    @ManyToOne
    private Publisher publisher;
    @ManyToOne
    private Category category;

    public Book() {

    }

    public void setId(Long id) {
        this.id = id;
    }
    public void setTitle(String title) {
        this.title = title;
    }
    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }
    public Long getId() {
        return id;
    }
    public String getTitle() {
        return title;
    }
    public String getIsbn() {
        return isbn;
    }
    public List<Author> getAuthors() {
        return authors;
    }
    public void setAuthors(List<Author> authors) {
        this.authors = authors;
    }
    public Publisher getPublisher() {
        return publisher;
    }
    public void setPublisher(Publisher publisher) {
        this.publisher = publisher;
    }
    public void addAuthor(Author author) {
        this.authors.add(author);

    }
    public int getRating() {
        return rating;
    }
    public void setRating(int rating) {
        this.rating = rating;
    }
    @Override
    public String toString() {
        return title + " - " + isbn;
    }


}

