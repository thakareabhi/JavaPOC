package com.example.bct.Ecommerce.entity;

import com.fasterxml.jackson.annotation.JsonFormat;

import javax.persistence.*;
import java.util.Date;

@Entity
public class OrderHistory {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "order_id")
    private Long orderId;

    @Column(name = "product_id")
    private Long productId;

    @Column(name = "product_name")
    private String productName;

    @Column(name = "order_date")
    @Temporal(TemporalType.DATE)
    @JsonFormat(pattern="yyyy-MM-dd" , timezone = "Asia/Kolkata")
    private Date orderDate;

    @Column(name = "user_id")
    private Long userId;

    @Column(name = "product_price")
    private Long productPrice;

    @Column(name = "is_delivered")
    boolean isDelivered;

    @Column(name = "prod_image")
    private String image;

    @Column(name = "prod_quant")
    private int productQuantity;

    public OrderHistory() {
    }

    public OrderHistory(Long productId, String productName, Date orderDate, Long userId, Long productPrice, boolean isDelivered, String image, int productQuantity) {
        this.productId = productId;
        this.productName = productName;
        this.orderDate = orderDate;
        this.userId = userId;
        this.productPrice = productPrice;
        this.isDelivered = isDelivered;
        this.image = image;
        this.productQuantity = productQuantity;
    }

    public Long getOrderId() {
        return orderId;
    }

    public void setOrderId(Long orderId) {
        this.orderId = orderId;
    }

    public Long getProductId() {
        return productId;
    }

    public void setProductId(Long productId) {
        this.productId = productId;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public Date getOrderDate() {
        return orderDate;
    }

    public void setOrderDate(Date orderDate) {
        this.orderDate = orderDate;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public Long getProductPrice() {
        return productPrice;
    }

    public void setProductPrice(Long productPrice) {
        this.productPrice = productPrice;
    }

    public boolean getIsDelivered() {
        return isDelivered;
    }

    public void setIsDelivered(boolean isDelivered) {
        this.isDelivered = isDelivered;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public int getProductQuantity() {
        return productQuantity;
    }

    public void setProductQuantity(int productQuantity) {
        this.productQuantity = productQuantity;
    }
}
