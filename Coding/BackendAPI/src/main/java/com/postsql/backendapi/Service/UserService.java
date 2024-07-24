package com.postsql.backendapi.Service;

import com.postsql.backendapi.DTO.UserDTO;
import com.postsql.backendapi.Mapper.UserMapper;
import com.postsql.backendapi.Repository.UserRepository;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.postsql.backendapi.Model.User;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class UserService {

    @Autowired
    UserRepository userRepository;

    @Autowired
    UserMapper userMapper;


    public List<UserDTO> getAllUser() {
        return userRepository.findAll().stream().map(userMapper::UserToUserDTO).collect(Collectors.toList());
    }

    public UserDTO findById(String Id) {
        return userRepository.findById(Id).map(userMapper::UserToUserDTO).orElse(null);
    }

    public UserDTO addUser(UserDTO userDTO) {
        return userMapper.UserToUserDTO(userRepository.save(userMapper.UserDTOToUser(userDTO)));
    }

    public void deleteUser(String Id) {
        userRepository.deleteById(Id);
    }

}
