package com.kwabenaberko.rest_api_auth.book.dto;

import javax.validation.constraints.NotNull;

public class BookDTO {
    @NotNull
    private String title;

    @NotNull
    private String author;

    @NotNull
    private String isbn;

    public String getTitle() {
        return title;
    }

    public String getAuthor() {
        return author;
    }

    public String getIsbn() {
        return isbn;
    }
}
