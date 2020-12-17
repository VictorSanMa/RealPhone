package com.andromedarp.realphone.api.realphone.enity;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="phone_users_contacts")
@Data
public class PhoneUserContact {

    @Id
    private int id;
    private String identifier;
    private String number;
    private String display;

}
