package com.example.openapigenerator.service.impl;

import com.example.openapigenerator.model.Book;
import com.example.openapigenerator.repo.BookRepository;
import com.example.openapigenerator.service.BooksService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BooksServiceImpl implements BooksService {

    private final BookRepository bookRepository;

    public BooksServiceImpl(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    @Override
    public Book createBook(Book book) {
        bookRepository.createBook(book);
        return book;
    }

    @Override
    public Boolean deleteBook(Integer id) {
        bookRepository.deleteBook(Long.valueOf(id));
        return true;
    }

    @Override
    public Book getBookById(Integer id) {
        return bookRepository.getBookById(Long.valueOf(id));
    }

    @Override
    public List<Book> getBooks() {
        return bookRepository.getBooks();
    }

    @Override
    public Boolean updateBook(Book book) {
        bookRepository.updateBook(book);
        return true;
    }
}
