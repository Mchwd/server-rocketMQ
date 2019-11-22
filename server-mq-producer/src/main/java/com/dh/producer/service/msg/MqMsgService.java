package com.dh.producer.service.msg;

import com.dh.producer.entity.Producer;
import lombok.extern.slf4j.Slf4j;
import org.apache.rocketmq.client.producer.SendCallback;
import org.apache.rocketmq.client.producer.SendResult;
import org.apache.rocketmq.spring.core.RocketMQTemplate;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
@Slf4j
public class MqMsgService {
    @Value("${rocketmq.app-topic}")
    String topic;
    @Resource
    RocketMQTemplate rocketMQTemplate;

    /**
     * 同步发送复杂的数据类型
     *
     * @param data
     */
    public void sendBaseMessage(List<Producer> data) {
        rocketMQTemplate.syncSend(topic, data);
    }


    /**
     * 发送顺序消息
     *
     * @param data
     */
    public void sendOrderlyMessage(List<Producer> data) {
        rocketMQTemplate.syncSendOrderly(topic, data, "1");
    }

    /**
     * 发送延迟消息
     *
     * @param data
     */
    public void sendDelayMessage(List<Producer> data) {
        rocketMQTemplate.syncSend(topic,MessageBuilder.withPayload(data).build(), 3000, 1);
    }

    /**
     * 发送单向的消息
     */

    public void sendOneWayMessage(List<Producer> data) {
        rocketMQTemplate.sendOneWay(topic, data);
    }

    /**
     *异步：
     * 普通
     * 顺序
     */
    public void asyncSend(String msg) {
        rocketMQTemplate.asyncSend(topic, msg, new SendCallback() {
            @Override
            public void onSuccess(SendResult sendResult) {
                log.info("发送成功");
            }
            @Override
            public void onException(Throwable throwable) {
                log.info("发送失败");
            }
        });

    }


}
