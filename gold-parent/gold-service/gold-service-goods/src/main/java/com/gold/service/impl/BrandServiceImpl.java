package com.gold.service.impl;

import com.gold.dao.BrandMapper;
import com.gold.entity.goods.Brand;
import com.gold.service.BrandService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * @Author: xu.dm
 * @Date: 2020/4/10 14:16
 * @Version: 1.0
 * @Description: TODO
 **/
@Service
public class BrandServiceImpl implements BrandService {

    @Resource
    BrandMapper brandMapper;

    @Override
    public List<Brand> findAll() {
        return brandMapper.selectAll();
    }
}
