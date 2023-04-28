package ecommerce.coderhouse.JPA_CoderHouse.controller;

import ecommerce.coderhouse.JPA_CoderHouse.entities.Product;
import ecommerce.coderhouse.JPA_CoderHouse.exception.ItAlreadyExistsException;
import ecommerce.coderhouse.JPA_CoderHouse.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "api/product")
public class ProductController {
    @Autowired
    private ProductService productService;

    @PostMapping(path = "/")
    public ResponseEntity<Product> create(@RequestBody Product product) throws Exception {
        return new ResponseEntity<>(this.productService.create(product), HttpStatus.OK);
    }

    @GetMapping(path = "/{id}")
    public ResponseEntity<Product> findById(@PathVariable Long id) throws Exception{
        return new ResponseEntity<>(this.productService.findById(id), HttpStatus.OK);
    }

    @GetMapping(path = "/")
    public ResponseEntity<List<Product>> findAll(){
        return new ResponseEntity<>(this.productService.findAll(), HttpStatus.OK);
    }

    @PutMapping(path = "/{id}")
    public ResponseEntity<Product> update(@RequestBody Product product, @PathVariable Long id) throws Exception{
        return new ResponseEntity<>(this.productService.update(product, id), HttpStatus.OK);
    }

    /*@DeleteMapping(path = "/{id}")
    public ResponseEntity<String> delete(@PathVariable Long id) throws Exception{
        productService.delete(id);
        return ResponseEntity.ok("Producto con ID " + id + " eliminado exitosamente");
    }*/
}
