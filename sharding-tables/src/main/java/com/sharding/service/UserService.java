package com.sharding.service;

import com.baomidou.mybatisplus.core.toolkit.IdWorker;
import com.baomidou.mybatisplus.extension.service.IService;
import com.sharding.entity.User;
import com.sharding.mapper.UserMapper;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;

@Service
@Transactional
public class UserService {

    @Resource
    UserMapper userMapper;

    public void save() {
        for (long i = 0; i < 100; i++) {
            User user = new User();
            user.setId(IdWorker.getId());
            user.setCity("深圳");
            user.setName("李四");
            userMapper.insert(user);
        }
    }
}
