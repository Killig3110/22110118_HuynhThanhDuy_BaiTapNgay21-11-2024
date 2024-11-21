package com.ktragk.demospringsecurity.restcontroller;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.http.ResponseEntity;
import com.ktragk.demospringsecurity.entities.Customer;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/customer")
@EnableMethodSecurity // Bật tính năng bảo mật ở mức phương thức
public class CustomersController {

    // Dữ liệu mẫu cho danh sách khách hàng
    final private List<Customer> customers = List.of(
            Customer.builder().id("001").name("Huynh Thanh Duy").email("thanhdiute@gmail.com").build(),
            Customer.builder().id("002").name("Thanh Duy").email("thanhdi@gmail.com").build()
    );

    // Endpoint không yêu cầu phân quyền
    @GetMapping("/hello")
    public ResponseEntity<String> hello() {
        return ResponseEntity.ok("Hello is Guest");
    }

    // Endpoint yêu cầu quyền ROLE_ADMIN để truy cập
    @GetMapping("/all")
    @PreAuthorize("hasAuthority('ROLE_ADMIN')")
    public ResponseEntity<List<Customer>> getCustomerList() {
        List<Customer> list = this.customers;
        return ResponseEntity.ok(list);
    }

    // Endpoint yêu cầu quyền ROLE_USER để truy cập
    @GetMapping("/{id}")
    @PreAuthorize("hasAuthority('ROLE_USER')")
    public ResponseEntity<Customer> getCustomerById(@PathVariable("id") String id) {
        List<Customer> filteredCustomers = this.customers.stream()
                .filter(customer -> customer.getId().equals(id))
                .collect(Collectors.toList());
        return ResponseEntity.ok(filteredCustomers.get(0));
    }
}

