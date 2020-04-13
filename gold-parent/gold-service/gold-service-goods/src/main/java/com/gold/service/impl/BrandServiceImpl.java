package com.gold.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.gold.dao.BrandMapper;
import com.gold.entity.goods.Brand;
import com.gold.service.BrandService;
import org.apache.commons.lang.StringUtils;
import org.springframework.stereotype.Service;
import tk.mybatis.mapper.entity.Example;

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

    @Override
    public Brand findById(Integer id) {
        return brandMapper.selectByPrimaryKey(id);
    }

    @Override
    public int add(Brand brand) {
        return brandMapper.insert(brand);
    }

    @Override
    public int update(Brand brand) {
        return brandMapper.updateByPrimaryKeySelective(brand);
    }

    @Override
    public int delete(Integer id) {
        return brandMapper.deleteByPrimaryKey(id);
    }


    /**
     * 构建查询对象
     * @param brand
     * @return
     */
    public Example createExample(Brand brand){
        Example example=new Example(Brand.class);
        Example.Criteria criteria = example.createCriteria();
        if(brand!=null){
            // 品牌名称
            if(!StringUtils.isEmpty(brand.getName())){
                criteria.andLike("name","%"+brand.getName()+"%");
            }
            // 品牌的首字母
            if(!StringUtils.isEmpty(brand.getLetter())){
                criteria.andEqualTo("letter",brand.getLetter());
            }
        }
        return example;
    }

    @Override
    public List<Brand> findList(Brand brand) {
        //构建查询条件
        Example example = createExample(brand);
        //根据构建的条件查询数据
        return brandMapper.selectByExample(example);
    }

    @Override
    public PageInfo<Brand> findPage(int page, int size) {
        PageHelper.startPage(page,size);
        return new PageInfo<>(brandMapper.selectAll());
    }

    @Override
    public PageInfo<Brand> findPage(Brand brand, int page, int size) {
        PageHelper.startPage(page,size);
        Example example = createExample(brand);
        return new PageInfo<>(brandMapper.selectByExample(example));
    }

}
