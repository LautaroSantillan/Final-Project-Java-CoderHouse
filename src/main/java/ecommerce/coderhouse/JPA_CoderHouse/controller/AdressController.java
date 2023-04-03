package ecommerce.coderhouse.JPA_CoderHouse.controller;

import ecommerce.coderhouse.JPA_CoderHouse.entities.Adress;
import ecommerce.coderhouse.JPA_CoderHouse.exception.ItAlreadyExistsException;
import ecommerce.coderhouse.JPA_CoderHouse.service.AdressService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "api/adress")
public class AdressController {
    @Autowired
    private AdressService adressService;

    @PostMapping(path = "/")
    public ResponseEntity<Adress> create(@RequestBody Adress adress) throws ItAlreadyExistsException{
        return new ResponseEntity<>(this.adressService.create(adress), HttpStatus.OK);
    }

    @GetMapping(path = "/{id}")
    public ResponseEntity<Adress> findById(@PathVariable Long id) throws Exception{
        return new ResponseEntity<>(this.adressService.findById(id), HttpStatus.OK);
    }

    @GetMapping(path = "/")
    public ResponseEntity<List<Adress>> findAll(){
        return new ResponseEntity<>(this.adressService.findAll(), HttpStatus.OK);
    }

    @PutMapping(path = "/{id}")
    public ResponseEntity<Adress> update(@RequestBody Adress adress, @PathVariable Long id) throws Exception{
        return new ResponseEntity<>(this.adressService.update(adress, id), HttpStatus.OK);
    }

    @DeleteMapping(path = "/{id}")
    public ResponseEntity<String> deleteById(@PathVariable Long id) throws Exception{
        adressService.delete(id);
        return ResponseEntity.ok("Dirección con ID " + id + " eliminado exitosamente");
    }
}
