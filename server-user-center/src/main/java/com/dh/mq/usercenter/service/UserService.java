package com.dh.mq.usercenter.service;

import com.dh.mq.usercenter.domain.dto.UserDto;
import com.dh.mq.usercenter.domain.entity.User;

public interface UserService {
    /**
     * 注册
     * @param userDto
     * @return
     */
    UserDto register(UserDto userDto);
     User findUserByName(String username);
}
