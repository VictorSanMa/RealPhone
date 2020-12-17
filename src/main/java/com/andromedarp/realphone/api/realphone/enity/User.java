package com.andromedarp.realphone.api.realphone.enity;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="users")
@Data
public class User {

    @Id
    public String identifier;
    public String steamHex;
    public String firstName;
    public String lastName;
    public String phoneNumber;

}
