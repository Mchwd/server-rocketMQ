package com.dh.mq.usercenter.controller;

import com.dh.mq.usercenter.domain.dto.UserDto;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@RestController
@RequestMapping("/user")
public class UserController  extends BaseController{


    @Resource


    /**
     * 对数据进行校验
     *@Validated 对Dto进行数据校验
     * @param userDto
     * @return
     */

    @PostMapping("/register")
    public String register(@Validated @RequestBody UserDto userDto) {
        return "";
    }


    @RequestMapping("/verify")
    public String isExist(String username){

        return "";
    }


    /**
     * 激活账号
     *
     * 激活码过期时间？redis
     * /api/v2/activekey
     * tooken:id
     *
     * @return
     */
    @RequestMapping("/activationAccount")
    public  String activationAccount(String tooken){
       //从redis中获取tooken的key,获取value用户的id
        return null;
    }
}
