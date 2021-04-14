package com.example.bct.Ecommerce.repository;

import com.example.bct.Ecommerce.entity.Product;
import com.example.bct.Ecommerce.entity.User;
import com.example.bct.Ecommerce.entity.WishList;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public interface WishListRepository extends JpaRepository<WishList,Long> {

    Object findByUserAndProduct(User user, Product product);

    List<WishList> findByUser(User user);

    String deleteAllByUserAndProduct(User user, Product product);

    ArrayList<WishList> findAllByUser(User user);

}
