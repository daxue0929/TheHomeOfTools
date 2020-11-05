package com.daxue.nacosconsumer;

import org.springframework.beans.factory.annotation.Autowired;

/**
 * 关于springboot整合elasticsearch
 * 参考博文：
 * https://blog.csdn.net/qq_35885488/article/details/93189386
 */

public class ProductService {

    @Autowired
    ProductESDAO productESDAO;


    public void update(Product bean) {

//        productESDAO.save(bean);
    }
}
