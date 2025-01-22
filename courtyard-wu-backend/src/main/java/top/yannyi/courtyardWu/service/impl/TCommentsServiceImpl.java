package top.yannyi.courtyardWu.service.impl;


import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;
import top.yannyi.courtyardWu.dao.TCommentsDao;
import top.yannyi.courtyardWu.model.entity.TComments;
import top.yannyi.courtyardWu.service.TCommentsService;

import javax.annotation.Resource;

/**
 * 评论表：每条评论包含用户、店铺和评论内容，通过user_id和shop_id与用户表、店铺表关联。(TComments)表服务实现类
 *
 * @author anshengyo
 * @since 2025-01-20 12:26:28
 */
@Service("tCommentsService")
public class TCommentsServiceImpl extends ServiceImpl<TCommentsDao,TComments> implements TCommentsService {
    @Resource
    private TCommentsDao tCommentsDao;

}
