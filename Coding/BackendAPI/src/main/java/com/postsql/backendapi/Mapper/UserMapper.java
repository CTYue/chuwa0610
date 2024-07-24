package com.postsql.backendapi.Mapper;

import com.postsql.backendapi.DTO.UserDTO;
import com.postsql.backendapi.Model.User;
import org.springframework.stereotype.Component;

@Component
public class UserMapper {
    public UserDTO UserToUserDTO(User user) {
        return new UserDTO(user.getId(),user.getName(),user.getEmail(),user.getRole(),user.getAddress());
    }
    public User UserDTOToUser(UserDTO dto) {
        return new User(dto.getId(),dto.getName(),dto.getEmail(),dto.getRole(),dto.getAddress());
    }


}
