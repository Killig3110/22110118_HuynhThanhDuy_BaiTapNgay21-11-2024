package com.ktragk.demospringsecurity.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.HashSet;
import java.util.Set;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "users")
public class Users {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) // Tự động tăng ID
    @Column(name = "user_id")
    private Long id;

    @Column(name = "username")
    private String username;

    @Column(name = "email", length = 60, columnDefinition = "nvarchar(50) not null")
    private String email;

    @Column(name = "password")
    private String password;

    @Column(name = "name")
    private String name;

    @Column(name = "enabled")
    private boolean enabled;

    @ManyToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinTable(
            name = "users_roles", // Tên bảng liên kết
            joinColumns = @JoinColumn(name = "user_id"), // Khóa chính từ Users
            inverseJoinColumns = @JoinColumn(name = "role_id") // Khóa chính từ Role
    )
    private Set<Role> roles = new HashSet<>();
}

