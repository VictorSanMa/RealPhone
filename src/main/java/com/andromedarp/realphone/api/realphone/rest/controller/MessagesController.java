package com.andromedarp.realphone.api.realphone.rest.controller;

import com.andromedarp.realphone.api.realphone.domain.SendMessage;
import com.andromedarp.realphone.api.realphone.enity.PhoneMessage;
import com.andromedarp.realphone.api.realphone.service.MessageService;
import com.jcraft.jsch.JSchException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.util.List;

@RestController
@Slf4j
@RequestMapping("messages")
public class MessagesController {

    @Autowired
    private MessageService messageService;

    @GetMapping("/phone/{phoneNumber}")
    public List<PhoneMessage> getPhoneNumberMessages(@PathVariable String phoneNumber) {
        log.info("Getting user messages of phone number: {}", phoneNumber);
        return messageService.getMessages(phoneNumber);
    }

    @GetMapping("/{id}")
    public List<PhoneMessage> getUserMessages(@PathVariable String id) {
        log.info("Getting user messages of identifier: {}", id);
        return messageService.getUserMessages(id);
    }

    @GetMapping("/{id}/{number}")
    public List<PhoneMessage> getUserMessages(@PathVariable String id, @PathVariable String number) {
        log.info("Getting user messages of identifier: {} and number: {}", id, number);
        return messageService.getMessagesWithNumber(id, number);
    }

    @PostMapping
    public void sendMessage(@RequestBody SendMessage sendMessage) throws IllegalAccessException, JSchException, IOException {
        messageService.sendMessage(sendMessage);
    }

}
