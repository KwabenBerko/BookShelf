package com.kwabenaberko.book_shelf.dto;

import javax.validation.constraints.NotNull;

public class CreateBookDTO {
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
