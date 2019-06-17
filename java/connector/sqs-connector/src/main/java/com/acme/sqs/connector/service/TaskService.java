package com.acme.sqs.connector.service;

import com.acme.sqs.connector.Application;
import com.acme.sqs.connector.constant.models.Event;
import com.acme.sqs.connector.constant.models.Task;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.annotation.JmsListener;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

import javax.jms.JMSException;

@Service
public class TaskService {

    private final JmsTemplate jmsTemplate;
    private final ObjectMapper mapper;

    @Autowired
    public TaskService(JmsTemplate jmsTemplate, ObjectMapper mapper) {
        this.jmsTemplate = jmsTemplate;
        this.mapper = mapper;
    }

    @JmsListener(destination = Application.MANAGER_QUEUE)
    public void onMessage(String message) throws JMSException {
        log.debug("Got a message <{}>", message);
        try {
            Event event = mapper.readValue(message, Event.class);
            onMessage(event);
        } catch (Exception ex) {
            log.error("Encountered error while parsing message.",ex);
            throw new JMSException("Encountered error while parsing message.");
        }
    }

    private void onMessage(Event event) {
        log.info("Got an event: {}", event);
    }

    @Async
    @SneakyThrows
    public void start(Task task) {
        jmsTemplate.convertAndSend(Application.PROCESSOR_QUEUE, mapper.writeValueAsString(task));
    }

}
