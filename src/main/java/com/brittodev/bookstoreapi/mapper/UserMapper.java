package com.brittodev.bookstoreapi.mapper;

import com.brittodev.bookstoreapi.dto.requestDto.UserRequest;
import com.brittodev.bookstoreapi.dto.responseDto.UserResponse;
import com.brittodev.bookstoreapi.entity.User;

public class UserMapper {

    public static User toEntity(UserRequest request) {
        return User.builder()
                .userName(request.userName())
                .password(request.password())
                .role(request.role())
                .build();
    }

    public static UserResponse toResponse(User user) {
        return new UserResponse(
                user.getId(),
                user.getUserName(),
                user.getRole()
        );
    }


}
