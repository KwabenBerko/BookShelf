package com.kwabenaberko.book_shelf.model;

import javax.persistence.*;
import java.util.UUID;

@Entity
public class Customer {
    @Id
    private String id;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn
    private User user;

    public Customer(User user) {
        this.id = UUID.randomUUID().toString();
        this.user = user;
    }

    protected Customer(){}

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    @Override
    public String toString() {
        return "Customer{" +
                "id='" + id + '\'' +
                ", user=" + user +
                '}';
    }
}
