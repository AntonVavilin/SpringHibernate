package pl.coderslab.hibernate.song;

import jakarta.persistence.*;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;
import pl.coderslab.hibernate.publishers.Publisher;

@Entity
@Getter
@Setter
public class Song {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Size(min = 5)
    private String title;
    @Min(1)
    @Max(10)
    private int rating;
    @Size(max = 600)
    private String description;
    @NotNull
    @ManyToOne
    private Publisher publisher;
    @Min(2)
    private int pages;

}
