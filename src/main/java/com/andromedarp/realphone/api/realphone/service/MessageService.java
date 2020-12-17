package com.andromedarp.realphone.api.realphone.service;

import com.andromedarp.realphone.api.realphone.domain.SendMessage;
import com.andromedarp.realphone.api.realphone.enity.PhoneMessage;
import com.andromedarp.realphone.api.realphone.repository.PhoneMessageRepository;
import com.jcraft.jsch.JSchException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.List;

@Service
@Slf4j
public class MessageService {

    @Autowired
    public PhoneMessageRepository repository;

    @Autowired
    private SSHService sshService;

    @Value("${ssh.send-command}")
    public String sendCommand;

    @Value("${ssh.send-command}")
    public String sendMsgCommand;

    public List<PhoneMessage> getMessages(String phoneNumber) {
        return repository.findAllByPhoneNumber(phoneNumber);
    }

    public List<PhoneMessage> getUserMessages(String id) {
        return repository.findAllByUser(id);
    }

    public List<PhoneMessage> getMessagesWithNumber(String id, String number) {
        return repository.findAllWithNumber(id, number);
    }

    public void sendMessage(SendMessage sendMessage) throws IllegalAccessException, JSchException, IOException {
        log.info("Sending message: {}", sendMessage);
        String msgCommand = String.format(sendMsgCommand, sendMessage.getSender(), sendMessage.getReceiver(), sendMessage.getMessage());
        String entireCommand = constructCommand(msgCommand);
        sshService.executeCommand(entireCommand);
    }

    public String constructCommand(String command) {
        return String.format(sendCommand, command);
    }

}
