package com.tan.system.controller;


import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.tan.response.Result;
import com.tan.system.entity.User;
import com.tan.system.service.UserService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.*;
import sun.awt.SunHints;

import javax.annotation.Resource;
import java.util.List;

/**
 * <p>
 * 用户表 前端控制器
 * </p>
 *
 * @author tan
 * @since 2020-09-04
 */
@RestController
@RequestMapping("/system/user")
@Api(value = "用户模块", tags = "用户管理")
public class UserController {

    @Resource
    private UserService userService;
    /**
     * 分页查询用户列表
     * @return
     */
    @ApiOperation(value = "分页查询用户")
    @GetMapping("/findUserList")
    public Result findUserList(@RequestParam(required = true, defaultValue = "1") Integer current,
                               @RequestParam(required = true, defaultValue = "10") Integer size){
        //对用户进行分页，泛型中注入的就是用户实体类
        Page<User> page = new Page<>(current, size);
        Page<User> userPage = userService.page(page);
        long total = userPage.getTotal();
        List<User> records = userPage.getRecords();
        return Result.ok().data("total", total).data("records", records);
    }

    @ApiOperation(value = "基于Rest风格的分页查询用户")
    @GetMapping("/findUserListRest/{current}/{size}")
    public Result findUserList2(@PathVariable(value = "current") Integer current,
                               @PathVariable(value = "size") Integer size){
        //对用户进行分页，泛型中注入的就是用户实体类
        Page<User> page2 = new Page<>(current, size);
        Page<User> userPage = userService.page(page2);
        long total = userPage.getTotal();
        List<User> records = userPage.getRecords();
        return Result.ok().data("total", total).data("records", records);
    }
}

