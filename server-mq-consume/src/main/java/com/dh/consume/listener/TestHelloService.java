package com.dh.consume.listener;

import lombok.extern.slf4j.Slf4j;
import org.apache.rocketmq.spring.annotation.RocketMQMessageListener;
import org.apache.rocketmq.spring.core.RocketMQListener;
import org.springframework.stereotype.Component;


/**
 * 生产者  test-topic:order
 * 消费者  在@RocketMQMessageListener 上添加 selectorExpression = "order"
 */
@Component
@RocketMQMessageListener(consumerGroup = "default-consumer-group", topic = "app-topic-ddh")
@Slf4j
public class TestHelloService implements RocketMQListener<String> {
    @Override
    public void onMessage(String msg) {
        log.error(msg);
    }
}
