package edu.unbosque.JPATutorial.jpa.entities;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "Rent") // Optional
@NamedQueries({
        @NamedQuery(name = "Rent.findByDate",
                query = "SELECT a FROM Rent a WHERE a.rentingDate = :renting_date")
})
public class Rent {

    @Id
    @GeneratedValue
    @Column(name = "rent_id")
    private Integer rentId;

    @ManyToOne
    @JoinColumn(name = "email", nullable = false)
    private Customer customer;

    @ManyToOne
    @JoinColumn(name = "edition_id", nullable = false)
    private Edition edition;

    @Column(name = "renting_date", nullable = false)
    private String rentingDate;

    public Rent() {

    }

    public Rent(Customer customer, Edition edition, String rentingDate) {
        this.customer = customer;
        this.edition = edition;
        this.rentingDate = rentingDate;
    }

    public Rent(Integer rentId, Customer customer, Edition edition, String rentingDate) {
        this.rentId = rentId;
        this.customer = customer;
        this.edition = edition;
        this.rentingDate = rentingDate;
    }

    public Integer getRentId() {
        return rentId;
    }

    public void setRentId(Integer rentId) {
        this.rentId = rentId;
    }

    public Customer getEmail() {
        return customer;
    }

    public void setEmail(Customer email) {
        this.customer = email;
    }

    public Edition getEditionId() {
        return edition;
    }

    public void setEditionId(Edition edition) {
        this.edition = edition;
    }

    public String getRentingDate() {
        return rentingDate;
    }

    public void setRentingDate(String rentingDate) {
        this.rentingDate = rentingDate;
    }
}
