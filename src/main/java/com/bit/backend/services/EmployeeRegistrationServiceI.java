package com.bit.backend.services;

import com.bit.backend.dtos.EmployeeRegistrationDto;

import java.util.List;

public interface EmployeeRegistrationServiceI {
    EmployeeRegistrationDto addEmployeeRegistrationEntity(EmployeeRegistrationDto employeeRegistrationDto);
    List<EmployeeRegistrationDto> getData();
    EmployeeRegistrationDto updateEmployeeRegistration(long id,EmployeeRegistrationDto employeeRegistrationDto);
    EmployeeRegistrationDto deleteEmpRegForm(long id);
}
