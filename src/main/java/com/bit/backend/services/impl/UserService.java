package com.bit.backend.services.impl;

import com.bit.backend.config.RSADecryptor;
import com.bit.backend.dtos.*;
import com.bit.backend.entities.User;
import com.bit.backend.exceptions.AppException;
import com.bit.backend.mappers.UserMapper;
import com.bit.backend.repositories.UserRepository;
import com.bit.backend.services.UserServiceI;
import jakarta.persistence.Tuple;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.nio.CharBuffer;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class UserService implements UserServiceI {

    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;
    private final UserMapper userMapper;

    private static final Logger logger = LoggerFactory.getLogger(UserService.class);

    public UserService(UserRepository userRepository, PasswordEncoder passwordEncoder, UserMapper userMapper) {
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
        this.userMapper = userMapper;
    }

    @Override
    public UserDto login(CredentialsDto credentialsDto) throws Exception {
        logger.debug("Entering in login Method...");
        User user = userRepository.findByLogin(credentialsDto.login()).orElseThrow(() -> new AppException("Unknown User", HttpStatus.NOT_FOUND));
        String decryptedPassword = RSADecryptor.decrypt(new String(credentialsDto.password()));

        if (passwordEncoder.matches(CharBuffer.wrap(decryptedPassword.toCharArray()), user.getPassword())) {
            return userMapper.toUserDto(user);
        }
        throw new AppException("Invalid password", HttpStatus.BAD_REQUEST);
    }

    @Override
    public UserDto register(SignUpDto signUpDto) throws Exception {
        Optional<User> oUser = userRepository.findByLogin(signUpDto.login());

        if (oUser.isPresent()) {
            throw new AppException("User Already Exists", HttpStatus.BAD_REQUEST);
        }
        User user = userMapper.signUpToUser(signUpDto);

        String decryptedPassword = RSADecryptor.decrypt(new String(signUpDto.password()));

        user.setPassword(passwordEncoder.encode(CharBuffer.wrap(decryptedPassword.toCharArray())));
        User savedUser = userRepository.save(user);
        return userMapper.toUserDto(savedUser);
    }

    @Override
    public List<Integer> getAuthIds(long userId) {
        Optional<List<Integer>> optionalAuthIdLists = userRepository.findAuthIdsByUserId(userId);
        List<Integer> authIdLists = optionalAuthIdLists.get();

        return authIdLists;
    }

    @Override
    public SystemPrivilegeListDto getSystemPrivileges() {
        List<Tuple> tupleAvailableSystemPrivilegeLists = userRepository.getAvailableSystemPrivileges();
        List<Tuple> tupleAssignedSystemPrivilegeLists = userRepository.getAssignedSystemPrivileges();
        SystemPrivilegeListDto systemPrivilegeListDto = new SystemPrivilegeListDto();

        List<SystemPrivilegeDto> availableSystemPrivilegeLists = tupleAvailableSystemPrivilegeLists.stream().map(t -> {
            SystemPrivilegeDto systemPrivilegeDto = new SystemPrivilegeDto();
            systemPrivilegeDto.setId(t.get(0, Integer.class));
            systemPrivilegeDto.setDescription(t.get(1, String.class));
            return systemPrivilegeDto;
        }).collect(Collectors.toList());

        List<SystemPrivilegeDto> assignSystemPrivilegeLists = tupleAssignedSystemPrivilegeLists.stream().map(t -> {
            SystemPrivilegeDto systemPrivilegeDto = new SystemPrivilegeDto();
            systemPrivilegeDto.setId(t.get(0, Integer.class));
            systemPrivilegeDto.setDescription(t.get(1, String.class));
            return systemPrivilegeDto;
        }).collect(Collectors.toList());

        systemPrivilegeListDto.setSourcePrivileges(availableSystemPrivilegeLists);
        systemPrivilegeListDto.setTargetPrivileges(assignSystemPrivilegeLists);

        return systemPrivilegeListDto;
    }

    @Override
    public List<Integer> setSystemPrivileges(SystemPrivilegeListDto systemPrivilegeListDto) {

        return null;
    }

    @Override
    public UserDto getUserData(String role, Long id) {
        try {
            User user = null;
            if (role.equals("EMPLOYEE")) {
                user = userRepository.findByEmployeeId(id);
            } else {
                user = userRepository.findByCustomerId(id);
            }

            UserDto userDto = userMapper.toUserDto(user);
            return userDto;
        } catch (Exception e) {
            throw new AppException("Error while getting user data", HttpStatus.BAD_REQUEST);
        }
    }

    @Override
    public UserDto updateLoginDetails(Long id, SignUpDto signUpDto) {
        try {
            Optional<User> oUser = userRepository.findById(id);
//            if (signUpDto.role().equals("EMPLOYEE")) {
//                user = userRepository.findByEmployeeId(id);
//            } else {
//                user = userRepository.findByEmployeeId(id);
//            }

            if (!oUser.isPresent()) {
                throw new AppException("Login user not found!", HttpStatus.BAD_REQUEST);
            }

            User user = oUser.get();

            /*check if another user exists with the same user name*/
            List<User> userList = userRepository.checkIfUserNameExistForOtherUsers(signUpDto.login(), user.getId());

            if (userList.size() > 0) {
                throw new AppException("User name already exists! Please try with different user name", HttpStatus.BAD_REQUEST);
            }

            user.setFirstName(signUpDto.firstName());
            user.setLastName(signUpDto.lastName());
            user.setLogin(signUpDto.login());

            if (signUpDto.password().length > 0) {
                String decryptedPassword = RSADecryptor.decrypt(new String(signUpDto.password()));
                if (decryptedPassword != null && !decryptedPassword.equals("")) {
                    if (!passwordEncoder.matches(CharBuffer.wrap(decryptedPassword), user.getPassword())) {
                        user.setPassword(passwordEncoder.encode(CharBuffer.wrap(decryptedPassword)));
                    }
                }
            }

            User savedUser = userRepository.save(user);
            return userMapper.toUserDto(savedUser);

        } catch (Exception e) {
            throw new AppException("Error while updating user data: " + e, HttpStatus.BAD_REQUEST);
        }
    }
}
