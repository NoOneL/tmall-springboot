package com.example.tmall.comparator;

import com.example.tmall.pojo.Product;

import java.util.Comparator;

public class ProductReviewComparator implements Comparator<Product> {
    //人气比较器，把评价数量高的放前面
    @Override
    public int compare(Product p1,Product p2){
        return p2.getReviewCount() - p1.getReviewCount();
    }
}
