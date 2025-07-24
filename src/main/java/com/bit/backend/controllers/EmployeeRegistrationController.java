package com.bit.backend.controllers;

import com.bit.backend.dtos.CustomerRegistrationDto;
import com.bit.backend.dtos.EmployeeRegistrationDto;
import com.bit.backend.dtos.SignUpDto;
import com.bit.backend.dtos.UserDto;
import com.bit.backend.exceptions.AppException;
import com.bit.backend.services.EmployeeRegistrationServiceI;
import com.bit.backend.services.UserServiceI;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.util.List;

@RestController
public class EmployeeRegistrationController {
    private final EmployeeRegistrationServiceI employeeRegistrationServiceI;
    private final UserServiceI userServiceI;

    public EmployeeRegistrationController(EmployeeRegistrationServiceI employeeRegistrationServiceI, UserServiceI userServiceI) {
        this.employeeRegistrationServiceI = employeeRegistrationServiceI;
        this.userServiceI = userServiceI;
    }

    @PostMapping("/employee-registration")

    public ResponseEntity<EmployeeRegistrationDto> addForm(@RequestBody EmployeeRegistrationDto employeeRegistrationDto) {

        try {
            EmployeeRegistrationDto employeeRegistrationDtoResponse = employeeRegistrationServiceI.addEmployeeRegistrationEntity(employeeRegistrationDto);
            return ResponseEntity.created(URI.create("/employee-registration"+employeeRegistrationDtoResponse.getId())).body(employeeRegistrationDtoResponse);
        }
        catch (Exception e) {
            throw new AppException("Request failed with error: " + e, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/employee-registration")

    public ResponseEntity<List<EmployeeRegistrationDto>> getData(){

        try {
            List<EmployeeRegistrationDto> employeeRegistrationDtoList = employeeRegistrationServiceI.getData();
            return ResponseEntity.ok(employeeRegistrationDtoList);
        }
        catch (Exception e) {
            throw new AppException("Request failed with error: " + e, HttpStatus.INTERNAL_SERVER_ERROR);
        }


    }

    @PutMapping("/employee-registration/{id}")

    public ResponseEntity<EmployeeRegistrationDto> updateEmpRegForm(@PathVariable Long id, @RequestBody EmployeeRegistrationDto employeeRegistrationDto) {

        try {
            EmployeeRegistrationDto responseEmployeeRegistrationDto = employeeRegistrationServiceI.updateEmployeeRegistration(id,employeeRegistrationDto);
            return ResponseEntity.ok(responseEmployeeRegistrationDto);
        }
        catch (Exception e) {
            throw new AppException("Request failed with error: " + e, HttpStatus.INTERNAL_SERVER_ERROR);
        }

    }

    @DeleteMapping("/employee-registration/{id}")

    public  ResponseEntity<EmployeeRegistrationDto> deleteEmpRegForm(@PathVariable Long id) {

        try {
            EmployeeRegistrationDto employeeRegistrationDto = employeeRegistrationServiceI.deleteEmpRegForm(id);
            return ResponseEntity.ok(employeeRegistrationDto);
        }
        catch (Exception e) {
            throw new AppException("Request failed with error: " + e, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PostMapping("/create-employee-login")
    public ResponseEntity<UserDto> register(@RequestBody SignUpDto signUpDto) throws Exception {
        UserDto user = userServiceI.register(signUpDto);
        return ResponseEntity.created(URI.create("/create-employee-login/" + user.getId())).body(user);
    }

    @PutMapping("/update-employee-login-details/{id}")
        public ResponseEntity<UserDto> updateLoginDetails(@PathVariable Long id, @RequestBody SignUpDto signUpDto) throws Exception {
        UserDto user = userServiceI.updateLoginDetails(id, signUpDto);
        return ResponseEntity.created(URI.create("/create-employee-login/" + user.getId())).body(user);
    }
}
