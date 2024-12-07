package com.example.openapigenerator.service;

import com.example.openapigenerator.model.Book;

import java.util.List;

public interface BooksService {

    Book createBook(Book book);

    Boolean deleteBook(Integer id);

    Book getBookById(Integer id);

    List<Book> getBooks();

    Boolean updateBook(Book book);
}
