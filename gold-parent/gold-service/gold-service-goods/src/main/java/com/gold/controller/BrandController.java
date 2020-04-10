package com.gold.controller;

import com.gold.common.pojo.Result;
import com.gold.common.pojo.StatusCode;
import com.gold.entity.goods.Brand;
import com.gold.service.BrandService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;

/**
 * @Author: xu.dm
 * @Date: 2020/4/10 14:26
 * @Version: 1.0
 * @Description: TODO
 **/
@RestController
@RequestMapping("/brand")
public class BrandController {
    @Resource
    BrandService brandService;

    @GetMapping
    public Result<List<Brand>> findList(){
        List<Brand> brandList = brandService.findAll();
        return new Result<>(true, StatusCode.OK,"查询成功",brandList);
    }
}
