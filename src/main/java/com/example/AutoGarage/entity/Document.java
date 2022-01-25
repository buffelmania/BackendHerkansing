package com.example.AutoGarage.entity;


import javax.persistence.*;

@Entity (name = "Documents")
@Table (name = "documents")
public class Document {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Lob
    private byte[] content;

    @ManyToOne(cascade = CascadeType.MERGE)
    private Customer customer;

    public Document(){

    }

    public Document(byte[]content, Customer customer){
        this.customer = customer;
        this.content = content;
    }

    public Long getId() {return id;}
    public void setId(Long id) {this.id = id;}

    public byte[] getContent() {return content;}
    public void setContent(byte[] content) {this.content = content;}

    public Customer getCustomer() {return customer;}

    public void setCustomer(Customer customer) {this.customer = customer;}
}
