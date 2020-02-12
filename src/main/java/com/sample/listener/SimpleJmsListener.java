package com.sample.listener;

import com.sample.processors.MessageProcessor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.jms.annotation.JmsListener;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import javax.jms.JMSException;
import javax.jms.Message;
import java.util.List;

@Component
public class SimpleJmsListener {

    private static final Logger LOG = LoggerFactory.getLogger(SimpleJmsListener.class);

    @Resource
    public List<MessageProcessor> messageProcessors;

    @JmsListener(destination = "mailbox")
    public void processOrder(Message message) {

        for (MessageProcessor messageProcessor : messageProcessors) {
            try {
                messageProcessor.process(message);
            } catch (JMSException e) {
                LOG.error("Error is processing the message", e);
            }
        }
    }

}
