package com.acme.sqs.common.processor;

import com.acme.sqs.common.config.SQSCommonSpringConfig;
import com.acme.sqs.common.entity.CustomEvent;
import com.acme.sqs.common.entity.CustomTask;
import com.acme.sqs.common.enumerate.CustomEventStatusEnum;
import com.acme.sqs.common.factory.CustomEventDataFactory;
import com.acme.sqs.connector.Application;
import com.fasterxml.jackson.databind.ObjectMapper;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.annotation.JmsListener;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.stereotype.Component;

import javax.jms.JMSException;
import java.io.IOException;
import java.util.Random;


@Component
public class TaskProcessor {
	
	private static final Logger LOG = LoggerFactory.getLogger(TaskProcessor.class);

    private final JmsTemplate jmsTemplate;
    private final ObjectMapper mapper;

    @Autowired
    public TaskProcessor(JmsTemplate jmsTemplate, ObjectMapper mapper) {
        this.jmsTemplate = jmsTemplate;
        this.mapper = mapper;
    }

    @JmsListener(destination = Application.PROCESSOR_QUEUE)
    public void onMessage(String message) throws JMSException {
        LOG.debug("Got a message <{}>", message);
        try {
            CustomTask task = mapper.readValue(message, CustomTask.class);
            onMessage(task);
        } catch (IOException ex) {
            log.error("Encountered error while parsing message.", ex);
            throw new JMSException("Encountered error while parsing message.");
        }
    }

    @SneakyThrows
    private void onMessage(CustomTask task) {
    	LOG.info("Got a task: {}", task);

        // task started notification
    	CustomEvent startEvent = CustomEventDataFactory.create(task.getId(), task.getType(), CustomEventStatusEnum.STARTED);
        sendEvent(startEvent);

        // emulate task processing
        Thread.sleep(10_000);

        // task finished notification
        CustomEventStatusEnum statusEndEvent = random.nextInt(2) == 1 ? Event.Status.SUCCESSFUL : Event.Status.FAILED; 
        CustomEvent endEvent = CustomEventDataFactory.create(task.getId(), task.getType(), statusEndEvent);
        sendEvent(endEvent);
    }

    @SneakyThrows
    private void sendEvent(CustomEvent event) {
        jmsTemplate.convertAndSend(Application.MANAGER_QUEUE, mapper.writeValueAsString(event));
    }

}
