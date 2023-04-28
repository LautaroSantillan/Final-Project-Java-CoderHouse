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
    InvoiceDetailRepository invoice_detailRepository;

	@Autowired
	ProductRepository productRepository;

	public static void main(String[] args) {
		SpringApplication.run(JpaCoderHouseApplication.class, args);
	}

	/*@Override
	public void run(String... args) throws Exception {

		System.out.println("LISTA DE DIRECCIONES : " + adressRepository.findAll());
		System.out.println("LISTA DE CLIENTES : " + clientRepository.findAll());
		System.out.println("LISTA DE FACTURAS : " + invoiceRepository.findAll());
		System.out.println("LISTA DE LOS DETALLES DE LAS FACTURAS : " + invoice_detailRepository.findAll());
		System.out.println("LISTA DE PRODUCTOS : " + productRepository.findAll());

	}*/
}
