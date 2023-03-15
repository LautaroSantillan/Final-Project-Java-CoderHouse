package ecommerce.coderhouse.JPA_CoderHouse.entities;
import jakarta.persistence.*;

@Entity
@Table(name = "adresses")
public class Adress {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String province;
    private String locality;
    private String street;
    private String height;

    public Adress() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getProvince() {
        return province;
    }

    public void setProvince(String province) {
        this.province = province;
    }

    public String getLocality() {
        return locality;
    }

    public void setLocality(String locality) {
        this.locality = locality;
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public String getHeight() {
        return height;
    }

    public void setHeight(String height) {
        this.height = height;
    }

    @Override
    public String toString() {
        return "Adress{" +
                "id='" + id + '\'' +
                ", province='" + province + '\'' +
                ", locality='" + locality + '\'' +
                ", street='" + street + '\'' +
                ", height='" + height + '\'' +
                '}';
    }
}
