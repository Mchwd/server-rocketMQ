package com.dh.mq.usercenter.domain.dto;

import com.baomidou.mybatisplus.annotation.TableField;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.Pattern;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class UserDto {

    /**
     * 用户名
     * 账号规则：必须是字母开头  +数字/字母
     * 长度有限制
     * \w表示a-zA-Z0-9_
     */
    @TableField(value = "username")
    @Pattern(regexp = "^[a-zA-Z]\\w{5,15}$")
    private String username;

    /**
     * 密码
     * 首字母必须大写   数字+字母的组合
     * 长度必须是8位
     */
    @TableField(value = "password")
    @Pattern(regexp = "^[A-Z]\\w{7,15}$")
    private String password;

    /**
     * 手机
     * 手机验证 1开头
     * 长度为11位
     * \d表示0-9
     */
    @TableField(value = "phone")
    @Pattern(regexp = "1[3-9]\\d{9}$")
    private String phone;

    /**
     * 性别 1 表示男 0 表示女
     */
    @TableField(value = "sex")
    private Boolean sex;

    /**
     * 邮箱
     * 邮箱的地址规则：数字、字母、下划线 + @ + 数字、英文 + . +英文
     */
    @TableField(value = "email")
    @Pattern(regexp = "^\\w+([-+.]\\w+)*@\\w+([-.]\\w+)*\\.\\w+([-.]\\w+)*$")
    private String email;

    /**
     * 备注
     */
    @TableField(value = "mark")
    private String mark;





}
