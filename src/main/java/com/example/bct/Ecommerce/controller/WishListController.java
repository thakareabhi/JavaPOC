package com.example.bct.Ecommerce.controller;

import com.example.bct.Ecommerce.constants.ApiName;
import com.example.bct.Ecommerce.entity.OrderHistory;
import com.example.bct.Ecommerce.entity.WishList;
import com.example.bct.Ecommerce.services.UserService;
import com.example.bct.Ecommerce.services.WishListService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.security.Principal;
import java.util.List;

import static com.example.bct.Ecommerce.constants.ApiName.COMMON;

@RestController
@RequestMapping(value = COMMON)
public class WishListController {

    @Autowired
    WishListService wishListService;

    @Autowired
    UserService userService;


    @GetMapping(ApiName.ADD_TO_CART)
    public String addToCart(@PathVariable("productId") Long productId, Principal principal) {
        wishListService.addProductToWishlist(userService.getUserId(principal), productId);
        return "\"Added Product To Cart\"";
    }

    @GetMapping(ApiName.SUBTRACT_ONE_FROM_WISHLIST)
    public String subtractProductFromWishList(@PathVariable("productId")Long productId, Principal principal) {
        wishListService.subtractProductFromWishList(userService.getUserId(principal),productId);
        return "removed one product from wishlist";
    }

    @GetMapping(ApiName.REMOVE_FROM_CART)
    public String removeFromCart(@PathVariable("productId") Long productId, Principal principal) {
        wishListService.removeProductFromWishList(userService.getUserId(principal), productId);
        return "\"Product Removed\"";
    }

    //Publically available without user login
    @GetMapping(ApiName.SHOW_CART)
    public List<WishList> showCart(Principal principal) {
        return wishListService.showUserProducts(userService.getUserId(principal));
    }

    @PreAuthorize("hasRole('USER') or hasRole('ADMIN')")
    @GetMapping(ApiName.CHECKOUT)
    public List<OrderHistory> checkOutFromCart(Principal principal) {
        return wishListService.checkout(principal);

    }
}
