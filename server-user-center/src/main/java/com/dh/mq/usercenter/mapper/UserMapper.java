package com.dh.mq.usercenter.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.dh.mq.usercenter.domain.entity.User;
import org.apache.ibatis.annotations.Param;

public interface UserMapper extends BaseMapper<User> {

    User selectByName(@Param("username") String username);
}