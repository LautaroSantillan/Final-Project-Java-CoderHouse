package ecommerce.coderhouse.JPA_CoderHouse.validator;

import ecommerce.coderhouse.JPA_CoderHouse.entities.Product;
import ecommerce.coderhouse.JPA_CoderHouse.exception.InputShortException;
import ecommerce.coderhouse.JPA_CoderHouse.exception.MinCantException;
import ecommerce.coderhouse.JPA_CoderHouse.exception.NullException;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class ProductValidator {
    public static void productValidator(Product newProduct) throws Exception{
        if(newProduct.getName().isEmpty()){
            log.info("El nombre está vacio");
            throw new NullException("El nombre no puede estar vacio");
        }
        if(newProduct.getName().length()<3){
            log.info("El nombre es corto");
            throw new InputShortException("El nombre no puede ser menor a 3 caracteres");
        }
        if(newProduct.getDescription().isEmpty()){
            log.info("La descripción está vacio");
            throw new NullException("La descripción no puede estar vacio");
        }
        if(newProduct.getDescription().length()<15){
            log.info("La descripción es corto");
            throw new InputShortException("La descripción no puede ser menor a 15 caracteres");
        }
        if(newProduct.getCode().isEmpty()){
            log.info("El código está vacio");
            throw new NullException("El código no puede estar vacio");
        }
        if(newProduct.getCode().length()<3){
            log.info("El código es corto");
            throw new InputShortException("La descripción no puede ser menor a 3 caracteres");
        }
        if(newProduct.getStock()<0){
            log.info("El stock está en 0");
            throw new MinCantException("El stock no puede ser menor o igual a 0");
        }
        if(newProduct.getPrice()==null){
            log.info("El precio está vacio");
            throw new InputShortException("El precio no puede estar vacio");
        }
        if(newProduct.getPrice()<0){
            log.info("El precio está en 0");
            throw new MinCantException("El precio no puede ser menor o igual a 0");
        }
    }
}
