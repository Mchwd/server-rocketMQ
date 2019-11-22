package com.dh.mq.usercenter.service.impl;

import com.dh.mq.usercenter.domain.dto.UserDto;
import com.dh.mq.usercenter.domain.entity.User;
import com.dh.mq.usercenter.mapper.UserMapper;
import com.dh.mq.usercenter.message.MqEmailSender;
import com.dh.mq.usercenter.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * @author Administrator
 */
@Service
@Slf4j
public class UserServiceImpl implements UserService {

    @Resource
    UserMapper userMapper;

    @Resource
    MqEmailSender mqEmailSender;

    /**
     * @param username
     * @return
     */
    @Override
    public User findUserByName(String username) {
        return userMapper.selectByName(username);
    }

    /**
     * 判断用户是否存在
     * 邮箱验证
     * @param userDto
     * @return
     */
    @Override
    public UserDto register(UserDto userDto) {

        User user = findUserByName(userDto.getUsername());
        if (user == null) {
            user=new User();
            BeanUtils.copyProperties(userDto,user);
            int row = userMapper.insert(user);
            if (row==1){
                mqEmailSender.sendRegisterMsg(user.getUid());
            }
        } else {
            log.info("账号已经被注册");
        }
        return null;
    }
}
