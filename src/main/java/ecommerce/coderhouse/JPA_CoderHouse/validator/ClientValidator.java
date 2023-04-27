package ecommerce.coderhouse.JPA_CoderHouse.validator;

import ecommerce.coderhouse.JPA_CoderHouse.entities.Client;
import ecommerce.coderhouse.JPA_CoderHouse.exception.InputShortException;
import ecommerce.coderhouse.JPA_CoderHouse.exception.NullException;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class ClientValidator {
    public static void clientValidator(Client newClient) throws Exception{
        if(newClient.getName().isEmpty()){
            log.info("El nombre está vacio");
            throw new NullException("El nombre no puede estar vacio");
        }
        if(newClient.getName().length()<3){
            log.info("El nombre es corto");
            throw new InputShortException("El nombre no puede ser menor a 3 caracteres");
        }
        if(newClient.getLastname().isEmpty()){
            log.info("El apellido está vacio");
            throw new NullException("El apellido no puede estar vacio");
        }
        if(newClient.getLastname().length()<3){
            log.info("El apellido es corto");
            throw new InputShortException("El apellido no puede ser menor a 3 caracteres");
        }
        if(newClient.getDocnumber().isEmpty()){
            log.info("El número de documento está vacio");
            throw new NullException("El número de documento no puede estar vacio");
        }
        if(newClient.getDocnumber().length()<7){
            log.info("El número de documento es corto");
            throw new InputShortException("El número de documento no puede ser menor a 7 caracteres");
        }
    }
}
