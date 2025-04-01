package com.bit.backend.mappers;


import com.bit.backend.dtos.TaskFormDto;
import com.bit.backend.entities.TaskFormEntity;
import org.mapstruct.Builder;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring", builder = @Builder(disableBuilder = true))
public interface TaskFormMapper {

    TaskFormDto toTaskFormDto(TaskFormEntity taskFormEntity);
    TaskFormEntity toTaskFormEntity(TaskFormDto taskFormDto);
    List<TaskFormDto> toTaskFormDtoList(List<TaskFormEntity> taskFormEntityList);
}
