package com.example.sqlex1.controllers;

import com.example.sqlex1.service.TaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "api/v1/task")
public class TaskController {
    @Autowired
    TaskService taskService;
    @GetMapping("/exec/{task_num}")
    public Object execute(@PathVariable String task_num) {
        return taskService.execute(task_num);
    }

}
