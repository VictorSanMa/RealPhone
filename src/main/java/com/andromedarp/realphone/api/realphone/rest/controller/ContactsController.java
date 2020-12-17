package com.andromedarp.realphone.api.realphone.rest.controller;

import com.andromedarp.realphone.api.realphone.enity.PhoneUserContact;
import com.andromedarp.realphone.api.realphone.service.PhoneUserContactService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@Slf4j
@RequestMapping("contacts")
public class ContactsController {

    @Autowired
    private PhoneUserContactService phoneUserContactService;

    @GetMapping("/{id}")
    public List<PhoneUserContact> getUserContacts(@PathVariable String id) {
        log.info("Getting contacts of identifier: {}", id);
        return phoneUserContactService.getContacts(id);
    }

}
