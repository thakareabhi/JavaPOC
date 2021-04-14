package com.example.bct.Ecommerce.controller;

import com.example.bct.Ecommerce.constants.ApiName;
import com.example.bct.Ecommerce.entity.Category;
import com.example.bct.Ecommerce.services.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static com.example.bct.Ecommerce.constants.ApiName.COMMON;

@RestController
@RequestMapping(value = COMMON)
public class CategoryController {

    @Autowired
    CategoryService categoryService;

    @PreAuthorize("hasRole('ADMIN')")
    @PostMapping(value = ApiName.CATEGORY_ADD)
    public Category addCategory(@RequestBody Category category){
        return categoryService.addCategory(category);
    }

    @GetMapping(value = ApiName.CATEGORY_GET)
    public Category getCategoryById(@PathVariable("id") Long id){
        return categoryService.getCategoryById(id);
    }

    @GetMapping(value = ApiName.CATEGORY_GETALL)
    public List<Category> getAllCategory(){
        return categoryService.getAllCategory();
    }

    @PreAuthorize("hasRole('ADMIN')")
    @DeleteMapping(value = ApiName.CATEGORY_DELETE)
    public String deleteCategoryById(@PathVariable("id") Long id){
        return categoryService.deleteCategoryById(id);
    }


}
