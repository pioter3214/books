package com.example.bookinfo.repo;

import com.example.bookinfo.entity.Author;
import com.example.bookinfo.entity.Book;
import com.example.bookinfo.entity.Category;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BookRepo extends JpaRepository<Book,Long> {

    @Override
    public List<Book> findAll();
    public List<Book> getAllByAuthorSetContainsAndCategory(Author author, Category category);
}
