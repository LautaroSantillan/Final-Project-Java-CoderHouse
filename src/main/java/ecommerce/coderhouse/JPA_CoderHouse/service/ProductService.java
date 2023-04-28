package ecommerce.coderhouse.JPA_CoderHouse.service;

import ecommerce.coderhouse.JPA_CoderHouse.entities.InvoiceDetail;
import ecommerce.coderhouse.JPA_CoderHouse.entities.Product;
import ecommerce.coderhouse.JPA_CoderHouse.exception.IdInvalitedException;
import ecommerce.coderhouse.JPA_CoderHouse.exception.ItAlreadyExistsException;
import ecommerce.coderhouse.JPA_CoderHouse.exception.ItNotFoundException;
import ecommerce.coderhouse.JPA_CoderHouse.repository.ProductRepository;
import ecommerce.coderhouse.JPA_CoderHouse.validator.ProductValidator;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Slf4j
@Service
public class ProductService {
    @Autowired
    private ProductRepository productRepository;

    public Product create(Product newProduct) throws Exception {
        Optional<Product> productOp = this.productRepository.findByCode(newProduct.getCode());

        if (productOp.isPresent()){
            log.info("El producto que está intentando agregar ya existe en la base de datos: " + newProduct);
            throw new ItAlreadyExistsException("El producto que está intentando agregar ya existe en la base de datos");
        } else {
            ProductValidator.productValidator(newProduct);
            return this.productRepository.save(newProduct);
        }
    }

    public Product findById(Long id) throws Exception{
        if (id <= 0){
            throw new IdInvalitedException("El ID ingresado no es valido");
        }

        Optional<Product> productOp = this.productRepository.findById(id);

        if (productOp.isEmpty()){
            log.info("El producto con id " + id + "  no existe en la base de datos");
            throw new ItNotFoundException("El producto no existe en la base de datos");
        } else {
            return productOp.get();
        }
    }

    public List<Product> findAll(){ return this.productRepository.findAll(); }

    public Product update(Product newProduct, Long id) throws Exception{
        log.info("ID ingresado: " + id);
        if (id <= 0){
            throw new IdInvalitedException("El ID ingresado no es valido");
        }

        Optional<Product> productOp = this.productRepository.findById(id);

        if (productOp.isEmpty()){
            log.info("El producto que intenta actualizar no existe en la base de datos");
            throw new ItNotFoundException("El producto no existe en la base de datos");
        } else {
            ProductValidator.productValidator(newProduct);

            log.info("El producto fue localizado");
            Product productDB = productOp.get();

            productDB.setName(newProduct.getName());
            productDB.setDescription(newProduct.getDescription());
            productDB.setCode(newProduct.getCode());
            productDB.setStock(newProduct.getStock());
            productDB.setPrice(newProduct.getPrice());

            log.info("Producto Actualizado: " + productDB);
            return this.productRepository.save(productDB);
        }
    }



    //Comente el método DELETE porque en la realidad no se eliminan registros así
    /*public void delete(Long id) throws Exception {
        log.info("ID ingresado: " + id);
        if (id <= 0) {
            throw new IdInvalitedException("El ID ingresado no es valido");
        }

        Optional<Product> productOp = this.productRepository.findById(id);

        if (productOp.isEmpty()) {
            log.info("El producto que intenta actualizar no existe en la base de datos");
            throw new ItNotFoundException("El producto no existe en la base de datos");
        } else {
            log.info("El producto con ID " + id + " se eliminó satisfactoriamente");
            productRepository.delete(productOp.get());
        }
    }*/

    public void subtractStock(InvoiceDetail invoiceDetail) throws ItNotFoundException {
        Product product = productRepository.findById(invoiceDetail.getProduct().getId()).orElseThrow(() -> new ItNotFoundException("Este producto no existe"));

        product.setStock(product.getStock() - invoiceDetail.getAmount());
    }
}
