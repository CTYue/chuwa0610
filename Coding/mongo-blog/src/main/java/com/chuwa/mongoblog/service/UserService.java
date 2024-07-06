package com.chuwa.mongoblog.service;

import com.chuwa.mongoblog.dto.UserDto;
import org.springframework.stereotype.Service;

import java.util.Optional;

/**
 * @Create 07/2024
 * @Author xiao
 * @Description
 */
@Service
public interface UserService {
	UserDto createUser(UserDto userDto);
	Optional<UserDto> getUserById(String id);
}
