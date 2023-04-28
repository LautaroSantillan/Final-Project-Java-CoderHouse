package ecommerce.coderhouse.JPA_CoderHouse.service;

import ecommerce.coderhouse.JPA_CoderHouse.entities.InvoiceDetail;
import ecommerce.coderhouse.JPA_CoderHouse.exception.IdInvalitedException;
import ecommerce.coderhouse.JPA_CoderHouse.exception.ItNotFoundException;
import ecommerce.coderhouse.JPA_CoderHouse.repository.InvoiceRepository;
import ecommerce.coderhouse.JPA_CoderHouse.repository.InvoiceDetailRepository;
import ecommerce.coderhouse.JPA_CoderHouse.validator.InvoiceDetailValidator;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Slf4j
@Service
public class InvoiceDetailService {
    @Autowired
    private InvoiceDetailRepository invoiceDetailRepository;

    @Autowired
    private InvoiceRepository invoiceRepository;

    public InvoiceDetail create(InvoiceDetail newInvoiceDetail) throws Exception{
        newInvoiceDetail.setInvoice(invoiceRepository.findById(newInvoiceDetail.getInvoiceId()).orElseThrow(() -> new ItNotFoundException("Este invoice no existe")));
        double actualPrice = newInvoiceDetail.getProduct().getPrice();
        newInvoiceDetail.setProductPrice(actualPrice);
        newInvoiceDetail.setPrice(actualPrice * newInvoiceDetail.getAmount());
        InvoiceDetailValidator.invoiceDetailValidator(newInvoiceDetail);

        return this.invoiceDetailRepository.save(newInvoiceDetail);
    }
}
