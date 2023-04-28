package ecommerce.coderhouse.JPA_CoderHouse.service;

import ecommerce.coderhouse.JPA_CoderHouse.entities.Client;
import ecommerce.coderhouse.JPA_CoderHouse.exception.ItAlreadyExistsException;
import ecommerce.coderhouse.JPA_CoderHouse.exception.ItNotFoundException;
import ecommerce.coderhouse.JPA_CoderHouse.exception.IdInvalitedException;
import ecommerce.coderhouse.JPA_CoderHouse.repository.ClientRepository;
import ecommerce.coderhouse.JPA_CoderHouse.validator.ClientValidator;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Slf4j
@Service
public class ClientService {
    @Autowired
    private ClientRepository clientRepository;

    public Client create(Client newClient) throws Exception {
        Optional<Client> clientOp = this.clientRepository.findByDocnumber(newClient.getDocnumber());

        if (clientOp.isPresent()){
            log.info("El cliente que está intentando agregar ya existe en la base de datos: " + newClient);
            throw new ItAlreadyExistsException("El cliente que está intentando agregar ya existe en la base de datos");
        } else {
            ClientValidator.clientValidator(newClient);
            return this.clientRepository.save(newClient);
        }
    }

    public Client findById(Long id) throws Exception{
        if (id <= 0){
            throw new IdInvalitedException("El ID ingresado no es valido");
        }

        Optional<Client> clientOp = this.clientRepository.findById(id);

        if (clientOp.isEmpty()){
            log.info("El cliente con id " + id + "  no existe en la base de datos");
            throw new ItNotFoundException("El cliente no existe en la base de datos");
        } else {
            return clientOp.get();
        }
    }

    public List<Client> findAll(){ return this.clientRepository.findAll(); }

    public Client update(Client newClient, Long id) throws Exception{
        log.info("ID ingresado: " + id);
        if (id <= 0){
            throw new IdInvalitedException("El ID ingresado no es valido");
        }

        Optional<Client> clientOp = this.clientRepository.findById(id);

        if (clientOp.isEmpty()){
            log.info("El cliente que intenta actualizar no existe en la base de datos");
            throw new ItNotFoundException("El cliente no existe en la base de datos");
        } else {
            ClientValidator.clientValidator(newClient);

            log.info("Cliente encontrado");
            Client clientDB = clientOp.get();

            clientDB.setName(newClient.getName());
            clientDB.setLastname(newClient.getLastname());
            clientDB.setDocnumber(newClient.getDocnumber());

            log.info("Cliente Actualizado: " + clientDB);
            return this.clientRepository.save(clientDB);
        }
    }

    //Comente el método DELETE porque en la realidad no se eliminan registros así
    /*public void delete(Long id) throws Exception{
        log.info("ID ingresado: " + id);
        if (id <= 0){
            throw new IdInvalitedException("El ID ingresado no es valido");
        }

        Optional<Client> clientOp = this.clientRepository.findById(id);

        if (clientOp.isEmpty()){
            log.info("El cliente que intenta eliminar no existe en la base de datos");
            throw new ItNotFoundException("El cliente no existe en la base de datos");
        } else {
            log.info("El cliente con ID " + id + " se eliminó");
            clientRepository.delete(clientOp.get());
        }
    }*/
}
