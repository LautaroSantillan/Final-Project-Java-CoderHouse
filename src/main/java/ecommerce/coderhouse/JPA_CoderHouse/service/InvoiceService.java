package ecommerce.coderhouse.JPA_CoderHouse.service;

import ecommerce.coderhouse.JPA_CoderHouse.entities.Invoice;
import ecommerce.coderhouse.JPA_CoderHouse.exception.IdInvalitedException;
import ecommerce.coderhouse.JPA_CoderHouse.exception.ItNotFoundException;
import ecommerce.coderhouse.JPA_CoderHouse.repository.InvoiceRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Slf4j
@Service
public class InvoiceService {
    @Autowired
    private InvoiceRepository invoiceRepository;

    public Invoice create(Invoice newInvoice){
        return this.invoiceRepository.save(newInvoice);
    }

    public Invoice findById(Long id) throws Exception{
        if (id <= 0){
            throw new IdInvalitedException("El ID ingresado no es valido");
        }

        Optional<Invoice> invoiceOp = this.invoiceRepository.findById(id);

        if (invoiceOp.isEmpty()){
            log.info("La factura con id " + id + "  no existe en la base de datos");
            throw new ItNotFoundException("La factura no existe en la base de datos");
        } else {
            return invoiceOp.get();
        }
    }

    public List<Invoice> findAll(){ return this.invoiceRepository.findAll(); }

    public Invoice update(Invoice newInvoice, Long id) throws Exception{
        log.info("ID ingresado: " + id);
        if (id <= 0){
            throw new IdInvalitedException("El ID ingresado no es valido");
        }

        Optional<Invoice> invoiceOp = this.invoiceRepository.findById(id);

        if (invoiceOp.isEmpty()){
            log.info("La factura que intenta actualizar no existe en la base de datos");
            throw new ItNotFoundException("La factura no existe en la base de datos");
        } else {
            log.info("La factura fue encontrada");
            Invoice invoiceDB = invoiceOp.get();

            invoiceDB.setClient(newInvoice.getClient());
            invoiceDB.setCreated_at(newInvoice.getCreated_at());
            invoiceDB.setTotal(newInvoice.getTotal());

            log.info("Factura actualizada: " + invoiceDB);
            return this.invoiceRepository.save(invoiceDB);
        }
    }

    public void delete(Long id) throws Exception{
        log.info("ID ingresado: " + id);
        if (id <= 0) {
            throw new IdInvalitedException("El ID ingresado no es valido");
        }

        Optional<Invoice> invoiceOp = this.invoiceRepository.findById(id);

        if (invoiceOp.isEmpty()){
            log.info("La factura que intenta eliminar no existe en la base de datos");
            throw new ItNotFoundException("La factura no existe en la base de datos");
        } else {
            log.info("La factura con ID " + id + " se eliminó satisfactoriamente");
            invoiceRepository.delete(invoiceOp.get());
        }
    }
}
