package com.kwabenaberko.rest_api_auth.book;

import com.kwabenaberko.rest_api_auth.user.User;

import java.time.LocalDateTime;

public class Book {
    private Long id;
    private String title;
    private String author;
    private String isbn;
    private boolean read;
    private User user;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;

    private Book(Builder builder) {
        this.title = builder.title;
        this.author = builder.author;
        this.isbn = builder.isbn;
    }

    protected Book() {
        this.createdAt = LocalDateTime.now();
    }

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

    public boolean isRead() {
        return read;
    }

    public void setRead(boolean read) {
        this.read = read;
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
        private User user;

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

        public Builder withUser(User user){
            this.user = user;
            return this;
        }

        public Book build(){
            return new Book(this);
        }
    }
}
