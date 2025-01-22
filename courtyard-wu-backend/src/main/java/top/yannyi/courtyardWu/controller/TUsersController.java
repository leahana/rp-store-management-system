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
import top.yannyi.courtyardWu.model.entity.TUsers;
import top.yannyi.courtyardWu.service.TUsersService;

import javax.annotation.Resource;
import java.util.List;

/**
 * 用户表：包含所有用户的信息，每个用户可以评论、管理店铺。(TUsers)表控制层
 *
 * @author anshengyo
 * @since 2025-01-20 12:22:25
 */
@RestController
@RequestMapping("tUsers")
public class TUsersController {
    /**
     * 服务对象
     */
    @Resource
    private TUsersService tUsersService;

    /**
     * 通过主键查询单条数据
     *
     * @param id 主键
     * @return 单条数据
     */
    @GetMapping("{id}")
    public BaseResponse<TUsers> queryById(@PathVariable("id") String id) {
        return ResultUtils.success(this.tUsersService.getById(id));
    }

    /**
     * 新增数据
     *
     * @param tUsers 实体
     * @return 新增结果
     */
    @PostMapping
    public BaseResponse<String> add(@RequestBody TUsers tUsers) {
        boolean save = this.tUsersService.save(tUsers);
        return ResultUtils.success(tUsers.getId());
    }

    /**
     * 编辑数据
     *
     * @param tUsers 实体
     * @return 编辑结果
     */
    @PutMapping
    public BaseResponse<Boolean> edit(@RequestBody TUsers tUsers) {
        return ResultUtils.success(tUsersService.updateById(tUsers));
    }

    /**
     * 删除数据
     *
     * @param ids 主键集合
     * @return 删除是否成功
     */
    @DeleteMapping
    public BaseResponse<Boolean> deleteById(@RequestBody List<String> ids) {
        return ResultUtils.success(tUsersService.removeBatchByIds(ids));
    }

}

