package top.yannyi.courtyardWu.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import top.yannyi.courtyardWu.model.entity.TShops;

/**
 * 店铺表：包含店铺信息，每个店铺由一个用户管理，用户通过owner_id字段关联。(TShops)表数据库访问层
 *
 * @author anshengyo
 * @since 2025-01-20 12:26:28
 */

public interface TShopsDao extends BaseMapper<TShops> {


}

