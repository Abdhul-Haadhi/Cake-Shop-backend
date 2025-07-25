package com.bit.backend.services;

import com.bit.backend.dtos.*;

import java.util.List;

public interface UserServiceI {
    UserDto login(CredentialsDto credentialsDto) throws Exception;
    UserDto register(SignUpDto signUpDto) throws Exception;
    List<Integer> getAuthIds(long userId);
    SystemPrivilegeListDto getSystemPrivileges();
    List<Integer> setSystemPrivileges(SystemPrivilegeListDto systemPrivilegeListDto);
    UserDto getUserData(String role, Long id);
    UserDto updateLoginDetails(Long id, SignUpDto signUpDto);
    UserDto mainRegister(SignUpDto signUpDto) throws Exception;
}
