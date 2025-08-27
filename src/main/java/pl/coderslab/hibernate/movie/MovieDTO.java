package pl.coderslab.hibernate.movie;

import lombok.*;

import java.util.List;

@Builder
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class MovieDTO {
    private Long id;
    private String title;
    private int releaseYear;
    private List<String> genres;
    private double rating;
}
