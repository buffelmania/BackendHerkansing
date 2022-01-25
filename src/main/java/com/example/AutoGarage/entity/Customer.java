package com.example.AutoGarage.entity;

import javax.persistence.*;
import java.util.List;
import javax.validation.constraints.Email;

@Entity(name = "Customer")
@Table(name = "customers")
public class Customer {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "first_name", nullable = false)
    private String firstName;

    @Column(name = "last_name", nullable = false)
    private String lastName;

    @Column(name = "email")
    @Email(message = "Geen geldig emailadres ingevoerd.")
    private String email;

    @Column(name = "phonenumber", nullable = false)
    private String phoneNR;

    @OneToMany
    @JoinColumn(name = "customer_id", referencedColumnName = "Id")
    private List<Car> cars;

    @OneToMany
    @JoinColumn(name= "customer_id", referencedColumnName = "Id")
    private List<Document> documents;


    public Customer(){}

    public Customer(Long id, String firstName, String lastName, String email, String phoneNR) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.phoneNR = phoneNR;
    }

    public Customer(String firstName, String lastName, String email, String phoneNR) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.phoneNR = phoneNR;
    }

    public Long getId() {return id;}
    public void setId(Long id) {
        this.id = id;
    }

    public String getFirstName() {return firstName;}
    public void setFirstName(String firstName) {this.firstName = firstName;}

    public String getLastName() {return lastName;}
    public void setLastName(String lastName) {this.lastName = lastName;}


    public String getEmail() {return email;}
    public void setEmail(String email) {this.email = email;}

    public String getPhoneNR() {return phoneNR;}
    public void setPhoneNR(String phoneNR) {this.phoneNR = phoneNR;}












}
