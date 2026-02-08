package com.spring.authservice.models;

import com.fasterxml.jackson.databind.PropertyNamingStrategy;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import com.spring.authservice.entities.UserInfo;
import lombok.*;

@JsonNaming(PropertyNamingStrategy.SnakeCaseStrategy.class)
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class UserInfoDto {

    private String userName;

    private String firstName;

    private String userId;

    private String lastName;
    private String password;

    private long phoneNumber;

    private String email;
}
