package ecommerce.coderhouse.JPA_CoderHouse.entities;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.Data;

import java.util.List;

@Entity
@Data
@Table(name = "clients")
public class Client {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String lastname;
    private String docnumber;
    @OneToOne
    @JoinColumn(name = "id_adress")
    private Adress adress;

    @JsonManagedReference("clientsEntities")
    @OneToMany(mappedBy = "client")
    private List<Invoice> invoice;

    public Client() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public String getDocnumber() {
        return docnumber;
    }

    public void setDocnumber(String docnumber) {
        this.docnumber = docnumber;
    }

    public Adress getAdress() {
        return adress;
    }

    public void setAdress(Adress adress) {
        this.adress = adress;
    }

    public List<Invoice> getInvoice() { return invoice; }

    public void setInvoice(List<Invoice> invoice) { this.invoice = invoice; }

    @Override
    public String toString() {
        return "Clients{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", lastname='" + lastname + '\'' +
                ", docnumber='" + docnumber + '\'' +
                ", adress='" + adress +
                '}';
    }
}
