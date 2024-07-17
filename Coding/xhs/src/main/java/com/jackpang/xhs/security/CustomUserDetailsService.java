package com.jackpang.xhs.security;


import com.jackpang.xhs.dao.security.UserRepository;
import com.jackpang.xhs.entity.security.Role;
import com.jackpang.xhs.entity.security.User;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.Set;
import java.util.stream.Collectors;

/**
 * @author b1go
 * @date 6/26/22 4:06 PM
 * 旧版的
 */
@Service
@RequiredArgsConstructor
public class CustomUserDetailsService implements UserDetailsService {

    private final UserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String accountOrEmail) throws UsernameNotFoundException {
        User user = userRepository.findByAccountOrEmail(accountOrEmail, accountOrEmail)
                .orElseThrow(() ->
                        new UsernameNotFoundException("User not found with account or email" + accountOrEmail));
        return new org.springframework.security.core.userdetails.User(
                user.getEmail(),
                user.getPassword(),
                mapRolesToAuthorities(user.getRoles()));
    }

    private Collection<? extends GrantedAuthority> mapRolesToAuthorities(Set<Role> roles) {
        return roles.stream().map(role -> new SimpleGrantedAuthority(role.getName())).collect(Collectors.toList());
    }
}
