package com.kwabenaberko.book_shelf.model;

import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
public class Book {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String title;
    private String author;
    private String isbn;
    private boolean completed;

    @ManyToOne
    private Customer customer;

    @CreatedDate
    private LocalDateTime createdAt;

    @LastModifiedDate
    private LocalDateTime updatedAt;

    private Book(Builder builder) {
        this.title = builder.title;
        this.author = builder.author;
        this.isbn = builder.isbn;
        this.customer = builder.customer;
    }

    protected Book() {}

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getIsbn() {
        return isbn;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    public boolean isCompleted() {
        return completed;
    }

    public void setCompleted(boolean completed) {
        this.completed = completed;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(LocalDateTime createdAt) {
        this.createdAt = createdAt;
    }

    public LocalDateTime getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(LocalDateTime updatedAt) {
        this.updatedAt = updatedAt;
    }

    public static class Builder {
        private String title;
        private String author;
        private String isbn;
        private Customer customer;

        public Builder withTitle(String title){
            this.title = title;
            return this;
        }

        public Builder withAuthor(String author){
            this.author = author;
            return this;
        }

        public Builder withIsbn(String isbn){
            this.isbn = isbn;
            return this;
        }

        public Builder withCustomer(Customer customer){
            this.customer = customer;
            return this;
        }

        public Book build(){
            return new Book(this);
        }
    }
}
