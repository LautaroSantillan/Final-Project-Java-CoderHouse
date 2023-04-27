package ecommerce.coderhouse.JPA_CoderHouse.validator;

import ecommerce.coderhouse.JPA_CoderHouse.entities.Adress;
import ecommerce.coderhouse.JPA_CoderHouse.exception.MinCantException;
import ecommerce.coderhouse.JPA_CoderHouse.exception.NullException;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class AdressValidator {
    public static void adressValidator(Adress newAdress) throws Exception{
        if(newAdress.getProvince().isEmpty()){
            log.info("El campo de provincia está vacia");
            throw new NullException("El campo de provincia no puede estar vacia");
        }
        if(newAdress.getProvince().length()<4){
            log.info("El campo de provincia es corto");
            throw new MinCantException("El campo de provincia no puede ser menor a 4 caracteres");
        }
        if(newAdress.getLocality().isEmpty()){
            log.info("El campo de localidad está vacia");
            throw new NullException("El campo de localidad no puede estar vacia");
        }
        if(newAdress.getLocality().length()<5){
            log.info("El campo de localidad es corto");
            throw new MinCantException("El campo de localidad no puede ser menor a 5 caracteres");
        }
        if(newAdress.getStreet().isEmpty()){
            log.info("El campo de calle está vacia");
            throw new NullException("El campo de calle no puede estar vacia");
        }
        if(newAdress.getStreet().length()<4){
            log.info("El campo de calle es corto");
            throw new MinCantException("El campo de calle no puede ser menor a 4 caracteres");
        }
        if(newAdress.getHeight().isEmpty()){
            log.info("El campo de altitud está vacia");
            throw new NullException("El campo de altitud no puede estar vacia");
        }
    }
}
