package com.example.bct.Ecommerce.constants;

public class ApiName {
    public static final String COMMON = "/api/v1/";

    public static final String CATEGORY_ADD = "category/add";
    public static final String CATEGORY_GET = "category/{id}";
    public static final String CATEGORY_GETALL = "category";
    public static final String CATEGORY_DELETE = "category/delete/{id}";


    public static final String PRODUCT_ADD = "product/add";
    public static final String PRODUCT_GETALL = "product";
    public static final String PRODUCT_GET = "product/{id}";
    public static final String PRODUCT_DELETE = "product/delete/{id}";
    public static final String PRODUCT_GETALLBYCATEG = "product/category/{categoryName}";
    public static final String PRODUCT_GET_ALL_BY_CATEG_AND_PRICE = "product/category/{categoryName}/{price1}/{price2}";
    public static final String PRODUCT_GET_ALL_BY_PRICE = "product/category/{price1}/{price2}";
    public static final String SEARCH_PRODUCT = "/product/search/{searchedItem}";

    public static final String USER_ADD = "user/add";
    public static final String USER_GET = "user/{id}";
    public static final String USER_DELETE = "user/delete/{id}";
    public static final String USER_GETAll = "user/all";

    public static final String ADD_TO_CART = "addToWishList/{productId}";
    public static final String SUBTRACT_ONE_FROM_WISHLIST = "removeOneFromWishlist/{productId}";
    public static final String  REMOVE_FROM_CART = "removeFromCart/{productId}";
    public static final String  SHOW_CART = "/showCart";
    public static final String  CHECKOUT = "/checkout";
}
