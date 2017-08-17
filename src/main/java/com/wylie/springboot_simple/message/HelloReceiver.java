package com.wylie.springboot_simple.message;

import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Component;

import java.util.Date;

@Component
public class HelloReceiver {

	@RabbitListener(queues = "hello")
    public void process(String hello) {
        System.out.println("Receiversdfdsfdf  : " + hello);
    }

}
