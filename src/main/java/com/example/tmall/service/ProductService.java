package com.example.tmall.service;

import com.example.tmall.dao.CategoryDAO;
import com.example.tmall.dao.ProductDAO;
import com.example.tmall.pojo.Category;
import com.example.tmall.pojo.Product;
import com.example.tmall.util.Page4Navigator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

@Service
public class ProductService{
    @Autowired
    ProductDAO productDAO;
    @Autowired
    CategoryService categoryService;

    public void add(Product bean){
        productDAO.save(bean);
    }

    public void delete(int id){
        productDAO.delete(id);
    }

    public Product get(int id){
        return productDAO.findOne(id);

    }
    public void update(Product bean){
        productDAO.save(bean);
    }

    public Page4Navigator<Product> list(int cid,int start,int size,int navigatePages){
        Category category = categoryService.get(cid);
        Sort sort = new Sort(Sort.Direction.DESC,"id");
        Pageable pageable = new PageRequest(start,size,sort);
        Page<Product> pageFromJPA = productDAO.findByCategory(category,pageable);
        return new Page4Navigator<>(pageFromJPA,navigatePages);
    }
}
