package com.example.tmall.service;

import com.example.tmall.dao.PropertyValueDAO;
import com.example.tmall.pojo.Product;
import com.example.tmall.pojo.Property;
import com.example.tmall.pojo.PropertyValue;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheConfig;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@CacheConfig(cacheNames = "propertyValues")
public class PropertyValueService {
    @Autowired
    PropertyValueDAO propertyValueDAO;
    @Autowired PropertyService propertyService;

    public void update(PropertyValue propertyValue){
        propertyValueDAO.save(propertyValue);
    }

    public void init(Product product){
        List<Property> propertys = propertyService.listByCategory(product.getCategory());
        for(Property property :propertys){
            PropertyValue propertyValue = getByPropertyAndProduct(product,property);
            if(null == propertyValue){
                propertyValue = new PropertyValue();
                propertyValue.setProduct(product);
                propertyValue.setProperty(property);
                propertyValueDAO.save(propertyValue);
            }
        }
    }

    @Cacheable(key = "'propertyValues-one-pid-'+ #p0.id+'-ptid-' + #p1.id")
    public PropertyValue getByPropertyAndProduct(Product product,Property property){
        return propertyValueDAO.getByPropertyAndProduct(property,product);
    }

    @Cacheable(key = "'propertyValues-pid-'+#p0.id")
    public List<PropertyValue> list(Product product){
      return  propertyValueDAO.findByProductOrderByIdDesc(product);
    }
}

