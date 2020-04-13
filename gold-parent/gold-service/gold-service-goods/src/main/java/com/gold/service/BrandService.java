package com.gold.service;

import com.github.pagehelper.PageInfo;
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
     * 品牌列表查询
     */
    List<Brand> findAll();

    /**
     * 根据ID查询
     * @param id
     * @return
     */
    Brand findById(Integer id);


    /***
     * 新增品牌
     * @param brand
     */
    int add(Brand brand);

    /**
     *
     * @param brand
     * @return 修改记录数
     */
    int update(Brand brand);

    /***
     * 删除品牌
     * @param id
     */
    int delete(Integer id);

    /***
     * 多条件搜索品牌方法
     * @param brand
     * @return
     */
    List<Brand> findList(Brand brand);

    /***
     * 分页查询
     * @param page
     * @param size
     * @return
     */
    PageInfo<Brand> findPage(int page, int size);

    /***
     * 多条件分页查询
     * @param brand
     * @param page
     * @param size
     * @return
     */
    PageInfo<Brand> findPage(Brand brand, int page, int size);
}
