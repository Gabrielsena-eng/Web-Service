package com.GabrielsSena.Web.Service.repository;

import com.GabrielsSena.Web.Service.Entities.User;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Integer> {

    Optional<User> findByEmail(String email);
    Optional<User> findByPhone(String phone);

    @Transactional
    void deleteByEmail(String email);


}
