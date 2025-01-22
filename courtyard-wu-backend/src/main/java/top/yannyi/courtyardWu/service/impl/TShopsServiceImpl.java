package top.yannyi.courtyardWu.service.impl;


import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;
import top.yannyi.courtyardWu.dao.TShopsDao;
import top.yannyi.courtyardWu.dao.TUsersDao;
import top.yannyi.courtyardWu.model.entity.TShops;
import top.yannyi.courtyardWu.model.entity.TUsers;
import top.yannyi.courtyardWu.service.TShopsService;
import top.yannyi.courtyardWu.service.TUsersService;

import javax.annotation.Resource;

/**
 * 店铺表：包含店铺信息，每个店铺由一个用户管理，用户通过owner_id字段关联。(TShops)表服务实现类
 *
 * @author anshengyo
 * @since 2025-01-20 12:26:28
 */
@Service("tShopsService")
public class TShopsServiceImpl extends ServiceImpl<TShopsDao, TShops> implements TShopsService {

    @Resource
    private TShopsDao tShopsDao;

}
