package pl.coderslab.hibernate.publishers;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PublisherRepository extends JpaRepository<Publisher, Long> {
    Publisher findByNip(Long nip);
    Publisher findByRegon(Long regon);



}
