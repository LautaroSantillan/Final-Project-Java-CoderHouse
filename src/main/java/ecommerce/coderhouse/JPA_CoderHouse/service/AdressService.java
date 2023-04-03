package ecommerce.coderhouse.JPA_CoderHouse.service;

import ecommerce.coderhouse.JPA_CoderHouse.entities.Adress;
import ecommerce.coderhouse.JPA_CoderHouse.exception.IdInvalitedException;
import ecommerce.coderhouse.JPA_CoderHouse.exception.ItAlreadyExistsException;
import ecommerce.coderhouse.JPA_CoderHouse.exception.ItNotFoundException;
import ecommerce.coderhouse.JPA_CoderHouse.repository.AdressRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Slf4j
@Service
public class AdressService {
    @Autowired
    private AdressRepository adressRepository;

    public Adress create(Adress newAdress) throws ItAlreadyExistsException{
        Optional<Adress> adressOp = this.adressRepository.findById(newAdress.getId());

        if (adressOp.isPresent()){
            log.info("La dirección que intenta ingresar ya existe en la base de datos: " + newAdress);
            throw new ItAlreadyExistsException("La dirección ya existe en la base de datos");
        } else {
            return this.adressRepository.save(newAdress);
        }
    }

    public Adress findById(Long id) throws Exception{
        if (id <= 0){
            throw new IdInvalitedException("El ID ingresado no es valido");
        }

        Optional<Adress> adressOp = this.adressRepository.findById(id);

        if (adressOp.isEmpty()){
            log.info("La dirección con ID " + id + " no existe");
            throw new ItNotFoundException("La dirección solicitada no existe en la base de datos");
        } else {
            return adressOp.get();
        }
    }

    public List<Adress> findAll(){ return this.adressRepository.findAll(); }

    public Adress update(Adress newAdress, Long id) throws Exception{
        log.info("ID ingresado: " + id);
        if (id <= 0){
            throw new IdInvalitedException("El ID ingresado no es valido");
        }

        Optional<Adress> adressOp = this.adressRepository.findById(id);

        if (adressOp.isEmpty()){
            log.info("La dirección que intenta actualizar no existe");
            throw new ItNotFoundException("La dirección no existe en la base de datos");
        } else {
            log.info("Dirección encontrada");
            Adress adressDB = adressOp.get();

            adressDB.setProvince(newAdress.getProvince());
            adressDB.setLocality(newAdress.getLocality());
            adressDB.setStreet(newAdress.getStreet());
            adressDB.setHeight(newAdress.getHeight());

            log.info("Dirección actualizada: " + adressDB);
            return this.adressRepository.save(adressDB);
        }
    }

    public void delete(Long id) throws Exception{
        log.info("ID ingresado: " + id);
        if (id <= 0){
            throw new IdInvalitedException("El ID ingresado no es valido");
        }

        Optional<Adress> adressOp = this.adressRepository.findById(id);

        if (adressOp.isEmpty()){
            log.info("La dirección que intenta eliminar no existe");
            throw new ItNotFoundException("La dirección no existe en la base de datos");
        } else {
            log.info("La dirección con ID " + id + " se elimino satisfactoriamente");
            adressRepository.delete(adressOp.get());
        }
    }
}
