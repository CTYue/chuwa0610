package com.postsql.backendapi.Controller;


import com.fasterxml.jackson.databind.ObjectMapper;
import com.postsql.backendapi.DTO.UserDTO;
import com.postsql.backendapi.Model.User;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.*;
import com.fasterxml.jackson.core.type.TypeReference;
import static org.assertj.core.api.Assertions.assertThat;

import java.util.ArrayList;
import java.util.List;

import java.util.stream.Collectors;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class UserControllerTest {

    @Autowired
    private TestRestTemplate restTemplate;

    @Autowired
    private ObjectMapper objectMapper;


    @Test
    void getAllUsersTest() throws Exception {

        ResponseEntity<List> response = restTemplate.getForEntity("/api/user", List.class);

        assertThat(response.getStatusCode()).isEqualTo(HttpStatus.OK);
        assertThat(response.getBody()).isNotNull();
        assertThat(response.getBody()).isNotEmpty();

    }

    @Test
    void getUserTest() throws Exception {
        UserDTO userDTO = new UserDTO("123", "Aiiken", "Aiiken@example.com", "user", "789 Pine St");

        ResponseEntity<UserDTO> response = restTemplate.postForEntity("/api/user", userDTO, UserDTO.class);
        assertThat(response.getStatusCode()).isEqualTo(HttpStatus.OK);
        assertThat(response.getBody()).isNotNull();
        assertThat(response.getBody().getId()).isEqualTo(userDTO.getId());
        assertThat(response.getBody().getName()).isEqualTo(userDTO.getName());
        assertThat(response.getBody().getEmail()).isEqualTo(userDTO.getEmail());
        assertThat(response.getBody().getRole()).isEqualTo(userDTO.getRole());


    }

    @Test
    void deleteUserTest() throws Exception {
        UserDTO userDTO = new UserDTO("123", "Aiiken", "Aiiken@example.com", "user", "789 Pine St");

        ResponseEntity<UserDTO> response = restTemplate.postForEntity("/api/user", userDTO, UserDTO.class);
        assertThat(response.getStatusCode()).isEqualTo(HttpStatus.OK);
        assertThat(response.getBody()).isNotNull();
        assertThat(response.getBody().getId()).isEqualTo(userDTO.getId());
        assertThat(response.getBody().getName()).isEqualTo(userDTO.getName());
        assertThat(response.getBody().getEmail()).isEqualTo(userDTO.getEmail());
        assertThat(response.getBody().getRole()).isEqualTo(userDTO.getRole());
        restTemplate.delete("/api/user/" + userDTO.getId());
        ResponseEntity<String> getAllUserResponse = restTemplate.getForEntity("/api/user", String.class);

        List<UserDTO> users = objectMapper.readValue(getAllUserResponse.getBody(),
                new TypeReference<List<UserDTO>>() {});

        assertThat(users).doesNotContain(userDTO);
    }




}
