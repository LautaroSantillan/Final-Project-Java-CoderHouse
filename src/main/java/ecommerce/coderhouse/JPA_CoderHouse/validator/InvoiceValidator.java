package ecommerce.coderhouse.JPA_CoderHouse.validator;

import ecommerce.coderhouse.JPA_CoderHouse.entities.Invoice;
import ecommerce.coderhouse.JPA_CoderHouse.exception.MinCantException;
import ecommerce.coderhouse.JPA_CoderHouse.exception.NullException;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class InvoiceValidator {
    public static void invoiceValidator(Invoice newInvoice) throws Exception{
        if(newInvoice.getTotal()==null){
            log.info("El total está vacio");
            throw new NullException("El total no puede estar vacio");
        }
        if(newInvoice.getTotal()<0){
            log.info("El total está en 0");
            throw new MinCantException("El total no puede ser menor o igual a 0");
        }
        if(newInvoice.getCreated_at()==null){
            log.info("La fecha está vacia");
            throw new NullException("La fecha de creación de la factura no puede estar vacia");
        }
    }
}
