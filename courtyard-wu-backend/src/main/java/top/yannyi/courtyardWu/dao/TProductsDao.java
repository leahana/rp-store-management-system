package top.yannyi.courtyardWu.dao;


import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import top.yannyi.courtyardWu.model.entity.TProducts;

/**
 * 商品表：包含每个店铺的商品信息，每个商品属于一个店铺，通过shop_id与店铺表关联。(TProducts)表数据库访问层
 *
 * @author anshengyo
 * @since 2025-01-20 12:26:28
 */
public interface TProductsDao extends BaseMapper<TProducts> {


}

