package ecommerce.coderhouse.JPA_CoderHouse;

import ecommerce.coderhouse.JPA_CoderHouse.repository.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class JpaCoderHouseApplication {
	@Autowired
	AdressRepository adressRepository;

	@Autowired
	ClientRepository clientRepository;

	@Autowired
	InvoiceRepository invoiceRepository;

	@Autowired
    InvoiceDetailRepository invoiceDetailRepository;

	@Autowired
	ProductRepository productRepository;

	public static void main(String[] args) {
		SpringApplication.run(JpaCoderHouseApplication.class, args);
	}

}
