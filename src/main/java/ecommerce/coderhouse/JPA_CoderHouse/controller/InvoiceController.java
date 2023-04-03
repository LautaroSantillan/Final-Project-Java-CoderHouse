package ecommerce.coderhouse.JPA_CoderHouse.controller;

import ecommerce.coderhouse.JPA_CoderHouse.entities.Invoice;
import ecommerce.coderhouse.JPA_CoderHouse.exception.ItAlreadyExistsException;
import ecommerce.coderhouse.JPA_CoderHouse.service.InvoiceService;
import jakarta.persistence.criteria.CriteriaBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "api/invoice")
public class InvoiceController {
    @Autowired
    private InvoiceService invoiceService;

    @PostMapping(path = "/")
    public ResponseEntity<Invoice> create(@RequestBody Invoice invoice) throws ItAlreadyExistsException{
        return new ResponseEntity<>(this.invoiceService.create(invoice), HttpStatus.OK);
    }

    @GetMapping(path = "/{id}")
    public ResponseEntity<Invoice> findById(@PathVariable Long id) throws Exception{
        return new ResponseEntity<>(this.invoiceService.findById(id), HttpStatus.OK);
    }

    @GetMapping(path = "/")
    public ResponseEntity<List<Invoice>> findAll(){
        return new ResponseEntity<>(this.invoiceService.findAll(), HttpStatus.OK);
    }

    @PutMapping(path = "/{id}")
    public ResponseEntity<Invoice> update(@RequestBody Invoice invoice, @PathVariable Long id) throws Exception{
        return new ResponseEntity<>(this.invoiceService.update(invoice, id), HttpStatus.OK);
    }

    @DeleteMapping(path = "/{id}")
    public ResponseEntity<String> delete(@PathVariable Long id) throws Exception{
        invoiceService.delete(id);
        return ResponseEntity.ok("Factura con ID " + id + " eliminado exitosamente");
    }
}
