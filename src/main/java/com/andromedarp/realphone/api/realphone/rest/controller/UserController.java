package com.andromedarp.realphone.api.realphone.rest.controller;

import com.andromedarp.realphone.api.realphone.enity.User;
import com.andromedarp.realphone.api.realphone.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Slf4j
@RequestMapping("user")
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping("/{id}")
    public User getUser(@PathVariable String id) {
        log.info("Getting user of id: {}", id);
        return userService.getUser(id);
    }

}
