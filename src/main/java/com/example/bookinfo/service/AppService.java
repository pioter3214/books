package com.example.bookinfo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

@Service
public class AppService {
    private AuthorService authorService;
    private BookService bookService;
    private CategoryService categoryService;

    @Autowired
    public AppService(AuthorService authorService, BookService bookService, CategoryService categoryService) {
        this.authorService = authorService;
        this.bookService = bookService;
        this.categoryService = categoryService;
    }

    public List<Map<String,Object>> getAuthorsAmountOfBooksInCategory(){
        List<Map<String, Object>> json = new ArrayList<>();
        authorService.getAuthors().stream().forEach(author -> {
            Map<String,Object> authorInf = new LinkedHashMap<>();
            authorInf.put("first_name", author.getFirstName());
            authorInf.put("last_name", author.getLastName());

            categoryService.getCategories().stream().forEach(category -> {
                int bookCount = bookService.getBooksByAuthorAndCategory(author,category).size();
                authorInf.put(category.getCategoryName().replace(" ","_").toLowerCase(),bookCount);
            });
            json.add(authorInf);

        });
        return json;
    }
}
