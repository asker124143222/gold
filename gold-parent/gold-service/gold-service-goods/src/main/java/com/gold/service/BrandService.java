package com.gold.service;

import com.gold.entity.goods.Brand;

import java.util.List;

/**
 * @Author: xu.dm
 * @Date: 2020/4/10 14:14
 * @Version: 1.0
 * @Description: TODO
 **/
public interface BrandService {

    /**
     * @return
     */
    List<Brand> findAll();
}
