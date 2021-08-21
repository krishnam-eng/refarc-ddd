package com.example.library.domain;

import com.example.library.constant.BookType;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import java.util.List;

@ToString
@Getter
@Setter
public class Book {
    private Integer id;
    private String title;
    private String isbnCode;
    private Short numberOfPages;

    private BookType bookType;

    private String author;

    private Boolean isAvailable;

    @Min(0)
    @Max(3000)
    private Short publishedYear;

    private String subject;

    private List<String> tags;

    public Boolean isAvailable() {
        return isAvailable;
    }

    public void lend() {
        isAvailable = false;
    }
}
