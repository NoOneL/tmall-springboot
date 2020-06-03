package com.example.tmall.service;

import com.example.tmall.dao.PropertyDAO;
import com.example.tmall.pojo.Category;
import com.example.tmall.pojo.Property;
import com.example.tmall.util.Page4Navigator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import javax.persistence.Id;

@Service
public class PropertyService {
    @Autowired CategoryService categoryService;
    @Autowired
    PropertyDAO propertyDAO;

    public void add(Property bean){
        propertyDAO.save(bean);
    }

    public void delete(int id){
        propertyDAO.delete(id);
    }

    public Property get(int id){
        return propertyDAO.findOne(id);
    }

    public void update(Property bean){
        propertyDAO.save(bean);
    }

    /*
    * 分页
    * */
    public Page4Navigator<Property> list(int cid, int start, int size, int navigatePages){
        Category category = categoryService.get(cid);
        Sort sort = new Sort(Sort.Direction.DESC,"id");
        Pageable pageable = new PageRequest(start,size,sort);
        Page<Property> pageFromJPA = propertyDAO.findByCategory(category,pageable);

        return new Page4Navigator<>(pageFromJPA,navigatePages);
    }
}
