package com.bit.backend.services;

import com.bit.backend.dtos.TaskFormDto;

import java.util.List;

public interface TaskFormServiceI {
    TaskFormDto addTaskForm(TaskFormDto taskFormDto);
    List<TaskFormDto> getData();
    TaskFormDto updateTaskForm(long id,TaskFormDto taskFormDto);
    TaskFormDto DeleteTaskForm(long id);
}
