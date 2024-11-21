package com.ktragk.demospringsecurity.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import com.ktragk.demospringsecurity.entities.UserInfo;
import com.ktragk.demospringsecurity.repositories.UserInfoRepository;
import org.springframework.stereotype.Service;

import java.util.Optional;
@Service
public class UserInfoService implements UserDetailsService {

    @Autowired
    UserInfoRepository repository;

    public UserInfoService(UserInfoRepository userInfoRepository) {
        this.repository = userInfoRepository;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Optional<UserInfo> userInfo = repository.findByName(username);
        return userInfo.map(UserInfoUserDetails::new)
                .orElseThrow(() -> new UsernameNotFoundException("User not found: " + username));
    }
}