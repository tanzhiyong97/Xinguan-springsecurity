package com.tan.system.controller;


import com.tan.handler.BusinessException;
import com.tan.response.Result;
import com.tan.response.ResultCode;
import com.tan.system.entity.TbUser;
import com.tan.system.service.TbUserService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import org.springframework.stereotype.Controller;

import java.util.List;
import java.util.Map;

/**
 * <p>
 * 用户表 前端控制器
 * </p>
 *
 * @author tan
 * @since 2020-09-01
 */
@RestController
@RequestMapping("/system/tb-user")
@Api(value = "系统用户模块", tags = "系统用户接口")
public class TbUserController {

    @Autowired
    TbUserService tbUserService;

    @GetMapping("/" +
            "" +
            "")
    @ApiOperation(value = "用户列表", notes = "查询所有的用户信息")
    public Result findUsers(){
        List<TbUser> list = tbUserService.list();
        return Result.ok().data("users", list);
    }


    @GetMapping("/{name}")
    @ApiOperation(value = "查询单个用户", notes = "通过ID查询单个用户信息")
    public Result getUserById(@PathVariable("name") String name) {
        TbUser user = tbUserService.getByName(name);
        if(user!=null){
            return Result.ok().data("user", user);
        }else{
            throw new BusinessException(ResultCode.USER_NOT_FONUD.getCode(), ResultCode.USER_NOT_FONUD.getMessage());
        }
    }
}

