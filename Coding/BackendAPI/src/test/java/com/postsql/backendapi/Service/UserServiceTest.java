package com.postsql.backendapi.Service;


import com.postsql.backendapi.Mapper.UserMapper;
import com.postsql.backendapi.Model.User;
import com.postsql.backendapi.DTO.UserDTO;
import com.postsql.backendapi.Repository.UserRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import static org.mockito.Mockito.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

public class UserServiceTest {

    @Mock
    private UserRepository userRepository;

    @Mock
    private UserMapper userMapper;

    @InjectMocks
    private UserService userService;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);  // Ensure mocks are initialized
    }

    @Test
    void getAllUserTest(){
        String userId = "123";
        User user = new User("123", "Aiiken", "Aiiken@example.com", "user", "789 Pine St");
        UserDTO userDTO = new UserDTO("123", "Aiiken", "Aiiken@example.com", "user", "789 Pine St");

        when(userRepository.findAll()).thenReturn(Arrays.asList(user));
        when(userMapper.UserToUserDTO(user)).thenReturn(userDTO);

        List<UserDTO> result = userService.getAllUser();
        assertNotNull(result);
        assertEquals(Arrays.asList(userDTO), result);

        verify(userRepository, times(1)).findAll();
        verify(userMapper, times(1)).UserToUserDTO(user);

    }

    @Test
    void findByIdTest(){
        String userId = "123";
        UserDTO userDTO = new UserDTO("123", "Aiiken", "Aiiken@example.com", "user", "789 Pine St");
        User user = new User("123", "Aiiken", "Aiiken@example.com", "user", "789 Pine St");

        when(userRepository.findById(userId)).thenReturn(Optional.of(user));
        when(userMapper.UserToUserDTO(user)).thenReturn(userDTO);


        UserDTO result = userService.findById(userId);
        assertEquals(userDTO, result);

        verify(userRepository, times(1)).findById(userId);
        verify(userMapper, times(1)).UserToUserDTO(user);

    }

    @Test
    void addUserTest(){
        UserDTO userDTO = new UserDTO("123", "Aiiken", "Aiiken@example.com", "user", "789 Pine St");
        User user = new User("123", "Aiiken", "Aiiken@example.com", "user", "789 Pine St");


        when(userMapper.UserDTOToUser(userDTO)).thenReturn(user);
        when(userRepository.save(user)).thenReturn(user);
        when(userMapper.UserToUserDTO(user)).thenReturn(userDTO);

        UserDTO result = userService.addUser(userDTO);
        assertEquals(userDTO, result);

        verify(userRepository, times(1)).save(user);
        verify(userMapper,times(1)).UserToUserDTO(user);
        verify(userMapper,times(1)).UserDTOToUser(userDTO);

    }

    @Test
    void deleteUser(){
        String Id = "123";
        UserDTO userDTO = new UserDTO("123", "Aiiken", "Aiiken@example.com", "user", "789 Pine St");
        User user = new User("123", "Aiiken", "Aiiken@example.com", "user", "789 Pine St");

        userService.deleteUser(Id);
        verify(userRepository, times(1)).deleteById(Id);
    }





}
