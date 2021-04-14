package com.example.bct.Ecommerce.entity;

import javax.persistence.*;

@Entity
public class WishList {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "wishlist_id")
    Long id;

    @Column(name = "quantity")
    int quantity;

    @Column(name = "price_per_unit")
    Long pricePerUnit;

    @Column(name = "product_name")
    String productName;


    @ManyToOne
    Product product;

    @ManyToOne
    User user;

    public WishList() {
    }

    public WishList(int quantity, Long pricePerUnit, String productName, Product product, User user) {
        this.quantity = quantity;
        this.pricePerUnit = pricePerUnit;
        this.productName = productName;
        this.product = product;
        this.user = user;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public Long getPricePerUnit() {
        return pricePerUnit;
    }

    public void setPricePerUnit(Long pricePerUnit) {
        this.pricePerUnit = pricePerUnit;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    @Override
    public String toString() {
        return "WishList{" +
                "id=" + id +
                ", quantity=" + quantity +
                ", pricePerUnit=" + pricePerUnit +
                ", productName='" + productName + '\'' +
                ", product=" + product +
                ", user=" + user +
                '}';
    }
}
