package com.example.bookinfo.service;

import com.example.bookinfo.entity.Author;
import com.example.bookinfo.repo.AuthorRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AuthorService {
    private AuthorRepo authorRepo;

    @Autowired
    public AuthorService(AuthorRepo authorRepo) {
        this.authorRepo = authorRepo;
    }

    public List<Author> getAuthors(){
        return authorRepo.findAll();
    }

    public void save(Author author){
        authorRepo.save(author);
    }


}
