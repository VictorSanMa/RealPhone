package com.andromedarp.realphone.api.realphone.repository;

import com.andromedarp.realphone.api.realphone.enity.PhoneUserContact;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PhoneUserContactRepository extends JpaRepository<PhoneUserContact, Long> {

    public List<PhoneUserContact> findAllByIdentifier(String identifier);

    @Query("SELECT puc " +
            "FROM PhoneUserContact puc " +
            "LEFT JOIN PhoneMessage pm ON puc.number = pm.transmitter " +
            "where identifier = ?1 " +
            "group by puc.number " +
            "order by pm.time desc")
    public List<PhoneUserContact> getAllContactsById(String identifier);

}
