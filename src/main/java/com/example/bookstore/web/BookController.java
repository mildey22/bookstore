package com.example.bookstore.web;

import java.util.ArrayList;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import com.example.bookstore.model.BookRepository;
import org.springframework.web.bind.annotation.RequestParam;
import com.example.bookstore.model.Book;


@Controller
public class BookController {

    @Autowired
    private BookRepository repository;

    @RequestMapping(value = {"/", "/booklist"})
    public String bookList(Model model){
        model.addAttribute("books", repository.findAll());
    return "booklist";
}

@RequestMapping(value = "/delete/{id}", method = RequestMethod.GET)
public String deleteBook(@PathVariable("id") Long bookId, Model model) {
    repository.deleteById(bookId);
    return "redirect:../booklist";
}

@RequestMapping("/addbook")
public String addBook(Model model) {
    model.addAttribute("book", new Book());
    return "addbook";
}


@RequestMapping(value = "/save", method = RequestMethod.POST)
public String save(Book book) {
    repository.save(book);
    return "redirect:booklist";
}



}
