package com.andromedarp.realphone.api.realphone.service;

import com.andromedarp.realphone.api.realphone.enity.User;
import com.andromedarp.realphone.api.realphone.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    @Autowired
    public UserRepository repository;

    public User getUser(String id) {
        return repository.findById(id).get();
    }

}
