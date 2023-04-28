package ecommerce.coderhouse.JPA_CoderHouse.controller;

import ecommerce.coderhouse.JPA_CoderHouse.entities.Client;
import ecommerce.coderhouse.JPA_CoderHouse.exception.ItAlreadyExistsException;
import ecommerce.coderhouse.JPA_CoderHouse.service.ClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "api/client")
public class ClientController {
    @Autowired
    private ClientService clientService;

    @PostMapping(path = "/")
    public ResponseEntity<Client> create(@RequestBody Client client) throws Exception {
        return new ResponseEntity<>(this.clientService.create(client), HttpStatus.OK);
    }

    /*@GetMapping(path = "/{id}")
    public ResponseEntity<Client> findById(@PathVariable Long id) throws Exception{
        return new ResponseEntity<>(this.clientService.findById(id), HttpStatus.OK);
    }

    @GetMapping(path = "/")
    public ResponseEntity<List<Client>> findAll(){
        return new ResponseEntity<>(this.clientService.findAll(), HttpStatus.OK);
    }

    @PutMapping(path = "/{id}")
    public ResponseEntity<Client> update(@RequestBody Client client, @PathVariable Long id) throws Exception{
        return new ResponseEntity<>(this.clientService.update(client, id), HttpStatus.OK);
    }*/

    /*@DeleteMapping(path = "/{id}")
    public ResponseEntity<String> deleteById(@PathVariable Long id) throws Exception{
        clientService.delete(id);
        return ResponseEntity.ok("Cliente con ID " + id + "eliminado exitosamente");
    }*/
}
