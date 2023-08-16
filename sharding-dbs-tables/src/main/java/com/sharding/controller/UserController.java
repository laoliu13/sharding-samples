package com.sharding.controller;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.sharding.entity.User;
import com.sharding.service.UserService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;

@RestController
@RequestMapping("/user")
public class UserController {

    @Resource
    private UserService userService;

    @RequestMapping("/save")
    public void save() {
        userService.save();
    }

    @RequestMapping("/selectUserList")
    public IPage<User> selectUserList() {
        return userService.selectUserList();
    }

    public static void main(String[] args) {
        System.out.println(1 % 2);
        System.out.println(2 % 2);
        System.out.println(3 % 2);
    }
}
