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
}
