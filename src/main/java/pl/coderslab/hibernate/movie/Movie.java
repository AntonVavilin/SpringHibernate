package pl.coderslab.hibernate.movie;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@Setter
public class Movie {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String title;
    private int releaseYear;
    @OneToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    private List<Genre> genres = new ArrayList<>();
    private double rating;


}
