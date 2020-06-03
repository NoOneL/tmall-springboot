package com.example.tmall.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import com.example.tmall.pojo.Category;



public interface CategoryDAO extends JpaRepository<Category,Integer> {

}
