package com.example.tmall.comparator;

import com.example.tmall.pojo.Product;

import java.util.Comparator;

public class ProductDateComparator implements Comparator<Product> {
    //新品比较器，把创建日期晚的放前面
    @Override
    public int compare(Product p1,Product p2){
        return p1.getCreateDate().compareTo(p2.getCreateDate());
    }
}
