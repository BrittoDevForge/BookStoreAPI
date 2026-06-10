package com.brittodev.bookstoreapi.service;


import com.brittodev.bookstoreapi.dto.requestDto.UserRequest;
import com.brittodev.bookstoreapi.dto.responseDto.UserResponse;
import com.brittodev.bookstoreapi.entity.User;
import com.brittodev.bookstoreapi.mapper.UserMapper;
import com.brittodev.bookstoreapi.repository.UserRepository;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    UserRepository userRepository;
    BCryptPasswordEncoder encoder;
    AuthenticationManager authenticationManager;
    JwtService jwtService;

    UserService(UserRepository userRepository,
                BCryptPasswordEncoder encoder,
                AuthenticationManager authenticationManager,
                JwtService jwtService) {
        this.userRepository = userRepository;
        this.encoder = encoder;
        this.authenticationManager = authenticationManager;
        this.jwtService = jwtService;
    }

    public UserResponse register(UserRequest request) {
        User user = UserMapper.toEntity(request);
        user.setPassword(encoder.encode(user.getPassword()));
        return UserMapper.toResponse(userRepository.save(user));
    }

    public String login(UserRequest userRequest) {
        Authentication authentication = authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(userRequest.userName(),userRequest.password())
        );

        if(authentication.isAuthenticated()) {
            return jwtService.generateToken(userRequest.userName());
        }

        return "Invalid UserName/Password";
    }


}
