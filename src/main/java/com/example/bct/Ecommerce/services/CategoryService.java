package com.example.bct.Ecommerce.services;

import com.example.bct.Ecommerce.entity.Category;
import com.example.bct.Ecommerce.repository.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
public class CategoryService {
    @Autowired
    CategoryRepository categoryRepository;

    public Category addCategory(Category category){
        category.setCreatedOn(new Date());
        category.setUpdatedOn(new Date());
        return categoryRepository.save(category);
    }

    //Not working please refer ProductService
//    public void addCategoryViaProduct(Category category,Long categoryId){
//        category.setCreatedOn(new Date());
//        category.setUpdatedOn(new Date());
//        category.setCategoryId(categoryId);
//        categoryRepository.save(category);
//    }

    public Category getCategoryById(Long id){
        List<Category> categList = categoryRepository.findAll();
        Category category=null;
        category = categList.stream().filter(e->e.getCategoryId()==id).findFirst().get();
        return category;
    }

    public boolean isThereAnyCategory(String categoryName){

        return categoryRepository.existsByCategoryName(categoryName);
    }

    public List<Category> getAllCategory(){
        List<Category> categoryList= categoryRepository.findAll();
        return categoryList;
    }

    public String deleteCategoryById(Long id){
        List<Category> categList = categoryRepository.findAll();
        Category category=null;
        category = categList.stream().filter(e->e.getCategoryId()==id).findFirst().get();
        categoryRepository.delete(category);
        return "DELETED "+category.getCategoryName();
    }
}
