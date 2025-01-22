package top.yannyi.courtyardWu.controller;


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
import top.yannyi.courtyardWu.model.entity.TComments;
import top.yannyi.courtyardWu.service.TCommentsService;

import javax.annotation.Resource;
import java.util.List;

/**
 * 评论表：每条评论包含用户、店铺和评论内容，通过user_id和shop_id与用户表、店铺表关联。(TComments)表控制层
 *
 * @author anshengyo
 * @since 2025-01-20 12:26:11
 */
@RestController
@RequestMapping("tComments")
public class TCommentsController {
    /**
     * 服务对象
     */
    @Resource
    private TCommentsService tCommentsService;

    /**
     * 通过主键查询单条数据
     *
     * @param id 主键
     * @return 单条数据
     */
    @GetMapping("{id}")
    public BaseResponse<TComments> queryById(@PathVariable("id") String id) {
        return ResultUtils.success(tCommentsService.getById(id));
    }

    /**
     * 新增数据
     *
     * @param tComments 实体
     * @return 新增结果
     */
    @PostMapping("add")
    public BaseResponse<String> add(@RequestBody TComments tComments) {
        boolean save = tCommentsService.save(tComments);
        return ResultUtils.success(tComments.getId());
    }

    /**
     * 编辑数据
     *
     * @param tComments 实体
     * @return 编辑结果
     */
    @PutMapping("edit")
    public BaseResponse<Boolean> edit(@RequestBody TComments tComments) {
        return ResultUtils.success(tCommentsService.updateById(tComments));
    }

    /**
     * 删除数据
     *
     * @param ids 主键
     * @return 删除是否成功
     */
    @DeleteMapping("delete")
    public BaseResponse<Boolean> deleteById(@RequestBody List<String> ids) {
        return ResultUtils.success(tCommentsService.removeBatchByIds(ids));
    }
}

