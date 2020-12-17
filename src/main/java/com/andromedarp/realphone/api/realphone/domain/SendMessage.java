package com.andromedarp.realphone.api.realphone.domain;

import lombok.Data;

@Data
public class SendMessage {
    private String sender;
    private String receiver;
    private String message;
}
