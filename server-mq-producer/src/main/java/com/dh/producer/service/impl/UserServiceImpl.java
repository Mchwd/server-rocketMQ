package com.dh.producer.service.impl;

import com.dh.producer.service.msg.MqMsgService;
import com.dh.producer.service.msg.UserService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
@Service
public class UserServiceImpl implements UserService {

    @Resource
    MqMsgService mqMsgService;

    public  String register(String username,String password){
        mqMsgService.asyncSend("发送邮件");

        return "";
    }
}
