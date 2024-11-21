package com.ktragk.demospringsecurity.restcontroller;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import com.ktragk.demospringsecurity.entities.UserInfo;
import com.ktragk.demospringsecurity.services.UserServices;

@RestController
@RequestMapping("/user")
@RequiredArgsConstructor
public class UserController {

    private final UserServices userService;

    @PostMapping("/new")
    public String addUser(@RequestBody UserInfo userInfo) {
        return userService.addUser(userInfo);
    }
}
