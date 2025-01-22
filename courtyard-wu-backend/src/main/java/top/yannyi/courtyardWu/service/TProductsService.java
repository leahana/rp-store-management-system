package top.yannyi.courtyardWu.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.IService;
import top.yannyi.courtyardWu.model.dto.PageProductsDto;
import top.yannyi.courtyardWu.model.entity.TProducts;
import top.yannyi.courtyardWu.model.vo.PageProductsVo;

import java.util.List;

/**
 * 商品表：包含每个店铺的商品信息，每个商品属于一个店铺，通过shop_id与店铺表关联。(TProducts)表服务接口
 *
 * @author anshengyo
 * @since 2025-01-20 12:26:28
 */
public interface TProductsService extends IService<TProducts> {
    Page<TProducts> page(PageProductsDto pageProductsDto);
}
