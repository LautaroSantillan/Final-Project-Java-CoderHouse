package ecommerce.coderhouse.JPA_CoderHouse.entities;
import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;

@Entity
@Table(name = "invoice_details")
public class InvoiceDetail {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long invoiceDetailsId;
    private int amount;
    private Double price;
    @JsonBackReference
    @ManyToOne
    @JoinColumn(name="id_invoice")
    private Invoice invoice;
    private Double productPrice;
    @ManyToOne
    @JoinColumn(name="id_product")
    private Product product;
    @Transient
    private long invoiceId;

    public long getInvoiceDetailsId() {
        return invoiceDetailsId;
    }

    public void setInvoiceDetailsId(long invoiceDetailsId) {
        this.invoiceDetailsId = invoiceDetailsId;
    }

    public Integer getAmount() {
        return amount;
    }

    public void setAmount(Integer amount) {
        this.amount = amount;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public Invoice getInvoice() {
        return invoice;
    }

    public void setInvoice(Invoice invoice) {
        this.invoice = invoice;
    }

    public Double getProductPrice() {
        return productPrice;
    }

    public void setProductPrice(Double productPrice) {
        this.productPrice = productPrice;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public long getInvoiceId() {
        return invoiceId;
    }

    public void setInvoiceId(long invoiceId) {
        this.invoiceId = invoiceId;
    }
}
