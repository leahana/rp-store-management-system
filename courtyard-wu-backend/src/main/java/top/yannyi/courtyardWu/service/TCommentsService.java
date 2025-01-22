package top.yannyi.courtyardWu.service;


import com.baomidou.mybatisplus.extension.service.IService;
import top.yannyi.courtyardWu.model.entity.TComments;

/**
 * 评论表：每条评论包含用户、店铺和评论内容，通过user_id和shop_id与用户表、店铺表关联。(TComments)表服务接口
 *
 * @author anshengyo
 * @since 2025-01-20 12:26:26
 */
public interface TCommentsService extends IService<TComments> {


}
