package ecommerce.coderhouse.JPA_CoderHouse.entities;
import jakarta.persistence.*;

@Entity
@Table(name = "invoice_details")
public class Invoice_Detail {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @ManyToOne
    @JoinColumn(name = "id_invoice")
    private Invoice invoice;
    @ManyToOne
    @JoinColumn(name = "id_product")
    private Product product;
    private int amount;
    private Double price;

    public Invoice_Detail() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Invoice getInvoice() {
        return invoice;
    }

    public void setInvoice(Invoice invoice) {
        this.invoice = invoice;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return "Invoice_Detail{" +
                "id='" + id + '\'' +
                ", invoice='" + invoice + '\'' +
                ", product='"  + product + '\'' +
                ", amount='" + amount + '\'' +
                ", price='" + price +
                '}';
    }
}
