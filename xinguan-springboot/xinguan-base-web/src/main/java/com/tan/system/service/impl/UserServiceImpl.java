package com.tan.system.service.impl;

import com.tan.system.entity.User;
import com.tan.system.mapper.UserMapper;
import com.tan.system.service.UserService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 用户表 服务实现类
 * </p>
 *
 * @author tan
 * @since 2020-09-04
 */
@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, User> implements UserService {

}
