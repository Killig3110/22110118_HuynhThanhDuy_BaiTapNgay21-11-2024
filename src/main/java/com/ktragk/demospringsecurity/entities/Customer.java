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
public class Customer {

    @Id
    @Column(name = "id") // Tên cột trong bảng
    private String id; // Khóa chính, ánh xạ với cột "id" trong bảng

    @Column(name = "name") // Tên cột trong bảng
    private String name; // Ánh xạ với cột "name" trong bảng

    @Column(name = "phone_number") // Tên cột trong bảng
    private String phoneNumber; // Ánh xạ với cột "phone_number" trong bảng

    @Column(name = "email") // Tên cột trong bảng
    private String email; // Ánh xạ với cột "email" trong bảng
}

