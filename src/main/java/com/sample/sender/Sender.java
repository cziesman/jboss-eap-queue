package com.sample.sender;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Component
public class Sender {

    private static final Logger LOG = LoggerFactory.getLogger(Sender.class);

    @Autowired
    private JmsTemplate jmsTemplate;

    @Scheduled(fixedDelay = 60000L)
    public void send() {

        try {
            jmsTemplate.convertAndSend("jboss/exported/jms/queue/mailbox", "Hello");
            LOG.info("Sent message");
        } catch (Exception ex) {
            LOG.error(ex.getMessage(), ex);
        }
    }
}