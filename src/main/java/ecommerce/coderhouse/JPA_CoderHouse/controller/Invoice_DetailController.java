package ecommerce.coderhouse.JPA_CoderHouse.controller;

import ecommerce.coderhouse.JPA_CoderHouse.entities.Invoice_Detail;
import ecommerce.coderhouse.JPA_CoderHouse.service.Invoice_DetailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "api/invoice-detail")
public class Invoice_DetailController {
    @Autowired
    private Invoice_DetailService invoice_detailService;

    @PostMapping(path = "/")
    public ResponseEntity<Invoice_Detail> create(@RequestBody Invoice_Detail invoice_detail){
        return new ResponseEntity<>(this.invoice_detailService.create(invoice_detail), HttpStatus.OK);
    }

    @GetMapping(path = "/{id}")
    public ResponseEntity<Invoice_Detail> findById(@PathVariable Long id) throws Exception{
        return new ResponseEntity<>(this.invoice_detailService.findById(id), HttpStatus.OK);
    }

    @GetMapping(path = "/")
    public ResponseEntity<List<Invoice_Detail>> findAll(){
        return new ResponseEntity<>(this.invoice_detailService.findAll(), HttpStatus.OK);
    }

    @PutMapping(path = "/")
    public ResponseEntity<Invoice_Detail> update(@RequestBody Invoice_Detail invoice_detail, @PathVariable Long id) throws Exception{
        return new ResponseEntity<>(this.invoice_detailService.update(invoice_detail, id), HttpStatus.OK);
    }

    @DeleteMapping(path = "/{id}")
    public ResponseEntity<String> delete(@PathVariable Long id) throws Exception{
        invoice_detailService.delete(id);
        return ResponseEntity.ok("Factura detallada con ID " + id + " eliminado exitosamente");
    }
}
