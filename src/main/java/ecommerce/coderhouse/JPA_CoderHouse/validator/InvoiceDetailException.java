package ecommerce.coderhouse.JPA_CoderHouse.validator;

import ecommerce.coderhouse.JPA_CoderHouse.entities.Invoice_Detail;
import ecommerce.coderhouse.JPA_CoderHouse.exception.MinCantException;
import ecommerce.coderhouse.JPA_CoderHouse.exception.NullException;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class InvoiceDetailException {
    public static void invoiceDetailException(Invoice_Detail newInvoiceDetail) throws Exception{
        if(newInvoiceDetail.getPrice()==null){
            log.info("El precio está vacio");
            throw new NullException("El precio no puede estar vacio");
        }
        if(newInvoiceDetail.getPrice()<0){
            log.info("El precio está en 0");
            throw new MinCantException("El precio no puede ser menor o igual a 0");
        }
        if(newInvoiceDetail.getAmount()<0){
            log.info("La cantidad de compra está en 0");
            throw new MinCantException("La cantidad de compra no puede ser menor o igual a 0");
        }
    }
}
