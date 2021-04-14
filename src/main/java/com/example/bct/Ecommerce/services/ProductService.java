package com.example.bct.Ecommerce.services;

import com.example.bct.Ecommerce.entity.Category;
import com.example.bct.Ecommerce.entity.Product;
import com.example.bct.Ecommerce.repository.CategoryRepository;
import com.example.bct.Ecommerce.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.*;

@Service
public class ProductService {

    @Autowired
    ProductRepository productRepository;

    @Autowired
    CategoryRepository categoryRepository;

    @Autowired
    CategoryService categoryService;

    public List<Product> getProductList() {
        return productRepository.findAll();
    }

    @Transactional
    public Product addOneProduct(Product product) {

        Date date=new Date();
//Attempt-1
//        Optional<Category> category1 = categoryRepository.findById(product.getCategory().getCategoryId());
//        if (category1==null){
//            categoryService.addCategoryViaProduct(product.getCategory());
////            String categName = category1.get().getCategoryName();
//
//        }
//        if(category1.isPresent()){
//            categoryService.addCategoryViaProduct(product.getCategory());
//        }

//        Attempt-2
//        Category category1 = new Category();
//        category1.setCategoryId(product.getCategory().getCategoryId());
//        category1.setCategoryName(product.getCategory().getCategoryName());
//        category1.setCategoryImage(product.getCategory().getCategoryImage());
//
//        categoryService.addCategoryViaProduct(category1);


//        boolean category1 = categoryService.isThereAnyCategory(product.getCategory().getCategoryName());
//        System.out.println(category1);
//        if (!category1) {
//            categoryService.addCategoryViaProduct(product.getCategory(),product.getCategory().getCategoryId());
//        }

        Optional<Category> category = categoryRepository.findById(product.getCategory().getCategoryId());
        String categName = category.get().getCategoryName();


        product.setCreatedOn(date);
        product.setUpdatedOn(date);
        product.setCategoryName(categName);
        return productRepository.save(product);
    }

    public Optional<Product> getProduct(Long id)
    {
        return productRepository.findById(id);
    }

    public List<Product> deleteProduct(Long id) {
        productRepository.deleteById(id);
        return productRepository.findAll();
    }

    public List<Product> getAllProductByCategory(String categoryName) {
        return productRepository.findAllByCategoryName(categoryName);
    }

    public List<Product> getProductsByCategoryAndPrice(String category, Long price1, Long price2) {
        return productRepository.findAllByCategoryNameAndPriceBetween(category, price1, price2);
    }

    public List<Product> getProductsByPrice(Long price1, Long price2) {
        return productRepository.findAllByPriceBetween(price1, price2);
    }

    public Set<Product> getSearchedData(String searchedItem) {
        List<Product> productsList = productRepository.findAll();
        Set<Product> result = new HashSet<>();

        for(int i=0; i<productsList.size(); i++) {
            if(productsList.get(i).getProductName().toLowerCase().contains(searchedItem.toLowerCase()) ||
                    productsList.get(i).getCategory().getCategoryName().toLowerCase().contains(searchedItem.toLowerCase()) ||
                    productsList.get(i).getManufacturerName().toLowerCase().contains(searchedItem.toLowerCase()) ||
                    productsList.get(i).getShortDescription().toLowerCase().contains(searchedItem.toLowerCase()) ||
                    productsList.get(i).getLongDescription().toLowerCase().contains(searchedItem.toLowerCase())) {

                result.add(productsList.get(i));
            }
        }
        return result;
    }



}
