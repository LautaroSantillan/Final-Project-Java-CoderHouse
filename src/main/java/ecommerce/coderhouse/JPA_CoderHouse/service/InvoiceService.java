package ecommerce.coderhouse.JPA_CoderHouse.service;

import ecommerce.coderhouse.JPA_CoderHouse.entities.Invoice;
import ecommerce.coderhouse.JPA_CoderHouse.entities.InvoiceDetail;
import ecommerce.coderhouse.JPA_CoderHouse.exception.IdInvalitedException;
import ecommerce.coderhouse.JPA_CoderHouse.exception.ItNotFoundException;
import ecommerce.coderhouse.JPA_CoderHouse.exception.LittleStockException;
import ecommerce.coderhouse.JPA_CoderHouse.repository.InvoiceRepository;
import ecommerce.coderhouse.JPA_CoderHouse.repository.ProductRepository;
import ecommerce.coderhouse.JPA_CoderHouse.validator.InvoiceValidator;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Slf4j
@Service
public class InvoiceService {
    @Autowired
    private InvoiceRepository invoiceRepository;

    @Autowired
    private InvoiceDetailService invoiceDetailService;

    @Autowired
    private ProductRepository productRepository;

    @Autowired
    private ProductService productService;

    public Invoice create(Invoice newInvoice) throws Exception {

        InvoiceValidator.invoiceValidator(newInvoice);

        newInvoice.setCreatedAt(LocalDate.now());

        for(int i=0; i<newInvoice.getInvoiceDetails().size();i++){

            InvoiceDetail invoiceDetail = newInvoice.getInvoiceDetails().get(i);

            if(invoiceDetail.getAmount()>productRepository.findById(invoiceDetail.getProduct().getId()).orElseThrow(() -> new ItNotFoundException("El producto seleccionado no existe.")).getStock()){
                log.info("El stock es insuficiente o nulo");
                throw new LittleStockException("Stock insuficiente");
            }
        }

        Invoice creatInvoice = this.invoiceRepository.save(newInvoice);
        double subTotal = 0;

        for(int i=0; i<newInvoice.getInvoiceDetails().size();i++){

            InvoiceDetail newInvoiceDetail = newInvoice.getInvoiceDetails().get(i);

            newInvoiceDetail.setInvoiceId(creatInvoice.getId());

            newInvoiceDetail.setProduct(productRepository.findById(newInvoiceDetail.getProduct().getId()).orElseThrow(() -> new ItNotFoundException("El producto seleccionado no existe.")));

            invoiceDetailService.create(newInvoiceDetail);

            subTotal+=newInvoiceDetail.getPrice();

            productService.subtractStock(newInvoiceDetail);

        }

        creatInvoice.setTotal(subTotal);
        this.invoiceRepository.save(creatInvoice);

        return creatInvoice;
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
}
