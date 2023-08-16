package com.sharding.service;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.core.toolkit.IdWorker;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.sharding.entity.User;
import com.sharding.mapper.UserMapper;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;

@Service
@Transactional
public class UserService {

    @Resource
    UserMapper userMapper;

    public void save() {
        for (long i = 0; i < 100; i++) {
            User user = new User();
            user.setId(IdWorker.getId());
            user.setCity("深圳"+i);
            user.setName("李四"+i);
            userMapper.insert(user);
        }
    }

    public IPage<User> selectUserList() {
        Page<User> page = new Page<>(1, 2);
        IPage<User> userIPage = userMapper.selectPage(page, new QueryWrapper<User>());
        return userIPage;
    }
}
