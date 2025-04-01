package com.bit.backend.services.impl;

import com.bit.backend.dtos.TaskFormDto;
import com.bit.backend.entities.TaskFormEntity;
import com.bit.backend.exceptions.AppException;
import com.bit.backend.mappers.TaskFormMapper;
import com.bit.backend.repositories.TaskFormRepository;
import com.bit.backend.services.TaskFormServiceI;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;


@Service
public class TaskFormService implements TaskFormServiceI {
    private final TaskFormRepository taskFormRepository;
    private final TaskFormMapper taskFormMapper;

    public TaskFormService(TaskFormRepository taskFormRepository, TaskFormMapper taskFormMapper) {
        this.taskFormRepository = taskFormRepository;
        this.taskFormMapper = taskFormMapper;
    }

    @Override
    public TaskFormDto addTaskForm(TaskFormDto taskFormDto) {

        try {
            System.out.println("Back End");

            TaskFormEntity taskFormEntity = taskFormMapper.toTaskFormEntity(taskFormDto);

            TaskFormEntity savedItem = taskFormRepository.save(taskFormEntity);
            TaskFormDto savedDto = taskFormMapper.toTaskFormDto(savedItem);
            return savedDto;
        }
        catch (Exception e){
            throw new AppException("Request failed with error " + e, HttpStatus.INTERNAL_SERVER_ERROR);
        }

    }

    @Override
    public List<TaskFormDto> getData() {

        try {
            List<TaskFormEntity> taskFormEntityList = taskFormRepository.findAll();
            List<TaskFormDto> taskFormDtoList = taskFormMapper.toTaskFormDtoList(taskFormEntityList);
            return taskFormDtoList;
        }
        catch (Exception e){
            throw new AppException("Request failed with error " + e, HttpStatus.INTERNAL_SERVER_ERROR);
        }

    }

    @Override
    public TaskFormDto updateTaskForm(long id, TaskFormDto taskFormDto) {

        try {
            Optional<TaskFormEntity> optionalTaskFormEntity = taskFormRepository.findById(id);
            if (!optionalTaskFormEntity.isPresent()){
                throw new AppException("Task form does not exist", HttpStatus.BAD_REQUEST);
            }
            TaskFormEntity newTaskFormEntity = taskFormMapper.toTaskFormEntity(taskFormDto);
            newTaskFormEntity.setId(id);

            TaskFormEntity taskFormEntity = taskFormRepository.save(newTaskFormEntity);
            TaskFormDto responseTaskFormDto = taskFormMapper.toTaskFormDto(taskFormEntity);
            return responseTaskFormDto;
        }
        catch (Exception e){
            throw new AppException("Request failed with error " + e, HttpStatus.INTERNAL_SERVER_ERROR);
        }


    }


    @Override
    public TaskFormDto DeleteTaskForm(long id) {

        try {
            Optional<TaskFormEntity> optionalTaskFormEntity = taskFormRepository.findById(id);
            if (!optionalTaskFormEntity.isPresent()){
                throw new AppException("Task form does not exist", HttpStatus.BAD_REQUEST);
            }
            taskFormRepository.deleteById(id);

            return taskFormMapper.toTaskFormDto(optionalTaskFormEntity.get());
        }
        catch (Exception e){
            throw new AppException("Request failed with error " + e, HttpStatus.INTERNAL_SERVER_ERROR);
        }

    }

}
