package com.BookLibrary.bookLibrary;

import com.BookLibrary.bookLibrary.model.Book;
import com.BookLibrary.bookLibrary.model.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.Date;

@Controller
public class DefaultController {

    @Autowired
    BookRepository bookRepository;

    @RequestMapping("/")
    public String index(Model model){
        Iterable<Book> bookIterable = bookRepository.findAll();
        ArrayList<Book> books = new ArrayList<>();
        for(Book book : bookIterable){
            books.add(book);
        }
        model.addAttribute("books", books);

        return "index";
    }
}
