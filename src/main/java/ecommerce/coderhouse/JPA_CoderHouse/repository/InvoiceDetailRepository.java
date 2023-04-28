package ecommerce.coderhouse.JPA_CoderHouse.repository;

import ecommerce.coderhouse.JPA_CoderHouse.entities.InvoiceDetail;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface InvoiceDetailRepository extends JpaRepository<InvoiceDetail, Long> {
}
