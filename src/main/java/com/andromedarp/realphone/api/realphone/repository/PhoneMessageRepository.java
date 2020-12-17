package com.andromedarp.realphone.api.realphone.repository;

import com.andromedarp.realphone.api.realphone.enity.PhoneMessage;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PhoneMessageRepository extends JpaRepository<PhoneMessage, Long> {

    @Query("SELECT p FROM PhoneMessage p WHERE transmitter = :phone_number or receiver = :phone_number")
    public List<PhoneMessage> findAllByPhoneNumber(@Param("phone_number") String phoneNumber);

    @Query("SELECT p FROM PhoneMessage p LEFT JOIN User u ON (p.transmitter = u.phoneNumber OR p.receiver = u.phoneNumber) WHERE u.identifier = :id ORDER BY p.time DESC")
    public List<PhoneMessage> findAllByUser(@Param("id") String id);

    @Query("SELECT p FROM PhoneMessage p LEFT JOIN User u ON p.transmitter = :number AND p.receiver = u.phoneNumber WHERE u.identifier = :id ORDER BY p.time DESC")
    public List<PhoneMessage> findAllWithNumber(@Param("id") String id, @Param("number") String number);

}
