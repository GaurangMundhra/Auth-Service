package com.spring.authservice.controller;


import com.spring.authservice.entities.RefreshToken;
import com.spring.authservice.models.UserInfoDto;
import com.spring.authservice.response.JwtResponseDto;
import com.spring.authservice.service.JwtService;
import com.spring.authservice.service.RefreshTokenService;
import com.spring.authservice.service.UserDetailsServiceImpl;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@AllArgsConstructor
@RestController
public class AuthController
{

    @Autowired
    private JwtService jwtService;

    @Autowired
    private RefreshTokenService refreshTokenService;

    @Autowired
    private UserDetailsServiceImpl userDetailsService;

    @PostMapping("auth/v1/signup")
    public ResponseEntity<?> signUp(@RequestBody UserInfoDto userInfoDto) {
        Boolean isSignUp = userDetailsService.signUpUser(userInfoDto);

        if (!isSignUp) {
            return ResponseEntity.badRequest().body("Already Exist");
        }

        RefreshToken refreshToken =
                refreshTokenService.createRefreshToken(userInfoDto.getUsername());

        String jwtToken =
                jwtService.GenerateToken(userInfoDto.getUsername());

        return ResponseEntity.ok(
                JwtResponseDto.builder()
                        .accessToken(jwtToken)
                        .token(refreshToken.getToken())
                        .build()
        );
    }


}