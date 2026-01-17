package com.spring.authservice.service;

import com.spring.authservice.entities.UserInfo;
import com.spring.authservice.models.UserInfoDto;
import com.spring.authservice.repository.UserRepository;
import com.spring.authservice.util.ValidationUtil;
import lombok.AllArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Objects;
import java.util.Optional;
import java.util.UUID;

@AllArgsConstructor
@Service
public class UserDetailsServiceImpl implements UserDetailsService {

    private final UserRepository userRepository;

    private final PasswordEncoder passwordEncoder;

    private static final Logger log = LoggerFactory.getLogger(UserDetailsServiceImpl.class);

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

        log.debug("Entering in loadUserByUsername Method...");
        UserInfo user = userRepository.findByUsername(username)
                .orElseThrow(() ->
                        new UsernameNotFoundException("User not found: " + username));

        log.info("User Authenticated Successfully..!!!");
        return new CustomUserDetails(user);
    }

    public Optional<UserInfo> checkIfUserExists(String username){
        return userRepository.findByUsername(username);
    }

    public Boolean signUpUser(UserInfoDto userInfoDto){
        ValidationUtil.validateUserAttributes(userInfoDto);
        userInfoDto.setPassword(passwordEncoder.encode(userInfoDto.getPassword()));
        if (checkIfUserExists(userInfoDto.getUsername()).isPresent()) {
            return false;
        }

        UserInfo userInfo = new UserInfo();
        userInfo.setUsername(userInfoDto.getUsername());
        userInfo.setPassword(userInfoDto.getPassword());
        userInfo.setRoles(new HashSet<>());

        userRepository.save(userInfo);
        log.info("User Registered Successfully..!!!");
        // pushEventToQueue
        return true;
    }
}

