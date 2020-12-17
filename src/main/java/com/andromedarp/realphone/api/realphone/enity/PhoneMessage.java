package com.andromedarp.realphone.api.realphone.enity;

import lombok.Data;

import javax.persistence.*;

@Entity
@Table(name="phone_messages")
@Data
public class PhoneMessage {

    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    public Long id;
    public String transmitter;
    public String receiver;
    public String message;
    public String time;
    @Column(name="isread")
    public boolean isRead;
    public boolean owner;

}