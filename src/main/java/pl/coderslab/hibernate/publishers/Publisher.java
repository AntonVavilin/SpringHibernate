package pl.coderslab.hibernate.publishers;

import jakarta.persistence.*;
import org.springframework.web.bind.annotation.ResponseBody;

@Entity
@Table(name = "publishers")
public class Publisher {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;


    public Publisher() {

    }
    public Publisher(Long id, String name) {
        this.id = id;
        this.name = name;

    }
    public Long getId() {
        return id;

    }
    public void setId(Long id) {
        this.id = id;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;

    }
    @Override
    public String toString() {
        return name;
    }
}
