package ecommerce.coderhouse.JPA_CoderHouse.service;

import ecommerce.coderhouse.JPA_CoderHouse.entities.Invoice_Detail;
import ecommerce.coderhouse.JPA_CoderHouse.exception.IdInvalitedException;
import ecommerce.coderhouse.JPA_CoderHouse.exception.ItNotFoundException;
import ecommerce.coderhouse.JPA_CoderHouse.repository.Invoice_DetailRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Slf4j
@Service
public class Invoice_DetailService {
    @Autowired
    private Invoice_DetailRepository invoice_detailRepository;

    public Invoice_Detail create(Invoice_Detail newInvoice_detail){ return this.invoice_detailRepository.save(newInvoice_detail); }

    public Invoice_Detail findById(Long id) throws Exception{
        if (id <= 0){
            throw new IdInvalitedException("El ID ingresado no es valido");
        }

        Optional<Invoice_Detail> invoice_detailOp = this.invoice_detailRepository.findById(id);

        if (invoice_detailOp.isEmpty()){
            log.info("La factura con detalles con id " + id + "  no existe en la base de datos");
            throw new ItNotFoundException("La factura detallada no existe en la base de datos");
        } else {
            return invoice_detailOp.get();
        }
    }

    public List<Invoice_Detail> findAll(){ return this.invoice_detailRepository.findAll(); }

    public Invoice_Detail update(Invoice_Detail newInvoice_detail, Long id) throws Exception{
        log.info("ID ingresado: " + id);
        if (id <= 0){
            throw new IdInvalitedException("El ID ingresado no es valido");
        }

        Optional<Invoice_Detail> invoice_detailOp = this.invoice_detailRepository.findById(id);

        if (invoice_detailOp.isEmpty()){
            log.info("La factura con detalles con id " + id + "  no existe en la base de datos");
            throw new ItNotFoundException("La factura detallada no existe en la base de datos");
        } else {
            log.info("La factura detallada fue encontrada");
            Invoice_Detail invoice_detailDB = invoice_detailOp.get();

            invoice_detailDB.setInvoice(newInvoice_detail.getInvoice());
            invoice_detailDB.setProduct(newInvoice_detail.getProduct());
            invoice_detailDB.setAmount(newInvoice_detail.getAmount());
            invoice_detailDB.setPrice(newInvoice_detail.getPrice());

            log.info("Factura detallada actualizada: " + invoice_detailDB);
            return this.invoice_detailRepository.save(invoice_detailDB);
        }
    }

    public void delete(Long id) throws Exception{
        log.info("ID ingresado: " + id);
        if (id <= 0) {
            throw new IdInvalitedException("El ID ingresado no es valido");
        }

        Optional<Invoice_Detail> invoice_detailOp = this.invoice_detailRepository.findById(id);

        if (invoice_detailOp.isEmpty()){
            log.info("La factura con detalles con id " + id + "  no existe en la base de datos");
            throw new ItNotFoundException("La factura detallada no existe en la base de datos");
        } else {
            log.info("La factura detallada con ID " + id + " se eliminó satisfactoriamente");
            invoice_detailRepository.delete(invoice_detailOp.get());
        }
    }
}
