package com.example.tmall.dao;

import com.example.tmall.pojo.Product;
import com.example.tmall.pojo.Review;
import com.sun.org.apache.regexp.internal.RE;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ReviewDAO extends JpaRepository<Review,Integer> {
    List<Review> findByProductOrderByIdDesc(Product product);
    int countByProduct(Product product);

}
