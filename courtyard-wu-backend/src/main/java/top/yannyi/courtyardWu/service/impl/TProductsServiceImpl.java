package top.yannyi.courtyardWu.service.impl;


import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;
import top.yannyi.courtyardWu.dao.TProductsDao;
import top.yannyi.courtyardWu.model.dto.PageProductsDto;
import top.yannyi.courtyardWu.model.entity.TProducts;
import top.yannyi.courtyardWu.service.TProductsService;

import javax.annotation.Resource;


/**
 * 商品表：包含每个店铺的商品信息，每个商品属于一个店铺，通过shop_id与店铺表关联。(TProducts)表服务实现类
 *
 * @author anshengyo
 * @since 2025-01-20 12:26:28
 */
@Service("tProductsService")
public class TProductsServiceImpl extends ServiceImpl<TProductsDao, TProducts> implements TProductsService {
    @Resource
    private TProductsDao tProductsDao;

    @Override
    public Page<TProducts> page(PageProductsDto pageProductsDto) {
        TProducts tProducts = new TProducts();
        int current = pageProductsDto.getCurrent();
        int pageSize = pageProductsDto.getPageSize();
        QueryWrapper<TProducts> queryWrapper = new QueryWrapper<>();
        Page<TProducts> pageResult = new Page<>(current, pageSize);
        this.page(pageResult, queryWrapper);
        return pageResult;

    }
}


