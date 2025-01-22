package top.yannyi.courtyardWu.controller;


import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.ResponseEntity;
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
import top.yannyi.courtyardWu.model.entity.TShops;
import top.yannyi.courtyardWu.service.TShopsService;

import javax.annotation.Resource;
import java.util.List;

/**
 * 店铺表：包含店铺信息，每个店铺由一个用户管理，用户通过owner_id字段关联。(TShops)表控制层
 *
 * @author anshengyo
 * @since 2025-01-20 12:26:28
 */
@RestController
@RequestMapping("tShops")
public class TShopsController {
    /**
     * 服务对象
     */
    @Resource
    private TShopsService tShopsService;

    @GetMapping("{id}")
    public BaseResponse<TShops> queryById(@PathVariable("id") String id) {
        return ResultUtils.success(tShopsService.getById(id));
    }

    /**
     * 新增数据
     *
     * @param tShops 实体
     * @return 新增结果
     */
    @PostMapping
    public BaseResponse<String> add(@RequestBody TShops tShops) {
        boolean save = tShopsService.save(tShops);
        return ResultUtils.success(tShops.getId());
    }

    /**
     * 编辑数据
     *
     * @param tShops 实体
     * @return 编辑结果
     */
    @PutMapping
    public BaseResponse<Boolean> edit(@RequestBody TShops tShops) {
        return ResultUtils.success(tShopsService.updateById(tShops));
    }

    /**
     * 删除数据
     *
     * @param ids 主键
     * @return 删除是否成功
     */
    @DeleteMapping
    public BaseResponse<Boolean> deleteById(@RequestBody List<String> ids) {
        return ResultUtils.success(tShopsService.removeBatchByIds(ids));
    }

}

