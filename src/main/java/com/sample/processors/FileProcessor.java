package com.sample.processors;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.TextMessage;

@Component
public class FileProcessor implements MessageProcessor {

    private static final Logger LOG = LoggerFactory.getLogger(FileProcessor.class);

    @Override
    public boolean process(Message message) throws JMSException {

        LOG.info("=====>" + ((TextMessage) message).getText());

        return true;
    }
}
