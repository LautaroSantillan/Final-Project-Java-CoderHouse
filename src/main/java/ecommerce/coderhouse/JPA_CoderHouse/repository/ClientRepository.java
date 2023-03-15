package ecommerce.coderhouse.JPA_CoderHouse.repository;

import ecommerce.coderhouse.JPA_CoderHouse.entities.Client;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ClientRepository extends JpaRepository<Client, Long> {
}
