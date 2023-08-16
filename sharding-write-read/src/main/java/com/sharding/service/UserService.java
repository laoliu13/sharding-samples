package com.sharding.service;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.toolkit.IdWorker;
import com.sharding.entity.User;
import com.sharding.mapper.UserMapper;
import org.apache.shardingsphere.api.hint.HintManager;
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
            user.setCity("城市"+i);
            user.setName("刘"+i);
            userMapper.insert(user);
        }
    }

    public List<User> list(Boolean onlyRead) {
        if (!onlyRead) {
            HintManager.clear();
            try (HintManager hintManager = HintManager.getInstance()) {
                hintManager.setMasterRouteOnly();
            } catch (Exception e) {
                throw new RuntimeException("切换读写库异常", e);
            }
        }
        return userMapper.selectList(new QueryWrapper<>());
    }
}
