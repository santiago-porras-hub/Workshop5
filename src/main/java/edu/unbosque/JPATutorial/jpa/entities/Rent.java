package edu.unbosque.JPATutorial.jpa.entities;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "Rent") // Optional
@NamedQueries({
        @NamedQuery(name = "Costumer.findByDate",
                query = "SELECT a FROM Rent a WHERE a.rentingDate = :renting_date")
})
public class Rent {

    @Id
    @GeneratedValue
    @Column(name = "rent_id")
    private Integer rentId;

    @ManyToOne
    @JoinColumn(name = "email", nullable = false)
    private Customer email;

    @ManyToOne
    @JoinColumn(name = "edition_id", nullable = false)
    private Edition editionId;

    @Column(name = "renting_date", nullable = false)
    private String rentingDate;

    public Rent() {

    }

    public Rent(Customer email, Edition editionId, String rentingDate) {
        this.email = email;
        this.editionId = editionId;
        this.rentingDate = rentingDate;
    }

    public Rent(Integer rentId, Customer email, Edition editionId, String rentingDate) {
        this.rentId = rentId;
        this.email = email;
        this.editionId = editionId;
        this.rentingDate = rentingDate;
    }

    public Integer getRentId() {
        return rentId;
    }

    public void setRentId(Integer rentId) {
        this.rentId = rentId;
    }

    public Customer getEmail() {
        return email;
    }

    public void setEmail(Customer email) {
        this.email = email;
    }

    public Edition getEditionId() {
        return editionId;
    }

    public void setEditionId(Edition editionId) {
        this.editionId = editionId;
    }

    public String getRentingDate() {
        return rentingDate;
    }

    public void setRentingDate(String rentingDate) {
        this.rentingDate = rentingDate;
    }
}
