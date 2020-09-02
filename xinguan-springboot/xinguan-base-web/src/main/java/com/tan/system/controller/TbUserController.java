package com.tan.system.controller;


import com.tan.system.entity.TbUser;
import com.tan.system.service.TbUserService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

/**
 * <p>
 * 用户表 前端控制器
 * </p>
 *
 * @author tan
 * @since 2020-09-01
 */
@Controller
@RequestMapping("/system/tb-user")
@Api(value = "用户管理")
public class TbUserController {

    @Autowired
    TbUserService tbUserService;

    @GetMapping("/findUsers")
    @ResponseBody
    @ApiOperation(value = "查询所有的用户信息", notes = "")
    public List<TbUser> findUsers(){
        List<TbUser> list = tbUserService.list();
        return list;
    }
}

