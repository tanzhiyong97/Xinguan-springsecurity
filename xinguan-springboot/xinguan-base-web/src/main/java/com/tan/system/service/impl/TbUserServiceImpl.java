package com.tan.system.service.impl;

import com.tan.system.entity.TbUser;
import com.tan.system.mapper.TbUserMapper;
import com.tan.system.service.TbUserService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 用户表 服务实现类
 * </p>
 *
 * @author tan
 * @since 2020-09-01
 */
@Service
public class TbUserServiceImpl extends ServiceImpl<TbUserMapper, TbUser> implements TbUserService {

    @Autowired
    TbUserMapper tbUserMapper;
    @Override
    public TbUser getByName(String name) {
        return tbUserMapper.getByName(name);
    }
}
