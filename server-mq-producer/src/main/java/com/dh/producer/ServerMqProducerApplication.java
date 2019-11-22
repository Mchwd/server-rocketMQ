package com.dh.producer;

import org.apache.rocketmq.spring.core.RocketMQTemplate;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import javax.annotation.Resource;

@SpringBootApplication
public class ServerMqProducerApplication implements CommandLineRunner {

    @Resource
    private RocketMQTemplate rocketMQTemplate;
    @Value("${rocketmq.app-topic}")
    private String default_topic;

    public static void main(String[] args) {
        SpringApplication.run(ServerMqProducerApplication.class, args);
    }

    /**
     * 同步消息
     * 异步消息
     *
     * @param args
     * @throws Exception
     */
    @Override
    public void run(String... args) throws Exception {
        /**
         * String destination, 目的地  主题 topic
         * Message<?> message, 消息体
         * long timeout, 发送超时的时间
         * int delayLevel  延迟等级 有1-18个等级   1：表示1秒 ，2：表示5秒
         */
        for (int i = 0; i < 200; i++) {
            rocketMQTemplate.syncSend(default_topic, "妖精"+i+"号,贫道收了你", 3000);
        }
    }



}
