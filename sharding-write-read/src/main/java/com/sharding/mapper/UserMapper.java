package com.sharding.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.sharding.entity.User;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

@Mapper
@Repository
public interface UserMapper extends BaseMapper<User> {

    public void save(@Param("user") User user);
}
