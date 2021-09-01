package com.clap.lms.infra.dataprovider;

import com.clap.lms.domain.model.Book;
import com.clap.lms.business.repository.BookCommand;
import com.clap.lms.business.repository.BookQuery;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.CopyOnWriteArrayList;

@Component
public class BookDao implements BookCommand, BookQuery {

    private final List<Book> books = new CopyOnWriteArrayList<>();

    private final Map<Integer, Book> isbnToBookMap = new HashMap<>();

    @Override
    public void addBook(Book book) {
        if (isbnToBookMap.get(book.getId()) == null) {
            isbnToBookMap.put(book.getId(), book);
            books.add(book);
        } else {
            throw new IllegalArgumentException("Book already exist with same ISBN");
        }
    }

    @Override
    public void updateBookAvailability(Integer bookId, Boolean isAvailable) {
        Book book = isbnToBookMap.get(bookId);
        book.setAvailable(true);
    }

    @Override
    public Book getBookById(Integer title) {
        return isbnToBookMap.get(title);
    }


    @Override

    public List<Book> getAllBooks() {
        return books;
    }


    @Override
    public List<Book> getAllAvailableBooks() {
        return null;
    }
}
