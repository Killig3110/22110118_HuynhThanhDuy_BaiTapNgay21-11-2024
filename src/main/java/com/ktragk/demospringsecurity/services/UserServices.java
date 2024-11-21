package com.ktragk.demospringsecurity.services;

import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import com.ktragk.demospringsecurity.entities.UserInfo;
import com.ktragk.demospringsecurity.repositories.UserInfoRepository;
import org.springframework.security.crypto.password.PasswordEncoder;

@Service
public class UserServices {
    private final UserInfoRepository repository;
    private final PasswordEncoder passwordEncoder;

    public UserServices(UserInfoRepository repository, PasswordEncoder passwordEncoder) {
        this.repository = repository;
        this.passwordEncoder = passwordEncoder;
    }

    public String addUser(UserInfo userInfo) {
        // Mã hóa mật khẩu trước khi lưu
        userInfo.setPassword(passwordEncoder.encode(userInfo.getPassword()));
        // Lưu thông tin người dùng vào cơ sở dữ liệu
        repository.save(userInfo);
        return "Thêm user thành công!";
    }
}

