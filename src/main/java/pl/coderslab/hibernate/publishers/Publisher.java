package pl.coderslab.hibernate.publishers;

import jakarta.persistence.*;

@Entity
@Table(name = "publishers")
public class Publisher {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private Long nip;
    private Long regon;


    public Publisher() {

    }

    public Publisher(Long id, String name, Long nip, Long regon) {
        this.id = id;
        this.name = name;
        this.nip = nip;
        this.regon = regon;

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

    public Long getNip() {
        return nip;
    }

    public void setNip(Long nip) {
        this.nip = nip;
    }

    public Long getRegon() {
        return regon;
    }

    public void setRegon(Long regon) {
        this.regon = regon;
    }

    @Override
    public String toString() {
        return "Publisher{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", nip=" + nip +
                ", regon=" + regon +
                '}';
    }
}
