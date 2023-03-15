package ecommerce.coderhouse.JPA_CoderHouse.repository;

import ecommerce.coderhouse.JPA_CoderHouse.entities.Invoice_Detail;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface Invoice_DetailRepository extends JpaRepository<Invoice_Detail, Long> {
}
