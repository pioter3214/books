package com.example.bookinfo.service;

import com.example.bookinfo.entity.Category;
import com.example.bookinfo.repo.CategoryRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CategoryService {
    private CategoryRepo categoryRepo;

    @Autowired
    public CategoryService(CategoryRepo categoryRepo) {
        this.categoryRepo = categoryRepo;
    }

    public List<Category> getCategories(){
        return categoryRepo.findAll();
    }

    public void save(Category category){
        categoryRepo.save(category);
    }

}
