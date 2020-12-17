package com.andromedarp.realphone.api.realphone.repository;

import com.andromedarp.realphone.api.realphone.enity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, String> {
}
