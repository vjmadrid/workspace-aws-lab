package com.acme.sqs.connector.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.acme.sqs.connector.constant.models.Task;
import com.acme.sqs.connector.constant.models.Type;
import com.acme.sqs.connector.service.TaskService;

import java.util.Arrays;
import java.util.List;

/**
 * @author Ruslan Molchanov (ruslanys@gmail.com)
 */
@Controller
public class MainController {

    private final TaskService taskService;

    @Autowired
    public MainController(TaskService taskService) {
        this.taskService = taskService;
    }

    @RequestMapping({ "/", "/index.html" })
    public String index() {
        return "index";
    }

    @RequestMapping("/task")
    @ResponseBody
    public List<Task> task(@RequestParam String typeName, @RequestParam String runner, String description) {
        Type type = Type.valueOf(typeName);

        List<Task> tasks = Arrays.asList(
                new Task(type, runner, description),
                new Task(type, runner, description),
                new Task(type, runner, description)
        );

        tasks.forEach(taskService::start);

        return tasks;
    }

}
