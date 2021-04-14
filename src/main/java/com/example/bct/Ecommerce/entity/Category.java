package com.example.bct.Ecommerce.entity;

import com.fasterxml.jackson.annotation.JsonFormat;

import javax.persistence.*;
import java.util.Date;
import java.util.Set;

@Entity
public class Category {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "category_id")
    private Long categoryId;

    @Column(name = "category_name")
    private String categoryName;

    @Column(name = "category_image")
    private String categoryImage;

    @Column(name = "category_description")
    private String categoryDescription;

    @Column(name = "created_on")
    @Temporal(TemporalType.DATE)
    @JsonFormat(pattern="yyyy-MM-dd",timezone = "Asia/Kolkata")
    private Date createdOn;

    @Column(name = "updatedon")
    @Temporal(TemporalType.DATE)
    @JsonFormat(pattern="yyyy-MM-dd" ,timezone = "Asia/Kolkata")
    private Date updatedOn;

    @Column(name = "parent_id")
    private Long parentId;

//    @OneToMany(mappedBy = "category", cascade = CascadeType.ALL)
//    @Column(name = "products_list")
//    private Set<Product> products = new HashSet<>();


    public Category() {
    }

    public Category(String categoryName, String categoryImage, String categoryDescription, Date createdOn, Date updatedOn, Long parentId, Set<Product> products) {
        this.categoryName = categoryName;
        this.categoryImage = categoryImage;
        this.categoryDescription = categoryDescription;
        this.createdOn = createdOn;
        this.updatedOn = updatedOn;
        this.parentId = parentId;
//        this.products = products;
    }

    public Long getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(Long categoryId) {
        this.categoryId = categoryId;
    }

    public String getCategoryName() {
        return categoryName;
    }

    public void setCategoryName(String categoryName) {
        this.categoryName = categoryName;
    }

    public String getCategoryImage() {
        return categoryImage;
    }

    public void setCategoryImage(String categoryImage) {
        this.categoryImage = categoryImage;
    }

    public String getCategoryDescription() {
        return categoryDescription;
    }

    public void setCategoryDescription(String categoryDescription) {
        this.categoryDescription = categoryDescription;
    }

    public Date getCreatedOn() {
        return createdOn;
    }

    public void setCreatedOn(Date createdOn) {
        this.createdOn = createdOn;
    }

    public Date getUpdatedOn() {
        return updatedOn;
    }

    public void setUpdatedOn(Date updatedOn) {
        this.updatedOn = updatedOn;
    }

    public Long getParentId() {
        return parentId;
    }

    public void setParentId(Long parentId) {
        this.parentId = parentId;
    }


//    public Set<Product> getProducts() {
//        return products;
//    }
//
//    public void setProducts(Set<Product> products) {
//        this.products = products;
//    }

    @Override
    public String toString() {
        return "Category{" +
                "categoryId=" + categoryId +
                ", categoryName='" + categoryName + '\'' +
                ", categoryImage='" + categoryImage + '\'' +
                ", categoryDescription='" + categoryDescription + '\'' +
                ", createdOn=" + createdOn +
                ", updatedOn=" + updatedOn +
                ", parentId=" + parentId +
                '}';
    }
}
