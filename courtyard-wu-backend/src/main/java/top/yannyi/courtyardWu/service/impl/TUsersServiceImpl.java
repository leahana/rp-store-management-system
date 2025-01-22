package top.yannyi.courtyardWu.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import top.yannyi.courtyardWu.model.entity.TUsers;
import top.yannyi.courtyardWu.dao.TUsersDao;
import top.yannyi.courtyardWu.service.TUsersService;
import org.springframework.stereotype.Service;
import javax.annotation.Resource;

/**
 * 用户表：包含所有用户的信息，每个用户可以评论、管理店铺。(TUsers)表服务实现类
 *
 * @author anshengyo
 * @since 2025-01-20 12:22:27
 */
@Service("tUsersService")
public class TUsersServiceImpl extends ServiceImpl<TUsersDao, TUsers> implements TUsersService {
    @Resource
    private TUsersDao tUsersDao;
}
