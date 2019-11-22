package com.dh.mq.usercenter.message;

import lombok.extern.slf4j.Slf4j;
import org.apache.rocketmq.client.producer.SendCallback;
import org.apache.rocketmq.client.producer.SendResult;
import org.apache.rocketmq.spring.core.RocketMQTemplate;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
@Slf4j
public class MqEmailSender {

    @Value("${rocketmq.user-topic}")
    private String userTopic;
    @Value("${rocketmq.user-topic-register}")
    private String UserTopicRegister;
    @Resource
    RocketMQTemplate rocketMQTemplate;

    public void sendRegisterMsg(int uid) {
        rocketMQTemplate.asyncSend("userTopic", uid, new SendCallback() {
            @Override
            public void onSuccess(SendResult sendResult) {
                log.debug("发送成功");
            }

            @Override
            public void onException(Throwable throwable) {
                log.debug("发送失败");
            }
        });

    }

}
