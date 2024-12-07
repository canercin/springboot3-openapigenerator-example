package com.example.openapigenerator.api;

import com.example.openapigenerator.model.Book;
import com.example.openapigenerator.service.BooksService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class BooksApiImpl implements BooksApi {

    private final BooksService booksService;

    public BooksApiImpl(BooksService booksService) {
        this.booksService = booksService;
    }

    @PostMapping
    @Override
    public ResponseEntity<Book> createBook(@RequestBody Book book) {
        Optional<Book> test = Optional.of(this.booksService.createBook(book));
        if (test.isPresent()) {
            return ResponseEntity.ok(test.get());
        } else {
            return ResponseEntity.badRequest().build();
        }
    }

    @DeleteMapping("/{id}")
    @Override
    public ResponseEntity<Void> deleteBook(@PathVariable Integer id) {
        if (this.booksService.deleteBook(id)) {
            return ResponseEntity.ok().build();
        } else {
            return ResponseEntity.badRequest().build();
        }
    }

    @GetMapping("/{id}")
    @Override
    public ResponseEntity<Book> getBookById(@PathVariable Integer id) {
        Optional<Book> test = Optional.of(this.booksService.getBookById(id));
        if (test.isPresent()) {
            return ResponseEntity.ok(test.get());
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @GetMapping
    @Override
    public ResponseEntity<List<Book>> getBooks() {
        return ResponseEntity.ok(this.booksService.getBooks());
    }

    @PutMapping("/{id}")
    @Override
    public ResponseEntity<Void> updateBook(@PathVariable Integer id, @RequestBody Book book) {
        if (this.booksService.updateBook(book)) {
            return ResponseEntity.ok().build();
        } else {
            return ResponseEntity.badRequest().build();
        }
    }
}
