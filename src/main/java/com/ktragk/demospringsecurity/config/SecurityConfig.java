package com.ktragk.demospringsecurity.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class SecurityConfig {

    @Bean
    // Cấu hình UserDetailsService với hai user trong bộ nhớ
    public UserDetailsService userDetailsService(PasswordEncoder encoder) {
        UserDetails admin = User.withUsername("admin")
                .password(encoder.encode("admin"))
                .roles("ADMIN") // Gán quyền ADMIN
                .build();

        UserDetails user = User.withUsername("user")
                .password(encoder.encode("123"))
                .roles("USER") // Gán quyền USER
                .build();

        // Lưu trữ hai user vào InMemoryUserDetailsManager
        return new InMemoryUserDetailsManager(admin, user);
    }

    @Bean
    // Mã hóa mật khẩu sử dụng BCrypt
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        return http
                .csrf(csrf -> csrf.disable()) // Vô hiệu hóa CSRF để đơn giản hóa testing
                .authorizeHttpRequests(auth -> auth
                        .requestMatchers("/").permitAll() // Cho phép truy cập vào endpoint "/" không cần xác thực
                        .requestMatchers("/customer/**").authenticated() // Yêu cầu xác thực cho các endpoint "/customer/**"
                )
                .formLogin(Customizer.withDefaults()) // Kích hoạt form đăng nhập mặc định của Spring Security
                .build();
    }
}

