package com.dh.mq.serveremail.listener;

import lombok.extern.slf4j.Slf4j;
import org.apache.rocketmq.spring.core.RocketMQListener;

/**
 * 邮箱  第三方的邮件服务（springboot自带的邮箱组件）
 * 失效的时间： redis
 *
 * 发送的内容：
 * 链接[点击激活]
 * 如果点击失效复制url地址到浏览器激活
 */


@Slf4j
public class EmailListener implements RocketMQListener<Integer> {
    @Override
    public void onMessage(Integer message) {
log.debug(message+"");
    }
}
