package com.sharding.controller;

import com.sharding.entity.User;
import com.sharding.service.UserService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
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

    @RequestMapping("/list")
    public List<User> list(@RequestParam("onlyRead") Boolean onlyRead) {
        return userService.list(onlyRead);
    }
}
