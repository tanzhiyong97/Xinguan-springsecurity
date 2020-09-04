package com.tan.system.service;

import com.tan.system.entity.TbUser;
import com.baomidou.mybatisplus.extension.service.IService;

/**
 * <p>
 * 用户表 服务类
 * </p>
 *
 * @author tan
 * @since 2020-09-01
 */
public interface TbUserService extends IService<TbUser> {
    TbUser getByName(String name);
}
