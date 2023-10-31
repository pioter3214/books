package com.example.bookinfo.controller;

import com.example.bookinfo.service.AppService;
import com.example.bookinfo.service.AuthorService;
import com.example.bookinfo.service.BookService;
import com.example.bookinfo.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/api")
public class ApiContoller {
    private AuthorService authorService;
    private BookService bookService;
    private CategoryService categoryService;

    private AppService appService;

    @Autowired
    public ApiContoller(AuthorService authorService, BookService bookService, CategoryService categoryService, AppService appService) {
        this.authorService = authorService;
        this.bookService = bookService;
        this.categoryService = categoryService;
        this.appService = appService;
    }

    @GetMapping("/authorBooksInCategory")
    public ResponseEntity authorsBooks(){
        return new ResponseEntity(appService.getAuthorsAmountOfBooksInCategory(),HttpStatus.OK);
    }

    @GetMapping("/books")
    public ResponseEntity getBooks(){
        return new ResponseEntity(bookService.getBooks(),HttpStatus.OK);
    }

    @GetMapping("authors")
    public ResponseEntity getAuthors(){
        return new ResponseEntity<>(authorService.getAuthors(),HttpStatus.OK);
    }


}
