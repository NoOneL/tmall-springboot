package com.example.tmall.dao;

import com.example.tmall.pojo.Category;
import com.example.tmall.pojo.Product;
import com.example.tmall.pojo.Property;
import com.example.tmall.pojo.PropertyValue;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface PropertyValueDAO extends JpaRepository<PropertyValue,Integer> {

//    Page<Property> findByCategory(Category category, Pageable pageable);
//    List<Property> findByCategory(Category category);

    PropertyValue getByPropertyAndProduct(Property property, Product product);


    List<PropertyValue> findByProductOrderByIdDesc(Product product);
}
