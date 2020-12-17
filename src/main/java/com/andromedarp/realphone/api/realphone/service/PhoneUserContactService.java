package com.andromedarp.realphone.api.realphone.service;

import com.andromedarp.realphone.api.realphone.enity.PhoneUserContact;
import com.andromedarp.realphone.api.realphone.repository.PhoneUserContactRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PhoneUserContactService {

    @Autowired
    private PhoneUserContactRepository repository;

    public List<PhoneUserContact> getContacts(String id) {
        return repository.findAllByIdentifier(id);
    }

    public List<PhoneUserContact> getAllContactsById(String id) {
        return repository.getAllContactsById(id);
    }

}
