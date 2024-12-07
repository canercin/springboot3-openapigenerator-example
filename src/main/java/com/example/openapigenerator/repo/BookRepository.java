package com.example.openapigenerator.repo;

import com.example.openapigenerator.model.Book;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Repository
public class BookRepository {

    private Map<Long, Book> books = new HashMap<>();

    public Book createBook(Book book) {
        books.put(book.getId(), book);
        return book;
    }

    public Boolean deleteBook(Long id) {
        books.remove(id);
        return true;
    }

    public Book getBookById(Long id) {
        return books.get(id);
    }

    public List<Book> getBooks() {
        return List.copyOf(books.values());
    }

    public Boolean updateBook(Book book) {
        books.put(book.getId(), book);
        return true;
    }
}
