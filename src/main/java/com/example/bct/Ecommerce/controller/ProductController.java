package com.example.bct.Ecommerce.controller;

import com.example.bct.Ecommerce.constants.ApiName;
import com.example.bct.Ecommerce.entity.Product;
import com.example.bct.Ecommerce.services.CategoryService;
import com.example.bct.Ecommerce.services.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
import java.util.Set;

import static com.example.bct.Ecommerce.constants.ApiName.COMMON;

@RestController
@RequestMapping(value = COMMON)
public class ProductController {

    @Autowired
    ProductService productService;

    @Autowired
    CategoryService categoryService;

    @PreAuthorize("hasRole('ADMIN')")
    @PostMapping(value = ApiName.PRODUCT_ADD)
    public Product addProduct(@RequestBody Product product){
        return productService.addOneProduct(product);
    }

    @GetMapping(value = ApiName.PRODUCT_GETALL)
    public List<Product> getAllProduct() {
        return productService.getProductList();
    }

    @GetMapping(value = ApiName.PRODUCT_GET)
    public Optional<Product> getProductById(@PathVariable("id") Long id) {

        return productService.getProduct(id);
    }

    @PreAuthorize("hasRole('ADMIN')")
    @DeleteMapping(value = ApiName.PRODUCT_DELETE)
    public List<Product> deleteProductById(@PathVariable("id") Long id) {

        return productService.deleteProduct(id);
    }

    @GetMapping(value = ApiName.PRODUCT_GETALLBYCATEG)
    public List<Product> getProductByCateg(@PathVariable("categoryName") String categoryName) {

        return productService.getAllProductByCategory(categoryName);
    }

    @GetMapping(value = ApiName.PRODUCT_GET_ALL_BY_CATEG_AND_PRICE)
    public List<Product> getProductByCategAndPrice(@PathVariable(value = "categoryName")String categoryName,
                                                   @PathVariable(value = "price1")Long price1,
                                                   @PathVariable(value = "price2")Long price2) {

        return productService.getProductsByCategoryAndPrice(categoryName,price1,price2);
    }

    @GetMapping(value = ApiName.PRODUCT_GET_ALL_BY_PRICE)
    public List<Product> getProductByPrice(@PathVariable(value = "price1")Long price1,@PathVariable(value = "price2")Long price2) {

        return productService.getProductsByPrice(price1,price2);
    }

    @GetMapping(ApiName.SEARCH_PRODUCT)
    public Set<Product> searchItem(@PathVariable("searchedItem") String searchedItem) {
        Set<Product> prod = productService.getSearchedData(searchedItem);
        for (int i = 0; i < prod.size(); i++) {
            System.out.println(prod);
        }
        return prod;
    }

}
