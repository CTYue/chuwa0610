package com.jackpang.xhs.controller;


import com.jackpang.xhs.dao.security.RoleRepository;
import com.jackpang.xhs.dao.security.UserRepository;
import com.jackpang.xhs.entity.security.Role;
import com.jackpang.xhs.entity.security.User;
import com.jackpang.xhs.payload.security.JWTAuthResponse;
import com.jackpang.xhs.payload.security.LoginDto;
import com.jackpang.xhs.payload.security.SignUpDto;
import com.jackpang.xhs.security.JwtTokenProvider;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collections;

/**
 * @author b1go
 * @date 6/26/22 5:03 PM
 */
@RestController
@RequestMapping("/api/v1/auth/jwt")
@RequiredArgsConstructor
public class AuthJWTController {

    private final AuthenticationManager authenticationManager;

    private final UserRepository userRepository;

    private final RoleRepository roleRepository;

    private final PasswordEncoder passwordEncoder;

    private final JwtTokenProvider tokenProvider;

    private static final Logger logger = LoggerFactory.getLogger(AuthJWTController.class);

    @PostMapping("/signin")
    public ResponseEntity<JWTAuthResponse> authenticateUser(@RequestBody LoginDto loginDto) {
        logger.info("{} is trying to sign in our application", loginDto.getAccountOrEmail());

        Authentication authentication = authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(
                loginDto.getAccountOrEmail(), loginDto.getPassword()
        ));

        SecurityContextHolder.getContext().setAuthentication(authentication);

        // get token from tokenProvider
        String token = tokenProvider.generateToken(authentication);
        JWTAuthResponse jwtAuthResponse = new JWTAuthResponse(token);
        jwtAuthResponse.setTokenType("JWT");

        logger.info("{} sign in successfully", loginDto.getAccountOrEmail());
        return ResponseEntity.ok(jwtAuthResponse);
    }

    @PostMapping("/signup")
    public ResponseEntity<?> registerUser(@RequestBody SignUpDto signUpDto) {
        logger.info("New User is trying to sign up our application");

        // check if username is in a DB
        if (userRepository.existsByAccount(signUpDto.getAccount())) {
            return new ResponseEntity<>("Username is already taken!", HttpStatus.BAD_REQUEST);
        }

        // check if email exists in DB
        if (userRepository.existsByEmail(signUpDto.getEmail())) {
            return new ResponseEntity<>("Email is already taken!", HttpStatus.BAD_REQUEST);
        }

        // create user object
        User user = new User();
        user.setName(signUpDto.getName());
        user.setAccount(signUpDto.getAccount());
        user.setEmail(signUpDto.getEmail());
        user.setPassword(passwordEncoder.encode(signUpDto.getPassword()));

        Role roles;
        if (signUpDto.getAccount().contains("account")) {
            roles = roleRepository.findByName("ROLE_ADMIN").get();
        } else {
            roles = roleRepository.findByName("ROLE_USER").get();
        }

        user.setRoles(Collections.singleton(roles));
        userRepository.save(user);

        logger.info("User registered successfully");
        return new ResponseEntity<>("User registered successfully", HttpStatus.CREATED);
    }
}
