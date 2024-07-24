package com.postsql.backendapi.Controller;

import com.postsql.backendapi.DTO.UserDTO;
import com.postsql.backendapi.Model.User;
import com.postsql.backendapi.Service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/user")
public class UserController {

    @Autowired
    private UserService userService;




    @GetMapping()
    public List<UserDTO> getAllUsers() {
        return userService.getAllUser();
    }

    @PostMapping()
    public UserDTO addUser(@RequestBody UserDTO userDTO) {
        return userService.addUser(userDTO);
    }

    @GetMapping("/{id}")
    public UserDTO getUser(@PathVariable String id) {
        return userService.findById(id);
    }


    @DeleteMapping("/{id}")
    public void deleteUser(@PathVariable String id) {
        userService.deleteUser(id);
    }

}
