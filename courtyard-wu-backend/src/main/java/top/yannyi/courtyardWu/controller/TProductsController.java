package top.yannyi.courtyardWu.controller;


import com.baomidou.mybatisplus.extension.plugins.pagination.Page;


import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import top.yannyi.courtyardWu.model.common.BaseResponse;
import top.yannyi.courtyardWu.model.common.ResultUtils;
import top.yannyi.courtyardWu.model.dto.PageProductsDto;
import top.yannyi.courtyardWu.model.entity.TProducts;
import top.yannyi.courtyardWu.service.TProductsService;

import javax.annotation.Resource;
import java.util.List;

/**
 * 商品表：包含每个店铺的商品信息，每个商品属于一个店铺，通过shop_id与店铺表关联。(TProducts)表控制层
 *
 * @author anshengyo
 * @since 2025-01-20 12:26:28
 */
@RestController
@RequestMapping("tProducts")
public class TProductsController {

    /**
     * 服务对象
     */
    @Resource
    private TProductsService tProductsService;

    /**
     * 通过主键查询单条数据
     *
     * @param id 主键
     * @return 单条数据
     */
    @GetMapping("{id}")
    public BaseResponse<TProducts> queryById(@PathVariable("id") String id) {
        return ResultUtils.success(tProductsService.getById(id));
    }

    /**
     * 新增数据
     *
     * @param tProducts 实体
     * @return 新增结果
     */
    @PostMapping("add")
    public BaseResponse<String> add(@RequestBody TProducts tProducts) {
        boolean save = tProductsService.save(tProducts);
        return ResultUtils.success(tProducts.getId());
    }

    /**
     * 编辑数据
     *
     * @param tProducts 实体
     * @return 编辑结果
     */
    @PutMapping("edit")
    public BaseResponse<Boolean> edit(@RequestBody TProducts tProducts) {
        return ResultUtils.success(tProductsService.updateById(tProducts));
    }

    /**
     * 删除数据
     *
     * @param ids 主键
     * @return 删除是否成功
     */
    @DeleteMapping("delete")
    public BaseResponse<Boolean> deleteById(@RequestBody List<String> ids) {
        return ResultUtils.success(tProductsService.removeBatchByIds(ids));
    }

    /**
     * 商品分页查询
     *
     * @param pageProductsDto
     * @return
     */
    @PostMapping("page")
    public BaseResponse<Page<TProducts>> page(@RequestBody PageProductsDto pageProductsDto) {
        return ResultUtils.success(tProductsService.page(pageProductsDto));
    }


}

