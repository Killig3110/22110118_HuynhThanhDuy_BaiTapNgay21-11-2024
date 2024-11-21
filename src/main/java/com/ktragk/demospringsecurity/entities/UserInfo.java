package com.ktragk.demospringsecurity.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Builder
@Entity
@Table(name = "customers") // Tên bảng trong cơ sở dữ liệu
public class UserInfo {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) // Auto increment
    @Column(name = "id") // Tên cột trong bảng
    private int id; // Khóa chính, ánh xạ với cột "id" trong bảng

    @Column(name = "name") // Tên cột trong bảng
    private String name; // Ánh xạ với cột "name" trong bảng

    @Column(name = "phone_number") // Tên cột trong bảng
    private String phoneNumber; // Ánh xạ với cột "phone_number" trong bảng

    @Column(name = "password") // Tên cột trong bảng
    private String password; // Ánh xạ với cột "password" trong bảng

    @Column(name = "email") // Tên cột trong bảng
    private String email; // Ánh xạ với cột "email" trong bảng

    @Column(name = "roles") // Tên cột trong bảng
    private String roles; // Ánh xạ với cột "role" trong bảng
}

