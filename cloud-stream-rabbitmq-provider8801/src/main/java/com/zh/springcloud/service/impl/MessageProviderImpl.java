package com.zh.springcloud.service.impl;

import com.zh.springcloud.service.IMessageProvider;
import lombok.extern.slf4j.Slf4j;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.messaging.Source;
import org.springframework.integration.support.MessageBuilder;
import org.springframework.messaging.MessageChannel;
import javax.annotation.Resource;
import java.util.UUID;
@Slf4j
@EnableBinding(Source.class)//定义消息的推送管道和Exchange绑定
public class MessageProviderImpl implements IMessageProvider {

    @Resource
    private MessageChannel output;

    @Override
    public boolean send() {
        String serial = UUID.randomUUID().toString();
        boolean b =  output.send(MessageBuilder.withPayload(serial).build());
        log.info("serial:"+serial);
        return b;
    }
}
