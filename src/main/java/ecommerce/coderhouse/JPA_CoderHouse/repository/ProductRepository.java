package ecommerce.coderhouse.JPA_CoderHouse.repository;

import ecommerce.coderhouse.JPA_CoderHouse.entities.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {
}
