package com.clap.lms.domain.entities;

import com.clap.lms.domain.enumurations.BookType;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.validation.constraints.*;
import java.util.List;

@ToString
@Getter
@Setter
public class Book {
    @NotNull
    private Integer id;

    @NotNull
    private String title;

    @NotNull
    private String isbnCode;

    @NotNull
    @Max(10_000)
    private Short numberOfPages;

    @Null
    private BookType bookType;

    @Null
    private String author;

    private boolean isAvailable;

    private Short publishedYear;

    private String subject;

    @Size(max = 5)
    private List<String> tags;

    public boolean isAvailable() {
        return isAvailable;
    }

    public void lend() {
        isAvailable = false;
    }
}
