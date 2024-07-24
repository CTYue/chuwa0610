package com.postsql.backendapi.Mapper;

import com.postsql.backendapi.DTO.UserDTO;
import com.postsql.backendapi.Model.User;
import org.springframework.stereotype.Component;

@Component
public class UserMapper {
    public UserDTO UserToUserDTO(User user) {
        UserDTO dto = new UserDTO();
        dto.setId(user.getId());
        dto.setName(user.getName());
        dto.setEmail(user.getEmail());
        dto.setRole(user.getRole());
        dto.setAddress(user.getAddress());
        return dto;
    }
    public User UserDTOToUser(UserDTO dto) {
        return new User(dto.getId(),dto.getName(),dto.getEmail(),dto.getRole(),dto.getAddress());
    }


}
