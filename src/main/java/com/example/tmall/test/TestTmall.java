package com.example.tmall.test;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class TestTmall {
    public static void main(String args[]){
        //准备分类测试数据
        try {
            Class.forName("com.mysql.jdbc.Driver");
        }catch (ClassNotFoundException e){
            e.printStackTrace();
        }

        try (
            Connection c = DriverManager.getConnection("jdbc:mysql://localhost:3306/tmall_springboot?useUnicode=true&characterEncoding=utf8",
                    "root","admin");
            Statement s = c.createStatement();
        ){
            for(int i = 0; i <=10; i++){
                String sqlForment = "insert into category values (null,'测试分类%d')";
                String sql = String .format(sqlForment,i);
                s.execute(sql);
            }
            System.out.println("已经创建10条分类测试数据");
        } catch (SQLException e){
            e.printStackTrace();
        }
    }
}
