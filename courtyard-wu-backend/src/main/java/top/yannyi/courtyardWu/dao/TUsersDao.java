package top.yannyi.courtyardWu.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import top.yannyi.courtyardWu.model.entity.TUsers;


/**
 * 用户表：包含所有用户的信息，每个用户可以评论、管理店铺。(TUsers)表数据库访问层
 *
 * @author anshengyo
 * @since 2025-01-20 12:22:26
 */
public interface TUsersDao extends BaseMapper<TUsers> {

}

