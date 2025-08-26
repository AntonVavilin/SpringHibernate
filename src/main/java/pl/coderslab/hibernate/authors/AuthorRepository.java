package pl.coderslab.hibernate.authors;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AuthorRepository extends JpaRepository<Author, Long> {
    Author findByEmail(String email);
    Author findByPesel(String pesel);
    List<Author> findAllByLastName(String lastName);

    @Query(value = "select * from authors where email like ?1%",nativeQuery = true)
    List<Author> findAllByEmailStartsWith(String email);

    @Query(value = "SELECT * FROM authors where pesel like ?1%", nativeQuery = true)
    List<Author> findAllByPeselStartsWith(String pesel);

}
