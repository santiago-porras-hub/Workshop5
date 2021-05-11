package edu.unbosque.JPATutorial.jpa.entities;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "Costumer") // Optional
@NamedQueries({
        @NamedQuery(name = "Costumer.findByEmail",
                query = "SELECT a FROM Costumer a WHERE a.email = :email")
})
public class Costumer {

    @Id
    @GeneratedValue
    @Column(name = "email", unique = true)
    private String email;

    @Column(name = "first_name", nullable = false)
    private String first_name;

    @Column(name = "last_name", nullable = false)
    private String last_name;

    @Column(name = "genre")
    private String genre;

    @Column(name = "age")
    private Integer age;

    //@OneToMany(mappedBy = "costumer", fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    //private List<Rent> rents = new ArrayList<>();

    public Costumer() {

    }

    public Costumer(String first_name, String last_name, String genre, Integer age) {
        this.first_name = first_name;
        this.last_name = last_name;
        this.genre = genre;
        this.age = age;
    }

    public Costumer(String email, String first_name, String last_name, String genre, Integer age) {
        this.email = email;
        this.first_name = first_name;
        this.last_name = last_name;
        this.genre = genre;
        this.age = age;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getFirst_name() {
        return first_name;
    }

    public void setFirst_name(String first_name) {
        this.first_name = first_name;
    }

    public String getLast_name() {
        return last_name;
    }

    public void setLast_name(String last_name) {
        this.last_name = last_name;
    }

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    /*public void addRent(Rent rent) {
        rents.add(rent);
        //Completar

    }*/
}
