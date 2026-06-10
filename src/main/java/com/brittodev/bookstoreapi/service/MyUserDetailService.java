package com.brittodev.bookstoreapi.service;

import com.brittodev.bookstoreapi.repository.UserRepository;
import com.brittodev.bookstoreapi.security.UserPrinciple;
import org.jspecify.annotations.NonNull;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;


@Service
public class MyUserDetailService implements UserDetailsService {

    UserRepository userRepository;

    MyUserDetailService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override @NonNull
    public UserDetails loadUserByUsername(@NonNull String username) throws UsernameNotFoundException {
        return new UserPrinciple(userRepository.findUserByUserName(username));
    }

}
