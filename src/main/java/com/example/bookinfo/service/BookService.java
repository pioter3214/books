package com.example.bookinfo.service;

import com.example.bookinfo.entity.Author;
import com.example.bookinfo.entity.Book;
import com.example.bookinfo.entity.Category;
import com.example.bookinfo.repo.BookRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookService {
    private BookRepo bookRepo;

    @Autowired
    public BookService(BookRepo bookRepo) {
        this.bookRepo = bookRepo;
    }

    public BookService() {
    }

    public List<Book> getBooks(){
        return bookRepo.findAll();
    }

    public void save(Book book){
        bookRepo.save(book);
    }

    public List<Book> getBooksByAuthorAndCategory(Author author, Category category){
        return bookRepo.getAllByAuthorSetContainsAndCategory(author,category);
    }
}
