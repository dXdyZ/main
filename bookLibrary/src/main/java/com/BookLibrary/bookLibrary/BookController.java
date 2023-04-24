package com.BookLibrary.bookLibrary;

import com.BookLibrary.bookLibrary.model.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.BookLibrary.bookLibrary.model.Book;

import java.util.List;

@RestController
public class BookController {

    @Autowired
    private BookRepository bookRepository;
    @GetMapping("/books/")
    public List<Book> list(){
        return Storage.getAllBooks();
    }

    @PostMapping("/books/")
    public int add(Book book){
        Book newBook = bookRepository.save(book);
        return newBook.getId();
    }


    @GetMapping("/books/{id}")
    public ResponseEntity get(@PathVariable int id){
        Book book = Storage.getBook(id);
        if(book == null){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
        }
        return  new ResponseEntity(book, HttpStatus.OK);
    }
}
