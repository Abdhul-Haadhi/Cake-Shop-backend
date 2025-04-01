package com.bit.backend.controllers;


import com.bit.backend.dtos.TaskFormDto;
import com.bit.backend.entities.TaskFormEntity;
import com.bit.backend.exceptions.AppException;
import com.bit.backend.services.TaskFormServiceI;
import com.bit.backend.services.impl.TaskFormService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.util.Date;
import java.util.List;

@RestController
public class TaskFormController {

    private final TaskFormServiceI taskFormServiceI;

    public TaskFormController(TaskFormServiceI taskFormServiceI) {
        this.taskFormServiceI = taskFormServiceI;
    }

    @PostMapping("/form-task")
    public ResponseEntity<TaskFormDto> addTaskForm(@RequestBody TaskFormDto taskFormDto) {

        try {
            TaskFormDto taskFormDtoResponse = taskFormServiceI.addTaskForm(taskFormDto);
            return ResponseEntity.created(URI.create("/form-task"+taskFormDtoResponse.getId())).body(taskFormDtoResponse);
        }
        catch (Exception e){
            throw new AppException("Request failed with error: " + e, HttpStatus.INTERNAL_SERVER_ERROR);
        }


    }

    @GetMapping("/form-task")
    public ResponseEntity<List<TaskFormDto>> getData(){

        try {
            List<TaskFormDto> taskFormDtoList = taskFormServiceI.getData();
            return ResponseEntity.ok(taskFormDtoList);
        }
        catch (Exception e){
            throw new AppException("Request failed with error: " + e, HttpStatus.INTERNAL_SERVER_ERROR);
        }


    }

    @PutMapping("/form-task/{id}")
    public ResponseEntity<TaskFormDto> updateTaskForm(@PathVariable long id, @RequestBody TaskFormDto taskFormDto) {

        try {
            TaskFormDto responseTaskFormDto = taskFormServiceI.updateTaskForm(id,taskFormDto);
            return ResponseEntity.ok(responseTaskFormDto);
        }
        catch (Exception e){
            throw new AppException("Request failed with error: " + e, HttpStatus.INTERNAL_SERVER_ERROR);
        }

    }

    @DeleteMapping("/form-task/{id}")
    public ResponseEntity<TaskFormDto> deleteTaskForm(@PathVariable long id) {

        try {
            TaskFormDto taskFormDto = taskFormServiceI.DeleteTaskForm(id);
            return ResponseEntity.ok(taskFormDto);
        }
        catch (Exception e){
            throw new AppException("Request failed with error: " + e, HttpStatus.INTERNAL_SERVER_ERROR);
        }

    }
}
