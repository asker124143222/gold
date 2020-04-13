package com.gold.controller;

import com.github.pagehelper.PageInfo;
import com.gold.common.pojo.Result;
import com.gold.common.pojo.StatusCode;
import com.gold.entity.goods.Brand;
import com.gold.service.BrandService;
import org.springframework.web.bind.annotation.*;

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

    /***
     * 根据ID查询品牌数据
     * @param id
     * @return
     */
    @GetMapping("/{id}")
    public Result<Brand> findById(@PathVariable Integer id){
        //根据ID查询
        Brand brand = brandService.findById(id);
        return new Result<Brand>(true,StatusCode.OK,"查询成功",brand);
    }

    /***
     * 新增品牌数据
     * @param brand
     * @return
     */
    @PostMapping
    public Result add(@RequestBody Brand brand){
        if(brandService.add(brand)==1)
            return new Result(true,StatusCode.OK,"添加成功");
        else
            return new Result(false,StatusCode.ERROR,"添加失败");
    }


    /***
     * 修改品牌数据
     * @param brand
     * @param id
     * @return
     */
    @PutMapping(value="/{id}")
    public Result update(@RequestBody Brand brand,@PathVariable Integer id){
        //设置ID
        brand.setId(id);
        //修改数据
        if(brandService.update(brand)==1)
            return new Result(true,StatusCode.OK,"修改成功");
        else
            return new Result(false,StatusCode.ERROR,"修改失败");
    }

    /***
     * 根据ID删除品牌数据
     * @param id
     * @return
     */
    @DeleteMapping(value = "/{id}" )
    public Result delete(@PathVariable Integer id){
        if(brandService.delete(id)==1)
            return new Result(true,StatusCode.OK,"删除成功");
        else
            return new Result(false,StatusCode.ERROR,"删除失败");
    }

    /***
     * 多条件搜索品牌数据
     * @param brand
     * @return
     */
    @PostMapping(value = "/search" )
    public Result<List<Brand>> findList(@RequestBody(required = false) Brand brand){
        List<Brand> list = brandService.findList(brand);
        return new Result<List<Brand>>(true,StatusCode.OK,"查询成功",list);
    }

    /***
     * 分页搜索实现
     * @param page:当前页
     * @param size:每页显示多少条
     * @return
     */
    @GetMapping(value = "/search/{page}/{size}" )
    public Result<PageInfo> findPage(@PathVariable  int page, @PathVariable  int size){
        //分页查询
        PageInfo<Brand> pageInfo = brandService.findPage(page, size);
        return new Result<PageInfo>(true,StatusCode.OK,"查询成功",pageInfo);
    }

    /***
     * 分页搜索实现
     * @param brand
     * @param page
     * @param size
     * @return
     */
    @PostMapping(value = "/search/{page}/{size}" )
    public Result<PageInfo> findPage(@RequestBody(required = false) Brand brand, @PathVariable  int page, @PathVariable  int size){
        //执行搜索
        PageInfo<Brand> pageInfo = brandService.findPage(brand, page, size);
        return new Result(true,StatusCode.OK,"查询成功",pageInfo);
    }
}
